

public class Driver {

	public static void main(String[] args) throws Exception {
		
		try {
			String text = "abcde";
			
		
			
			System.out.print(text.charAt(0));
			
			int r1 = Integer.parseInt(text);
			
		}
		catch (StringIndexOutOfBoundsException e) {
			System.out.println("errr");
		}	
		catch (ArithmeticException e) {
			System.out.println("Calculation Error!");
			}
			
			
			System.out.println("Finished!");
	}

}
