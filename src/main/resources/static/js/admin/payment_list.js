$(document).ready(function(){
    const $paymentList = $("#payment-list");
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
                <td>${post.userId}</td>
                <td>${post.paymentAmount}</td>
                <td>${post.paymentStatus}</td>
                <td>${post.paymentApproveDate}</td>
                <td>${post.paymentSort}</td>
            
        `
        text += `
            </tr>
        `
    });
    $paymentList.append(text);
});