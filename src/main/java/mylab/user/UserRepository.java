package mylab.user;

public class UserRepository {
    private String dbType = "MySQL";

    public void saveUser(String username) {
        System.out.println(dbType + " DB에 사용자 '" + username + "'을(를) 저장했습니다.");
    }

    public String getDbType() {
        return dbType;
    }

    public void setDbType(String dbType) {
        this.dbType = dbType;
    }
}
