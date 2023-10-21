package in.co.Edviron.SchoolFeeManagement.Bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.*;
import java.time.LocalDate;

public class Test {


    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/schoolfeemanagement", "root", "root");) {

            PreparedStatement preparedStatement=connection.prepareStatement("select default_count from fee_defaulters where school_id=? and roll_no=?");
            preparedStatement.setInt(1,7);
            preparedStatement.setInt(2,1);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next())
            {
                System.out.println(resultSet.getInt(1));
            }
        } catch (Exception e) {

        }
    }
}
