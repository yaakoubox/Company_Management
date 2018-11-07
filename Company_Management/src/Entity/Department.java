//
package Entity;

import company.Tolls;
import javax.swing.JTable;


public class Department implements mainData{
    private int DeptNO;
    private String  DeptNAME;
    private String Location;

    public int getDeptNO() {
        return DeptNO;
    }

    public void setDeptNO(int DeptNO) {
        this.DeptNO = DeptNO;
    }

    public String getDeptNAME() {
        return DeptNAME;
    }

    public void setDeptNAME(String DeptNAME) {
        this.DeptNAME = DeptNAME;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    @Override
    public void add() {
       String strInsert = "insert into department VALUES("
               + DeptNO + ",'"
               + DeptNAME + "','"
               + Location + "')";
       boolean isAdd = db.go.runNonQuery(strInsert);
       if(isAdd){
           Tolls.MsgBox("Department "+ DeptNAME +" Is Added");
       }
    }

    @Override
    public void update() {
        String strUpdate="UPDATE department set "+
                      " DeptNAME='"+ DeptNAME + "',"
                      +"Location='"+ Location +"'"
                      +"where DeptNO="+ DeptNO ;
        boolean isUpdate = db.go.runNonQuery(strUpdate);
        if(isUpdate){
        Tolls.MsgBox("Department "+ DeptNAME +" Is Updated");
        }
    }

    @Override
    public void delete() {
        String strDelete = "delete from department where DeptNO = "+ DeptNO;
        boolean isDelete = db.go.runNonQuery(strDelete);
        if (isDelete){
                Tolls.MsgBox("Department "+ DeptNAME +" Is Deleted");
        }
    }
    
      @Override
    public String getAutoNumber() {
       String getAuto = db.go.getAoutoNumber("department", "DeptNO");
       return getAuto;
    }
    
    @Override
    public void getAllRows(JTable table) {
        db.go.fillToJTable("department", table);
    }

    @Override
    public void getOneRows(JTable table) {
        String strSelect = "select * from department where DeptNO =" + DeptNO;
        db.go.fillToJTable(strSelect, table);
    }

    @Override
    public void getCustomRows(String statment, JTable table) {
        db.go.fillToJTable(statment, table);
    }

    @Override
    public String getValueByName(String name) {
        String strSelect = 
                "select DeptNO from department "+ "where DeptNAME ='" + name + "'";
                
        String strVal = (String)db.go.getTableData(strSelect).Names[0][0];
        return strVal;
    }

    @Override
    public String getNameByValue(String value) {
        String strSelect = "select DeptName from department "
                + "where DeptNO =" + value  ;
        String strName= (String)db.go.getTableData(strSelect).Names[0][0];
        return strName;
    }

  
}
