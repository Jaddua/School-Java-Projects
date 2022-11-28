import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class GaussianInteger {
	private BigInteger real;
	private BigInteger imag;
	public static final GaussianInteger ZERO = new GaussianInteger("0", "0");
	public static final GaussianInteger ONE = new GaussianInteger("1","0");
	public static final GaussianInteger MINUSONE = new GaussianInteger("-1", "0");
	public static final GaussianInteger I = new GaussianInteger("0", "1");
	public static final GaussianInteger MINUSI = new GaussianInteger("0", "-1");
	public static final GaussianInteger M3Pi = new GaussianInteger("-3", "1");
	
	public GaussianInteger(BigInteger real, BigInteger imag) {
		this.real = real;
		this.imag = imag;
	}
	public GaussianInteger(String real, String imag) {
		this.real = new BigInteger(real);
		this.imag = new BigInteger(imag);
	}
	
	public BigInteger realPart() {
		return this.real;
	}
	
	public BigInteger imagPart() {
		return this.imag;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(imag, real);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GaussianInteger other = (GaussianInteger) obj;
		return Objects.equals(imag, other.imag) && Objects.equals(real, other.real);
	}
	
	public static GaussianInteger valueOf(BigInteger n) {
		return new GaussianInteger(n, BigInteger.ZERO);
	}
	
	public GaussianInteger add(GaussianInteger addend) {
		BigInteger augendReal = this.realPart();
		BigInteger augendImag = this.imagPart();
		BigInteger addendReal = addend.realPart();
		BigInteger addendImag = addend.imagPart();
		return new GaussianInteger(augendReal.add(addendReal), augendImag.add(addendImag));
	}
	public GaussianInteger subtract(GaussianInteger subtrahend) {
		BigInteger minuendReal = this.realPart();
		BigInteger minuendImag = this.imagPart();
		BigInteger subtrahendReal = subtrahend.realPart();
		BigInteger subtrahendImag = subtrahend.imagPart();
		return new GaussianInteger(minuendReal.subtract(subtrahendReal), minuendImag.subtract(subtrahendImag));
	}
	public GaussianInteger multiply(GaussianInteger multiplier) {
		BigInteger multiplicandReal = this.realPart();
		BigInteger multiplicandImag = this.imagPart();
		BigInteger multiplierReal = multiplier.realPart();
		BigInteger multiplierImag = multiplier.imagPart();
		return new GaussianInteger(multiplicandReal.multiply(multiplierReal).subtract(multiplicandImag.multiply(multiplierImag)), multiplicandReal.multiply(multiplierImag).add(multiplicandImag.multiply(multiplierReal)));
	}
	public GaussianInteger pow(BigInteger exponent) {
		GaussianInteger result = GaussianInteger.ONE;
		for (BigInteger i = BigInteger.ZERO; i.compareTo(exponent) == -1; i = i.add(BigInteger.ONE)) {
			result = result.multiply(this);
		}
		return result;
	}
	
	public String toString() {
		String answer = this.realPart().toString();
		if (this.realPart().compareTo(BigInteger.ZERO) == 0) {
			answer = "";
			if (this.imagPart().compareTo(BigInteger.ZERO) != 0) {
				if (this.imagPart().compareTo(BigInteger.ONE) == 0) {
					answer = "i";
				}
				else if (this.imagPart().compareTo(new BigInteger("-1")) == 0) {
					answer = "-i";
				}
				else {
					answer = this.imagPart().toString() + "i";
				}
			}
			else {
				answer = "0";
			}
		}
		else {
			//if (this.imagPart().compareTo(BigInteger.ZERO) != 0 && this.realPart().compareTo(BigInteger.ZERO) == 0) {
			if (this.imagPart().signum() == 1) {
				if (this.imagPart().compareTo(BigInteger.ONE) == 0) {
					answer = answer + "+" + "i";
				}
				else {
					answer = answer + "+" + this.imagPart().toString() + "i";
				}
			}
			else if (this.imagPart().signum() == -1){
				if (this.imagPart().abs().compareTo(BigInteger.ONE) == 0) {
					answer = answer + "-" + "i";
				}
				else {
					answer = answer + this.imagPart().toString() + "i";
				}
			}
		}
		return answer;//String.valueOf(this.realPart()) + " , " + String.valueOf(this.imagPart());
	}
	/*public BigInteger norm() {
		return this.realPart().pow(2).add(this.imagPart().pow(2));
	}*/
	public int compareNorm(GaussianInteger z) {
		if(this.norm().compareTo(z.norm()) == -1){
			return -1;
		}
		else if (this.norm().compareTo(z.norm()) == 1) {
			return 1;
		}
		else {
			return 0;
		}
	}
	/*public boolean isEqual(GaussianInteger z) {
		if (this.realPart().compareTo(z.realPart()) == 0 && this.imagPart().compareTo(z.imagPart()) == 0) {
			return true;
		}
		else {
			return false;
		}
	}*/
	
	/*public GaussianInteger intDivide(GaussianInteger divisor) {
		BigInteger dividendReal = this.realPart();
		BigInteger dividendImag = this.imagPart();
		BigInteger divisorReal = divisor.realPart();
		BigInteger divisorImag = divisor.imagPart();
		return new GaussianInteger(dividendReal.multiply(divisorReal).add(dividendImag.multiply(divisorImag)).divide(divisorReal.pow(2).add(divisorImag.pow(2))), dividendImag.multiply(divisorReal).subtract(dividendReal.multiply(divisorImag)).divide(divisorReal.pow(2).add(divisorImag.pow(2))));
	}*/
	
	public GaussianInteger divide(GaussianInteger divisor) {
		BigDecimal dividendReal = new BigDecimal(this.realPart());
		BigDecimal dividendImag = new BigDecimal(this.imagPart());
		BigDecimal divisorReal = new BigDecimal(divisor.realPart());
		BigDecimal divisorImag = new BigDecimal(divisor.imagPart());
		
		return new GaussianInteger(dividendReal.multiply(divisorReal).add(dividendImag.multiply(divisorImag)).divide(divisorReal.pow(2).add(divisorImag.pow(2)), 0, RoundingMode.HALF_EVEN).toBigInteger(), dividendImag.multiply(divisorReal).subtract(dividendReal.multiply(divisorImag)).divide(divisorReal.pow(2).add(divisorImag.pow(2)), 0, RoundingMode.HALF_EVEN).toBigInteger());
	}
	
	
	/*public GaussianInteger gcdHelp(GaussianInteger z) {
		GaussianInteger z1 = this;
		GaussianInteger z2 = z;
		//Complex Z1 = new Complex(z1);
		//Complex Z2 = new Complex(z2);
		GaussianInteger q = z1.divide(z2);
		GaussianInteger r = z1.subtract(q.multiply(z2));
		if (!r.equals(GaussianInteger.ZERO)) {
			return z2.gcdHelp(r);
		}
		else {
			return z2;
		}
		BigInteger Z1N = Z1.norm();
		BigInteger Z2N = Z2.norm();
		while(Z1N.compareTo(Z2N) != 0) {
			if (Z1N.compareTo(Z2N) == 1) {
				Z1N = Z1N.subtract(Z2N);
				Z1 = Z1.subtract(Z2);
			}
			else {
				Z2N = Z2N.subtract(Z1N);
				Z2 = Z2.subtract(Z1);
			}
		}
		return Z1;
		
	}
	public GaussianInteger gcdForM3Pi() {
		GaussianInteger gcd1 = this.gcdHelp(GaussianInteger.M3Pi);
		GaussianInteger gcd2 = GaussianInteger.M3Pi.gcdHelp(this);
		if (this.equals(gcd1)) {
			return gcd2;
		}
		else if (GaussianInteger.M3Pi.equals(gcd2)) {
			return gcd1;
		}
		else {
			//if (this.compareNorm(z) == -1) {
				if (gcd2.equals(GaussianInteger.MINUSONE) || gcd1.equals(GaussianInteger.MINUSONE) || gcd2.equals(GaussianInteger.ONE) || gcd1.equals(GaussianInteger.ONE)) {
					return GaussianInteger.ONE;
				}
			//}
			else {
				if (gcd1.equals(GaussianInteger.MINUSONE)) {
					return GaussianInteger.ONE;
				}
				else {
				return gcd2;
				//}
			}
		}
	}*/
	public GaussianInteger mod(GaussianInteger divisor) {
		GaussianInteger dividend = this;
		GaussianInteger q = dividend.divide(divisor);
		return dividend.subtract(q.multiply(divisor));
	}
	
	public GaussianInteger gcd(GaussianInteger z) {
		GaussianInteger a = this;
		GaussianInteger b = z;
		GaussianInteger t = b;
		while(!b.equals(GaussianInteger.ZERO)) {
			t = b;
			b = a.mod(b);
			a = t;
		}
		return a;
	}
	
	public boolean coPrime(GaussianInteger z) {
		GaussianInteger a = this;
		GaussianInteger b = z;
		GaussianInteger gcdab = a.gcd(b);
		if (gcdab.equals(GaussianInteger.ONE) || gcdab.equals(GaussianInteger.MINUSONE) || gcdab.equals(GaussianInteger.I) || gcdab.equals(GaussianInteger.MINUSI)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static GaussianInteger gaussIntFromStr(String str) {
		GaussianInteger ans = GaussianInteger.ZERO;
		if (str.contains("i")) {
			if (!str.contains("+") && !str.contains("-")) {
				if (str.compareTo("i") == 0) {
					ans = new GaussianInteger("0","1");
				}
				else {
					ans = new GaussianInteger("0",  str.substring(0,str.indexOf("i")));
				}
			}
			else if (str.contains("+")) {
				if ((str.indexOf("i") - str.indexOf("+")) == 1) {

					ans = new GaussianInteger(str.substring(0,str.indexOf("+")),"1");
				}
				else {
				ans = new GaussianInteger(str.substring(0,str.indexOf("+")), str.substring(str.indexOf("+")+1,str.indexOf("i")));	
				}
				}
			else if(str.contains("-") && !str.contains("+") && str.indexOf("-") == str.lastIndexOf("-") && str.indexOf("-") == 0) {
			if ((str.indexOf("i") - str.indexOf("-")) == 1) {
				ans = new GaussianInteger("0","-1");
					}
			else {
				ans = new GaussianInteger("0", str.substring(0,str.indexOf("i")));
			
				}
			}
			
			else {
			if ((str.indexOf("i") - str.lastIndexOf("-")) == 1) {
			ans = new GaussianInteger(str.substring(0,str.lastIndexOf("-")), "-1");	
			}
			else {
			ans = new GaussianInteger(str.substring(0,str.lastIndexOf("-")), str.substring(str.lastIndexOf("-"),str.indexOf("i")));
			}
				}
		}
		else {
		ans =  new GaussianInteger(str, "0");
		}
		return ans;
	}
	
	public BigInteger norm() {
		BigInteger real = this.realPart();
		BigInteger imag = this.imagPart();
		return real.multiply(real).add(imag.multiply(imag));
				}
	
	public List<GaussianInteger> factorize() {
		List<GaussianInteger> result = new ArrayList<>();
		if (this.norm().compareTo(BigInteger.ONE) <= 0) {  // 0, 1, -1, i, -i
			if (this.equals(ZERO)) {
			result.add(ZERO);
			}
			else if (this.equals(MINUSONE)) {
				result.add(I);
				result.add(I);
			}
			else if (this.equals(MINUSI)) {
				result.add(I);
				result.add(I);
				result.add(I);
			}
			else {
				result.add(this);
			}
			return result;
		}
		
		GaussianInteger temp = this;
		GaussianInteger check = GaussianInteger.ONE;//new GaussianInteger(1, 0);
		while (temp.norm().compareTo(BigInteger.ONE) == 1) {
			GaussianInteger factor = temp.findPrimeFactor();
			result.add(factor);
			temp = temp.divide(factor);
			check = check.multiply(factor);
		}
		check = check.multiply(temp);
		if (temp.norm().compareTo(BigInteger.ONE) != 0 || !check.realPart().equals(this.realPart()) || !check.imagPart().equals(this.imagPart()))
			throw new AssertionError();
		if (temp.realPart().compareTo(BigInteger.ONE) != 0)  // -1, i, -i
			result.add(temp);
		
		Collections.sort(result, new Comparator<GaussianInteger>() {
			public int compare(GaussianInteger x, GaussianInteger y) {
				if      (x.norm().compareTo(y.norm()) == -1) return -1;
				else if (x.norm().compareTo(y.norm()) == 1) return +1;
				else if (x.realPart().compareTo(y.realPart()) == 1) return -1;
				else if (x.realPart().compareTo(y.realPart()) == -1) return +1;
				else return 0;
			}
		});
		if (result.contains(MINUSONE)) {
			result.remove(MINUSONE);
			
			result.add(0, I);
			result.add(0, I);
		}
		else if (result.contains(MINUSI)) {
			result.remove(MINUSI);
			result.add(0, I);
			result.add(0, I);
			result.add(0, I);
		}
		return result;
	}
	
	private GaussianInteger findPrimeFactor() {
		BigInteger norm = this.norm();
		BigInteger three = new BigInteger("3");
		BigInteger four = new BigInteger("4");
		if (norm.mod(BigInteger.TWO).compareTo(BigInteger.ZERO) == 0)
			return new GaussianInteger(BigInteger.ONE, BigInteger.ONE);
		
		for (BigInteger i = three, end = norm.sqrt(); i.compareTo(end) == -1 || i.compareTo(end) == 0; i = i.add(BigInteger.TWO)) {  // Find factors of norm
			if (norm.mod(i).compareTo(BigInteger.ZERO) == 0) {
				if (i.mod(four).compareTo(three) == 0)
					return new GaussianInteger(i, BigInteger.ZERO);
				else {
					for (BigInteger re = i.sqrt(); re.compareTo(BigInteger.ZERO) == 1; re = re.subtract(BigInteger.ONE) ) {
						BigInteger im = i.subtract(re.multiply(re)).sqrt();
						if (re.multiply(re).add(im.multiply(im)).compareTo(i) == 0) {
							//if (re > Integer.MAX_VALUE || im > Integer.MAX_VALUE)
								//throw new ArithmeticException("Overflow");
							/*else */if (isDivisibleBy(re, im))
								return new GaussianInteger(re, im);
						}
					}
				}
			}
		}
		
		// This number itself is prime. Rotate so that the argument is in [0, pi/2)
		GaussianInteger temp = this;
		while (temp.realPart().compareTo(BigInteger.ZERO) == -1 || temp.imagPart().compareTo(BigInteger.ZERO) == -1)
			temp = temp.multiply(GaussianInteger.I);//new GaussianInteger(0, 1));
		return temp;
	}
	
	public boolean isDivisibleBy(BigInteger re, BigInteger im) {
		BigInteger minusone = new BigInteger("-1");
		BigInteger divisorNorm = re.multiply(re).add(im.multiply(im));
		return this.realPart().multiply(re).add(this.imagPart().multiply(im)).mod(divisorNorm).compareTo(BigInteger.ZERO) == 0 &&
		       this.realPart().multiply(minusone).multiply(im).add(this.imagPart().multiply(re)).mod(divisorNorm).compareTo(BigInteger.ZERO) == 0;
	}
	
	
	/*private static <T> void printTree(Node<T> node, String appender) {
		  System.out.println(appender + node.getData());
		  node.getChildren().forEach(each ->  printTree(each, appender + appender));
	 }*/
	//public static void main(String[] args) {
		/*Node<GaussianInteger> root = new Node<>(new GaussianInteger("-4","0"));
		int count = 0;
		List<Node<GaussianInteger>> childindex = null;// = new Node<>(new GaussianInteger("1","0"));
		//for (int k = 0; k < 2; k++) {
		for (int i = 0; i < 10; i++) {
			root.addChild(new Node<GaussianInteger>(Minus3Plusi.ginv(root.getData(), new GaussianInteger("5", "0"), new BigInteger(String.valueOf(i)))));
		}
		childindex = root.getChildren();
	//	while (count < 2) {
	for (int k = 0; k < 10; k++) {	
		for (int j = 0; j < 10; j++) {
				for (int i = 0; i < 10; i++) {
					//if (count == 0) {
					//root.addChild(new Node<GaussianInteger>(Minus3Plusi.ginv(root.getData(), new GaussianInteger("5", "0"), new BigInteger(String.valueOf(i)))));
					//childindex = root.getChildren();
				//	}
					//else {
						childindex.get(j).addChild(new Node<GaussianInteger>(Minus3Plusi.ginv(childindex.get(j).getData(), new GaussianInteger("5", "0"), new BigInteger(String.valueOf(i)))));
						//root.getChildren().get(j * i + i).addChild(new Node<GaussianInteger>(Minus3Plusi.ginv(root.getChildren().get(j * i +i).getData(), new GaussianInteger("5", "0"), new BigInteger(String.valueOf(i)))));
					//}
				}
				//if (count != 0) {
				//childindex = childindex.get(j - Math.floorDiv(j, 10)).getChildren();
			//	}
			}
		childindex = root.getChildren().get(k).getChildren();
	}
		//count++;
		//}
		//	count++;
	//}
		//System.out.println(Arrays.toString(root.getChildren().toArray()));
		//for (Node<String> obj : root.getChildren()) {System.out.println(obj.getData());}
		printTree(root, " ");*/
		//Scanner input = new Scanner(System.in);
		
	//	Minus3Plusi jim = new Minus3Plusi();
	//	while(true) {
		//Complex ape = new Complex("3","0");
		//System.out.println(Complex.ONE.divide(ape).toString());
	//	M3Pi abc = new M3Pi("117");//.clearingAlgorithm()
		//List<Integer> boop = abc.clearingAlgorithm("1,6,11");
		//for (Integer i : boop) {
			//System.out.print(String.valueOf(i) + " ");
		//}
		//GaussianInteger v = GaussianInteger.gaussIntFromStr(input.next());//GaussianInteger.gaussIntFromStr(input.next());//new GaussianInteger("1","1");
			//Minus3Plusi foo = new Minus3Plusi();
			//System.out.println(foo.coPrimeM3Pi(z));
		//System.out.println(new GaussianInteger("4", "1").mod(new GaussianInteger("2", "0")));	
		//GaussianInteger w = GaussianInteger.gaussIntFromStr(input.next());//new GaussianInteger("1","1");
		//	System.out.println(Minus3Plusi.divide(v, w));
			//GaussianInteger[] h = /*Minus3Plusi.newDivVal(v, w);///Minus3Plusi.newCalcRemSet(w);
			//for (int j = 0; j < h.length; j++) {*/
				//System.out.println(Minus3Plusi.newDivide(v, w));//h[j].toString());
		//	}
		//System.out.println(v.divide(w));
		//System.out.println(Minus3Plusi.longDiv(v, w));
		//for (GaussianInteger z : Minus3Plusi.repPartLongDiv(Minus3Plusi.longDiv(v, w))) {
			//System.out.println(Minus3Plusi.repPartLongDivGaussVal(Minus3Plusi.repPartLongDiv(Minus3Plusi.longDiv(v, w))).toString());
			//System.out.println(Minus3Plusi.toMinus3Plusi(Minus3Plusi.repPartLongDivGaussVal(Minus3Plusi.repPartLongDiv(Minus3Plusi.longDiv(v, w)))) + "  /  b^" + String.valueOf(Minus3Plusi.repPartSize - Minus3Plusi.indexRep) + " - 1");
		//System.out.println(Minus3Plusi.longDivToM3Pi(v, w));
		//}
		//System.out.println(Minus3Plusi.toMinus3Plusi(v));
		//int[] numbers = Arrays.stream("12563452526891003169313635258314541808833126661426997128051326667517531896001436079061047351523596444958178674441".split("")).mapToInt(Integer::parseInt).toArray();  
	/*	int[] nums = Minus3Plusi.gaussToM3Pi(v);
		for (int i : nums) {
			System.out.print(String.valueOf(i));
		}
		System.out.println("");*/
		//System.out.println(Minus3Plusi.M3PiToGauss(numbers).toString());
		//GaussianInteger[] vals = Minus3Plusi.newCalcRemSet(w);//Minus3Plusi.newNewDivVal(v, w);//v.factorize();
		/*List<GaussianInteger> vals = w.factorize();
		for (GaussianInteger factor : vals) {
			System.out.println(factor.toString());
		}*/
		//GaussianInteger result = vals.stream().reduce(GaussianInteger.ONE, (GaussianInteger a, GaussianInteger b) -> a.multiply(b));
		//System.out.println(result.toString());	
		//System.out.println(z.gcdForM3Pi().toString());
		//}
			/*List<GaussianInteger> factors = z.factorize();
			String ans = "";
			for (GaussianInteger factor : factors) {
				ans = ans + factor.toString() + " | ";
			}
			System.out.println(ans);*/
			//System.out.println(Minus3Plusi.isRemainder(z,w ));
			//GaussianInteger[] abc = Minus3Plusi.newDivVal(w);
			//System.out.println(abc[0].toString() + " / " + abc[1].toString());
			//System.out.println(Minus3Plusi.divide(z, w));//z.coPrime(z1));
			//System.out.println(z.multiply(w).toString());
		//}
		
		//for (Natural k = Natural.ZERO; k.getVal().compareTo(new BigInteger("421")) == -1; k = k.add(Natural.ONE)) {
			//System.out.println(k.NtoZi().norm().toString());
		//}
	/*	List<Integer> value = new ArrayList<Integer>();
		int n = 5;
		int q = 0;
		int val = 0;
		for (int a = 0; a < n; a++) {
			for (int b = 0; b <= a; b++) {
				
				if(q == n) {
					break;
				}
				q++;
				val = a*a + b*b;
				if (!value.contains(val)) {
				value.add(val);//System.out.println(a*a + b*b);
				}
				//if (b == n-1 && )
				//System.out.println(a*a + b*b);
			}
			if (q==n) {
				break;
			}
			//if (n < a*(a-1)) {
				//break;
//			}
		}
		Collections.sort(value);
		System.out.println(value.get(value.size()-1));*/
		//System.out.println(value.get(n-2));
		/*GaussianInteger test = GaussianInteger.gaussIntFromStr(input.next());//new GaussianInteger("-3","1");
		if (test1.gcd(test).equals(test1)) {
			System.out.println(test.gcd(test1));
		}
		else if (test.gcd(test1).equals(test)) {
			System.out.println(test1.gcd(test));
		}
		else {
			if (test1.compareNorm(test) == -1) {
			System.out.println(test.gcd(test1).toString());
			}
			else {
			System.out.println(test1.gcd(test).toString());
			}
		}*/
		//System.out.println(test1.gcd(test).toString());
		//BigInteger exp = new BigInteger("11");
		//GaussianInteger ans = test.pow(exp);
		//System.out.println(ans.toString());
		//Natural three = new Natural(exp);
		//System.out.println(three.toString());
		//System.out.println(three.NtoN2()[0].toString() + " " + three.NtoN2()[1].toString());
		//System.out.println(String.valueOf(three.NtoZ()));
		//System.out.println(three.NtoZi().toString());
		//System.out.println(test1.divide(test).toString());
		//System.out.println(test.norm().toString());
	//}
}
