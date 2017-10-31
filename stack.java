public static void binaray(int n){
        Stack <Integer> stack = new Stack<Integer>();
        while(n/2 != 0){
            int reminder = n % 2;
            n = n /2;
            stack.push(reminder);
        }

        while (!stack.empty()){
            System.out.print(stack.pop());
        }

    }
    
///////////////////////////////////////////////////////////////////////////////////////////////////////

    public static boolean palindrome(String string){
        Stack<String> stack = new Stack<String>();
        if(string.isEmpty()){
            return true;
        }
        if(string.length()%2 == 0){
            for (int i = 0; i < string.length()/2; i++) {
                stack.push(String.valueOf(string.charAt(i)));
            }
            for (int i = string.length()/2; i <string.length() ; i++) {
                if(!stack.pop().equals(String.valueOf(string.charAt(i)))){
                    return false;
                }

            }
        }
        return true;

    }
    public static void main(String[] args) {

        System.out.println(palindrome("abcba"));

    }
