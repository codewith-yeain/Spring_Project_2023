
function send(){
    // $joinInputs.trigger("blur");
    // if(!idCheck){
    //     let modalMessage = "<span>아이디를 다시 확인해주세요.</span>";
    //     showWarnModal(modalMessage);
    //     return;
    // }
    //
    // if(joinCheckAll.filter(check => check).length != $joinInputs.length){
    //     let modalMessage = "<span>모든 정보를 정확히 입력하셔야</span><span>가입이 완료됩니다.</span>";
    //     showWarnModal(modalMessage);
    //     return;
    // }

    /*비밀번호 암호화(인코딩)*/
    $("input[name='confirmPassword']").val(btoa($("input[name='confirmPassword']").val()));
    // $("#password-check").val(btoa($("#password-check").val()));

    /*이메일 합치기*/
    $("input[name='userEmail']").val($("input[name='email-first']").val() + '@' + $("select[id='email-select']").val())

    document.join.submit();
}





/*------------------------------------------------------------------------*/
// 이메일 직접 입력 선택시 select 태그가 input 태그로 바꾸는 기능

// select 태그와 input 태그를 생성할 컨테이너 요소를 가져옵니다.
const select = document.getElementById('email-select');
const arrowBtn = document.querySelector('.email-input2_expand');
const inputContainer = document.getElementById('change');

// select 태그를 input 태그로 대체하는 함수를 정의합니다.
function convertToInput() {
    // 선택한 option의 값을 가져옵니다.
    const selectedOption = select.value;
    if (selectedOption === 'manual') { // '직접입력' 선택시
        // input 태그를 생성하고 설정합니다.
        const input = document.createElement('input');
        input.type = 'text';
        input.classList.add('form-control');
        // input.value = selectedOption;

        // 이전의 select 태그를 숨깁니다.
        select.style.display = 'none';

        // 확장 버튼(arrow)을 숨깁니다.
        arrowBtn.style.display = 'none';

        // input 태그를 컨테이너에 추가합니다.
        inputContainer.appendChild(input);
    }
}

// select 태그의 변경 이벤트에 convertToInput 함수를 연결합니다.
select.addEventListener('change', convertToInput);

// 이메일 인증 버튼 활성화

// const $emailFirst = $("input[name='email-first']");
// const $emailLastSelect = $("label[name='email-last'] select");
// const $emailLastInput = $("label[name='email-last'] input");
// const $emailBtn = $("button[name='emailAuth']");
// const $Inputs = $("input");
//
// $Inputs.on("blur", function () {
//     if($emailLastSelect.style.display == 'none'){
//         if($emailFirst.val() == "" || $emailLastInput.val() == ""){
//             $emailBtn.disabled = true;
//             $emailFirst.style.border = "1px solid #f77";
//             $emailLastInput.style.border = "1px solid #f77";
//         } else {
//             $emailBtn.disabled = false;
//             $emailFirst.style.border = "1px solid #dbdbdb";
//             $emailLastInput.style.border = "1px solid #dbdbdb";
//             $emailBtn.style.color = "mediumpurple";
//             $emailBtn.style.border = "1px solid mediumpurple";
//         }
//         $("input[name='userEmail']").val($emailFirst.val() + '@' + $emailLastInput.val()) // 이메일 합치기
//     } else{
//         $("input[name='userEmail']").val($emailFirst.val() + '@' + $emailLastSelect.val()) // 이메일 합치기
//     }
// })






















