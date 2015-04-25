package bean17.cha;

public class Problem19 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Problem19().sundays();
	}

	protected void sundays() {
		long start = System.currentTimeMillis();

		int year = 1900;
		int month = 1;
		int weekday = 0;

		int count = 0;
		do {
			weekday += days(year, month);
			weekday %= 7;
			if (year > 1900 && 6 == weekday) {
				count++;
			}

			month++;
			if (month > 12) {
				month = month % 12;
				year++;
			}
		} while (year < 2001);

		System.out.println("count = " + count);
		System.out.println("cost time : "
				+ (System.currentTimeMillis() - start) + "ms.");
	}

	private static int days(int year, int month) {
		if (1 == month || 3 == month || 5 == month || 7 == month || 8 == month
				|| 10 == month || 12 == month) {
			return 31;
		} else if (4 == month || 6 == month || 9 == month || 11 == month) {
			return 30;
		} else {
			if (isLeap(year)) {
				return 29;
			} else {
				return 28;
			}
		}
	}

	private static int days(int year) {
		if (isLeap(year)) {
			return 366;
		}
		return 365;
	}

	private static boolean isLeap(int year) {
		if (0 != year % 4) {
			return false;
		}

		if (0 != year % 100) {
			return true;
		}

		if (0 == year % 400) {
			return true;
		}

		return false;
	}
}
