package cn.mylava.service.impl;

import cn.mylava.datasource.DataSourceHolder;
import cn.mylava.mapper.UserMapper;
import cn.mylava.model.User;
import cn.mylava.service.UserService;
import com.ruwe.collectlog.util.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lipengfei
 */
@Service
public class UserServiceImpl implements UserService{

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(int userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        LogUtils.info(logger,"service","-->",user.getName());
        return user;
    }

    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    @Transactional
    public void tran(int userId,User user) {

        User result = userMapper.selectByPrimaryKey(userId);

        LogUtils.info(logger,"service","-->",result.getName());

        userMapper.insert(user);
    }
}
