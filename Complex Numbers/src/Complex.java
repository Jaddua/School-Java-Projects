import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.math.BigDecimal;
public class Complex {
	public static final Complex ZERO = new Complex("0", "0");
	public static final Complex ONE = new Complex("1", "0");
	public static final Complex MINUSONE = new Complex("-1", "0");
	public static final Complex I = new Complex("0", "1");
	public static final Complex MINUSI = new Complex("0", "-1");
	public static final Complex M3Pi = new Complex("-3", "1");
	private BigDecimal real;
	private BigDecimal imag;
	private String exactReal;
	private String exactImag;
	public Complex(BigDecimal real, BigDecimal imag) {
		this.real = real;
		this.imag = imag;
	}
	public Complex(String real, String imag) {
		this.real = new BigDecimal(real);
		this.imag = new BigDecimal(imag);
	}
	public Complex(GaussianInteger z) {
		this.real = new BigDecimal(z.realPart());
		this.imag = new BigDecimal(z.imagPart());
	}
	public BigDecimal realPart() {
		return this.real;
	}
	public BigDecimal imagPart() {
		return this.imag;
	}
	public Complex add(Complex addend) {
		BigDecimal augendReal = this.realPart();
		BigDecimal augendImag = this.imagPart();
		BigDecimal addendReal = addend.realPart();
		BigDecimal addendImag = addend.imagPart();
		return new Complex(augendReal.add(addendReal), augendImag.add(addendImag));
	}
	public Complex subtract(Complex subtrahend) {
		BigDecimal minuendReal = this.realPart();
		BigDecimal minuendImag = this.imagPart();
		BigDecimal subtrahendReal = subtrahend.realPart();
		BigDecimal subtrahendImag = subtrahend.imagPart();
		return new Complex(minuendReal.subtract(subtrahendReal), minuendImag.subtract(subtrahendImag));
	}
	public Complex multiply(Complex multiplier) {
		BigDecimal multiplicandReal = this.realPart();
		BigDecimal multiplicandImag = this.imagPart();
		BigDecimal multiplierReal = multiplier.realPart();
		BigDecimal multiplierImag = multiplier.imagPart();
		return new Complex(multiplicandReal.multiply(multiplierReal).subtract(multiplicandImag.multiply(multiplierImag)), multiplicandReal.multiply(multiplierImag).add(multiplicandImag.multiply(multiplierReal)));
	}
	public Complex divide(Complex divisor) {
		BigDecimal dividendReal = this.realPart();
		BigDecimal dividendImag = this.imagPart();
		BigDecimal divisorReal = divisor.realPart();
		BigDecimal divisorImag = divisor.imagPart();
		return new Complex(dividendReal.multiply(divisorReal).add(dividendImag.multiply(divisorImag)).divide(divisorReal.pow(2).add(divisorImag.pow(2)), new MathContext(100)), dividendImag.multiply(divisorReal).subtract(dividendReal.multiply(divisorImag)).divide(divisorReal.pow(2).add(divisorImag.pow(2)), new MathContext(100)));
	}
	public BigInteger decFloor(BigDecimal x) {
	        return x.setScale(0, RoundingMode.FLOOR).unscaledValue();
	    }
		
	public GaussianInteger floor() {
		return new GaussianInteger(decFloor(this.realPart()), decFloor(this.imagPart()));
	}
	public boolean isGaussInt() {
		//BigDecimal result1 = .setScale(0, RoundingMode.DOWN);
		if (this.realPart().setScale(0, RoundingMode.DOWN).compareTo(this.realPart()) == 0 && this.imagPart().setScale(0, RoundingMode.DOWN).compareTo(this.imagPart()) == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	public static Complex valueOf(GaussianInteger z) {
		return new Complex(new BigDecimal(z.realPart()), new BigDecimal(z.imagPart()));
	}
	public GaussianInteger toGaussInt() {
		return new GaussianInteger(this.realPart().toBigInteger(), this.imagPart().toBigInteger());
	}
	public String toString() {
		return this.realPart().toString() + " , " + this.imagPart().toString();
	}
	
	}

