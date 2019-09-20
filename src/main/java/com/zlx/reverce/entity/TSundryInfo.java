package com.zlx.reverce.entity;

import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zlx
 * @since 2019-09-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class TSundryInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 验证码
     */
    private String mobileCode;

    /**
     * 创建时间
     */
    private Date createTime;


}
