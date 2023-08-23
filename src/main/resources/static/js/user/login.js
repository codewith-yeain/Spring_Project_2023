
const $email = $("input#email");
const $password = $("input#password");

function send(){
    if(!$email.val()){
        alert("아이디를 입력해주세요!");
        return;
    }
    if(!$password.val()){
        alert("비밀번호를 입력해주세요!");
        return;
    }

	/*비밀번호 암호화(인코딩)*/
	$password.val(btoa($password.val()));

    document.login.submit();
}