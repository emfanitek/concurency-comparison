package cz.diribet.test.concurent.message;

import java.util.List;

import cz.diribet.test.concurent.domain.DataVyrobnihoCelku;
import cz.diribet.test.concurent.domain.Stroj;

public class RozdelenaDataMessage {

	public final Stroj stroj;
	public final List<DataVyrobnihoCelku> data;


	public RozdelenaDataMessage(Stroj stroj, List<DataVyrobnihoCelku> data) {
		super();
		this.stroj = stroj;
		this.data = data;
	}


	public Stroj getStroj() {
		return stroj;
	}


	public List<DataVyrobnihoCelku> getData() {
		return data;
	}


}
