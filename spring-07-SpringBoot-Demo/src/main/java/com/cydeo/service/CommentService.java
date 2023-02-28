package com.cydeo.service;

import com.cydeo.config.AppConfigData;
import com.cydeo.config.DBConfigData;
import com.cydeo.model.Comment;
import com.cydeo.proxy.CommentNotificationProxy;
import com.cydeo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CommentService {

    private final CommentRepository commentRepository;
    private final CommentNotificationProxy commentNotificationProxy;
private final AppConfigData appConfigData;
private final DBConfigData dbConfigData;

    public CommentService(CommentRepository commentRepository,@Qualifier("EMAIL") CommentNotificationProxy commentNotificationProxy,AppConfigData appConfigData,DBConfigData dbConfigData) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
   this.appConfigData=appConfigData;
   this.dbConfigData=dbConfigData;
    }

    public void publishComment(Comment comment){
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);
    }
    public void printConfigData(){
        //print ozzy
        //pring password
        //print url
        System.out.println(appConfigData.getUsername());
        System.out.println(appConfigData.getPassword());
        System.out.println(appConfigData.getUrl());
    }
    public void printDbConfigData(){
        System.out.println(dbConfigData.getUserName());
        System.out.println(dbConfigData.getPassword());
        System.out.println(dbConfigData.getType());
    }
}
