package silverit.deliverables.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import silverit.deliverables.common.entity.Project;
import silverit.deliverables.common.form.ProjectForm;
import silverit.deliverables.project.repository.ProjectRepository;
import silverit.deliverables.service.ProjectService;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class SessionController {

    final ProjectRepository projectRepository;
    final ProjectService projectService;

    /**
     * 프로젝트 세션 설정
     * @param model
     * @return
     */
    @RequestMapping("/session")
    public String list(Model model, HttpSession session){


        List<Project> projectList = projectRepository.findAll();

        //임시로 프로젝트 설정
        session.setAttribute("prjNo", projectList.get(0).getPrjNo());


        return "redirect:/requirementSpec/list";
    }

}
