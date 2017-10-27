    private static int recursiveBinaryCtr = 0;
    private static int iterativeBinaryCtr = 0;
   
    public static int recursiveBinarysearch(int[] A, int startIndex, int endIndex, int v){
        recursiveBinaryCtr++;
        int foundIndex = -1, mid;

        if(startIndex > endIndex){
            return -1;
        }

        mid = (startIndex + endIndex)/2;

        if(A[mid] == v){
            System.out.print("\nThe value was found ......");
            return mid;
        }else {
            if(v < A[mid]){
                System.out.print("\nWill search the array between index # " + startIndex + " and index # " + (mid-1));
                foundIndex = recursiveBinarysearch(A, startIndex, mid - 1, v);
            }else {
                System.out.print("\nWill search the array between index # " + (mid+1) + " and index # " + endIndex);
                foundIndex = recursiveBinarysearch(A, mid + 1,endIndex,v);
            }
        }
        return foundIndex;
    }

    public static int iterativeBinarysearch(int[] A, int startIndex, int endIndex, int v){

        Boolean found = false;

        if(startIndex > endIndex){
            return -1;
        }

        int mid, result = -1;
        while (startIndex <= endIndex && !found){
            iterativeBinaryCtr++;
            mid = (startIndex + endIndex)/2;
            if(A[mid] == v){
                System.out.print("\nThe value was found ......");
                result = mid;
                found = true;
            }else if(v < A[mid]){
                endIndex = mid - 1;
            }else if(v > A[mid]){
                startIndex = mid + 1;
            }
        }
        return result;
    }
