$(document).ready(function(){
    const $mypageProfileImg = $("#mypage-profile-img");
    const $mypageProfileNickname = $("#profile-user-nickname");


    const $mypageProfileIntrotext = $("#profile-content-detail-text-intro dd");

    // let type = $("select[name=type]").val();
    // let keyword = $("input[name=keyword]").val();
    let textImg = "";
    let textNickname = "";

    let textIntro = "";

    console.log("----------");
    console.log(memberId);
    console.log(myId);
    console.log("----------22");

    textNickname += `
        <div id="profile-user-nickname" class="profile-user-nickname">${myId.userNickname}</div>
    `

    if(myId.userIntro != null) {
        textIntro += `
            <dd>${myId.userIntro}</dd>
        `
    } else {
        textIntro += `
            <dd>한 줄 소개</dd>
        `
    }






    $mypageProfileIntrotext.html(textIntro);
    $mypageProfileImg.append(textImg);
    $mypageProfileNickname.html(textNickname);
});



