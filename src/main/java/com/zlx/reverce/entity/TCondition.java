package com.zlx.reverce.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zlx
 * @since 2019-09-17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class TCondition extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 类型
     */
    private Integer type;

    /**
     * 值
     */
    private String value;


}
