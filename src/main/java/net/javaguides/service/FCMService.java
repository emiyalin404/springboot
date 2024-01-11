package net.javaguides.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class FCMService {

    private Logger logger = LoggerFactory.getLogger(FCMService.class);


    public void SendMessage(String titile,String msg,String token){

    }

}
