package generator;

public class BinaryOperations {
    private static String fixLength(String fixing, int length) {
        StringBuilder buffer = new StringBuilder(fixing);

        if (fixing.length() < length) {
            for (int i = 0; i != length - fixing.length(); i++) {
                buffer.insert(0, 0);
            }
        } else if (fixing.length() > length) {
            buffer.delete(0, fixing.length() - length);
        }else{
            return fixing;
        }
        return buffer.toString();
    }
}
