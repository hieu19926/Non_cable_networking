package com.primary.jsonstorage;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class CauHoi {
	@Expose
	@SerializedName("question")
	private String cauhoi;
	@SerializedName("answer_a")
	private String tla;
	@SerializedName("answer_b")
	private String tlb;
	@SerializedName("answer_c")
	private String tlc;
	@SerializedName("answer_d")
	private String tld;
	@SerializedName("true_result")
	private String dapan_dung;
	public CauHoi(){
		
	}
	public CauHoi(String cauhoi, String tla, String tlb, String tlc, String tld, String dapan){
		this.cauhoi = cauhoi;
		this.tla = tla;
		this.tlb = tlb;
		this.tlc = tlc;
		this.tld = tld;
		this.dapan_dung = dapan;
	}
	public void setData(String cauhoi, String tla, String tlb, String tlc, String tld, String dapan){
		this.cauhoi = cauhoi;
		this.tla = tla;
		this.tlb = tlb;
		this.tlc = tlc;
		this.tld = tld;
		this.dapan_dung = dapan;
	}
	public String getCauhoi(){
		return cauhoi;
	}
	public String getTla(){
		return tla;
	}
	public String getTlb(){
		return tlb;
	}
	public String getTlc(){
		return tlc;
	}
	public String getTld(){
		return tld;
	}
	public String getDapAn(){
		return dapan_dung;
	}
}