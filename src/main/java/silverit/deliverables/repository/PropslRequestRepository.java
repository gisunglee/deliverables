package silverit.deliverables.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import silverit.deliverables.common.entity.PropslRequest;

public interface PropslRequestRepository extends JpaRepository<PropslRequest, Long> {
}
