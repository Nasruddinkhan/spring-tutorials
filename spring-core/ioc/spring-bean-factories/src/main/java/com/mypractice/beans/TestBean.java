package com.mypractice.beans;

public class TestBean {
	private  String osArch;
	private String  javaRuntime;
	private String  javaSpec;
	private String  javaHome;
	
	public void setJavaHome(String javaHome) {
		this.javaHome = javaHome;
	}
	public void setOsArch(String osArch) {
		this.osArch = osArch;
	}
	public void setJavaRuntime(String javaRuntime) {
		this.javaRuntime = javaRuntime;
	}
	public void setJavaSpec(String javaSpec) {
		this.javaSpec = javaSpec;
	}
	@Override
	public String toString() {
		return "TestBean [osArch=" + osArch + ", javaRuntime=" + javaRuntime + ", javaSpec=" + javaSpec + ", javaHome="
				+ javaHome + "]";
	}
	
	
}
