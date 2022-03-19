package com.mypractice.bean;

import java.util.List;
import java.util.Date;
import java.util.Map;

public class SkillMaster {
	private Map<String,List<String>> emplSkill;
	private Map<String,Date>  addJoiningDate;
	public void setEmplSkill(Map<String, List<String>> emplSkill) {
		this.emplSkill = emplSkill;
	}
	
	public void setAddJoiningDate(Map<String, Date> addJoiningDate) {
		this.addJoiningDate = addJoiningDate;
	}

	@Override
	public String toString() {
		return "SkillMaster [emplSkill=" + emplSkill + ", addJoiningDate=" + addJoiningDate + "]";
	}
}
