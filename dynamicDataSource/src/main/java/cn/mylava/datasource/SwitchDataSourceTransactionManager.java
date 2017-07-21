package cn.mylava.datasource;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;

/**
 * @author lipengfei
 */
public class SwitchDataSourceTransactionManager extends DataSourceTransactionManager{
    @Override
    protected void doBegin(Object transaction, TransactionDefinition definition) {
//        DataSourceHolder.setDBType(DataSourceHolder.SLAVE_DATA_SOURCE);
        super.doBegin(transaction, definition);
    }
}
