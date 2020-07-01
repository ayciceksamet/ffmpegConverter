package com.converterplatform.service;

import java.io.IOException;

public interface ConverterService {
	
	 public abstract void convertVideo(String videoId, String inputFormat, String outputFormat) throws IOException, InterruptedException;
	 
	 public abstract void convertVideoByScaling(String videoId, String inputFormat, String outputFormat, String videoWidth, String videoHeight) throws IOException, InterruptedException;

	

}
