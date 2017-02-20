import java.util.HashMap;
import java.util.Scanner;

public class dec2Hex {
	final static int HEX = 16;
	final static int DEC = 10;
	static HashMap<Integer, Character> hash;

	static public void main(String[] str){
		hash = new HashMap<Integer, Character>();
		Scanner scan = new Scanner(System.in);
		int value = scan.nextInt();

		setHashMap();		

		System.out.println(translation(value));
		hash=null;
	}

	
	static String translation(int value){
		StringBuffer buffer = new StringBuffer();
		
		int remainder;
		while(value>=HEX){
			remainder = value%HEX;
			addBuffer(remainder, buffer);
			value /= HEX;
		}
		addBuffer(value, buffer);

		return buffer.toString();
	}
	
	static void addBuffer(int remainder, StringBuffer buffer){
		if(remainder<DEC){
			buffer.insert(0, remainder);
		}else{
			buffer.insert(0, hash.get(remainder));
		}
	}

	static void setHashMap(){
		char val = 'a'-10;
		for(int i=10; i<=15; i++){
			hash.put(i, (char) (val+i));
		}
	}
}
