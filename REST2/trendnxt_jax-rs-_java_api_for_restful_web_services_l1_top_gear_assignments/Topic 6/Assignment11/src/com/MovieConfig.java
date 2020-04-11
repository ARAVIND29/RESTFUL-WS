package com;

import org.glassfish.jersey.server.ResourceConfig;

public class MovieConfig extends ResourceConfig {
	public MovieConfig() {
		packages("com");
	}
}
