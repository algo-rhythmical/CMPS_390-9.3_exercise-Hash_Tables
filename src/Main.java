import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
public class Main {
    public static void main (String[] args) {
        try {
            Scanner keyboard;
            Scanner listReader;
            File file;
            String fileName;
            String entryName;
            int tableLength;
            Hash myHash;

            System.out.print("Enter the file name: ");
            keyboard = new Scanner(System.in);
            fileName = keyboard.nextLine();
            file = new File("src\\" + fileName);
            listReader = new Scanner(file);

            System.out.print("Choose size of hash table(200, 400, 700 or 9000): ");
            tableLength = keyboard.nextInt();

            myHash = new Hash(tableLength);

            while(listReader.hasNextLine()){
                entryName = listReader.nextLine();
                myHash.nameToHashTable(entryName);
            }
            myHash.showHashTable();
            System.out.println();
            myHash.namesCount();
        }
        catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }
}