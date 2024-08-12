package AssignmentFolder.day0812;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class EmployeeSalaryInfo {
    private int EmployeeID;
    private String DepartmentName;
    private int Salary;
    private int AvgSalary;

    EmployeeSalaryInfo (int EmployeeID, String DepartmentName, int Salary, int AvgSalary) {
        this.EmployeeID = EmployeeID;
        this.DepartmentName = DepartmentName;
        this.Salary = Salary;
        this.AvgSalary = AvgSalary;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(EmployeeID);
        sb.append("\t\t\t\t\t\t");
        sb.append(DepartmentName);
        sb.append("\t\t\t\t\t\t");
        sb.append(Salary);
        sb.append("\t\t\t\t\t\t");
        sb.append(AvgSalary);

        return sb.toString();
    }

}

public class Prob5 {
    public Connection getConnection(String url, String user, String password) throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }


    public void printInfo(String url, String id, String password, String dept_id)  {
        ResultSet rs = null;
        try (Connection connection = getConnection(url, id, password)){
             PreparedStatement ps = connection.prepareStatement("SELECT EMPLOYEE_ID,\n" +
                     "       D.DEPARTMENT_NAME,\n" +
                     "       E.SALARY,\n" +
                     "       AVGE.AVG_SAL AS AVG_SAL \n" +
                     "FROM EMPLOYEES E\n" +
                     "         INNER JOIN (SELECT TRUNC(AVG(SALARY), 0) AS \"AVG_SAL\",\n" +
                     "                            DEPARTMENT_ID         AS \"DID\"\n" +
                     "                     FROM EMPLOYEES\n" +
                     "                     GROUP BY DEPARTMENT_ID) AVGE ON E.DEPARTMENT_ID = AVGE.DID\n" +
                     "         INNER JOIN DEPARTMENTS D ON E.DEPARTMENT_ID = D.DEPARTMENT_ID\n" +
                     "WHERE AVGE.DID = ?");
            ps.setInt(1, Integer.valueOf(dept_id));

            rs = ps.executeQuery();
            ResultSetMetaData rsmd;

            List<EmployeeSalaryInfo> EmployeeSalaryInfoList = new ArrayList<>();

            while (rs.next()) {
                EmployeeSalaryInfoList.add(new EmployeeSalaryInfo(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4)));
            }

            rsmd = rs.getMetaData();
            for (int i = 1; i < rsmd.getColumnCount() + 1; i++) {
                System.out.print(rsmd.getColumnName(i) + "\t\t\t\t\t");
            }
            System.out.println("");

            for (EmployeeSalaryInfo info : EmployeeSalaryInfoList) {
                System.out.println(info.toString());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("부서의 아이디를 입력하세요");
            System.exit(1);
        }
        String dept_id = args[0];

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
            String user = "hr";
            String password = "hr";
            Prob5 p = new Prob5();
            p.printInfo(url, user, password, dept_id);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
