package com.ats.remotetimemanager.Controller.Database;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@CrossOrigin("*")
@RequestMapping("/db/")
@Configuration
@EnableScheduling
public class BackupDBController {
    private final Path backup = Paths.get("Backup");
    private final Path dailyBackup = backup.resolve("DailyBackup");
    private final Path customBackup = backup.resolve("CustomBackup");
    private final Path dataBase = Paths.get("Database");
    private Path folderPath = dailyBackup;
    private Long custom = 0L;
    String fileName;

    @RequestMapping("dumpDb/{custom}")
    public void customExport(@PathVariable("custom") Long cs) throws IOException {
        custom = cs;
        schedule();
    }
//    @Scheduled(cron = "*/5 * * * * *") // every 30 seconds
    @Scheduled(cron = "0 0 23 * * *") // everyday at 23h
    public void schedule() throws IOException {
        System.out.println("Backup Started at " + new Date());
//        custom = 1L;
        Date dateNow = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String backupDate = dateFormat.format(dateNow);
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH-mm-ss");
        String backupTime = timeFormat.format(dateNow);

        // Database info
        String dbName = "remotetimemanager";
        String dbUserName = "root";

        //path to mmysqldump.sql
        Path mysqldump =this.dataBase.resolve("mysqldump");

        if(!this.backup.toFile().exists())
            Files.createDirectory(this.backup);

        if (custom == 0) {
            if (!this.dailyBackup.toFile().exists()){
                System.out.println("CHEMDAKHEL ZOK OMMOU!");
                folderPath = Files.createDirectory(this.dailyBackup);
            }
        }
        else {
            System.out.println("DKHALL LIL CUSTOM !!!!!!!!!!!!!!!!");
            if(!this.customBackup.toFile().exists())
                folderPath  = Files.createDirectory(this.customBackup);
            else
                folderPath = customBackup;
        }

        if (custom == 0) {
            fileName  = "Daily_DB_Backup_" + backupDate + ".sql";
        } else {
            fileName = "Custom_DB_Backup"+backupDate+"_"+backupTime+".sql";
        }

        custom = 0L;
        Path backup = folderPath.resolve(fileName);
        String executeCmd = mysqldump+ "  -u "+dbUserName+" "+dbName+"  --add-drop-database -r "+ backup;

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
            System.out.println(executeCmd);
            System.out.println("Backup Failure");
        }
    }
}
