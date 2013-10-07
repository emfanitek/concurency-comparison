package cz.diribet.test.concurent.message;

import cz.diribet.test.concurent.domain.Stroj;

public class NajitARozdelitDataMessage {

	private final Stroj stroj;

	public NajitARozdelitDataMessage(Stroj stroj) {
		super();
		this.stroj = stroj;
	}

	public Stroj getStroj() {
		return stroj;
	}
}
