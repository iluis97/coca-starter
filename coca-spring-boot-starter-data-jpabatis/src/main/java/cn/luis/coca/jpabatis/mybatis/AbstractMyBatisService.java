package cn.luis.coca.jpabatis.mybatis;

import cn.luis.coca.jpabatis.entity.AbstractDbEntity;
import cn.luis.coca.jpabatis.mybatis.mapper.BaseMapper;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 提供mybatis mapper注入
 *
 * @author luis
 * @since 1.0
 * created 2022/5/29 17:11
 */
@Getter
@Setter
public abstract class AbstractMyBatisService<M extends BaseMapper<? extends AbstractDbEntity>> {

    @Autowired(required = false)
    private M mapper;

}