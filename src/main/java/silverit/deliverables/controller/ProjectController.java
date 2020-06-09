package silverit.deliverables.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import silverit.deliverables.common.entity.Project;
import silverit.deliverables.common.form.ProjectForm;
import silverit.deliverables.project.repository.ProjectRepository;
import silverit.deliverables.service.ProjectService;
import sun.rmi.runtime.Log;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequiredArgsConstructor
public class ProjectController {

    final ProjectRepository projectRepository;
    final ProjectService projectService;
    
    
    @RequestMapping("/project/list")
    public String list(Model model){
        //프로젝트 목록 조회
        List<Project> projectList = projectRepository.findAll();

        model.addAttribute("projectList", projectList);

        return "biz/project/list";
    }

    @RequestMapping("/project/goAdd")
    public String add(ProjectForm projectForm, Model model){

        return "biz/project/add";
    }


    @PostMapping("/project/add")
    public @ResponseBody ProjectForm save(@ModelAttribute("projectForm") ProjectForm projectForm, Project p, Model model, String prjNm){

        Project project = projectService.save(projectForm);

        BeanUtils.copyProperties(project, projectForm);

        System.out.println(projectForm.getPrjNm());
        System.out.println(projectForm.getPrjNm());
        System.out.println(projectForm.getPrjNm());
        System.out.println(projectForm.getPrjNm());

        return projectForm;
    }

}
