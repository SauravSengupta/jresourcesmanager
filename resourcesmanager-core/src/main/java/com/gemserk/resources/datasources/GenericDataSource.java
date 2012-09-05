package com.gemserk.resources.datasources;

import java.io.InputStream;
import java.net.URI;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import com.badlogic.gdx.utils.Logger;

/**
 * Generic implementation of DataSource interface which uses directly an InputStream.
 * 
 * @author acoppes
 * 
 */
public class GenericDataSource implements DataSource {

	//protected static final Logger logger = LoggerFactory.getLogger(ClassPathDataSource.class);
	protected static final Logger logger = new Logger(ClassPathDataSource.class.getSimpleName());

	private final InputStream inputStream;

	private final String resourceName;

	public GenericDataSource(InputStream inputStream, String resourceName) {
		this.inputStream = inputStream;
		this.resourceName = resourceName;
	}

	@Override
	public URI getUri() {
		throw new RuntimeException("getUri not implemented yet");
	}

	@Override
	public String getResourceName() {
		return resourceName;
	}

	@Override
	public InputStream getInputStream() {
		//if (logger.isInfoEnabled())
		if (logger.getLevel() >= Logger.INFO)
			logger.info("returning static input stream " + getResourceName());
		return inputStream;
	}
}