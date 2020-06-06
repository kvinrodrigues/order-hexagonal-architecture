package py.com.poraplz.cursomc;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import py.com.poraplz.cursomc.shared.infraestructure.InfrastructureTestCase;

@ContextConfiguration(classes = OrderManagementApplication.class)
@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest
public abstract class OrderManagementInfrastructureTestCase extends InfrastructureTestCase {
}
