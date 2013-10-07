package cz.diribet.test.concurent.executorservice;

import java.util.concurrent.Executors;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import cz.diribet.test.concurent.domain.DataVyrobnihoCelku;
import cz.diribet.test.concurent.domain.Stroj;
import cz.diribet.test.concurent.executorservice.worker.DeleniDatVyrobnichCelkuWorker;
import cz.diribet.test.concurent.executorservice.worker.VypocetVyrobnihoCelkuWorker;
import cz.diribet.test.concurent.message.RozdelenaDataMessage;
import cz.diribet.test.concurent.message.SpocitanaDataMessage;
import cz.diribet.test.concurent.message.SpocitatDataMessage;

public class ExecutorServiceMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ListeningExecutorService deleniDatExecutorService = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(5));
		final ListeningExecutorService vypocetDatExecutorService = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(5));

		for (int i = 1; i < 20; i++) {
			DeleniDatVyrobnichCelkuWorker deleniDatWorker = new DeleniDatVyrobnichCelkuWorker(new Stroj(i, "Stroj " + i));
			ListenableFuture<RozdelenaDataMessage> rozdelenaDataFuture = deleniDatExecutorService.submit(deleniDatWorker);

			Futures.addCallback(rozdelenaDataFuture, new FutureCallback<RozdelenaDataMessage>() {

				public void onFailure(Throwable arg0) {
					// TODO Auto-generated method stub
				}

				public void onSuccess(RozdelenaDataMessage message) {
					System.out.println("Data stroje se muzou pocitat: " + message.getStroj());

					for (DataVyrobnihoCelku dataVyrobnihoCelku : message.getData()) {
						SpocitatDataMessage spocitatDataMessage = new SpocitatDataMessage(message.getStroj(), dataVyrobnihoCelku);
						ListenableFuture<SpocitanaDataMessage> vypocetFuture = vypocetDatExecutorService.submit(new VypocetVyrobnihoCelkuWorker(spocitatDataMessage));

						Futures.addCallback(vypocetFuture, new FutureCallback<SpocitanaDataMessage>() {

							public void onFailure(Throwable arg0) {
								// TODO Auto-generated method stub
							}

							public void onSuccess(SpocitanaDataMessage arg0) {

							}
						});
					}
				}
			});
		}
	}

}
