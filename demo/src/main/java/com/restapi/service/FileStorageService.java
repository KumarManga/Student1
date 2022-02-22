//package com.restapi.service;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.nio.file.StandardCopyOption;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.util.StringUtils;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.restapi.exceptionhandlingconroller.StudentResourceNotFoundException;
//import com.restapi.filedemo.FileStorageProperties;
//
//@Service
//public class FileStorageService {
//	
//	 private final Path fileStorageLocation;
//
//	    @Autowired
//	    public FileStorageService(FileStorageProperties fileStorageProperties) {
//	        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
//	                .toAbsolutePath().normalize();
//	        System.out.println("ceckinng ,......");
//
//	        try {
//	        	
//	            Files.createDirectories(this.fileStorageLocation);
//	        } catch (Exception ex) {
//	            throw new StudentResourceNotFoundException("Could not create the directory where the uploaded files will be stored.", ex);
//	        }
//	    }
//
//	    public String storeFile(MultipartFile file) throws IOException {
//	        // Normalize file name
//	        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//
//	        try {
//	            // Check if the file's name contains invalid characters
//	            if(fileName.contains("..")) {
//	                throw new StudentResourceNotFoundException("Sorry! Filename contains invalid path sequence " + fileName);
//	            }
//
//	            // Copy file to the target location (Replacing existing file with the same name)
//	            Path targetLocation = this.fileStorageLocation.resolve(fileName);
//	            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
//
//	            return fileName;
//	        } catch (Exception ex) {
//	            throw new StudentResourceNotFoundException("null");
//	        }
//	    }
//
//}
