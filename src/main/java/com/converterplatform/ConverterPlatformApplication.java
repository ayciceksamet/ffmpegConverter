package com.converterplatform;

import org.bytedeco.javacpp.Loader;

import static org.bytedeco.ffmpeg.global.avformat.*;
import static org.bytedeco.ffmpeg.global.avutil.*;
import static org.bytedeco.ffmpeg.global.swscale.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConverterPlatformApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(ConverterPlatformApplication.class, args);
		
	
	 
	}
	
	

}
