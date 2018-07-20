package com.scgj.manage;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class ApplicationService {

    public Collection<Application> getApplicationList()
    {
        ApplicationDao applicationDao=new ApplicationDao();
        return applicationDao.getAllApplications();
    }
}
