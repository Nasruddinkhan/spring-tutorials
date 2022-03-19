package com.mypractice.factory;

import com.mypractice.beans.CNGEngine;
import com.mypractice.beans.DieselEngine;
import com.mypractice.beans.Engine;
import com.mypractice.beans.PetrolEngine;
import com.mypractice.beans.Viechle;

public class ViechleFactory {
	
	public static  Viechle getInstance(String engineType) {
		  Viechle viechle=null;
		  Engine engine=null;
		  //create Engine object
		  if(engineType.equalsIgnoreCase("petrol")) {
			  engine=new PetrolEngine();
		  }
		  else if(engineType.equalsIgnoreCase("diesel")) {
			  engine=new DieselEngine();
		  }
		  else if(engineType.equalsIgnoreCase("CNG")) {
			  engine=new CNGEngine();
		  }
		  else {
			  throw new IllegalArgumentException("Invalid Engine Type");
		  }
		  //create Viechle object having Engine object
		  viechle=new Viechle();
		  viechle.setEngine(engine);
		  return viechle;
	}

}
