package com.scgj.sdms.service;

import com.scgj.sdms.interfaces.IAppContsants;
import com.scgj.sdms.interfaces.ImportHistoryRepository;
import com.scgj.sdms.model.ImportHistory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
@Service
public class UploadFileService {
    @Autowired
    ImportHistoryRepository importHistoryRepository;
        public @ResponseBody String uploadFile(MultipartFile multipartFile,String type,String userId) throws IOException {
            String folderUpload = IAppContsants.UPLOADFOLDER;
            if (multipartFile.isEmpty()) {
                return "empty file";
            }
            ImportHistory importHistory;
            //LocalDateTime localDateTime = LocalDateTime.now();
            String fileNameReceived = multipartFile.getOriginalFilename();
            byte[] fileByteArray = multipartFile.getBytes();
            File folder = new File(folderUpload);
            if (!folder.exists()) {
                if (folder.mkdirs() || folder.canWrite()) {
                    System.out.println("folder created successfully");
                } else {
                    return "Cannot process further";
                }
            }
            int year=LocalDateTime.now().getYear();
            int month=LocalDateTime.now().getMonthValue();
            int day=LocalDateTime.now().getDayOfMonth();
            int hour=LocalDateTime.now().getHour();
            int minute=LocalDateTime.now().getMinute();
            String saveFile=fileNameReceived+"_"+year+"_"+month+"_"+day+"_"+hour+"_"+minute+".csv";
            Path path = Paths.get(folderUpload +"/"+ saveFile);
            System.out.println("path"+path);

            try {
                Files.write(path, fileByteArray);
                importHistory=new ImportHistory();
                importHistory.setDataType(type);
                importHistory.setFileName(saveFile);
                importHistory.setUploadedBy(userId);
                importHistory.setUploadedDate(new Date());
                ImportHistory importHistory1=importHistoryRepository.save(importHistory);
                if(importHistory1!=null)
                {
                    System.out.println("History created successfully");
                }
                return saveFile;
            } catch (Exception e) {
                System.out.println(e);
                return "Error Saving file on Local Machine.Try Again later ";
            }
        }

        private File convertMultiPartToFile(MultipartFile file) throws IOException {
            File convFile = new File(file.getOriginalFilename());
            FileOutputStream fos = new FileOutputStream(convFile);
            fos.write(file.getBytes());
            fos.close();
            return convFile;
        }
}

