package com.scgj.sdms.interfaces;

import com.scgj.sdms.model.ImportHistory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IImportHistoryRepository extends CrudRepository<ImportHistory,Long> {
    List<ImportHistory> findAll();
}
