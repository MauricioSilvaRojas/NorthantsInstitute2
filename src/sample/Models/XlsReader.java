package sample.Models;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * Created by regga on 22/04/2017.
 */
public class XlsReader {
    List<Student> studentList;
    String path;

    public XlsReader(String path) {
        this.path = path;
    }

    public List<Student> getStudentList() throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(path));
        HSSFSheet sheet = workbook.getSheetAt(0);
        HSSFRow row=sheet.getRow(0);
        String result=row.getCell(0).toString();
        System.out.println("Read from file row :"+result);
        FormulaEvaluator formulaEvaluator=workbook.getCreationHelper().createFormulaEvaluator();

        int n=0;


        for (Row row1:sheet){
            Student student=new Student();
            for(Cell cell: row1)
            {

                result= row1.getCell(cell.getColumnIndex()).toString();
                //System.out.println("Read from file row :"+result);
                switch (cell.getColumnIndex()){
                    case 0:
                        student.setStudentCode(result);
                        System.out.println("Student Code :" + result);
                        break;
                    case 1:
                        student.setName(result);
                        System.out.println("Student Name :" + result);
                        break;
                    case 2:
                        student.setSurName(result);
                        System.out.println("Student Surname :" + result);
                        break;
                    case 3:
                        student.setAddress(result);
                        System.out.println("Student Address :" + result);
                        break;
                    case 4:
                        student.setPostCode(result);
                        System.out.println("Student postCode :" + result);
                        break;
                    case 5:
                        student.setEmail(result);
                        System.out.println("Student email :" + result);
                        break;
                    case 6:
                        student.setMobileNumber(result);
                        System.out.println("Student mobileNUmber :" + result);
                        break;
                    case 7:
                        student.setCourseName(result);
                        System.out.println("Student CourseName :" + result);
                        break;
                    case 8:
                        student.setEnrollmentYear(result);
                        System.out.println("Student enrollmentYear :" + result);
                        break;
                    case 9:
                        student.setCourseFees(result);
                        System.out.println("Student courseFees :" + result);
                        break;
                    case 10:
                        student.setDissertationTitle(result);
                        System.out.println("Student DissertationTable :" + result);
                        student.createNewStudent(student);
                        break;
                }
            }
        }

        return studentList;
    }
}
