package cn.luis.coca.jpabatis.test.service.impl;

import cn.luis.coca.jpabatis.AbstractJpaBatisService;
import cn.luis.coca.jpabatis.test.dao.mapper.UserMapper;
import cn.luis.coca.jpabatis.test.dao.repository.UserRepository;
import cn.luis.coca.jpabatis.test.domain.User;
import cn.luis.coca.jpabatis.test.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl extends AbstractJpaBatisService<User, Long, UserRepository, UserMapper> implements UserService {

    @Override
    public int deleteByName(String name) {
        Objects.requireNonNull(name, "name not null!");
        return this.getMapper().deleteByName(name);
    }

    @Override
    public List<User> queryByName(String name) {
        Objects.requireNonNull(name, "name not null!");
        return this.getMapper().queryByName(name);
    }

    @Override
    public User updateUser(User user) {
        // id不为null才是更新
        Objects.requireNonNull(user.getId());
        return this.getRepository().save(user);
    }

    @Override
    public User addUser(User user) {
        return this.getRepository().save(user);
    }
}
