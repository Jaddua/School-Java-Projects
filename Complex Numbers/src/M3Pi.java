import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class M3Pi {
	
	public List<Integer> repM3Pi;
	public GaussianInteger repGauss;
	//public GaussianInteger[] repGaussRat = new GaussianInteger[2];
	public int size;
	
	public M3Pi(List<Integer> val) {
		this.repM3Pi = val;
		this.size = this.repM3Pi.size();
		this.repGauss = this.toGauss();
		//this.repGaussRat[0] = this.repGauss;
		//this.repGaussRat[1] = GaussianInteger.ONE;
	}
	
	public M3Pi(String val) {
		this.repM3Pi  = Arrays.asList(val.split("")).stream().map(Integer::parseInt).collect(Collectors.toList());
		this.size = this.repM3Pi.size();
		this.repGauss = this.toGauss();
	}
	
	public M3Pi(GaussianInteger val) {
		BigInteger s = val.realPart();
		BigInteger t = val.imagPart();
		BigInteger three = new BigInteger("3");
		this.repM3Pi = clearingAlgorithm("0," + String.valueOf(t) + "," + String.valueOf(s.add(three.multiply(t))));
		this.size = this.repM3Pi.size();
		this.repGauss = val;
		//this.repGaussRat[0] = this.repGauss;
		//this.repGaussRat[1] = GaussianInteger.ONE;
	}
	
	public GaussianInteger toGauss() {
		BigInteger pow = new BigInteger(String.valueOf(this.size - 1));
		GaussianInteger ans = GaussianInteger.ZERO;
		for (int i : this.repM3Pi) {
			ans = ans.add(new GaussianInteger(String.valueOf(i), "0").multiply(GaussianInteger.M3Pi.pow(pow)));
			pow = pow.subtract(BigInteger.ONE);
		}
		return ans;
	}
	
	public String multiply(M3Pi multiplier) {
		M3Pi multiplicand = this;
		List<Integer> ans = new M3Pi(multiplicand.repGauss.multiply(multiplier.repGauss)).repM3Pi;
		return ans.stream().map(String::valueOf).collect(Collectors.joining(""));
	}
	
	public String divide(M3Pi divisor) {
		M3Pi dividend = this;
		GaussianInteger dividendGauss = dividend.toGauss();
		GaussianInteger divisorGauss = divisor.toGauss();
		List<GaussianInteger> longDivVals = longDiv(dividendGauss, divisorGauss);
		int indexRep = longDivVals.get(longDivVals.size()-1).realPart().intValueExact();
		longDivVals.remove(longDivVals.size()-1);
		List<GaussianInteger> repPartLongDivVals = repPartLongDiv(indexRep, longDivVals);
		List<GaussianInteger> firstPartLongDivVals = longDivVals.subList(0, indexRep);
		//firstPartLongDivVals.removeAll(repPartLongDivVals);
		
		GaussianInteger tempFirstPartGauss = GaussianInteger.ZERO;
		BigInteger pow = new BigInteger(String.valueOf(firstPartLongDivVals.size()-1));
		for (GaussianInteger z : firstPartLongDivVals) {
			tempFirstPartGauss = tempFirstPartGauss.add(z.multiply(GaussianInteger.M3Pi.pow(pow)));
			pow = pow.subtract(BigInteger.ONE);
		}
		M3Pi firstPart = new M3Pi(tempFirstPartGauss);
		
		GaussianInteger tempRepPartGauss = GaussianInteger.ZERO;
		pow = new BigInteger(String.valueOf(repPartLongDivVals.size()-1));
		for (GaussianInteger z : repPartLongDivVals) {
			tempRepPartGauss = tempRepPartGauss.add(z.multiply(GaussianInteger.M3Pi.pow(pow)));
			pow = pow.subtract(BigInteger.ONE);
		}
		
		M3Pi repPart = new M3Pi(tempRepPartGauss);
		int n = repPartLongDivVals.size();
		int s = repPart.size / n;
		int S = s;
		repPart = new M3Pi(repPart.repGauss.multiply(new Complex(GaussianInteger.ONE.subtract(GaussianInteger.M3Pi.pow(new BigInteger(String.valueOf(n*(1 << s)))))).divide(new Complex(GaussianInteger.ONE.subtract(GaussianInteger.M3Pi.pow(new BigInteger(String.valueOf(n)))))).toGaussInt()));
		if (s != 0) {
			repPart = new M3Pi(repPart.repM3Pi.subList(0, repPart.size - n));
		}
		else {
			S = 1;
		}
		firstPart = new M3Pi(firstPart.repGauss.multiply(GaussianInteger.M3Pi.pow(new BigInteger(String.valueOf(n*((1 << s) - 1))))));
		String answer = "";
		M3Pi ans = new M3Pi(firstPart.repGauss.add(repPart.repGauss));
		answer = ans.repM3Pi.stream().map(String::valueOf).collect(Collectors.joining(""));// + " * b^-" + String.valueOf(longDivVals.size() - 1 + n*((1 << S) - 2) + "   " + String.valueOf(n*S));
		int ansLength = answer.length();
		if (ansLength < n*S) {
			for (int i = 0; i < n*S - ansLength; i++) {
				answer = "0" + answer;
			}
		}
		answer = answer.substring(0, answer.length() - n*S) + "(" + answer.substring(answer.length() - n*S) + ")...";
		int point = longDivVals.size() - 1 + n*((1 << S) - 2);
		ansLength = answer.length() - 5;
		if (ansLength <= point) {
			for (int i = 0; i < point - ansLength; i++) {
				answer = "0" + answer;
			}
			answer = "0." + answer;
		}
		else {
			answer = answer.substring(0, ansLength - point) + "." + answer.substring(ansLength - point);
		}
		if (answer.contains("(0)...")) {
			answer = answer.substring(0, answer.length() - 6);
		}
		if (answer.indexOf(".") == answer.length() - 1) {
			answer = answer.substring(0, answer.length() - 1);
		}
		return answer;
	}
	
	private List<GaussianInteger> longDiv(GaussianInteger v, GaussianInteger w) {
		List<GaussianInteger> ansVals = new ArrayList<GaussianInteger>();
		List<GaussianInteger> remVals = new ArrayList<GaussianInteger>();
		int count = 0;
		int indexRep = 0;
		while (true) {
			if (count == 0) {
				ansVals.add(v.divide(w));
				remVals.add(v.mod(w));
				count++;
			}
			else {
				ansVals.add(remVals.get(count-1).multiply(GaussianInteger.M3Pi).divide(w));
				if (remVals.contains(remVals.get(count-1).multiply(GaussianInteger.M3Pi).mod(w))) {
					indexRep = remVals.indexOf(remVals.get(count-1).multiply(GaussianInteger.M3Pi).mod(w)) + 1;
					break;
				}
				else {
					remVals.add(remVals.get(count-1).multiply(GaussianInteger.M3Pi).mod(w));
					count++;
				}
			}
		}
		//Add indexRep to the end so it can be recovered outside of the method. Will be removed once recovered in another method.
		ansVals.add(new GaussianInteger(String.valueOf(indexRep), "0"));
		return ansVals;
	}
	
	private List<GaussianInteger> repPartLongDiv(int indexRep, List<GaussianInteger> div) {
		
		return div.subList(indexRep, div.size());
	}
	
	
	private List<Integer> clearingAlgorithm(String num) {
		int[] minPoly = {1,6,10};
		List<BigInteger> vals = new ArrayList<BigInteger>();
		String str[] = num.split(",");
		List<String> strvals = new ArrayList<String>();
		strvals = Arrays.asList(str);
		BigInteger ten = new BigInteger("10");
		BigInteger nine = new BigInteger("9");
		BigInteger minusone = new BigInteger("-1");
		BigInteger zero = new BigInteger("0");
		for (String mybigint : strvals) 
        { 
          vals.add(new BigInteger(mybigint)); 
        }
		Collections.reverse(vals);
		BigInteger b =  vals.get(0).divide(ten).multiply(minusone);
		BigInteger[] poly = {b.multiply(new BigInteger(String.valueOf(minPoly[0]))),b.multiply(new BigInteger(String.valueOf(minPoly[1]))),b.multiply(new BigInteger(String.valueOf(minPoly[2])))};
		int i = 0;
		int z = vals.size();
		int k = 0;
		while (i < z) {
			z = vals.size() + k;
			if (vals.get(i).compareTo(zero) == -1  || vals.get(i).compareTo(nine) == 1 ) {
				if (vals.get(i).compareTo(zero) == -1) {
					if (vals.get(i).mod(ten).compareTo(zero) == 0) {
						b =   vals.get(i).divide(ten).multiply(minusone);
					}
					else {
						
					
					b =   vals.get(i).divide(ten).add(minusone).multiply(minusone);
					}
				}
				else {
					b =   vals.get(i).divide(ten).multiply(minusone);	
				}
				poly[0] = b.multiply(new BigInteger(String.valueOf(minPoly[0])));
				poly[1] = b.multiply(new BigInteger(String.valueOf(minPoly[1])));
				poly[2] = b.multiply(new BigInteger(String.valueOf(minPoly[2])));
				
				
				if (i < z - 2) {
				vals.set(i, vals.get(i).add(poly[2]));
				vals.set(i+1, vals.get(i+1).add(poly[1]));
				vals.set(i+2, vals.get(i+2).add(poly[0]));
				}
				else {
					vals.set(i, vals.get(i).add(poly[2]));
					vals.set(i+1, vals.get(i+1).add(poly[1]));
					vals.add(poly[0]);
				}
				i += 1;
				vals.add(zero);
			}
			else {	
			i += 1;
			}
		}
		Collections.reverse(vals);
		List<String> strVals = vals.stream().map(String::valueOf).collect(Collectors.toList());
		List<Integer> answer = strVals.stream().map(Integer::parseInt).collect(Collectors.toList());
		while (true) {
			if (answer.indexOf(0) == 0) {
				answer.remove(0);
			}
			else {
				break;	
			}
		}
		if (answer.size() == 0) {
			answer.add(0);
		}
		return answer;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("\u2202");
		//GaussianInteger v = GaussianInteger.gaussIntFromStr(input.next());
		//GaussianInteger w = GaussianInteger.gaussIntFromStr(input.next());
	//	System.out.println(new M3Pi(v).divide(new M3Pi(w)));
		//ComplexRational abc = new ComplexRational(v,w);
		//System.out.println(abc.realPart().toString());
		//System.out.println(abc.imagPart().toString());
		//System.out.println(v.mod(w).toString());
	}
	
	
}
