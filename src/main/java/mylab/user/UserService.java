package mylab.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    // @Autowired를 통해 Spring 컨테이너가 자동으로 의존성을 주입합니다.
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SecurityService securityService;

    public boolean registerUser(String username, String password) {
        System.out.println("사용자 등록을 시작합니다: " + username);
        if (securityService.authenticate(username, password)) {
            userRepository.saveUser(username);
            System.out.println("사용자 등록이 성공적으로 완료되었습니다.");
            return true;
        } else {
            System.out.println("인증 실패로 사용자 등록에 실패했습니다.");
            return false;
        }
    }

    // 테스트 코드에서 접근하기 위한 Getter
    public UserRepository getUserRepository() {
        return userRepository;
    }

    public SecurityService getSecurityService() {
        return securityService;
    }
}
