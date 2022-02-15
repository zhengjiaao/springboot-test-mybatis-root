/**
 * @Company: 上海数慧系统技术有限公司
 * @Department: 数据中心
 * @Author: 郑家骜[ào]
 * @Email: zhengja@dist.com.cn
 * @Date: 2022-02-15 10:27
 * @Since:
 */
package com.zja.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zja.entitys.Student;
import com.zja.mappers.mybatisplus.IStudentService;
import com.zja.mappers.mybatisplus.StudentMapper;
import org.springframework.stereotype.Service;

@Service
public class IStudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {
}
