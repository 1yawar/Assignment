package in.co.Edviron.SchoolFeeManagement.Service;

import in.co.Edviron.SchoolFeeManagement.Bean.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Calendar;


@Service
public class PaymentService {

    @Autowired
    JdbcTemplate jdbcTemplate;
    int frequency_months;

    public String feePayment(Payment payment)
    {
        try (Connection connection = jdbcTemplate.getDataSource().getConnection();)
        {
            PreparedStatement preparedStatement = connection.prepareStatement("select student_name from student where school_id=? and Student_roll_no=?");
            preparedStatement.setInt(1, payment.getSchoolId());
            preparedStatement.setInt(2, payment.getRoll_no());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
            {
                String query1 = "insert into transaction(school_id,student_roll_no,fee_head_name,amount,transaction_date) values(?,?,?,?,current_date())";
                PreparedStatement preparedStatement1 = connection.prepareStatement(query1);
                preparedStatement1.setInt(1, payment.getSchoolId());
                preparedStatement1.setInt(2, payment.getRoll_no());
                preparedStatement1.setString(3, payment.getFeeHead());
                preparedStatement1.setInt(4, payment.getAmount());
                preparedStatement1.execute();
                Date date = Date.valueOf(LocalDate.now());
                String query2 = "select end_date from student where school_id=? and Student_roll_no=?";
                PreparedStatement preparedStatement2 = connection.prepareStatement(query2);
                preparedStatement2.setInt(1, payment.getSchoolId());
                preparedStatement2.setInt(2, payment.getRoll_no());
                ResultSet resultSet1 = preparedStatement2.executeQuery();
                if (resultSet1.next())
                {
                    int compareDate = date.compareTo(resultSet1.getDate(1));
                    if (compareDate >= 1) {
                        String query = "insert into fee_defaulters values(?,?,?,?,current_date())";
                        PreparedStatement preparedStatement3 = connection.prepareStatement(query);
                        preparedStatement3.setInt(1, payment.getSchoolId());
                        preparedStatement3.setInt(2, payment.getRoll_no());
                        preparedStatement3.setString(3, resultSet.getString(1));
                        preparedStatement3.setDate(4, resultSet1.getDate(1));
                        preparedStatement3.execute();
                        String query8="select frequency_months from fee_head where fee_head_name=?";
                        PreparedStatement preparedStatement4=connection.prepareStatement(query8);
                        preparedStatement4.setString(1,payment.getFeeHead());
                        ResultSet resultSet2=preparedStatement4.executeQuery();
                        if (resultSet2.next())
                        {
                            frequency_months=resultSet2.getInt(1);
                        }
                        Date date1 =resultSet1.getDate(1);
                        PreparedStatement preparedStatement5=connection.prepareStatement("UPDATE student SET end_date = DATE_ADD(?, INTERVAL ? MONTH) WHERE school_id = ? AND student_roll_no = ?");
                        preparedStatement5.setDate(1,date1);
                        preparedStatement5.setInt(2,frequency_months);
                        preparedStatement5.setInt(3,payment.getSchoolId());
                        preparedStatement5.setInt(4,payment.getRoll_no());
                        preparedStatement5.executeUpdate();
                        System.out.println("hello");

                    }
                     else {
                        String query9="select frequency_months from fee_head where fee_head_name=?";
                        PreparedStatement preparedStatement4=connection.prepareStatement(query9);
                        preparedStatement4.setString(1,payment.getFeeHead());
                        ResultSet resultSet2=preparedStatement4.executeQuery();
                        if (resultSet2.next())
                        {
                            frequency_months=resultSet2.getInt(1);
                        }
                        Date date1 =resultSet1.getDate(1);
                        PreparedStatement preparedStatement5=connection.prepareStatement("UPDATE student SET end_date = DATE_ADD(?, INTERVAL ? MONTH) WHERE school_id = ? AND student_roll_no = ?");
                        preparedStatement5.setDate(1,date1);
                        preparedStatement5.setInt(2,frequency_months);
                        preparedStatement5.setInt(3,payment.getSchoolId());
                        preparedStatement5.setInt(4,payment.getRoll_no());
                        preparedStatement5.executeUpdate();
                    }

                }
               

                return "Transaction is successful";
            }
            else
            {
                return "roll_No or school_Id are Invalid";
            }

        } catch (Exception e)
        {
            return "Something went wrong.... Please try after some time";
        }
    }
}
