package com.example.jpastart2.controller.member;

import com.example.jpastart2.dto.UserDto;
import com.example.jpastart2.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
@RequestMapping("/user")
public class MemberController {

    @Autowired
    private UserService userService;

    @GetMapping("/join")
    public String GetJoin(){
        return "/user/join";
    }
    @PostMapping("/join")
    public String PostJoin(UserDto userDto){
        System.out.println("userDto = " + userDto);
        userService.join(userDto);
        return "index";
    }

    @GetMapping("/login")
    public String GetLogin(){
        return "/user/login";
    }

    @PostMapping("/login")
    public String PostLogin(@RequestParam String id,
                            @RequestParam String password,
                            HttpSession session,
                            Model model){
        if (userService.login(id,password,session)){
            return "/index";
        } else {
            model.addAttribute("message", "아이디 또는 비밀번호가 잘못되었습니다.");
            return "/user/login";
        }

    }

    @GetMapping("/logout")
    public String getLogout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate(); // 현재 세션 무효화
        }
        return "redirect:/"; // 로그아웃 후 메인 페이지로 리다이렉트
    }


}
