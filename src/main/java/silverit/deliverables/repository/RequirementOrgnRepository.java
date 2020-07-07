package silverit.deliverables.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import silverit.deliverables.common.entity.RequirementOrgn;

public interface RequirementOrgnRepository extends JpaRepository<RequirementOrgn, Long> {
}
