package silverit.deliverables.creatdata;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import silverit.deliverables.common.entity.Member;
import silverit.deliverables.repository.ComponentRepository;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@RequiredArgsConstructor
class Component {

    private final ComponentRepository componentRepository;

    //    @Rollback(false)
    @Transactional(readOnly = false)
    @Test
    public void crudTest(){
        System.out.println("asdf");
        System.out.println("asdf");

    }

    public Member createMember(String i){
        Member member = new Member();
        member.setMemberNm(String.valueOf(UUID.randomUUID()));
        member.setAdvntg(i);
        return member;
    }
}