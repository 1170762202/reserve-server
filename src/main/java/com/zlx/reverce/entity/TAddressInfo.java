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
public class TAddressInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 名字
     */
    private String addressName;

    /**
     * 描述
     */
    private String addressDescription;

    /**
     * 图片logo
     */
    private String addressImage;

    /**
     * 等级
     */
    private String addressLevel;

    /**
     * 房间数量
     */
    private String addressRoomNumber;

    /**
     * 场地面积
     */
    private String addressAreaSize;

    /**
     * 场地容量(人数)
     */
    private String addressCapacity;

    /**
     * 室外场地容量(人数)
     */
    private String addressOutsideParkNumber;

    /**
     * 室内场地容量(人数)
     */
    private String addressInsideParkNumber;

    /**
     * 创建时间
     */
    private Date createTime;
}
