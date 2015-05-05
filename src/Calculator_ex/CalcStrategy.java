package Calculator_ex;

public interface CalcStrategy {
	int calcValue(BigDig digA, BigDig digB, int i); 
	int calcMinResultLength(BigDig digA, BigDig digB);
}
