import java.util.Scanner;

public class ParanthesisMatching {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the expression: ");
        String str = sc.nextLine();
        Stack s = new Stack(20);
        sc.close();

        for(int i = 0; i < str.length(); i++) {

            if(str.charAt(i) == '[' || str.charAt(i) == '{' || str.charAt(i) == '(') {
                s.push(str.charAt(i));
            }

            else if(str.charAt(i) == ']') {
                if(s.size() == 0 || s.peek() != '[') {
                    System.out.println("invalid");
                    return;
                }
                else
                    s.pop();
            }

            else if(str.charAt(i) == '}') {
                if(s.size() == 0 || s.peek() != '{') {
                    System.out.println("invalid");
                    return;
                }
                else
                    s.pop();
            }

            else if(str.charAt(i) == ')') {
                if(s.size() == 0 || s.peek() != '(') {
                    System.out.println("invalid");
                    return;
                }
                else
                    s.pop();
            }
        }
        
        if(s.size() == 0) {
            System.out.println("Valid");
        }
        else {
            System.out.println("Invalid");
        }
    }
}
