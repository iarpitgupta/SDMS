package com.scgj.sdms.controller;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.scgj.sdms.interfaces.IAppContsants;
import com.scgj.sdms.model.Application;
import com.scgj.sdms.model.AssessmentAgency;
import com.scgj.sdms.model.Assessor;
import com.scgj.sdms.model.Location;
import com.scgj.sdms.service.*;
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
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@RequestMapping("/save")
@Controller
public class AssessorCsvController {

    private Assessor assessor;
    private AssessmentAgency assessmentAgency;
    private static final String CSV_FILE_PATH = "C:\\New folder\\sdms\\sdms\\src\\main\\resources\\src\\assessor1.csv";
    @Autowired
    AssessorService assessorService;
    @Autowired
    AssessmentAgencyService assessmentAgencyService;
    @Autowired
    LocationService locationService;
    Location location;
    @Autowired
    UploadFileService uploadFileService;

    @PostMapping("/assessor")
    public ModelAndView saveAgencyCsv(@RequestParam("csv") MultipartFile multipartFile, @RequestParam(value = "filedatatype") String type, @RequestParam(value = "userId",required = false) String userId) {
        try
        {
            String saveFilePath=uploadFileService.uploadFile(multipartFile,type,"surbhi");
            saveFilePath=IAppContsants.UPLOADFOLDER +"/"+ saveFilePath;
            Reader reader = Files.newBufferedReader(Paths.get(saveFilePath));
            CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(2).build();
            //System.out.println("filetype"+filetype);
            //System.out.println("I am here to save");
            String[] nextRecord;
            List<Assessor> assessmentAgencies = new LinkedList<Assessor>();
            while ((nextRecord = csvReader.readNext()) != null) {
                System.out.println("In while");
                System.out.println("nextRecord" + nextRecord[0] + " " + nextRecord[1] + " " + nextRecord[2] + " " + nextRecord[3] + " " + nextRecord[4]);
                assessor = new Assessor();
                //System.out.println("nextRecord[0]"+nextRecord[0]);
                if (!(nextRecord[0].isEmpty())) ;
                assessor.setAssesorId(Integer.valueOf(nextRecord[0]));
                //System.out.println("nextRecord[1]"+nextRecord[1]);
                assessor.setAssesorName(nextRecord[1]);
                //  if (!(nextRecord[1].isEmpty())) {
                location = locationService.findByDistrictAndState(nextRecord[2], nextRecord[3]);
                if (location == null) {
                    location = new Location();
                    location.setState(nextRecord[3]);
                    location.setDistrict(nextRecord[2]);
                    location = locationService.save(location);
                }
                if (location != null)
                    assessor.setLocationId(location);
                //System.out.println("nextRecord[2]"+nextRecord[2]);
                if (!(nextRecord[4].isEmpty())) {
                    assessmentAgency = assessmentAgencyService.findByAgencyId(Integer.valueOf(nextRecord[4]));
                    if (assessmentAgency == null) {
                        assessmentAgency = new AssessmentAgency();
                        assessmentAgency.setAgencyId(Integer.valueOf(nextRecord[4]));
                        assessmentAgencyService.save(assessmentAgency);
                    }
                }
                if (assessmentAgency != null)
                    assessor.setAgencyId(assessmentAgency);
                assessorService.save(assessor);


                //assessmentAgencyService.save(assessmentAgency);

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
