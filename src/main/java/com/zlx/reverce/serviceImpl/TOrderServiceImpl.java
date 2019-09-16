package com.zlx.reverce.serviceImpl;

import com.zlx.reverce.entity.TOrder;
import com.zlx.reverce.mapper.TOrderMapper;
import com.zlx.reverce.mapper.TUserMapper;
import com.zlx.reverce.service.ITOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
public class TOrderServiceImpl extends ServiceImpl<TOrderMapper, TOrder> implements ITOrderService {

    @Autowired
    TOrderMapper tOrderMapper;

    @Override
    public void insertOrder(TOrder order) {
        tOrderMapper.insertOrder(order);
    }
}
