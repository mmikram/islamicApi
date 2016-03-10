package com.islamicinfo.bean;

import java.io.Serializable;

public class YouTubeVideoBean implements Serializable {

	public Integer vId;

	public String vKey;

	public String title;

	public String maulanaName;

	public String date;

	public Integer getvId() {
		return vId;
	}

	public void setvId(Integer vId) {
		this.vId = vId;
	}

	public String getvKey() {
		return vKey;
	}

	public void setvKey(String vKey) {
		this.vKey = vKey;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMaulanaName() {
		return maulanaName;
	}

	public void setMaulanaName(String maulanaName) {
		this.maulanaName = maulanaName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
