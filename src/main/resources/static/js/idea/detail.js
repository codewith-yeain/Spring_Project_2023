

function numberWithCommas(x) {
    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}

function checkVisible(element) {
    const viewportTop = $(window).scrollTop();
    const viewportBottom = viewportTop + $(window).height();

    const elemTop = $(element).offset().top + 700;
    const elemBottom = elemTop + $(element).height() + 600;

    // 요소의 일부분만 화면에 보이더라도 감지하기 위한 조건 수정
    return (elemTop < viewportBottom) && (elemBottom > viewportTop);
}


$(document).ready(function () {
    /*가격 단위 콤마 추가*/
    document.addEventListener('DOMContentLoaded', function() {
        let priceElement = document.getElementById("price");
        let priceValue = parseInt(priceElement.textContent, 10);
        // 모든 'production-item-price-price' 클래스를 가진 요소를 선택
        const priceElements = document.querySelectorAll('.production-item-price-price');


        priceElement.textContent = numberWithCommas(priceValue);

        // 각 요소의 내용을 numberWithCommas 함수로 변환
        priceElements.forEach(element => {
            element.textContent = numberWithCommas(element.textContent.trim());
        });
    });


    $(document).ready(function () {
        // 네비게이션 아이템 클릭 시 스크롤 이동
        $('.production-selling-navigation-item').on('click', function (e) {
            e.preventDefault();
            let targetId = $(this).data('target');
            $('html, body').animate({
                scrollTop: $('#' + targetId).offset().top - 200
            }, 500);
        });

        // 스크롤 이벤트
        $(window).on('scroll', function () {
            $('.production-selling-navigation-item').each(function () {
                let targetId = $(this).data('target');
                let targetElement = $('#' + targetId);

                if (checkVisible(targetElement)) {
                    $('.production-selling-navigation-item').removeClass('production-selling-navigation-item-active');
                    $(this).addClass('production-selling-navigation-item-active');
                }
            });
        });
    });

});


