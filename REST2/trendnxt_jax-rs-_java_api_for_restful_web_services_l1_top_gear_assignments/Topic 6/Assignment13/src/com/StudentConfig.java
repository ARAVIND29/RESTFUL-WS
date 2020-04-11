package com;

import org.glassfish.jersey.server.ResourceConfig;

public class StudentConfig extends ResourceConfig {
	public StudentConfig() {
		packages("com");
	}
	
}
