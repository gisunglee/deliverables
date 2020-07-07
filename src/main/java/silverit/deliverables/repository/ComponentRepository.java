package silverit.deliverables.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import silverit.deliverables.common.entity.Component;

public interface ComponentRepository extends JpaRepository<Component, Long> {
}
