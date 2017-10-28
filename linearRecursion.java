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
