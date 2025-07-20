package TextManipulator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TextManipulator {
    public static void main(String[] args) throws IOException {
        File file = new File("TextManipulator/newfile.txt");
        Scanner fileScanner = new Scanner(file);
        System.out.println("Current contents of the file:");
        while (fileScanner.hasNextLine()) {
            String data = fileScanner.nextLine();
            System.out.println(data);
        }
        fileScanner.close();
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("Enter a line to append to the file: ");
        String newLine = inputScanner.nextLine();
        FileWriter writer = new FileWriter(file, true);
        writer.write("\n" + newLine);
        writer.close();

        System.out.println("Line appended successfully!");
    }
}
