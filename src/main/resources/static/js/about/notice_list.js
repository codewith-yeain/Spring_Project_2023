$(document).ready(function(){
    const $noticeList = $("#notice-list");
    let text = "";
    console.log(posts);
    posts.forEach(post => {

        text += `
           <a href="" class="blog-page-post-list-item">
                <div class="blog-page-post-list-item-wrap">
                    <div class="blog-page-post-list-item-title">${post.noticeTitle}</div>
                    <div>${post.noticeContent}</div>
                    <div class="blog-page-post-list-item-explain">
                        <div>${post.noticeDate}</div>
                        <span class="blog-page-post-list-item-explain-bar"></span>
                        <div>Admin</div>
                    </div>
                </div>
          
        `
        text += `
            </a>
        `
    });
    $noticeList.append(text);
});