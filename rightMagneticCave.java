    public static boolean rightMagneticCave(int a[], int position, int repeat[]){

        if(a[position] == 0){
            return true;
        }
        for (int r:repeat) {
            if(r > 1){
                return false;
            }
        }

        int moves = Math.round(a[position]/2);

        if(position + moves < a.length){
            repeat[position + moves]++;
            return rightMagneticCave(a, position + moves,repeat);
        } else if (position - moves >= 0){
            repeat[position - moves]++;
            return rightMagneticCave(a, position - moves,repeat);
        } else {
            return false;
        }
    }
    
    
