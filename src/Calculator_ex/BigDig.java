package Calculator_ex;


public class BigDig {
	private static final String negtiveSign = "-";
	StringBuffer buffer = null;
	int valueSign = 1;
	
	public BigDig(String str) {
		if (str.charAt(0) == '-'){
			valueSign = -1;
			buffer = new StringBuffer(str.substring(1, str.length()));
		}else{
			buffer = new StringBuffer(str);			
		}
		buffer.reverse();
	}

	public BigDig() {
		buffer = new StringBuffer();
	}

	public int length() {		
		return buffer.length();
	}

	public void append(int value) {
		buffer.append(value);
	}
	
	private String signString(){
		if (valueSign == 1){
			return "";
		}
		return negtiveSign;
	}
	
	private void setSign(int value){
		valueSign = value;
	}
	
	public String toString() {
		omitZeros();
		if (buffer.length() == 0){
			return "0";
		}
		StringBuffer buffer = new StringBuffer(this.buffer);
		return signString() + buffer.reverse().toString();
	}

	private void omitZeros() {
		while (buffer.length() != 0){
			int i = buffer.length() - 1;
			if (at(i) == 0){				
				buffer.deleteCharAt(i);
			}else{
				break;
			}
		}
	}

	public int at(int index) {
		if (index < length()){
			return buffer.charAt(index) - '0';
		}
		else{
			return 0;
		}
	}
	
	BigDig apply(BigDig dig, CalcStrategy strategy){
			int minLength = strategy.calcMinResultLength(this, dig);
			BigDig result = new BigDig();
			int carry = 0;
			for (int i = 0; i < minLength ; i++){
				int tempResult = strategy.calcValue(this, dig, i) + carry;
				result.append(tempResult % 10);
				carry = tempResult / 10;			
			}
			if (carry != 0){
				result.append(carry);
			}
			return result;		
	}

	private boolean sameSign(BigDig dig){
		return dig.valueSign == valueSign;
	}	
	
	BigDig add(BigDig dig){
		if (sameSign(dig)){			
			return addOperationWithSign(dig);			
		}else{
			return positiveMinus(dig);
		}
	}

	private BigDig positiveMinus(BigDig dig) {
		if(this.valueSign == -1){
			return positiveMinusOper(dig, this);
		}else{
			return positiveMinusOper(this, dig);
		}
	}

	private BigDig addOperationWithSign(BigDig dig) {
		BigDig result = addOperation(dig);			
		result.setSign(this.valueSign);
		return result;
	}
		
	private BigDig positiveMinusOper(BigDig digA, BigDig digB) {
		digA.setSign(1);
		digB.setSign(1);		
		return digA.minusOperWithSign(digB);
	}

	public BigDig minus(BigDig dig){
		if (sameSign(dig)){
			return minusOperWithSign(dig);
		}
		else{
			dig.reverseSign();
			return this.addOperationWithSign(dig);
		}
	}

	private BigDig minusOperWithSign(BigDig dig) {
		BigDig result = null;
		if (absNoLessThan(dig) == true){
			result = minusOperation(dig);
			result.setSign(valueSign);		
		}else{
			result = dig.minusOperation(this);
			result.setSign(dig.valueSign);
			result.reverseSign();
		}
		return result;
	}
	
	private void reverseSign() {
		valueSign *= -1;
	}

	BigDig addOperation(BigDig dig){
		return apply(dig, new AddStrategy());
	}
	
	public BigDig multiply(BigDig dig) {
		if (sameSign(dig)){
			return apply(dig, new MultiplyStrategy());
		}
		else{
			BigDig result = apply(dig, new MultiplyStrategy());
			result.setSign(-1);
			return result;
		}
	}
	
	private int at(boolean hasBorrowd, int index){
		if (true == hasBorrowd){
			return at(index) - 1; 
		}
		return at(index);
	}
	
	
	public BigDig minusOperation(BigDig dig) {
		int minLength = Math.max(length(), dig.length());
		boolean hasBorrowd = false;
		BigDig result = new BigDig();
		for (int index = 0; index < minLength; index++){
			int digA = at(hasBorrowd, index);
			int digB = dig.at(index);			
			if (digA >= digB){
				result.append(digA - digB);
				hasBorrowd = false;
			}else{
				result.append(10 + digA - digB);
				hasBorrowd = true;
			}
		}
		return result;
	}
	
	public boolean absNoLessThan(BigDig dig) {
		if (length() > dig.length()){
			return true;
		}
		else if (dig.length() > length()){
			return false;
		}
		else{
			for(int i = length() - 1; i >= 0; i--){
				if (at(i) != dig.at(i)){
					if (at(i) > dig.at(i)){
						return true;
					}else if (at(i) < dig.at(i)){						
						return false;
					}else{
						continue;
					}
				}
			}
			return true;
		}
	}
	
}



