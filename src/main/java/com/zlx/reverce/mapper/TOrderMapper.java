package com.zlx.reverce.mapper;

import com.zlx.reverce.entity.TOrder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zlx
 * @since 2019-09-16
 */
@Mapper
public interface TOrderMapper extends BaseMapper<TOrder> {
    List<Map> selectAll();

    void insertOrder(@Param("od") TOrder order);
}
