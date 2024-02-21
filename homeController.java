package com.sts.ProductList.controller;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sts.ProductList.entity.Student;
import com.sts.ProductList.service.StudentService;

@RestController
public class homeController {
	
	@Autowired
	private StudentService studentService;
	//api for testing purpose
	
	public static String uploadDirectory = System.getProperty("user.dir") + "/src/main/webapp/images";

	@GetMapping("/")
	public String home() {
		return "Welcome to image uploading app in spring boot!!" ;
	}
	//Saving the student data in database
	@PostMapping("/saveData")
	public Student saveStudent(@ModelAttribute Student student,
	         @RequestParam("image") MultipartFile file) throws IOException {
		String originalFilename = file.getOriginalFilename();
		Path fileNameAndPath = Paths.get(uploadDirectory, originalFilename);
		System.out.println("File Path: " + fileNameAndPath); // Add this line for debugging
		Files.write(fileNameAndPath, file.getBytes());

		student.setProfileImage (originalFilename);
		Student savedStudentData = studentService.saveStudentData(student);
		return savedStudentData;
	}
}
