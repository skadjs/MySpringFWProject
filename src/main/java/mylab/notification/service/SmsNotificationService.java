package mylab.notification.service;

public class SmsNotificationService implements NotificationService {
    private final String provider;

    public SmsNotificationService(String provider) {
        this.provider = provider;
    }

    @Override
    public void sendNotification(String message) {
        System.out.println("SMS 발송: \"" + message + "\" (통신사: " + provider + ")");
    }

    // 테스트 코드에서 값을 검증하기 위한 Getter
    public String getProvider() {
        return provider;
    }
}
