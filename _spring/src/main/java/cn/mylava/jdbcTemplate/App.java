package cn.mylava.jdbcTemplate;

import com.mysql.jdbc.Driver;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lipengfei
 */
public class App {


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

//        DataSource dataSource = (DataSource) context.getBean("dataSource");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
        App app = new App();
        app.insert(jdbcTemplate);

    }

    public void insert(JdbcTemplate jdbcTemplate){
        String sql = "insert into user(name) values(?)";
        List<Object[]> batchArgs = new ArrayList<>();
        batchArgs.add(new Object[]{"AA"});
        batchArgs.add(new Object[]{"BB"});

        jdbcTemplate.batchUpdate(sql,batchArgs);
    }
}
