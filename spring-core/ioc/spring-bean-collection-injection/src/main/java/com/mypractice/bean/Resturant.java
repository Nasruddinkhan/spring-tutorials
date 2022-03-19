package com.mypractice.bean;

import java.util.Properties;

public class Resturant {
	private Properties menus;

	public Resturant(Properties menus) {
		this.menus = menus;
	}

	@Override
	public String toString() {
		return "Resturant [menus=" + menus + "]";
	}
}
