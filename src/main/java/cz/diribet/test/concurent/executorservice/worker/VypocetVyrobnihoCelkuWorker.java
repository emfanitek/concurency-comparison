package cz.diribet.test.concurent.executorservice.worker;

import java.util.concurrent.Callable;

import cz.diribet.test.concurent.message.SpocitanaDataMessage;
import cz.diribet.test.concurent.message.SpocitatDataMessage;

public class VypocetVyrobnihoCelkuWorker implements Callable<SpocitanaDataMessage> {

	private final SpocitatDataMessage message;

	public VypocetVyrobnihoCelkuWorker(SpocitatDataMessage message) {
		super();
		this.message = message;
	}

	public SpocitanaDataMessage call() throws Exception {
		System.out.println("Pocitaji se data stroje: " + message.getStroj());

		Thread.sleep(10000);

		return new SpocitanaDataMessage();
	}

}
