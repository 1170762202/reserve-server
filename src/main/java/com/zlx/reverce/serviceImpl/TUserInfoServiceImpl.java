package com.zlx.reverce.serviceImpl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlx.reverce.entity.TUserInfo;
import com.zlx.reverce.mapper.TUserInfoMapper;
import com.zlx.reverce.service.ITUserInfoService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zlx
 * @since 2019-09-16
 */
@Service
public class TUserInfoServiceImpl extends ServiceImpl<TUserInfoMapper, TUserInfo> implements ITUserInfoService {

}
