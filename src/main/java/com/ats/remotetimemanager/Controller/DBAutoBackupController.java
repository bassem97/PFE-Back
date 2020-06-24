package com.ats.remotetimemanager.Controller;

import com.ats.remotetimemanager.Model.Department;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@CrossOrigin("*")
@RequestMapping("/db/")
@Configuration
@EnableScheduling
public class DBAutoBackupController {
    private final Path backUp = Paths.get("BackUp");
    private final Path dataBase = Paths.get("Database");
    private Long custom = null;

    @RequestMapping("dumpDb/{custom}")
    public void customExport(@PathVariable("custom") Long cs) {
        custom = cs;
        schedule(); 
    }
//    @Scheduled(cron = "*/30 * * * * *") // every 30 seconds
    @Scheduled(cron = "0 0 23 * * *") // everyday at 23h

    public void schedule() {
        System.out.println("Backup Started at " + new Date());

        Date backupDate = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        String backupDateStr = format.format(backupDate);
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH_mm_ss");
        String time = timeFormat.format(backupDate);
        String dbName = "remotetimemanager";
        String dbUserName = "root";
        Path mysqldump =this.dataBase.resolve("mysqldump");
        String folderPath;
        if (custom == null) {
            folderPath  = "C:\\Users\\khail\\Desktop\\PFE\\PFE-Back\\DailyBackUp";
        } else {
            folderPath  = "C:\\Users\\khail\\Desktop\\PFE\\PFE-Back\\CustomBackUp";
        }
        File f1 = new File(folderPath);
        f1.mkdir();
        String fileName;
        if (custom == null) {
            fileName  = "Daily_DB_Backup_" + backupDateStr + ".sql";
        } else {
            fileName = "Custom_DB_Backup"+backupDateStr+"_"+time+".sql";
        }
        custom = null;
        Path backup = this.backUp.resolve(fileName);

        String executeCmd = mysqldump+ " --no-create-db --no-create-info -u "+dbUserName+" "+dbName+" -r "+ backup;

        Process runtimeProcess = null;
        try {
            runtimeProcess = Runtime.getRuntime().exec(executeCmd);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int processComplete = 0;
        try {
            processComplete = runtimeProcess.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (processComplete == 0) { System.out.println("Backup Complete at " + new Date());
        } else {
            System.out.println("Backup Failure");
        }
    }

}
