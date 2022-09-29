package com.yruns.service.impl;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CreateCache;
import com.yruns.pojo.SMSCode;
import com.yruns.service.MsgService;
import com.yruns.utils.CodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * MsgServiceImpl
 */
@Service
public class MsgServiceImpl implements MsgService {

    @Autowired
    private CodeUtils codeUtils;

    @CreateCache(area="default", name="jetCache", expire=60, timeUnit=TimeUnit.SECONDS, cacheType = CacheType.LOCAL)
    private Cache<String, String> cache;

    @Override
    public String sendCodeToSMS(String tele) {
        String code = codeUtils.generator(tele);
        cache.put(tele, code);
        return code;
    }

    @Override
    public boolean checkCode(SMSCode smsCode) {
        String code = smsCode.getCode();    // 拿出用户填写的code
        String cacheCode = cache.get(smsCode.getTele());   // 从内存中拿出真正的code
        return code.equals(cacheCode);
    }
}
