import java.util.HashMap;
import java.util.Scanner;

public class NumberThread extends Thread {

	
	static HashMap<Integer,String> numberMap = new HashMap<Integer,String>();
	String number;
	static Scanner inp = new Scanner(System.in);
	NumberThread(){
		loadNumbers();
	}
	static void loadNumbers()	{
		numberMap.put(1, "One");
		numberMap.put(2, "Two");
		numberMap.put(3, "Three");
		numberMap.put(4, "Four");
		numberMap.put(5, "Five");
		numberMap.put(6, "Six");
		numberMap.put(7, "Seven");
		numberMap.put(8, "Eight");
		numberMap.put(9, "Nine");
		numberMap.put(0, "Zero");
	}
	public void run()	{
		System.out.println("Enter a 4 digit number: ");
		number = inp.next();
		for(int i=0; i<number.length(); i++)	{
			int ch = Integer.parseInt(number.charAt(i)+"");
			System.out.println(ch +" -> " + numberMap.get(ch));
		}
	}

}
