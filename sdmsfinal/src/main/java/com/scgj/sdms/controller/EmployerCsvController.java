package com.scgj.sdms.controller;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.scgj.sdms.interfaces.IAppContsants;
import com.scgj.sdms.model.AssessmentAgency;
import com.scgj.sdms.model.Assessor;
import com.scgj.sdms.model.Employer;
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
import java.util.LinkedList;
import java.util.List;
@RequestMapping("/save")
@Controller
public class EmployerCsvController {
    private Employer employer;
    //private static final String CSV_FILE_PATH = "C:\\New folder\\sdms\\sdms\\src\\main\\resources\\src\\employer.csv";
   @Autowired
    EmployerService employerService;
    @Autowired
    LocationService locationService;
    @Autowired
    UploadFileService uploadFileService;
    private Location location;

    @PostMapping("/employer")
    public ModelAndView saveEmployerCsv(@RequestParam("csv")MultipartFile multipartFile, @RequestParam("filedatatype")String type, @RequestParam(value = "userId",required = false) String userId) {
        try
        {
            String saveFilePath=uploadFileService.uploadFile(multipartFile,type,"surbhi");
            saveFilePath=IAppContsants.UPLOADFOLDER +"/"+ saveFilePath;
            Reader reader = Files.newBufferedReader(Paths.get(saveFilePath));
            CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(2).build();
            //System.out.println("I am here to save");
            String[] nextRecord;
            List<Assessor> assessmentAgencies = new LinkedList<Assessor>();
            while ((nextRecord = csvReader.readNext()) != null) {
                System.out.println("In while");
                System.out.println("nextRecord" + nextRecord[0] + " " + nextRecord[1] + " " + nextRecord[2] + " " + nextRecord[3] + " " + nextRecord[4]);
                employer= new Employer();
                //System.out.println("nextRecord[0]"+nextRecord[0]);
                if (!(nextRecord[0].isEmpty())) ;
                employer.setEmployerId(Integer.valueOf(nextRecord[0]));
                //System.out.println("nextRecord[1]"+nextRecord[1]);
                employer.setEmployerName(nextRecord[1]);
                //  if (!(nextRecord[1].isEmpty())) {
                location = locationService.findByDistrictAndState(nextRecord[3], nextRecord[4]);
                if (location == null) {
                    location = new Location();
                    location.setState(nextRecord[4]);
                    location.setDistrict(nextRecord[3]);
                    location = locationService.save(location);
                }
                if (location != null)
                    employer.setLocationId(location);
                employer.setLocationOfEmployer(nextRecord[2]);
                //System.out.println("nextRecord[2]"+nextRecord[2]);
                    employerService.save(employer);
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
