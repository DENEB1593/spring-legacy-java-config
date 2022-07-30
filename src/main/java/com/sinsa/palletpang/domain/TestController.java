package com.sinsa.palletpang.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    private final TestMapper testMapper;

    @Autowired
    public TestController(TestMapper testMapper) {
        this.testMapper = testMapper;
    }

    @RequestMapping("/")
    public String index(Model model) {
        String result = testMapper.select();
        model.addAttribute("result", result);
        return "index";
    }

    @RequestMapping("/admin")
    public String admin() {
        return "admin";
    }

}
