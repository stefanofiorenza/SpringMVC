package corso.spring.mvc.demo.clients.callbacks;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.omg.PortableServer.THREAD_POLICY_ID;

import lombok.extern.slf4j.Slf4j;
import corso.spring.mvc.demo.rest.beans.Employee;

@Slf4j
public class EmployeeFutureParsingThread implements Runnable{

	private Future<Employee> employeeFuture;
	
	public EmployeeFutureParsingThread(Future<Employee> employeeFuture){
		this.employeeFuture=employeeFuture;
	}
	
	@Override
	public void run() {
		try {
			while(!this.employeeFuture.isDone()){
				Thread.currentThread().sleep(200L);// try every 200 millis
			}
			// done
			Employee employee = this.employeeFuture.get();
			log.info(employee.toString());
		
		
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
	}

}
