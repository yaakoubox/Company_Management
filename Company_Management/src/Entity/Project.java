//
package Entity;

import company.Tolls;
import javax.swing.JTable;

public class Project implements mainData {

    private int ProjectNO;
    private String ProjectName;
    private String Location;
    private int DeptNO;

    public int getProjectNO() {
        return ProjectNO;
    }

    public void setProjectNO(int ProjectNO) {
        this.ProjectNO = ProjectNO;
    }

    public String getProjectName() {
        return ProjectName;
    }

    public void setProjectName(String ProjectName) {
        this.ProjectName = ProjectName;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public int getDeptNO() {
        return DeptNO;
    }

    public void setDeptNO(int DeptNO) {
        this.DeptNO = DeptNO;
    }

    @Override
    public void add() {
        String strInsert = "insert into project values("
                + ProjectNO + ",'"
                + ProjectName + "','"
                + Location + "',"
                + DeptNO + ")";
        boolean isAdd = db.go.runNonQuery(strInsert);
        if (isAdd) {
            Tolls.MsgBox("The Project " + ProjectName + " Is Added");
        }
    }

    @Override
    public void update() {
        String strUpdate = "update project set "
                + " ProjectName ='" + ProjectName + "',"
                + " Location ='" + Location + "',"
                + " DeptNO = " + DeptNO
                + " where ProjectNO = " + ProjectNO;
        boolean isUpdated = (db.go.runNonQuery(strUpdate));
        if (isUpdated) {
            Tolls.MsgBox("The Project " + ProjectName + " Is Updated");
        }
    }

    @Override
    public void delete() {
        String strDelete = "delete from project where ProjectNO =" + ProjectNO;
        boolean isDelete = db.go.runNonQuery(strDelete);
        if (isDelete) {
            Tolls.MsgBox("The Project " + ProjectName + " Is Deleted");
        }
    }

    @Override
    public String getAutoNumber() {
        return db.go.getAoutoNumber("project", "ProjectNO");
    }

    @Override
    public void getAllRows(JTable table) {
        db.go.fillToJTable("project_data", table);
    }

    @Override
    public void getOneRows(JTable table) {
        String strSelect = "select * from project_data where NUMBER =" + ProjectNO;
        db.go.fillToJTable(strSelect, table);
    }

    @Override
    public void getCustomRows(String statment, JTable table) {
        db.go.fillToJTable(statment, table);
    }

    @Override
    public String getValueByName(String name) {
        String strSelct = "select ProjectNO from project where ProjectName ='" + name + "'";
        String strValue = (String) db.go.getTableData(strSelct).Names[0][0];
        return strValue;
    }

    @Override
    public String getNameByValue(String value) {
        String strSelct = "select ProjectName from project where ProjectNO =" + value;
        String strName = (String) db.go.getTableData(strSelct).Names[0][0];
        return strName;
    }

}
