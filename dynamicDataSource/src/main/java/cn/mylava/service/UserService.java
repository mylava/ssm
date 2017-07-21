package cn.mylava.service;

import cn.mylava.model.User;

/**
 * @author lipengfei
 */
public interface UserService {
    public User getUserById(int userId);

    public int addUser(User user);

    public void tran(int userId,User user);
}
