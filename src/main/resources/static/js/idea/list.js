showList(ideas, total);
function showList(ideas, total) {
    let $ideasWrap = $("#ideas-wrap");
    let hopePriceIndex = $("#hope-price-tag").next().val();
    let ideaMaxIndex = $("#idea-max-tag").next().val();

    $ideasWrap.empty();
    let textArray = [];

    let totalWrap = $("p.all-text");
    totalWrap.text("전체 " + total + "개");

    ideas.forEach(idea => {
        let itemText = `
        <div class="category-feed-content-item-wrap item-col item-layout">
            <article class="production-item">
                <a href="/idea/detail?id=${idea.id}&ideaPrice=${hopePriceIndex}&ideaMax=${ideaMaxIndex}" class="production-item-overlay"></a>
                <div class="production-item-image">`;

        idea.files.forEach(file => {
            if (file.ideaFileType == "REPRESENTATIVE") {
                itemText += `<img src="/idea-files/display?fileName=${file.ideaFilePath}/t_${file.ideaFileUuid}_${file.ideaFileName}" class="image">`;
            }
        });

        itemText += `
            <button type="button" class="production-item-scrap-badge">
                <svg xmlns="http://www.w3.org/2000/svg" id="Filled" viewBox="0 0 24 24" width="24" height="24"><path stroke="#fff" fill="#fff3" d="M2.849,23.55a2.954,2.954,0,0,0,3.266-.644L12,17.053l5.885,5.853a2.956,2.956,0,0,0,2.1.881,3.05,3.05,0,0,0,1.17-.237A2.953,2.953,0,0,0,23,20.779V5a5.006,5.006,0,0,0-5-5H6A5.006,5.006,0,0,0,1,5V20.779A2.953,2.953,0,0,0,2.849,23.55Z"/></svg>
            </button>
        </div>
        <div class="production-item-content">
            <h1 class="production-item-title">${idea.ideaTitle}</h1>
            <h3 class="production-item-title" style="margin: 0; font-weight: 500; font-size: 15px; margin-top: 10px; color: #9d9b9b; letter-spacing: -0.5px;">${idea.ideaIntro}</h3>
            <span class="item-profile-writer-name" style="display: inline-block; margin-top: 10px; font-size: 15px; color: #444; font-weight: 600;">${idea.userNickname}</span>
            <footer class="production-item-status">
                <span class="entry">스크랩 ${idea.ideaScarpCount}</span>
                <span class="entry">조회 ${idea.ideaReadCount}</span>
                <span class="entry" style="color: mediumpurple; font-weight: 700;">진행상황 ${idea.ideaCount}/${idea.ideaMax}명</span>
                <p class="item-profile-writer-name" style="display: block; margin-top: 10px; font-size: 18px; color: #444; font-weight: 600;"><span style="color:mediumpurple; padding-right: 5px">희망가격</span>${idea.ideaPrice}원</p>
            </footer>
        </div>
    </article>
</div>`;
        textArray.push(itemText);
    });

    $ideasWrap.html(textArray.join(''));
}


function updatePagination(pagination) {
    let paginationHtml = '';

    // 이전 페이지 버튼
    if (pagination.prev) {
        paginationHtml += `<a class="inactive-moving change-page relist" th:if="${pagination.prev}" data-page="${pagination.startPage - 1}">
                                        <span class="prev-arrow"></span>
                                    </a>`;
    }

    // 페이지 번호들
    for (let page = pagination.startPage; page <= pagination.endPage; page++) {
        if (page === pagination.page) {
            paginationHtml += `<a class="active" data-page="${page}">${page}</a>`;
        } else {
            paginationHtml += `<a class="change-page inactive" data-page="${page}">${page}</a>`;
        }
    }

    // 다음 페이지 버튼
    if (pagination.next) {
        paginationHtml += `<a class="active-moving change-page" data-page="${pagination.endPage + 1}">
            <span class="next-arrow"></span>
        </a>`;
    }

    // 페이지네이션 HTML을 DOM에 적용
    $("#paging-wrap").html(paginationHtml);
}



/*----------------------------------------------------------------*/
/*------------------------------------------------------------------------*/


let categoryOrder = ['패션', '리빙홈', '문구', '제로웨이스트', '음료·주류', '디저트', '요리', '반려용품', '유아용품', '기타'];

$(document).ready(function() {
    /*카테고리 뿌리기*/

    $(document).ready(function() {

        // 초기에 모든 하위 카테고리를 숨깁니다.
        $('.commerce-category-list-categories').hide();

        // 상위 카테고리를 클릭하면 해당 하위 카테고리의 표시를 토글합니다.
        $('.commerce-category-list-title a').on('click', function(e) {
            // 클릭 이벤트의 기본 동작(링크로 이동)을 중지시킵니다.
            e.preventDefault();

            // 다른 모든 하위 카테고리를 숨깁니다.
            $('.commerce-category-list-categories').not($(this).parent().next('.commerce-category-list-categories')).slideUp();

            // 클릭한 카테고리의 하위 카테고리 표시를 토글합니다.
            $(this).parent().next('.commerce-category-list-categories').slideToggle();
        });

        $('.commerce-category-tree-entry-title').on('click', function(e) {
            e.preventDefault();  // 링크로 이동하는 것을 방지합니다.

            // 클릭한 타이틀 옆에 있는 hidden input의 value 값을 가져옵니다.
            ideaCategory = $(this).siblings('input[type="hidden"]').val();

            console.log(ideaCategory);  // 콘솔에서 확인할 수 있도록 출력합니다. 필요에 따라 제거해도 좋습니다.
        });


    });

});


