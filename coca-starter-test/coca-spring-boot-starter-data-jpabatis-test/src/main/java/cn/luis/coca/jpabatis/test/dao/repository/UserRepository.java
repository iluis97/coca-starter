package cn.luis.coca.jpabatis.test.dao.repository;

import cn.luis.coca.jpabatis.test.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
