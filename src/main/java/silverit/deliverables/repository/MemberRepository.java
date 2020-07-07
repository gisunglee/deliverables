package silverit.deliverables.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import silverit.deliverables.common.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
