package ru.itis.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.itis.springbootdemo.services.fileStorage.FileStorageService;

import javax.servlet.http.HttpServletResponse;

@Controller
public class DistributeController {
    @Autowired
    FileStorageService fileStorageService;


    @RequestMapping(value = "/img/{id}", method = RequestMethod.GET)
    @ResponseBody public void getImg(@PathVariable("id") Long id, HttpServletResponse response) {
        fileStorageService.writeFileToResponse(id,response);
    }
    @RequestMapping(value = "/track/{id}", method = RequestMethod.GET)
    @ResponseBody public void getTrack(@PathVariable("id") Long id, HttpServletResponse response) {
        fileStorageService.writeFileToResponse(id,response);
    }
}
