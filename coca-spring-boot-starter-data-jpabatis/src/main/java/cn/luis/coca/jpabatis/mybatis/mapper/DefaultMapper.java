package cn.luis.coca.jpabatis.mybatis.mapper;

import cn.luis.coca.jpabatis.entity.AbstractDbEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Lazy;

/**
 * 占位符
 *
 * @author luis
 */
@Mapper
@Lazy
public interface DefaultMapper extends BaseMapper<AbstractDbEntity> {
}