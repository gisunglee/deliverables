package silverit.deliverables.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/s/boooda/index")
    public String goSBooodaIndex(){
        return "boooda/index";
    }


    @GetMapping("/boooda/index")
    public String goBooodaIndex(){
        return "index";
    }

    @GetMapping("/boooda/forms-wysiwyg-editors")
    public String formsWysiwygEditors(){
        return "/test/forms-wysiwyg-editors";
    }


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

    @GetMapping("/hello3")
    public String goHello3(){

        return "fragments/main/content";
    }
}
