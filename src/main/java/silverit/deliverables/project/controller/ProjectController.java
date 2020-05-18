package silverit.deliverables.project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import silverit.deliverables.common.entity.Project;
import silverit.deliverables.project.repository.ProjectRepository;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectRepository projectRepository;

    @GetMapping("/hello")
    public String hello(){

        Project project = new Project();
        project.setName("a");
        projectRepository.save(project);

        List<Project> projectList = projectRepository.findAll();

        System.out.println("================" + projectList.size() + "================");

        return "hello";
    }
}
