package fastExponentiation;

public class Methods {

	public int naive1(long a, long b, long m) {
		long C = 1;
		for (int i = 0; i < b; i++) {
			C = C * a;
			if (C > Integer.MAX_VALUE) {
				// System.out.println("Over Flow");
				return -1;
			}
		}
		C = C % m;
		return (int) C;
	}

	public int naive2(long a, long b, long m) {
		long C = 1;
		for (int i = 0; i < b; i++) {
			C = (C * a);
			if (C > Integer.MAX_VALUE) {
				// System.out.println("Over Flow");
				return -1;
			}
			C = C % m;
		}
		return (int) C;
	}

	public int fastExponentiationIterative(long a, long b, long m) {
		String binaryRep = Long.toBinaryString(b);
		long x = 1;
		long pow = a % m;
		for (int i = binaryRep.length() - 1; i >= 0; i--) {
			if (binaryRep.charAt(i) == '1') {
				x = (x * pow) % m;
			}
			pow = (pow * pow);
			if (pow > Integer.MAX_VALUE) {
				// System.out.println("Over Flow");
				return -1;
			}
			pow = pow % m;
		}
		return (int) x;
	}

	public int fastExponentiationRecursive(long a, long b, long m) {
		long x;
		if (b == 0)
			return 1;
		else if (b == 1) {
			return (int) (a % m);
		} else if (b == 2) {
			x = a * a;
			if (x > Integer.MAX_VALUE) {
				// System.out.println("Over Flow");
				return -1;
			}
			x = x % m;
			return (int) x;
		} else {

			if (b % 2 == 0) {
				x = fastExponentiationRecursive(a, b / 2, m);
				if (x == -1)
					return -1;
				x = (x * x);
				if (x > Integer.MAX_VALUE) {
					// System.out.println("Over Flow");
					return -1;
				}
				x = x % m;
			} else {
				x = fastExponentiationRecursive(a, (b - 1), m);
				if (x == -1)
					return -1;
				x = x * (a % m);
				if (x > Integer.MAX_VALUE) {
					// System.out.println("Over Flow");
					return -1;
				}
				x = x % m;
			}
			return (int) x;
		}
	}
}
