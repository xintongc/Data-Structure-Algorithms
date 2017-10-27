    public static int findTheMostOne(int[][]array){
        int n = array.length;
        int i = n - 1;
        int j = 0;

        while (i >= 0 && j< n){
            if(array[i][j] == 1){
                j++;
            } else {
                i--;
            }
        }
        return j;
    }
