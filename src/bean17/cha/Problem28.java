package bean17.cha;

import java.util.Arrays;

public class Problem28 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Problem28().testSpiralDiagonals();
	}

	private void testSpiralDiagonals() {
		long start = System.currentTimeMillis();

		int s = 500;
		final int n = s * 2 + 1;

		int[][] data = new int[n][n];
		for (int i = 0; i < data.length; i++) {
			Arrays.fill(data[i], 0);
		}

		final int center = n / 2;

		final Point centerPoint = new Point(center, center);

		int currentValue = 1;
		write(data, centerPoint, currentValue++);

		Point currentPoint = centerPoint;
		Point nextPoint = null;
		while (null != (nextPoint = next(data, currentPoint, centerPoint))) {
			write(data, nextPoint, currentValue++);
			currentPoint = nextPoint;
		}

		long result = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) {
					result += data[i][j];
				} else if (i + j == n - 1) {
					result += data[i][j];
				}
			}
		}
		System.out.println("result = " + result);

		System.out.println("cost time : "
				+ (System.currentTimeMillis() - start) + "ms.");
	}

	private Point next(int[][] data, Point currentPoint, Point centerPoint) {
		Point topPoint = new Point(currentPoint.x, currentPoint.y - 1);
		Point leftPoint = new Point(currentPoint.x - 1, currentPoint.y);
		Point bottomPoint = new Point(currentPoint.x, currentPoint.y + 1);
		Point rightPoint = new Point(currentPoint.x + 1, currentPoint.y);

		Point nextPoint = null;
		Point[] nextpPoints = new Point[] { topPoint, leftPoint, bottomPoint,
				rightPoint };
		for (int i = 0; i < nextpPoints.length; i++) {
			Point point = nextpPoints[i];
			if (isValid(data, point)
					&& 0 == read(data, point)
					&& (null == nextPoint || round(point, centerPoint) <= round(
							nextPoint, centerPoint))) {
				nextPoint = point;
			}
		}
		return nextPoint;
	}

	private boolean isValid(int[][] data, Point point) {
		if (point.y < 0 || point.y >= data.length) {
			return false;
		}

		if (point.x < 0 || point.x >= data[0].length) {
			return false;
		}

		return true;
	}

	private int read(int[][] data, Point nextPoint) {
		return data[nextPoint.y][nextPoint.x];
	}

	private void write(int[][] data, Point nextPoint, int value) {
		data[nextPoint.y][nextPoint.x] = value;
	}

	private int round(Point point, Point center) {
		int round = Math.max(Math.abs(center.x - point.x),
				Math.abs(center.y - point.y));
		return round;
	}
	
	class Point {
		int x;
		int y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
