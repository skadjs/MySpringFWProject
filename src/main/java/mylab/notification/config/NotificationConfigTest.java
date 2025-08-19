package mylab.notification.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mylab.notification.manager.NotificationManager;
import mylab.notification.service.EmailNotificationService;
import mylab.notification.service.SmsNotificationService;

/**
 * NotificationConfig 설정을 기반으로 Spring 컨텍스트를 로드하여 테스트를 수행합니다.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = NotificationConfig.class) // XML 대신 Java 설정 클래스를 지정
public class NotificationConfigTest {

    @Autowired
    private NotificationManager notificationManager;

    @Test
    public void testDiConfigurationAndServiceExecution() {
        // 1. NotificationManager가 null이 아닌지 검증
        assertNotNull("NotificationManager가 주입되지 않았습니다.", notificationManager);
        System.out.println("1. NotificationManager Bean 주입 성공");

        // 2. 이메일 서비스 검증
        EmailNotificationService emailService = notificationManager.getEmailService();
        assertNotNull("EmailService가 주입되지 않았습니다.", emailService);
        assertEquals("SMTP 서버 주소가 일치하지 않습니다.", "smtp.gmail.com", emailService.getSmtpServer());
        assertEquals("SMTP 포트 번호가 일치하지 않습니다.", 587, emailService.getPort());
        System.out.println("2. EmailService 의존성 및 값 검증 성공");

        // 3. SMS 서비스 검증
        SmsNotificationService smsService = notificationManager.getSmsService();
        assertNotNull("SmsService가 주입되지 않았습니다.", smsService);
        assertEquals("SMS 제공업체가 일치하지 않습니다.", "SKT", smsService.getProvider());
        System.out.println("3. SmsService 의존성 및 값 검증 성공");

        System.out.println("\n====== 서비스 메서드 실행 테스트 ======");
        // 4. NotificationManager의 메서드 실행
        notificationManager.sendNotificationByEmail("테스트 이메일");
        notificationManager.sendNotificationBySms("테스트 SMS");
        System.out.println("======================================");
    }
}
