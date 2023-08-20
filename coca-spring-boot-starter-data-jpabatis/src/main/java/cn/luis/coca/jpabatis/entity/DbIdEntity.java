package cn.luis.coca.jpabatis.entity;

import lombok.Getter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * 数据库 ID 实体
 *
 * @author luis
 * @since 1.0
 * created 2022/5/28 20:32
 */
@Getter
@MappedSuperclass
public class DbIdEntity<T> extends AbstractDbEntity {

    @GenericGenerator(
            name = "idGenerator",
            strategy = "cn.luis.coca.jpabatis.core.IdGenerator"
    )
    @Id
    @GeneratedValue(
            generator = "idGenerator"
    )
    private Long id;

    @SuppressWarnings("unchecked")
    public T setId(Long id) {
        this.id = id;
        return (T) this;
    }

    @Override
    public String toString() {
        return "DbIdEntity{" +
                "id=" + id +
                '}';
    }
}