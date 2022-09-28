package com.yruns.service;

import com.yruns.pojo.SMSCode;

public interface MsgService {

    public String sendCodeToSMS(String tele);

    public boolean checkCode(SMSCode code);
}
