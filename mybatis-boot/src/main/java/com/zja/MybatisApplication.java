/**
 * @Company: 上海数慧系统技术有限公司
 * @Department: 数据中心
 * @Author: 郑家骜[ào]
 * @Email: zhengja@dist.com.cn
 * @Date: 2022-02-14 15:26
 * @Since:
 */
package com.zja;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * http://localhost:8080/swagger-ui/index.html#/
 *
 * 启动类添加MapperScan注解。指定mapper扫描路径。指定后就不要在mapper层写@Mapper注解了
 */
@MapperScan("com.zja.mappers")
@SpringBootApplication
public class MybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisApplication.class, args);
    }

}
