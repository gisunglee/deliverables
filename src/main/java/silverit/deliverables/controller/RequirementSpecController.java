package silverit.deliverables.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import silverit.deliverables.common.entity.Project;
import silverit.deliverables.common.entity.PropslRequest;
import silverit.deliverables.common.entity.RequirementSpec;
import silverit.deliverables.common.form.ProjectForm;
import silverit.deliverables.common.form.PropslRequestForm;
import silverit.deliverables.common.form.RequirementSpecForm;
import silverit.deliverables.project.repository.ProjectRepository;
import silverit.deliverables.project.repository.PropslRequestRepository;
import silverit.deliverables.project.repository.RequirementSpecRepository;
import silverit.deliverables.service.RequirementSpecService;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class RequirementSpecController {

    final RequirementSpecRepository requirementSpecRepository;
    final RequirementSpecService requirementSpecService;

    final PropslRequestRepository propslRequestRepository;


    /**
     * 리스트
     * @param model
     * @return
     */
    @RequestMapping("/requirementSpec/list")
    public String list(Model model){

        List<RequirementSpec> requirementSpecList = requirementSpecRepository.findAll();

        model.addAttribute("requirementSpecList", requirementSpecList);

        return "biz/requirementSpec/list";
    }

    /**
     * 등록 화면 이동
     * @param requirementSpecForm
     * @param model
     * @return
     */
    @RequestMapping("/requirementSpec/goAdd")
    public String goAdd(RequirementSpecForm requirementSpecForm, Model model){

        //제안요청서 목록 조회
        List<PropslRequest> propslRequestList = propslRequestRepository.findAll();
        model.addAttribute("propslRequestList", propslRequestList);

        return "biz/requirementSpec/add";
    }

    /**
     * 저장
     * @param requirementSpecForm
     * @return
     */
    @PostMapping("/requirementSpec/add")
    public @ResponseBody RequirementSpecForm add(@ModelAttribute("requirementSpecForm") RequirementSpecForm requirementSpecForm, Long prjNo){

        RequirementSpec requirementSpec = requirementSpecService.save(requirementSpecForm, prjNo);

        BeanUtils.copyProperties(requirementSpec, requirementSpecForm);

        return requirementSpecForm;
    }


    /**
     * 상세화면이동
     * @param dataKey
     * @param model
     * @return
     */
    @GetMapping("/requirementSpec/goView/{dataKey}")
    public String goView(@PathVariable Long dataKey, Model model){

        Optional<RequirementSpec> requirementSpec = requirementSpecRepository.findById(dataKey);
        Project project = requirementSpec.orElse(null).getProject();

        RequirementSpecForm requirementSpecForm = new RequirementSpecForm();
        ProjectForm projectForm = new ProjectForm();
        BeanUtils.copyProperties(requirementSpec.get(), requirementSpecForm);
        BeanUtils.copyProperties(project, projectForm);

        model.addAttribute("requirementSpec", requirementSpecForm);
        model.addAttribute("project", projectForm);

        return "biz/requirementSpec/view";
    }

    /**
     * 수정화면이동
     * @param dataKey
     * @param model
     * @return
     */
    @GetMapping("/requirementSpec/goEdit/{dataKey}")
    public String goEdit(@PathVariable Long dataKey, Model model){

        Optional<RequirementSpec> requirementSpec = requirementSpecRepository.findById(dataKey);

        RequirementSpecForm requirementSpecForm = new RequirementSpecForm();
        BeanUtils.copyProperties(requirementSpec.get(), requirementSpecForm);

        model.addAttribute("requirementSpec", requirementSpecForm);

        return "biz/requirementSpec/edit";
    }

    /**
     * 수정
     * @param requirementSpecForm
     * @return
     */
    @PostMapping("/requirementSpec/edit")
    public @ResponseBody RequirementSpecForm edit(@ModelAttribute("requirementSpecForm") RequirementSpecForm requirementSpecForm, Long prjNo){

        RequirementSpec requirementSpec = requirementSpecService.edit(requirementSpecForm);

        BeanUtils.copyProperties(requirementSpec, requirementSpecForm);

        return requirementSpecForm;
    }

}
