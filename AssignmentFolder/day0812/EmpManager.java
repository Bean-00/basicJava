package AssignmentFolder.day0812;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class EmployeeNameSalaryInfo {
    private int EmployeeID;
    private String FirstName;
    private int Salary;

    EmployeeNameSalaryInfo(int EmployeeID, String FirstName, int Salary) {
        this.EmployeeID = EmployeeID;
        this.FirstName = FirstName;
        this.Salary = Salary;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append(EmployeeID);
        builder.append("\t");
        builder.append(FirstName);
        builder.append("\t");
        builder.append(Salary);

        return builder.toString();
    }


}

public class EmpManager {
    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "hr", "hr");
    }

    public void printEmployee(String str, int salary) throws SQLException {
        ResultSet rs = null;
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT\n" +
                     "    EMPLOYEE_ID,\n" +
                     "    FIRST_NAME,\n" +
                     "    SALARY\n" +
                     "FROM EMPLOYEES\n" +
                     "WHERE (LOWER(FIRST_NAME) LIKE INITCAP(?)\n" +
                     "        OR FIRST_NAME LIKE ? \n" +
                     "        OR INITCAP(FIRST_NAME) LIKE INITCAP(?))\n" +
                     "        AND SALARY > ?")) {
            ps.setString(1, "%" + str);
            ps.setString(2, "%" + str + "%");
            ps.setString(3, str + "%");
            ps.setInt(4, salary);
            rs = ps.executeQuery();
            List<EmployeeNameSalaryInfo> EmployeeNameSalaryInfoList = new ArrayList<>();

            while (rs.next()) {
                EmployeeNameSalaryInfoList.add(new EmployeeNameSalaryInfo(
                        rs.getInt("EMPLOYEE_ID"),
                        rs.getString("FIRST_NAME"),
                        rs.getInt("SALARY")));
            }
            for (EmployeeNameSalaryInfo info : EmployeeNameSalaryInfoList) {
                System.out.println(info.toString());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (rs != null) {
                rs.close();
            }
        }

    }

    public static void main(String[] args) throws SQLException {
       new EmpManager().printEmployee("al", 4000);
    }
}
