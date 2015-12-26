package constants;

public interface Constants {
    //	public static final String CONNECTING_URL = "jdbc:mysql://127.0.0.1/studentprogress?user=root&password=1515&characterEncoding=UTF-8";
    String CONNECTING_URL = "jdbc:mysql://localhost:3306/students?user=root&password=root&characterEncoding=UTF-8";
    int CONNECTING_POOL_SIZE = 5;

    String CONTEXT = "CONTEXT";
    String VALIDATION_MESSAGE = "VALIDATION_MESSAGE";
    String CURRENT_SESSION_ACCOUNT = "CURRENT_SESSION_ACCOUNT";
    String CURRENT_ROLE = "CURRENT_ROLE";
    String CURRENT_MAPPING = "CURRENT_MAPPING";

    int ROLE_ADMIN = 1;
    int ROLE_STUDENT = 2;
    String DB_URL = "jdbc:mysql://$OPENSHIFT_MYSQL_DB_HOST:$OPENSHIFT_MYSQL_DB_PORT/jbossews?user=adminyGBDPY3&password=n5t4mmdF8VHU&characterEncoding=UTF-8";
}
