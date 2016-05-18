package com.vsii.tsc.model;

import java.util.List;

public class TestCase {
	private String tcID;
	private String tcLct;
	private String tcDesc;
	private String tcPrec;
	private String tcStep;
	private String tcExpt;
	private String tcPri;
	private List<TCImageResults> tcImageResults;
	
	
	public String getTcLct() {
		return tcLct;
	}
	public void setTcLct(String tcLct) {
		this.tcLct = tcLct;
	}
	public String getTcPri() {
		return tcPri;
	}
	public void setTcPri(String tcPri) {
		this.tcPri = tcPri;
	}
	public String getTcID() {
		return tcID;
	}
	public void setTcID(String tcID) {
		this.tcID = tcID;
	}
	public String getTcDesc() {
		return tcDesc;
	}
	public void setTcDesc(String tcDesc) {
		this.tcDesc = tcDesc;
	}
	public String getTcPrec() {
		return tcPrec;
	}
	public void setTcPrec(String tcPrec) {
		this.tcPrec = tcPrec;
	}
	public String getTcStep() {
		return tcStep;
	}
	public void setTcStep(String tcStep) {
		this.tcStep = tcStep;
	}
	public String getTcExpt() {
		return tcExpt;
	}
	public void setTcExpt(String tcExpt) {
		this.tcExpt = tcExpt;
	}
	public List<TCImageResults> getTcImageResults() {
		return tcImageResults;
	}
	public void setTcImageResults(List<TCImageResults> tcImageResults) {
		this.tcImageResults = tcImageResults;
	}
	
	
	

	
	
	

}
