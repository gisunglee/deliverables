package silverit.deliverables.project.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import silverit.deliverables.common.entity.Output;

public interface ProjectMemberMppgRepository extends JpaRepository<Output, Long> {
}
