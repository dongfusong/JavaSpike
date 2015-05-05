package Calculator_ex;

public class AddStrategy implements CalcStrategy {
	@Override
	public
	int calcValue(BigDig digA, BigDig digB, int i) {
		return digA.at(i) + digB.at(i);
	}
	
	@Override
	public int calcMinResultLength(BigDig digA, BigDig digB) {
		return Math.max(digA.length(), digB.length());
	}
}
