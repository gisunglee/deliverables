package silverit.deliverables.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import silverit.deliverables.common.entity.Project;
import silverit.deliverables.common.entity.PropslRequest;
import silverit.deliverables.common.form.PropslRequestForm;
import silverit.deliverables.repository.ProjectRepository;
import silverit.deliverables.repository.PropslRequestRepository;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PropslRequestService {

    final PropslRequestRepository propslRequestRepository;
    final ProjectRepository projectRepository;

    /**
     * 제안요청서 등록
     */
    @Transactional
    public PropslRequest save(PropslRequestForm param, Long prjNo) {

        Project Project = projectRepository.findById(prjNo).orElseThrow(() -> new NullPointerException("Project 가 존재하지 않습니다."));

        PropslRequest propslRequest = new PropslRequest();

        //프로젝트 존재시 프로젝트 설정
        BeanUtils.copyProperties(param, propslRequest);
        propslRequest.setProject(Project);

        return propslRequestRepository.save(propslRequest);
    }

    /**
     * 제안요청서 수정
     */
    @Transactional
    public PropslRequest edit(PropslRequestForm param) {

        PropslRequest propslRequest = propslRequestRepository.getOne(param.getPropslReqNo());
        //Project project = propslRequest.getProject();

        BeanUtils.copyProperties(param, propslRequest);

        return propslRequestRepository.save(propslRequest);
    }

    


}
