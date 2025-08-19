package mylab.notification.manager;

import mylab.notification.service.EmailNotificationService;
import mylab.notification.service.SmsNotificationService;

public class NotificationManager {
    private final EmailNotificationService emailService;
    private final SmsNotificationService smsService;

    public NotificationManager(EmailNotificationService emailService, SmsNotificationService smsService) {
        this.emailService = emailService;
        this.smsService = smsService;
    }

    public void sendNotificationByEmail(String message) {
        emailService.sendNotification(message);
    }

    public void sendNotificationBySms(String message) {
        smsService.sendNotification(message);
    }

    // 테스트 코드에서 주입된 객체를 검증하기 위한 Getter
    public EmailNotificationService getEmailService() {
        return emailService;
    }

    public SmsNotificationService getSmsService() {
        return smsService;
    }
}
