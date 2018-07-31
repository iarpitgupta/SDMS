package com.scgj.sdms.interfaces;

import com.scgj.sdms.model.ChartDataModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IChartModelRepository extends CrudRepository<ChartDataModel,String> {
    @Query(value = "select count(candidate_id),batch_type from candidate c join batch b on b.batch_id=c.batch_id group by batch_type",nativeQuery=true)
    List<ChartDataModel> findAll();
}
