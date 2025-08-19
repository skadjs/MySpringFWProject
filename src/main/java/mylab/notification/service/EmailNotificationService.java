package mylab.notification.service;

public class EmailNotificationService implements NotificationService {
    private final String smtpServer;
    private final int port;

    public EmailNotificationService(String smtpServer, int port) {
        this.smtpServer = smtpServer;
        this.port = port;
    }

    @Override
    public void sendNotification(String message) {
        System.out.println("이메일 발송: \"" + message + "\" (서버: " + smtpServer + ":" + port + ")");
    }

    // 테스트 코드에서 값을 검증하기 위한 Getter
    public String getSmtpServer() {
        return smtpServer;
    }

    public int getPort() {
        return port;
    }
}
