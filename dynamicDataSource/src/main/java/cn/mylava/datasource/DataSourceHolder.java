package cn.mylava.datasource;

import javafx.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;
import javax.swing.*;

/**
 * @author lipengfei
 */
@Component
public class DataSourceHolder {
    private static final ThreadLocal<String> holder = new ThreadLocal<String>();

    public static final String MASTER_DATA_SOURCE = "masterDataSource";

    public static final String SLAVE_DATA_SOURCE = "slaveDataSource";


    public static String getDBType() {
        String dbType = holder.get();
        return dbType;
    }

    public static void setDBType(String dbType) {
        holder.set(dbType);
    }

    public static Object switchDataSource() {
        return SpringUtil.getObject(holder.get());
    }

    public static void clearDBType() {
        holder.remove();
    }

}
