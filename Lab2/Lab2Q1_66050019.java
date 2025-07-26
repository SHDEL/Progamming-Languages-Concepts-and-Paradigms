package Lab2;

import java.util.Scanner;
import java.util.Stack;

public class Lab2Q1_66050019 {
    private boolean isFinal;
    private Stack<String> stack = new Stack<>();
    public Lab2Q1_66050019(){

    }
    private void Q1(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the input string: ");
        String input = sc.nextLine();
        sc.close();

        int idx = 0;
        stack.push("Z");
        q0(idx, input);

        if (isFinal == true){
            System.out.println("Accept");
        }
        else{
            System.out.println("Reject");
        }    
    }
    private void q0(int idx, String input) {
        isFinal = true;
        if (input.charAt(idx) == 'a' && (stack.peek() == "Z")){
            try {
                idx++;
                stack.push("a");
                q1(idx, input);
            } catch (Exception e) {
                return;
            }
            
        }
        else{
            System.out.println("Input error");
            isFinal = true;
        }
    }
    private void q1(int idx, String input) {
        isFinal = false;
        if (input.charAt(idx) == 'a' && (stack.peek() == "a")){
            try {
                idx++;
                stack.push("a");
                q1(idx, input);
            } catch (Exception e) {
                return;
            }
        }
        else if (input.charAt(idx) == 'b' && (stack.peek() == "a")){
            try{
                idx++;
                stack.pop();
                q2(idx, input);
            }
            catch (Exception e) {
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
        if (idx == input.length() && (stack.peek() == "Z")){
            q3();
        }
        else if (input.charAt(idx) == 'b' && (stack.peek() == "a")){
            try {
                idx++;
                stack.pop();
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
    private void q3(){
        isFinal = true;
        return;
    }
    public static void main(String[] args) {
        Lab2Q1_66050019 lab = new Lab2Q1_66050019();
        lab.Q1();
    }
}
