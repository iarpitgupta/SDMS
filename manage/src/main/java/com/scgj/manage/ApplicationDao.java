package com.scgj.manage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

@Component("applicationDao")
@ComponentScan
public class ApplicationDao
{

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public DataSource getDataSource() {
        return dataSource;
    }
    @Autowired
    public ApplicationDao(NamedParameterJdbcTemplate namedParameterJdbcTemplate)
    {
        this.namedParameterJdbcTemplate=namedParameterJdbcTemplate;
    }
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
       // this.namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
    }

    private DataSource dataSource;
    public ApplicationDao(){}
//    public ApplicationDao(NamedParameterJdbcTemplate namedParameterJdbcTemplate)
//    {
//        this.namedParameterJdbcTemplate=namedParameterJdbcTemplate;
//    }
    public Collection<Application> getAllApplications()
    {
        String selectQuery="select * from scgj_users";

        Collection<Application> applicationCollection=namedParameterJdbcTemplate.query(selectQuery,new ApplicationMapper());
        return applicationCollection;


    }
    private static class ApplicationMapper implements RowMapper<Application>
    {

        public Application mapRow(ResultSet rs, int rowNum) throws SQLException {
            Application application = new Application();
            application.setApplicationId(rs.getInt("applicationId"));
            application.setAppComment(rs.getString("applicationStatus"));
            application.setAppStatus(Application.AppStatus.valueOf(rs.getString("appStatus")));
            application.setAppType(rs.getString("appType"));
            application.setInstitueName(rs.getString("instituteName"));
            application.setLocation(rs.getString("location"));
            application.setSubmitDate(rs.getDate("submitDate"));
            return application;
        }

    }
}

