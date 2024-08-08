package com.simple.basic.controller;

import com.simple.basic.command.TestVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

@Controller
@RequestMapping("/view") //templates.view
public class ThymeleafController {

    @GetMapping("/ex01")
    public String ex01() {
        return "view/ex01";
    }

    @GetMapping("/ex02")
    public String ex02(Model model) {

        ArrayList<TestVO> list = new ArrayList<>();
        for(int i = 1; i <= 10; i++) {
            TestVO vo = TestVO.builder()
                    .num(i)
                    .name("홍"+ i)
                    .addr("서울시" + i)
                    .age(20 + i)
                    .build();

            list.add(vo);
        }
        model.addAttribute("list", list); //list를 모델에 저장
        return "view/ex02";
    }

    @GetMapping("/ex03")
    public String ex03(Model model) {

        ArrayList<TestVO> list = new ArrayList<>();
        for(int i = 1; i <= 10; i++) {
            TestVO vo = TestVO.builder()
                    .num(i)
                    .name("홍"+ i)
                    .addr("서울시" + i)
                    .age(20 + i)
                    .build();

            list.add(vo);
        }
        model.addAttribute("list", list); //list를 모델에 저장
        return "view/ex03";
    }

    @GetMapping("/ex03_result")
    public String result() {
        return "view/ex03_result";
    }

    @GetMapping("/ex03_result2/{name}/{age}") //가변매개변수는 {} 중괄호로 묶는다
    public String result2(@PathVariable("name") String name,
                          @PathVariable("age") int age) {

        System.out.println(name + "-" + age);

        return "view/ex03_result";
    }

    @GetMapping("/ex04")
    public String eg04(Model model) {

        TestVO vo = TestVO.builder()
                .num(1)
                .name("홍")
                .addr("서울시")
                .age(20)
                .build();

        model.addAttribute("name", "홍길동");
        model.addAttribute("arr", new Integer[] {1,2,3});
        model.addAttribute("vo", vo);

        model.addAttribute("list", Arrays.asList(1,2,3,4));
        model.addAttribute("now", new Date());

        return "view/ex04";
    }

    @GetMapping("/ex05")
    public String ex05() {
        return "view/ex05";
    }

    @GetMapping("/ex06")
    public String ex06() {
        return "view/ex06";
    }

    @GetMapping("/quiz01")
    public String quiz01(Model model) {
        TestVO vo = TestVO.builder()
                .num(10)
                .name("홍길동")
                .addr("서울시")
                .age(30)
                .build();

        model.addAttribute("vo", vo);
        return "view/quiz01";
    }

    @GetMapping("/quiz_result01")
    public String result2(@ModelAttribute("num") String num) {
        return "view/quiz_result01";
    }
}
