package silverit.deliverables.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import silverit.deliverables.common.entity.Project;
import silverit.deliverables.common.entity.PropslRequest;
import silverit.deliverables.common.form.ProjectForm;
import silverit.deliverables.common.form.PropslRequestForm;
import silverit.deliverables.project.repository.ProjectRepository;
import silverit.deliverables.project.repository.PropslRequestRepository;
import silverit.deliverables.service.PropslRequestService;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class PropslRequestController {

    final PropslRequestRepository propslRequestRepository;
    final PropslRequestService propslRequestService;

    final ProjectRepository projectRepository;


    /**
     * 리스트
     * @param model
     * @return
     */
    @RequestMapping("/propslRequest/list")
    public String list(Model model){

        List<PropslRequest> propslRequestList = propslRequestRepository.findAll();

        model.addAttribute("propslRequestList", propslRequestList);

        return "biz/propslRequest/list";
    }

    /**
     * 등록 화면 이동
     * @param propslRequestForm
     * @param model
     * @return
     */
    @RequestMapping("/propslRequest/goAdd")
    public String goAdd(PropslRequestForm propslRequestForm, Model model){

        //프로젝트 목록 조회
        List<Project> projectList = projectRepository.findAll();
        model.addAttribute("projectList", projectList);

        return "biz/propslRequest/add";
    }

    /**
     * 저장
     * @param propslRequestForm
     * @return
     */
    @PostMapping("/propslRequest/add")
    public @ResponseBody PropslRequestForm add(@ModelAttribute("propslRequestForm") PropslRequestForm propslRequestForm, Long prjNo){

        PropslRequest propslRequest = propslRequestService.save(propslRequestForm, prjNo);

        BeanUtils.copyProperties(propslRequest, propslRequestForm);

        return propslRequestForm;
    }


    /**
     * 상세화면이동
     * @param dataKey
     * @param model
     * @return
     */
    @GetMapping("/propslRequest/goView/{dataKey}")
    public String goView(@PathVariable Long dataKey, Model model){

        Optional<PropslRequest> propslRequest = propslRequestRepository.findById(dataKey);
        Project project = propslRequest.orElse(null).getProject();

        PropslRequestForm propslRequestForm = new PropslRequestForm();
        ProjectForm projectForm = new ProjectForm();
        BeanUtils.copyProperties(propslRequest.get(), propslRequestForm);
        BeanUtils.copyProperties(project, projectForm);

        model.addAttribute("propslRequest", propslRequestForm);
        model.addAttribute("project", projectForm);

        return "biz/propslRequest/view";
    }

    /**
     * 수정화면이동
     * @param dataKey
     * @param model
     * @return
     */
    @GetMapping("/propslRequest/goEdit/{dataKey}")
    public String goEdit(@PathVariable Long dataKey, Model model){

        Optional<PropslRequest> propslRequest = propslRequestRepository.findById(dataKey);

        PropslRequestForm propslRequestForm = new PropslRequestForm();
        BeanUtils.copyProperties(propslRequest.get(), propslRequestForm);

        model.addAttribute("propslRequest", propslRequestForm);

        return "biz/propslRequest/edit";
    }

    /**
     * 수정
     * @param propslRequestForm
     * @return
     */
    @PostMapping("/propslRequest/edit")
    public @ResponseBody PropslRequestForm edit(@ModelAttribute("propslRequestForm") PropslRequestForm propslRequestForm, Long prjNo){

        PropslRequest propslRequest = propslRequestService.edit(propslRequestForm);

        BeanUtils.copyProperties(propslRequest, propslRequestForm);

        return propslRequestForm;
    }

}
