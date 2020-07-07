package silverit.deliverables.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import silverit.deliverables.common.entity.Activity;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
}
