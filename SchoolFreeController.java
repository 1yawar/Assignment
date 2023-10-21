package in.co.Edviron.SchoolFeeManagement.Controller;

import in.co.Edviron.SchoolFeeManagement.Bean.FeeDefaulter;
import in.co.Edviron.SchoolFeeManagement.Bean.Payment;
import in.co.Edviron.SchoolFeeManagement.Bean.Student;
import in.co.Edviron.SchoolFeeManagement.Service.DefaulterService;
import in.co.Edviron.SchoolFeeManagement.Service.NextDueDateService;
import in.co.Edviron.SchoolFeeManagement.Service.PaymentService;
import in.co.Edviron.SchoolFeeManagement.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SchoolFreeController {

    @Autowired
    StudentService studentService;
    @Autowired
    PaymentService paymentService;

    @Autowired
    NextDueDate nextDueDateService;
    @Autowired
    DefaulterService defaulterService;

    @GetMapping ("getStudents")

    public List<Student> getStudents(@RequestParam int schoolId)
    {
        List<Student> list=studentService.getStudent(schoolId);
        return list;
    }

    @PostMapping ("fee payment")
    public String feePayment(@RequestBody Payment payment)
    {
           String result= paymentService.feePayment(payment);
           return result;
    }

    @GetMapping ("next due date")
    public String nextdueDate(@RequestParam int school_id, int roll_no)
    {
        String result=nextDueDate.nextDueDate(school_id,roll_no);
        return result;
    }

   @GetMapping ("fee defaulter")

    public List<FeeDefaulter> feeDefaulters()
   {
       List<FeeDefaulter> list=defaulterService.feeDefaulters();
       return list;
   }

}
