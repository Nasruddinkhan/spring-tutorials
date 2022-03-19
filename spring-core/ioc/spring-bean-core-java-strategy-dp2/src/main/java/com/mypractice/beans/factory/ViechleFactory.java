package com.mypractice.beans.factory;

import java.util.HashMap;
import java.util.Map;

import com.mypractice.beans.CNGEngine;
import com.mypractice.beans.DieselEngine;
import com.mypractice.beans.Engine;
import com.mypractice.beans.PetrolEngine;
import com.mypractice.beans.Viechle;

public class ViechleFactory {
	private static Map<Class, Object> cacheMap = new HashMap();
	public static Viechle getInstance(String engineType) {
		Viechle viechle = null;
		Engine engine = null;
		// create Engine object
		if (!cacheMap.containsKey(Engine.class)) {
			if (engineType.equalsIgnoreCase("petrol")) {
				engine = new PetrolEngine();
			} else if (engineType.equalsIgnoreCase("diesel")) {
				engine = new DieselEngine();
			} else if (engineType.equalsIgnoreCase("CNG")) {
				engine = new CNGEngine();
			} else {
				throw new IllegalArgumentException("Invalid Engine Type");
			}
			cacheMap.put(engine.getClass(), engine);
		} else {
			engine = (Engine) cacheMap.get(Engine.class);
		}

		if (!cacheMap.containsKey(Viechle.class)) {
			viechle = new Viechle();
			cacheMap.put(viechle.getClass(), viechle);
		} else {
			viechle = (Viechle) cacheMap.get(Viechle.class);
		}
		viechle.setEngine(engine);
		return viechle;
	}// method
}
