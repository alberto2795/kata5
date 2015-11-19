
import java.sql.*;

public class kata5v1 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connection = DriverManager.getConnection(
                "jdbc:oracle:thin:@10.22.143.90:1521:orcl", "system", "orcl");
        Statement state = connection.createStatement();
        
        String query = "SELECT * FROM PEOPLE";
        ResultSet rs = state.executeQuery(query);
        
        while (rs.next()){
            System.out.print(rs.getInt("ID") +  " ");
            System.out.println(rs.getString("NAME"));
        }
        
        rs.close();
        state.close();
        connection.close();
    }

}
