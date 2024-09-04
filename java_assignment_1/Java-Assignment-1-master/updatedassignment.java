import java.util.Scanner;

public class updatedassignment {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Let's calculate summin!");
        double Num1 = 0, Num2 = 0, Ans = 0;
        String Op = "";
        boolean isRunning = true;
        while (isRunning) {

boolean isOK = false;             // Number format checking has now been included here//

Num1 = getNumberFromUser("first");
Op = getOperatorFromUser();
if (Op.length()==1){
    Num2 = getNumberFromUser("second");
}

Ans = calculate(Op, Num1, Num2);



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

public static double getNumberFromUser(String txt){
Scanner scan = new Scanner(System.in);
double Num = 0;

boolean isOK = false;             // Number format checking has now been included here//
while (!isOK) {
        try {
            System.out.println("Please enter your "+txt+" number");
            Num = scan.nextDouble(); // First entry is a number
            isOK =true;
        } catch (Exception e) {
            System.out.println("That is not quite right - please try again");
            scan.next();
        }
    }
return Num;
}

public static String getOperatorFromUser(){
Scanner scan = new Scanner(System.in);
Boolean isOK = false;             // Operator format checking has now been included here//
String Op = "";
    while (!isOK) {
            System.out.println("Please enter your operand (+,-,*,/,sin,cos or tan)");
                Op = scan.next(); // Second entry is the operator
                switch(Op){
                    case "+":
                    case "-":
                    case "*":
                    case "/":
                    case "sin":
                    case "cos":
                    case "tan":
                       isOK =true; //This ensures that only the above have been entered
                break;
                    default:
                    System.out.println("That is not quite right - please try again");
                   
                }
              
          
        } 
return Op;
    }
    
    public static double calculate(String Op,double Num1, double Num2){

    double Ans = 0;
    
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
    case "sin":
    Ans=mySin(Num1);
    break;
    case "cos":
    Ans=myCos(Num1);
    break;
    case "tan":
    Ans=myTan(Num1);
    break;
    default:
    System.out.println("Blimey! That's out of order mate.");
    break;
}
return Ans;
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
    public static double mySin(double x) {
        double result = Math.sin(x);
        return result;
    }
    public static double myCos(double x) {
        double result = Math.cos(x);
        return result;
    }

    public static  double myTan( double x) {
        double result = Math.tan(x);
        return result;

    }
}


