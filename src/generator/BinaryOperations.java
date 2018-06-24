package generator;


public class BinaryOperations {
    private static boolean[] oneDecimalToBoolean(int number){
        String binary = fixLength(Integer.toBinaryString(number));
        char splitBinary[] = binary.toCharArray();
        boolean toBoolean[] = new boolean[splitBinary.length];

        for(int i = 0; i != splitBinary.length; i++){
            if(splitBinary[i] == '0') toBoolean[i] = false;
            else if (splitBinary[i] == '1') toBoolean[i] = true;
        }
        return toBoolean;
    }

    private static String fixLength(String fixing){
        StringBuilder buffer = new StringBuilder(fixing);
        if (fixing.length() == 6) return fixing;
        for(int i = 0; i != 6 - fixing.length(); i++){
            buffer.insert(0, 0);
        }

        return buffer.toString();
    }

    private static boolean[] addArrays(boolean array[], boolean array2[]){
        boolean addedArray[] = new boolean[array.length + array2.length];
        for (int i = 0; i != array.length; i++) {
            addedArray[i] = array[i];
        }

        for (int i = 0; i != array2.length; i++) {
            addedArray[i + array.length] = array2[i];
        }

        return addedArray;
    }

    public static boolean[] decimalToBinary(int number){
        number = number * 6;
        boolean finalBoolean[];
        finalBoolean = oneDecimalToBoolean(number);

        for (int i = 1; i != 6 ; i++) {
            finalBoolean = addArrays(finalBoolean, oneDecimalToBoolean(number + i));
        }
        return finalBoolean;
    }
}
