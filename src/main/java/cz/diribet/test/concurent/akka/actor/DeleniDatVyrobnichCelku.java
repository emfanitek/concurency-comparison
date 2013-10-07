package cz.diribet.test.concurent.akka.actor;

import java.util.List;

import akka.actor.UntypedActor;

import com.google.common.collect.Lists;

import cz.diribet.test.concurent.domain.DataVyrobnihoCelku;
import cz.diribet.test.concurent.message.NajitARozdelitDataMessage;
import cz.diribet.test.concurent.message.RozdelenaDataMessage;

public class DeleniDatVyrobnichCelku extends UntypedActor {

	@Override
	public void onReceive(Object msg) throws Exception {
		if (msg instanceof NajitARozdelitDataMessage) {
			NajitARozdelitDataMessage message = (NajitARozdelitDataMessage) msg;
			System.out.println("Rozdeluji se data stroje: " + message.getStroj());

			Thread.sleep(5000);

			List<DataVyrobnihoCelku> dataVyrobnichCelku = Lists.newArrayList(
																		new DataVyrobnihoCelku(Lists.newArrayList(1, 2)),
																		new DataVyrobnihoCelku(Lists.newArrayList(3, 4)));

			getSender().tell(new RozdelenaDataMessage(message.getStroj(), dataVyrobnichCelku), getSelf());
		} else {
			unhandled(msg);
		}
	}

}
