package com;

import org.glassfish.jersey.server.ResourceConfig;

public class EmployeeConfig extends ResourceConfig {
	public EmployeeConfig() {
		packages("com");
	}
}
