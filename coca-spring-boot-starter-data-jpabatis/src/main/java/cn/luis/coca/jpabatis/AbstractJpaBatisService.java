package cn.luis.coca.jpabatis;

import cn.luis.coca.jpabatis.entity.AbstractDbEntity;
import cn.luis.coca.jpabatis.jpa.AbstractJpaService;
import cn.luis.coca.jpabatis.jpa.JpaService;
import cn.luis.coca.jpabatis.mybatis.mapper.BaseMapper;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

/**
 * 封装jpa做通用service
 *
 * @author luis
 * @since 1.0
 * created 2022/5/29 17:11
 */
@Getter
@Setter
public abstract class AbstractJpaBatisService<T extends AbstractDbEntity, ID extends Serializable, R extends JpaRepository<T, ID>, M extends BaseMapper<? extends AbstractDbEntity>>
        extends AbstractJpaService<T, ID, R> implements JpaService<T, ID> {

    @Autowired
    private R repository;

    @Autowired(required = false)
    private M mapper;

    @PersistenceContext
    private EntityManager entityManager;

}