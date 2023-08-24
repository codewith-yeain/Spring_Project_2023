let currentIndex = 1;  // 첫 번째 '실제' 이미지를 가리키도록 초기값 변경
const slides = document.querySelectorAll("#slider img");

function updateSlide(position, transition=true) {
    if(transition) {
        document.querySelector("#slider").style.transition = "transform 2s";
    } else {
        document.querySelector("#slider").style.transition = "none";
    }
    const offset = -position * 1920;
    document.querySelector("#slider").style.transform = `translateX(${offset}px)`;
}

function nextImage() {
    currentIndex++;
    updateSlide(currentIndex);
    if (currentIndex === slides.length - 1) {  // 마지막 복제된 이미지에 도달했을 때
        setTimeout(() => {
            currentIndex = 1;  // 첫 번째 '실제' 이미지로 이동
            updateSlide(currentIndex, false);  // 순간적으로 점프
        }, 2000);  // 2초 후에 실행
    }
}

function prevImage() {
    currentIndex--;
    updateSlide(currentIndex);
    if (currentIndex === 0) {  // 첫 번째 복제된 이미지에 도달했을 때
        setTimeout(() => {
            currentIndex = slides.length - 2;  // 마지막 '실제' 이미지로 이동
            updateSlide(currentIndex, false);  // 순간적으로 점프
        }, 2000);  // 2초 후에 실행
    }
}

const slideInterval = setInterval(nextImage, 5000);
