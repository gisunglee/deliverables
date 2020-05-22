package silverit.deliverables.project.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import silverit.deliverables.common.entity.Output;
import silverit.deliverables.common.entity.Project;
import silverit.deliverables.common.entity.ProjectMemberMppg;

public interface ProjectRepository extends JpaRepository<ProjectMemberMppg, Long> {
}
