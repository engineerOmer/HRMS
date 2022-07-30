package inonu.hrms.business.concretes;

import inonu.hrms.business.abstracts.MailSendService;

import inonu.hrms.core.utilities.mail.SpringMailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailSendManager implements MailSendService {

    @Autowired
    private SpringMailSenderService javaMailSenderUtils;


    @Override
    public void sendMail(String to, String subject, String body) {
        javaMailSenderUtils.sendMail(to, subject, body);
    }
}