package cz.diribet.test.concurent.gpars.actor;

import groovyx.gpars.ReactorMessagingRunnable;
import groovyx.gpars.actor.ReactiveActor;

import java.util.List;

import com.google.common.collect.Lists;

import cz.diribet.test.concurent.domain.DataVyrobnihoCelku;
import cz.diribet.test.concurent.message.NajitARozdelitDataMessage;
import cz.diribet.test.concurent.message.RozdelenaDataMessage;

public class DeleniDatVyrobnichCelku extends ReactiveActor {

	public DeleniDatVyrobnichCelku() {
		super(new ReactorMessagingRunnable<NajitARozdelitDataMessage, RozdelenaDataMessage>() {

			@Override
			protected RozdelenaDataMessage doRun(NajitARozdelitDataMessage message) {
				System.out.println("Rozdeluji se data stroje: " + message.getStroj());

				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
				}

				List<DataVyrobnihoCelku> dataVyrobnichCelku = Lists.newArrayList(
																			new DataVyrobnihoCelku(Lists.newArrayList(1, 2)),
																			new DataVyrobnihoCelku(Lists.newArrayList(3, 4)));

				return new RozdelenaDataMessage(message.getStroj(), dataVyrobnichCelku);
			}
		});
	}

}
