
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class kata5v1 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
        Class.forName("org.sqlite.JDBC");
        //Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connection = DriverManager.getConnection(
                "jdbc:sqlite:KATA.DB");
        //Connection connection = DriverManager.getConnection(
        //        "jdbc:oracle:thin:@10.22.143.90:1521:orcl", "system", "orcl");
        Statement state = connection.createStatement();
        
        String query = "SELECT * FROM PEOPLE";
        ResultSet rs = state.executeQuery(query);
        
        while (rs.next()){
            System.out.print(rs.getInt("ID") +  " ");
            System.out.println(rs.getString("NAME"));
        }
        
        rs.close();
        
        String namefile = "C:\\Users\\usuario\\Documents\\NetBeansProjects\\kata 5\\emailsfilev1.txt";
        BufferedReader reader = new BufferedReader(new FileReader(new File(namefile)));
        String mail;
        while ((mail=reader.readLine())!=null){
            query = "INSERT INTO MAILS (MAIL) VALUES ('" + mail + "')";
            state.executeUpdate(query);
        }
        
        
        state.close();
        connection.close();
    }

}
