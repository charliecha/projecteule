package bean17.cha;


import java.util.Arrays;

/**
 * Cubic permutations
 * Problem 62
 * The cube, 41063625 (3453), can be permuted to produce two other cubes: 56623104 (3843)
 * and 66430125 (4053). In fact, 41063625 is the smallest cube w
 * hich has exactly three permutations of its digits which are also cube.
 * <p/>
 * Find the smallest cube for which exactly five permutations of its digits are cube.
 */
public class Problem62 {
    final int N = 10000;

    long[] cubes = new long[N];

    final int LESS = 1;
    final int ARRAGMENT = 2;
    final int NOT_ARRAGMENT = 3;
    final int LARGE = 4;


    /**
     * @param args arguments
     */
    public static void main(String[] args) {
        new Problem62().testCubicPermutations();
    }

    private void testCubicPermutations() {
        long start = System.currentTimeMillis();

        for (int i = 0; i < 5; i++) {
            cubes[i] = cube(i);
        }

        int min = 0;
        boolean find = false;

        for (int i = 5; !find && i < N; i++) {
            if (0 == cubes[i]) {
                cubes[i] = cube(i);
            }

            for (int j = i - 1; !find && j >= 3; j--) {
                int c = compare(cubes[j], cubes[i]);
                if (LESS == c) {
                    break;
                } else if (ARRAGMENT == c) {
                    for (int k = j - 1; !find && k >= 2; k--) {
                        int c2 = compare(cubes[k], cubes[i]);
                        if (LESS == c2) {
                            break;
                        } else if (ARRAGMENT == c2) {
                            for (int l = k - 1; !find && l >= 1; l--) {
                                int c3 = compare(cubes[l], cubes[i]);
                                if (LESS == c3) {
                                    break;
                                } else if (ARRAGMENT == c3) {
                                    for (int m = l - 1; !find && m >= 0; m--) {
                                        int c4 = compare(cubes[m], cubes[i]);
                                        if (LESS == c4) {
                                            break;
                                        } else if (ARRAGMENT == c4) {
                                            find = true;
                                            min = m;
//                                            System.out.println(i + " " + cubes[i]);
//                                            System.out.println(j + " " + cubes[j]);
//                                            System.out.println(k + " " + cubes[k]);
//                                            System.out.println(l + " " + cubes[l]);
//                                            System.out.println(m + " " + cubes[m]);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println("min cube = " + cubes[min]);
        System.out.println("cost time : "
                + (System.currentTimeMillis() - start) + "ms.");
    }

    int compare(long source, long target) {
        char[] ss = String.valueOf(source).toCharArray();
        char[] ts = String.valueOf(target).toCharArray();
        if (ss.length < ts.length) {
            return LESS;
        } else if (ss.length > ts.length) {
            return LARGE;
        } else {
            Arrays.sort(ss);
            Arrays.sort(ts);
            for (int i = 0; i < ss.length; i++) {
                if (ss[i] != ts[i]) {
                    return NOT_ARRAGMENT;
                }
            }
            return ARRAGMENT;
        }
    }

    long cube(int n) {
        long result = 1;
        result = result * n * n * n;
        return result;
    }
}
