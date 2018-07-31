package com.scgj.sdms.controller;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.scgj.sdms.interfaces.IAppContsants;
import com.scgj.sdms.model.*;
import com.scgj.sdms.service.*;
import com.scgj.sdms.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/**
 * @author surbhi garg
 * **/
@RequestMapping("/save")
@Controller
public class BatchCsvController {
    private Batch batch;
    private static final String CSV_FILE_PATH = "C:\\New folder\\sdms\\sdms\\src\\batch.csv";
    private Centre centre;
    private TrainingPartner trainingPartner,trainingPartnerRes;
    private AssessmentAgency assessmentAgency;
    private JobRole jobRole;
    private Assessor assessor;
    private Trainer trainer;
    @Autowired
    CentreService centreService;
    @Autowired
    TrainerService trainerService;
    @Autowired
    AssessorService assessorService;
    @Autowired
    BatchService batchService;
    @Autowired
    TrainingPartnerService trainingPartnerService;
    @Autowired
    AssessmentAgencyService assessmentAgencyService;
    @Autowired
    JobRoleService jobRoleService;
    @Autowired
    UploadFileService uploadFileService;
    @PostMapping("/batch")
    public ModelAndView saveBatchFile(@RequestParam("csv") MultipartFile multipartFile, @RequestParam(value = "filedatatype") String type, @RequestParam(value = "userId",required = false) String userId) throws ParseException
    {
        try{
            //System.out.println("path variable"+filetype);
            String saveFilePath=uploadFileService.uploadFile(multipartFile,type,"surbhi");
            saveFilePath=IAppContsants.UPLOADFOLDER +"/"+ saveFilePath;
            Reader reader = Files.newBufferedReader(Paths.get(saveFilePath));
            CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(2).build();
            //Scanner scanner=new Scanner(new File(CSV_FILE_PATH))
                String[] nextRecord;
                List<Batch> batchList=new LinkedList<Batch>();
                 while ((nextRecord = csvReader.readNext()) != null) {
                {
                    //initializing batch details with argument lists
                    batch=new Batch(nextRecord);
                    //checking relational data
                    trainingPartner=trainingPartnerService.findByTainingPartnerId(nextRecord[3]);
                    if(!(nextRecord[4].isEmpty()))
                    {
                        Long parsedCentre=Long.parseLong(nextRecord[4].trim());
                        System.out.println("parse"+parsedCentre);
                        centre=centreService.findCentreById(parsedCentre);
                    }
                        if(!(nextRecord[5].isEmpty()))
                        trainer=trainerService.findByTrainerId(Long.valueOf(nextRecord[5].trim()));
                        if(!(nextRecord[23].isEmpty()))
                        assessmentAgency=assessmentAgencyService.findByAgencyId(Integer.valueOf(nextRecord[23].trim()));
                        if(!(nextRecord[24].isEmpty()))
                        assessor=assessorService.findByAssessorId(Integer.valueOf(nextRecord[24].trim()));

                        jobRole=jobRoleService.findByJobRole(nextRecord[10]);
                        if(jobRole==null)
                        {
                            jobRole=new JobRole();
                            jobRole.setJobRoleCode(nextRecord[11]);
                            jobRole.setJobRole(nextRecord[10]);
                            jobRole=jobRoleService.save(jobRole);

                        }

                    //setting relational data
                        if(trainer!=null)
                            batch.setTrainerId(trainer);
                        if(assessor!=null)
                            batch.setAssesorId(assessor);
                        if(assessmentAgency!=null)
                            batch.setAgencyId(assessmentAgency);
                        if(centre!=null)
                            batch.setCentreId(centre);
                        if(trainingPartner!=null)
                            batch.setTrainingPartnerId(trainingPartner);
                        batch.setJobRole(jobRole);
                        batchList.add(batch);
                }
            }
            for(Batch batch:batchList)
            {
                System.out.println( batchService.getData(batch));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        ModelAndView modelAndView=new ModelAndView("importdata");
        modelAndView.addObject("success","File uploaded successfully");
        return modelAndView;
    }
}
