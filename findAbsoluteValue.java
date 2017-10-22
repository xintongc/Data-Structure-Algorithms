public static void findAbsoluteValue(int a[], int value){

        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        for (int n: a) {
            arrayList.add(n);
        }

        for (int element: arrayList) {
            if(arrayList.contains(element + value) && (arrayList.indexOf(element) < arrayList.indexOf(element + value))){

                System.out.println("Indices " + arrayList.indexOf(element)  + " & " +
                        arrayList.indexOf(element + value) + " with values " + element + " & " + (element + value));

            }
            if(arrayList.contains(element - value) && (arrayList.indexOf(element) < arrayList.indexOf(element - value))){
                System.out.println("Indices " + arrayList.indexOf(element)  + " & " +
                        arrayList.indexOf(element - value) + " with values " + element + " & " + (element - value));
            }
        }
    }

    public static void absolutValue(int a[], int value){

        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                if(a[i] + value == a[j] || a[i] - value == a[j]){
                    System.out.println("Indices " + i + " & " + j + " with values " + a[i] + " & " + a[j]);
                }
            }
        }

    }
    
    public static void findAbsoluteValue(int a[], int value){


        int number = 0;
        int target = 0;


        for (int i = 0; i < a.length ; i++) {
            int targetIndex = 0;
            int numberIndex = 0;

            Stack<Integer> s = new Stack<>();

            for (int k = a.length - 1; k >= 0 ; k--) {
                s.push(a[k]);
            }


            for (int j = 0; j < a.length; j++) {

                if(i >= j){
                    target = s.pop();
                    targetIndex++;

                } else{

                    number = s.pop();
                    numberIndex++;
                    if(target + value == number || target + value == number){
                        System.out.println("Indices " + targetIndex + " & " + numberIndex + " with values " + target + " & " + number);
                    }
                }
            }
        }

    }

    public static void main(String[] args) {//use 3 different method to solve this problem
        int a[] = {13, 1,-8, 21, 0, 9,-54, 17, 31, 81,-46};
        findAbsoluteValue(a,8);
    }
