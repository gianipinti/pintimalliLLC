import java.util.*;
import java.io.*;
import java . nio . file . Files ;
import java . nio . file . Path ;
import java . util . Scanner ;


/**
 * Program analyzes files and collapses any whitespace sequences to a 
 * single whitespace character then creates an output file with desired
 * results
 *
 * @author Gianfranco Pintimalli
 * @author Eric Ngaopraseut
 */
public class Collapse {
    /**
     * Prompts user for input filename (and reprompts as needed until file is
     * found). Prompts user for output filename. If output file does not already
     * exist, collapse spaces for input file and write into output file. If output
     * file already exists, print error message to console.
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        
        Scanner console = new Scanner(System.in);
        Scanner in = getInput(console);
        PrintWriter output = getOutput(console);
        
        if (output == null) {
            System.exit(1);
        }
    }

    /**
     * Outputs collapsed input file into output file
     * 
     * @param in Scanner for input file
     * @param out PrintWriter for output file
     */
    public static void collapseSpaces(Scanner in, PrintWriter out) {

    }

    /**
     * Returns string with spaces collapsed
     * 
     * @param line input string to collapse spaces
     * @return string with spaces collapsed
     */
    public static String collapseLine(String line) {
        String s = "";
        int spaces = 0;
        for(int i = 0; i < line.length; i++) {
            char ch = line.charAt(i);
            char nextCharacter = line.charAt(i + 1);
            
            if (!Character.isWhitespace(ch) &&
                !Character.isWhitespace(nextCharacter)) {
                    s = s + ch;
            } else if (Character.isWhitespace(ch) &&
                Character.isWhitespace(nextCharacter)) {
                    
                }
        }
        return s;
        
    }

    /**
     * Prompts the user for an output filename, then creates and returns a
     * PrintStream tied to the file. If file with filename already exists, returns
     * null. If construction of PrintWriter and FileOutputStream results 
     * in FileNotFoundException, return null.
     * 
     * @param console console input scanner
     * 
     * @return PrintWriter for output file, or null if file exists
     */
    public static PrintWriter getOutput(Scanner console) {
        PrintWriter checkOutput = null;
        
        while (checkOutput == null) {
            System.out.print("Output file name? ");
            String outputFile = console.next();
            Path path = Path.of(outputFile);

            if (!Files.exists(path)) {

                try {
                    checkOutput = new PrintWriter(new FileOutputStream(outputFile));
                } catch (FileNotFoundException e) {
                    System.out.println("Cannot create output file");
                    return null;
                }
            } else {
                System.out.println("File already exists!");
                return null;
            }
        }
        return checkOutput;
    }

    /**
     * Prompts the user for an input filename, then creates and returns a Scanner
     * tied to the file. Reprompts as needed if file does not exist.
     * 
     * @param console console input scanner
     * 
     * @return scanner for input file
     */
    public static Scanner getInput(Scanner console) {
        Scanner checkFile = null;

        while (checkFile == null) {
            System.out.print("input file name? ");
            String filename = console.next();

            try {
                checkFile = new Scanner(new FileInputStream(filename));
            } catch (FileNotFoundException e) {
                System.out.print("File not found. Please try again.");
            }
        }
        return checkFile;
    }
}
