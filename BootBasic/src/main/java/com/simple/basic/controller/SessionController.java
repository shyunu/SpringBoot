package com.simple.basic.controller;

import com.simple.basic.command.UserVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class SessionController {

    @GetMapping("/login")
    public String login() {
        return "user/login";
    }

    @GetMapping("/mypage")
    public String mypage() {
        return "user/mypage";
    }

    @GetMapping("/success")
    public String success(HttpSession session) {
        /*
        //mypage or success 페이지 세션에 값이 없으면 접근하지 못하도록
        UserVO vo = (UserVO)session.getAttribute("usesrVO");
        if(vo == null) {
            return "redirect:/user/login";
        }
        */
        return "user/success";
    }

    @PostMapping("/loginForm")
    public String loginForm(UserVO vo, HttpSession session) {
        //로그인 시도...
        //SELECT * FROM 테이블명 WHERE ID = ? AND PW = ?

        UserVO result = vo; //로그인 성공이라고 가정 (아니면 null로 변경)
        if(result == null) {
            //로그인실패
            return "redirect:/user/login";
        } else {
            //로그인성공 (세션에 회원정보를 저장)
            session.setAttribute("userVO", result);
            return "redirect:/user/success";
        }

    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {

        session.invalidate(); //세션 무효화 (로그아웃기능)
        return "redirect:/user/login";
    }
}
