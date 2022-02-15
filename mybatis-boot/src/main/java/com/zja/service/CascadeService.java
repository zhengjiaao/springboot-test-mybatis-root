/**
 * @Company: 上海数慧系统技术有限公司
 * @Department: 数据中心
 * @Author: 郑家骜[ào]
 * @Email: zhengja@dist.com.cn
 * @Date: 2022-02-14 16:01
 * @Since:
 */
package com.zja.service;

import com.zja.entitys.GroupEntity;
import com.zja.entitys.OrdersEntity;
import com.zja.entitys.UserEntity;
import com.zja.mappers.CascadeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CascadeService {

    @Autowired
    private CascadeMapper cascadeMapper;

    /**
     * 根据订单id查询用户信息(一对一)，一个订单对应一个用户
     * @param ordersId 订单id
     */
    public OrdersEntity getOrderAndUserByOrdersId(Integer ordersId) {
        return cascadeMapper.getOrderAndUserByOrdersId(ordersId);
    }

    /**
     * 根据用户id查询所有订单信息(一对多)，一个用户对应多个订单
     * @param userId 用户id
     */
    public UserEntity getUserAndOrdersByUserId(Integer userId) {
        return cascadeMapper.getUserAndOrdersByUserId(userId);
    }

    /**
     * 根据用户id查询用户所属组(全部)(多对多)
     * @param userId 用户id
     */
    public UserEntity getUsersAndGroupByUserId(Integer userId) {
        return cascadeMapper.getUsersAndGroupByUserId(userId);
    }

    /**
     * 根据用户组id查询组下的所有用户(多对多)
     * @param groupId 组id
     */
    public GroupEntity getGroupAndUsersByGroupId(Integer groupId) {
        return cascadeMapper.getGroupAndUsersByGroupId(groupId);
    }

    /**
     * 查询用户信息(包含所属的全部组)
     * @param userId
     */
    public UserEntity getUsers(Integer userId) {
        return cascadeMapper.getUsers(userId);
    }

    /**
     * 查询用户组信息(包含组下面的全部用户)
     * @param groupId
     */
    public GroupEntity getGroup(Integer groupId) {
        return cascadeMapper.getGroup(groupId);
    }
}
