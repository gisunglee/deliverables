package silverit.deliverables.project.repository;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import silverit.deliverables.common.entity.Member;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)  // (1)
@DataJpaTest
//@SpringBootTest
//@Transactional(readOnly = false)
@Transactional
class MemberRepositoryTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());



    @Autowired
    MemberRepository memberRepository;

    @Before("crudTest")
    public void before(){

    }


//    @Rollback(false)
    @Transactional(readOnly = false)
    @Test
    public void crudTest(){
        System.out.println("asdf");
        System.out.println("asdf");


        for(int i = 0; i < 11; i++){
            memberRepository.save(createMember(String.valueOf(i)));
        }

        //        PageRequest pageRequest = PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC), "memberNo");

        PageRequest pageRequest = PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "memberNo"));
        Page<Member> memberList = memberRepository.findAll(pageRequest);

        logger.debug("===============" + memberList.getSize() + "===============");

        memberRepository.flush();
        assertTrue(memberList.getSize() > 0);
    }

    public Member createMember(String i){
        Member member = new Member();
        member.setMemberNm(String.valueOf(UUID.randomUUID()));
        member.setAdvntg(i);
        return member;
    }
}