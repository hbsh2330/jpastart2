package com.example.jpastart2.controller;

import com.example.jpastart2.dto.WriteDto;
import com.example.jpastart2.entity.User;
import com.example.jpastart2.service.WriteService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@Slf4j
public class WriteController {

    @Autowired
    private WriteService writeService;
    User user1;
    @GetMapping("/write")
    public String GetWrite(HttpSession session, Model model){
        log.info("GET/ WRITE");
        Object userObj = session.getAttribute("user");
        if (userObj == null){
            return "/index";
        }else {
            User user = (User)userObj;
            model.addAttribute("user", user);
            user1 = user;
            return "/write";
        }
    }
    @PostMapping("/write")
    public String PostWrite(WriteDto writeDto){
        System.out.println(user1);
        writeService.write(writeDto, user1);
        return "/write";
    }
}
