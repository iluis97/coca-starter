package cn.luis.coca.jpabatis.jpa;

import cn.luis.coca.jpabatis.entity.AbstractDbEntity;
import cn.luis.coca.jpabatis.jpa.utils.ExampleMatcherUtils;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * 封装jpa做通用service
 *
 * @author luis
 * @since 1.0
 * created 2022/5/29 17:11
 */
@Getter
@Setter
public abstract class AbstractJpaReadOnlyService<T extends AbstractDbEntity, ID extends Serializable, R extends JpaRepository<T, ID>>
        implements JpaReadOnlyService<T, ID> {

    @Autowired
    private R repository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void clear() {
        this.entityManager.clear();
    }

    @Override
    public void evict(T t) {
        Session session = entityManager.unwrap(Session.class);
        session.evict(t);
    }

    @Override
    public List<T> findAll() {
        return this.repository.findAll();
    }

    @Override
    public List<T> findAll(Sort sort) {
        return this.repository.findAll(sort);
    }

    @Override
    public List<T> findAllById(Iterable<ID> ids) {
        return this.repository.findAllById(ids);
    }

    @Override
    public void flush() {
        this.repository.flush();
    }

    @Override
    public T getOne(ID id) {
        return this.repository.getOne(id);
    }

    @Override
    public <S extends T> Optional<S> findOne(Example<S> example) {
        return this.repository.findOne(example);
    }

    @Override
    public <S extends T> Optional<S> findOne(S entity, boolean ignoreNullValues) {
        if (ignoreNullValues) {
            return this.repository.findOne(ExampleMatcherUtils.ignoreNullValuesOf(entity));
        }
        return this.repository.findOne(ExampleMatcherUtils.includeNullValuesOf(entity));
    }

    @Override
    public <S extends T> Optional<S> findOne(S entity, ExampleMatcher matcher) {
        return this.repository.findOne(ExampleMatcherUtils.matcher(entity, matcher));
    }

    @Override
    public <S extends T> S getOne(S entity, boolean ignoreNullValues) {
        if (ignoreNullValues) {
            return this.repository.findOne(ExampleMatcherUtils.ignoreNullValuesOf(entity)).orElse(null);
        }
        return this.repository.findOne(ExampleMatcherUtils.includeNullValuesOf(entity)).orElse(null);
    }

    @Override
    public <S extends T> S getOne(S entity, ExampleMatcher matcher) {
        return this.repository.findOne(ExampleMatcherUtils.matcher(entity, matcher)).orElse(null);
    }

    @Override
    public <S extends T> List<S> findAll(Example<S> example) {
        return this.repository.findAll(example);
    }

    @Override
    public <S extends T> List<S> findAll(S entity, boolean ignoreNullValues) {
        if (ignoreNullValues) {
            return this.repository.findAll(ExampleMatcherUtils.ignoreNullValuesOf(entity));
        }
        return this.repository.findAll(ExampleMatcherUtils.includeNullValuesOf(entity));

    }

    @Override
    public <S extends T> List<S> findAll(S entity, ExampleMatcher matcher) {
        return this.repository.findAll(ExampleMatcherUtils.matcher(entity, matcher));
    }

    @Override
    public <S extends T> List<S> findAll(Example<S> example, Sort sort) {
        return this.repository.findAll(example, sort);
    }

    @Override
    public <S extends T> List<S> findAll(S entity, Sort sort, boolean ignoreNullValues) {
        if (ignoreNullValues) {
            return this.repository.findAll(ExampleMatcherUtils.ignoreNullValuesOf(entity), sort);
        }
        return this.repository.findAll(ExampleMatcherUtils.includeNullValuesOf(entity), sort);
    }

    @Override
    public <S extends T> List<S> findAll(S entity, Sort sort, ExampleMatcher matcher) {
        return this.repository.findAll(ExampleMatcherUtils.matcher(entity, matcher), sort);
    }

    @Override
    public <S extends T> Page<S> findAll(Example<S> example, Pageable pageable) {
        return this.repository.findAll(example, pageable);
    }

    @Override
    public <S extends T> Page<S> findAll(S entity, Pageable pageable, boolean ignoreNullValues) {
        if (ignoreNullValues) {
            return this.repository.findAll(ExampleMatcherUtils.ignoreNullValuesOf(entity), pageable);
        }
        return this.repository.findAll(ExampleMatcherUtils.includeNullValuesOf(entity), pageable);
    }

    @Override
    public <S extends T> Page<S> findAll(S entity, Pageable pageable, ExampleMatcher matcher) {
        return this.repository.findAll(ExampleMatcherUtils.matcher(entity, matcher), pageable);
    }

    @Override
    public <S extends T> long count(Example<S> example) {
        return this.repository.count(example);
    }

    @Override
    public <S extends T> long count(S entity, boolean ignoreNullValues) {
        if (ignoreNullValues) {
            return this.repository.count(ExampleMatcherUtils.ignoreNullValuesOf(entity));
        }
        return this.repository.count(ExampleMatcherUtils.includeNullValuesOf(entity));
    }

    @Override
    public <S extends T> boolean exists(Example<S> example) {
        return this.repository.exists(example);
    }

    @Override
    public <S extends T> boolean exists(S entity, boolean ignoreNullValues) {
        if (ignoreNullValues) {
            return this.repository.exists(ExampleMatcherUtils.ignoreNullValuesOf(entity));
        }
        return this.repository.exists(ExampleMatcherUtils.includeNullValuesOf(entity));
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        return this.repository.findAll(pageable);
    }


    @Override
    public Optional<T> findById(ID id) {
        return this.repository.findById(id);
    }

    @Override
    public T getById(ID id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public boolean existsById(ID id) {
        return this.repository.existsById(id);
    }

    @Override
    public long count() {
        return this.repository.count();
    }
}