package com.islamicinfo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class YuoTubeVideo implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer vId;

	@Column
	public String vKey;

	@Column
	public String title;

	@Column
	public String maulanaName;

	@Column
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
