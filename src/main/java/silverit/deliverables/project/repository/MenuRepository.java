package silverit.deliverables.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import silverit.deliverables.common.entity.Menu;

public interface MenuRepository extends JpaRepository<Menu, Long> {
}
