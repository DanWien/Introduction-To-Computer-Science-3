
public class Bit {

    private boolean value;

    public Bit(boolean value){
       this.value = value;
    }

    public int toInt(){ 
        // True means one and false means zero.
        if (value) 
        	return 1;
        return 0;

    }

    public String toString(){
        if(value)
        	return "1";
        return "0";
        
    }
}

