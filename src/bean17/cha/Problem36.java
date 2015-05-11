package bean17.cha;

public class Problem36 {

    /**
     * @param args arguments
     */
    public static void main(String[] args) {
        new Problem36().testPalindromes();
    }

    private void testPalindromes() {
        long start = System.currentTimeMillis();
        long count = 0;

        final int max = 1000000;
        for (int i = 1; i < max; i++) {
            char[] binary = Integer.toBinaryString(i).toCharArray();
            char[] tens = Integer.toString(i).toCharArray();
            if (isPalindromes(binary) && isPalindromes(tens)){
                count += i;
            }
        }

        System.out.println("count = " + count);
        System.out.println("cost time : "
                + (System.currentTimeMillis() - start) + "ms.");
    }

    private boolean isPalindromes(final char[] cs) {
        int start = 0;
        while(cs[start]=='0'){
            start++;
        }
        int end = cs.length - 1;
        while(cs[start] == cs[end] && start < end){
            start++;
            end--;
        }
        return start >= end;
    }
}
