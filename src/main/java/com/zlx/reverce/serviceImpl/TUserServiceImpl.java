package com.zlx.reverce.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlx.reverce.entity.TUser;
import com.zlx.reverce.mapper.TUserMapper;
import com.zlx.reverce.service.ITUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zlx
 * @since 2019-09-16
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements ITUserService {

    @Autowired
    TUserMapper tUserMapper;

    @Override
    public void insertUser(TUser tUser) {
        tUserMapper.insertUser(tUser);
    }
}
