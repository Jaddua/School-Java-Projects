import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Minus3Plusi {
	private static Natural k = Natural.ZERO;
	private static Natural KVAL = Natural.ZERO;
	private static final GaussianInteger ZERO = GaussianInteger.ZERO;
	private static final GaussianInteger ONE = GaussianInteger.ONE;
	private static final GaussianInteger TWO = new GaussianInteger("2", "0");
	private static final GaussianInteger THREE = new GaussianInteger("3", "0");
	private static final GaussianInteger FOUR = new GaussianInteger("4", "0");
	private static final GaussianInteger FIVE = new GaussianInteger("5", "0");
	private static final GaussianInteger SIX = new GaussianInteger("6", "0");
	private static final GaussianInteger SEVEN = new GaussianInteger("7", "0");
	private static final GaussianInteger EIGHT = new GaussianInteger("8", "0");
	private static final GaussianInteger NINE = new GaussianInteger("9", "0");
	private static final GaussianInteger[] DIGITS = {ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE};
	private static final List<GaussianInteger> M3PIFACTORS = Arrays.asList(GaussianInteger.I, new GaussianInteger("1", "1"), new GaussianInteger("2", "1"));
	public static int indexRep = 0;
	public static int repPartSize = 0;
	public static BigInteger[] clearingAlgorithm(String num/*,int radixval*/) {
		int[] minPoly = {1,6,10};
		List<BigInteger> vals = new ArrayList<BigInteger>();
		String str[] = num.split(",");
		List<String> strvals = new ArrayList<String>();
		strvals = Arrays.asList(str);
		BigInteger ten = new BigInteger("10");
		BigInteger nine = new BigInteger("9");
		BigInteger minusone = new BigInteger("-1");
		BigInteger zero = new BigInteger("0");
		BigInteger one = new BigInteger("1");
		for (String mybigint : strvals) 
        { 
          vals.add(new BigInteger(mybigint)); 
        }
		Collections.reverse(vals);
	//	double b =   Math.floor((s+3*t) / 10.0) * -1; //* Math.signum((s + 3 * t));
		BigInteger b =  vals.get(0).divide(ten).multiply(minusone);
		//String k = String.valueOf(c);
		BigInteger[] poly = {b.multiply(new BigInteger(String.valueOf(minPoly[0]))),b.multiply(new BigInteger(String.valueOf(minPoly[1]))),b.multiply(new BigInteger(String.valueOf(minPoly[2])))};
		//String answer = "";
		//vals.add((s+3*t) + poly[2]);
		//vals.add(t + poly[1]);
		//vals.add(poly[0]);
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
				//if (i == 1){
				//vals.add(poly[0]);
				//}
				
				if (i < z - 2) {
				vals.set(i, vals.get(i).add(poly[2]));
				vals.set(i+1, vals.get(i+1).add(poly[1]));
				vals.set(i+2, vals.get(i+2).add(poly[0]));
				}//i = answerVal.size();
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
			
			//k += 1;
			}
			/*if (z == 100) {
				i = z;
			}*/
		}
		Collections.reverse(vals);
		//if (vals.get(0).compareTo(zero) == 0) {
			//vals.remove(0);
		//}
		/*
		for (int x = 0; x < vals.size(); x++) {
			if (x == 0 && x >= (vals.size() - radixval) && vals.size() <= radixval) {
				answer = answer + "0,.";
				for (i = 0; i < Math.abs(vals.size() - radixval);i++) {
					answer = answer + "," + "0";
				}
				answer =answer + "," + String.valueOf(vals.get(x));
			}
			else if (x == (vals.size() - radixval) && vals.size() > radixval) {
				answer = answer + "," + ".," + String.valueOf(vals.get(x));
			}
			else {
				if (x == 0) {
					answer = String.valueOf(vals.get(x));
				}
				else {
				answer = answer + "," + String.valueOf(vals.get(x));
			}
			}
			
		}
		String[] valsStrArr = answer.split(",");
		List<String> valsStrList = new LinkedList<String>(Arrays.asList(valsStrArr));
		//List<String> valsStrList = new ArrayList<String>();
	//	valsStrList = Arrays.asList(valsStrArr);
		List<Integer> posVals = new ArrayList<Integer>();
		for (int h = 1; h < 10; h++) {
			posVals.add(valsStrList.indexOf(String.valueOf(h)));
		}
		if (posVals.contains(-1)) {
			posVals.removeAll(Collections.singletonList(-1));
		}
		int valsMin = Collections.min(posVals);
		if (!valsStrList.contains(".")) {
			for (int h = 0; h < valsMin; h++) {
				valsStrList.remove(0);
			//	valsMin -= 1;
			}
		}
		else {
			if (valsStrList.indexOf(".") < valsMin) {
				int posRad = valsStrList.indexOf(".");
				for (int h = 0; h < (posRad - 1); h++) {
					valsStrList.remove(0);
				}
			}
			else {
				for (int h = 0; h < valsMin; h++) {
					valsStrList.remove(0);
				
				}
			}
		}
		answer = String.join("", valsStrList);
		//String repeated = answer.replaceAll("(.+?)\\1+", "$1");
		return answer;//String.valueOf(Collections.min(posVals));*/
		BigInteger[] answer = new BigInteger[vals.size()];
        answer = vals.toArray(answer);
		return answer;
	}
	
	
	public static GaussianInteger[] potRemSet(GaussianInteger v , GaussianInteger w) {
		GaussianInteger[] potRemSet = new GaussianInteger[10];
		for (int a = 0; a < 10; a++) {
			potRemSet[a] = v.subtract(w.multiply(new GaussianInteger(String.valueOf(a),"0")));
		}
		return potRemSet;
	}
	
	public static GaussianInteger g(GaussianInteger z , GaussianInteger w) {
		GaussianInteger ans = GaussianInteger.ZERO;
		//Complex intg = new Complex("0","0");
		Complex g = new Complex("0","0");;
		for (int a = 0; a <10; a++) {
			g = Complex.valueOf(z.add(w.multiply(new GaussianInteger(String.valueOf(a), "0")))).divide(Complex.valueOf(GaussianInteger.M3Pi));
			//g = new Complex(g.getReal(),g.getImaginary());
			//intg = new Complex(Math.round(g.getReal()),Math.round(g.getImaginary()));
			if (g.isGaussInt()) {
				ans = g.toGaussInt();
			}
		}
		return ans;
	}
	public static List<List<GaussianInteger>> remOrNotSet(GaussianInteger z, GaussianInteger w) {
		int count = 0;
		int index = 0;
		GaussianInteger g = new GaussianInteger("0", "0");
		List<GaussianInteger> protoRemSet = new ArrayList<GaussianInteger>();
		protoRemSet.add(z);
		boolean flag = true;
		while (flag) {
			g = Minus3Plusi.g(protoRemSet.get(count), w);
			if (protoRemSet.contains(g)) {
				index = protoRemSet.indexOf(g);
				flag = false;
			}
			else {
				protoRemSet.add(g);
				count += 1;
			}
		}
		List<GaussianInteger> remSet = protoRemSet.subList(index, protoRemSet.size());// new ArrayList<GaussianInteger>();//GaussianInteger[protoRemSet.size() - index];
		List<GaussianInteger> notRemSet = protoRemSet.subList(0, index);
		/*for (int i = 0; i < protoRemSet.size() - index; i++ ) {
			remSet.add(protoRemSet.get(i + index));
		}*/
		List<List<GaussianInteger>> answer = Arrays.asList(remSet, notRemSet);//new List<GaussianInteger>[2];
		return answer;
	}
	public static List<GaussianInteger> calcRemSet(GaussianInteger z, GaussianInteger w) {
		int count = 0;
		int index = 0;
		GaussianInteger g = new GaussianInteger("0", "0");
		List<GaussianInteger> protoRemSet = new ArrayList<GaussianInteger>();
		protoRemSet.add(z);
		boolean flag = true;
		while (flag) {
			g = Minus3Plusi.g(protoRemSet.get(count), w);
			if (protoRemSet.contains(g)) {
				index = protoRemSet.indexOf(g);
				flag = false;
			}
			else {
				protoRemSet.add(g);
				count += 1;
			}
		}
		List<GaussianInteger> remSet = protoRemSet.subList(index, protoRemSet.size());// new ArrayList<GaussianInteger>();//GaussianInteger[protoRemSet.size() - index];
		/*for (int i = 0; i < protoRemSet.size() - index; i++ ) {
			remSet.add(protoRemSet.get(i + index));
		}*/
		return remSet;
	}
	
	public static boolean isRemainder(GaussianInteger z, GaussianInteger w ) {
		if (calcRemSet(z, w).contains(z)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static GaussianInteger ginv(GaussianInteger z, GaussianInteger w, BigInteger a) {
		GaussianInteger A = new GaussianInteger(a, BigInteger.ZERO);
		return GaussianInteger.M3Pi.multiply(z).subtract(A.multiply(w));
	}
	
	/*public static GaussianInteger newCalcRemSet(GaussianInteger z, GaussianInteger w) {
		BigInteger ten = new BigInteger("10");
		List<GaussianInteger> zero = new ArrayList<GaussianInteger>();
		List<GaussianInteger> one = new ArrayList<GaussianInteger>();
		List<GaussianInteger> two = new ArrayList<GaussianInteger>();
		List<GaussianInteger> three = new ArrayList<GaussianInteger>();
		List<GaussianInteger> four = new ArrayList<GaussianInteger>();
		List<GaussianInteger> five = new ArrayList<GaussianInteger>();
		List<GaussianInteger> six = new ArrayList<GaussianInteger>();
		List<GaussianInteger> seven = new ArrayList<GaussianInteger>();
		List<GaussianInteger> eight = new ArrayList<GaussianInteger>();
		List<GaussianInteger> nine = new ArrayList<GaussianInteger>();
		zero.add(z);
		one.add(z);
		two.add(z);
		three.add(z);
		four.add(z);
		five.add(z);
		six.add(z);
		seven.add(z);
		eight.add(z);
		nine.add(z);
		int count = 0;
		while(true) {
			for(int j = 0; j <= count; j++) {
				for (int i = 0; i < 10; i = i++) {
					switch (i) {
						case 0:
							zero.add(ginv(zero.get(count), w, new BigInteger(String.valueOf(i))));
							break;
						case 1:
							one.add(ginv(one.get(count), w, new BigInteger(String.valueOf(i))));
							break;
						case 2:
							two.add(ginv(two.get(count), w, new BigInteger(String.valueOf(i))));
							break;
						case 3:
							three.add(ginv(three.get(count), w, new BigInteger(String.valueOf(i))));
							break;
						case 4:
							four.add(ginv(four.get(count), w, new BigInteger(String.valueOf(i))));
							break;
						case 5:
							five.add(ginv(five.get(count), w, new BigInteger(String.valueOf(i))));
							break;
						case 6:
							six.add(ginv(six.get(count), w, new BigInteger(String.valueOf(i))));
							break;
						case 7:
							seven.add(ginv(seven.get(count), w, new BigInteger(String.valueOf(i))));
							break;
						case 8:
							eight.add(ginv(eight.get(count), w, new BigInteger(String.valueOf(i))));
							break;
						case 9:
							nine.add(ginv(nine.get(count), w, new BigInteger(String.valueOf(i))));
							break;
					}
				}	
				count++;
			}
		}
	}*/
	private static int calculatePowersOf10(BigDecimal value)
	{
	    return (value.round(new MathContext(1)).scale() - 1) * -1;
	}
	
	public static GaussianInteger[] newCalcRemSet(GaussianInteger w) {
		//List<BigInteger> normVals = new ArrayList<BigInteger>(1000);
		//Stream<BigInteger> normValsStream = Stream.of();
		//Stream<GaussianInteger> potRemValsStream = Stream.of();
		//Stream<GaussianInteger> remValsStream = Stream.of();
		List<BigInteger> normVals = new ArrayList<BigInteger>();//normValsStream.collect(Collectors.toList());
		List<GaussianInteger> potRemVals = new ArrayList<GaussianInteger>();//potRemValsStream.distinct().collect(Collectors.toList());
		List<GaussianInteger> remVals = new ArrayList<GaussianInteger>();//potRemValsStream.distinct().collect(Collectors.toList());
		BigDecimal divVal = new BigDecimal("11").subtract(new BigDecimal("2").multiply(new BigDecimal("10").sqrt(new MathContext(50))));
		//System.out.println(String.valueOf(divVal));
		BigDecimal normW = new BigDecimal(w.norm());
		BigDecimal maxValDec = (new BigDecimal("81").multiply(normW)).divide(/*new BigDecimal("11").subtract(new BigDecimal("2").multiply(new BigDecimal("10").sqrt(new MathContext(50,RoundingMode.HALF_EVEN))))*/divVal,new MathContext(50));//.toBigInteger();
		BigInteger maxVal = maxValDec.round(new MathContext(calculatePowersOf10(maxValDec),RoundingMode.CEILING)).toBigInteger();
		//System.out.println(String.valueOf(maxVal));
		BigDecimal n1Dec = new BigDecimal(maxVal).sqrt(new MathContext(50));
		BigInteger n1 = n1Dec.round(new MathContext(calculatePowersOf10(n1Dec),RoundingMode.FLOOR)).toBigInteger();
		//System.out.println(String.valueOf(n1));
		BigDecimal n2Dec = new BigDecimal(maxVal.subtract(n1.multiply(n1))).sqrt(new MathContext(50));
		BigInteger n2 = n2Dec.round(new MathContext(calculatePowersOf10(n2Dec),RoundingMode.FLOOR)).toBigInteger();
		//System.out.println(String.valueOf(n2));
		//int c = 0;
		boolean check = false;
		
		for (BigInteger a = BigInteger.ZERO; a.compareTo(n1) == -1 || a.compareTo(n1) == 0; a = a.add(BigInteger.ONE)) {
			for (BigInteger b = BigInteger.ZERO; b.compareTo(a) == -1 || b.compareTo(a) == 0; b = b.add(BigInteger.ONE)) {
				normVals.add(a.multiply(a).add(b.multiply(b)));//normValsStream = Stream.concat(normValsStream,Stream.of(a.multiply(a).add(b.multiply(b))));
				//System.out.println(String.valueOf(a.multiply(a).add(b.multiply(b))));
				//c++;
				//System.out.println(c);
				if (a.compareTo(n1) == 0 && b.compareTo(n2) == 0) {
					check = true;
					break;
				}
			}
			if (check) {
				break;
			}
			
		}
		//List<BigInteger> normVals = normValsStream.collect(Collectors.toList());
		for (BigInteger n : normVals) {
			for (BigInteger a = BigInteger.ZERO; a.compareTo(new BigDecimal(n).sqrt(new MathContext(50)).toBigInteger().add(BigInteger.ONE)) == -1; a = a.add(BigInteger.ONE)) {
				BigDecimal b = new BigDecimal(n.subtract(a.multiply(a))).sqrt(new MathContext(50));
				try {
					BigInteger B = b.toBigIntegerExact();
					if (n.compareTo(BigInteger.ZERO) == 0) {
						potRemVals.add(GaussianInteger.ZERO);
						//potRemValsStream = Stream.concat(potRemValsStream,Stream.of(GaussianInteger.ZERO));
					}
					else if (n.compareTo(BigInteger.ONE) == 0) {
						/*potRemValsStream = Stream.concat(potRemValsStream,Stream.of(GaussianInteger.ONE));
						potRemValsStream = Stream.concat(potRemValsStream,Stream.of(GaussianInteger.MINUSONE));
						potRemValsStream = Stream.concat(potRemValsStream,Stream.of(GaussianInteger.I));
						potRemValsStream = Stream.concat(potRemValsStream,Stream.of(GaussianInteger.MINUSI));*/
						potRemVals.add(GaussianInteger.ONE);
						potRemVals.add(GaussianInteger.MINUSONE);
						potRemVals.add(GaussianInteger.I);
						potRemVals.add(GaussianInteger.MINUSI);
					}
					else {
						if(a.compareTo(BigInteger.ZERO) == 0) {
							//potRemValsStream = Stream.concat(potRemValsStream,Stream.of(new GaussianInteger(BigInteger.ZERO, B)));
							//potRemValsStream = Stream.concat(potRemValsStream,Stream.of(new GaussianInteger(BigInteger.ZERO, new BigInteger("-1").multiply(B))));
							potRemVals.add(new GaussianInteger(BigInteger.ZERO, B));
							potRemVals.add(new GaussianInteger(BigInteger.ZERO, new BigInteger("-1").multiply(B)));
							
						}
						else if(B.compareTo(BigInteger.ZERO) == 0) {
							//potRemValsStream = Stream.concat(potRemValsStream,Stream.of(new GaussianInteger(a, BigInteger.ZERO)));
							//potRemValsStream = Stream.concat(potRemValsStream,Stream.of(new GaussianInteger(new BigInteger("-1").multiply(a), BigInteger.ZERO)));
							potRemVals.add(new GaussianInteger(a, BigInteger.ZERO));
							potRemVals.add(new GaussianInteger(new BigInteger("-1").multiply(a), BigInteger.ZERO));
							
						}
						else {
							/*potRemValsStream = Stream.concat(potRemValsStream,Stream.of(new GaussianInteger(a, B)));
							potRemValsStream = Stream.concat(potRemValsStream,Stream.of(new GaussianInteger(new BigInteger("-1").multiply(a), B)));
							potRemValsStream = Stream.concat(potRemValsStream,Stream.of(new GaussianInteger(a, new BigInteger("-1").multiply(B))));
							potRemValsStream = Stream.concat(potRemValsStream,Stream.of(new GaussianInteger(new BigInteger("-1").multiply(a), new BigInteger("-1").multiply(B))));*/
							potRemVals.add(new GaussianInteger(a, B));
							potRemVals.add(new GaussianInteger(new BigInteger("-1").multiply(a), B));
							potRemVals.add(new GaussianInteger(a, new BigInteger("-1").multiply(B)));
							potRemVals.add(new GaussianInteger(new BigInteger("-1").multiply(a), new BigInteger("-1").multiply(B)));
						}
					}
				}
					catch(ArithmeticException e) {
						
					}
					
				}
			}
		
		//List<GaussianInteger> potRemVals = potRemValsStream.distinct().collect(Collectors.toList());
		// List<GaussianInteger> result = new ArrayList<>(
			 //     new LinkedHashSet<>(remVals));
		//List<GaussianInteger> remVals = new ArrayList<GaussianInteger>();
		potRemVals = potRemVals.stream().distinct().collect(Collectors.toList());
		for (GaussianInteger n : potRemVals) {
			//remValsStream.distinct().collect(Collectors.toList());
			if (remVals.contains(n)) {//remValsStream.collect(Collectors.toList()).contains(n)) {//.anyMatch(GI -> GI.equals(n))) {
			}
			else {
				//remValsStream = Stream.concat(remValsStream, Stream.of(calcRemSet(n, w))).distinct();
				remVals.addAll(calcRemSet(n, w));
				remVals = remVals.stream().distinct().collect(Collectors.toList());
			}
		}
	//	List<GaussianInteger> result = new ArrayList<>(
				   //   new LinkedHashSet<>(remVals));
		//List<GaussianInteger> remVals = remValsStream.distinct().collect(Collectors.toList());
		return remVals.toArray(new GaussianInteger[remVals.size()]);
		
	}
	
	public static GaussianInteger[] newNewDivVal(GaussianInteger v, GaussianInteger w) {
		//GaussianInteger[] result = new GaussianInteger[2];
		List <GaussianInteger> wFactors = w.factorize();
		/*List<GaussianInteger> tempw1Factors = wFactors.stream()
				  .distinct()
				  .filter(M3PIFACTORS::contains)
				  .collect(Collectors.toList());*/
		List<GaussianInteger> w1Factors = new ArrayList<>(wFactors);
		w1Factors.removeAll(M3PIFACTORS);
		GaussianInteger w1 = w1Factors.stream().reduce(GaussianInteger.ONE, (GaussianInteger a, GaussianInteger b) -> a.multiply(b));
		//List<GaussianInteger> tempuFactors = new ArrayList<>(wFactors);
		//tempuFactors.removeAll(tempw1Factors);
		//int occurrences = Collections.frequency(animals, "bat");
		List<Integer> uFactorFreq = Arrays.asList(Collections.frequency(wFactors, GaussianInteger.I), Collections.frequency(wFactors, M3PIFACTORS.get(1)), Collections.frequency(wFactors, M3PIFACTORS.get(2)));
		int uiFreq = uFactorFreq.get(0);
		int u1plusiFreq = uFactorFreq.get(1);
		int u2plusiFreq = uFactorFreq.get(2);
		int k = Collections.max(uFactorFreq);
		System.out.println(k);
		GaussianInteger u = GaussianInteger.ONE;
		for (int i = 0; i < k - uiFreq; i++) {
			u = u.multiply(GaussianInteger.I);
		}
		for (int i = 0; i < k - u1plusiFreq; i++) {
			u = u.multiply(M3PIFACTORS.get(1));
		}
		for (int i = 0; i < k - u2plusiFreq; i++) {
			u = u.multiply(M3PIFACTORS.get(2));
		}
		//List<GaussianInteger> answer = Arrays.asList(u,w1);
		//return answer;
		return new GaussianInteger[] {u.multiply(v),w1};
	}
	
	public static GaussianInteger[] newNewCalcRemSet(GaussianInteger w) {
		//List<BigInteger> normVals = new ArrayList<BigInteger>();//normValsStream.collect(Collectors.toList());
	//	List<GaussianInteger> potRemVals = new ArrayList<GaussianInteger>();//potRemValsStream.distinct().collect(Collectors.toList());
		List<GaussianInteger> remVals = new ArrayList<GaussianInteger>();//potRemValsStream.distinct().collect(Collectors.toList());
		List<GaussianInteger> notRemVals = new ArrayList<GaussianInteger>();
		BigDecimal divVal = new BigDecimal("11").subtract(new BigDecimal("2").multiply(new BigDecimal("10").sqrt(new MathContext(50))));
		//System.out.println(String.valueOf(divVal));
		BigDecimal normW = new BigDecimal(w.norm());
		BigDecimal maxValDec = (new BigDecimal("81").multiply(normW)).divide(divVal,new MathContext(50));
		BigInteger maxVal = maxValDec.round(new MathContext(calculatePowersOf10(maxValDec),RoundingMode.CEILING)).toBigInteger();
		//System.out.println(String.valueOf(maxVal));
		BigDecimal n1Dec = new BigDecimal(maxVal).sqrt(new MathContext(50));
		BigInteger n1 = n1Dec.round(new MathContext(calculatePowersOf10(n1Dec),RoundingMode.FLOOR)).toBigInteger();
		//System.out.println(String.valueOf(n1));
		BigDecimal n2Dec = new BigDecimal(maxVal.subtract(n1.multiply(n1))).sqrt(new MathContext(50));
		BigInteger n2 = n2Dec.round(new MathContext(calculatePowersOf10(n2Dec),RoundingMode.FLOOR)).toBigInteger();
		//System.out.println(String.valueOf(n2));
		//int c = 0;
		BigInteger normVal = BigInteger.ZERO;
		boolean check = false;
		
		for (BigInteger a = BigInteger.ZERO; a.compareTo(n1) == -1 || a.compareTo(n1) == 0; a = a.add(BigInteger.ONE)) {
			for (BigInteger b = BigInteger.ZERO; b.compareTo(a) == -1 || b.compareTo(a) == 0; b = b.add(BigInteger.ONE)) {
				normVal = a.multiply(a).add(b.multiply(b));
				for (BigInteger c = BigInteger.ZERO; c.compareTo(new BigDecimal(normVal).sqrt(new MathContext(50)).toBigInteger().add(BigInteger.ONE)) == -1; c = c.add(BigInteger.ONE)) {
					BigDecimal d = new BigDecimal(normVal.subtract(c.multiply(c))).sqrt(new MathContext(50));
					try {
						BigInteger B = d.toBigIntegerExact();
						if (normVal.compareTo(BigInteger.ZERO) == 0) {
							List<List<GaussianInteger>> remOrNot = remOrNotSet(GaussianInteger.ZERO, w);
							remVals.addAll(remOrNot.get(0));
							notRemVals.addAll(remOrNot.get(1));
							//potRemValsStream = Stream.concat(potRemValsStream,Stream.of(GaussianInteger.ZERO));
						}
						else if (normVal.compareTo(BigInteger.ONE) == 0) {
							/*potRemValsStream = Stream.concat(potRemValsStream,Stream.of(GaussianInteger.ONE));
							potRemValsStream = Stream.concat(potRemValsStream,Stream.of(GaussianInteger.MINUSONE));
							potRemValsStream = Stream.concat(potRemValsStream,Stream.of(GaussianInteger.I));
							potRemValsStream = Stream.concat(potRemValsStream,Stream.of(GaussianInteger.MINUSI));*/
							if (!(remVals.contains(GaussianInteger.ONE) || notRemVals.contains(GaussianInteger.ONE))) {
								List<List<GaussianInteger>> remOrNot = remOrNotSet(GaussianInteger.ONE, w);
								remVals.addAll(remOrNot.get(0));
								remVals = remVals.stream().distinct().collect(Collectors.toList());
								notRemVals.addAll(remOrNot.get(1));
								notRemVals = notRemVals.stream().distinct().collect(Collectors.toList());
							}
							if (!(remVals.contains(GaussianInteger.MINUSONE) || notRemVals.contains(GaussianInteger.MINUSONE))) {
								List<List<GaussianInteger>> remOrNot = remOrNotSet(GaussianInteger.MINUSONE, w);
								remVals.addAll(remOrNot.get(0));
								remVals = remVals.stream().distinct().collect(Collectors.toList());
								notRemVals.addAll(remOrNot.get(1));
								notRemVals = notRemVals.stream().distinct().collect(Collectors.toList());
							}
							if (!(remVals.contains(GaussianInteger.I) || notRemVals.contains(GaussianInteger.I))) {
								List<List<GaussianInteger>> remOrNot = remOrNotSet(GaussianInteger.I, w);
								remVals.addAll(remOrNot.get(0));
								remVals = remVals.stream().distinct().collect(Collectors.toList());
								notRemVals.addAll(remOrNot.get(1));
								notRemVals = notRemVals.stream().distinct().collect(Collectors.toList());
							}
							if (!(remVals.contains(GaussianInteger.MINUSI) || notRemVals.contains(GaussianInteger.MINUSI))) {
								List<List<GaussianInteger>> remOrNot = remOrNotSet(GaussianInteger.MINUSI, w);
								remVals.addAll(remOrNot.get(0));
								remVals = remVals.stream().distinct().collect(Collectors.toList());
								notRemVals.addAll(remOrNot.get(1));
								notRemVals = notRemVals.stream().distinct().collect(Collectors.toList());
							}
							/*potRemVals.add(GaussianInteger.ONE);
							potRemVals.add(GaussianInteger.MINUSONE);
							potRemVals.add(GaussianInteger.I);
							potRemVals.add(GaussianInteger.MINUSI);*/
						}
						else {
							if(c.compareTo(BigInteger.ZERO) == 0) {
								//potRemValsStream = Stream.concat(potRemValsStream,Stream.of(new GaussianInteger(BigInteger.ZERO, B)));
								//potRemValsStream = Stream.concat(potRemValsStream,Stream.of(new GaussianInteger(BigInteger.ZERO, new BigInteger("-1").multiply(B))));
								GaussianInteger val1 = new GaussianInteger(BigInteger.ZERO, B);
								GaussianInteger val2 = new GaussianInteger(BigInteger.ZERO, new BigInteger("-1").multiply(B));
								if (!(remVals.contains(val1) || notRemVals.contains(val1))) {
									List<List<GaussianInteger>> remOrNot = remOrNotSet(val1, w);
									remVals.addAll(remOrNot.get(0));
									remVals = remVals.stream().distinct().collect(Collectors.toList());
									notRemVals.addAll(remOrNot.get(1));
									notRemVals = notRemVals.stream().distinct().collect(Collectors.toList());
								}
								if (!(remVals.contains(val2) || notRemVals.contains(val2))) {
									List<List<GaussianInteger>> remOrNot = remOrNotSet(val2, w);
									remVals.addAll(remOrNot.get(0));
									remVals = remVals.stream().distinct().collect(Collectors.toList());
									notRemVals.addAll(remOrNot.get(1));
									notRemVals = notRemVals.stream().distinct().collect(Collectors.toList());
								}
								
								/*potRemVals.add(new GaussianInteger(BigInteger.ZERO, B));
								potRemVals.add(new GaussianInteger(BigInteger.ZERO, new BigInteger("-1").multiply(B)));*/
								
							}
							else if(B.compareTo(BigInteger.ZERO) == 0) {
								//potRemValsStream = Stream.concat(potRemValsStream,Stream.of(new GaussianInteger(a, BigInteger.ZERO)));
								//potRemValsStream = Stream.concat(potRemValsStream,Stream.of(new GaussianInteger(new BigInteger("-1").multiply(a), BigInteger.ZERO)));
								GaussianInteger val1 = new GaussianInteger(c, BigInteger.ZERO);
								GaussianInteger val2 = new GaussianInteger(new BigInteger("-1").multiply(c), BigInteger.ZERO);
								if (!(remVals.contains(val1) || notRemVals.contains(val1))) {
									List<List<GaussianInteger>> remOrNot = remOrNotSet(val1, w);
									remVals.addAll(remOrNot.get(0));
									remVals = remVals.stream().distinct().collect(Collectors.toList());
									notRemVals.addAll(remOrNot.get(1));
									notRemVals = notRemVals.stream().distinct().collect(Collectors.toList());
								}
								if (!(remVals.contains(val2) || notRemVals.contains(val2))) {
									List<List<GaussianInteger>> remOrNot = remOrNotSet(val2, w);
									remVals.addAll(remOrNot.get(0));
									remVals = remVals.stream().distinct().collect(Collectors.toList());
									notRemVals.addAll(remOrNot.get(1));
									notRemVals = notRemVals.stream().distinct().collect(Collectors.toList());
								}
							/*	potRemVals.add(new GaussianInteger(c, BigInteger.ZERO));
								potRemVals.add(new GaussianInteger(new BigInteger("-1").multiply(c), BigInteger.ZERO));*/
								
							}
							else {
								/*potRemValsStream = Stream.concat(potRemValsStream,Stream.of(new GaussianInteger(a, B)));
								potRemValsStream = Stream.concat(potRemValsStream,Stream.of(new GaussianInteger(new BigInteger("-1").multiply(a), B)));
								potRemValsStream = Stream.concat(potRemValsStream,Stream.of(new GaussianInteger(a, new BigInteger("-1").multiply(B))));
								potRemValsStream = Stream.concat(potRemValsStream,Stream.of(new GaussianInteger(new BigInteger("-1").multiply(a), new BigInteger("-1").multiply(B))));*/
								GaussianInteger val1 = new GaussianInteger(c, B);
								GaussianInteger val2 = new GaussianInteger(new BigInteger("-1").multiply(c), B);
								GaussianInteger val3 = new GaussianInteger(c, new BigInteger("-1").multiply(B));
								GaussianInteger val4 = new GaussianInteger(new BigInteger("-1").multiply(c), new BigInteger("-1").multiply(B));
								if (!(remVals.contains(val1) || notRemVals.contains(val1))) {
									List<List<GaussianInteger>> remOrNot = remOrNotSet(val1, w);
									remVals.addAll(remOrNot.get(0));
									remVals = remVals.stream().distinct().collect(Collectors.toList());
									notRemVals.addAll(remOrNot.get(1));
									notRemVals = notRemVals.stream().distinct().collect(Collectors.toList());
								}
								if (!(remVals.contains(val2) || notRemVals.contains(val2))) {
									List<List<GaussianInteger>> remOrNot = remOrNotSet(val2, w);
									remVals.addAll(remOrNot.get(0));
									remVals = remVals.stream().distinct().collect(Collectors.toList());
									notRemVals.addAll(remOrNot.get(1));
									notRemVals = notRemVals.stream().distinct().collect(Collectors.toList());
								}
								if (!(remVals.contains(val3) || notRemVals.contains(val3))) {
									List<List<GaussianInteger>> remOrNot = remOrNotSet(val3, w);
									remVals.addAll(remOrNot.get(0));
									remVals = remVals.stream().distinct().collect(Collectors.toList());
									notRemVals.addAll(remOrNot.get(1));
									notRemVals = notRemVals.stream().distinct().collect(Collectors.toList());
								}
								if (!(remVals.contains(val4) || notRemVals.contains(val4))) {
									List<List<GaussianInteger>> remOrNot = remOrNotSet(val4, w);
									remVals.addAll(remOrNot.get(0));
									remVals = remVals.stream().distinct().collect(Collectors.toList());
									notRemVals.addAll(remOrNot.get(1));
									notRemVals = notRemVals.stream().distinct().collect(Collectors.toList());
								}
								
								
								/*potRemVals.add(new GaussianInteger(c, B));
								potRemVals.add(new GaussianInteger(new BigInteger("-1").multiply(c), B));
								potRemVals.add(new GaussianInteger(c, new BigInteger("-1").multiply(B)));
								potRemVals.add(new GaussianInteger(new BigInteger("-1").multiply(c), new BigInteger("-1").multiply(B)));*/
							}
						}
					}
						catch(ArithmeticException e) {
							
						}
						
					}
				//System.out.println(String.valueOf(a.multiply(a).add(b.multiply(b))));
				//c++;
				//System.out.println(c);
				if (a.compareTo(n1) == 0 && b.compareTo(n2) == 0) {
					check = true;
					break;
				}
			}
			if (check) {
				break;
			}
			
		}
		GaussianInteger[] ans = remVals.toArray(new GaussianInteger[remVals.size()]);
		return ans;
	}
	
	public static String newDivide(GaussianInteger v, GaussianInteger w) {
		String answer = "";
		GaussianInteger vu = GaussianInteger.ZERO;
		GaussianInteger w1 = GaussianInteger.ZERO;
		BigInteger K = BigInteger.ZERO;
		GaussianInteger R = GaussianInteger.ZERO;
		int indexRem = 0;
		int indexRepRem = 0;
		List<GaussianInteger> remSet = new ArrayList<GaussianInteger>();
		List<GaussianInteger> rems = new ArrayList<GaussianInteger>();
		if (coPrimeM3Pi(w)) {
			vu = v;
			w1 = w;
		}
		else {
			GaussianInteger[] newDivVals = newDivVal(v, w);//toCoPrimeM3Pi(w);
			vu = newDivVals[0];
			w1 = newDivVals[1];
			K = KVAL.getVal();
		}
		Natural count = Natural.ZERO;
		while (true) {
			GaussianInteger A = count.NtoZi();
			R = vu.subtract(A.multiply(w1));
			remSet = calcRemSet(R, w1);
			if (remSet.contains(R)) {
				answer = toMinus3Plusi(A);
				indexRepRem++;
				if (K.compareTo(BigInteger.ZERO) == 0) {
					answer = answer + ".";
				}
				else if (K.compareTo(new BigInteger(String.valueOf(answer.length()))) == -1) {
					answer = answer.substring(0, answer.length() - K.intValueExact()) + "." + answer.substring(answer.length()-K.intValueExact());
				}
				else {
					String tempAns = "0.";
					for (int i = 0; i < K.intValueExact() - answer.length(); i++) {
						tempAns = tempAns + "0";
					}
					answer = tempAns + answer;
				}
				/*while (true) {
					if (answer.indexOf("0") == 0) {
						answer = answer.replaceFirst("0","");
					}
					else {
						break;	
					}
				}*/
				rems.add(R);
			//	System.out.println(R.toString());
			//	System.out.println(K.toString());
				break;
			}
			else {
				count = count.add(Natural.ONE);
			}
		}
		boolean flag = true;
		GaussianInteger tempR = GaussianInteger.ZERO;
		while (flag) {
			for (GaussianInteger d : DIGITS) {
				tempR = GaussianInteger.M3Pi.multiply(rems.get(indexRem)).subtract(d.multiply(w1));
				if (remSet.contains(tempR)) {
					R = tempR;
					answer = answer + d.realPart().toString();
					indexRem++;
					break;
				}
				else {
					List<GaussianInteger> tempRemSet = calcRemSet(tempR, w1);
					if (tempRemSet.contains(tempR)) {
						R = tempR;
						answer = answer + d.realPart().toString();
						remSet.addAll(tempRemSet);
						remSet = remSet.stream().distinct().collect(Collectors.toList());
						indexRem++;
						break;
					}
				}
			}
			if (rems.contains(R)) {
				flag = false;
			}
			else {
				indexRepRem++;
				rems.add(R);
			}
		}
		
		return answer;
	}
	
	public static String divide(GaussianInteger v, GaussianInteger w) {
		String answer = "";
		GaussianInteger[] val = new GaussianInteger[2];//newDivVal(v,w);
		if (coPrimeM3Pi(w)) {
			val[0] = v;
			val[1] = w;
		}
		else {
			val = newDivVal(v, w);
		}
		GaussianInteger V = val[0];
		GaussianInteger W = val[1];
		//Natural K = KVAL;
		GaussianInteger[] remSet = newCalcRemSet(W);
		List<GaussianInteger> rems = new ArrayList<GaussianInteger>();
		Complex A = Complex.ZERO;
		int indexRepRem = 0;
		int count = 0;
		boolean flag = true;
		while (flag) {
			if (count == 0) {
				for (GaussianInteger r : remSet) {
					A = Complex.valueOf(V.subtract(r)).divide(Complex.valueOf(W));
					if (A.isGaussInt()) {
						GaussianInteger a = A.toGaussInt();
						if (a.equals(ZERO) || a.equals(ONE) || a.equals(TWO) || a.equals(THREE) || a.equals(FOUR) || a.equals(FIVE) || a.equals(SIX) || a.equals(SEVEN) || a.equals(EIGHT) || a.equals(NINE)) {
							answer = a.toString() + ".";
						}
						/*if (a.equals(ZERO)) {
							
						}
						else if(a.equals(ZERO)) {
							answer = answer + "0.";
						}
						else if(a.equals(ONE)) {
							answer = answer + "1.";
						}
						else if(a.equals(TWO)) {
							answer = answer + "2.";
						}
						else if(a.equals(THREE)) {
							answer = answer + "3.";
						}
						else if(a.equals(FOUR)) {
							answer = answer + "4.";
						}
						else if(a.equals(FIVE)) {
							answer = answer + "5.";
						}
						else if(a.equals(SIX)) {
							answer = answer + "6.";
						}
						else if(a.equals(SEVEN)) {
							answer = answer + "7.";
						}
						else if(a.equals(EIGHT)) {
							answer = answer + "8.";
						}
						else if(a.equals(NINE)) {
							answer = answer + "9.";
						}*/
						else {
							answer = toMinus3Plusi(a) + ".";
						}
						rems.add(r);
						count++;
						break;
					}
				}
			}	
			else {
				for (GaussianInteger r : remSet) {
					A = new Complex(GaussianInteger.M3Pi.multiply(rems.get(count-1)).subtract(r)).divide(Complex.valueOf(W));
					if (A.isGaussInt()) {
						GaussianInteger a = A.toGaussInt();
						if (a.equals(ZERO) || a.equals(ONE) || a.equals(TWO) || a.equals(THREE) || a.equals(FOUR) || a.equals(FIVE) || a.equals(SIX) || a.equals(SEVEN) || a.equals(EIGHT) || a.equals(NINE)) {
							answer = answer + a.toString();
							if (rems.contains(r)) {
								indexRepRem = rems.indexOf(r);
								flag = false;
							}
							else {
								rems.add(r);
								count++;
								break;
							}
						}
					}
					
				}
			}
		}
		while (true) {
			if (answer.indexOf("0") == 0) {
				answer = answer.replaceFirst("0","");
			}
			else {
				break;	
			}
		}
		if (KVAL.getVal().intValueExact() > answer.indexOf(".")) {
			String ANS = answer.substring(0,answer.indexOf(".")) + answer.substring(answer.indexOf("."),indexRepRem+answer.indexOf(".")+1) + "(" + answer.substring(indexRepRem+answer.indexOf(".")+1) + ")";
			int K = KVAL.getVal().intValueExact();
			int point = answer.indexOf(".");
			int move = K - point;
			answer = "0.";
			//System.out.println(answer);
			for (int i = 0; i < move; i++) {
				answer = answer + "0";
			}
			//String[] AnS = ANS.split(".");
			String[] AnS = {ANS.substring(0,point), ANS.substring(point+1)};
			answer = answer + AnS[0] + AnS[1];
			//return answer;
		}
		else if (KVAL.getVal().intValueExact() < answer.indexOf(".")){
			int K = KVAL.getVal().intValueExact();
			int point = answer.indexOf(".");
			//System.out.println(point);
			String ANS = answer.substring(0,answer.indexOf(".")) + answer.substring(answer.indexOf("."),indexRepRem+answer.indexOf(".")+1) + "(" + answer.substring(indexRepRem+answer.indexOf(".")+1) + ")";
			String[] AnS = {ANS.substring(0,point), ANS.substring(point+1)};//ANS.split(".");
			//System.out.println(ANS);
			answer = AnS[0].substring(0, point - K) + "." + AnS[0].substring(point - K) + AnS[1];
			//return AnS[0].substring(0, point - K) + "." + AnS[0].substring(point - K) + AnS[1];
		}
		else {
			//System.out.println(answer);
	answer = answer.substring(0,answer.indexOf(".")) + answer.substring(answer.indexOf("."),indexRepRem+answer.indexOf(".")+1) + "(" + answer.substring(indexRepRem+answer.indexOf(".")+1) + ")";
		}
		//return answer;
		if (answer.contains("(0)")) {
			answer = answer.replace("(0)", "");
		}
		while (true) {
			if (answer.lastIndexOf("0") == answer.length() - 1) {
				answer = answer.substring(0,answer.length() - 1);}
			else {
				break;	
			}
		}
		if(answer.indexOf(".") == answer.length() - 1) {
			answer = answer.substring(0, answer.length() - 1);
		}
		return answer;//.substring(0, div.indexOf("."));//divide1(v.multiply(u), w1);
	}
	
	
	public static String toMinus3Plusi(GaussianInteger z) {
		BigInteger s = z.realPart();
		BigInteger t = z.imagPart();
		BigInteger three = new BigInteger("3");
		String answer = "";
		BigInteger answerVals[] = Minus3Plusi.clearingAlgorithm("0," + String.valueOf(t) + "," + String.valueOf(s.add(three.multiply(t))));
		for (int i = 0; i < answerVals.length; i++) {
			answer = answer + String.valueOf(answerVals[i]);
		}
		while (true) {
			if (answer.equals("0")) {
				break;
			}
			else {
				if (answer.indexOf("0") == 0) {
					answer = answer.replaceFirst("0","");
				}
				else {
					break;	
				}
			}
		}
		return answer;
	}
	
	
	/*public static String divide1(GaussianInteger v, GaussianInteger w) {
		String answer = "";
		boolean flag = true;
		boolean flag2 = true;
		GaussianInteger[] potRemSet = new GaussianInteger[10];
		GaussianInteger v1 = GaussianInteger.ZERO;
		int indexRem = 0;
		int indexRepRem = 0;
		int remCount = 0;
		Natural count = new Natural(BigInteger.ZERO);
		GaussianInteger A = GaussianInteger.ZERO;
		//String radVal;
		List<GaussianInteger> rems = new ArrayList<GaussianInteger>();
		while (flag) {
			if(indexRem == 0) {
				/*if (coPrimeM3Pi(w)) {
					potRemSet = potRemSet(v,w);
					for (int a = 0; a < 10; a++) {
						List<GaussianInteger> remSet = Arrays.asList(calcRemSet(potRemSet[a],w));
						if (remSet.contains(potRemSet[a])) {
							/*if (rems.contains(potRemSet[a])) {
								indexRepRem = rems.indexOf(potRemSet[a]);
								answer = answer + String.valueOf(a);// + radVal;
								flag = false;
								break;
							}
							else {*/
							/*answer = String.valueOf(a) + ".";// + radVal;
							rems.add(potRemSet[a]);
							indexRem += 1;
							break;
							//}
						}
						else {
							remCount += 1;
						}
					}
					if (remCount == 10) {
						/*flag2 = true;
						remCount = 0;
						indexRem = 0;
						indexRepRem = 0;
						count = count.add(Natural.ONE);*/
						//flag = false;
				//	}
				//}
				//else {
			/*	while(flag2) {
					A = count.NtoZi();//new GaussianInteger(count.NtoZ(), BigInteger.ZERO);
					if (Minus3Plusi.isRemainder(v.subtract(A.multiply(w)), w)) {
						//System.out.println(v.toString() + " " + w.toString());
					//	System.out.println(v.subtract(A.multiply(w)).toString());
						flag2 = false;
					}
					else {
						count = count.add(Natural.ONE);
					}
				}
				//v1 = v;
				//BigInteger[] Aval = Minus3Plusi.clearingAlgorithm("0,0," + String.valueOf(A.realPart()));
			//	for (int i = 0; i < Aval.length; i++) {
				//	answer = answer + String.valueOf(Aval[i]);
				//}
				//answer = answer + String.valueOf(Minus3Plusi.clearingAlgorithm("0,0," + String.valueOf(A.realPart()))) + ".";
				answer = Minus3Plusi.toMinus3Plusi(A) + ".";
				//answer = answer + ".";
				rems.add(v.subtract(A.multiply(w)));
				//}
				indexRem++;
				//System.out.println(A.toString());
				v1 = GaussianInteger.M3Pi.multiply(rems.get(indexRem - 1));
			}
			else {
				//radVal = "";
				v1 = GaussianInteger.M3Pi.multiply(rems.get(indexRem - 1));
			}
			potRemSet = potRemSet(v1,w);
			for (int a = 0; a < 10; a++) {
				List<GaussianInteger> remSet = calcRemSet(potRemSet[a], w);//Arrays.asList(calcRemSet(potRemSet[a],w));
				if (remSet.contains(potRemSet[a])) {
					if (rems.contains(potRemSet[a])) {
						indexRepRem = rems.indexOf(potRemSet[a]);
						answer = answer + String.valueOf(a);// + radVal;
						flag = false;
						break;
					}
					else {
					answer = answer + String.valueOf(a);// + radVal;
					rems.add(potRemSet[a]);
					indexRem += 1;
					break;
					}
				}
				else {
					remCount += 1;
				}
			}
			if (remCount == 10) {
				/*flag2 = true;
				remCount = 0;
				indexRem = 0;
				indexRepRem = 0;
				count = count.add(Natural.ONE);*/
				/*flag = false;
			}
		
		}
		if (remCount == 10) {
			return "Didn't work";
		}
		else {
			while (true) {
				if (answer.indexOf("0") == 0) {
					answer = answer.replaceFirst("0","");
					//System.out.println(div);
				}
				else {
					break;	
					
				}
			}
			//System.out.println(KVAL.getVal().toString());
			if (KVAL.getVal().intValueExact() > answer.indexOf(".")) {
				String ANS = answer.substring(0,answer.indexOf(".")) + answer.substring(answer.indexOf("."),indexRepRem+answer.indexOf(".")+1) + "(" + answer.substring(indexRepRem+answer.indexOf(".")+1) + ")";
				int K = KVAL.getVal().intValueExact();
				int point = answer.indexOf(".");
				int move = K - point;
				answer = "0.";
				//System.out.println(answer);
				for (int i = 0; i < move; i++) {
					answer = answer + "0";
				}
				//String[] AnS = ANS.split(".");
				String[] AnS = {ANS.substring(0,point), ANS.substring(point+1)};
				answer = answer + AnS[0] + AnS[1];
				return answer;
			}
			else if (KVAL.getVal().intValueExact() < answer.indexOf(".")){
				int K = KVAL.getVal().intValueExact();
				int point = answer.indexOf(".");
				//System.out.println(point);
				String ANS = answer.substring(0,answer.indexOf(".")) + answer.substring(answer.indexOf("."),indexRepRem+answer.indexOf(".")+1) + "(" + answer.substring(indexRepRem+answer.indexOf(".")+1) + ")";
				String[] AnS = {ANS.substring(0,point), ANS.substring(point+1)};//ANS.split(".");
				//System.out.println(ANS);
				return AnS[0].substring(0, point - K) + "." + AnS[0].substring(point - K) + AnS[1];
			}
			else {
				//System.out.println(answer);
		return answer.substring(0,answer.indexOf(".")) + answer.substring(answer.indexOf("."),indexRepRem+answer.indexOf(".")+1) + "(" + answer.substring(indexRepRem+answer.indexOf(".")+1) + ")";
			}
		}
	}
	
	public static String divide(GaussianInteger v, GaussianInteger w) {
		Complex W1;
		GaussianInteger w1 = GaussianInteger.ONE;
		GaussianInteger u = GaussianInteger.ONE;
		//Natural k = Natural.ZERO;
		boolean flag = true;
		Natural count = Natural.ZERO;
		String div = "";
		if (coPrimeM3Pi(w)) {//w.coPrime(GaussianInteger.M3Pi)) {
			div = divide1(v,w);
			/*while (true) {
				if (div.indexOf("0") == 0) {
					div = div.replaceFirst("0","");
					//System.out.println(div);
				}
				else {
					break;	
					
				}
			}*/
			/*if (div.contains("(0)")) {
				div = div.replace("(0)", "");
			}
			return div;//divide1(v, w);
		}
		else {
			GaussianInteger[] newdivval = newDivVal(v, w);
			div = divide1(newdivval[0],newdivval[1]);
			/*while(flag) {
				u = count.NtoN2()[0].NtoZi();
				k = count.NtoN2()[1];
				W1 = Complex.valueOf(w.multiply(u)).divide(Complex.valueOf(GaussianInteger.M3Pi.pow(k.getVal())));
				if (W1.isGaussInt()) {
					w1 = W1.toGaussInt();
					if (coPrimeM3Pi(w1) && !w1.equals(GaussianInteger.ZERO)) {//w1.coPrime(GaussianInteger.M3Pi)) {
						div = divide1(v.multiply(u), w1);
						if (div.equals("Didn't work")) {
							count = count.add(Natural.ONE);
						}
						else {
							flag = false;
						}
					}
					else {
						count = count.add(Natural.ONE);
					}	
				}
				else {
					count = count.add(Natural.ONE);
				}
			}*/
			//System.out.println(v.multiply(u).toString() + " " + w1.toString() + " " + k.toString());
		//	String result = new StringBuilder(div).delete(0, k.getVal().intValueExact()).append(div.substring(0,b)).toString();
			//int divlength = div.length();
			/*while (true) {
				if (div.indexOf("0") == 0) {
					div = div.replaceFirst("0","");
					//System.out.println(div);
				}
				else {
					break;	
					
				}
			}*/
			//if (divlength < k.getVal().intValueExact()) {
				
			//}
			//System.out.println(v.multiply(u).toString() + " / ( (" + w1.toString() + ") * " + "b^-" + k.toString() + ")");
		/*	if (div.contains("(0)")) {
				div = div.replace("(0)", "");
			}
			return div;//.substring(0, div.indexOf("."));//divide1(v.multiply(u), w1);
		}
	}*/
	
	public static GaussianInteger[] toCoPrimeM3Pi(GaussianInteger z) {
		GaussianInteger u = GaussianInteger.ZERO;
		Natural count = Natural.ZERO;
		//Natural k = Natural.ZERO;
		Complex W1 = new Complex("0","0");
		GaussianInteger w1 = GaussianInteger.ZERO;
		if (coPrimeM3Pi(z)) {
			return new GaussianInteger[] {GaussianInteger.ONE , z};
		}
		else {
		//List<GaussianInteger> factors = z.factorize();
		while(true) {
			u = count.NtoN2()[0].NtoZi();
			k = count.NtoN2()[1];
		//	System.out.println(k.getVal().toString());
			W1 = Complex.valueOf(z.multiply(u)).divide(Complex.valueOf(GaussianInteger.M3Pi.pow(k.getVal())));
			if (W1.isGaussInt()) {
				w1 = W1.toGaussInt();
				if (coPrimeM3Pi(w1) && !w1.equals(GaussianInteger.ZERO)) {//w1.coPrime(GaussianInteger.M3Pi)) {
					break;
					//div = divide1(v.multiply(u), w1);
					/*if (div.equals("Didn't work")) {
						count = count.add(Natural.ONE);
					}
					else {
						break
					}*/
				}
				else {
					count = count.add(Natural.ONE);
				}	
			}
			else {
				count = count.add(Natural.ONE);
			}
		}
		}
		return new GaussianInteger[] {u, w1};
	}
	
	public static GaussianInteger[] newDivVal(GaussianInteger v, GaussianInteger w) {
		GaussianInteger[] result = {v , GaussianInteger.ONE};
		GaussianInteger[] temp = new GaussianInteger[2];
		List<GaussianInteger> factors = w.factorize();
		KVAL = k;
		for(GaussianInteger factor : factors) {
			if (!coPrimeM3Pi(factor)) { 
				temp = toCoPrimeM3Pi(factor);
				KVAL = KVAL.add(k);
				result[0] = result[0].multiply(temp[0]);
				result[1] = result[1].multiply(temp[1]);
			}
			else {
				result[1] = result[1].multiply(factor);
			}
		}
		System.out.println(result[0].toString() + " / " + result[1].toString());
		return result;
	}
	
	public static boolean coPrimeM3Pi(GaussianInteger z) {
		GaussianInteger f1 = new GaussianInteger("1","1");
		GaussianInteger f2 = new GaussianInteger("2", "1");
		List<GaussianInteger> factors = z.factorize();
		if (factors.contains(f1) || factors.contains(f2)) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public static /*String*/List<GaussianInteger> longDiv(GaussianInteger v, GaussianInteger w) {
		List<GaussianInteger> ansVals = new ArrayList<GaussianInteger>();
		List<GaussianInteger> remVals = new ArrayList<GaussianInteger>();
		String answer = "";
		int count = 0;
		//int indexRep = 0;
		while (true) {
			if (count == 0) {
				ansVals.add(v.divide(w));
				remVals.add(v.mod(w));
				//System.out.println(v.mod(w));
				count++;
			}
			else {
				ansVals.add(remVals.get(count-1).multiply(GaussianInteger.M3Pi).divide(w));
				//System.out.println(ansVals.get(count));
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
		//boolean first = true;
		/*int index = 0;
		for (GaussianInteger i : ansVals) {
			if (index == 0) {
				answer = "(" + i.toString() + ")" + ".";
				index++;
				//first = false;
			}
			else {
				if (index == indexRep + 1) {
					answer = answer + "[" + "(" + i.toString() + ")";
				}
				else {
				answer = answer + "(" + i.toString() + ")";
				}
				index++;
			}
		}
		return answer + "]";*/
		
		return ansVals;
	}
	public static List<GaussianInteger> repPartLongDiv(List<GaussianInteger> div) {
		repPartSize =  div.size() - indexRep;//div.subList(indexRep, div.size()).size();
		return div.subList(indexRep, div.size());	
	}
	
	public static GaussianInteger repPartLongDivGaussVal(List<GaussianInteger> reps) {
		GaussianInteger answer = GaussianInteger.ZERO;
		BigInteger pow = new BigInteger(String.valueOf(reps.size()-1));
		for (GaussianInteger z : reps) {
			answer = answer.add(z.multiply(GaussianInteger.M3Pi.pow(pow)));
			pow = pow.subtract(BigInteger.ONE);
		}
		return answer;
	}
	
	public static String longDivToM3Pi(GaussianInteger v, GaussianInteger w) {
		String answer = "";
		List<GaussianInteger> longDivVal = longDiv(v,w);
		List<GaussianInteger> repPartLongDivVal = repPartLongDiv(longDivVal);
		List<GaussianInteger> firstPartLongDivVal = new ArrayList<GaussianInteger>();//longDivVal;
		for (GaussianInteger i : longDivVal) {
			if (repPartLongDivVal.contains(i)) {
				firstPartLongDivVal.add(GaussianInteger.ZERO);
			}
			else {
				firstPartLongDivVal.add(i);
			}
		}
		//List<GaussianInteger> repPartLongDivVal1 = repPartLongDivVal;
	//	int S = repPartLongDivVal.size();
		//int F = firstPartLongDivVal.size();
		//	firstPartLongDivVal.removeAll(repPartLongDivVal1);
	//	for (int i = 0; i < S; i++) {
		//	firstPartLongDivVal.remove(F-S + i);
		//	F--;
	//	}
		//firstPartLongDivVal.removeAll(repPartLongDivVal1);
		GaussianInteger firstPartLongDivValGauss = repPartLongDivGaussVal(firstPartLongDivVal);
		int repSize = repPartSize;
		GaussianInteger repPartLongDivValGauss = repPartLongDivGaussVal(repPartLongDivVal);
		List<Integer> repPartLongDivValM3Pi = gaussToM3Pi(repPartLongDivValGauss);
		List<Integer> repAnsM3Pi = repPartLongDivValM3Pi;
		GaussianInteger repAnsGauss = repPartLongDivValGauss;
		GaussianInteger repAnsGaussInit = repAnsGauss;
		List<GaussianInteger> wholeParts = new ArrayList<GaussianInteger>();
		//int repSize = repPartSize;
		GaussianInteger wholePart = GaussianInteger.ZERO;
		boolean check = true;
		//System.out.println(repSize);
		//System.out.println(repAnsM3Pi.size());
		while (true) {
			if (repAnsM3Pi.size() <= repSize) {
				repAnsM3Pi = gaussToM3Pi(M3PiToGauss(repAnsM3Pi));
				if (repAnsM3Pi.size() <= repSize) {
				break;
				}
			}
			else {
				GaussianInteger largePart = new GaussianInteger(String.valueOf(repAnsM3Pi.get(0)), "0");//new GaussianInteger(String.valueOf(repAnsM3Pi.get(0)), "0").multiply(GaussianInteger.M3Pi.pow(new BigInteger(String.valueOf(repAnsM3Pi.size()-1)))).divide(GaussianInteger.M3Pi.pow(new BigInteger(String.valueOf(repSize))).subtract(GaussianInteger.ONE));
				//GaussianInteger modPart = //new GaussianInteger(String.valueOf(repAnsM3Pi.get(0)), "0").multiply(GaussianInteger.M3Pi.pow(new BigInteger(String.valueOf(repAnsM3Pi.size()-1)))).mod(GaussianInteger.M3Pi.pow(new BigInteger(String.valueOf(repSize))).subtract(GaussianInteger.ONE));
				BigInteger power = new BigInteger(String.valueOf(repAnsM3Pi.size() - 1 - repSize));
				
				
				repAnsM3Pi.set(repAnsM3Pi.size() - 1 - power.intValueExact(), repAnsM3Pi.get(repAnsM3Pi.size() - 1 - power.intValueExact()) + repAnsM3Pi.get(0));
				repAnsM3Pi.remove(0);
				wholePart = wholePart.add(largePart.multiply(GaussianInteger.M3Pi.pow(power)));//new GaussianInteger(String.valueOf(repAnsM3Pi.get(0)), "0").multiply(GaussianInteger.M3Pi.pow(new BigInteger(String.valueOf(repAnsM3Pi.size()-1)))).divide(GaussianInteger.M3Pi.pow(new BigInteger(String.valueOf(repSize)).subtract(BigInteger.ONE))));
				repAnsGauss = M3PiToGauss(repAnsM3Pi);
				System.out.println("Current: " + repAnsGauss.toString());
				System.out.println("Init: " + repAnsGaussInit.toString());
				//repAnsM3Pi = gaussToM3Pi(repAnsGauss);
				//GaussianInteger modPart = largePart.multiply(GaussianInteger.M3Pi.pow(power));
				//	wholeParts.add(wholePart);
				//repAnsGauss = repAnsGauss.add(modPart).subtract(largePart.multiply(GaussianInteger.M3Pi.pow(new BigInteger(String.valueOf(repAnsM3Pi.size()-1)))));
				//repAnsM3Pi = repAnsM3Pi.subList(1,repAnsM3Pi.size());
				//repAnsGauss = M3PiToGauss(repAnsM3Pi).add(modPart);//new GaussianInteger(String.valueOf(repAnsM3Pi.get(0)), "0").multiply(GaussianInteger.M3Pi.pow(new BigInteger(String.valueOf(repAnsM3Pi.size()-1)))).divide(GaussianInteger.M3Pi.pow(new BigInteger(String.valueOf(repSize)).subtract(BigInteger.ONE))));
			//	repAnsM3Pi = gaussToM3Pi(repAnsGauss);
				//System.out.println("repans" + repAnsGauss.toString());
				//System.out.println("init" + repAnsGaussInit.toString());
				//System.out.println("whole" + wholePart.toString());
				if (wholePart.equals(GaussianInteger.ZERO) && repAnsGauss.equals(repAnsGaussInit)) {
					wholePart = GaussianInteger.ZERO;
					repAnsGaussInit = /*repPartLongDivValGauss*/repAnsGaussInit.multiply(GaussianInteger.M3Pi.pow(new BigInteger(String.valueOf(repSize))).add(GaussianInteger.ONE));
					repAnsGauss = repAnsGaussInit;
					//System.out.println(repAnsGauss.toString());
					repAnsM3Pi = gaussToM3Pi(repAnsGauss);
					repSize = repSize*2;
				}
				/*if (wholeParts.contains(wholePart) && check) {
					wholeParts.clear();//removeAll(wholeParts);
					wholePart = GaussianInteger.ZERO;
					repAnsGauss = repPartLongDivValGauss.multiply(GaussianInteger.M3Pi.pow(new BigInteger(String.valueOf(repSize))).add(GaussianInteger.ONE));
				//	System.out.println(repAnsGauss.toString());
					repAnsM3Pi = gaussToM3Pi(repAnsGauss);
					repSize = repSize*2;
					//check = false;
				}
				else {*/
				/*	wholeParts.add(wholePart);
					repAnsM3Pi = repAnsM3Pi.subList(1,repAnsM3Pi.size());
					repAnsGauss = M3PiToGauss(repAnsM3Pi).add(modPart);//new GaussianInteger(String.valueOf(repAnsM3Pi.get(0)), "0").multiply(GaussianInteger.M3Pi.pow(new BigInteger(String.valueOf(repAnsM3Pi.size()-1)))).divide(GaussianInteger.M3Pi.pow(new BigInteger(String.valueOf(repSize)).subtract(BigInteger.ONE))));
					repAnsM3Pi = gaussToM3Pi(repAnsGauss);*/
				//	System.out.println(wholePart.toString());
				//}
			}
		}
		String firstPartAnswer = toMinus3Plusi(firstPartLongDivValGauss.add(wholePart.multiply(GaussianInteger.M3Pi.pow(new BigInteger(String.valueOf(repAnsM3Pi.size()))))));
		//for (int i = 0; i < repAnsM3Pi.size(); i++) {
		//firstPartAnswer = firstPartAnswer.substring(0, firstPartAnswer.length() - repAnsM3Pi.size());
	//	}
		String secondPartAnswer = /*+ "   " + toMinus3Plusi(wholePart) + "." +*/ "(" + toMinus3Plusi(M3PiToGauss(repAnsM3Pi)) + ")";
		//int afterPoint = longDivVal.size() - 1;
		answer = firstPartAnswer + secondPartAnswer;
		//answer = answer.substring(0, answer.length() - 2 - afterPoint) + "." + answer.substring(answer.length() - 2 - afterPoint);
		if (answer.contains("(0)")) {
			answer = answer.substring(0, answer.indexOf("("));
		}
		/*if (answer.indexOf(".") == answer.length()-1) {
			answer = answer.substring(0, answer.indexOf("."));
		}*/
		//answer = answer + " * (-3+i) ^ -" + String.valueOf(afterPoint) + " " + String.valueOf(repSize);
		return answer;
		
	}
	
	public static List<Integer> gaussToM3Pi(GaussianInteger z) {
		int[] tempAns = Arrays.stream(toMinus3Plusi(z).split("")).mapToInt(Integer::parseInt).toArray();
		 ArrayList<Integer> ans = (ArrayList<Integer>) Arrays.stream(tempAns).boxed().collect(Collectors.toList());

		return ans;
		//return toMinus3Plusi(z).getBytes();
	}
	
	public static GaussianInteger M3PiToGauss(List<Integer> z) {
		BigInteger pow = new BigInteger(String.valueOf(z.size() - 1));
		GaussianInteger ans = GaussianInteger.ZERO;
		for (int i : z) {
			ans = ans.add(new GaussianInteger(String.valueOf(i), "0").multiply(GaussianInteger.M3Pi.pow(pow)));
			pow = pow.subtract(BigInteger.ONE);
		}
		return ans;
	}
}
