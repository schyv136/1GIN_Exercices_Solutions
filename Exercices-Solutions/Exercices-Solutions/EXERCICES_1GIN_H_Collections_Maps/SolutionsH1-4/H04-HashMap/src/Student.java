
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 *
 * @author fred
 */
public class Student {
    
    private String untis;
    
    private String name;
    private String givenName;
    private String address;
    private String grade;
    private Calendar birthday;


    public Student(String untis, String name, String givenName, String address, String grade, Calendar birthday) {
        this.untis = untis;
        this.name = name;
        this.givenName = givenName;
        this.address = address;
        this.grade = grade;
        this.birthday = birthday;
    }

    public String getUntis() {
        return untis;
    }

    public Calendar getBirthday() {
        return birthday;
    }

    public String getGrade() {
        return grade;
    }

    public String getAddress() {
        return address;
    }

    public String getGivenName() {
        return givenName;
    }

    public String getName() {
        return name;
    }

    public String birthdayAsString() {
        SimpleDateFormat df = new SimpleDateFormat();
        df.applyPattern("dd/MM/yyyy");
        return df.format(birthday.getTime());
    }
    
    @Override
    public String toString() {
        return "["+untis+"] "+givenName + " "+name+" (" + address + ") - " + 
                grade + " *" + birthdayAsString();
    }
    
    

}
