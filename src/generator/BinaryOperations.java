package generator;

public class BinaryOperations {
    private static String fixLength(String fixing, int length) {
        if (fixing.length() == length) return fixing;
        StringBuilder buffer = new StringBuilder(fixing);

        if (fixing.length() < length) {
            for (int i = 0; i != length - fixing.length(); i++) {
                buffer.insert(0, 0);
            }
        } else {
            buffer.delete(0, fixing.length() - length);
        }

        return buffer.toString();
    }
}
