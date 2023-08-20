package cn.luis.coca.jpabatis.jpa;

import cn.luis.coca.jpabatis.entity.AbstractDbEntity;
import org.springframework.data.domain.*;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

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
@NoRepositoryBean
public interface JpaReadOnlyService<T extends AbstractDbEntity, ID extends Serializable> extends Repository<T, ID> {

    /**
     * 从entityManager 中清理缓存
     */
    void clear();

    /**
     * 将对象改为游离态
     *
     * @param t
     */
    void evict(T t);

    /**
     * 不支持dubbo远程调用：Optional对象不支持序列化
     *
     * @param example SpringDataJpa  Example
     * @param <S>     S
     * @return Optional<S>
     * @see #findOne(AbstractDbEntity, boolean)
     */
    @Deprecated
    <S extends T> Optional<S> findOne(Example<S> example);

    /**
     * 不支持dubbo远程调用：Optional对象不支持序列化
     *
     * @see #getOne(AbstractDbEntity, boolean)
     */
    <S extends T> Optional<S> findOne(S entity, boolean ignoreNullValues);

    /**
     * 不支持dubbo远程调用：Optional对象不支持序列化
     *
     * @see #getOne(AbstractDbEntity, ExampleMatcher)
     */
    <S extends T> Optional<S> findOne(S entity, ExampleMatcher matcher);

    <S extends T> S getOne(S entity, boolean ignoreNullValues);

    <S extends T> S getOne(S entity, ExampleMatcher matcher);

    List<T> findAll();

    List<T> findAll(Sort sort);

    List<T> findAllById(Iterable<ID> ids);

    void flush();

    /**
     * 延迟加载,不建议使用
     *
     * @param id 主键
     * @return T
     * @see #getById(Serializable)
     */
    @Deprecated
    T getOne(ID id);

    Page<T> findAll(Pageable pageable);

    /**
     * 不支持dubbo远程调用：Optional对象不支持序列化
     *
     * @see #getById(Serializable)
     */

    Optional<T> findById(ID id);

    /**
     * @param id 主键
     * @return 单个实体对象
     */
    T getById(ID id);

    /**
     * @param example SpringDataJpa  Example
     * @param <S>     S
     * @return java.util.List
     * @see #findOne(AbstractDbEntity, boolean)
     */
    @Deprecated
    <S extends T> List<S> findAll(Example<S> example);

    /**
     * @param entity           实体对象pojo
     * @param ignoreNullValues 是否忽略 null 值
     * @param <S>              实体对象类型
     * @return java.util.List
     */
    <S extends T> List<S> findAll(S entity, boolean ignoreNullValues);

    <S extends T> List<S> findAll(S entity, ExampleMatcher matcher);

    /**
     * @param example SpringDataJpa  Example
     * @param sort    spring data jpa 排序请求参数
     * @param <S>     S
     * @return java.util.List
     * @see #findAll(AbstractDbEntity, Sort, boolean)
     */
    @Deprecated
    <S extends T> List<S> findAll(Example<S> example, Sort sort);

    /**
     * @param entity           实体对象pojo
     * @param sort             spring data jpa 排序请求参数
     * @param ignoreNullValues 是否忽略 null 值
     * @param <S>              实体对象类型
     * @return java.util.List
     */
    <S extends T> List<S> findAll(S entity, Sort sort, boolean ignoreNullValues);

    <S extends T> List<S> findAll(S entity, Sort sort, ExampleMatcher matcher);

    /**
     * 分页查询
     *
     * @param example  SpringDataJpa  Example
     * @param pageable spring data jpa分页请求参数
     * @param <S>      实体对象类型
     * @return 分页数据
     * @see #findAll(AbstractDbEntity, boolean)
     */
    @Deprecated
    <S extends T> Page<S> findAll(Example<S> example, Pageable pageable);

    /**
     * 分页查询
     *
     * @param entity           实体对象pojo
     * @param pageable         spring data jpa分页请求参数
     * @param ignoreNullValues 是否忽略null值
     * @param <S>              实体对象类型
     * @return 分页数据
     */
    <S extends T> Page<S> findAll(S entity, Pageable pageable, boolean ignoreNullValues);

    <S extends T> Page<S> findAll(S entity, Pageable pageable, ExampleMatcher matcher);

    /**
     * 根据实体查询有多少条数据
     *
     * @param example SpringDataJpa  Example
     * @param <S>     实体对象类型
     * @return 数据量
     * @see #count(AbstractDbEntity, boolean)
     */
    @Deprecated
    <S extends T> long count(Example<S> example);

    /**
     * 根据实体查询有多少条数据
     *
     * @param entity           实体对象pojo
     * @param ignoreNullValues 是否忽略null值
     * @param <S>              实体对象类型
     * @return 数据量
     */
    <S extends T> long count(S entity, boolean ignoreNullValues);

    /**
     * 查询数据是否存在
     *
     * @param example SpringDataJpa  Example
     * @param <S>     实体对象类型
     * @return true 存在,false不存在
     * @see #exists(AbstractDbEntity, boolean)
     */
    @Deprecated
    <S extends T> boolean exists(Example<S> example);

    /**
     * 查询数据是否存在
     *
     * @param entity           实体对象pojo
     * @param ignoreNullValues 是否忽略null值
     * @param <S>              实体对象类型
     * @return true 存在,false不存在
     */
    <S extends T> boolean exists(S entity, boolean ignoreNullValues);

    boolean existsById(ID id);

    long count();
}