import org.apache.commons.math3.complex.Complex;
public class ComplexTest {
	public static Complex zero = new Complex(0,0);
	public static Complex one = new Complex(1,0);
	public static Complex two = new Complex(2,0);
	public static Complex three = new Complex(3,0);
	public static Complex four = new Complex(4,0);
	public static Complex five = new Complex(5,0);
	public static Complex six = new Complex(6,0);
	public static Complex seven = new Complex(7,0);
	public static Complex eight = new Complex(8,0);
	public static Complex nine = new Complex(9,0);
	public static Complex[] valFromString(String valString) {
		String[] strVals = valString.split("");
		Complex[] ans = new Complex[strVals.length];
		for (int i = 0;i < strVals.length;i++) {
			switch (strVals[i]) {
			case "0":
				ans[i] = zero;
				break;
			case "1":
				ans[i] = one;
				break;
			case "2":
				ans[i] = two;
				break;
			case "3":
				ans[i] = three;
				break;
			case "4":
				ans[i] = four;
				break;
			case "5":
				ans[i] = five;
				break;
			case "6":
				ans[i] = six;
				break;
			case "7":
				ans[i] = seven;
				break;
			case "8":
				ans[i] = eight;
				break;
			case "9":
				ans[i] = nine;
				break;
			}
		}
		return ans;
	}
/*public static void main(String[] args) {
	
	Complex base = new Complex(-3,1);
	Complex[] vals = valFromString("00039179810088");//{zero,zero,zero,three,nine,one,seven,nine,eight,one,zero,zero,eight,eight};
	Complex answer = new Complex(0,0);
	for (int i = 0; i < vals.length;i++) {
		answer = answer.add(vals[i].divide(base.pow(((double) i) + 1.0)));
	}
	System.out.println(answer.toString());
}*/
}
