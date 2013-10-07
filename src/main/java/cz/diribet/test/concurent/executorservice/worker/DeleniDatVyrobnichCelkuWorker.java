package cz.diribet.test.concurent.executorservice.worker;

import java.util.List;
import java.util.concurrent.Callable;

import com.google.common.collect.Lists;

import cz.diribet.test.concurent.domain.DataVyrobnihoCelku;
import cz.diribet.test.concurent.domain.Stroj;
import cz.diribet.test.concurent.message.RozdelenaDataMessage;

public class DeleniDatVyrobnichCelkuWorker implements Callable<RozdelenaDataMessage> {

	private final Stroj stroj;

	public DeleniDatVyrobnichCelkuWorker(Stroj stroj) {
		super();
		this.stroj = stroj;
	}

	public RozdelenaDataMessage call() throws Exception {
		System.out.println("Rozdeluji se data stroje: " + stroj);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}

		List<DataVyrobnihoCelku> dataVyrobnichCelku = Lists.newArrayList(
																	new DataVyrobnihoCelku(Lists.newArrayList(1, 2)),
																	new DataVyrobnihoCelku(Lists.newArrayList(3, 4)));

		return new RozdelenaDataMessage(stroj, dataVyrobnichCelku);
	}

}
