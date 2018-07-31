package com.scgj.sdms.interfaces;

import com.scgj.sdms.model.ImportHistory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImportHistoryRepository extends CrudRepository<ImportHistory,Long> {
    ImportHistory save(ImportHistory importHistory);
}
