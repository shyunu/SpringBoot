package com.simple.basic.interceptor;

import com.simple.basic.command.UserVO;
import org.apache.catalina.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserAuthHandler implements HandlerInterceptor {

    // 1.인터셉터로 동작을 하려면 HandlerInterceptor 상속
    // 2.인터셉터를 설정파일에 bean으로 등록하고 인터셉터클래스로 등록
    //ctrl + i (자동오버라이딩)

    //컨트롤러 이전에 동작
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        System.out.println("컨트롤러 이전에 동작");

        //세션 검사 -> 세션이 있으면 로그인된 유저이기 때문에 컨트롤러 연결
        //         -> 세션이 없으면 로그인이 안된 유저이기 때문에 로그인페이지로

        HttpSession session = request.getSession(); //현재 세션
        UserVO vo = (UserVO) session.getAttribute("userVO"); //로그인 성공 시 저장해놓은 세션

        if(vo == null) { //세션이 없다(로그인 X)
            response.sendRedirect("/user/login"); //로그인 페이지로
            return false; //컨트롤러를 동작시키지 않음
        } else { //로그인 O
            return true;
        }



        //return true; //true는 컨트롤러를 동작시키고, false는 컨트롤러를 연결하지 않는다.
    }

    //컨트롤러 이후에 동작
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("컨트롤러 이후에 동작");
    }
}
