package com.scgj.sdms.service;

import com.scgj.sdms.interfaces.IChartModelRepository;
import com.scgj.sdms.model.ChartDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChartDataService {
    @Autowired
    IChartModelRepository iChartModelRepository;
    public List<ChartDataModel> findAll()
    {
        return iChartModelRepository.findAll();
    }
}
