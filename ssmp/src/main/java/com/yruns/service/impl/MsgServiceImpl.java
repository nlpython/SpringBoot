package com.yruns.service.impl;

import com.yruns.pojo.SMSCode;
import com.yruns.service.MsgService;
import com.yruns.utils.CodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * MsgServiceImpl
 */
@Service
public class MsgServiceImpl implements MsgService {

    @Autowired
    private CodeUtils codeUtils;

    @Override
    @CachePut(value="smsCode", key="#tele")
    public String sendCodeToSMS(String tele) {
        return codeUtils.generator(tele);
    }

    @Override
    public boolean checkCode(SMSCode smsCode) {
        String code = smsCode.getCode();    // 拿出用户填写的code
        String cacheCode = codeUtils.get(smsCode.getTele());   // 从内存中拿出真正的code
        return code.equals(cacheCode);
    }
}
