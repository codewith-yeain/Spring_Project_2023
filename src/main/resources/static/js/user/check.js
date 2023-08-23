document.addEventListener('DOMContentLoaded', function () {

    // 전체 동의 체크박스
    const allAgreeCheckbox = document.querySelector('.conditions .form-radio-label:first-child input[name="connect"]');

    // 전체 동의 체크박스를 제외한 나머지 체크박스들
    const otherCheckboxes = document.querySelectorAll('.conditions .form-radio:not(:first-child) input[name="connect"]');

    // 전체 동의 체크박스의 이벤트 리스너
    allAgreeCheckbox.addEventListener('change', function() {
        otherCheckboxes.forEach(checkbox => {
            checkbox.checked = allAgreeCheckbox.checked;
        });
    });

    // 다른 체크박스들의 이벤트 리스너
    otherCheckboxes.forEach(checkbox => {
        checkbox.addEventListener('change', function() {
            // 모든 체크박스가 선택되면
            if ([...otherCheckboxes].every(box => box.checked)) {
                allAgreeCheckbox.checked = true;
            }
            // 하나라도 선택되지 않았다면
            else {
                allAgreeCheckbox.checked = false;
            }
        });
    });

});


document.addEventListener('DOMContentLoaded', function () {
    const allAgreeCheckbox = document.querySelector('.conditions .form-radio-label:first-child input[name="connect"]');
    const otherCheckboxes = document.querySelectorAll('.conditions .form-radio-label:not(:first-child) input[name="connect"]');
    const requiredCheckboxes = document.querySelectorAll('.conditions .form-radio-label.check-box-text4 input[name="connect"]');
    const joinButton = document.querySelector('.join-button');

    function updateAllAgreeCheckbox() {
        allAgreeCheckbox.checked = [...otherCheckboxes].every(checkbox => checkbox.checked);
    }

    function updateJoinButton() {
        if ([...requiredCheckboxes].every(checkbox => checkbox.checked)) {
            joinButton.removeAttribute('disabled');
        } else {
            joinButton.setAttribute('disabled', 'disabled');
        }
    }

    allAgreeCheckbox.addEventListener('change', function () {
        const isChecked = allAgreeCheckbox.checked;
        otherCheckboxes.forEach(checkbox => checkbox.checked = isChecked);
        updateJoinButton();
    });

    otherCheckboxes.forEach(checkbox => {
        checkbox.addEventListener('change', function () {
            updateAllAgreeCheckbox();
            updateJoinButton();
        });
    });

    // 필수 항목 체크박스 상태 변화 감지
    requiredCheckboxes.forEach(checkbox => {
        checkbox.addEventListener('change', updateJoinButton);
    });

    // 페이지 로딩 시 초기 상태 설정
    updateJoinButton();
});



