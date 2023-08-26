
$(document).ready(function () {
    const $filterWrap = $(".category-filter-bar-tag-list-content");

    $(".panel-drop-down").on("click", function () {
        const $optionWrap = $(this).find(".option-wrap");

        if ($optionWrap.css("display") == "none") {
            $optionWrap.fadeIn("fast");
        } else {
            $optionWrap.fadeOut("fast");
        }
    });

    $(".opt").on("click", function () {
        let $optText = $(this).text();
        let $text = `<li class="category-filter-bar-tag-list-item">
                        <button class="category-filter-bar-tag">
                            ${$optText}
                            <img src="/images/icon/x.svg" width="10" height="10">
                        </button>
                    </li>`;

        $filterWrap.append($text);
        console.log($optText);
    });
});

/*------------------------------------------------------------------------*/


let categoryOrder = ['패션', '리빙홈', '문구', '제로웨이스트', '음료・주류', '디저트', '요리', '반려용품', '유아용품', '기타'];

$(document).ready(function() {
    $('.commerce-category-list-others-item a').on('click', function(e) {
        e.preventDefault();

        let clickedCategory = $(this).text();

        // 상위 카테고리 업데이트ideaCategory
        let $currentCategory = $('.commerce-category-list-title a');
        let currentCategoryText = $currentCategory.text();

        $currentCategory.text(clickedCategory);

        // 하위 카테고리 업데이트
        updateSubCategories(clickedCategory);

        // 클릭한 카테고리를 목록에서 제거
        $(this).parent().remove();

        // 기존 상단 카테고리를 목록에 복귀
        let categoryListItems = $('.commerce-category-list-others-item').toArray();
        let categoriesInList = categoryListItems.map(item => $(item).find('a').text());

        let currentIndex = categoryOrder.indexOf(currentCategoryText);
        let insertionIndex = -1;

        for (let i = currentIndex - 1; i >= 0; i--) {
            let prevCategory = categoryOrder[i];
            if (categoriesInList.includes(prevCategory)) {
                insertionIndex = categoriesInList.indexOf(prevCategory);
                break;
            }
        }

        if (insertionIndex >= 0) {
            $('.commerce-category-list-others-item').eq(insertionIndex).after('<li class="commerce-category-list-others-item"><a href="">' + currentCategoryText + '</a></li>');
        } else {
            $('.commerce-category-list-others').prepend('<li class="commerce-category-list-others-item"><a href="">' + currentCategoryText + '</a></li>');
        }
    });
});

function updateSubCategories(category) {
    let subCategoriesMap = {
        '패션' : ['여성의류', '남성의류', '언더웨어', '액세서리', '신발', '가방', '아동의류', '스포츠・아웃도어'],
        '리빙홈' : ['가구', '조명', '인테리어 소품', '침구', '욕실용품', '주방용품'],
        '문구' : ['필기도구', '노트', '데스크용품', '여행・가방용품', '기프트・포장'],
        '제로웨이스트' : ['재사용 가능 용기', '패브릭', '주방용품', '화장품・뷰티', '생활용품'],
        '음료・주류' : ['차・커피', '쥬스', '칵테일', '와인・맥주', '전통주・알코올음료'],
        '디저트' : ['케이크・빵', '초콜릿・사탕', '아이스크림', '푸딩・젤리', '전통 디저트'],
        '요리' : ['한식', '중식', '일식', '양식', '그 외 세계요리', '특색 요리'],
        '반려용품' : ['개용품', '고양이용품', '소동물용품', '어류용품', '훈련・게임용품'],
        '유아용품' : ['유아복', '장난감・교육용품', '유아식품・간식', '위생용품', '유아가구・침구'],
        '기타' : ['전자제품・기기', '여행・레저', '취미・공예', '책・출판', '음악・엔터테인먼트', '그 외']
    };
    let subCategories = subCategoriesMap[category];

    let $subCategoryList = $('.commerce-sub-category-list');
    $subCategoryList.empty();

    subCategories.forEach(subCategory => {
        $subCategoryList.append('<li class="commerce-sub-category-list-item"><a href="#">' + subCategory + '</a></li>');
    });
}

