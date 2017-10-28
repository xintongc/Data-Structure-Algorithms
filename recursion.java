public static int linearSum(int[] A, int n){
        if(n == 0){
            return A[0];
        }else {
            return linearSum(A,n-1) + A[n-1];
        }
    }

    public static void reverseArray(int[]A, int i, int j){
        if(i < j){
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
            reverseArray(A, i + 1, j - 1);
        }
    }

    public static int powers1(int x, int n){
        if(n == 0){
            return 1;
        }else {
            return powers1(x,n-1) * x;
        }
    }

    public static int powers2(int x, int n){
        if(n == 0){
            return 1;
        }
        if(n%2 == 0){
            int y = powers2(x,n/2);
            return y * y;
        }else {
            int y = powers2(x,n/2);
            return y * y * x;
        }
    }

    public static int binarySum(int A[], int i, int n){
        if(n == 1){
            return A[i];
        }else if(n%2 == 0){
            return binarySum(A,i,n/2) + binarySum(A,i + n/2, n/2);
        }else {
            return binarySum(A,i,n/2) + binarySum(A,i + n/2, n/2) + A[i + n/2 + 1];
        }
    }

    public static int product(int n, int m){
        if(m == 1){
            return n;
        }else if (m == -1){
            return -n;
        } else if (m > 0){
            return product(n, m-1) + n;
        }else{
            return product(n, m+1) - n;
        }
    }

    public static int maximum(int[] A, int n){
        if(n == 0){
            return A[0];
        }else {
            return Math.max(maximum(A, n-1), A[n-1]);
        }
    }

    public static int findRepeat(int[]A, int n){

        if(A[n] == A[n + 1]){
            return A[n];
        }else if(n == A.length - 1){
            return -1;
        }else {
            return findRepeat(A,n+1);
        }
    }

    public static int greatestCommonDivisor(int a, int b){
        if (b==0)
            return a;
        else
            return greatestCommonDivisor(b, a % b);

    }

    public static boolean isPrime(int n, int div){
        if(div <= 1){
            return true;
        }
        if(n % div == 0){
            return false;
        }
        return isPrime(n,div - 1);
    }


    public static void printBinary(int n){
        if (n/2 != 0){
            printBinary(n/2);
        }
        System.out.print(n%2);
    }
