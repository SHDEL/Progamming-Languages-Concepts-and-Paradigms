import java.math.BigInteger;

public class IntTest {

    public static void main(String[] args) {

        // long a = 9_223_372_036_854_775_807L;
        // long overflow = a + 1;
        // System.out.println("ans: " + overflow);

        BigInteger b = new BigInteger("9223372036854775807");
        BigInteger c = b.add(new BigInteger("1"));
        System.out.println("BigInteger c: " + c);
    }
}
