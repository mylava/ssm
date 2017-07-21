package cn.mylava.datasource;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author lipengfei
 */
public class DataSourceSwitchAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        DataSourceHolder.setDBType(DataSourceHolder.SLAVE_DATA_SOURCE);
    }
}
