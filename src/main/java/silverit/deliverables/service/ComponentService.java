package silverit.deliverables.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import silverit.deliverables.common.entity.Component;
import silverit.deliverables.common.entity.Project;
import silverit.deliverables.common.form.ComponentForm;
import silverit.deliverables.common.form.ProjectForm;
import silverit.deliverables.repository.ProjectRepository;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ComponentService {

    private final ProjectRepository projectRepository;


    /**
     * 컴포넌트 등록
     */
    @Transactional
    public Component save(ComponentForm param) {
        return null;
    }
}
