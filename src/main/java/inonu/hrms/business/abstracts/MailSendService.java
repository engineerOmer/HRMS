package inonu.hrms.business.abstracts;

public interface MailSendService {
    void sendMail(String to,String subject,String body);
}
