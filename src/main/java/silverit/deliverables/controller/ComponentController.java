package silverit.deliverables.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import silverit.deliverables.common.entity.Component;
import silverit.deliverables.common.entity.Project;
import silverit.deliverables.common.form.ComponentForm;
import silverit.deliverables.repository.ComponentRepository;
import silverit.deliverables.repository.ProjectRepository;
import silverit.deliverables.service.ComponentService;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import static org.springframework.util.StringUtils.*;

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

    @RequestMapping("/component/add")
    public String add(Model model){

        //프로젝트 목록 조회
        List<Project> projectList = projectRepository.findAll();
        model.addAttribute("projectList", projectList);

        String rVal = String.valueOf(System.currentTimeMillis()).substring(10, String.valueOf(System.currentTimeMillis()).length());

        //샘플 데이터 생성
        Component component = new Component();
        component.setComponentNm("통하징수" + rVal);
        component.setComponentAbbrNm("LEVY");
        component.setComponentDc(UUID.randomUUID().toString());
        component.setProject(projectList.get(0));
        componentRepository.save(component);

        List<Component> componentList =  componentRepository.findByProject(projectList.get(0));
        model.addAttribute("componentList", componentList);
        return "biz/component/add1";
    }

    @RequestMapping("/component/add1")
    public String add1(Model model){

        //프로젝트 목록 조회
        List<Project> projectList = projectRepository.findAll();
        model.addAttribute("projectList", projectList);

        //컴포넌트 목록 조회
//        List<Component> componentList = componentRepository.findAll();
//        model.addAttribute("componentList", componentList);

        List<Component> componentList =  componentRepository.findByProject(projectList.get(0));

        return "biz/component/add1";
    }

    /**
     * 컴포넌트 등록
     * @param
     * @return
     */
    @PostMapping("/component/save")
    public @ResponseBody ComponentForm save(
             @RequestParam("isChgYnId") String[] isChgYnId
            , @RequestParam("oriComponentNm1") String[] oriComponentNm1
            , @RequestParam("oriComponentNm1") String[] oriComponentNm2
            , @RequestParam("oriComponentNm1") String[] oriComponentNm3
            , @RequestParam("oriComponentNm1") String[] oriComponentNm4
            , @RequestParam("componentNo1") String[] componentNo1
            , @RequestParam("componentNo2") String[] componentNo2
            , @RequestParam("componentNo3") String[] componentNo3
            , @RequestParam("componentNo4") String[] componentNo4
            , @RequestParam("componentNm1") String[] componentNm1
            , @RequestParam("componentNm2") String[] componentNm2
            , @RequestParam("componentNm3") String[] componentNm3
            , @RequestParam("componentNm4") String[] componentNm4
    ){

        //row 가 존재할때 동작
        if(isChgYnId != null && isChgYnId.length > 0){
            //화면에서 1, 2, 3, 4 동일한값이 중복되면 Alert 시켜줘야 할듯

            //지금 데이터가 저장상태였는가?
            //지금 데이터에 변경이 생겼는가? - 값이 변경되었는가?

            for(int row = 0; row<componentNm1.length; row++){

                //값 존재시
                if(!isEmpty(trimAllWhitespace(componentNo1[row]))){

                }
//                String oriVal = oriComponentNm1[row];
//                String newVal = componentNm1[row];




            }



        }




//        BeanUtils.copyProperties(component, componentForm);

        return null;
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
