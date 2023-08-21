public class BitVector {
    private Bit[] bits;
    
    public BitVector(String s) {
        if (!(NumericalString.legalNumericString(s,2)))
        		throw new IllegalArgumentException("Invalid String Input");
        // Creating a new Bit array with the proper length , and inserting the bits as defined.
        this.bits = new Bit[s.length()];
        for(int i = 0; i<s.length(); i=i+1) {
        	if (s.charAt(i) == '0')
        		bits[i] = new Bit(false);
        	else
        		bits[i] = new Bit(true);
        }
    }

    public String toString() {
    	String Binary ="";
    	// Converting the bit array to a binary string.
        for (int i = 0 ; i<this.bits.length ; i = i+1) {
        	Binary = Binary + bits[i];
        }
        // Converting the binary string to a reversed decimal string. 
        String DecReversed = NumericalString.binary2Decimal(Binary);
        String Decimal = "";
        // Converting the reversed decimal string to a normal decimal string.
        for (int i = 0 ; i<DecReversed.length() ; i = i+1) {
        	Decimal = Decimal + DecReversed.charAt(DecReversed.length()-i-1);
        }
        return Decimal;
    }
}
