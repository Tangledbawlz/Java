import java.io.*;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.lang.*;

public class driver {

    public static void main(String[] args) throws IOException {
        //Create a file object that will read in a file
        File file = new File("C:\\Users\\ntang\\Documents\\Anime Watchlist\\Anime Names\\Anime-to-Watch\\Anime Recommendations.txt");

        //Create scanner classes for both the file, and the prompt user
        Scanner scanner = new Scanner(file);
        Scanner input = new Scanner(System.in);

        //prompt user
        System.out.println("Would you like to read the whole file, or only words\n starting with a letter?\n Type: 1: Whole File, 2: Print Alphabetically to file, 3: Exit");
        //Keep user response
        int response = input.nextInt();

        if(response == 1)
        {
            //create a scanner to read from the file
            printElements(file, scanner);
            System.exit(0);
        }

        else if(response == 2)
        {
            //create a FileWriter and give a filepath
            FileWriter myWriter = new FileWriter("C:\\Users\\ntang\\Documents\\Anime Watchlist\\Anime Names\\Anime-to-Watch\\Anime Recommendations1.txt");
            writeFile(myWriter, file, scanner);
            System.exit(0);
        }
        else if(response == 3)
        {
            System.exit(0);
        }
        else
            System.out.println("That is not a valid entry, Try again!");
    }


    public static void printElements(File file, Scanner scanner) {
        //create a while loop to read the entire file
        while (scanner.hasNextLine()) {
            String words = scanner.nextLine();
            System.out.println(words);
        }

    }


    public static void writeFile(FileWriter myWriter, File file, Scanner scanner) throws IOException {
        //had trouble with this and got some help on this function
        //reads the file
        FileReader fileReader = new FileReader("C:\\Users\\ntang\\Documents\\Anime Watchlist\\Anime Names\\Anime-to-Watch\\Anime Recommendations.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        //creates an arraylist of strings for each name
        List<String> lines = new ArrayList<String>();
        //intialize variable
        String line = null;
        //loop if the file is not empty and write to file
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }
        //close
        bufferedReader.close();

        //uses a sorting built-in function and compares values
        Collections.sort(lines, Collator.getInstance());

        //Rewrites file to new or existing file
        FileWriter writer = new FileWriter("C:\\Users\\ntang\\Documents\\Anime Watchlist\\Anime Names\\Anime-to-Watch\\Anime Recommendations1.txt");
        for(String str: lines) {
            writer.write(str + "\r\n");
        }
        writer.close();
        }

}
