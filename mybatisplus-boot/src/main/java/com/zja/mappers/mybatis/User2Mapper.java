/**
 * @Company: 上海数慧系统技术有限公司
 * @Department: 数据中心
 * @Author: 郑家骜[ào]
 * @Email: zhengja@dist.com.cn
 * @Date: 2022-02-14 17:24
 * @Since:
 */
package com.zja.mappers.mybatis;

import com.zja.entitys.UserEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface User2Mapper {

    @Select("SELECT * FROM userentity")
    @Results({
            @Result(property = "userName", column = "userName"/*, javaType = .class*/),
            @Result(property = "age", column = "age")
    })
    List<UserEntity> getAll();

    @Select("SELECT * FROM userentity WHERE id = #{id}")
    @Results({
            @Result(property = "userName", column = "userName"/*, javaType = .class*/),
            @Result(property = "age", column = "age")
    })
    UserEntity getOne(Long id);

    @Insert("INSERT INTO userentity(userName,age) VALUES(#{userName}, #{age})")
    void insert(UserEntity user);

    @Update("UPDATE userentity SET userName=#{userName},age=#{age} WHERE id =#{id}")
    void update(UserEntity user);

    @Delete("DELETE FROM userentity WHERE id =#{id}")
    void delete(Long id);

}
