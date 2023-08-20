package cn.luis.coca.jpabatis.jpa;

import cn.luis.coca.jpabatis.entity.AbstractDbEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

/**
 * 封装jpa做通用service
 *
 * @author luis
 * @since 1.0
 * created 2022/5/29 17:11
 */
@Getter
@Setter
public abstract class AbstractJpaService<T extends AbstractDbEntity, ID extends Serializable, R extends JpaRepository<T, ID>>
        extends AbstractJpaReadOnlyService<T, ID, R> implements JpaService<T, ID> {

    @Autowired
    private R repository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public <S extends T> List<S> saveAll(Iterable<S> entities) {
        return this.repository.saveAll(entities);
    }

    @Override
    public <S extends T> S saveAndFlush(S entity) {
        return this.repository.saveAndFlush(entity);
    }

    @Override
    public void deleteInBatch(Iterable<T> entities) {
        this.repository.deleteInBatch(entities);
    }

    @Override
    public void deleteAllInBatch() {
        this.repository.deleteAllInBatch();
    }

    @Override
    public <S extends T> S save(S entity) {
        return this.repository.save(entity);
    }

    @Override
    public void deleteById(ID id) {
        this.repository.deleteById(id);
    }

    @Override
    public void delete(T entity) {
        this.repository.delete(entity);
    }

    @Override
    public void deleteAll(Iterable<? extends T> entities) {
        this.repository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        this.repository.deleteAll();
    }
}