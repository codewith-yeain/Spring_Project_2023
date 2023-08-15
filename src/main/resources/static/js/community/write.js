/*community > write.html*/


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