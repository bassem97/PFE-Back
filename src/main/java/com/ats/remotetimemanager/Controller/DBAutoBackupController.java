package com.ats.remotetimemanager.Controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
@EnableScheduling
public class DBAutoBackupController {
    private final Path root = Paths.get("BackUp");
//    @Scheduled(cron = "0 30 1 * * ?")
    @Scheduled(cron = "*/15 * * * * *")
    public void schedule() {


        System.out.println("Backup Started at " + new Date());

        Date backupDate = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        String backupDateStr = format.format(backupDate);
        String dbName = "remotetimemanager";
        String dbUserName = "root";


        String folderPath = "C:\\Users\\Bassem's PC\\Desktop\\PFE\\PFE-Back\\BackUp";
        File f1 = new File(folderPath);
        f1.mkdir();

        String fileName = "Daily_DB_Backup_"+backupDateStr+".sql";
        String executeCmd = "C:\\xampp\\mysql\\bin\\mysqldump --no-create-db --no-create-info -u "+dbUserName+" "+dbName+" -r "+this.root.resolve(fileName);

        Process runtimeProcess = null;
        try {
            System.out.println("dkhal lil execute ");
            runtimeProcess = Runtime.getRuntime().exec(String.format( executeCmd));
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
