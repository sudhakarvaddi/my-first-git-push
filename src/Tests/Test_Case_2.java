package Tests;

import org.testng.annotations.Test;

import framework_sudha.CommonMethods_vsr;
import framework_sudha.Events_vsr;
import framework_sudha.UtilityMethods_vsr;

public class Test_Case_2 extends CommonMethods_vsr{
	@Test
	public static void CustomerViews() {
	
		Events_vsr.get().clickingElement(UtilityMethods_vsr.get().get_By_fromRep("CustomerView"));
		
		
		
		
	}

}
