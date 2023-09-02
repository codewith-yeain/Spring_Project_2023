/*idea > write.html*/

/*textarea 자동 사이즈 조절*/
function resize(obj) {
    obj.style.height = '1px';
    obj.style.height = (12 + obj.scrollHeight) + 'px';
}

function handleCheckboxChange(checkboxElem) {
    var hiddenInput = document.querySelector('input[name="ideaType"]');

    if (checkboxElem.checked) {
        hiddenInput.value = '프리미엄';
    } else {
        hiddenInput.value = '일반';
    }
}

let sizes = new Array(8).fill(0);
const noImageMessage = document.querySelector("#no-image");

// 이벤트 위임 방식으로 x 버튼 클릭 이벤트 추가
$(document).on("click", ".x", function () {
    const index = $(this).closest('.preview-layout').index();
    const noImageMessage = document.querySelector("#no-image");
    const bigPreviewImgWrapper = document.querySelector("#big-preview-wrap");

    // 작은 미리보기 숨기기
    $(".preview-img-wrapper").eq(index).hide().find('.preview-img').attr('src', '');

    // 큰 미리보기 숨기기
    $(".idea-img-wrapper").eq(index).hide().find('.idea-img').attr('src', '');

    // 해당 이미지를 currentFiles 배열에서 제거
    if (Array.isArray(currentFiles) && currentFiles.length > 0) {
        currentFiles.splice(index, 1);
    }

    // 해당 이미지의 sizes 배열에서의 크기 정보 제거
    sizes[index] = 0;

    if (currentFiles.length === 0) {
        noImageMessage.style.display = "block";
        bigPreviewImgWrapper.style.display = "none";
    } else {
        noImageMessage.style.display = "none";
        bigPreviewImgWrapper.style.display = "block";
    }
});


// 상수 정의
const MAX_IMAGES = 8;
const FILE_PATH_TEMPLATE = `/idea-files/display?fileName=`;

document.getElementById("upload").addEventListener("change", async function(e) {
    const newFiles = Array.from(e.target.files); // 새롭게 선택된 이미지들
    const addedFiles = [];

    // 기존에 없는 새로운 파일만 추가
    newFiles.forEach(file => {
        if (!currentFiles.includes(file)) {
            currentFiles.push(file);
            addedFiles.push(file);
        }
    });

    // 최대 8개의 이미지만 유지
    currentFiles = currentFiles.slice(0, MAX_IMAGES);

    // 로컬 미리보기 업데이트
    await updateLocalPreviews(addedFiles);

    // 서버로 파일 업로드
    const formData = new FormData();
    addedFiles.forEach(file => {
        formData.append("uploadFile", file);
    });

    $.ajax({
        url: "/idea-files/upload",
        type: "post",
        data: formData,
        contentType: false,
        processData: false,
        success: function (uuids) {
            updateServerPreviews(uuids, addedFiles);
        },
        error: function (err) {
            console.error("파일 업로드 중 오류 발생:", err);
            alert("파일 업로드 중 오류가 발생했습니다. 다시 시도해주세요.");
        }
    });
});

async function updateLocalPreviews(addedFiles) {
    const ideaImgWrappers = document.querySelectorAll(".idea-img-wrapper");
    const previewImgWrappers = document.querySelectorAll(".preview-layout");
    const noImageMessage = document.querySelector("#no-image");
    const bigPreviewImgWrapper = document.querySelector("#big-preview-wrap");

    const startIndex = currentFiles.length - addedFiles.length;

    for (let i = 0; i < addedFiles.length; i++) {
        await loadImage(addedFiles[i], startIndex + i, ideaImgWrappers, previewImgWrappers);
    }

    if (currentFiles.length === 0) {
        noImageMessage.style.display = "block";
        bigPreviewImgWrapper.style.display = "none";
    } else {
        noImageMessage.style.display = "none";
        bigPreviewImgWrapper.style.display = "block";
    }

    addedFiles.forEach((file, index) => {
        sizes[index] = file.size;
        console.log(sizes[index]);
    });

}

function loadImage(file, index, ideaImgWrappers, previewImgWrappers) {
    return new Promise((resolve) => {
        const reader = new FileReader();
        reader.readAsDataURL(file);
        reader.onload = function (e) {
            // 큰 미리보기
            ideaImgWrappers[index].style.display = "block";
            ideaImgWrappers[index].querySelector('.idea-img').src = e.target.result;

            // 작은 미리보기
            previewImgWrappers[index].style.display = "block";
            previewImgWrappers[index].querySelector('.preview-img').src = e.target.result;

            resolve();
        }
    });
}

function updateServerPreviews(uuids, addedFiles) {
    const startIndex = currentFiles.length - addedFiles.length;

    for (let i = 0; i < uuids.length; i++) {
        const now = new Date();
        const year = now.getFullYear();
        const month = (now.getMonth() + 1).toString().padStart(2, '0');
        const date = now.getDate().toString().padStart(2, '0');

        const fileName = `${year}/${month}/${date}/t_${uuids[i]}_${addedFiles[i].name}`;

        // 작은 미리보기 업데이트
        const $smallPreview = $(".preview-layout").eq(startIndex + i);
        $smallPreview.find('.preview-img').attr("src", FILE_PATH_TEMPLATE + fileName);
        $smallPreview.show();

        // 큰 미리보기 업데이트
        const $bigPreview = $(".idea-img-wrapper").eq(startIndex + i);
        $bigPreview.find('.idea-img').attr("src", FILE_PATH_TEMPLATE + fileName);
        console.log($bigPreview.find('.idea-img').attr("src"));
        $bigPreview.show();
    }
}

// 초기화
let currentFiles = [];
const bigPreviewImgWrapper = document.querySelector("#big-preview-wrap");
bigPreviewImgWrapper.style.display = "none";


/*-----submit--------------------------------------------------------*/

$(".idea-write-btn").on("click", function(e){
    e.preventDefault(); // 폼의 기본 제출을 막아줍니다.

    let text = ``;
    let count = 0;

    // 클릭 이벤트에서 큰 미리보기를 기준으로 each 반복문 실행
    $(".idea-img").each((i, img) => {
        let fullPath = $(img).attr("src");
        if(!fullPath) {return;}
        /*alert(i + '으악' + fullPath);*/

        // /idea-files/display?fileName=2023/08/26/t_6b9ac53a-bae6-449a-92bb-14899d753f05_IMG_8240.PNG

        let datas = fullPath.split("_");

        let ideaFilePath = datas[0].split("=")[1].replace("/t", ""); // 2023/08/26
        let ideaFileUuid = datas[1]; // 6b9ac53a-bae6-449a-92bb-14899d753f05
        let ideaFileName = datas.slice(2).join("_"); // IMG_8240.PNG
        // let ideaFileType = $(img).hasClass("representative");
        let ideaFileSize = sizes[i]; // 'sizes' 변수가 정의되어 있어야 합니다.

        text += `
            <input type="hidden" name="files[${count}].ideaFilePath" value="${ideaFilePath}">
            <input type="hidden" name="files[${count}].ideaFileUuid" value="${ideaFileUuid}">
            <input type="hidden" name="files[${count}].ideaFileName" value="${ideaFileName}">
            <input type="hidden" name="files[${count}].ideaFileSize" value="${ideaFileSize}">
        `
        if(i == 0){
            text += `<input type="hidden" name="files[${count}].ideaFileType" value="REPRESENTATIVE">`;
        }

        // alert(i + '경로' + ideaFilePath + '으악' + ideaFileUuid + '이름' + ideaFileName);
        count++;
    });


    $(ideaForm).append(text);
    $(ideaForm).submit();
});

