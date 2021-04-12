import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Solution {
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Pleas enter the birthday date in this pattern dd-MM-yyyy");
        String birthDayString = reader.readLine();
        reader.close();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Calendar birthDay = new GregorianCalendar();
        birthDay.setTime(format.parse(birthDayString));
        Calendar now = Calendar.getInstance();
        Calendar nearestBirthDayDate = birthDay;
        nearestBirthDayDate.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));
        if(now.before(nearestBirthDayDate)) {
            Long timeUntilBirthDay = nearestBirthDayDate.getTimeInMillis() - now.getTimeInMillis();
            System.out.println(timeUntilBirthDay/86400000);
        } else {
            nearestBirthDayDate.set(1,Calendar.getInstance().get(1) + 1);
            Long timeUntilBirhDay = nearestBirthDayDate.getTimeInMillis() - now.getTimeInMillis();
            System.out.println(timeUntilBirhDay/86400000);
        }
    }
}
