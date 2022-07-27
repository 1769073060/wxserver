package com.rzk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rzk.mapper.WpOptionsMapper;
import com.rzk.pojo.WpOptions;
import com.rzk.service.IWpOptionService;
import org.springframework.stereotype.Service;

@Service
public class WpOptionService extends ServiceImpl<WpOptionsMapper,WpOptions> implements IWpOptionService {
}
