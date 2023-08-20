package cn.luis.coca.jpabatis.test.service;

import cn.luis.coca.jpabatis.test.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testFindAll() {
        List<User> users = userService.findAll();
        users.forEach(System.out::println);
    }

    @Test
    public void testDeleteByName() {
        int num = userService.deleteByName("l4");
        System.out.println(num);
    }

    @Test
    public void testQueryByName() {
        List<User> z3 = userService.queryByName("z3");
        System.out.println(z3);
    }

    @Test
    public void testUpdateUser() {
        User u = new User()
                .setAge(23)
                .setName("z3")

                .setId(1L)
                .setCreator(1L)
                .setModifier(1L)
                .setCreatedTime(LocalDateTime.now())
                .setModifyTime(LocalDateTime.now());
        User z3 = userService.updateUser(u);
        System.out.println(z3);
    }

    @Test
    public void testAddUser() {
        User u = new User()
                .setAge(33)
                .setName("w5")

                .setCreator(1L)
                .setModifier(1L)
                .setCreatedTime(LocalDateTime.now())
                .setModifyTime(LocalDateTime.now());
        User ans = userService.addUser(u);
        System.out.println(ans);
    }
}
