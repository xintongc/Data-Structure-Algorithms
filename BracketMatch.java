package stack;

import java.util.ArrayList;

import java.util.Stack;

/**
 * Created by zncu on 2017-06-23.
 * This program can validate whether a string of bracket is in legal format.
 */
public class BracketMatch {

    public boolean isValid(String string){

        Stack<Character> stack = new Stack<Character>();
        ArrayList<Character> open = new ArrayList<>();
        open.add('(');
        open.add('[');
        open.add('{');
        ArrayList<Character> close = new ArrayList<>();
        close.add(')');
        close.add(']');
        close.add('}');


        for (int i = 0; i < string.length(); i++) {
            char current = string.charAt(i);

            if (open.contains(current)) {
                stack.push(current);

            } else if (stack.size() == 0) {
                return false;
            } else if (close.contains(current)) {

                char peekchar = stack.peek();
                int closeIndex = close.indexOf(current);
                if(open.get(closeIndex) != peekchar){
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        if(!stack.empty()){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        BracketMatch bracketMatch = new BracketMatch();
        System.out.println(bracketMatch.isValid("()([]{})()"));
    }
}
