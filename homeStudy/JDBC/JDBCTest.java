package homeStudy.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCTest {


    public static void main(String[] args) throws ClassNotFoundException {
        BeanDAO beanDAO = new BeanDAO();

        beanDAO.add(new BeanVO("Test"));

        List<BeanVO> beanlist = beanDAO.findAll();

        for (BeanVO bean : beanlist) {
            System.out.println(bean.toString());
        }

    }


}

class BeanDAO {
    public List<BeanVO> findAll() {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT ID, NAME FROM BEAN");
             ResultSet resultSet = preparedStatement.executeQuery()) {
            List<BeanVO> beanList = new ArrayList<>();

            while (resultSet.next()) {
                beanList.add(new BeanVO(resultSet.getInt("ID"), resultSet.getString("NAME")));
            }
            return beanList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void add(BeanVO beanVO) {

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO BEAN(ID, NAME) VALUES(BEAN_SEQ.nextval, ?)")) {
            preparedStatement.setString(1, beanVO.getName());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(BeanVO beanVO) {

    }

    public void delete(BeanVO beanVO) {

    }


    public Connection getConnection() throws SQLException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            return DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "hr", "hr");

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}

    class BeanVO {
        private int id;
        private String name;

        public BeanVO(String name) {
            this.name = name;
        }

        public BeanVO(int id, String value) {
            this.id = id;
            this.name = value;
        }

        public String getName() {
            return this.name;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();

            builder.append("Bean [id=");
            builder.append(id);
            builder.append(", name=");
            builder.append(name);
            builder.append("]");

            return builder.toString();
        }
    }