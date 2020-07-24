package silverit.deliverables.repository;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import silverit.deliverables.service.ComponentService;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)  // (1)
@DataJpaTest
@RequiredArgsConstructor
class ComponentRepositoryTest {

    final ComponentService componentService;

    @Test
    @Transactional(readOnly = false)
    public void createComponent(){

        System.out.println("Asdf");
    }

}