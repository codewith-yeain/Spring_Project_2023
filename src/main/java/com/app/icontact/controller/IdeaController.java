package com.app.icontact.controller;

import com.app.icontact.DTO.IdeaDTO4;
import com.app.icontact.DTO.Pagination;
import com.app.icontact.DTO.Search;
import com.app.icontact.domain.IdeaList;
import com.app.icontact.domain.IdeaVO;
import com.app.icontact.domain.UserVO;
import com.app.icontact.exception.LoginFailedException;
import com.app.icontact.service.IdeaService;
import com.app.icontact.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.jdbc.Null;
import org.springframework.expression.spel.ast.NullLiteral;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/idea/*")
public class IdeaController {
    private final IdeaService ideaService;
    private final UserService userService;
    private final HttpSession session;

    @GetMapping("detail")
    public void detail(Long id, Pagination pagination, Search search, Model model){
        model.addAttribute("idea", ideaService.read(id).get());
    }

    @GetMapping("ideaBank")
    public void ideaList(Pagination pagination, Search search, Model model){
        if(search.getIdeaCategory() == null){
            search.setIdeaCategory(1L);
        }

        pagination.setTotal(ideaService.getTotal(search));
        pagination.progress();

        model.addAttribute("ideas", ideaService.getList(pagination, search));
        model.addAttribute("total", ideaService.getTotal(search));
    }

    @PostMapping("ideaBank")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> ideaReList(@RequestBody IdeaList ideaList){
        System.out.println("------------------------------");
        System.out.println("페이지" + ideaList.getPage());
        System.out.println("카테고리" + ideaList.getIdeaCategory()); //Object여서 형 변환
        System.out.println("가격" + ideaList.getIdeaPrice());
        System.out.println("최대 협의자수" + ideaList.getIdeaMax());
        System.out.println("정렬" + ideaList.getOrder());
        System.out.println("------------------------------");

        Pagination pagination = new Pagination();
        Search search = new Search();

        search.setIdeaPrice(ideaList.getIdeaPrice());
        search.setIdeaCategory(ideaList.getIdeaCategory());
        search.setOrder(ideaList.getOrder());
        search.setIdeaMax(ideaList.getIdeaMax());

        Map<String, Object> response = new HashMap<>();
        pagination.setTotal(ideaService.getTotal(search));
        pagination.progress();

        response.put("ideas", ideaService.getList(pagination, search));
        response.put("total", ideaService.getTotal(search));
        response.put("pagination", pagination);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

//    @PostMapping("ideaBank/{page}/{ideaCategory}/{ideaPrice}/{ideaMax}/{order}")
//    public List<IdeaDTO4> list(Pagination pagination, Search search){
//        pagination.setTotal(ideaService.getTotal(search));
//        pagination.progress();
//        return ideaService.getList(pagination, search);
//    }

    @GetMapping("update")
    public void goToUpdateIdeaForm(){;}

    @PostMapping("update")
    public RedirectView update(IdeaVO ideaVO, RedirectAttributes redirectAttributes){
        return new RedirectView("/idea/detail");
    }

    @GetMapping("write")
    public void goToWriteIdeaForm(IdeaDTO4 ideaDTO4, Model model){
        String sessionId = (String)session.getAttribute("id");
        Long id = Long.parseLong(sessionId);
        model.addAttribute("id", id);

        model.addAttribute("userNickname", userService.getUser(id).get().getUserNickname());
    }

    @PostMapping("write")
    public RedirectView write(IdeaDTO4 ideaDTO4){
        log.info(ideaDTO4.toString());

        String sessionId = (String)session.getAttribute("id");
        Long id = Long.parseLong(sessionId);

        ideaDTO4.setUserId(id);
        ideaService.write(ideaDTO4);
        return new RedirectView("/idea/ideaBank");
    }


}
