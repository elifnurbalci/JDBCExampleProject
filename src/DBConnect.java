import java.sql.*;

public class DBConnect {
    public static final String DB_URL = "jdbc:mysql://localhost/Company";
    public static final String DB_USERNAME = "root";
    public static final String DB_PASSWORD = "mysql";

    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Employees");
            while (resultSet.next()) {
                System.out.println("ID : " + resultSet.getInt("employee_id"));
                System.out.println("FullName : " + resultSet.getString("employee_name"));
                System.out.println("Position : " + resultSet.getString("employee_position"));
                System.out.println("Salary : " + resultSet.getString("employee_salary"));
                System.out.println("#################");
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

}