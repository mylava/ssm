import cn.mylava.model.User;
import cn.mylava.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lipengfei
 */
public class App {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-mybatis.xml");

//        Object obj = SpringUtil.getObject("master");
//        System.out.println(obj);
//        UserService service = (UserService) context.getBean("userService");
//
//        service.test();

        UserService userService = (UserService) context.getBean("userService");
        User user = userService.getUserById(1);


    }

}
