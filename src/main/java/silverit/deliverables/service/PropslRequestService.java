package silverit.deliverables.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import silverit.deliverables.common.entity.Project;
import silverit.deliverables.common.entity.PropslRequest;
import silverit.deliverables.common.form.PropslRequestForm;
import silverit.deliverables.project.repository.ProjectRepository;
import silverit.deliverables.project.repository.PropslRequestRepository;

import java.util.Optional;

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
        // 프로젝트 조회
        Optional<Project> project = findOne(prjNo);

        PropslRequest propslRequest = new PropslRequest();

        //프로젝트 존재시 프로젝트 설정
        if(project.isPresent()){
            BeanUtils.copyProperties(param, propslRequest);
            propslRequest.setProject(project.get());
        }else{
            throw new NullPointerException("Project 가 존재하지 않습니다.");
        }

        return propslRequestRepository.save(propslRequest);
    }

    public Optional<Project> findOne(Long prjNo) {
        return projectRepository.findById(prjNo);
    }
}
