package com.gin.springbootmbp.mapper;

import com.gin.springbootmbp.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
class UserMapperTest {
        @Resource
        private UserMapper userMapper;
        @Test
        void save() {
            User user = User.builder().name("Rose").age(19).email("rose@baomidou.com").build();

            int row = userMapper.insert(user);
            assertEquals(1, row);

            System.out.println("雪花算法id: " + user.getId());
        }

}