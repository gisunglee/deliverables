package silverit.deliverables.project.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import silverit.deliverables.common.entity.PropslRequest;
import silverit.deliverables.common.entity.PropslRequirementMppg;

public interface PropslRequirementMppgRepository extends JpaRepository<PropslRequirementMppg, Long> {
}
