package silverit.deliverables.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/test")
    public String goTest(){

        return "fragments/layout/defaultLayout";
    }


    @GetMapping("/hello1")
    public String goHello1(){

        return "hello";
    }
    @GetMapping("/hello2")
    public String goHello2(){

        return "fragments/layout/hello";
    }
}
