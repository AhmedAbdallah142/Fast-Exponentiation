package fastExponentiation;

public class Methods {

	public int naive1(int a,int b,int m) {
		int C = 1;
		for (int i=0;i<b;i++ ) {
			C=C*a;
		}
		C= C % m;
		return C;
	}
	
	public int naive2(int a,int b,int m) {
		int C = 1;
		for (int i=0;i<b;i++ ) {
			C=(C*a)%m;
		}
		return C;
	}
	
	public int fastExponentiationIterative(int a,int b,int m) {
		String binaryRep = Integer.toBinaryString(b);
		int x=1;
		int pow = a % m ;
		for (int i=binaryRep.length()-1;i>=0;i--) {
			if (binaryRep.charAt(i)=='1') {
				x=(x*pow)%m;
			}
			pow = (pow*pow)%m;
		}
		return x;
	}
	
	public int fastExponentiationRecursive(int a,int b,int m) {
		if (b==0)return 1;
		else if (b==1) {
			return a%m;
		}
		else if (b==2) {
			return (a*a)%m;
		}
		else {
			int x;
			if (b%2==0) {
				x=fastExponentiationRecursive(a,b/2,m);
				x=(x*x)%m;
			}
			else {
				x=(fastExponentiationRecursive(a,(b-1),m)*(a%m))%m;
			}
			return x;
		}
	}
}
