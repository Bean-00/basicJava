package AssignmentFolder.day0812;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class CityDeptInfo {
    private String city;
    private String dept_name;
    private String first_name;
    private int salary;

    CityDeptInfo(String city, String dept_name, String first_name, int salary) {
        this.city = city;
        this.dept_name = dept_name;
        this.first_name = first_name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append(city);
        builder.append("\t");
        builder.append(dept_name);
        builder.append("\t");
        builder.append(first_name);
        builder.append("\t");
        builder.append(salary);

        return builder.toString();
    }

}

public class Prob6 {
    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "hr", "bean1234");
    }

    private static void printEmployeeList (String cityName, String deptName) throws Exception {
        ResultSet rs = null;
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT L.CITY,\n" +
                     "       D.DEPARTMENT_NAME,\n" +
                     "       E.FIRST_NAME,\n" +
                     "       TRUNC(E.SALARY, 0)\n" +
                     "FROM EMPLOYEES E\n" +
                     "         LEFT OUTER JOIN DEPARTMENTS D ON E.DEPARTMENT_ID = D.DEPARTMENT_ID\n" +
                     "         LEFT OUTER JOIN LOCATIONS L ON D.LOCATION_ID = L.LOCATION_ID\n" +
                     "WHERE ((LOWER(L.CITY) LIKE LOWER(?))\n" +
                     "    OR (LOWER(L.CITY) LIKE ?)\n" +
                     "        OR (INITCAP(L.CITY) LIKE INITCAP(?)))\n" +
                     "    AND ((LOWER(D.DEPARTMENT_NAME) LIKE LOWER(?))\n" +
                     "        OR (LOWER(D.DEPARTMENT_NAME) LIKE ?)\n" +
                     "            OR (INITCAP(D.DEPARTMENT_NAME) LIKE INITCAP(?)))")) {
            ps.setString(1, "%" + cityName);
            ps.setString(2, "%" + cityName + "%");
            ps.setString(3, cityName + "%");
            ps.setString(4, "%" + deptName);
            ps.setString(5, "%" + deptName + "%");
            ps.setString(6, deptName + "%");

            rs = ps.executeQuery();
            List<CityDeptInfo> CityDeptInfoList = new ArrayList<>();

            while (rs.next()) {
                CityDeptInfoList.add(new CityDeptInfo(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4)));
            }
            for (CityDeptInfo info : CityDeptInfoList) {
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

    public static void main(String[] args) throws Exception {
        printEmployeeList("lon", "resource");
    }





}
