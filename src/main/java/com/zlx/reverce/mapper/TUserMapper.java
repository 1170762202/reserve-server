package com.zlx.reverce.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zlx.reverce.entity.TUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zlx
 * @since 2019-09-16
 */
@Mapper
public interface TUserMapper extends BaseMapper<TUser> {

    void insertUser(@Param("user") TUser TUser);

}
