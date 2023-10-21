package in.co.Edviron.SchoolFeeManagement.Bean;

public class Payment {

    private int schoolId;
    private int roll_no;
    private String feeHead;
    private int amount;

    public Payment(int schoolId, int roll_no, String feeHead, int amount) {
        this.schoolId = schoolId;
        this.roll_no = roll_no;
        this.feeHead = feeHead;
        this.amount = amount;
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

    public String getFeeHead() {
        return feeHead;
    }

    public void setFeeHead(String feeHead) {
        this.feeHead = feeHead;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
