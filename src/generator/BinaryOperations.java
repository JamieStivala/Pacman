package generator;

public class BinaryOperations {
    private static String fixLength(String fixing){
        if (fixing.length() == 30) return fixing;
        StringBuilder buffer = new StringBuilder(fixing);
        for(int i = 0; i != 30 - fixing.length(); i++){
            buffer.insert(0, 0);
        }

        return buffer.toString();
    }
}
