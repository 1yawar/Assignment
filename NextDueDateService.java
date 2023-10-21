package in.co.Edviron.SchoolFeeManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

@Service
public class NextDueDateService {

    @Autowired
    JdbcTemplate jdbcTemplate;
    public String nextDueDate(int school_id, int roll_no)
    {
        try(Connection connection=jdbcTemplate.getDataSource().getConnection();)
        {
            PreparedStatement preparedStatement=connection.prepareStatement("select end_date from student where school_id=? and Student_roll_no=?");
            preparedStatement.setInt(1,school_id);
            preparedStatement.setInt(2,roll_no);
            ResultSet resultSet=preparedStatement.executeQuery();
            if (resultSet.next())
            {
                return resultSet.getDate(1).toString();
            }
            else
                return "Invalid details";
        }
        catch (Exception e)
        {
            return "Something went wrong.... Please try after some time";
        }
    }

}
