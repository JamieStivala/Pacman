package generator;

public class BinaryOperations {
    private static boolean[] oneDecimalToBoolean(int number){
        String binary = fixLenght(Integer.toBinaryString(number));
        char splitBinary[] = binary.toCharArray();
        boolean toBoolean[] = new boolean[splitBinary.length];

        for(int i = 0; i != splitBinary.length; i++){
            if(splitBinary[i] == '0') toBoolean[i] = true;
            else if (splitBinary[i] == '1') toBoolean[i] = false;
        }
        return toBoolean;
    }

    private static String fixLenght(String fixing){
        StringBuilder buffer = new StringBuilder(fixing);
        if (fixing.length() == 6) return fixing;
        for(int i = 0; i != 6 - fixing.length(); i++){
            buffer.insert(0, 0);
        }

        return buffer.toString();
    }
}
