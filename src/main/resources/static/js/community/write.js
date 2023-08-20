/*community > write.html*/
autosize($("textarea"));

function resize(obj) {
    obj.style.height = '1px';
    obj.style.height = (12 + obj.scrollHeight) + 'px';
}


document.addEventListener("DOMContentLoaded", function() {
    let toggleButton = document.querySelector(".write-community-help-btn");
    let helpWrapper = document.querySelector(".write-community-help-content-wrapper");

    toggleButton.addEventListener("click", function() {
        helpWrapper.classList.toggle("open");
    });
});

document.addEventListener("DOMContentLoaded", function() {
    let closeButton = document.querySelector(".write-community-help-content-close-btn");
    let helpWrapper = document.querySelector(".write-community-help-content-wrapper");

    closeButton.addEventListener("click", function() {
        helpWrapper.classList.remove("open");
    });
});

function checkLength(textarea, max){
    let value = $(textarea).val();
    let length = value.length > max ? max : value.length;
    max = max.toLocaleString('ko-KR'); //한국 숫자 표기법(끝 3자리 마다 콤마 삽입)
    $(textarea).next().text(`${length}/${max}`);
}


/*----------------------------------------------------*/

$("button.ok-button").on("click", function(){
    let text = ``;
    // let count = 0;
    // $("img.thumbnail").each((i, img) => {
    //     let fullPath = $(img).attr("src");
    //     if(!fullPath) {return;}
    //
    //     let datas = fullPath.split("_");
    //     let filePath = datas[0].split("=")[1].replace("/t", "");
    //     let fileUuid = datas[1];
    //     let fileName = datas[2];
    //     let fileType = $(img).hasClass("representative");
    //     let fileSize = sizes[i];
    //
    //     text += `
    //         <input type="hidden" name="files[${count}].filePath" value="${filePath}">
    //         <input type="hidden" name="files[${count}].fileUuid" value="${fileUuid}">
    //         <input type="hidden" name="files[${count}].fileName" value="${fileName}">
    //         <input type="hidden" name="files[${count}].fileSize" value="${fileSize}">
    //     `
    //     if(fileType){
    //         text += `<input type="hidden" name="files[${count}].fileType" value="REPRESENTATIVE">`;
    //     }
    //     count++;
    // });
    $communityAnonym = $("input[id='community-anonym']");
    $anonymStatus = $("input[id='anonym-status']");
    const isChecked = $communityAnonym.checked;

    if(isChecked === 'true'){
        $anonymStatus.val('on');
    } else {
        $anonymStatus.val('off');
    }

    $(writeForm).append(text);
    // $(writeForm).submit();
    document.writeForm.submit();
});
















