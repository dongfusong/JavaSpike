package Calculator_ex;

public class MultiplyStrategy implements CalcStrategy {

	@Override
	public int calcValue(BigDig digA, BigDig digB, int index) {
		int result = 0;
		for (int i = 0; i < digA.length(); i++){
			for (int j = 0; j < digB.length(); j++){
				if (i + j == index){
					result += digA.at(i) * digB.at(j);
				}
			}
		}
		return result;
	}

	@Override
	public int calcMinResultLength(BigDig digA, BigDig digB) {
		return digA.length() + digB.length() - 1;
	}
}
