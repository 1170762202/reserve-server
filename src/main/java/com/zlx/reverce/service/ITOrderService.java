package com.zlx.reverce.service;

import com.zlx.reverce.entity.TOrder;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zlx
 * @since 2019-09-16
 */
public interface ITOrderService extends IService<TOrder> {
    void insertOrder(@Param("od") TOrder order);
}
