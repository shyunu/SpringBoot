package com.coding404.myweb.controller;

import com.coding404.myweb.util.Criteria;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/topic")
public class TopicController {

    @GetMapping("/topicDetail")
    public String topicDetail(Criteria cri) {

        return "topic/topicDetail";
    }

    //--- 등록요청
    @GetMapping("/registForm")
    public String registForm() {




        return "redirect:/topic/topicListAll";
    }


    @GetMapping("/topicListAll")
    public String topicListAll() {
        return "topic/topicListAll";
    }

    @GetMapping("/topicListMe")
    public String topicListMe() {
        return "topic/topicListMe";
    }

    @GetMapping("/topicModify")
    public String topicModify() {
        return "topic/topicModify";
    }

    @GetMapping("/topicReg")
    public String topicReg() {
        return "topic/topicReg";
    }
}
