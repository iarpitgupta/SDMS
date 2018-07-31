package com.scgj.sdms.controller;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.scgj.sdms.interfaces.IAppContsants;
import com.scgj.sdms.model.Application;
import com.scgj.sdms.model.Trainer;
import com.scgj.sdms.model.TrainingPartner;
import com.scgj.sdms.service.ApplicationService;
import com.scgj.sdms.service.TrainerService;
import com.scgj.sdms.service.TrainingPartnerService;
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
public class TrainerCsvController {

    private TrainingPartner trainingPartner;
    private Trainer trainer;
   // private static final String CSV_FILE_PATH = "C:\\New folder\\sdms\\sdms\\src\\main\\resources\\src\\trainer.csv";
    @Autowired
    TrainingPartnerService trainingPartnerService;
    @Autowired
    UploadFileService uploadFileService;
    @Autowired
    TrainerService trainerService;
    @PostMapping("/trainer")
    public ModelAndView saveTrainerCsv(@RequestParam("csv")MultipartFile multipartFile, @RequestParam("filedatatype")String type, @RequestParam(value = "userId",required = false) String userId) {
        try {
            String saveFilePath=uploadFileService.uploadFile(multipartFile,type,"surbhi");
            saveFilePath=IAppContsants.UPLOADFOLDER +"/"+ saveFilePath;
            Reader reader = Files.newBufferedReader(Paths.get(saveFilePath));
            CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(2).build();
            System.out.println("I am here to save");
            String[] nextRecord;
            List<Trainer> trainers=new LinkedList<Trainer>();
            while ((nextRecord = csvReader.readNext()) != null) {
                //System.out.println("nextRecord"+nextRecord[0]+" "+nextRecord[1]+" "+nextRecord[2]);
                trainer = new Trainer();
                //System.out.println("nextRecord[0]"+nextRecord[0]);
                if (!(nextRecord[0].isEmpty()))
                trainer.setTrainerId(Long.parseLong(nextRecord[0]));
                System.out.println("nextRecord[1]"+nextRecord[1]);
                if (!(nextRecord[3].isEmpty())) {
                    trainingPartner = trainingPartnerService.findByTainingPartnerId(nextRecord[3]);
                }
                if (trainingPartner != null)
                    trainer.setTrainingPartnerId(trainingPartner);
               // System.out.println("nextRecord[2]"+nextRecord[2]);
                trainer.setTrainerName(nextRecord[1]);
                trainer.setDesignation(nextRecord[2]);
                trainers.add(trainer);
                //assessmentAgencyService.save(assessmentAgency);

            }
            for(Trainer trainer:trainers)
            {
                trainerService.save(trainer);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        ModelAndView modelAndView=new ModelAndView("importdata");
        modelAndView.addObject("success","File uploaded successfully");
        return modelAndView;
    }
}
