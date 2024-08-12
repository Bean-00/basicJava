package AssignmentFolder.day0812;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class EmployeeNameSalaryInfo2 {
    private int EmployeeID;
    private String FirstName;
    private int Salary;

    EmployeeNameSalaryInfo2(int EmployeeID, String FirstName, int Salary) {
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

public class EmpManager2 {
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

    public void printEmployee(String[] jobs) throws SQLException {
        ResultSet rs = null;
        try (Connection connection = getConnection()) {
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT\n");
            sb.append("E.EMPLOYEE_ID,\n");
            sb.append("E.FIRST_NAME,\n");
            sb.append("E.SALARY\n");
            sb.append("FROM JOBS J INNER JOIN EMPLOYEES E ON J.JOB_ID = E.JOB_ID\n");
            int count = 0;
            while (count < jobs.length) {
                if (count == 0 ) {
                    sb.append("WHERE J.JOB_TITLE = ?");
                }
                if (count != 0 && count < jobs.length) {
                    sb.append(" OR \n");
                    sb.append("J.JOB_TITLE = ?");
                }
                count++;
            }
            PreparedStatement ps = connection.prepareStatement(sb.toString());
            for (int i = 0; i < jobs.length; i++) {
                ps.setString(i + 1, jobs[i]);
            }
            rs = ps.executeQuery();
            List<EmployeeNameSalaryInfo2> EmployeeNameSalaryInfoList = new ArrayList<>();

            while (rs.next()) {
                EmployeeNameSalaryInfoList.add(new EmployeeNameSalaryInfo2(
                        rs.getInt("EMPLOYEE_ID"),
                        rs.getString("FIRST_NAME"),
                        rs.getInt("SALARY")));
            }
            for (EmployeeNameSalaryInfo2 info : EmployeeNameSalaryInfoList) {
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
        String[] jobs = {"Accountant", "Stock Clerk"};
        new EmpManager2().printEmployee(jobs);
    }
}
