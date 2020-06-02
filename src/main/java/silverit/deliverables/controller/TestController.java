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

    //---------------------------------------------------------------------------------

    @GetMapping("/hello")
    public String goHello(){

        return "hello";
    }
    @GetMapping("/hello2")
    public String goHello2(){

        return "hello2";
    }


    @GetMapping("/biz/hello")
    public String goBizHello(){

        return "biz/hello";
    }

    @GetMapping("/biz/hello1")
    public String goBizHello1(){

        return "biz/hello2";
    }

    @GetMapping("/biz/hello2")
    public String goBizHello2(){

        return "biz/hello2";
    }

    @GetMapping("/biz/test")
    public String goBizTest(){

        return "biz/test";
    }


}
