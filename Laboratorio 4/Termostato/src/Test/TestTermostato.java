package Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import Temp.Thermostat;
import Temp.ProgrammedSetting;
public class TestTermostato {
	/*
	 *  if (((curTemp < dTemp - thresholdDiff) ||
           (override && curTemp < overTemp - thresholdDiff)) &&
           (timeSinceLastRun > minLag))
      {
	 */
	private Thermostat t;
	private ProgrammedSetting ps;
	
	public void setUP () {
		t = new Thermostat();
		ps = new ProgrammedSetting();
	}
	
	@Test
	void testn7 () {
		//curTemp < dTemp - thresholdDiff = True
		//override = False
		//curTemp < overTemp - thresholdDiff = False
		//timeSinceLastRun > minLag = True
		//resultado = true
		t.setCurrentTemp(5);
		//dTemp = 65
		t.setDay(null);
		t.setPeriod(null);
		t.setThresholdDiff(1);
		
		t.setOverride(false);
		
		t.setOverTemp(25);
		
		t.setTimeSinceLastRun(20);
		t.setMinLag(5);
		
		assertTrue (t.turnHeaterOn(ps));
		
		
		
	}
	@Test
	void testn9 () {
		
		
	}
	
	@Test
	void testn10 () {		

		
		
	}
	
	@Test
	void testn11() {
		
		
	}
	
	@Test
	void testn13 () {
		
		
	}
	@Test
	void testn15 () {
		
		
	}
	
	
	

}
