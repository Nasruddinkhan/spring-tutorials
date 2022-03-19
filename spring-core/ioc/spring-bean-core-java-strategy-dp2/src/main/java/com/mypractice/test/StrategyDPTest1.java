package com.mypractice.test;

import com.mypractice.beans.Viechle;
import com.mypractice.beans.factory.ViechleFactory;

public class StrategyDPTest1{

	public static void main(String[] args) {
		Viechle viechle=null;
		//Get Target class obj having Dependent class obj
		viechle=ViechleFactory.getInstance("CNG");
		viechle.journey("MUMBAI", "CHENNAI");
		System.out.println("....................................");
		//Get Target class obj having Dependent class obj
				viechle=ViechleFactory.getInstance("petrol");
				viechle.journey("CHENNAI", "MUMBAI");
				viechle=ViechleFactory.getInstance("petrol");
				viechle.journey("DELHI", "MUMBAI");
	}

}
