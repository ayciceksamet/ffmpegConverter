package com.converterplatform;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.bytedeco.javacpp.Loader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConverterController {





	private static final String template = "Hello, %s!";


	@GetMapping("/convert")
	public String greeting() throws IOException {
		 String ffmpeg = Loader.load(org.bytedeco.ffmpeg.ffmpeg.class);
		 
		 //org.bytedeco.ffmpeg.ffmpeg ffmeg = new org.bytedeco.ffmpeg.ffmpeg();
		 
	     ProcessBuilder pb = new ProcessBuilder(ffmpeg, "-i", "D:/sample.flv", "-ar", "44100",
                 "-s", 300 + "*" + 200, "D:/sample4.mp4");
	     
	  
	        Process process = pb.start();
	        InputStream stderr = process.getErrorStream();
	        InputStreamReader isr = new InputStreamReader(stderr);
	        BufferedReader br = new BufferedReader(isr);
	        String line;
	        while ((line = br.readLine()) != null) ;
	        {
	        }
		return "200 OK";
	}


}
