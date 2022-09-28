package com.yruns.controller;

import com.yruns.pojo.SMSCode;
import com.yruns.service.MsgService;
import com.yruns.utils.CodeUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * MsgController
 */
@RestController
@RequestMapping("/msg")
public class MsgController {

    @Autowired
    private MsgService msgService;

    @GetMapping("/{tele}")
    public String getCode(@PathVariable String tele) {
        return msgService.sendCodeToSMS(tele);
    }

    @PostMapping
    public boolean checkCode(SMSCode smsCode){
        return msgService.checkCode(smsCode);
    }
}

