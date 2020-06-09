package silverit.deliverables.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import silverit.deliverables.common.entity.Project;
import silverit.deliverables.common.form.ProjectForm;
import silverit.deliverables.project.repository.ProjectRepository;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;


    /**
     * 프로젝트 등록
     */
    @Transactional
    public Long order(Long memberId, Long itemId, int count){


        return memberId;

    }

    @Transactional
    public Project save(ProjectForm param) {
        Project project = new Project();
        project.setPrjNm(param.getPrjNm());
        project.setPrjBeginDe(param.getPrjBeginDe());
        project.setPrjEndDe(param.getPrjEndDe());
        project.setPrjEngCdNm(param.getPrjEngCdNm());

        Project savedProject = projectRepository.save(project);

        return savedProject;
    }
}
