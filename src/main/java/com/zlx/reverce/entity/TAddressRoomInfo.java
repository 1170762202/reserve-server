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
 * @since 2019-09-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class TAddressRoomInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 地址id
     */
    private String addressId;

    /**
     * 名字
     */
    private String roomName;

    /**
     * 描述
     */
    private String roomDescription;

    /**
     * 图片logo
     */
    private String roomImage;

    /**
     * 场地面积
     */
    private String roomAreaSize;

    /**
     * 场地容量(人数)
     */
    private String roomCapacity;

    /**
     * 创建时间
     */
    private Date createTime;
}
