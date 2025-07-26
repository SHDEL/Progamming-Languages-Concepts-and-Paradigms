package Lab2;

import java.util.Scanner;
import java.util.Stack;

public class Lab2Q2_66050019 {
    private boolean isFinal;
    private Stack<String> stack = new Stack<>();

    public Lab2Q2_66050019(){

    }

    private void Q2(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the input string: ");
        String input = sc.nextLine();
        sc.close();

        int idx = 0;
        stack.push("$");
        q1(idx, input);

        if (isFinal == true){
            System.out.println("Accept");
        }
        else{
            System.out.println("Reject");
        }    
    }
    private void q1(int idx, String input) {
        isFinal = false;
        if (idx == input.length() && (stack.peek() == "$")){
            q2();
        }
        if (input.charAt(idx) == 'a' && (stack.peek() == "$")){
            try {
                idx++;
                stack.push("0");
                q1(idx, input);
            } catch (Exception e) {
                return;
            }
        }
        else if (input.charAt(idx) == 'a' && (stack.peek() == "0")){
            try{
                idx++;
                stack.push("0");
                q1(idx, input);
            }
            catch (Exception e) {
                return;
            }
        }
        else if (input.charAt(idx) == 'a' && (stack.peek() == "1")){
            try{
                idx++;
                stack.pop();
                q1(idx, input);
            }
            catch (Exception e) {
                return;
            }
        }
        else if (input.charAt(idx) == 'b' && (stack.peek() == "$")){
            try{
                idx++;
                stack.push("1");
                q1(idx, input);
            }
            catch (Exception e) {
                return;
            }
        }
        else if (input.charAt(idx) == 'b' && (stack.peek() == "1")){
            try{
                idx++;
                stack.push("1");
                q1(idx, input);
            }
            catch (Exception e) {
                return;
            }
        }
        else if (input.charAt(idx) == 'b' && (stack.peek() == "0")){
            try{
                idx++;
                stack.pop();
                q1(idx, input);
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
    private void q2(){
        isFinal = true;
        return;
    }

    public static void main(String[] args) {
        Lab2Q2_66050019 lab = new Lab2Q2_66050019();
        lab.Q2();
    }
}
