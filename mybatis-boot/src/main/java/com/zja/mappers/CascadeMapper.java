/**
 * @Company: 上海数慧系统技术有限公司
 * @Department: 数据中心
 * @Author: 郑家骜[ào]
 * @Email: zhengja@dist.com.cn
 * @Date: 2022-02-14 15:59
 * @Since:
 */
package com.zja.mappers;

import com.zja.entitys.GroupEntity;
import com.zja.entitys.OrdersEntity;
import com.zja.entitys.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 级联测试
 */
@Mapper
//@Repository
public interface CascadeMapper {
    //根据订单id查询用户信息(一对一)，一个订单对应一个用户
    OrdersEntity getOrderAndUserByOrdersId(Integer ordersId);
    //根据用户id查询所有订单信息(一对多)，一个用户对应多个订单
    UserEntity getUserAndOrdersByUserId(Integer userId);

    /**多对多（方式一）**/
    //根据用户id查询用户所属组(全部)(多对多)
    UserEntity getUsersAndGroupByUserId(Integer userId);
    //根据用户组id查询组下的所有用户(多对多)
    GroupEntity getGroupAndUsersByGroupId(Integer groupId);

    /**多对多（方式二）：将上面方式一的步骤查分两步实现**/
    //根据用户组id 获取组下的全部用户(List<UserEntity>)
    List<UserEntity> getUsersByGroupId(Integer groupId);
    //根据用户id查询用户所属全部组(List<GroupEntity>)
    List<GroupEntity> getGroupByUsersId(Integer userId);

    //查询用户信息(包含所属的全部组)
    UserEntity getUsers(Integer userId);
    //查询用户组信息(包含组下面的全部用户)
    GroupEntity getGroup(Integer groupId);
}
