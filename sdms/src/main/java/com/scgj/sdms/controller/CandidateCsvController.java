package com.scgj.sdms.controller;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.scgj.sdms.interfaces.IAppContsants;
import com.scgj.sdms.model.Batch;
import com.scgj.sdms.model.Candidate;
import com.scgj.sdms.model.Employer;
import com.scgj.sdms.model.TrainingPartner;
import com.scgj.sdms.service.BatchService;
import com.scgj.sdms.service.CandidateService;
import com.scgj.sdms.service.EmployerService;
import com.scgj.sdms.service.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
@RequestMapping("/save")
@Controller
public class CandidateCsvController {
    @Autowired
    CandidateService candidateService;
    @Autowired
    EmployerService employerService;
    @Autowired
    BatchService batchService;
    @Autowired
    UploadFileService uploadFileService;
    private Batch batch;
    private Employer employer;
    private Candidate candidate;
    private static final String CSV_FILE_PATH = "C:\\New folder\\sdms\\sdms\\src\\main\\resources\\src\\candidate.csv";

   @PostMapping("/candidate")
    public ModelAndView saveCandidate(@RequestParam("csv") MultipartFile multipartFile, @RequestParam(value = "filedatatype") String type, @RequestParam(value = "userId",required = false) String userId) throws ParseException {
        try
        {
            String saveFilePath=uploadFileService.uploadFile(multipartFile,type,"surbhi");
            saveFilePath=IAppContsants.UPLOADFOLDER +"/"+ saveFilePath;
            Reader reader = Files.newBufferedReader(Paths.get(saveFilePath));
            CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(2).build();
            //System.out.println("filetype"+filetype);
            String[] nextRecord;
            List<Candidate> candidateList=new LinkedList<Candidate>();
            while ((nextRecord = csvReader.readNext()) != null) {
                SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
                String datePatterns[]={"dd-MM-yyyy","dd/MM/yyyy"};
                candidate=new Candidate();
                candidate.setCandidateId(nextRecord[0]);
                candidate.setCandidateName(nextRecord[1]);
                if(!(nextRecord[2].isEmpty()))
                candidate.setEnrollmentNo(Long.parseLong(nextRecord[2]));
                candidate.setGender(nextRecord[3]);
                if(!(nextRecord[4].isEmpty()))
                candidate.setDob(DateUtils.parseDate(nextRecord[4],datePatterns));
                candidate.setNameOfFatherOrHusband(nextRecord[5]);
                if(!(nextRecord[6].isEmpty()))
                candidate.setAadharNo(Long.parseLong(nextRecord[6]));
                if(!(nextRecord[7].isEmpty()))
                candidate.setMobileNo(Long.parseLong(nextRecord[7]));
                candidate.setEmail(nextRecord[8]);
                candidate.setEducation(nextRecord[9]);
                candidate.setTraineeAddress(nextRecord[10]);
                if(!(nextRecord[11].isEmpty()))
                candidate.setTraineePinCode(Integer.valueOf(nextRecord[11]));
                if(!(nextRecord[12].isEmpty()))
                candidate.setMarksObtainerTheory(Integer.valueOf(nextRecord[12]));
                if(!(nextRecord[13].isEmpty()))
                candidate.setMarksObtainedPractical(Integer.valueOf(nextRecord[13]));
                candidate.setResult(nextRecord[14]);
                candidate.setCertified(nextRecord[15]);
                candidate.setPlacementStatus(nextRecord[16]);
                if(!(nextRecord[17]).isEmpty())
                 candidate.setDateOfJoining(DateUtils.parseDate(nextRecord[17],datePatterns));
                candidate.setEmploymentType(nextRecord[18]);
                if(!(nextRecord[19].isEmpty()))
                {
                    batch=batchService.findByBatchId(nextRecord[19]);
                }
                if(batch!=null)
                {
                    candidate.setBatchId(batch);
                }
                if(!(nextRecord[20].isEmpty()))
                {
                    employer=employerService.findByEmployerId(Long.parseLong(nextRecord[20]));
                }
                if(employer!=null)
                {
                    candidate.setEmployer(employer);
                }
                candidateService.save(candidate);

            }


        } catch (IOException e) {
            e.printStackTrace();
        }
       ModelAndView modelAndView=new ModelAndView("importdata");
       modelAndView.addObject("success","File uploaded successfully");
       return modelAndView;
    }
}
