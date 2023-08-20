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


$(document).ready(function(){
    const $list = $("#com-listMine");
    // let type = $("select[name=type]").val();
    // let keyword = $("input[name=keyword]").val();
    let text = "";
    console.log(posts);
    posts.forEach(post => {
        text += `
            <div class="customer-notice-list-item">
                <a href="" class="customer-notice-feed-item">
                    <article class="customer-notice-feed-item-content">
                        <div>
                            <p class="customer-notice-feed-item-sort">창업</p>
                            <h1 class="customer-notice-feed-item-title">게시글 제목</h1>
                            <time class="customer-notice-feed-item-date">2023.07.06</time>
                        </div>
                        <aside class="card-item-action-list">
                            <button type="button" class="card-item-action-list-action">
                                <svg class="like" width="24" height="24" fill="currentColor" stroke="currentColor" stroke-width="2" viewBox="0 0 24 24">
                                    <path d="M23.22 7.95c.4 4.94-2.92 9.71-10.92 13.85a.47.47 0 0 1-.42 0C3.88 17.66.56 12.9.96 7.93 1.54 2.48 8.28.3 12.1 4.7c3.8-4.4 10.55-2.22 11.13 3.25z"></path>
                                </svg>
                                <span class="count">73</span>
                            </button>
                            <button type="button" class="card-item-action-list-action">
                                <svg class="comment" width="24" height="24" viewBox="0 0 24 24">
                                    <path fill="currentColor" fill-rule="nonzero" d="M13.665 18.434l.53-.066C19.69 17.679 23 14.348 23 10c0-4.942-4.235-8.5-11-8.5S1 5.058 1 10c0 4.348 3.31 7.68 8.804 8.368l.531.066L12 21.764l1.665-3.33zm-3.985.926C3.493 18.585 0 14.69 0 10 0 4.753 4.373.5 12 .5S24 4.753 24 10c0 4.69-3.493 8.585-9.68 9.36l-1.647 3.293c-.374.75-.974.744-1.346 0L9.68 19.36z"></path>
                                </svg>
                                <span class="count">22</span>
                            </button>
                        </aside>
                    </article>
                </a>
            </div>
        `
        // post.files.forEach(file => {
        //     if(file.fileType == "REPRESENTATIVE"){
        //         text += `<img src="/files/display?fileName=${file.filePath}/t_${file.fileUuid}_${file.fileName}" class="preview">`;
        //     }
        // })

        // text += `
        //             </a>
        //         </div>
        //     </li>
        // `
    });

    $list.append(text);
});