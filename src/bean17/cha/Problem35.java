package bean17.cha;


public class Problem35 {
    //    final byte UNKNOWN = 0;
//    final byte PRIME = 1;
//    final byte NON_PRIME = 2;
    final int max = 1000000;
    final int length = (int) Math.log10(max + 1) + 1;
    final byte[] data = new byte[max];

    /**
     * @param args arguments
     */
    public static void main(String[] args) {
        new Problem35().testCircularPrimes();
    }

    private void testCircularPrimes() {
        long start = System.currentTimeMillis();
        int count = 0;
//        System.out.println(length);

        for (int i = 2; i < max; i++) {
            int index = 0;
            int[] digit = new int[length];

            int remaining = i % 10;
            int tens = i / 10;
            while (tens != 0) {
                digit[index++] = remaining;
                remaining = tens % 10;
                tens = tens / 10;
            }
            digit[index++] = remaining;
            final int size = index;

            boolean circularPrime = true;
            for (int j = size - 1; j >= 0; j--) {
                int value = 0;
                for (int k = j; k > j - size; k--) {
                    value = value * 10 + digit[(k + size) % size];
                }
//                if (UNKNOWN != data[value]) {
//                    if (PRIME != data[value]) {
//                        circularPrime = false;
//                        break;
//                    }
//                } else {
                if (prime(value)) {
//                        data[value] = PRIME;
                } else {
//                        data[value] = NON_PRIME;
                    circularPrime = false;
                    break;
                }
//                }
            }
            if (circularPrime) {
//                System.out.println(i);
                count++;
            }
        }

        System.out.println("count = " + count);
        System.out.println("cost time : "
                + (System.currentTimeMillis() - start) + "ms.");
    }

    private boolean prime(final int value) {
        if (value < 2) {
            return false;
        }
        boolean prime = true;
        for (int i = 2; i * i <= value; i++) {
            if (0 == value % i) {
                prime = false;
                break;
            }
        }
        return prime;
    }
}
