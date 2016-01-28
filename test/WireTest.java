
import static org.junit.Assert.*;
import org.junit.Test;
import qkd.Wire;

public class WireTest{
	@Test
        
	public void evaluatesExpression(){
		Wire blue = new Wire(); //the blue wire should be named "Default" with dimension 0
		Wire red = new Wire("redwire",2); //should be named "redwire" with dimension 2
								//each will have an Array of length [dimension] filled with -1s
		float[] bluetestarray = {};
		float[] redtestarray1 = {-1, -1};
                float[] redtestarray2 = {(float)0.5,(float)0.5};
                
                //float[] failarray = {8,6}; Had to make sure that test was working correctly--so it would produce
                    //a 'failure' message when I substituted an incorrect array for comparison
		
		assertEquals(blue.getName(),"Default");
		assertEquals(blue.getDimensions(),0);
		assertArrayEquals(bluetestarray, fillArray(blue),0);
		
		assertEquals(red.getName(),"redwire");
		assertEquals(red.getDimensions(),2);
		assertArrayEquals(redtestarray1, fillArray(red),0);
                
                red.setProbability(0,(float)0.5);
                red.setProbability(1,(float)0.5);
                
                assertArrayEquals(redtestarray2, fillArray(red),0);
                
                //assertArrayEquals(redtestarray, failarray); This is the fail case
	}
	
	public float[] fillArray(Wire x){ //Wire only allows retrieval of one probability at a time
		float[] getarray = new float[x.getDimensions()];
		for (int i = 0; i < x.getDimensions(); i++){
			getarray[i] = x.getProbability(i);
		}
		return getarray;
	}
}
