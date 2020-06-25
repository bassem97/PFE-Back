package com.ats.remotetimemanager.Controller.Database;

import com.ats.remotetimemanager.Service.Database.RestoreDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

@RestController
@CrossOrigin("*")
@RequestMapping("/db/")
public class RestoreDBController {

    @Autowired
    RestoreDBService restoreDBService;

    @RequestMapping("rollback")
    public ResponseEntity rollback() throws IOException{
      return restoreDBService.rollback();
    }

    @PostMapping("restore")
    public  ResponseEntity restore(@RequestParam("sql") MultipartFile file) throws IOException {
        return restoreDBService.restore(file);
    }

}
