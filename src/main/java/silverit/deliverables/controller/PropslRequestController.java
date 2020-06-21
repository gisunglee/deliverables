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
import silverit.deliverables.service.ProjectService;
import silverit.deliverables.service.PropslRequestService;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class PropslRequestController {

    final PropslRequestRepository propslRequestRepository;
    final PropslRequestService propslRequestService;


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
    public String add(PropslRequestForm propslRequestForm, Model model){

        return "biz/propslRequest/add";
    }

    /**
     * 저장
     * @param propslRequestForm
     * @return
     */
    @PostMapping("/propslRequest/add")
    public @ResponseBody PropslRequestForm save(@ModelAttribute("propslRequestForm") PropslRequestForm propslRequestForm, Long prjNo){

        PropslRequest propslRequest = propslRequestService.save(propslRequestForm, prjNo);

        BeanUtils.copyProperties(propslRequest, propslRequestForm);

        return propslRequestForm;
    }

    /**
     * 상세보기
     * @param dataKey
     * @param model
     * @return
     */
    @GetMapping("/propslRequest/view/{dataKey}")
    public String view(@PathVariable Long dataKey, Model model){

        Optional<PropslRequest> propslRequest = propslRequestRepository.findById(dataKey);

        PropslRequestForm propslRequestForm = new PropslRequestForm();
        BeanUtils.copyProperties(propslRequest, propslRequestForm);

        model.addAttribute("propslRequest", propslRequestForm);

        return "biz/propslRequest/view";
    }

}
