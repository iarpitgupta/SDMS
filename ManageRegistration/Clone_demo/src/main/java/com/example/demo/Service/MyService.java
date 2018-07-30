package com.example.demo.Service;

import com.example.demo.Entity.Application;
import com.example.demo.Entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MyService
{
//    @Autowired
//    ManageRespository manageRespository;
//
//    @Autowired
//    UserRepository userRepository;
//    private int application_id;
//
////    public MyService(int application_id, String type) {
////        this.application_id = application_id;
////        this.type = type;
////    }
//
//    public int getApplication_id() {
//        return application_id;
//    }
//
//    public void setApplication_id(int application_id) {
//        this.application_id = application_id;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public MyService() {
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    private String type;
//
//    public MyService(int application_id, String type) {
//        this.application_id = application_id;
//        this.type = type;
//    }

    public Map<Integer,String > myServiceList(List<Application> list1, List<User> list2)
    {
        Map<Integer,String> list=new HashMap<>();
        for(Application application:list1) {
            int app_id = application.getApplicationId();
            String type=null;
            for (User user : list2) {
                if ((application.getUser().getUserId())==(user.getUserId()));
                {
                    type = application.getUser().getUserRole();
                    list.put(app_id,type);
                    break;
                }
            }
        }
        return list;
    }
}
