package silverit.deliverables.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import silverit.deliverables.common.entity.Project;
import silverit.deliverables.common.entity.RequirementSpec;
import silverit.deliverables.common.form.RequirementSpecForm;
import silverit.deliverables.project.repository.ProjectRepository;
import silverit.deliverables.project.repository.RequirementSpecRepository;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RequirementSpecService {

    final RequirementSpecRepository requirementSpecRepository;
//    final ProjectRepository projectRepository;

    /**
     * 요구사항명세 등록
     */
    @Transactional
    public RequirementSpec save(RequirementSpecForm param, Long prjNo) {

//        Project Project = projectRepository.findById(prjNo).orElseThrow(() -> new NullPointerException("Project 가 존재하지 않습니다."));

        RequirementSpec requirementSpec = new RequirementSpec();

        //프로젝트 존재시 프로젝트 설정
        BeanUtils.copyProperties(param, requirementSpec);
//        requirementSpec.setProject(Project);

        return requirementSpecRepository.save(requirementSpec);
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
