import java.util.*;

public class Main
{
    public static void main(String[] args) 
    {
        /*Scanner sc = new Scanner(System.in);
        System.out.println("Enter file name: ");
        String fileName;
        fileName = sc.nextLine();
        File file = new File(fileName);*/

        Scanner input = new Scanner(System.in);

        boolean exit = false; 
        while(!exit)
        {
            System.out.println("--------------------------------------------------");
            System.out.println("Enter Selection from Menu");
            System.out.println("1.Convert String File to Lower Case or Upper Case");
            System.out.println("2.Convert Weight from kg to pounds and vise versa");
            System.out.println("3.Exit");
            System.out.println("--------------------------------------------------");
            
            System.out.print("Your Choice: ");
            int userSelection = input.nextInt();

            switch (userSelection) {
                case 1:
                    StringConverter.convertString();
                    break;
                case 2:
                    WeightConverter.unitValidation();
                    exit = true;
                    break;
                    
                default:
                    System.out.println("\n:::::::::: Exiting Application :::::::::");
                    exit = true;
                    break;
            }
        }


    }
}
