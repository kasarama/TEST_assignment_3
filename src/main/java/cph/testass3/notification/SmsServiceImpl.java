package cph.testass3.notification;

import org.springframework.stereotype.Service;

@Service
public class SmsServiceImpl implements SmsService {
    @Override
    public String sendSms(String to) {
        return "Sms sent to " + to;
    }
}
