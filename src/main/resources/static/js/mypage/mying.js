





/* ----- */


//
// $(document).ready(function(){
//     const $mypageProfileImg = $("#mypage-profile-img");
//     const $mypageProfileId = $("#mypage-profile-id");
//
//     let type = $("select[name=type]").val();
//     let keyword = $("input[name=keyword]").val();
//     let textImg = "";
//     let textId = "";
//
//     console.log("----------");
//     console.log(memberId);
//     console.log("----------22");
//
//     textId += `
//         <div id="mypage-profile-id" class="mypage-profile-id">${memberId}</div>
//     `
//
//
//     $mypageProfileImg.append(textImg);
//     $mypageProfileId.html(textId);
// });
//
//
//
//





//
// $(document).ready(function(){
//     const $mypageProfileImg = $("#mypage-profile-img");
//     const $mypageProfileId = $("#mypage-profile-id");
//
//     let type = $("select[name=type]").val();
//     let keyword = $("input[name=keyword]").val();
//     let textImg = "";
//     let textId = "";
//     posts.forEach(post => {
//         text += `
//             <li>
//                 <div>
//                     <a href="/post/read?id=${post.id}&type=${type}&keyword=${keyword}">
//                         <h1>${post.id}</h1>
//                         <section class="content-container">
//                             <div class="profile">
//                                 <div><img src="/images/profile.png" width="15px"></div>
//                                 <h6 class="writer">${post.memberName}</h6>
//                             </div>
//                             <h4 class="title">${post.postTitle}</h4>
//                             <h6 clss="post-info">
//                                 <span class="read-count">조회 ${post.postReadCount}</span>
//                                 <span>·</span>
//                                 <span class="date">${elapsedTime(post.postRegisterDate)}</span>
//                             </h6>
//                         </section>
//         `
//         // post.files.forEach(file => {
//
//         //     if(file.fileType == "REPRESENTATIVE"){
//         //         text += `<img src="/files/display?fileName=${file.filePath}/t_${file.fileUuid}_${file.fileName}" class="preview">`;
//         //     }
//         // })
//
//         text += `
//                     </a>
//                 </div>
//             </li>
//         `
//     });
//
//     $mypageProfileImg.append(textImg);
//     $mypageProfileId.html(textId);
// });
//







$(document).ready(function(){
    // const $mypageProfileImg = $("#mypage-profile-img");
    // const $mypageProfileId = $("#mypage-profile-id");
    //
    // let type = $("select[name=type]").val();
    // let keyword = $("input[name=keyword]").val();
    // let textImg = "";
    // let textId = "";
    posts.forEach(post => {
        text += `
            <div class="user-card-feed-item-wrap user-card-feed-content-col">
                <div class="user-card-feed-item">
                    <article class="card-collection-item">
                        <div class="card-collection-item-content">
                            <a href="" class="card-collection-item-content-link"></a>
                            <div class="card-item-description card-collection-item-description">
                                <div class="card-item-description-content">아이디어 제목</div>    <!--아이디어 제목-->
                            </div>
                            <div class="card-collection-item-image">
                                <div class="card-item-image">
                                    <img src="https://image.ohou.se/i/bucketplace-v2-development/uploads/cards/snapshots/163032748151865412.jpeg?gif=1&w=640&h=640&c=c&q=80&webp=1" class="image">
                                    <span class="card-item-image-collection-icon">
                                        <svg class="icon" width="18" height="18" viewBox="0 0 18 18" preserveAspectRatio="xMidYMid meet"><g fill="none" fill-rule="evenodd"><path stroke="#000" stroke-opacity=".14" stroke-width=".75" d="M14.27 3.85H15a2.62 2.62 0 0 1 2.62 2.63V15A2.62 2.62 0 0 1 15 17.63H6.49A2.62 2.62 0 0 1 3.85 15v-.73h7.8a2.63 2.63 0 0 0 2.62-2.62v-7.8zM.37 3A2.62 2.62 0 0 1 3 .37h8.52A2.62 2.62 0 0 1 14.15 3v8.52a2.62 2.62 0 0 1-2.63 2.63H3a2.62 2.62 0 0 1-2.63-2.63V3z"></path><path fill="#FFF" fill-opacity=".74" d="M14.64 4.22H15c1.25 0 2.26 1 2.26 2.26V15c0 1.24-1 2.25-2.25 2.25H6.48c-1.25 0-2.26-1-2.26-2.25v-.35h7.43a3 3 0 0 0 3-3V4.22zM.75 3C.75 1.76 1.75.75 3 .75h8.52c1.25 0 2.26 1 2.26 2.25v8.52c0 1.25-1 2.26-2.26 2.26H3c-1.24 0-2.25-1-2.25-2.26V3z"></path></g></svg>
                                    </span>
                                    <span class="card-item-image-view-count">
                                        조회수
                                        9,283
                                    </span>
                                </div>
                            </div>
                        </div>
                    </article>
                </div>
            </div>
        `
        // post.files.forEach(file => {

        //     if(file.fileType == "REPRESENTATIVE"){
        //         text += `<img src="/files/display?fileName=${file.filePath}/t_${file.fileUuid}_${file.fileName}" class="preview">`;
        //     }
        // })

        text += `
                   
        `
    });

    $mypageProfileImg.append(textImg);
    $mypageProfileId.html(textId);
});

