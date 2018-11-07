//
package Entity;

import company.Tolls;
import javax.swing.JTable;

public class Employee implements mainData{
     private int EmpNO;
     private String EmpName;
     private String Addres;
     private double Salary;
     private String HiringDate;
     private String BirthDate;
     private int DeptNO;

    public int getEmpNO() {
        return EmpNO;
    }

    public void setEmpNO(int EmpNO) {
        this.EmpNO = EmpNO;
    }

    public String getEmpName() {
        return EmpName;
    }

    public void setEmpName(String EmpName) {
        this.EmpName = EmpName;
    }

    public String getAddres() {
        return Addres;
    }

    public void setAddres(String Addres) {
        this.Addres = Addres;
    }

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double Salary) {
        this.Salary = Salary;
    }

    public String getHiringDate() {
        return HiringDate;
    }

    public void setHiringDate(String HiringDate) {
        this.HiringDate = HiringDate;
    }

    public String getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(String BirthDate) {
        this.BirthDate = BirthDate;
    }

    public int getDeptNO() {
        return DeptNO;
    }

    public void setDeptNO(int DeptNO) {
        this.DeptNO = DeptNO;
    }

    @Override
    public void add() {
       String steInsert= "insert into employee values ("
               + EmpNO +",'"
               + EmpName + "','"
               + Addres + "',"
               + Salary + ",'"
               + HiringDate + "','"
               + BirthDate +"',"
               + DeptNO + ")";
       
       boolean isAdd = db.go.runNonQuery(steInsert);
       if(isAdd){
        Tolls.MsgBox("The Employee " + EmpName + " Is Added");
       }
    }

    @Override
    public void update() {
        String strUpdate ="update employee set " 
                + "EmpName = '" + EmpName + "' , " 
                + "Addres = '" + Addres + "' , "
                + "Salary = " + Salary + " , "
                + "HiringDate = '" + HiringDate + "' , "
                + "BirthDate = '" + BirthDate+"' , "
                + "DeptNO = " + DeptNO 
                + " where EmpNO = " + EmpNO;
        boolean isUpdate = db.go.runNonQuery(strUpdate);
        if (isUpdate){
        Tolls.MsgBox("The Employee "+EmpName+" Is Updated");
        }
    }

    @Override
    public void delete() {
        String strDelete = "delete from employee where EmpNO = "+ EmpNO;
        boolean IsDelete = db.go.runNonQuery(strDelete);
        if(IsDelete){
        Tolls.MsgBox("The Employee "+EmpName+" Is Deleted");
        }
    }

    @Override
    public String getAutoNumber() {
        return db.go.getAoutoNumber("employee", "EmpNO");
    }

    @Override
    public void getAllRows(JTable table) {
        db.go.fillToJTable("employee_data", table);
    }

    @Override
    public void getOneRows(JTable table) {
        String strSelect = "select * from employee_data where Number = " + EmpNO;
        db.go.fillToJTable(strSelect, table);
    }

    @Override
    public void getCustomRows(String statment, JTable table) {
        db.go.fillToJTable(statment, table);
    }

    @Override
    public String getValueByName(String name) {
        String strSelect = "select EmpNo from employee where EmpName = '" + name + "'";
        String strval = db.go.getTableData(strSelect).Names[0][0].toString();
        return strval;
    }

    @Override
    public String getNameByValue(String value) {
        String strSelect = "select EmpName from employee where EmpNO = " + value ;
        String strName = db.go.getTableData(strSelect).Names[0][0].toString();
        return strName;
    }
     
     
     
}
