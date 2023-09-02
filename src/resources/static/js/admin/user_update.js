function deleteUser() {
    const selectedMembers = [];  // 선택된 회원 정보 (예: ID 목록)를 배열로 저장

    // 선택된 회원 정보를 배열에 추가하는 로직 (예: 테이블 내 체크박스 확인)

    // AJAX 요청 보내기
    $.ajax({
        type: "POST",
        url: "/member",  // 서버의 업데이트 처리 URL
        data: JSON.stringify(selectedMembers),
        contentType: "application/json",
        success: function(response) {
            // 성공 시 처리 로직
        },
        error: function(error) {
            // 오류 시 처리 로직
        }
    });
}

$(".delete-button").on("click", function() {
    const selectedMembers = [];

    $(".member-checkbox:checked").each(function() {
        const $row = $(this).closest("tr");
        const memberId = $row.find(".memberId").text();
        selectedMembers.push(memberId);
    });

    $.ajax({
        type: "POST",
        url: "/delete-members",
        data: JSON.stringify(selectedMembers),
        contentType: "application/json",
        success: function(response) {
            // 성공 시 처리 로직
            location.reload(); // 페이지 새로고침
        },
        error: function(error) {
            // 오류 시 처리 로직
        }
    });
});