package hashtableCerto;

import java.util.Date;

public class Main {
	
	//teste
	public static void main(String args[]) {
		PropertiesCerto p = new PropertiesCerto();
		p.put("data",new Date());
				
		System.out.println("Peguei beleza "+p.get("data"));
		System.out.println("Peguei errado "+p.getProperty("data"));
	}

}
