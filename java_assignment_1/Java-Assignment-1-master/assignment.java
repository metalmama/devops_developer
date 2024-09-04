import java.util.Scanner;

public class assignment {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Let's calculate summin!");
        double Num1 = 0, Num2 = 0, Ans = 0;
        String Op = "";
        boolean isRunning = true;
        while (isRunning) {

boolean isOK = false;             // Number format checking has now been included here//
while (!isOK) {
        try {
            System.out.println("Please enter your first number");
            Num1 = scan.nextDouble(); // First entry is a number
            isOK =true;
        } catch (Exception e) {
            System.out.println("That is not quite right - please try again");
            scan.next();
        }
    }
    isOK = false;             // Number format checking has now been included here//
    while (!isOK) {
            System.out.println("Please enter your operand (+,-,*, or /)");
                Op = scan.next(); // Second entry is the operator
                switch(Op){
                    case "+":
                    case "-":
                    case "*":
                    case "/":
                       isOK =true; //This ensures that only the above have been entered
                break;
                    default:
                    System.out.println("That is not quite right - please try again");
                    
                }
               
           
        }  
    
    
    isOK = false;             // Number format checking has now been included here//
    while (!isOK) {
            System.out.println("Please enter your second number");
            try {

                Num2 = scan.nextDouble(); // Second entry is a number//
                isOK =true;
            } catch (Exception e) {
                System.out.println("That is not quite right - please try again");
                scan.nextLine();
            }
        }


    

//Pick the right calculation depending on the operator entered//

switch(Op)
{
    case "+":
    Ans=addition(Num1, Num2);
    break; 
    case "-":
    Ans=subtraction(Num1, Num2);
    break;
    case "*":
    Ans=multiplication(Num1, Num2);
    break;
    case "/":
    Ans=division(Num1, Num2);
    break;
    default:
    System.out.println("Blimey! That's out of order mate.");
    break;
}
System.out.println("The answer is "+Ans);
isOK = false;
while(!isOK){
        System.out.println("Do you want to perform another calculation? Y/N?");
        String input = scan.next();

        if (input.toLowerCase().equals("y")){

            System.out.println("Entered Y");
            isOK = true;
        }   else if (input.toLowerCase().equals("n")){
            isRunning = false;
            isOK = true;
        }   else {
            System.out.println("Please enter Y or N!");
        }
        }
    }
    
}


    public static double addition(double x, double y) {
        double result = x+y;
        return result;
    }

    public static double subtraction(double x, double y) {
        double result = x-y;
        return result;
    }

    public static double multiplication(double x, double y) {
        double result = x*y;
        return result;
    }

    public static double division(double x, double y) {
        double result = x/y;
        return result;
    }
}
