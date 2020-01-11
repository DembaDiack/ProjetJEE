package com.di3.crenaux;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Crenaux {
	private LocalTime time;
	private int id;
	public static List<Crenaux> crenaux_list = new ArrayList<Crenaux>();
	
	public Crenaux() {
		
	}
	public Crenaux(int id,int hour,int minute) {
		this.setId(id);
		this.setTime(LocalTime.of(hour, minute));
	}
	public Crenaux(int i, String err) {
		this.id = i;
		// TODO Auto-generated constructor stub
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public static List<Crenaux> getCrenaux_list() {
		return crenaux_list;
	}
	public static void setCrenaux_list(List<Crenaux> crenaux_list) {
		Crenaux.crenaux_list = crenaux_list;
	}
}
