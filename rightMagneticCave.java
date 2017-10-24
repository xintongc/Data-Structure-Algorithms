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
    
    
    public static boolean rightMagneticCave(int a[]){

        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i:a) {
            arrayList.add(i);
        }

        int repeat[] = new int[a.length];
        int position = 0;
        while(true){
            int moves = Math.round(a[position]/2);
            if(position + moves < arrayList.size()){
                repeat[position + moves]++;
                position = position + moves;
            } else if(position - moves >= 0){
                repeat[position - moves]++;
                position = position - moves;
            } else {
                return false;
            }

            if (position == arrayList.size()-1){
                return true;
            }

            for (int r:repeat) {
                if(r > 1){
                    return false;
                }
            }

        }
    }
