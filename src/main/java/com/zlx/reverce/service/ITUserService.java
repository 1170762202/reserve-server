package com.zlx.reverce.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.zlx.reverce.entity.TUser;
import com.zlx.reverce.mapper.TUserMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zlx
 * @since 2019-09-16
 */
public interface ITUserService extends IService<TUser> {

    void insertUser(TUser tUser);

}
