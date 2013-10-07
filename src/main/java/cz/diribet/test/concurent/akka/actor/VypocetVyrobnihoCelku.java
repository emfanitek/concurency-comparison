package cz.diribet.test.concurent.akka.actor;

import akka.actor.UntypedActor;
import cz.diribet.test.concurent.message.SpocitanaDataMessage;
import cz.diribet.test.concurent.message.SpocitatDataMessage;

public class VypocetVyrobnihoCelku extends UntypedActor {

	@Override
	public void onReceive(Object msg) throws Exception {
		if (msg instanceof SpocitatDataMessage) {
			SpocitatDataMessage message = (SpocitatDataMessage) msg;
			System.out.println("Pocitaji se data stroje: " + message.getStroj());

			Thread.sleep(10000);

			getSender().tell(new SpocitanaDataMessage(), getSelf());

		} else {
			unhandled(msg);
		}
	}


}
