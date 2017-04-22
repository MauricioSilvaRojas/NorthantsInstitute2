package sample.Models;

/**
 * Created by regga on 17/04/2017.
 */
public class Assessment {
    private String moduleID;
    private String grade;
    private String lecturer;

    public Assessment(String moduleID, String grade) {
        this.moduleID = moduleID;
        this.grade = grade;
    }

    public String getModuleID() {
        return moduleID;
    }

    public void setModuleID(String moduleID) {
        this.moduleID = moduleID;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
