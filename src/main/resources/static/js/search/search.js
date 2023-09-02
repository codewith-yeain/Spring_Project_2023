// 헤더 input에서 keyword 값을 가져옴
let nextKeyword = document.getElementById('search-bar').value;



document.querySelector('#search-idea').addEventListener('click', function() {
    // keyword 값을 URL의 쿼리 스트링으로 추가
    window.location.href = "/search/search-idea?keyword=" + encodeURIComponent(nextKeyword);
});

document.querySelector('#search-user').addEventListener('click', function() {
    // keyword 값을 URL의 쿼리 스트링으로 추가
    window.location.href = "/search/search-user?keyword=" + encodeURIComponent(nextKeyword);
});

document.querySelector('#search-all').addEventListener('click', function() {
    // keyword 값을 URL의 쿼리 스트링으로 추가
    window.location.href = "/search/search-all?keyword=" + encodeURIComponent(nextKeyword);
});