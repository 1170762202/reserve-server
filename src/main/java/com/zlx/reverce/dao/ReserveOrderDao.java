package com.zlx.reverce.dao;

import com.zlx.reverce.domain.ReserveOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

@Mapper
public interface ReserveOrderDao {
    List<Map> selectAll();

    void insertOrder(@Param("od") ReserveOrder order);
}
