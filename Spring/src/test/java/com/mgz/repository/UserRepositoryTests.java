package com.mgz.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.mgz.model.Role;
import com.mgz.model.User;
import io.swagger.models.auth.In;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
    @Autowired
    private UserRepository userRepository;
    @Test
    public void testCreateUser(){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("qwer");
        User user = new User("tamnd@gmail.com",password);
        System.out.println(user.toString());
        User saveuser = userRepository.save(user);

        assertThat(saveuser).isNotNull();
        assertThat(saveuser.getId()).isGreaterThan(0);
    }

    @Test
    public void testAssignRolesToUser(){
        Integer userId = 1;
//        Integer roleId = 2;

        User user = userRepository.findById(userId).get();
        user.addRole(new Role(2));
//        user.addRole(new Role(3));

        User updateUser = userRepository.save(user);
        assertThat(updateUser.getRoles()).hasSize(2);
    }
}
