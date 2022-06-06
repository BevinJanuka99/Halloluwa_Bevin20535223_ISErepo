import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;
import java.util.Scanner;

public class StringConverter 
{
    public static void convertString()
    {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter input file name: ");
            String fileName = sc.nextLine();
            File file = new File(fileName);

            System.out.println("---------------------------------------------------------------------------");
            System.out.println("Converting Upper Case Text br " + file + " to Lower Case and Vise Versa\n");


            BufferedReader br = (new BufferedReader(new FileReader(file)));


            validation(file);

            Scanner scOut = new Scanner(System.in); 
            System.out.print("Enter output file name to save converted Strings : ");
            String outputFileName = scOut.nextLine();
            PrintWriter out = (new PrintWriter(new FileWriter(outputFileName)));


            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) 
            {
                sb.append(line).append("\n");
                line = br.readLine();
            }

            String fileAsString = sb.toString();
            String numRemoved = "";
            char[] charArray = fileAsString.toCharArray();
            for(int i=0; i<charArray.length;i++)
            {
                if (!Character.isDigit(charArray[i])) 
                {
                    numRemoved = numRemoved + charArray[i];
                }
            }

            //int character;
            //int i;

            StringBuffer newStringB = new StringBuffer(numRemoved);

            for(int i = 0; i < numRemoved.length(); i++) 
            {

                //Checking if string is an lowercase character
                if(Character.isLowerCase(numRemoved.charAt(i))) 
                {
                    newStringB.setCharAt(i, Character.toUpperCase(numRemoved.charAt(i)));//Converting relevant character using toUpperCase
                }
                //Checking if string is an uppercase character
                else if(Character.isUpperCase(numRemoved.charAt(i))) 
                {
                    newStringB.setCharAt(i, Character.toLowerCase(numRemoved.charAt(i)));//Converting relevant character using toUpperCase
                }
            }

            out.write(String.valueOf(newStringB));
            System.out.println("\nFile Saved");
            System.out.println("---------------------------------------------------------------------------\n");

            br.close();
            out.close();


        } 
        catch (IOException errorDetails) 
        {
            System.out.println("Error: " + errorDetails.getMessage());
        }
    }

    public static void validation(File file)
    {
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line).append("\n");
                line = br.readLine();
            }
            String fileAsString = sb.toString();
            for (int i = 0; i < fileAsString.length(); i++) {
                if (Character.isDigit(fileAsString.charAt(i)) == true)
                {
                    System.out.println("FILE INVALID :: File contains numeric values.");
                    System.out.println("\nRemoving Numeric Values.......\n");
                    fileAsString = fileAsString.replaceAll("[0-9]","");
                }
            }
        } 
        catch (IOException errorD) 
        {
            System.out.println("ERROR" + errorD.getMessage());
        }
    }
}