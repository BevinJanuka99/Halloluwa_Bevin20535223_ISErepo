import java.io.*;
import java.util.Scanner;

public class WeightConverter 
{
    public static void unitValidation() 
    {
        try 
        {
            Scanner scFile = new Scanner(System.in); 
            System.out.print("Enter file name: ");
            String fileName = scFile.nextLine();
            File file = new File(fileName);

            System.out.println("------------------------------------------------------------------------");
            System.out.println("Converting weight " + file + " to relevant unit\n");
            BufferedReader br = (new BufferedReader(new FileReader(file)));


            Scanner scOut = new Scanner(System.in);
            System.out.print("Enter output file name to save converted weight : ");
            String outputFileName = scOut.nextLine();
            PrintWriter weightOut = (new PrintWriter(new FileWriter(outputFileName)));


            String strWeight = readFile(file);

            StringBuilder convertedWeight = new StringBuilder();

            Scanner sc = new Scanner(new File(String.valueOf(file)));
            while (br.readLine()!=null)
            {
                String line = br.readLine();
                String[] splitBy = line.split(" ");

                double weight = Integer.parseInt(splitBy[0]);
                String unit = splitBy[1];

                switch (unit)
                {
                    case "kg":
                        weight=weight*2.2046;
                        convertedWeight.append(weight).append(" lbs\n");
                        strWeight=convertedWeight.toString();
                        //System.out.println(strWeight);
                        break;

                    case "lbs":
                        weight=weight*0.4536;
                        convertedWeight.append(weight).append(" kg\n");
                        strWeight=convertedWeight.toString();
                        //System.out.println(strWeight);
                        break;

                    case "":
                        strWeight = "Unit not defined correctly. Please enter weight with a space. Example: 50 kg ";
                        break;

                    default:
                        break;

                }

            }

            System.out.println("\nFile Saved");
            System.out.println("------------------------------------------------------------------------\n");
            weightOut.println(strWeight);
            weightOut.close();
            br.close();
            scFile.close();
            scOut.close();

        } 
        catch (IOException errorDetails) 
        {
            System.out.println("Error ::: " + errorDetails.getMessage());
        }


    }

    
}
