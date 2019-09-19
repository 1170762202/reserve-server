package com.zlx.reverce.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
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
public class TCase extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 案例名字
     */
    private String caseName;

    /**
     * 创建时间
     */
    private Date createTime;


}
