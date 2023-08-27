$(document).ready(function(){
    const $userList = $("#user-list");
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
                <td>${post.userNickname}</td>
                <td>${post.userEmail}</td>
                <td>${post.userStatus}</td>
                <td>${post.userType}</td>
            
        `
        text += `
            </tr>
        `
    });
    $userList.append(text);
});