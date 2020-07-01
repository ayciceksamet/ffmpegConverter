package com.converterplatform.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.converterplatform.service.ConverterService;

@RestController
public class ConverterController {

	@Autowired
	ConverterService converterService;

	@RequestMapping(value = "/convert/{inputFormat}/{outPutFormat}/{videoId}", method = RequestMethod.PUT)
	public ResponseEntity<Object> convertVideo(@PathVariable("videoId") String videoId,
			@PathVariable("inputFormat") String inputFormat, @PathVariable("outPutFormat") String outPutFormat)
			throws IOException, InterruptedException {
		converterService.convertVideo(videoId, inputFormat, outPutFormat);
		return new ResponseEntity<>("Convertion is completed successsfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/convert/{inputFormat}/{outPutFormat}/{videoId}/{videoWidth}/{videoHeight}", method = RequestMethod.PUT)
	public ResponseEntity<Object> convertMp42Flv(@PathVariable("videoId") String videoId,
			@PathVariable("inputFormat") String inputFormat, @PathVariable("outPutFormat") String outPutFormat,
			@PathVariable("videoWidth") String videoWidth, @PathVariable("videoHeight") String videoHeight)
			throws IOException, InterruptedException {
		converterService.convertVideoByScaling(videoId, inputFormat, outPutFormat, videoWidth, videoHeight);
		return new ResponseEntity<>("Convertion is completed successsfully", HttpStatus.OK);
	}

}
