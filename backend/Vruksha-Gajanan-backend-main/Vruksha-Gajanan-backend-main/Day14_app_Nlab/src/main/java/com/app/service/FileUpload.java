package com.app.service;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUpload {
	
public String uploadFile(String url,MultipartFile file) {
			
		String originalFilename=file.getOriginalFilename();
		String randomImageName=UUID.randomUUID().toString();
		
		return null;
	}

	

}
