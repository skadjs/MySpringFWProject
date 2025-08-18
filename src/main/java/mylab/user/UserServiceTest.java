package mylab.user;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) // Spring과 JUnit을 연동
@ContextConfiguration(locations = "classpath:mylab-user-di.xml") // 설정 파일 위치 지정
public class UserServiceTest {

    // 테스트 대상인 UserService를 Spring 컨테이너로부터 주입받습니다.
    @Autowired
    private UserService userService;

    @Test
    public void testDiConfiguration() {
        System.out.println("====== DI 설정 검증 테스트 시작 ======");

        // 1. UserService가 null이 아닌지 검증
        assertNotNull("UserService가 주입되지 않았습니다.", userService);
        System.out.println("1. UserService Bean 주입 성공");

        // 2. UserService에 UserRepository가 null이 아닌지 검증
        assertNotNull("UserRepository가 주입되지 않았습니다.", userService.getUserRepository());
        System.out.println("2. UserRepository 의존성 주입 성공");

        // 3. UserRepository의 dbType이 "MySQL"인지 검증
        assertEquals("dbType이 'MySQL'이 아닙니다.", "MySQL", userService.getUserRepository().getDbType());
        System.out.println("3. UserRepository의 dbType 값('MySQL') 검증 성공");

        // 4. UserService에 SecurityService가 null이 아닌지 검증
        assertNotNull("SecurityService가 주입되지 않았습니다.", userService.getSecurityService());
        System.out.println("4. SecurityService 의존성 주입 성공");

        System.out.println("====== DI 설정 검증 테스트 종료 ======\n");
    }

    @Test
    public void testRegisterUser() {
        System.out.println("====== registerUser 기능 테스트 시작 ======");
        // 5. registerUser 메서드가 true를 반환하는지 검증
        boolean result = userService.registerUser("testuser", "password");
        assertTrue("사용자 등록에 실패했습니다.", result);
        System.out.println("====== registerUser 기능 테스트 종료 ======");
    }
}
