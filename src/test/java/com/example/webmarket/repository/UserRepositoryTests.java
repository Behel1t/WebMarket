package com.example.webmarket.repository;

import com.example.security.entity.User;
import com.example.security.repository.UserRepository;
import com.example.webmarket.security.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTests {
    @Autowired
    private UserRepository repo;
    @Autowired
    private TestEntityManager entityManager;
    @Test
    public void testCreateUser(){
        User user=new User();
        user.setEmail("02ashes@gmail.com");
        user.setPassword("1212");
        user.setName("Oleg");
        repo.save(user);
        User savedUser=repo.save(user);
        entityManager.find(User.class,savedUser.getId());
        User existUser=entityManager.find(User.class,savedUser.getId());
        assertThat(existUser.getEmail()).isEqualTo(user.getEmail());
    }
    @Test
    public void testFindUserByEmail(){
        String email="02ashes@gmail.com";
        User byEmail = repo.findByEmail(email);
        assertThat(email).isNotNull();
    }

}
