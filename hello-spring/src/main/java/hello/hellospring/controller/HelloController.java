package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello") // get 요청
    public String hello(Model model){
        model.addAttribute("data", "hello!!"); // 키가 data(attributeName), 값이 hello(attributeValue)
        return "hello"; // 템플릿에 있는 html 이름
    }
}
