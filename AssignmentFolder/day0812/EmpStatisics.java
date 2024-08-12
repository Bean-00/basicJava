//2.3

package AssignmentFolder.day0812;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class JobTitleSalaryInfo {
    private String JobTitle;
    private int Salary;

    JobTitleSalaryInfo(String jobTitle, int salary) {
        this.JobTitle = jobTitle;
        this.Salary = salary;
    }

    public int getSalary() {
        return Salary;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("[");
        builder.append(JobTitle);
        builder.append("] ");
        builder.append(Salary);

        return builder.toString();
    }


}

public class EmpStatisics {
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

    public void printStatistics(int maxSalary) throws SQLException {
        System.out.println("===========================");
        System.out.println("maxSalary: "+ maxSalary);
        System.out.println("===========================");
        ResultSet rs = null;
        try (Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT\n" +
                    "    J.JOB_TITLE,\n" +
                    "    AVG(E.SALARY)\n" +
                    "FROM EMPLOYEES E INNER JOIN JOBS J ON E.JOB_ID = J.JOB_ID\n" +
                    "WHERE E.SALARY > ? \n" +
                    "GROUP BY J.JOB_TITLE\n" +
                    "ORDER BY AVG(E.SALARY) DESC")) {
            ps.setInt(1, maxSalary);
            rs = ps.executeQuery();
            List<JobTitleSalaryInfo> jobTitleSalaryInfoList = new ArrayList<>();

            while (rs.next()) {
                jobTitleSalaryInfoList.add(new JobTitleSalaryInfo(rs.getString(1), rs.getInt(2)));
            }
            for (JobTitleSalaryInfo jobTitleSalaryInfo : jobTitleSalaryInfoList) {
                System.out.println(jobTitleSalaryInfo.toString());
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
        int maxSalary = 10000;
        new EmpStatisics().printStatistics(maxSalary);

        maxSalary = 15000;
        new EmpStatisics().printStatistics(maxSalary);
    }
}

