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
public class TCaseInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 案例id
     */
    private String caseId;

    /**
     * 案例名字
     */
    private String caseInfoName;

    /**
     * 描述
     */
    private String caseInfoDescription;

    /**
     * 案例图片
     */
    private String caseInfoImage;

    /**
     * 创建时间
     */
    private Date createTime;


}
