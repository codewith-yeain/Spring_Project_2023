/** 배너 */
const bannerList = document.querySelector('.banner-lists');
const bannerItems = document.querySelectorAll('.banner-list');

let currentSlide = 0;

function showSlide(slideIndex) {
    bannerList.style.transform = `translateX(-${slideIndex * 100}%)`;
}

function nextSlide() {
    currentSlide = (currentSlide + 1) % bannerItems.length;
    showSlide(currentSlide);
}

setInterval(nextSlide, 5000); // Auto switch slides every 5 seconds

/** 상품 마우스 오버 */
const products = document.querySelectorAll('.products');
const productImg1 = document.querySelectorAll('.product-img1');
//const productImg2 = document.querySelectorAll('.product-img2');
// const productTitle = document.querySelector('.product-title');

products.addEventListener('mouseover', () => {
    productImg1.style.transform = 'scale(1.2)';
    // productTitle.style.color = '';
});

products.addEventListener('mouseout', () => {
    productImg1.style.transform = 'scale(1)';
    // productTitle.style.opacity = '0';
});