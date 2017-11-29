package assignment4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class SmartAR {

    static int size = 0;
    static int date = 0;
    static int thresholdNo = 100;
    static int keyLength = 6;
    static Hashtable<String, Car> plateHashTable = new Hashtable<>();
    static ArrayList<Car> carsList = new ArrayList<>();
    static ArrayList<CarNode> reusedPlate = new ArrayList<CarNode>();


    private static void swichContainerIfReachThresholdNo(){

        if(size >= thresholdNo){ //swich to hashtable
            for (Car car:carsList) {
                plateHashTable.put(car.plate, car);
            }
            carsList.clear();
//            System.out.println("Using hashtable");
        } else { //swich to arrayList

            ArrayList<String> keyList = new ArrayList<>();
            Enumeration<String> carKeyList = plateHashTable.keys();
            while (carKeyList.hasMoreElements()){
                String key = carKeyList.nextElement();
                carsList.add(plateHashTable.get(key));
            }
            plateHashTable.clear();
//            System.out.println("Using arrayList");
        }
    }

    public static void setThreshold(int threshold){
//
//        if(threshold < 100 || threshold > 500000){
//            return;
//        }


        if(threshold <= size && threshold < thresholdNo){ //swich to hashtable
            for (Car car:carsList) {
                plateHashTable.put(car.plate, car);
            }
            carsList.clear();
//            System.out.println("Using hashtable");
        } else if (threshold > size && threshold > thresholdNo){ //swich to arrayList

            ArrayList<String> keyList = new ArrayList<>();
            Enumeration<String> carKeyList = plateHashTable.keys();
            while (carKeyList.hasMoreElements()){
                String key = carKeyList.nextElement();
                carsList.add(plateHashTable.get(key));
            }
            plateHashTable.clear();
//            System.out.println("Using arrayList");
        }
        thresholdNo = threshold;
    }

    public static void setKeyLength(int length){
        keyLength = length;
    }

    public static ArrayList<String> generate(int n){
        ArrayList<String> stringsList = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            String string = getSaltString(keyLength);
            while (allKeys().contains(string)){
                string = getSaltString(keyLength);
            }
            stringsList.add(i,string);
        }
        return stringsList;
    }

    protected static String getSaltString(int length) {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < length) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

    public static ArrayList<String> allKeys(){
        ArrayList<String> keyList = new ArrayList<>();
        if(size < thresholdNo){
            for (Car car:carsList) {
                keyList.add(car.plate);
            }
            Collections.sort(keyList);
            return keyList;
        } else {
            Enumeration<String> carKeyList = plateHashTable.keys();
            while (carKeyList.hasMoreElements()){
                keyList.add(carKeyList.nextElement());
            }
            Collections.sort(keyList);
            return keyList;
        }
    }

    public static void add(String key, Car car){
        size++;
        car.setDate(date++);
        boolean repeatPlate = false;

        SmartAR.swichContainerIfReachThresholdNo();
        if(allKeys().contains(key)){ //if the plate been registered before
            reusedPlate.add(new CarNode(key, car));
            repeatPlate = true;
        }

        if(size < thresholdNo && !repeatPlate){
            carsList.add(car);
        } else if(size < thresholdNo && repeatPlate){

            for (int i = 0; i < carsList.size(); i++) {
                if(carsList.get(i).plate.equals(key)){
                    carsList.set(i,car);
                }
            }
        }
        else {
            plateHashTable.put(key,car);
        }
    }

    public static void remove(String key){
        if(size < thresholdNo){

            for (int i = 0; i < carsList.size(); i++) {
                if(carsList.get(i).getPlate().equals(key)){
                    carsList.remove(i);
                }
            }
        }
        else {
            plateHashTable.remove(key);
        }
        size--;
        SmartAR.swichContainerIfReachThresholdNo();
    }


    public static Car getValue(String key){
        if(size < thresholdNo) {
            for (Car car : carsList) {
                if (car.plate.equals(key)) {
                    return car;
                }
            }
        }
        return plateHashTable.get(key);

    }

    public static String nextKey(String key){
        String nextKey;
        Car value;
        Enumeration<String> carKeyList = plateHashTable.keys();
        if (size < thresholdNo){
            for(int i=0;i<carsList.size();i++)
            {
                if(carsList.get(i).plate == key)
                {
                    if(i==carsList.size()-1)
                        return null;
                    else
                    {
                        return carsList.get(i+1).plate;
                    }
                }
            }
        }
        else{
            if (allKeys().contains(key)){
                value=getValue(key);
                for (int i = 1;i <= plateHashTable.size() + reusedPlate.size();i++){
                    carKeyList = plateHashTable.keys();
                    while(carKeyList.hasMoreElements()){
                        nextKey= carKeyList.nextElement();
                        if(getValue(nextKey).date == (value.date + i)){
                            return nextKey;
                        }
                    }
                }
            }
        }
        return null;
    }

    public static String prevKey(String key){
        String prevKey;
        Car value;
        Enumeration<String> carKeyList = plateHashTable.keys();
        if (size < thresholdNo){
            for(int i=0;i<carsList.size();i++)
            {
                if(carsList.get(i).plate == key)
                {
                    if(i == 0)
                        return null;
                    else
                    {
                        return carsList.get(i - 1).plate;
                    }
                }
            }

        }
        else {
            if (allKeys().contains(key)) {
                value = getValue(key);
                //increasing the time
                for (int i = 1; i < plateHashTable.size() + reusedPlate.size(); i++) {
                    carKeyList = plateHashTable.keys();
                    //search for every key
                    while (carKeyList.hasMoreElements()) {
                        prevKey = carKeyList.nextElement();
                        //compare the time of keys.
                        if (getValue(prevKey).date == (value.date - i)) {
                            return prevKey;
                        }
                    }
                }
            }
        }
        return null;
    }

    public static ArrayList<Car> previousCars(String key){
        ArrayList<Car> cars = new ArrayList<>();

        for (CarNode carNode:reusedPlate) {
            if(carNode.key.equals(key)){
                cars.add(carNode.getCar());
            }
        }
        Collections.sort(cars);
        Collections.reverse(cars);
        return cars;
    }




    public static void main(String[] args) {
        String plate;

//        Scanner scanner = null;
//        try{
//            scanner = new Scanner(new FileInputStream("ar_test_file1.txt"));
//        } catch(FileNotFoundException e){
//            System.out.println("Could not open input file for reading."
//                    + " Please check if file exists.");
//            System.out.print("Program will terminate.");
//            System.exit(0);
//        }
//
//        while (scanner.hasNext()){
//            plate = scanner.nextLine();
//            Car car = new Car(plate);
//            SmartAR.add(plate,car);
//        }
//        scanner.close();


//        setKeyLength(8);
//        System.out.println(generate(6));
//
        setThreshold(3);

        Car car1 = new Car("a1");
        Car car2 = new Car("a1");
        Car car3 = new Car("a1");
        Car car4 = new Car("b1");
        Car car5 = new Car("b1");
        Car car6 = new Car("b1");
        Car car7 = new Car("b1");
        Car car8 = new Car("b1");
        Car car9 = new Car("c1");
        Car car10 = new Car("d1");
        Car car11 = new Car("e1");
        Car car12 = new Car("f1");
        add(car1.getPlate(),car1);
        add(car2.getPlate(),car2);
        add(car3.getPlate(),car3);
        add(car4.getPlate(),car4);
        add(car5.getPlate(),car5);
        add(car6.getPlate(),car6);
        add(car7.getPlate(),car7);
        add(car8.getPlate(),car8);
        add(car9.getPlate(),car9);
        add(car10.getPlate(),car10);
        add(car11.getPlate(),car11);
        add(car12.getPlate(),car12);




//        setThreshold(10);



        System.out.println(allKeys());

//        remove("c1");
//        System.out.println(allKeys());

        System.out.println(getValue("b1"));

        System.out.println(nextKey("a1"));
        System.out.println(nextKey("b1"));
        System.out.println(nextKey("c1"));
        System.out.println(prevKey("a1"));
        System.out.println(prevKey("b1"));
        System.out.println(prevKey("c1"));


        System.out.println(previousCars("a1"));
        System.out.println(previousCars("b1"));



    }
}
