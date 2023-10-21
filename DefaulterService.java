package in.co.Edviron.SchoolFeeManagement.Service;

import in.co.Edviron.SchoolFeeManagement.Bean.FeeDefaulter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Service
public class DefaulterService {

    @Autowired
    JdbcTemplate jdbcTemplate;
    public List<FeeDefaulter> feeDefaulters()
    {
        try(Connection connection=jdbcTemplate.getDataSource().getConnection();)
        {
            List<FeeDefaulter> list=new ArrayList<>();
            PreparedStatement preparedStatement=connection.prepareStatement("select * from fee_defaulters");
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next())
            {
                FeeDefaulter feeDefaulter=new FeeDefaulter(resultSet.getInt(1),resultSet.getInt(2),resultSet.getString(3),resultSet.getDate(4),resultSet.getDate(5));
                list.add(feeDefaulter);
            }
            return list;
        }catch (Exception e)
        {
            return null;
        }
    }
}
