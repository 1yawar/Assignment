package in.co.Edviron.SchoolFeeManagement.Bean;
import java.sql.Date;

public class FeeDefaulter {

    private int schoolId;
    private int roll_no;

    private String name;

    private Date dueDate;

    private Date paymentDate;

    public FeeDefaulter(int schoolId, int roll_no, String name, Date dueDate, Date paymentDate) {
        this.schoolId = schoolId;
        this.roll_no = roll_no;
        this.name = name;
        this.dueDate = dueDate;
        this.paymentDate = paymentDate;
    }

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    public int getRoll_no() {
        return roll_no;
    }

    public void setRoll_no(int roll_no) {
        this.roll_no = roll_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Data paymentDate) {
        this.paymentDate = (Date) paymentDate;
    }
}
