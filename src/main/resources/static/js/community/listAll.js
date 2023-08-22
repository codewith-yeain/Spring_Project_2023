$(document).ready(function(){
    const $postList = $("#community-post-list");
    let type = $("select[name=type]").val();
    let keyword = $("input[name=keyword]").val();
    let text = "";
    console.log(posts);
    posts.forEach(post => {
        text += `
            <li>
                <div>
                    <a href="/post/read?id=${post.id}&type=${type}&keyword=${keyword}">
                        <h1>${post.id}</h1>
                        <section class="content-container">
                            <div class="profile">
                                <div><img src="/images/profile.png" width="15px"></div>
                                <h6 class="writer">${post.memberName}</h6>
                            </div>
                            <h4 class="title">${post.postTitle}</h4>
                            <h6 clss="post-info">
                                <span class="read-count">조회 ${post.postReadCount}</span>
                                <span>·</span>
                                <span class="date">${elapsedTime(post.postRegisterDate)}</span>
                            </h6>
                        </section>
        `
        // post.files.forEach(file => {

        //     if(file.fileType == "REPRESENTATIVE"){
        //         text += `<img src="/files/display?fileName=${file.filePath}/t_${file.fileUuid}_${file.fileName}" class="preview">`;
        //     }
        // })

        text += `
                    </a>
                </div>
            </li>
        `
    });

    $ul.html(text);
});

$(document).ready(function(){
    const $ul = $("#content-wrap ul");
    let type = $("select[name=type]").val();
    let keyword = $("input[name=keyword]").val();
    let text = "";
    console.log(posts);
    posts.forEach(post => {
        text += `
            <li>
                <div>
                    <a href="/post/read?id=${post.id}&type=${type}&keyword=${keyword}">
                        <h1>${post.id}</h1>
                        <section class="content-container">
                            <div class="profile">
                                <div><img src="/images/profile.png" width="15px"></div>
                                <h6 class="writer">${post.memberName}</h6>
                            </div>
                            <h4 class="title">${post.postTitle}</h4>
                            <h6 clss="post-info">
                                <span class="read-count">조회 ${post.postReadCount}</span>
                                <span>·</span>
                                <span class="date">${elapsedTime(post.postRegisterDate)}</span>
                            </h6>
                        </section>
        `
        // post.files.forEach(file => {
        //     if(file.fileType == "REPRESENTATIVE"){
        //         text += `<img src="/files/display?fileName=${file.filePath}/t_${file.fileUuid}_${file.fileName}" class="preview">`;
        //     }
        // })

        text += `
                    </a>
                </div>
            </li>
        `
    });

    $ul.html(text);
});




//  사진 썸네일 있는 유형

// <a href="" class="blog-page-post-list-item">
//     <div class="blog-page-post-list-item-wrap">
//     <p class="blog-page-post-list-item-tag">창업</p>
//     <div class="blog-page-post-list-item-title">게시글 제목(사진 첨부O)</div>
// <div class="blog-page-post-list-item-description">
//     게시글 시작 일부 미리보기
// </div>
// <div class="blog-page-post-list-item-explain">
//     <div>2023년 7월 28일</div>
// <span class="blog-page-post-list-item-explain-bar"></span>
//     <div>게시글 작성자</div>
// </div>
// </div>
//
// <div class="blog-page-post-list-item-image">
//     <img src="https://image.ohou.se/i/bucketplace-v2-development/uploads/projects/cover_images/167181081384278038.jpg?w=540&h=360&c=c" class="blog-page-post-list-item-image-item">
//     </div>
//     </a>






//  사진 썸네일 없는 유형

// <a href="" class="blog-page-post-list-item">
//     <div class="blog-page-post-list-item-wrap">
//     <p class="blog-page-post-list-item-tag">문화</p>
//     <div class="blog-page-post-list-item-title">게시글 제목(사진 첨부X)</div>
// <div class="blog-page-post-list-item-description">
//     게시글 시작 일부 미리보기
// </div>
// <div class="blog-page-post-list-item-explain">
//     <div>2023년 7월 28일</div>
// <span class="blog-page-post-list-item-explain-bar"></span>
//     <div>게시글 작성자</div>
// </div>
// </div>
//
//          // <!--<div class="blog-page-post-list-item-image">
//          //     <img src="https://image.ohou.se/i/bucketplace-v2-development/uploads/projects/cover_images/167181081384278038.jpg?w=540&h=360&c=c" class="blog-page-post-list-item-image-item">
//          //     </div>-->
//     </a>


























































