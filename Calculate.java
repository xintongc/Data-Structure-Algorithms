package cal;



import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by zncu on 2017-06-24.
 */
public class Cal {


    public int calculate(String string){
//using map instead of swich
        Map<Character, Integer> opePriorities = new HashMap<Character, Integer>();
        opePriorities.put('*', 2);
        opePriorities.put('/',2);
        opePriorities.put('+',1);
        opePriorities.put('-',1);
        opePriorities.put('$',0);

        Map<Character, Integer> numberMap = new HashMap<Character, Integer>();
        numberMap.put('0',0);
        numberMap.put('1',1);
        numberMap.put('2',2);
        numberMap.put('3',3);
        numberMap.put('4',4);
        numberMap.put('5',5);
        numberMap.put('6',6);
        numberMap.put('7',7);
        numberMap.put('8',8);
        numberMap.put('9',9);

        string = string + "$";

        Stack<Integer> num = new Stack<Integer>();
        Stack<Character> ope = new Stack<Character>();

        for (int i = 0; i < string.length(); i+=2)  {
            char current1 = string.charAt(i);
            num.push(numberMap.get(current1));

            char current2 = string.charAt(i + 1);

            while (true){
                if (ope.empty()){
                    break;
                }
                if (opePriorities.get(current2) > opePriorities.get(ope.peek())){
                    break;
                }

                int num2 = num.pop();
                int num1 = num.pop();
                int result = cal2Num(num1,ope.pop(),num2);   //????
                num.push(result);
            }
            ope.push(current2);
        }
        return num.pop();
    }



//    private int convertNum(char c){
//        switch (c){
//            case '0': return 0;
//            case '1': return 1;
//            case '2': return 2;
//            case '3': return 3;
//            case '4': return 4;
//            case '5': return 5;
//            case '6': return 6;
//            case '7': return 7;
//            case '8': return 8;
//            case '9': return 9;
//            default: return 0;
//        }
//    }

//    private int opePriority(char c) {
//        switch (c) {
//            case '*':
//            case '/':
//                return 2;
//            case '+':
//            case '-':
//                return 1;
//            default:
//                return 0;
//        }
//    }

    private int cal2Num(int num1, char c, int num2 ){
        switch (c){
            case '*': return num1 * num2;
            case '/': return num1 / num2;
            case '+': return num1 + num2;
            case '-': return num1 - num2;
            default:
                return 0;
        }

    }

    public static void main(String[] args) {
        Cal calcu = new Cal();
        System.out.println(calcu.calculate("3+2*5-6+5*3"));
}




}
