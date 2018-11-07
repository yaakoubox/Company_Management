//
package Entity;

import company.Tolls;
import javax.swing.JTable;


public class Workon implements mainData{
    private int EmpNO;
    private int ProjectNO;

    public int getEmpNO() {
        return EmpNO;
    }

    public void setEmpNO(int EmpNO) {
        this.EmpNO = EmpNO;
    }

    public int getProjectNO() {
        return ProjectNO;
    }

    public void setProjectNO(int ProjectNO) {
        this.ProjectNO = ProjectNO;
    }

    @Override
    public void add() {
        String strinsert = "insert into workon values("+ EmpNO +","+ ProjectNO +")";
        boolean isAdd = db.go.runNonQuery(strinsert);
        if(isAdd){
            Tolls.MsgBox("Work On Is Added ...");
        }
    }

    @Override
    public void update() {
        Tolls.MsgBox("Update Method In workon Class Not Not Working !! ");
    }

    @Override
    public void delete() {
        
        String strinsert = "delete from workon where EmpNO = "+ EmpNO +" and ProjectNO = "+ProjectNO;
        boolean isdelete = db.go.runNonQuery(strinsert);
        if(isdelete){
            Tolls.MsgBox("Work On Is Deleted ...");
        }
        
    }

    @Override
    public String getAutoNumber() {
        Tolls.MsgBox("getAutoNumber Method In workon Class Not Not Working !! ");
        return "";
    }

    @Override
    public void getAllRows(JTable table) {
        String strSelect = "select * from workon_data   ";
        db.go.fillToJTable(strSelect, table);
    }

    @Override
    public void getOneRows(JTable table) {
        String strSelect = "select * from workon_data where EMPLOYEE_NO =" + EmpNO + " and PROJECT_NO = " + ProjectNO;
        db.go.fillToJTable(strSelect, table);
    }

    @Override
    public void getCustomRows(String statment, JTable table) {
        db.go.fillToJTable(statment, table);
    }

    @Override
    public String getValueByName(String name) {
       Tolls.MsgBox("getValueByName Method In workon Class Not Not Working !! ");
        return "";
    }

    @Override
    public String getNameByValue(String value) {
        Tolls.MsgBox("getNameByValue Method In workon Class Not Not Working !! ");
        return "";
    }
    
}
