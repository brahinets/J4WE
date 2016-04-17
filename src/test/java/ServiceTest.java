import com.ysb.j2we.Service;
import org.junit.Assert;
import org.junit.Test;

public class ServiceTest {

    @Test
    public void msgTest(){
        String message = new Service().getMessage();
        Assert.assertEquals(message, "2 b || ! 2 b");
    }
}