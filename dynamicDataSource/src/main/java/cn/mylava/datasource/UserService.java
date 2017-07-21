package cn.mylava.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lipengfei
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    @Transactional()
    public void test() {
        //写主库
        DataSourceHolder.setDBType(DataSourceHolder.MASTER_DATA_SOURCE);
        userDao.addUser();
        //读从库
        DataSourceHolder.setDBType(DataSourceHolder.SLAVE_DATA_SOURCE);
        userDao.findUser();
    }




}
