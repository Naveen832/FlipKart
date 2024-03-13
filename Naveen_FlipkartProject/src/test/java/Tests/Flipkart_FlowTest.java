package Tests;

import org.testng.annotations.Test;


import Pages.DriverSetup;
import Pages.Flipkart_Flow;

public class Flipkart_FlowTest extends DriverSetup {
	 @Test
	  public void Flipkart() {
		 
		 Flipkart_Flow flip = new Flipkart_Flow(driver);
		  flip.AddtoCart();
		  
	  }


}
