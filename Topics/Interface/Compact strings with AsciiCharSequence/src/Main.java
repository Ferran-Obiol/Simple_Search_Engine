import java.nio.charset.StandardCharsets;
import java.util.*;

class AsciiCharSequence implements CharSequence {

    private byte[] array;

    public AsciiCharSequence(byte[] array) {
        this.array = array.clone();
    }

    @Override
    public int length() {
        return array.length;
    }

    @Override
    public char charAt(int index) {
        return (char) array[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        int length = end - start;
        byte[] result = new byte[length];

        for (int i = start; i < end; i++) {
            result[i - start] = this.array[i];
        }
        return new AsciiCharSequence(result);
    }
    // implementation

    @Override
    public String toString() {
        return new String(this.array, StandardCharsets.UTF_8);
    }
}