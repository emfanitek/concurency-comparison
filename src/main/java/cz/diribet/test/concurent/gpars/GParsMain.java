package cz.diribet.test.concurent.gpars;

import groovyx.gpars.group.DefaultPGroup;
import cz.diribet.test.concurent.domain.Stroj;
import cz.diribet.test.concurent.gpars.actor.DeleniDatVyrobnichCelku;
import cz.diribet.test.concurent.message.NajitARozdelitDataMessage;

public class GParsMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DefaultPGroup group = new DefaultPGroup(10);
		DeleniDatVyrobnichCelku deleniDatActor = new DeleniDatVyrobnichCelku();
		deleniDatActor.setParallelGroup(group);
		deleniDatActor.start();

		for (int i = 1; i < 20; i++) {
			deleniDatActor.send(new NajitARozdelitDataMessage(new Stroj(i, "Stroj " + i)));
		}

		try {
			Thread.sleep(100000);
		} catch (InterruptedException e) {
		}
	}

}
