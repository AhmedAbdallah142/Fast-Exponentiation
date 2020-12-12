package fastExponentiation;

public class DataController {
	public long[][] values;
	public double[][] naive1;
	public double[][] naive2;
	public double[][] iterative;
	public double[][] recursion;

	public DataController(long[][] values) {
		this.values = values;
		this.naive1 = new double[values.length][2];
		this.naive2 = new double[values.length][2];
		this.iterative = new double[values.length][2];
		this.recursion = new double[values.length][2];
	}

	public void setData() {
		int n = 5;
		double startTime, endTime;
		Methods m = new Methods();
		double[] naive1Temp = new double[n];
		double[] naive2Temp = new double[n];
		double[] iterativeTemp = new double[n];
		double[] recursionTemp = new double[n];
		//////////////////////////////////////
		for (int i = 0; i < values.length; i++) {
			for (int j = 0; j < n; j++) {
//////////////////////////////Naive 1////////////////////////////////
				startTime = System.nanoTime();
				naive1[i][0] = m.naive1(values[i][0], values[i][1], values[i][2]);
				endTime = System.nanoTime();
				naive1Temp[j] = endTime - startTime;
//////////////////////////////Naive 2////////////////////////////////
				startTime = System.nanoTime();
				naive2[i][0] = m.naive2(values[i][0], values[i][1], values[i][2]);
				endTime = System.nanoTime();
				naive2Temp[j] = endTime - startTime;
//////////////////////////////Iterative////////////////////////////////
				startTime = System.nanoTime();
				iterative[i][0] = m.fastExponentiationIterative(values[i][0], values[i][1], values[i][2]);
				endTime = System.nanoTime();
				iterativeTemp[j] = endTime - startTime;
//////////////////////////////Recursion ////////////////////////////////
				startTime = System.nanoTime();
				recursion[i][0] = m.fastExponentiationRecursive(values[i][0], values[i][1], values[i][2]);
				endTime = System.nanoTime();
				recursionTemp[j] = endTime - startTime;
			}
			naive1[i][1] = average(naive1Temp);
			naive2[i][1] = average(naive2Temp);
			iterative[i][1] = average(iterativeTemp);
			recursion[i][1] = average(recursionTemp);
		}
		// System.out.println();
	}

	private static double average(double[] arr) {
		double sum = 0;
		for (double l : arr) {
			sum += l;
		}
		return sum / arr.length;
	}
}
