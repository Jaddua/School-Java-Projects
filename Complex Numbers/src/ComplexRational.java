import java.math.BigInteger;
public class ComplexRational {
	private GaussianInteger numerator;
	private GaussianInteger denominator;
	public ComplexRational(GaussianInteger numerator, GaussianInteger denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}
	public ComplexRational(GaussianInteger numerator) {
		this.numerator = numerator;
		this.denominator = GaussianInteger.ONE;
	}
	public ComplexRational(BigInteger numerator, BigInteger denominator) {
		this.numerator = new GaussianInteger(numerator,BigInteger.ZERO);
		this.denominator = new GaussianInteger(denominator,BigInteger.ZERO);
	}
	public ComplexRational(BigInteger numerator) {
		this.numerator = new GaussianInteger(numerator,BigInteger.ZERO);
		this.denominator = GaussianInteger.ONE;
	}
	public GaussianInteger getDenom() {
		return this.denominator;
	}
	public GaussianInteger getNum() {
		return this.numerator;
	}
	public ComplexRational realPart() {
		return new ComplexRational(this.getNum().realPart().multiply(this.getDenom().realPart()).add(this.getNum().imagPart().multiply(this.getDenom().imagPart())), this.getDenom().realPart().pow(2).add(this.getDenom().imagPart().pow(2)));
	}
	public ComplexRational imagPart() {
		return new ComplexRational(this.getNum().imagPart().multiply(this.getDenom().realPart()).subtract(this.getNum().realPart().multiply(this.getDenom().imagPart())), this.getDenom().realPart().pow(2).add(this.getDenom().imagPart().pow(2)));

	}
	public String toString() {
		return "(" + this.getNum().toString() + ")/(" + this.getDenom().toString() + ")";
	}
}
