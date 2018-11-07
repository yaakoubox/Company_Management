package company;

/*import Forms.frmDepartment;
import Forms.frmEmployee;
import Forms.frmLogin;
import Forms.frmProject;
import Forms.frmTest;*/
import Forms.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Company {

    public static void main(String[] args) throws InterruptedException {
    frmLoding r = new frmLoding();
    r.setVisible(true);
    r.setLocationRelativeTo(null);
    Thread.sleep(4000);
    r.setVisible(false);
    Tolls.OpenFormWithTitle("Login", new frmLogin());
       
    }
    
}
