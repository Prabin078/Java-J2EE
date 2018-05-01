
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1 = new NumberThread();
		Thread t2 = new VowelThread();
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.start();
	}

}
