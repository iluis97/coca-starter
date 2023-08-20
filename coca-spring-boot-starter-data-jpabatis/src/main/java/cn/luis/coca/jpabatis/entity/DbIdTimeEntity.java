package cn.luis.coca.jpabatis.entity;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * 数据库 ID 审计实体
 *
 * @author luis
 * @since 1.0
 * created 2022/5/28 20:45
 */
@Getter
@MappedSuperclass
public class DbIdTimeEntity<T> extends DbIdEntity<T> {

    @Column(name = "created_time")
    private LocalDateTime createdTime;

    @Column(name = "modify_time")
    private LocalDateTime modifyTime;

    @SuppressWarnings("unchecked")
    public T setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    public T setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
        return (T) this;
    }

    @Override
    public String toString() {
        return "DbIdTimeEntity{" +
                "id=" + super.getId() +
                ", createdTime=" + createdTime +
                ", modifyTime=" + modifyTime +
                '}';
    }
}