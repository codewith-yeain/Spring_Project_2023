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