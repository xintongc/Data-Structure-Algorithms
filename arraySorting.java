    public static int[] arraySorting(int a[], int n){

        int zom[] = new int[n];
        for (int i = 0; i <= n-1; i++) {
            zom[i] = 0;
        }

        for (int i = 0; i <= n-2 ; i++) {
            for (int j = i+1; j <= n-1; j++) {
                if(a[i] <= a[j]){
                    zom[j] = zom[j] + 1;
                } else {
                    zom[i] = zom [i] + 1;
                }
            }
        }
        int m[] = new int[n];
        for (int i = 0; i <= n-1; i++) {
            m[zom[i]] = a[i];
            System.out.println("m["+ zom [i]  +"]:"+ m[zom[i]]+ "  a[" + i + "]:" + a[i]);
        }

    return m;
    }
