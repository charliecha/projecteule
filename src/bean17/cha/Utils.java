package bean17.cha;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utils {
	/**
	 * read whole file
	 * @param file file
	 * @return file content
	 */
	public static String readString(File file) {
		StringBuilder builder = new StringBuilder();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String line;
			while (null != (line = reader.readLine())) {
				builder.append(line.trim());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != reader) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return builder.toString();
	}

	/**
	 * read lines
	 * @param file file
	 * @return contents
	 */
	public static String[] readStringArray(File file) {
		List<String> list = new ArrayList<String>();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String line;
			while (null != (line = reader.readLine())) {
				list.add(line.trim());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != reader) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		final int size = list.size();
		String[] array = new String[size];
		for (int i = 0; i < size; i++) {
			array[i] = list.get(i);
		}
		return array;
	}
	
	/**
	 * is n prime?
	 * @param n int value
	 * @return is prime?
	 */
	public static boolean isPrime(long n) {
		if (2 > n) {
			return false;
		}
		
		boolean isPrime = true;
		for (int i = 2; i * i <= n; i++) {
			if (0 == n % i) {
				isPrime = false;
				break;
			}
		}
		return isPrime;
	}

	/**
	 * next prime after current
	 * @param current current value
	 * @return next prime
	 */
	public static long nextPrime(long current) {
		long next = current + 1;
		while (!Utils.isPrime(next)) {
			next++;
		}
		return next;
	}

	/**
	 * compute prime factor in [start, end)
	 *
	 * @param start start
	 * @param end end
	 * @return list of primes
	 */
	public static List<Long> primeFactor(long start, long end) {
		List<Long> primeFactorList = new ArrayList<Long>();
		for (long i = 2; i <= end; i++) {
			boolean prime = true;
			for (int j = 0; j < primeFactorList.size(); j++) {
				long value = primeFactorList.get(j);
				long sqrt = sqrt(i);
				if (0 == i % value) {
					prime = false;
					break;
				} else if (value > sqrt) {
					break;
				}
			}

			if (prime) {
				primeFactorList.add(i);
			}

			if (0 != i % 2) {
				i++;
			}
		}

		if (start > 2) {
			for (int i = primeFactorList.size() - 1; i >= 0; i--) {
				primeFactorList.remove(i);
			}
		}
		return primeFactorList;
	}

	/**
	 * compute [prime factor, time] set of value
	 *
	 * @param value value
	 * @return set of [prime factor, time]
	 */
	public static Map<Long, Integer> primeFactor(long value) {
		Map<Long, Integer> map = new HashMap<Long, Integer>();
		List<Long> set = primeFactor(2, value);
		long v = value;
		while (1 != v) {
			for (Long long1 : set) {
				if (0 == v % long1) {
					v = v / long1;
					if (map.containsKey(long1)) {
						map.put(long1, map.get(long1) + 1);
					} else {
						map.put(long1, 1);
					}
					break;
				}
			}
		}
		return map;
	}

	/**
	 * sqrt of i
	 * @param i current value
	 * @return sqrt of i
	 */
	public static long sqrt(long i) {
		return (long) Math.sqrt(i + 0.1);
	}

	/**
	 * is i a square?
	 * @param i current value
	 * @return true: i is a square
	 */
	public static boolean isSqrt(long i) {
		long sqrt = sqrt(i);
		return sqrt * sqrt == i;
	}
}
