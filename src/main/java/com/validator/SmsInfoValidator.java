package com.validator;

import com.sms.bean.SmsInfo;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.Date;

/**
 * Created by zhoupengxiao on 16/5/17.
 */
public class SmsInfoValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return SmsInfo.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        SmsInfo smsInfo = (SmsInfo) target;
        ValidationUtils.rejectIfEmpty(errors, "contactId", "contactId.required");
        ValidationUtils.rejectIfEmpty(errors, "contactName", "contactName.required");
        ValidationUtils.rejectIfEmpty(errors, "phone", "phone.required");
        ValidationUtils.rejectIfEmpty(errors, "goodsId", "goodsId.required");
        ValidationUtils.rejectIfEmpty(errors, "goodsName", "goodsName.required");
        ValidationUtils.rejectIfEmpty(errors, "sendDate", "sendDate.required");
        ValidationUtils.rejectIfEmpty(errors, "smsContent", "smsContent.required");

        String phone = smsInfo.getPhone();
        //验证手机号是否合法
        if (phone != null && !phone.matches("^1\\d{10}$")) {
            errors.rejectValue("phone", "phone.invalid");
        }

        Date sendDate = smsInfo.getSendDate();
        //验证发送时期是否合法
        if (sendDate != null) {
            if (sendDate.before(new Date())) {
                errors.rejectValue("sendDate", "sendDate.invalid");
            }
        }
    }
}
