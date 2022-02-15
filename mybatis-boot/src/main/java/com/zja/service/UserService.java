/**
 * @Company: 上海数慧系统技术有限公司
 * @Department: 数据中心
 * @Author: 郑家骜[ào]
 * @Email: zhengja@dist.com.cn
 * @Date: 2022-02-14 16:03
 * @Since:
 */
package com.zja.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zja.entitys.UserEntity;
import com.zja.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    //静态插入数据:通用方法
    public int insertUser(UserEntity userEntity) {
        UserEntity userById = this.userMapper.queryUserById(userEntity.getId());
        if (userById !=null){
            throw new RuntimeException("id自增，默认可不传id，是唯一主键，已经存在："+userEntity.getId());
        }
        userEntity.setCreateTime(new Date());
        return this.userMapper.insertUser(userEntity);
    }

    //动态插入数据: mysql用法，id自增
    public int insertUserMysql(UserEntity userEntity) {
        return this.userMapper.insertUserMysql(userEntity);
    }

    //动态插入数据:oracle用法，id使用序列
    public int insertUserOracle(UserEntity userEntity) {
        return this.userMapper.insertUserOracle(userEntity);
    }

    //mybatis批量插入数据:mysql用法，id自增
    public int mysqlBatchSaveUser(List<UserEntity> userEntities) {
        return this.userMapper.mysqlBatchSaveUser(userEntities);
    }

    //mybatis批量插入数据:oracle用法，id使用序列
    public int oracleBatchSaveUser(List<UserEntity> userEntities) {
        return this.userMapper.oracleBatchSaveUser(userEntities);
    }

    //按id查询用户
    public UserEntity queryUserById(Integer id) {
        return this.userMapper.queryUserById(id);
    }

    //查询所有用户
    public List<UserEntity> queryAllUser() {
        return this.userMapper.queryAllUser();
    }

    /**
     * 获取分页结果
     * @param pageNum 页码值
     * @param pageSize 每页显示条数
     */
    public List<UserEntity> getPagingResults(int pageNum, int pageSize) {
        //第一个参数是页码值，第二个参数是每页显示条数，第三个参数默认查询总数count
        //获取第pageNum页，每页pageSize条内容，默认查询总数count
        PageHelper.startPage(pageNum, pageSize);
        //紧跟着的第一个select方法会被分页
        return this.userMapper.queryAllUser();
    }

    /**
     * 获取分页结果及分页信息
     * @param pageNum 页码值
     * @param pageSize 每页显示条数
     */
    public PageInfo<UserEntity> queryPageInfo(int pageNum, int pageSize) {
        //第一个参数是页码值，第二个参数是每页显示条数，第三个参数默认查询总数count
        //获取第pageNum页，每页pageSize条内容，默认查询总数count
        PageHelper.startPage(pageNum, pageSize,true);
        //紧跟着的第一个select方法会被分页
        List<UserEntity> userEntities = this.userMapper.queryAllUser();

        //分页信息
        PageInfo<UserEntity> pageInfo = new PageInfo<UserEntity>(userEntities);

        //打印分页信息
        System.out.println("数据总数：" + pageInfo.getTotal());
        System.out.println("数据总页数：" + pageInfo.getPages());
        System.out.println("进入第一页：" + pageInfo.getNavigateFirstPage());
        System.out.println("进入最后一页：" + pageInfo.getNavigateLastPage());

        for (UserEntity user : pageInfo.getList()) {
            System.out.println(user);
        }
        return pageInfo;
    }

    //更新数据-改数据
    public int updateUser(UserEntity userEntity) {
        userEntity.setCreateTime(new Date());
        return this.userMapper.updateUser(userEntity);
    }

    //删除数据
    public int delUser(Integer id) {
        return this.userMapper.delUser(id);
    }

}
