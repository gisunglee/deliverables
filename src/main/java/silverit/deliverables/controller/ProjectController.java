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
import sun.rmi.runtime.Log;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Controller
@RequiredArgsConstructor
public class ProjectController {

    final ProjectRepository projectRepository;
    final ProjectService projectService;

    /**
     * 프로젝트 목록
     * @param model
     * @return
     */
    @RequestMapping("/project/list")
    public String list(Model model){

        List<Project> projectList = projectRepository.findAll();

        model.addAttribute("projectList", projectList);

        return "biz/project/list";
    }

    /**
     * 프로젝트 등록 화면 이동
     * @param projectForm
     * @param model
     * @return
     */
    @RequestMapping("/project/goAdd")
    public String add(ProjectForm projectForm, Model model){

        return "biz/project/add";
    }

    /**
     * 프로젝트 등록
     * @param projectForm
     * @return
     */
    @PostMapping("/project/add")
    public @ResponseBody ProjectForm save(@ModelAttribute("projectForm") ProjectForm projectForm){

        Project project = projectService.save(projectForm);

        BeanUtils.copyProperties(project, projectForm);

        return projectForm;
    }

    /**
     * 프로젝트
     * @param dataKey
     * @param model
     * @return
     */
    @GetMapping("/project/view/{dataKey}")
    public String view(@PathVariable Long dataKey, Model model){

        Optional<Project> project = projectRepository.findById(dataKey);
        ProjectForm projectForm = new ProjectForm();
        BeanUtils.copyProperties(project, projectForm);

        model.addAttribute("project", projectForm);

        return "biz/project/view";
    }

}
