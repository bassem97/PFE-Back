package com.ats.remotetimemanager.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

@RestController
@CrossOrigin("*")
@RequestMapping("/db/")
public class DumpDBController {
    private final Object monitor = new Object();

    @Autowired
    private  JdbcTemplate jdbcTemplate;


    @RequestMapping("dumpDb")
    @ResponseBody
    public void dumpDb() throws IOException {
        synchronized (this.monitor) {
            File dump = new File("dump.sql");
            System.out.println("_______________________________________________________________");
            System.out.println(dump.getAbsolutePath());
            System.out.println("_______________________________________________________________");
            dump.mkdir();
//            if (dump.exists()) {
//                dump.delete();
//            }
//            String url = dump.getAbsolutePath().replace("\\\\","\\" );
            this.jdbcTemplate.execute("script '" + dump.getAbsolutePath() + "';");
        }
    }
}
