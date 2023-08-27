
$(document).on("click", "a.change-page", function(e){
    e.preventDefault();
    let page = $(this).data("page");  // 여기서 페이지 번호를 가져옵니다.
    // let page = $(this).text();// 여기서 페이지 번호를 가져옵니다.
    alert(page);
    let hopePriceIndex = $("#hope-price-tag").next().val();
    let ideaMaxIndex = $("#idea-max-tag").next().val();
    let sortValue = $("#sort-tag").next().val();
    let sortIndex;
    switch(sortValue) {
        case '1':
            sortIndex = 'scrap';
            break;
        case '2':
            sortIndex = 'popular';
            break;
        default:
            sortIndex = 'recent';
    }
    location.href = `/idea/ideaBank?page=${page}&ideaPrice=${hopePriceIndex}&ideaMax=${ideaMaxIndex}&order=${sortIndex}`;
});