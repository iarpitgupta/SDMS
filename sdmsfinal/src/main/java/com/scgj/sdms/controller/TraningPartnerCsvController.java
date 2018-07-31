package com.scgj.sdms.controller;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.scgj.sdms.interfaces.IAppContsants;
import com.scgj.sdms.model.Application;
import com.scgj.sdms.model.AssessmentAgency;
import com.scgj.sdms.model.TrainingPartner;
import com.scgj.sdms.service.ApplicationService;
import com.scgj.sdms.service.AssessmentAgencyService;
import com.scgj.sdms.service.TrainingPartnerService;
import com.scgj.sdms.model.TrainingPartner;
import com.scgj.sdms.service.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
@RequestMapping("/save")
@Controller
public class TraningPartnerCsvController {
    private TrainingPartner trainingPartner;
    private static final String CSV_FILE_PATH = "C:\\New folder\\sdms\\sdms\\src\\main\\resources\\src\\tp.csv";
    @Autowired
    TrainingPartnerService trainingPartnerService;
    @Autowired
    ApplicationService applicationService;
    @Autowired
    UploadFileService uploadFileService;
    Application application;

    @PostMapping("/tp")
    public ModelAndView saveTrainingPartner(@RequestParam("csv")MultipartFile multipartFile, @RequestParam("filedatatype")String type, @RequestParam(value = "userId",required = false) String userId) {
        try {
            String saveFilePath=uploadFileService.uploadFile(multipartFile,type,"surbhi");
            saveFilePath=IAppContsants.UPLOADFOLDER +"/"+ saveFilePath;
            Reader reader = Files.newBufferedReader(Paths.get(saveFilePath));
            CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(2).build();
            System.out.println("I am here to save");
            String[] nextRecord;
            List<TrainingPartner> traningPartners=new LinkedList<TrainingPartner>();
            while ((nextRecord = csvReader.readNext()) != null) {
                System.out.println("nextRecord"+nextRecord[0]+" "+nextRecord[1]+" "+nextRecord[2]);
                trainingPartner = new TrainingPartner();
                System.out.println("nextRecord[0]"+nextRecord[0]);
                if (!(nextRecord[0].isEmpty()))
                trainingPartner.setTrainingPartnerId(nextRecord[0]);
                System.out.println("nextRecord[1]"+nextRecord[1]);
                if (!(nextRecord[1].isEmpty())) {
                    application = applicationService.findByApplicationId(Integer.valueOf(nextRecord[1]));
                    if (application == null) {
                        application = new Application();
                        application.setApplicationId(Integer.valueOf(nextRecord[1]));
                        applicationService.save(application);
                    }
                }
                if (application != null)
                    trainingPartner.setApplicationId(application);
                System.out.println("nextRecord[2]"+nextRecord[2]);
                trainingPartner.setTrainingPartnerName(nextRecord[2]);
                traningPartners.add(trainingPartner);
                //assessmentAgencyService.save(assessmentAgency);

            }
            for(TrainingPartner trainingPartner:traningPartners)
            {
                trainingPartnerService.save(trainingPartner);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
         ModelAndView modelAndView=new ModelAndView("importdata");
        modelAndView.addObject("success","File uploaded successfully");
        return modelAndView;
}}
