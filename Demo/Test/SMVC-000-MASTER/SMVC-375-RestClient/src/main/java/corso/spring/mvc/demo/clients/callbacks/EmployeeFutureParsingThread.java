package corso.spring.mvc.demo.clients.callbacks;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import corso.spring.mvc.demo.rest.beans.Employee;

public class EmployeeFutureParsingThread implements Runnable{

	private Future<Employee> employeeFuture;
	
	public EmployeeFutureParsingThread(Future<Employee> employeeFuture){
		this.employeeFuture=employeeFuture;
	}
	
	@Override
	public void run() {
		try {
			while(this.employeeFuture.isDone()){
				Employee employee = this.employeeFuture.get();
				System.out.println(employee);
			}
		
		
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
	}

}
