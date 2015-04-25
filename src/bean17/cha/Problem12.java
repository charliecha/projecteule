package bean17.cha;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem12 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Problem12().p12();
	}

	/**
	 * Problem 10 compute sum of prime factor in [2, 1,000,000)
	 */
	protected void p12_2() {
		long start = System.currentTimeMillis();
		PrimeFactorCache cache = new PrimeFactorCache();

		long result = 0;
		primeFactor(2, result, cache);

		long i;
		int count = 0;
		for (i = 1; i < Long.MAX_VALUE; i++) {
			result += i;
			count = count(0 == i % 2 ? i / 2 : (i + 1) / 2, cache)
					* count(0 == i % 2 ? i + 1 : i, cache);
			if (count > 500) {
				break;
			}
		}

		System.out.println("cost time : "
				+ (System.currentTimeMillis() - start) + "ms.");
		System.out.println("result = " + result + " ,i = " + i + " ,count = " + count);
	}

	private int count(long value, PrimeFactorCache cache) {
		primeFactor(2, value + 1, cache);

		List<Long> primeFactorList = cache.primeFactorList;
		int count = 1;
		for (int j = 0; j < primeFactorList.size(); j++) {
			long primeFactor = primeFactorList.get(j).longValue();

			if (0 == value % primeFactor) {
				int time = 0;
				while (0 == value % primeFactor) {
					value /= primeFactor;
					time++;
				}
				count *= time + 1;
			} else if (value < primeFactor) {
				break;
			}
		}
		return count;
	}

	/**
	 * Problem 10 compute sum of prime factor in [2, 1,000,000)
	 */
	protected void p12() {
		long start = System.currentTimeMillis();

		PrimeFactorCache cache = new PrimeFactorCache();
		FactorDividerFactory factorFactory = new FactorDividerFactory(cache);

		long result = 3;
		long primeCount = 0;
		long i;

		for (i = 3; i < Long.MAX_VALUE; i++) {
			result += i;

			IFactorDivider iFactorDivider = new NonPrimeFactorDivider(result,
					0 == i % 2 ? i / 2 : i, 0 == i % 2 ? i + 1 : (i + 1) / 2,
					factorFactory);

			primeCount = iFactorDivider.count();

			if (primeCount > 1000) {
				for (Long key : iFactorDivider.divide().keySet()) {
					System.out.println(key + " "
							+ iFactorDivider.divide().get(key));
				}
				break;
			}

		}

		System.out.println("cost time : "
				+ (System.currentTimeMillis() - start) + "ms.");
		System.out.println("result = " + result + " ,i = " + i + ", primeCount = " + primeCount);
	}

	/**
	 * compute prime factor in [start, end)
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	private static List<Long> primeFactor(long start, long end,
			PrimeFactorCache cache) {
		List<Long> primeFactorList = null;

		long primeStart;
		if (null == cache) {
			primeFactorList = new ArrayList<Long>();
			primeStart = 2;
		} else {
			primeFactorList = cache.primeFactorList;
			primeStart = Math.max(cache.end, start);
		}

		long i;
		for (i = primeStart; i < end; i++) {
			boolean prime = true;
			for (int j = 0; j < primeFactorList.size(); j++) {
				long value = primeFactorList.get(j).longValue();
				long r = value * value;

				if (0 == i % value) {
					prime = false;
					break;
				} else if (r > i) {
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

		if (null != cache) {
			cache.end = i;
		}

		if (null == cache) {
			if (primeFactorList.size() > 0 && primeFactorList.get(0) < start) {
				for (int j = primeFactorList.size() - 1; j >= 0; j--) {
					if (primeFactorList.get(j) < start) {
						primeFactorList.remove(i);
					}
				}
			}
		}
		return primeFactorList;
	}

	/**
	 * cache of prime factor
	 * 
	 * @author Charlie
	 * 
	 */
	class PrimeFactorCache {
		public PrimeFactorCache() {
			end = 0;
			primeFactorList = new ArrayList<Long>();
		}

		public long end;
		final List<Long> primeFactorList;
	}

	/**
	 * factor divide interface
	 * 
	 * @author Charlie
	 * 
	 */
	interface IFactorDivider {
		Map<Long, Integer> divide();

		int count();
	}

	/**
	 * factor divider create interface
	 * 
	 * @author Charlie
	 * 
	 */
	interface IFactorDividerFactory {
		IFactorDivider create(long value);
	}

	/**
	 * factor divider create implement
	 * 
	 * @author Charlie
	 * 
	 */
	class FactorDividerFactory implements IFactorDividerFactory {
		/**
		 * known prime factor
		 */
		private final PrimeFactorCache cache;

		/**
		 * know factor divider
		 */
		private final Map<Long, IFactorDivider> factorMap = new HashMap<Long, IFactorDivider>();

		public FactorDividerFactory(PrimeFactorCache cache) {
			super();
			this.cache = cache;
		}

		@Override
		public IFactorDivider create(long value) {
			if (factorMap.containsKey(value)) {
				return factorMap.get(value);
			}

			primeFactor(2, value + 1, cache);
			
			List<Long> primeFactorList = cache.primeFactorList;
			for (int i = 0; i < primeFactorList.size(); i++) {
				long primeFactor = primeFactorList.get(i);
				if (0 == value % primeFactor) {
					IFactorDivider factor;
					long factor1 = 1;
					long factor2 = value;
					int time = 0;
					
					while (0 == factor2 % primeFactor) {
						factor2 /= primeFactor;
						time++;
						factor1 *= primeFactor;
					}

					if (1 == time && 1 == factor2) {
						factor = new PrimeFactorDivider(value);
					} else {
						TimesPrimeFactorDivider timesPrimeFactorDivider = new TimesPrimeFactorDivider(
								primeFactor, time);

						if (1 == factor2) {
							factor = timesPrimeFactorDivider;
						} else {
							factorMap.put(factor1, timesPrimeFactorDivider);
							factor = new NonPrimeFactorDivider(value, factor1,
									factor2, this);
						}
					}

					factorMap.put(value, factor);
					return factor;
				}
			}

			throw new IllegalArgumentException("wrong");
		}
	}

	/**
	 * prime factor divider
	 * 
	 * @author Charlie
	 * 
	 */
	class PrimeFactorDivider implements IFactorDivider {
		protected int count;
		protected final Long value;
		protected Map<Long, Integer> map = null;

		public PrimeFactorDivider(Long value) {
			super();
			this.value = value;
			count = 1;
		}

		@Override
		public Map<Long, Integer> divide() {
			if (null != map) {
				return map;
			}

			map = new HashMap<Long, Integer>();
			map.put(value, count);
			return map;
		}

		@Override
		public int count() {
			return count + 1;
		}
	}

	class TimesPrimeFactorDivider extends PrimeFactorDivider {

		public TimesPrimeFactorDivider(Long value, int count) {
			super(value);
			this.count = count;
		}
	}

	/**
	 * non prime factor divider
	 * 
	 * @author Charlie
	 * 
	 */
	class NonPrimeFactorDivider implements IFactorDivider {
		// private final long value;
		/**
		 * factor1
		 */
		private final IFactorDivider factor1;

		/**
		 * foctor2
		 */
		private final IFactorDivider factor2;

		/**
		 * result of divide
		 */
		private Map<Long, Integer> map = null;

		private int count = 0;

		public NonPrimeFactorDivider(long value, long factor1, long factor2,
				IFactorDividerFactory factorFactory) {
			super();
			// this.value = value;
			this.factor1 = factorFactory.create(factor1);
			this.factor2 = factorFactory.create(factor2);
			// count = this.factor1.count() * this.factor2.count();
		}

		@Override
		public Map<Long, Integer> divide() {
			if (null != map) {
				return map;
			}

			map = new HashMap<Long, Integer>();
			map.putAll(factor1.divide());

			Map<Long, Integer> map2 = factor2.divide();
			for (Long factor : map2.keySet()) {
				int factorCount = map2.get(factor);
				if (map.containsKey(factor)) {
					factorCount += map.get(factor);
				}
				map.put(factor, factorCount);
			}
			return map;
		}

		@Override
		public int count() {
			if (0 < count) {
				return count;
			}

			count = factor1.count() * factor2.count();
			
//			count = 1;
//			Map<Long, Integer> map = divide();
//			for (Long key : map.keySet()) {
//				count *= map.get(key) + 1;
//			}
			return count;
		}
	}
}
