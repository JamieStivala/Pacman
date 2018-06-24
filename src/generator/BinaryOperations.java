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

    private static char[] addArrays(char[] array1, char[] array2){
        char addedArray[] = new char[array1.length + array2.length];
        for (int i = 0; i != array1.length; i++) {
            addedArray[i] = array1[i];
        }

        for (int i = 0; i != array2.length; i++) {
            addedArray[i + array1.length] = array2[i];
        }

        return addedArray;
    }


}
