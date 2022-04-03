package com.mypractice.listeners;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class ContainerMonitoringListener implements ApplicationListener {
	private long pStart,cStart,pEnd,cEnd;

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println("ContainerMonitoringListener.onApplicationEvent [ event ="+ event+"]");
		if(event.toString().contains("parent") && event.toString().contains("Refreshed"))
			cStart=System.currentTimeMillis();
		else if(event.toString().contains("parent") && event.toString().contains("Closed")) {
			cEnd=System.currentTimeMillis();
			System.out.println("child container has taken "+(cEnd-cStart)+" ms");
		}
		
		if(event.toString().contains("Refreshed")&&!event.toString().contains("parent"))
			pStart=System.currentTimeMillis();
		else if(event.toString().contains("Closed") && !event.toString().contains("parent")) {
			pEnd=System.currentTimeMillis();
			System.out.println("parent container has taken "+(pEnd-pStart)+" ms");
		}
		
		
			
		
	 
	}

}
