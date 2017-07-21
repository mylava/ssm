import cn.mylava.model.User;
import cn.mylava.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author lipengfei
 */

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mvc.xml", "classpath:spring-mybatis.xml"})
public class TestTran {

    @Autowired
    private UserService userService;

    @Test
    public void test() {
        User user = userService.getUserById(1);
    }

    @Test
    public void tran() {
        User user = new User();
        user.setName("张三1");
        userService.tran(1000,user);
    }



}
