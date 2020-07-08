package silverit.deliverables.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import silverit.deliverables.common.entity.Component;
import silverit.deliverables.common.entity.Project;
import silverit.deliverables.common.form.ComponentForm;
import silverit.deliverables.repository.ComponentRepository;
import silverit.deliverables.repository.ProjectRepository;
import silverit.deliverables.service.ComponentService;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ComponentController {

    final ComponentRepository componentRepository;
    final ComponentService componentService;

    final ProjectRepository projectRepository;

    /**
     * 컴포넌트 목록
     * @param model
     * @return
     */
    @RequestMapping("/component/list")
    public String list(Model model){

        //프로젝트 목록 조회
        List<Project> projectList = projectRepository.findAll();
        model.addAttribute("projectList", projectList);

        //컴포넌트 목록 조회
        List<Component> componentList = componentRepository.findAll();
        model.addAttribute("componentList", componentList);

        return "biz/component/list";
    }

    /**
     * 컴포넌트 등록
     * @param componentForm
     * @return
     */
    @PostMapping("/component/save")
    public @ResponseBody ComponentForm save(@ModelAttribute("componentForm") ComponentForm componentForm){

        Component component = componentService.save(componentForm);

        BeanUtils.copyProperties(component, componentForm);

        return componentForm;
    }

    /**
     * 컴포넌트
     * @param dataKey
     * @param model
     * @return
     */
    @GetMapping("/component/view/{dataKey}")
    public String view(@PathVariable Long dataKey, Model model){

        Optional<Component> component = componentRepository.findById(dataKey);
        ComponentForm componentForm = new ComponentForm();
        BeanUtils.copyProperties(component.get(), componentForm);

        model.addAttribute("component", componentForm);

        return "biz/component/view";
    }

}
