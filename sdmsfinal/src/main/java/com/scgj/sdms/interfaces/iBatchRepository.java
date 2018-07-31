package com.scgj.sdms.interfaces;

import com.scgj.sdms.model.Batch;
import com.scgj.sdms.model.ChartDataModel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.List;

@Repository
@Transactional
//@Qualifier("batchRepository")
public interface iBatchRepository extends CrudRepository<Batch,String> {
    public Batch save(Batch b);
    public Batch findByBatchId(String batchId);
    List<Batch>findAll();

   // List<ChartDataModel> getChartData();
}
