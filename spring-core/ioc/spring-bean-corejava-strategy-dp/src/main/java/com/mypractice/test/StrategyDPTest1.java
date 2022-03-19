package com.mypractice.test;

import com.mypractice.beans.Viechle;
import com.mypractice.factory.ViechleFactory;

public class StrategyDPTest1{

	public static void main(String[] args) {
		Viechle viechle=null;
		//Get Target class obj having Dependent class obj
		viechle=ViechleFactory.getInstance("CNG");
		viechle.journey("MUBAI", "UP");
		System.out.println("....................................");
		//Get Target class obj having Dependent class obj
		viechle=ViechleFactory.getInstance("Petrol");
		viechle.journey("UP", "MUMBAI");
	}

}
