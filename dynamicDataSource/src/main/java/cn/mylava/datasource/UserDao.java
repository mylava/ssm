package cn.mylava.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lipengfei
 */
@Repository
public class UserDao {
//    @Autowired
    private JdbcTemplate jdbcTemplate;



    public void addUser() {
        String sql = "insert into user(name) values(?)";
        List<Object[]> batchArgs = new ArrayList<>();
        batchArgs.add(new Object[]{"JJ"});
        Object obj = DataSourceHolder.switchDataSource();
        if (obj != null && obj instanceof DataSource) {
            jdbcTemplate.setDataSource((DataSource) obj);
        }
        jdbcTemplate.batchUpdate(sql,batchArgs);
    }

    public String findUser() {
        String sql = "select name from  user where id = 1000";
        Object obj = DataSourceHolder.switchDataSource();
        if (obj != null && obj instanceof DataSource) {
            jdbcTemplate.setDataSource((DataSource) obj);
        }
        return jdbcTemplate.queryForObject(sql, new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                System.out.println(rs.getString(1));
                return rs.getString(1);
            }
        });
    }

}
