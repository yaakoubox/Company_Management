//
package Entity;

import company.Tolls;
import java.sql.SQLException;
import javax.swing.JTable;

public class Employee_Phones implements mainData {

    private int EmpNO;
    private String Phone;

    public int getEmpNO() {
        return EmpNO;
    }

    public void setEmpNO(int EmpNO) {
        this.EmpNO = EmpNO;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    @Override
    public void add() {
        String strAdd = "insert into employee_phones values("
                + EmpNO + ", '"
                + Phone + "')";
        boolean isAdd = db.go.runNonQuery(strAdd);
        if (isAdd) {
            //Tolls.MsgBox("The Phone Number Is Added");
        }

    }

    @Override
    public void update() {
        Tolls.MsgBox("Update Method In Employee_Phones Class Not Not Working !! ");
    }

    @Override
    public void delete() {
        String strDelete = "delete from employee_phones where EmpNO = " + EmpNO + " and phone= '" + Phone + "'";
        boolean isDeleted = db.go.runNonQuery(strDelete);
        if (isDeleted) {
            //Tolls.MsgBox("The Phone Number Is Deleted");
        }
    }

    public void deleteByEmp() {
        String strDelete = "delete from employee_phones where EmpNO = " + EmpNO;
        boolean isDeleted = db.go.runNonQuery(strDelete);
        if (isDeleted) {
            //Tolls.MsgBox("The Phone Numbers Is Deleted");
        }
    }

    @Override
    public String getAutoNumber() {
        Tolls.MsgBox("getAutoNumber Method In Employee_Phones Class Not Not Working !! ");
        return "";
    }

    @Override
    public void getAllRows(JTable table) {
        String strSelect = "select phone from Employee_Phones where EmpNO=" + EmpNO;
        db.go.fillToJTable(strSelect, table);
    }

    @Override
    public void getOneRows(JTable table) {
        Tolls.MsgBox("getOneRows Method In Employee_Phones Class Not Not Working !! ");
    }

    @Override
    public void getCustomRows(String statment, JTable table) {
        Tolls.MsgBox("getCustomRows Method In Employee_Phones Class Not Not Working !! ");

    }

    @Override
    public String getValueByName(String name) {
        Tolls.MsgBox("getValueByName Method In Employee_Phones Class Not Not Working !! ");
        return "";
    }

    @Override
    public String getNameByValue(String value) {
        Tolls.MsgBox("getNameByValue Method In Employee_Phones Class Not Not Working !! ");
        return "";
    }
    public String getEmpNOByPhone(String requestphone){
        String strSelect = "select EmpNO from Employee_Phones where Phone ='"+requestphone+"'";
        
        Object row[][] = db.go.getTableData(strSelect).Names;
        String strEmpNO = "";
        if(row.length>0){
        strEmpNO = (String)row[0][0];
        }
        else{
        strEmpNO="0";
        }
        return strEmpNO;
    }
}
