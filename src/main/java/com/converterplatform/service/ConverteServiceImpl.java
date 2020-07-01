package com.converterplatform.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.bytedeco.javacpp.Loader;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.google.common.base.Strings;

@Service
public class ConverteServiceImpl implements ConverterService {

	
	private static final String sourceDirectory =  "D:/convertedVideos/";

	@Override
	public void convertVideo(String videoId, String inputFormat, String outputFormat) throws IOException, InterruptedException {
		
		Strings.isNullOrEmpty(videoId);

		String ffmpeg = Loader.load(org.bytedeco.ffmpeg.ffmpeg.class);

		File file = new File(sourceDirectory);

		if (!file.exists()) {
			System.out.print("No Folder");
			file.mkdir();
			System.out.print("Folder created");
		}

		String sourcePath = generateFormatVideo(videoId, inputFormat);
		String outputPath = generateFormatVideo(videoId, outputFormat);

		ProcessBuilder pb = new ProcessBuilder(ffmpeg, "-i", sourcePath, "-ar", "44100", "-s", 300 + "*" + 200,
				outputPath);

		Process process = pb.start();
		InputStream stderr = process.getErrorStream();
		InputStreamReader isr = new InputStreamReader(stderr);

		BufferedReader br = new BufferedReader(isr);
		String line;
		while ((line = br.readLine()) != null);
		{
			System.out.println(line);
		}
		int exitCode = process.waitFor();

		System.out.println(exitCode);
	}


	@Override
	public void convertVideoByScaling(String videoId, String inputFormat, String outputFormat, String videoWidth, String videoHeight) throws IOException, InterruptedException {
		Strings.isNullOrEmpty(videoId);

		String ffmpeg = Loader.load(org.bytedeco.ffmpeg.ffmpeg.class);

		File file = new File(sourceDirectory);

		if (!file.exists()) {
			System.out.print("No Folder");
			file.mkdir();
			System.out.print("Folder created");
		}

		String sourcePath = generateFormatVideo(videoId, inputFormat);
		String outputPath = generateFormatVideo(videoId, outputFormat);

		ProcessBuilder pb = new ProcessBuilder(ffmpeg, "-i", sourcePath, "-ar", "44100", "-s", Integer.parseInt(videoWidth) + "*" +  Integer.parseInt(videoHeight),outputPath);

		Process process = pb.start();
		InputStream stderr = process.getErrorStream();
		InputStreamReader isr = new InputStreamReader(stderr);

		BufferedReader br = new BufferedReader(isr);
		String line;
		while ((line = br.readLine()) != null);
		{
			System.out.println(line);
		}
		int exitCode = process.waitFor();

		System.out.println(exitCode);

	}
	

	private String generateFormatVideo(String videoName, String type) {

		StringBuilder videoFormatted = new StringBuilder();

		videoFormatted.append(sourceDirectory + videoName + "." + type);

		return videoFormatted.toString();

	}

}
