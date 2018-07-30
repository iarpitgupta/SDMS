package com.scgj.sdms.controller;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.scgj.sdms.interfaces.IAppContsants;
import com.scgj.sdms.model.*;
import com.scgj.sdms.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
public class CentreCsvController {
    private Centre centre;
    private static final String CSV_FILE_PATH = "C:\\New folder\\sdms\\sdms\\src\\main\\resources\\src\\centre.csv";
    @Autowired
    CentreService centreService;
    @Autowired
    UploadFileService uploadFileService;
    @Autowired
    LocationService locationService;
    @Autowired
    TrainingPartnerService trainingPartnerService;
    private Location location;
    private TrainingPartner trainingPartner;

    @PostMapping("/centre")
    public ModelAndView saveCentreCsv(@RequestParam("csv") MultipartFile multipartFile, @RequestParam(value = "filedatatype") String type, @RequestParam(value = "userId",required = false) String userId) {
        try{
                //System.out.println("path variable"+filetype);
                String saveFilePath=uploadFileService.uploadFile(multipartFile,type,"surbhi");
                saveFilePath=IAppContsants.UPLOADFOLDER +"/"+ saveFilePath;
                Reader reader = Files.newBufferedReader(Paths.get(saveFilePath));
                CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(2).build();
                //Scanner scanner=new Scanner(new File(CSV_FILE_PATH))
            //System.out.println("I am here to save");
           // String fileNameReceived = multipartFile.getOriginalFilename();
            String[] nextRecord;
            List<Centre> assessmentAgencies = new LinkedList<Centre>();
            while ((nextRecord = csvReader.readNext()) != null) {
                System.out.println("In while");
               // System.out.println("nextRecord" + nextRecord[0] + " " + nextRecord[1] + " " + nextRecord[2] + " " + nextRecord[3] + " " + nextRecord[4]);
                centre= new Centre();
                //System.out.println("nextRecord[0]"+nextRecord[0]);
                if (!(nextRecord[0].isEmpty()))
                centre.setCentreId(Long.valueOf(nextRecord[0]));
                //System.out.println("nextRecord[1]"+nextRecord[1]);
                centre.setCentreName(nextRecord[1]);
                centre.setCentrePoContactName(nextRecord[2]);
                centre.setCentreAddress(nextRecord[3]);
                //  if (!(nextRecord[1].isEmpty())) {
                location = locationService.findByDistrictAndState(nextRecord[4], nextRecord[5]);
                if (location == null) {
                    location = new Location();
                    location.setState(nextRecord[5]);
                    location.setDistrict(nextRecord[4]);
                    location = locationService.save(location);
                }
                if (location != null)
                    centre.setLocationId(location);
                if(!(nextRecord[6]).isEmpty())
                {
                    trainingPartner=trainingPartnerService.findByTainingPartnerId(nextRecord[6]);
                }
                if(trainingPartner!=null)
                    centre.setTrainingPartnerId(trainingPartner);
                //System.out.println("nextRecord[2]"+nextRecord[2]);
                centreService.save(centre);
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
