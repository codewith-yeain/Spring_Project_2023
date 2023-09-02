$(document).ready(function(){
    const $tr = $("#content-wrap tr");
/*    let type = $("select[name=type]").val();
    let keyword = $("input[name=keyword]").val();*/
    let text = "";
    inquires.forEach(inquiry => {
        text += `
            <td class="checkbox-line">
                <input type="checkbox" name="check">
                </td>
                ${Inquiry.id}
            </td>
                <!-- <td>자유 게시판</td> -->
            <td name="inquiryTitle" th:field="${inquiryTitle}">
                <a href="/admin/inquiry-answer?id=${Inquiry.id}">${Inquiry.inquiryTitle}</a>
            </td>
            <td</td>">${Inquiry.inquiryWriterName}</td>
            <td>${Inquiry.inquiryWriterEmail}</td>
            <td>${Inquiry.inquiryDate}</td>
            <td class="is_answer is_warning">
                미답변
                <hr>
                </td>
        `
        text += `
                    </a>
                </div>
            </td>
        `
    });

    $tr.html(text);
});
