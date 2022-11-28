import java.lang.Math;
import java.math.BigInteger;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.apache.commons.math3.complex.Complex;

import java.util.Arrays;

public class Minus3Plusi {
	private int s;
	private int t;
	private int a;
	public static Complex base = new Complex(-3,1);
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
	
	public static String strFromComp(Complex val) {
		String ans = "";
		long real = Math.round(val.getReal());
		long imag = Math.round(val.getImaginary());
		if (real != 0) {
			ans = ans + String.valueOf(real);
		}
		if (real != 0 && imag > 0) {
			if (imag == 1) {
				ans = ans + "+i";
			}
			else {
			ans = ans + "+" + String.valueOf(imag) + "i";
			}
		}
		else if (imag != 0) {
			if (imag == 1) {
				ans = ans + "i";
			}
			else if (imag == -1) {
				ans = ans + "-i";
			}
			else {
			ans = ans + String.valueOf(imag) + "i";
			}
		}
		else if (real != 0) {
		}
		else {
			ans = "0";
		}
		return ans;
	}
	public static Complex compFromStr(String str) {
		Complex ans = zero;
		if (str.contains("i")) {
			if (!str.contains("+") && !str.contains("-")) {
				if (str.compareTo("i") == 0) {
					ans = new Complex(0,1);
				}
				else {
					ans = new Complex(0,Double.parseDouble(str.substring(0,str.indexOf("i"))));
				}
			}
			else if (str.contains("+")) {
				if ((str.indexOf("i") - str.indexOf("+")) == 1) {

					ans = new Complex(Double.parseDouble(str.substring(0,str.indexOf("+"))),1);
				}
				else {
				ans = new Complex(Double.parseDouble(str.substring(0,str.indexOf("+"))),Double.parseDouble(str.substring(str.indexOf("+")+1,str.indexOf("i"))));	
				}
				}
			else if(str.contains("-") && !str.contains("+") && str.indexOf("-") == str.lastIndexOf("-") && str.indexOf("-") == 0) {
			if ((str.indexOf("i") - str.indexOf("-")) == 1) {
				ans = new Complex(0,-1);
					}
			else {
				ans = new Complex(0,Double.parseDouble(str.substring(0,str.indexOf("i"))));
			
				}
			}
			
			else {
			if ((str.indexOf("i") - str.lastIndexOf("-")) == 1) {
			ans = new Complex(Double.parseDouble(str.substring(0,str.lastIndexOf("-"))),-1);	
			}
			else {
			ans = new Complex(Double.parseDouble(str.substring(0,str.lastIndexOf("-"))),Double.parseDouble(str.substring(str.lastIndexOf("-"),str.indexOf("i"))));
			}
				}
		}
		else {
		ans =  new Complex(Double.parseDouble(str));
		}
		return ans;
	}
	public static String divide(Complex v, Complex w) {
		//Complex a = new Complex(-6,-2);
		//Complex[] rems = calcRemSet(v,w);
		String answer = "";
		//for (int i = 0; i < rems.length; i++ ) {
			//answer = answer + String.valueOf(rems[i]) + " ";
		//}
		//answer = String.valueOf(g(v,w));
		
		boolean flag = true;
		Complex[] potRemSet = new Complex[10];
		Complex v1 = zero;
		int indexRem = 0;
		int indexRepRem = 0;
		String radVal;
		List<Complex> rems = new ArrayList<Complex>();
		while (flag) {
			if(indexRem == 0) {
				radVal = ".";
				v1 = v;
			}
			else {
				radVal = "";
				v1 = base.multiply(rems.get(indexRem - 1));
			}
			potRemSet = potRemSet(v1,w);
			for (int a = 0; a < 10; a++) {
				List<Complex> remSet = Arrays.asList(calcRemSet(potRemSet[a],w));
				if (remSet.contains(potRemSet[a])) {
					if (rems.contains(potRemSet[a])) {
						indexRepRem = rems.indexOf(potRemSet[a]);
						answer = answer + String.valueOf(a) + radVal;
						flag = false;
						break;
					}
					else {
					answer = answer + String.valueOf(a) + radVal;
					rems.add(potRemSet[a]);
					indexRem += 1;
					break;
					}
				}
			}
			//if (indexRem == 100) {
				//flag = false;
			//}
		}
		return answer.substring(0,2) + answer.substring(2,indexRepRem+2) + "(" + answer.substring(indexRepRem+2) + ")...";
	}
	public static Complex[] potRemSet(Complex v , Complex w) {
		Complex[] potRemSet = new Complex[10];
		for (int a = 0; a < 10; a++) {
			potRemSet[a] = v.subtract(w.multiply(a));
		}
		return potRemSet;
	}
	public static Complex g(Complex z , Complex w) {
		Complex ans = zero;
		Complex intg = zero;
		Complex g = zero;
		for (int a = 0; a <10; a++) {
			g = z.add(w.multiply(a)).divide(base);
			g = new Complex(g.getReal(),g.getImaginary());
			intg = new Complex(Math.round(g.getReal()),Math.round(g.getImaginary()));
			if (Complex.equals(g,intg,10)) {
				ans = intg;
			}
		}
		return ans;
	}
	public static Complex[] calcRemSet(Complex z, Complex w) {
		int count = 0;
		int index = 0;
		Complex g = zero;
		List<Complex> protoRemSet = new ArrayList<Complex>();
		protoRemSet.add(z);
		boolean flag = true;
		while (flag) {
			g = g(protoRemSet.get(count),w);
			if (protoRemSet.contains(g)) {
				index = protoRemSet.indexOf(g);
				flag = false;
			}
			else {
				protoRemSet.add(g);
				count += 1;
			}
		}
		Complex[] remSet = new Complex[protoRemSet.size() - index];
		for (int i = 0; i < remSet.length; i++ ) {
			remSet[i] = protoRemSet.get(i + index);
		}
		return remSet;
	}
	
	public static Complex strToVal(String str) {
		Complex ans = zero;
		Complex[] posVals = valFromString(str);
		for (int i = 0; i < posVals.length;i++) {
			ans = ans.add(posVals[i].multiply(base.pow(posVals.length - 1 - i)));
		}
		return ans;
	}
	
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
	private static int[] minPoly = {1,6,10};
	// From decimal representation of a gaussian integer s + ti
	public Minus3Plusi(int s, int t) {
		this.s = s;
		this.t = t;
	}
	// From -3+i base representation of a gaussian integer
	public Minus3Plusi(int a) {
		this.a = a;
	}
	public String toDecimal() {
		return "";
	}
	public static String toMinus3Plusi(Complex j) {
		//int s = this.s;
		//int t = this.t;
		long s = Math.round(j.getReal());
		long t = Math.round(j.getImaginary());
		/*double b =   Math.floor((s+3*t) / 10.0) * -1; //* Math.signum((s + 3 * t));
		int c = (int) b;
		int[] poly = {c * minPoly[0],c * minPoly[1],c * minPoly[2]};
		List<Integer> answerVal = new ArrayList<Integer>();
		String answer = null;
		answerVal.add((s+3*t) + poly[2]);
		answerVal.add(t + poly[1]);
		answerVal.add(poly[0]);
		//int[] simpleArray = answerVal.toArray();
		//boolean y = true;
		//while (y = true) {
			//for (int i = 0; i < answerVal.size(); i++) {
				//if (answerVal.get(i) < 0) {
					
				//}
			//}
			//y = false;
		//}
		//for (int i = 1; i < answerVal.size(); i++) {
		int i = 1;
		int z = answerVal.size();
		while (i < z) {
			z = answerVal.size();
			if (answerVal.get(i) < 0 || answerVal.get(i) > 9 ) {
				b =   Math.floor((answerVal.get(i)) / 10.0) * -1;
				c = (int) b;
				poly[0] = c * minPoly[0];
				poly[1] = c * minPoly[1];
				poly[2] = c * minPoly[2];
				//if (i == 1){
				answerVal.add(poly[0]);
				//}
				answerVal.set(i, answerVal.get(i) + poly[2]);
				answerVal.set(i+1, answerVal.get(i+1) + poly[1]);
				//i = answerVal.size();
			}
			i += 1;
		}
		Collections.reverse(answerVal);
		for (int x = 0; x < answerVal.size(); x++) {
			if (x == 0) {
				answer = String.valueOf(answerVal.get(x)) + " ";
			}
			else {
			answer = answer + String.valueOf(answerVal.get(x)) + " ";
		}
		}*/
		//return answer;//String.valueOf(b);
		return Minus3Plusi.clearingAlgorithm("0," + String.valueOf(t) + "," + String.valueOf(s + 3 * t), 0);
		}
	public static String toMinus3Plusi(Complex j,int radVal) {
		long s = Math.round(j.getReal());
		long t = Math.round(j.getImaginary());
		return Minus3Plusi.clearingAlgorithm("0," + String.valueOf(t) + "," + String.valueOf(s + 3 * t), radVal);
	}
	public static String clearingAlgorithm(String num,int radixval) {
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
		String answer = "";
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
		return answer;//String.valueOf(Collections.min(posVals));
	}
/*	public static String clearingAlgorithm(String num,int radixval) {
		List<Integer> vals = new ArrayList<Integer>();
		String str[] = num.split(",");
		List<String> strvals = new ArrayList<String>();
		strvals = Arrays.asList(str);
		for (String myInt : strvals) 
        { 
          vals.add(Integer.valueOf(myInt)); 
        }
		Collections.reverse(vals);
	//	double b =   Math.floor((s+3*t) / 10.0) * -1; //* Math.signum((s + 3 * t));
		double b = Math.floor((vals.get(0) / 10.0)) * -1;
		int c = (int) b;
		//String k = String.valueOf(c);
		int[] poly = {c * minPoly[0],c * minPoly[1],c * minPoly[2]};
		String answer = "";
		//vals.add((s+3*t) + poly[2]);
		//vals.add(t + poly[1]);
		//vals.add(poly[0]);
		int i = 0;
		int z = vals.size();
		while (i < z) {
			z = vals.size();
			if (vals.get(i) < 0 || vals.get(i) > 9 ) {
				b =   Math.floor((vals.get(i)) / 10.0) * -1;
				c = (int) b;
				poly[0] = c * minPoly[0];
				poly[1] = c * minPoly[1];
				poly[2] = c * minPoly[2];
				//if (i == 1){
				//vals.add(poly[0]);
				//}
				
				if (i < z - 2) {
				vals.set(i, vals.get(i) + poly[2]);
				vals.set(i+1, vals.get(i+1) + poly[1]);
				vals.set(i+2, vals.get(i+2) + poly[0]);
				}//i = answerVal.size();
				else {
					vals.set(i, vals.get(i) + poly[2]);
					vals.set(i+1, vals.get(i+1) + poly[1]);
					vals.add(poly[0]);
				}
			}
			i += 1;
		}
		Collections.reverse(vals);
		for (int x = 0; x < vals.size(); x++) {
			if (x == 0 && x >= vals.size() - radixval && vals.size() < radixval) {
				answer = answer + "0.";
				for (i = 0; i < Math.abs(vals.size() - radixval);i++) {
					answer = answer + "0";
				}
				answer = answer + String.valueOf(vals.get(x));
			}
			else if (x == vals.size() - radixval && vals.size() > radixval) {
				answer = answer + "." + String.valueOf(vals.get(x));
			}
			else {
				if (x == 0) {
					answer = String.valueOf(vals.get(x));
				}
				else {
				answer = answer + String.valueOf(vals.get(x));
			}
			}
			
		}
		return answer;
	}*/
	public static String multiply(String c,String d) {
		String[] cs = c.split("");
		String[] ds = d.split("");
		  int[] a = new int[cs.length];
		  int[] b = new int[ds.length];
	      for(int i=0; i<cs.length; i++) {
	         a[i] = Integer.parseInt(cs[i]);
	      }
	      for(int i=0; i<ds.length; i++) {
		         b[i] = Integer.parseInt(ds[i]);
		      }
		  int[] answers = new int[a.length + b.length - 1]; // always a.length + b.length - 1
		  for (int i = b.length - 1; i >= 0; i--) {
		   for (int j = a.length - 1; j >= 0; j--) {
		    if (i == b.length - 1) {
		     answers[i + j] = (b[i] * a[j]);
		    }
		    else {
		     answers[i + j] = answers[i + j] + (b[i] * a[j]);
		    }
		   }
		  }
		  String ans = "";
		  for (int k=0;k<answers.length;k++) {
		   if (k == answers.length - 1) {
		   // if(answers[k] == 0) {
		    //	break;
		//    }
		    //else {
			   ans = ans + String.valueOf(answers[k]);
		  //  }
		   }
		   else {
			  // if (k + 1 == answers.length - 1) {
				  // ans = ans + String.valueOf(answers[k]);
			  // }
			   //else {
		   ans = ans + String.valueOf(answers[k]) + ",";
			  // }
		   }
		  }
		//  System.out.println(ans);
		//  System.out.println(ans);
		  //System.out.println(Minus3Plusi.clearingAlgorithm(ans));
		return ans;
	}
	public static String div10(String a, int recurnum) {
		String b = "3";
		for (int i = 0; i < recurnum;i++) {
			b = b + "98";
		}
		return Minus3Plusi.clearingAlgorithm(Minus3Plusi.multiply(a, b),2 + 2 * recurnum );
	}
	public static String div100(String a, int recurnum) {
		String b = "3";
		for (int i = 0; i < recurnum;i++) {
			b = b + "9179810088";
		}
		return Minus3Plusi.clearingAlgorithm(Minus3Plusi.multiply(a, b),4 + 10 * recurnum);
	}
	public static String lrs (String str) { 
      String LRS="";  
      int n = str.length();  
      for(int i = 0; i < n; i++){  
          for(int j = i+1; j < n; j++){  
              //Checks for the largest common factors in every substring  
              String x = lcp(str.substring(i,n),str.substring(j,n));  
              //If the current prefix is greater than previous one  
              //then it takes the current one as longest repeating sequence  
              if(x.length() > LRS.length()) LRS=x;//.substring(0, x.length());  
          }  
      }  
      return LRS;
	}
      public static String lcp(String s, String t){  
          int n = Math.min(s.length(),t.length());  
          for(int i = 0; i < n; i++){  
              if(s.charAt(i) != t.charAt(i)){  
                  return s.substring(0,i);  
              }  
          }  
          return s.substring(0,n);  
      }  
      public static String formatNum(String num) {
    	 String recur = Minus3Plusi.lrs(num).replaceAll("(.+?)\\1+", "$1");
    	 String ans = num;
    	 if (num.contains(".")) {
    		 // ans = num.substring(0,num.indexOf(recur)) + "(" + recur + ")...";
    	  }
    	 System.out.println(num.indexOf(recur));
    	 System.out.println(recur);
    	 return num;
      }
   // Returns the longest repeating non-overlapping
   // substring in str
      public static String longestRepeatedSubstring(String str) {
           int n = str.length();
           int LCSRe[][] = new int[n + 1][n + 1];
    
           String res = ""; // To store result
           int res_length = 0; // To store length of result
    
           // building table in bottom-up manner
           int i, index = 0;
           for (i = 1; i <= n; i++) {
               for (int j = i + 1; j <= n; j++) {
                   // (j-i) > LCSRe[i-1][j-1] to remove
                   // overlapping
                   if (str.charAt(i - 1) == str.charAt(j - 1)
                           && LCSRe[i - 1][j - 1] < (j - i)) {
                       LCSRe[i][j] = LCSRe[i - 1][j - 1] + 1;
    
                       // updating maximum length of the
                       // substring and updating the finishing
                       // index of the suffix
                       if (LCSRe[i][j] > res_length) {
                           res_length = LCSRe[i][j];
                           index = Math.max(i, index);
                       }
                   } else {
                       LCSRe[i][j] = 0;
                   }
               }
           }
    
           // If we have non-empty result, then insert all
           // characters from first character to last
           // character of String
           if (res_length > 0) {
               for (i = index - res_length + 1; i <= index; i++) {
                   res += str.charAt(i - 1);
               }
           }
    
           return res;
       }
       
	public static void main(String[] args) {
		//Scanner input = new Scanner(System.in);
		//BigInteger a = input.nextBigInteger();
		//BigInteger b = input.nextBigInteger();
		//int c = input.nextInt();
	//Minus3Plusi j = new Minus3Plusi(25,70);
	//System.out.println(j.toMinus3Plusi());
		//String j = input.next();
		//System.out.println(clearingAlgorithm(j));
	//System.out.println(Minus3Plusi.multiply(String.valueOf(a), String.valueOf(b)));
			  //System.out.println(Minus3Plusi.clearingAlgorithm(Minus3Plusi.multiply(String.valueOf(a), String.valueOf(b)),c));
		//System.out.println(Minus3Plusi.div10(String.valueOf(a), c));
		//System.out.println(Minus3Plusi.div100(Minus3Plusi.toMinus3Plusi(552, 0),30));
		//String hop = Minus3Plusi.lrs("1551.12121212121212");
	//	String rep = hop.replaceAll("(.+?)\\1+", "$1");
	//	System.out.println((Minus3Plusi.div100(Minus3Plusi.clearingAlgorithm("0,0,1",0),10)));
		//System.out.println(longestRepeatedSubstring("3989898989898989756"));
		//System.out.println(Minus3Plusi.clearingAlgorithm("0,70,235", 0));
	}
	}
