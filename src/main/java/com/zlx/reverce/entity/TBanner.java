package com.zlx.reverce.entity;

import com.zlx.reverce.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zlx
 * @since 2019-09-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_banner")
public class TBanner extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 0手机1PC
     */
    private String bannerType;

    /**
     * 轮播图url
     */
    private String bannerImage;


}
