package Nash;


import Database.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NashDBDao implements  NashDao {
    private final String PUSH_TABLE_NAME ="nash_push";
    private final String CALL_TABLE_NAME ="nash_call";
    private final String ADD_PUSH_NASH = "INSERT INTO nash_push(name, position, bb, range_push ) VALUES(?,?,?,?)";
    private final String ADD_CALL_NASH = "INSERT INTO nash_call(name, position, bb, range_push, push_position ) VALUES(?,?,?,?,?)";
    private final String DELETE_PUSH_NASH = "DELETE FROM nash_push WHERE name = ?";
    private final String DELETE_CALL_NASH = "DELETE FROM nash_call WHERE name = ?";
    private final String FIND_PUSH_NASH = "SELECT * FROM nash_push WHERE name = ?";
    private final String FIND_CALL_NASH = "SELECT * FROM nash_call WHERE name = ?";

    private final String GET_ALL_NASH_QUERY =
            "SELECT * FROM products";
    public NashDBDao() {


    }

    @Override
    public int addNash(Nash nash) {
        if(nash instanceof CallNash){
            String[] ids = {"id_call"};
            try (PreparedStatement preparedStatement = ConnectionDB.getConnection().prepareStatement(ADD_CALL_NASH, ids)){
                preparedStatement.setString(1, nash.getName());
                preparedStatement.setString(2, nash.getPosition());
                preparedStatement.setInt(3, nash.getBb());
                preparedStatement.setString(4, nash.getRange());
                preparedStatement.setString(5, nash.getPushPosition());
                int i = preparedStatement.executeUpdate();
                if (i != 1) {
                    System.out.println("Call_nash not added to table");
                } else {
                    System.out.println("Call_nash added to table");
                }
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    while (generatedKeys.next()) {
                        nash.setNashId(generatedKeys.getInt(1));
                        System.out.println(nash.toString());
                        return generatedKeys.getInt(1);
                    }

                }
            }catch (SQLException e) {
                e.printStackTrace();

            }
            throw new RuntimeException("Call_nash not added to table");
        }
        else if(nash instanceof PushNash){
            String[] ids = {"id_push"};
            try (PreparedStatement preparedStatement = ConnectionDB.getConnection().prepareStatement(ADD_PUSH_NASH, ids)){

                preparedStatement.setString(1, nash.getName());
                preparedStatement.setString(2, nash.getPosition());
                preparedStatement.setInt(3, nash.getBb());
                preparedStatement.setString(4, nash.getRange());

                int i = preparedStatement.executeUpdate();
                if (i != 1) {
                    System.out.println("Push_nash not added to table");
                } else {
                    System.out.println("Push_nash added to table");
                }


                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    while (generatedKeys.next()) {
                          nash.setNashId(generatedKeys.getInt(1));
                        System.out.println(nash.toString());
                        return generatedKeys.getInt(1);
                    }

                }
            }catch (SQLException e) {
                e.printStackTrace();

            }
            throw new RuntimeException("Push_nash not added to table");


        }
        return  0;
    }

    @Override
    public void deleteNash(String name) {

    }

    @Override
    public void showNash(String name) {

    }

    @Override
    public void showAllNash() {

    }

    @Override
    public void findNash(String name) {

    }


}
