package com.zlx.reverce.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlx.reverce.entity.TCase;
import com.zlx.reverce.mapper.TCaseMapper;
import com.zlx.reverce.service.ITCaseService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zlx
 * @since 2019-09-19
 */
@Service
public class TCaseServiceImpl extends ServiceImpl<TCaseMapper, TCase> implements ITCaseService {

}
