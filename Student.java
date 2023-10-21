package in.co.Edviron.SchoolFeeManagement.Bean;

public class Student {

    private int rollNo;
    private String name;
    private int studentClass;
    private int contact;

    public Student(int rollNo, String name, int studentClass, int contact) {
        this.rollNo = rollNo;
        this.name = name;
        this.studentClass = studentClass;
        this.contact = contact;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(int studentClass) {
        this.studentClass = studentClass;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }
}


