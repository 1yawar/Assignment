package in.co.Edviron.SchoolFeeManagement.Service;

import in.co.Edviron.SchoolFeeManagement.Bean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    JdbcTemplate jdbcTemplate;
    public List<Student> getStudent(int schoolId)
    {
        try(Connection connection= jdbcTemplate.getDataSource().getConnection();)
        {
            String query="select student_roll_no,student_name,class,contact from student where school_id=?";
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setInt(1,schoolId);
            ResultSet resultSet=preparedStatement.executeQuery();
            List<Student> list=new ArrayList<>();
            while (resultSet.next())
            {
                Student student=new Student(resultSet.getInt(1),resultSet.getString(2),
                    resultSet.getInt(3),resultSet.getInt(4));
                list.add(student);
            }
            return list;

        }
        catch (Exception e)
        {
            return null;
        }

    }
}
