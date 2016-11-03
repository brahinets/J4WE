import com.ysb.j2we.config.J2weApplicationContextConfig;
import com.ysb.j2we.config.J2weSpringWebAppInitializer;
import com.ysb.j2we.model.service.IService;
import com.ysb.j2we.model.service.impl.TestService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {J2weApplicationContextConfig.class, J2weSpringWebAppInitializer.class})
public class ServiceTest {

    @Autowired
    IService service;

    @Test
    public void msgTest(){
        String message1 = new TestService().getMessage();
        Assert.assertEquals(message1, "2 b || ! 2 b");

        String message2 = service.getMessage();
        Assert.assertEquals(message2, "2 b || ! 2 b");
        
        Assert.assertEquals(message1, message2);
    }
}