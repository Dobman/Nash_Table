package Database;

import Nash.NashDao;

import java.util.List;

public class JdbcDao  {

    private final String url ;
    private final String user;
    private final String password;
    private final String PUSH_TABLE_NAME ="nash_push";
    private final String CALL_TABLE_NAME ="nash_call";
    private final String ADD_PUSH_NASH = "INSERT INTO "+ PUSH_TABLE_NAME +
            " (positionTable, bb, rangeNash) values(?,?,?)";
    private final String DELETE_PUSH_NASH = "DELETE FROM nash_push WHERE name = ?";
    private final String FIND_PUSH_NASH = "SELECT * FROM nash_push WHERE name = ?";

    private final String GET_ALL_NASH_QUERY =
            "SELECT * FROM products";

    public JdbcDao(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }




}
