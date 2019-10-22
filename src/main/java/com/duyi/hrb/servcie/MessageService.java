package com.duyi.hrb.servcie;

import com.duyi.common.CustomerContextHolder;
import com.duyi.hrb.dao.MsgDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    @Autowired
    MsgDao msgDao;

    public void insert(String msg){
        CustomerContextHolder.setCustomerType(CustomerContextHolder.DATASOURCE_USERMSG);
        try{
            msgDao.insertMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
