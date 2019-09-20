package com.zlx.reverce.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author zlx
 * @since 2019-09-16
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class TOrder extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 手机号
     */
    private String reservePhone;

    /**
     * 地址
     */
    private String address;

    /**
     * 加入人数
     */
    private String joinNumber;

    /**
     * 类型
     */
    private String reserveType;

    /**
     * 开始日期
     */
    private Date startDate;

    /**
     * 结束日期
     */
    private Date endDate;

    /**
     * 预算
     */
    private String budget;

    /**
     * 创建时间
     */
    private Date createTime;


}
