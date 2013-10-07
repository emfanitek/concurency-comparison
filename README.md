concurency-comparison
=====================

Comparison of Akka Actors vs GPars Actors vs JDK ExecutorService

- Akka Actors
	- remote actors
	 
- GPars Actors
	- no load balancing / routing of messages to actors
	- user has to create appropriate number of actors?
	
- JDK Executor service
	- use Guava callbacks to chain workers - this results in messy code
	- reusable workers
	- no remoting