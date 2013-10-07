package cz.diribet.test.concurent.akka.actor;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.routing.RoundRobinRouter;
import cz.diribet.test.concurent.domain.DataVyrobnihoCelku;
import cz.diribet.test.concurent.domain.Stroj;
import cz.diribet.test.concurent.message.NajitARozdelitDataMessage;
import cz.diribet.test.concurent.message.RozdelenaDataMessage;
import cz.diribet.test.concurent.message.SpocitatDataMessage;
import cz.diribet.test.concurent.message.SpustitVypocet;

public class Master extends UntypedActor {

	private ActorRef deleniDatRouter;
	private ActorRef vypocetRouter;

	public Master(final int nrOfWorkers/*, int nrOfMessages, int nrOfElements*/) {
		deleniDatRouter = this.getContext().actorOf(Props.create(DeleniDatVyrobnichCelku.class).withRouter(new RoundRobinRouter(nrOfWorkers)));
		vypocetRouter = this.getContext().actorOf(Props.create(VypocetVyrobnihoCelku.class).withRouter(new RoundRobinRouter(nrOfWorkers)));
	}

	@Override
	public void onReceive(Object msg) throws Exception {
		if (msg instanceof SpustitVypocet) {
			for (int i = 1; i < 20; i++) {
				deleniDatRouter.tell(new NajitARozdelitDataMessage(new Stroj(i, "Stroj " + i)), getSelf());
			}
		}

		if (msg instanceof RozdelenaDataMessage) {
			RozdelenaDataMessage rozdelenaDataMessage = (RozdelenaDataMessage) msg;
			System.out.println("Data stroje se muzou pocitat: " + rozdelenaDataMessage.getStroj());

			for (DataVyrobnihoCelku dataVyrobnihoCelku : rozdelenaDataMessage.getData()) {
				vypocetRouter.tell(new SpocitatDataMessage(rozdelenaDataMessage.getStroj(), dataVyrobnihoCelku), getSelf());
			}
		}

	}

}
