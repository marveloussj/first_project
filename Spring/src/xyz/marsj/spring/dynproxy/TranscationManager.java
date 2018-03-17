package xyz.marsj.spring.dynproxy;

import org.springframework.stereotype.Component;

@Component
public class TranscationManager {
	public void begin(){
		System.out.println("session.getTranscation.begin()");
	}
	public void commit(){
		System.out.println("session.getTranscation.commit()");
	}
	public void rollback(){
		System.out.println("session.getTranscation.rollback()");
	}
}
