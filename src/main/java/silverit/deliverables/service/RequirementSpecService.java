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
import silverit.deliverables.project.repository.ProjectRepository;
import silverit.deliverables.project.repository.PropslRequestRepository;
import silverit.deliverables.project.repository.RequirementSpecRepository;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RequirementSpecService {

    final RequirementSpecRepository requirementSpecRepository;
    final PropslRequestRepository propslRequestRepository;
//    final ProjectRepository projectRepository;

    /**
     * 요구사항명세 등록
     */
    @Transactional
    public RequirementSpec save(RequirementSpecForm param, Long propslReqNo) {

//        Project Project = projectRepository.findById(prjNo).orElseThrow(() -> new NullPointerException("Project 가 존재하지 않습니다."));

        //요구사항 명세 저장
        RequirementSpec requirementSpec = new RequirementSpec();
        BeanUtils.copyProperties(param, requirementSpec);
        final RequirementSpec requirementSpeced = requirementSpecRepository.save(requirementSpec);

        //제안 요청서 조회
        PropslRequest propslRequest = propslRequestRepository.getOne(propslReqNo);

        //매핑 정보 저장
        PropslRequirementMppg propslRequirementMppg = new PropslRequirementMppg();
        propslRequirementMppg.changePropslRequest(propslRequest);
        propslRequirementMppg.changeRequirementSpec(requirementSpeced);
        propslRequestRepository.save(propslRequest);

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
