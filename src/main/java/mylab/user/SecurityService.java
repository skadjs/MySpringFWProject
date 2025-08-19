package mylab.user;

import org.springframework.stereotype.Component;

@Component
public class SecurityService {
    public boolean authenticate(String username, String password) {
        System.out.println("사용자 '" + username + "' 인증을 시도합니다.");
        // 간단한 인증 로직 시뮬레이션
        if ("testuser".equals(username)) {
            System.out.println("인증 성공!");
            return true;
        }
        System.out.println("인증 실패!");
        return false;
    }
}
