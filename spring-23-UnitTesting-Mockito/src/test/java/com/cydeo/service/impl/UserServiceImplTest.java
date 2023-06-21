package com.cydeo.service.impl;

import com.cydeo.mapper.UserMapper;
import com.cydeo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    UserRepository userRepository;

    @Mock
    UserMapper userMapper;

    @InjectMocks
    UserServiceImpl userService;

   @Test
    void findByUserName_Test(){

       userService.findByUserName("harold@manager");

       verify(userRepository).findByUserNameAndIsDeleted("harold@manager",false);

    verify(userRepository,times(1)).findByUserNameAndIsDeleted("harold@manager",false);
       verify(userRepository,atLeastOnce()).findByUserNameAndIsDeleted("harold@manager",false);
       verify(userRepository,atLeast(1)).findByUserNameAndIsDeleted("harold@manager",false);
       verify(userRepository,atMostOnce()).findByUserNameAndIsDeleted("harold@manager",false);
       verify(userRepository,atMost(10)).findByUserNameAndIsDeleted("harold@manager",false);


       InOrder inOrder =inOrder(userRepository,userMapper);

       inOrder.verify(userRepository).findByUserNameAndIsDeleted("harold@manager",false);
       inOrder.verify(userMapper).convertToDto(null);

   }

}
