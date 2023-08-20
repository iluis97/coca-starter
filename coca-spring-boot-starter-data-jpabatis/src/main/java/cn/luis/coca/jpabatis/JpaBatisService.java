package cn.luis.coca.jpabatis;

import cn.luis.coca.jpabatis.entity.AbstractDbEntity;
import cn.luis.coca.jpabatis.jpa.JpaReadOnlyService;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * 封装jpa做通用service
 *
 * @author luis
 * @since 1.0
 * created 2022/5/29 17:11
 */
@NoRepositoryBean
public interface JpaBatisService<T extends AbstractDbEntity, ID extends Serializable>
        extends JpaReadOnlyService<T, ID> {

}