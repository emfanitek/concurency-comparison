package cz.diribet.test.concurent.akka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import cz.diribet.test.concurent.akka.actor.Master;
import cz.diribet.test.concurent.message.SpustitVypocet;

public class AkkaMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ActorSystem system = ActorSystem.create("VypocetSystem");

	    // create the result listener, which will print the result and shutdown the system
//	    final ActorRef listener = system.actorOf(Props.create(Listener.class), "listener");

	    // create the master
	    ActorRef master = system.actorOf(Props.create(Master.class, 5), "master");

	    // start the calculation
	    master.tell(new SpustitVypocet(), null);
	}

}
