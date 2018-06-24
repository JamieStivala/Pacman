package generator;

public class BinaryOperations {
    private static String fixLength(String fixing){
        StringBuilder buffer = new StringBuilder(fixing);
        if (fixing.length() == 8) return fixing;
        for(int i = 0; i != 8 - fixing.length(); i++){
            buffer.insert(0, 0);
        }

        return buffer.toString();
    }

    private static char[] oneDecimalToBinary(int number){
        return fixLength(Integer.toBinaryString(number)).toCharArray();
    }
}
