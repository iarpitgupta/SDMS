//package com.scgj.sdms.controller;
//import  java.io.BufferedOutputStream;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//
//import com.scgj.sdms.service.UploadFileService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.stereotype.Service;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.MultipartFile;
//
//@Controller
//public class FileUploadController {
//    @Autowired
//    UploadFileService uploadFileService;
//    // Handling file upload request
//    @PostMapping("/save/*")
//    public String fileUpload(@RequestParam("csv") MultipartFile multipartFile, @RequestParam(value = "filedatatype") String type, @RequestParam(value = "userId",required = false) String userId, @PathVariable String filetype)
//            throws IOException {
//                System.out.println("path variable"+filetype);
//                return  uploadFileService.uploadFile(multipartFile,"batch","surbhi");
//
////        // Save file on system
////        if (!file.getOriginalFilename().isEmpty()) {
////            BufferedOutputStream outputStream = new BufferedOutputStream(
////                    new FileOutputStream(
////                            new File("Upload", file.getOriginalFilename())));
////            outputStream.write(file.getBytes());
////            outputStream.flush();
////            outputStream.close();
////        }else{
////            return new ResponseEntity<>("Invalid file.",HttpStatus.BAD_REQUEST);
////        }
////
////        return new ResponseEntity<>("File Uploaded Successfully.",HttpStatus.OK);
//    }
//}