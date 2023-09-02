$(document).ready(function(){
    const $communityList = $("#community-list");
    let text = "";
    console.log(posts);
    posts.forEach(post => {

        text += `
            <tr>
                <td class="checkbox-line">
                    <input type="checkbox" name="check">
                </td>
                <td class="noticeId">
                    <a style="font-size: 15px;">
                    ${post.id}
                    </a>
                </td>
                <td>${post.userName}</td>               
                <td>${post.communityTitle}</td>
                <td>${post.userEmail}</td>
                <td>${post.communityRegisterDate}</td>
                <td>${post.sortId}</td>
            
                                            
        `
        text += `
            </tr>
        `
    });
    $communityList.append(text);
});