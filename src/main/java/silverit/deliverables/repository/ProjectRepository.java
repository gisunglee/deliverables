package silverit.deliverables.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import silverit.deliverables.common.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
