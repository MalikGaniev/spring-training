package com.cydeo.controller;

import com.cydeo.dto.AddressDTO;
import com.cydeo.dto.ResponseWrapper;
import com.cydeo.dto.TeacherDTO;
import com.cydeo.service.AddressService;
import com.cydeo.service.ParentService;
import com.cydeo.service.StudentService;
import com.cydeo.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SchoolController {

    private final TeacherService teacherService;
    private final StudentService studentService;
    private final ParentService parentService;
    private final AddressService addressService;

    public SchoolController(TeacherService teacherService, StudentService studentService, ParentService parentService, AddressService addressService) {
        this.teacherService = teacherService;
        this.studentService = studentService;
        this.parentService = parentService;
        this.addressService = addressService;
    }

    //write a method for teachers and return as a list of teachers

    @GetMapping("/teachers")
    public List<TeacherDTO> allTeachers(){

        List<TeacherDTO> teacherDTOS = teacherService.findAll();

        return teacherDTOS;
    }

    /* 7 MIN
        create an endpoint for students, where json includes
        "Students are successfully retrieved." message
        code:200
        success:true
        and student data
     */

    @GetMapping("/students")
    public ResponseEntity<ResponseWrapper> readAllStudents(){
        return ResponseEntity.ok(new ResponseWrapper("Students are successfully retrieved.",studentService.findAll()));
    }

    /*  5 MIN
        create a parents endpoint where status code is 202
        additional header has "Parent" , "Returned"
        and following json body structure
       "Parents are successfully retrieved." message
        code:202
        success:true
        and student data
     */

    @GetMapping("/parents")
    public ResponseEntity<ResponseWrapper> readAllParents(){
        ResponseWrapper responseWrapper = new ResponseWrapper(true, "Parents are successfully retrieved.",
                HttpStatus.ACCEPTED.value(),parentService.findAll());

        return ResponseEntity
                            .status(HttpStatus.ACCEPTED)
                            .header("Parent","Returned")
                            .body(responseWrapper);
    }

    /*
        create an endpoint for individual address information
        /address/1
        return status code 200
        "address .. is successfully retrieved" message
        and address information
     */

    @GetMapping("/address/{id}")
    public ResponseEntity<ResponseWrapper> getAddress(@PathVariable("id") Long id) throws Exception {
        //find the address to return
        AddressDTO addressToReturn = addressService.findById(id);

        return ResponseEntity.ok(new ResponseWrapper("Address "+id+" is successfully retrieved",addressToReturn));
    }

    /*  HW
        create and endpoint to update individual address information.
        return updated address directly.
     */
    @PutMapping("/address/{id}")
    public AddressDTO updateAddress(@PathVariable("id") Long id, @RequestBody AddressDTO addressDTO) throws Exception {
        addressDTO.setId(id);

        AddressDTO updateAddress = addressService.update(addressDTO);

        return updateAddress;
    }
}
