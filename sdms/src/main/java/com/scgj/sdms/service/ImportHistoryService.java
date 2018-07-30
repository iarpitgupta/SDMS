package com.scgj.sdms.service;

import com.scgj.sdms.interfaces.IImportHistoryRepository;
import com.scgj.sdms.model.ImportHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ImportHistoryService {
    @Autowired
    IImportHistoryRepository iImportHistoryRepository;
    public List<ImportHistory> findAll(){
        return  iImportHistoryRepository.findAll();
    }
}
