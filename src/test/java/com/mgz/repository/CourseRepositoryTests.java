package com.mgz.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.mgz.model.User;
import com.mgz.service.CourseService;
import org.junit.jupiter.api.Test;
import com.mgz.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class CourseRepositoryTests {
    @Autowired
    private UserRepository userRepository;
    @Test
    public void testCreateCourse(){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("nam2022");
        User user = new User("tamnd",password);
        System.out.println(user.toString());
        User saveuser = userRepository.save(user);

        assertThat(saveuser).isNotNull();
        assertThat(saveuser.getId()).isGreaterThan(0);
    }
}
