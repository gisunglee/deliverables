package silverit.deliverables.creatdata;


import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;
import silverit.deliverables.repository.ComponentRepository;

@DataJpaTest
@RequiredArgsConstructor

class Component {

    private final ComponentRepository componentRepository;

    // @Rollback(false)
    @Transactional(readOnly = false)
    @Test
    public void crudTest(){
        System.out.println("asdf");
        System.out.println("asdf");

    }

    public Component createMember(String i){

        Component component = new Component();
        component.


        return member;
    }
}