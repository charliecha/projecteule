package bean17.cha;

import java.util.ArrayList;
import java.util.List;

/**
 * Magic 5-gon ring
 * Problem 68
 * Consider the following "magic" 3-gon ring, filled with the numbers 1 to 6, and each line adding to nine.
 * <p/>
 * <p/>
 * Working clockwise, and starting from the group of three with the numerically lowest external node (4,3,2 in this example), each solution can be described uniquely. For example, the above solution can be described by the set: 4,3,2; 6,2,1; 5,1,3.
 * <p/>
 * It is possible to complete the ring with four different totals: 9, 10, 11, and 12. There are eight solutions in total.
 * <p/>
 * Total	Solution Set
 * 9	4,2,3; 5,3,1; 6,1,2
 * 9	4,3,2; 6,2,1; 5,1,3
 * 10	2,3,5; 4,5,1; 6,1,3
 * 10	2,5,3; 6,3,1; 4,1,5
 * 11	1,4,6; 3,6,2; 5,2,4
 * 11	1,6,4; 5,4,2; 3,2,6
 * 12	1,5,6; 2,6,4; 3,4,5
 * 12	1,6,5; 3,5,4; 2,4,6
 * By concatenating each group it is possible to form 9-digit strings; the maximum string for a 3-gon ring is 432621513.
 * <p/>
 * Using the numbers 1 to 10, and depending on arrangements, it is possible to form 16- and 17-digit strings. What is the maximum 16-digit string for a "magic" 5-gon ring?
 * /**
 * @author bean17.cha@gmail.com
 */
public class Problem68 {
    final int N = 10;
    final int MAX_RING = 16;

    final int[] values = new int[N];
    final int[] units = new int[N];

    /**
     * @param args arguments
     */
    public static void main(String[] args) {
        new Problem68().magic5GonRing();
    }

    private void magic5GonRing() {
        long start = System.currentTimeMillis();

        long max = 0;

        for (int i = 0; i < N; i++) {
            values[i] = i + 1;
            units[i] = fullPermutation(i);
        }

        final int PN = fullPermutation(N);

//        System.out.println(Arrays.toString(values));
//        System.out.println(Arrays.toString(units));
//        System.out.println("P(" + N + ") = " + fullPermutation(N));

        int match;
        int count;
        boolean success;
        boolean fail;

        List<Integer> sourceList = new ArrayList<Integer>();
        List<Integer> resultList = new ArrayList<Integer>();

        for (int k = 1; k <= PN; k++) {
            success = false;
            fail = false;

            match = k;
            count = 0;

            resultList.clear();
            sourceList.clear();
            for (int j = 0; j < N; j++) {
                sourceList.add(values[j]);
            }

            while (sourceList.size() > 1 && !success && !fail) {
                final int p1 = units[sourceList.size() - 1];
                for (int i = 0; i < sourceList.size(); i++) {
                    int p2 = p1 * (i + 1);
                    if (match == count + p2) {
                        // reverse get
                        success = true;

                        count += p1 * i;
                        resultList.add(sourceList.get(i));
                        sourceList.remove(i);
                        break;
                    } else if (match < count + p2) {
                        count += p1 * i;
                        resultList.add(sourceList.get(i));
                        sourceList.remove(i);
                        break;
                    }
                }

                // check condition
                if (resultList.size() <= N / 2 && resultList.size() > 1) {
                    for (int i = 1; i < N / 2; i++) {
                        if (resultList.size() > i) {
                            if (resultList.get(0) > resultList.get(i)) {
                                fail = true;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }

            if (success) {
                if (!sourceList.isEmpty()) {
                    for (int i = sourceList.size() - 1; i >= 0; i--) {
                        resultList.add(sourceList.get(i));
                    }
                }

                boolean find = true;
                int temp;
                int line = resultList.get(N / 2 - 1) + resultList.get(N - 1) + resultList.get(N / 2);
                for (int i = 0; i < N / 2 - 1; i++) {
                    temp = resultList.get(i) + resultList.get(i + N / 2) + resultList.get(i + N / 2 + 1);
                    if (line != temp) {
                        find = false;
                        break;
                    }
                }

                if (find) {
//                    System.out.println(Arrays.toString(resultList.toArray()));

                    StringBuilder builder = new StringBuilder();
                    for (int i = 0; i < N / 2 - 1; i++) {
                        builder.append(resultList.get(i)).append(resultList.get(i + N / 2)).append(resultList.get(i + N / 2 + 1));
                    }
                    builder.append(resultList.get(N / 2 - 1)).append(resultList.get(N - 1)).append(resultList.get(N / 2));

                    if (builder.length() <= MAX_RING) {
                        Long l = Long.parseLong(builder.toString());
                        if (l > max) {
                            max = l;
                        }
                    }
                }
            }
        }


        System.out.println("max = " + max);
        System.out.println("cost time : "
                + (System.currentTimeMillis() - start) + "ms.");
    }

    int fullPermutation(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
