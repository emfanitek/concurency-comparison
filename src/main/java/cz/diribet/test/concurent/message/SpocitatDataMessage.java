package cz.diribet.test.concurent.message;

import cz.diribet.test.concurent.domain.DataVyrobnihoCelku;
import cz.diribet.test.concurent.domain.Stroj;

public class SpocitatDataMessage {

	private final Stroj stroj;
	private final DataVyrobnihoCelku dataVyrobnihoCelku;

	public SpocitatDataMessage(Stroj stroj, DataVyrobnihoCelku dataVyrobnihoCelku) {
		super();
		this.stroj = stroj;
		this.dataVyrobnihoCelku = dataVyrobnihoCelku;
	}

	public Stroj getStroj() {
		return stroj;
	}

	public DataVyrobnihoCelku getDataVyrobnihoCelku() {
		return dataVyrobnihoCelku;
	}

}
