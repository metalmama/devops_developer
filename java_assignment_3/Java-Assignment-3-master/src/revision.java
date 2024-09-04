import java.sql.SQLOutput;
import java.util.Scanner;

public class revision {
    public static void main(String[] args) {
        try
        {
            int data=50/0; //may throw exception
            System.out.println("This one never appears on the console");
        }
        //handling the exception
        catch(Exception e)
        {
            System.out.println("The error is" + " " + e.getMessage());
        }
        System.out.println("Continuing with the rest of the code");
        moreJuice();
    }

    public static void moreJuice() {
        String brand = "";
        String flavour = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a brand");
        brand = scanner.nextLine();
        System.out.println("Enter a flavour");
        flavour = scanner.nextLine();
        System.out.println(brand +" " + flavour + " is served");
        }
    }