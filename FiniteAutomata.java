import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FiniteAutomata {
    private boolean isFinal;
    public FiniteAutomata() {
        // Constructor to initialize the finite automaton
        
    }
    private void q5(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the input string: ");
        String input = sc.nextLine();
        sc.close();

        int idx = 0;

        q0(idx, input);

        if (isFinal == true){
            System.out.println("Accept");
        }
        else{
            System.out.println("Reject");
        }    
    }
    private void q0(int idx, String input) {
        isFinal = false;
        if (input.charAt(idx) == 'b'){
            try {
                idx++;
                q0(idx, input);
            } catch (Exception e) {
                return;
            }
            
        }
        else if (input.charAt(idx) == 'a'){
            try {
                idx++;
                q1(idx, input);
            } catch (Exception e) {
                return;
            }
            
        }
        else{
            System.out.println("Input error");
            isFinal = false;
        }
    }
    private void q1(int idx, String input) {
        isFinal = true;
        if (input.charAt(idx) == 'b'){
            try {
                idx++;
                q1(idx, input);
            } catch (Exception e) {
                return;
            }
        }
        else if(input.charAt(idx) == 'a'){
            try {
                idx++;
                q2(idx, input);
            } catch (Exception e) {
                return;
            }
        }
        else{
            System.out.println("Input error");
            isFinal = false;
        }
    }
    private void q2(int idx, String input) {
        isFinal = false;
        if (input.charAt(idx) == 'b' || input.charAt(idx) == 'a'){
            try {
                idx++;
                q2(idx, input);
            } catch (Exception e) {
                return;
            }
        }
        else{
            System.out.println("Input error");
            isFinal = false;
        }
    }

    public static void main(String[] args) {

        // Example usage of the FiniteAutomata class
        FiniteAutomata fa = new FiniteAutomata();
        // fa.q5();
        // fa.q6();
        fa.q9();
    }

    private void q6(){
        System.out.println("-----------Regular Expresion---------");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the input string: ");
        String input = sc.nextLine();
        sc.close();

        Pattern pattern = Pattern.compile("^b*a{1}b*$");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            System.out.println("Accept");
        } else {
            System.out.println("Reject");
        }
    }
    private void q9(){
        System.out.println("-----------Regular Expresion---------");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the input string: ");
        String input = sc.nextLine();
        sc.close();

        Pattern pattern = Pattern.compile("^([ab]{3})+$");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            System.out.println("Accept");
        } else {
            System.out.println("Reject");
        }
    }
}
