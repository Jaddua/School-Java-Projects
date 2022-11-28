import java.math.BigInteger;
import java.math.MathContext;
import java.math.BigDecimal;
import java.math.RoundingMode;
public class Natural {
	private BigInteger value;
	private BigInteger NaN = new BigInteger(String.valueOf((long) Double.NaN));
	public static final Natural ONE = new Natural(BigInteger.ONE);
	public static final Natural ZERO = new Natural(BigInteger.ZERO);
	//public final Natural NaN = new Natural(nan);
	public Natural(BigInteger n) {
		if (n.compareTo(BigInteger.ZERO) == -1) {
			this.value = NaN;
		}
		else {
			this.value = n.abs();
		}
	}
	public Natural add(Natural addend) {
		return new Natural(this.value.add(addend.value));
	}
	public Natural subtract(Natural subtrahend) {
		return new Natural(this.value.subtract(subtrahend.value));
	}
	public Natural multiply(Natural multiplier) {
		return new Natural(this.value.multiply(multiplier.value));
	}
	public String toString() {
		return String.valueOf(this.value);
	}
	public BigInteger floor(BigDecimal x) {
        return x.setScale(0, RoundingMode.FLOOR).unscaledValue();
    }
	public BigInteger ceil(BigDecimal x) {
        return x.setScale(0, RoundingMode.CEILING).unscaledValue();
    }
	
	public BigInteger getVal() {
		return this.value;
	}
	
	public Natural[] NtoN2() {
		 MathContext mc = new MathContext(10);
		BigInteger eight = new BigInteger("8");
		BigDecimal two = new BigDecimal(2);
		 Natural[] mapping = new Natural[2];
		BigInteger w = floor((new BigDecimal(this.value.multiply(eight).add(BigInteger.ONE)).sqrt(mc).subtract(BigDecimal.ONE)).divide(two));
		BigDecimal wd = new BigDecimal(w);
		BigInteger t = (wd.multiply(wd).add(wd)).divide(two).toBigInteger();
		BigInteger y0 = this.value.subtract(t);
		Natural y = new Natural(y0);
		Natural x = new Natural(w.subtract(y0));
		mapping[0] = x;
		mapping[1] = y;
		return mapping;
	}
	public BigInteger NtoZ() {
		BigDecimal N = new BigDecimal(this.value);
		BigInteger TWO = new BigInteger("2");
		BigDecimal two = new BigDecimal("2");
		BigDecimal minusone = new BigDecimal("-1");
		if (this.value.mod(TWO).compareTo(BigInteger.ZERO) == 0) {
			return N.divide(two).toBigInteger();
		}
		else {
			return minusone.multiply(N).subtract(BigDecimal.ONE).divide(two).toBigInteger();
		}
	}
	public GaussianInteger NtoZi() {
		return new GaussianInteger(this.NtoN2()[0].NtoZ(), this.NtoN2()[1].NtoZ());
	}
}
