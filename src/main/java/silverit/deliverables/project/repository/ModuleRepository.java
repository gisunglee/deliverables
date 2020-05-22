package silverit.deliverables.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import silverit.deliverables.common.entity.Menu;
import silverit.deliverables.common.entity.Module;

public interface ModuleRepository extends JpaRepository<Module, Long> {
}
