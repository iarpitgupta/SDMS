//package com.scgj.sdms.Utilities;
//
//import com.opencsv.CSVReader;
//import com.opencsv.CSVReaderBuilder;
//import com.opencsv.bean.ColumnPositionMappingStrategy;
//import com.opencsv.bean.CsvToBeanBuilder;
//import com.scgj.sdms.interfaces.iBatchRepository;
//import com.scgj.sdms.model.Batch;
//import com.scgj.sdms.service.BatchService;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.io.IOException;
//import java.io.Reader;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
////import com.scgj.sdms.interfaces;
//
//public class CsvUploader {
//
//    private static final String delimitter="batchEnd";
//    private static final String CSV_FILE_PATH = "C:\\New folder\\sdms\\sdms\\src\\batch.csv";
//
//    public static void main(String[] args) {
//
//        try (
//
//                Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
//                CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(2).build();
//        ) {
//            //   Reading Records One by One in a String array
//            String[] nextRecord;
//            List<Batch>batchList=new LinkedList<Batch>();
//           List<String[]>recordList=new ArrayList<String[]>();
//            while ((nextRecord = csvReader.readNext()) != null) {
//                recordList.add(nextRecord);
////                recordList.add(nextRecord[0]);
////                recordList.add(nextRecord[1]);
////                recordList.add(nextRecord[2]);
////                recordList.add(nextRecord[3]);
////                recordList.add(nextRecord[4]);
////                recordList.add(nextRecord[5]);
////                recordList.add(nextRecord[6]);
////                recordList.add(nextRecord[7]);
////                recordList.add(nextRecord[8]);
////                recordList.add(nextRecord[9]);
////                recordList.add(nextRecord[10]);
////                recordList.add(nextRecord[11]);
////                recordList.add(nextRecord[12]);
////                recordList.add(nextRecord[13]);
////                recordList.add(nextRecord[14]);
////                recordList.add(nextRecord[15]);
////                recordList.add(nextRecord[16]);
////                recordList.add(nextRecord[17]);
////                recordList.add(nextRecord[18]);
////                recordList.add(nextRecord[19]);
////                recordList.add(nextRecord[20]);
////                recordList.add(nextRecord[21]);
////                recordList.add(nextRecord[22]);
////                recordList.add(nextRecord[23]);
////                recordList.add(nextRecord[24]);
////
//
////
////                //System.out.println("==========================");
////
//                }
//                for(String []strArr:recordList)
//                {
//                    batchList.add(new Batch(strArr));
//                }
//                for(Batch batch:batchList)
//                {
//                    System.out.println( new BatchService().getData(batch));
//
//
//                }
//        }
//        catch (IOException ioException)
//        {
//            ioException.printStackTrace();
//        }
//    }
//}