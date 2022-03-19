package com.mypractice.test;

import com.mypractice.beans.Viechle;
import com.mypractice.factory.ViechleFactory;

public class StrategyDPTest2{

	public static void main(String[] args) {
		Viechle viechle=null;
		//Get Target class obj having Dependent class obj
		viechle=ViechleFactory.getInstance("diesel");
		viechle.journey("SAKINAK", "VIKHROLI");
	}

}
