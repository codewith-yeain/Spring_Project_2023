$('#email-auth-second-step').hide();

$(document).ready(function() {
    // 초기 버튼 상태 설정
    $('.email-check-button').prop('disabled', true);
    $('.email-getcertification-button').prop('disabled', true);
    $('.password-get-button').prop('disabled', true);
    $('.password-gotcertificate-button').prop('disabled', true);

    // 이메일 입력란에 텍스트가 입력되면 확인 버튼의 disabled 상태 해제
    $('#toEmail').on('input', function() {
        if ($(this).val().length > 0) {
            $('.email-check-button').prop('disabled', false);
        } else {
            $('.email-check-button').prop('disabled', true);
        }
    });

    // 확인 버튼을 클릭하면
    $('.email-check-button').click(function() {

        // 이메일 입력 필드에서 값을 가져옴
        const toEmail = $("input[id='toEmail']").val();

        $.ajax({
            url: `/user/check-email?userEmail=${toEmail}`,
            success: function(result){
                if(!result) {
                    alert('가입되어 있지 않은 이메일입니다.');
                    /*$(".email-form .form-control").css('border-color', '#eacaff');*/
                } else {
                    alert('정상 이메일입니다.');
                }
            },
            error: function(jqXHR, textStatus, errorThrown) {
                console.error("AJAX 오류:", textStatus, errorThrown);
                alert('오류가 발생했습니다. 다시 시도해 주세요.');
            }
        });

        $('#toEmail').css('border-color', '#eacaff');
        $('.email-getcertification-button').prop('disabled', false);
    });

    // 이메일 인증코드 받기 버튼을 클릭하면
    $('.email-getcertification-button').click(function() {
        $('#email-auth-first-step').fadeOut(function() {
            $('#email-auth-second-step').fadeIn();
        });
    });
});

function confirmNumber(){
    var number1 = $("#number").val(); // 사용자 입력
    var number2 = $("#confirm").val(); // 실제 인증번호

    if(number1 == number2){
        alert("인증되었습니다.");
        $("#number").css("border-color", '#eacaff');
        $('.password-get-button').prop('disabled', false);
    }else{
        alert("번호가 다릅니다.");
        $('.password-get-button').prop('disabled', true);
    }
}

function sendNumber(){
    const toEmail = $("input[id='toEmail']").val();
    $.ajax({
        url:`/user/email-auth?toEmail=${toEmail}`,
        type:"post",
        success: function(data){
            alert("인증번호 발송");
            $("#confirm").attr("value",data);
            console.log($("#confirm").val());
        },
        error: function(jqXHR, textStatus, errorThrown){
            alert(`Request failed: ${textStatus}`);
            console.log(jqXHR, textStatus, errorThrown);
        }
    });
}


$(document).ready(function(){
    // 인증번호 input의 키 입력 이벤트 감지
    $("#number").on('keyup', function(){
        if($(this).val().length > 0){
            // 입력된 값이 있을 경우 "확인" 버튼의 disabled 상태 해제
            $('.password-gotcertificate-button').prop('disabled', false);
        }else{
            // 입력된 값이 없을 경우 "확인" 버튼을 다시 disabled 상태로 설정
            $('.password-gotcertificate-button').prop('disabled', true);
        }
    });

    // "확인" 버튼 클릭 이벤트
    $(".password-gotcertificate-button").click(function(){
        confirmNumber(); // 기존의 인증번호 검사 함수 호출
    });
});


