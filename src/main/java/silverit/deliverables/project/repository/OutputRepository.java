package silverit.deliverables.project.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import silverit.deliverables.common.entity.Project;

public interface OutputRepository extends JpaRepository<Project, Long> {
}
