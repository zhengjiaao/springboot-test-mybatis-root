/**
 * @Company: 上海数慧系统技术有限公司
 * @Department: 数据中心
 * @Author: 郑家骜[ào]
 * @Email: zhengja@dist.com.cn
 * @Date: 2022-02-14 15:42
 * @Since:
 */
package com.zja.mappers;

import com.zja.entitys.UserEntity;
import com.zja.mappers.mybatis.User2Mapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;

@SpringBootTest
public class User2MapperTests {

    @Resource
    private User2Mapper user2Mapper;

    @Test
    public void getAll() {
        System.out.println(user2Mapper.getAll());
    }

    @Test
    public void getOne() {
        System.out.println(user2Mapper.getOne(1L));
    }

    @Test
    public void insert() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName("666");
        userEntity.setAge(88);
        userEntity.setCreateTime(new Date());
        user2Mapper.insert(userEntity);
    }

}
