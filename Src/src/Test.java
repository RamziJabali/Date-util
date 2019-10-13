import java.util.Scanner;

public class Test {
    private static Scanner kb = new Scanner(System.in);
    public static void main(String[] args) {
        DateUtil test = new DateUtil();
        String date;
        do{
            System.out.println("Enter date in YYYYMMDD EIGHT CHARACTERS PLEASE");
            date = kb.next();
        }while(!test.checkGregorianDate(date));

    }
}
