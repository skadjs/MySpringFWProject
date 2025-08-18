package mylab.notification.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import mylab.notification.manager.NotificationManager;
import mylab.notification.service.EmailNotificationService;
import mylab.notification.service.SmsNotificationService;

@Configuration
public class NotificationConfig {

    @Bean
    public EmailNotificationService emailService() {
        // 생성자를 통해 의존성(SMTP 서버, 포트)을 직접 주입합니다.
        return new EmailNotificationService("smtp.gmail.com", 587);
    }

    @Bean
    public SmsNotificationService smsService() {
        // 생성자를 통해 의존성(통신사)을 직접 주입합니다.
        return new SmsNotificationService("SKT");
    }

    @Bean
    public NotificationManager notificationManager() {
        // 위에서 Bean으로 등록된 emailService()와 smsService() 메서드를 호출하여
        // 반환된 객체를 NotificationManager의 생성자에 주입합니다.
        return new NotificationManager(emailService(), smsService());
    }
}
