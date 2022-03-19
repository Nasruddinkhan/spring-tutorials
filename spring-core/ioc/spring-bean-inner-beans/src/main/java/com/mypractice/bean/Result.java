package com.mypractice.bean;

public class Result {
	private  StudentMark  mark;
	private Integer total;
	public Result( StudentMark mark, Integer total) {
		super();
		this.mark = mark;
		this.total = total;
	}
	public  String result() {
        int runs=0;
        runs=mark.getMarks();
        return mark.getName()+"  total number of  "+runs +" out of "+total;
	}
	
}
