package silverit.deliverables.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProjectController {

    @RequestMapping("project/list")
    public String goProjectList(){

        return "biz/project/list";
    }
}
