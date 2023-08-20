package cn.luis.coca.jpabatis.test.dao.mapper;

import cn.luis.coca.jpabatis.mybatis.mapper.BaseMapper;
import cn.luis.coca.jpabatis.test.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    int deleteByName(String name);

    List<User> queryByName(String name);

}
