package cn.mylava;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lipengfei
 */

public class _001_SpringTest {

    @Before
    public void before(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    }

    @Test
    public void instanceSpring(){
        System.out.println("日志信息没有异常，表明spring容器创建成功！");
    }
}
