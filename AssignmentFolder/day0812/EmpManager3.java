package AssignmentFolder.day0812;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class NameDeptInfo {
    private String FirstName;
    private String DeptName;

    NameDeptInfo(String FirstName, String DeptName) {
        this.DeptName = DeptName;
        this.FirstName = FirstName;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append(FirstName);
        builder.append("\t");
        builder.append(DeptName);

        return builder.toString();
    }
}

public class EmpManager3 {
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

    public void printEmployee3(String city, int lo, int hi) throws SQLException {
        ResultSet rs = null;
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT\n" +
                     "    E.FIRST_NAME,\n" +
                     "    D.DEPARTMENT_NAME\n" +
                     "FROM\n" +
                     "    EMPLOYEES E LEFT OUTER JOIN  DEPARTMENTS D ON E.DEPARTMENT_ID = D.DEPARTMENT_ID\n" +
                     "                LEFT OUTER JOIN LOCATIONS L ON D.LOCATION_ID = L.LOCATION_ID\n" +
                     "WHERE L.CITY = ?\n" +
                     "    AND SALARY BETWEEN ? AND ?")) {
            ps.setString(1, city);
            ps.setInt(2, lo);
            ps.setInt(3, hi);


            rs = ps.executeQuery();
            List<NameDeptInfo> NameDeptInfoList = new ArrayList<>();

            while (rs.next()) {
                NameDeptInfoList.add(new NameDeptInfo(
                        rs.getString(1),
                        rs.getString(2)));
            }
            for (NameDeptInfo info : NameDeptInfoList) {
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
        new EmpManager3().printEmployee3("South San Francisco", 7000, 10000);
    }
}
