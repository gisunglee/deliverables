package silverit.deliverables.project.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import silverit.deliverables.common.entity.ProjectMemberMppg;
import silverit.deliverables.common.entity.Step;

public interface StepRepository extends JpaRepository<Step, Long> {
}
