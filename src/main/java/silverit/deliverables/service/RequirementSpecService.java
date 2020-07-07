package silverit.deliverables.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import silverit.deliverables.common.entity.Project;
import silverit.deliverables.common.entity.PropslRequest;
import silverit.deliverables.common.entity.PropslRequirementMppg;
import silverit.deliverables.common.entity.RequirementSpec;
import silverit.deliverables.common.form.RequirementSpecForm;
import silverit.deliverables.repository.PropslRequestRepository;
import silverit.deliverables.repository.PropslRequirementMppgRepository;
import silverit.deliverables.repository.RequirementSpecRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RequirementSpecService {

    final RequirementSpecRepository requirementSpecRepository;
    final PropslRequestRepository propslRequestRepository;
    final PropslRequirementMppgRepository propslRequirementMppgRepository;
//    final ProjectRepository projectRepository;

    /**
     * 요구사항명세 등록
     */
    @Transactional
    public RequirementSpec save(RequirementSpecForm param, Long propslReqNo) {

        //Project Project = projectRepository.findById(prjNo).orElseThrow(() -> new NullPointerException("Project 가 존재하지 않습니다."));

        //요구사항 명세 저장
        RequirementSpec requirementSpec = new RequirementSpec();
        BeanUtils.copyProperties(param, requirementSpec);
        //requirementSpec.copyFromParam(param);

        //제안 요청서 조회
        PropslRequest propslRequest = propslRequestRepository.findById(propslReqNo).orElseThrow(() -> new NullPointerException("제안요청서 정보가 존재하지 않습니다."));
        Project project = propslRequest.getProject();
        requirementSpec.setProject(project);

        //매핑 정보 저장
        PropslRequirementMppg propslRequirementMppg = new PropslRequirementMppg();
        propslRequirementMppg.setPropslRequest(propslRequest);
        propslRequirementMppg.setRequirementSpec(requirementSpec);

        requirementSpec.getPropslRequirementMppgs().add(propslRequirementMppg);

//        propslRequirementMppg.changePropslRequest(propslRequest);
//        propslRequirementMppg.changeRequirementSpec(requirementSpec);

        final RequirementSpec requirementSpeced = requirementSpecRepository.save(requirementSpec);
        propslRequestRepository.save(propslRequest);

        List<PropslRequirementMppg> propslRequirementMppgs = propslRequest.getPropslRequirementMppgs();

        return requirementSpeced;
    }

    /**
     * 요구사항명세 수정
     */
    @Transactional
    public RequirementSpec edit(RequirementSpecForm param) {

        RequirementSpec requirementSpec = requirementSpecRepository.getOne(param.getRequirementNo());
        //Project project = requirementSpec.getProject();

        BeanUtils.copyProperties(param, requirementSpec);

        return requirementSpecRepository.save(requirementSpec);
    }

    


}
