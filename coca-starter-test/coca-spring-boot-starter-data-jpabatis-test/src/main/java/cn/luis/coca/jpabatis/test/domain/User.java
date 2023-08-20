package cn.luis.coca.jpabatis.test.domain;

import cn.luis.coca.jpabatis.entity.DbIdAuditingEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "user")
public class User extends DbIdAuditingEntity<User> {

    private String name;

    private int age;

}
