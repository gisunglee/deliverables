package silverit.deliverables.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import silverit.deliverables.common.entity.RequirementSpec;

public interface RequirementSpecRepository extends JpaRepository<RequirementSpec, Long> {
}
