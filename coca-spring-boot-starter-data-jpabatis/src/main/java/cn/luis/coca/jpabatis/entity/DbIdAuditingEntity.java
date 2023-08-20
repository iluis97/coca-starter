package cn.luis.coca.jpabatis.entity;

import lombok.Getter;

import javax.persistence.MappedSuperclass;

/**
 * 数据库 ID 审计实体
 *
 * @author luis
 * @since 1.0
 * created 2022/5/28 20:45
 */
@Getter
@MappedSuperclass
public class DbIdAuditingEntity<T> extends DbIdTimeEntity<T> {

    private Long creator;

    private Long modifier;

    @SuppressWarnings("unchecked")
    public T setCreator(Long creator) {
        this.creator = creator;
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    public T setModifier(Long modifier) {
        this.modifier = modifier;
        return (T) this;
    }

    @Override
    public String toString() {
        return "DbIdAuditingEntity{" +
                "id=" + super.getId() +
                ", creator=" + creator +
                ", modifier=" + modifier +
                ", createdTime=" + super.getCreatedTime() +
                ", modifyTime=" + super.getModifyTime() +
                '}';
    }
}