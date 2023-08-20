package cn.luis.coca.jpabatis.test.service;

import cn.luis.coca.jpabatis.JpaBatisService;
import cn.luis.coca.jpabatis.test.domain.User;

import java.util.List;

public interface UserService extends JpaBatisService<User, Long> {

    int deleteByName(String name);

    List<User> queryByName(String name);

    User updateUser(User user);

    User addUser(User user);

}
