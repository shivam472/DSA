import java.util.EmptyStackException;

public class Stack {
    private int top = -1;
    private char[] stack;
    Stack(int length) {
        stack = new char[length];
    }

    public void push(char data) {
        if(top < stack.length-1) 
            stack[++top] = data;
        else 
            throw new StackOverflowError();
        
    }

    public char pop() {
        if(top >= 0) 
            return stack[top--];
        else
            throw new EmptyStackException();
    }

    public char peek() {
        if(top < 0)
            throw new EmptyStackException();
        else
            return stack[top];
    }

    public int size() {
        return top+1;
    }

    public void print() {
        int i = top;
        while(i >= 0) 
            System.out.print(stack[i--] + " ");
        
        System.out.println();
    }
}

