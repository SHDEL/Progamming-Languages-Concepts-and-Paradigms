import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.zip.DataFormatException;

public class Main {

    static String readFile = "rawemployee.csv";
    static String cleanedFile = "cleanedemployee.csv";
    static String errorLogFile = "errorlog.txt";
    static final String ANSI_GREEN = "\u001B[32m\t";
    static final String ANSI_RED = "\u001B[31m";
    static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {
        readCSV();
    }

    public static void readCSV(){
        int rowcnt = 0;
        int validcnt = 0;
        try (Scanner input = new Scanner(Paths.get(readFile));) {
            while (input.hasNext()){
                rowcnt++;
                String row = input.nextLine();
                String [] tokens = row.split(",");
                try {

                    if (tokens.length != 4){
                        throw new NumberOfFieldsException("\"Number of Fields mismatch\"");
                    }
                    
                    int empId = Integer.parseInt(tokens[0]);
                    String firstName = tokens[1];
                    String lastName = tokens[2];
                    double salary = Double.parseDouble(tokens[3]);
                    // System.out.println(ANSI_GREEN + "PASS " + ANSI_RESET);
                    System.out.println(ANSI_GREEN + "PASS " + ANSI_RESET + empId + "," + firstName + "," + lastName + "," + salary );
                    writeCleanedFile(empId + "," + firstName + "," + lastName + "," + salary);
                    validcnt++;
                }
                catch (NumberFormatException e){
                    System.out.println(ANSI_RED + "FAIL " + ANSI_RESET + "line:" + rowcnt + ", error type: \"Data type mismatch\" data: \"" + row + "\"" );
                    writeErrorLog("line:" + rowcnt + ", error type: \"Data type mismatch\" data: \"" + row + "\"");
                }
                catch (NumberOfFieldsException e){
                    System.out.println(ANSI_RED + "FAIL " + ANSI_RESET + "line:" + rowcnt + ", error type: " + e.getMessage() + ", data: \"" + row + "\"");
                    writeErrorLog("line:" + rowcnt + ", error type: \"Data type mismatch\" data: \"" + row + "\"");
                }
                

            }
            System.out.println(validcnt + " out of " + rowcnt + " rows from rawemployee.csv were written to cleanedemployee.csv, see errorlog.txt for incorrect row(s)");
            
        }
        catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }
    public static void writeCleanedFile(String msg){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(cleanedFile, true))) {
            writer.write(msg);
            writer.newLine();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        
    }

    public static void writeErrorLog(String msg){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(errorLogFile, true))) {
            writer.write(msg);
            writer.newLine();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
