import java.util.Scanner;

public class Main {
public static void main(String[] args) 
{
Scanner input = new Scanner (System.in);
System.out.println("Input your first name: ");
String fname = input.next();
System.out.println("Input your last name: ");
String lname = input.next();
System.out.println();
System.out.println("Hello \n"+fname+" "+lname);
}
} 