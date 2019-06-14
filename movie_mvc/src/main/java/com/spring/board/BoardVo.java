package com.spring.board;

import java.sql.Date;

public class BoardVo {
	private int No;
	private String name;
	private Date screen_time;
	private String screen_room;

	public int getNo() {
		return No;
	}

	public void setNo(int no) {
		No = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getScreen_time() {
		return screen_time;
	}

	public void setScreen_time(Date screen_time) {
		this.screen_time = screen_time;
	}

	public String getScreen_room() {
		return screen_room;
	}

	public void setScreen_room(String screen_room) {
		this.screen_room = screen_room;
	}
}
