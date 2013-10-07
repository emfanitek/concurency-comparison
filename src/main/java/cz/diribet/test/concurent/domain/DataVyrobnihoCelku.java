package cz.diribet.test.concurent.domain;

import java.util.List;

public class DataVyrobnihoCelku {

	private List<Integer> data;

	public DataVyrobnihoCelku(List<Integer> data) {
		super();
		this.data = data;
	}

	public List<Integer> getData() {
		return data;
	}

	public void setData(List<Integer> data) {
		this.data = data;
	}


}
