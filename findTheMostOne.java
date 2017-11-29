// Suppose each row of an n x n array A consists of 1's
// and 0's such that, in any row of A, all the 1's come
// before any of the 0's in that row. Assuming A is
// already in memory, describe a method running in
// O(n) time (not O(n2
// ) time) for finding the row of A
// that contains the most 1's.    


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
