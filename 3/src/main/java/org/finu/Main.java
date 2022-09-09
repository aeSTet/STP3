package org.finu;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
public class Main {
    public final static String emptyFileName="file1.txt";
    public final static String textFileName="file2.txt";
    public final static String customTextFileName="Input.txt";
    public static void main(String[] args) throws FileNotFoundException {
        /************* File creation and Deletion **************/
        System.out.println(String.format("Creating an empty file [%s]....",emptyFileName));
        File file = new File(emptyFileName);
        try {
            if (file.createNewFile()) {
                System.out.println("File creation successful!");
            } else {
                System.out.println("File creation failed!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(String.format("Deleting file [%s]....",emptyFileName));
        System.out.println("Do you want to delete the file (Y or y for Yes)?");
        Scanner in=new Scanner(System.in);
        char choice=in.nextLine().charAt(0);
        if(choice=='Y' || choice=='y')
        {
            try {
                if (file.delete()) {
                    System.out.println("File deletion successful!");
                } else {
                    System.out.println("File deletion failed!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        /******************* Writing to a text file ********************/
        System.out.println(String.format("Writing to file [%s]",textFileName));
        try {
            FileWriter myWriter = new FileWriter(textFileName);
            myWriter.write("First line\nSecond line\nThird line\nForth Line");
            myWriter.close();
            System.out.println("Text saved successfully.");
        } catch (Exception e) {
            System.out.println("Text saving failed.");
            e.printStackTrace();
        }
        /******************* Reading from a text file *************************/
        // using FileReader
        System.out.println(String.format("Reading file [%s] using FileReader",customTextFileName));
                StringBuilder sb= new StringBuilder();
        try {
            FileReader myReader = new FileReader(customTextFileName);
            int character=myReader.read();
            while(character!=-1)
            {
                //System.out.print((char) character);
                sb.append((char) character);
                character=myReader.read();
            }
            myReader.close();
        } catch (Exception e) {
            System.out.println("Text reading failed.");
            e.printStackTrace();
        }
        System.out.println(sb.toString());
        // using Scanner
        System.out.println(String.format("Reading file[%s] using Scanner",customTextFileName));
        try {
            File myFile = new File(customTextFileName);
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                System.out.println(line);
            }
            myReader.close();
        } catch (Exception e) {
            System.out.println("Text reading failed.");
            e.printStackTrace();
        }
        try {
            File myFile = new File(customTextFileName);
            Scanner sc = new Scanner(myFile);
            int count = 0;
            while (sc.hasNext()) {
                sc.next();
                count++;
            }
            System.out.println("Number of words: " + count);
            } catch (Exception e) {
            System.out.println("Text counting failed.");
            e.printStackTrace();

        }
        try {
            File myFile = new File(customTextFileName);
            Scanner sc = new Scanner(myFile);
            for (int k = 0; k < sc.length(); k++) {
                if (Character.isUpperCase(sc.charAt(k))) upperCase++;
                if (Character.isLowerCase(sc.charAt(k))) lowerCase++;
                }
            System.out.printf("There are %d upper case and %d lower case.",upperCase,lowerCase);
            } catch (Exception e) {
            System.out.println("Text counting failed.");
            e.printStackTrace();
        }

    }

}
