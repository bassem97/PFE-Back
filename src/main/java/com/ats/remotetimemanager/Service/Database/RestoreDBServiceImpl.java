package com.ats.remotetimemanager.Service.Database;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Objects;

@Service("restoreService")
public class RestoreDBServiceImpl implements RestoreDBService {
    private final Path mysql =Paths.get("Database").resolve("mysql");
    private final String dbUsername = "root";
    private final String dbName = "remotetimemanager";

    @Override
    public ResponseEntity rollback() throws IOException {
        if(!Paths.get("Backup").toFile().exists() || !Paths.get("Backup").resolve("DailyBackup").toFile().exists() )
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        else{
            Path dailyBackup = Paths.get("Backup").resolve("DailyBackup");
            Path lastBackUp = getLastFile(dailyBackup.toFile().listFiles(File::isFile));
            String executeCmd = mysql+" -u "+dbUsername+" "+dbName+" < "+ lastBackUp;
            executeBat("Rollback",executeCmd);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
    }

    @Override
    public ResponseEntity restore(MultipartFile file) throws IOException {
        if(file != null){
            File sql = new File(Objects.requireNonNull(file.getOriginalFilename()));
            FileOutputStream fos = new FileOutputStream( sql );
            fos.write( file.getBytes() );
            fos.close();
            Path sqlPath = sql.toPath();
            String executeCmd = mysql+" -u "+dbUsername+" "+dbName+" < "+ sqlPath;
            executeBat("Restore",executeCmd);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    private void executeBat(String action, String executeCmd) throws IOException {
        System.out.println(action+" Started at " + new Date());
        File f = new File(action+".bat");
        FileOutputStream outputStream = new FileOutputStream(f);
        outputStream.write(executeCmd.getBytes());
        outputStream.close();
        Process runtimeProcess = null;
        try {
            runtimeProcess = Runtime.getRuntime().exec("cmd /c start /wait cmd /C  "+action+".bat -r");
        } catch (IOException e) {
            e.printStackTrace();
        }
        int processComplete = 0;
        try {
            processComplete =  runtimeProcess.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (processComplete == 0) { System.out.println(action+" Complete at " + new Date());
        } else {
            System.out.println(executeCmd);
            System.out.println(action+" Failure");
        }
    }


    private Path getLastFile(File[] files) {
        long lastModifiedTime = Long.MIN_VALUE;
        Path chosenFile = null;
        if(files != null){
            for (File file: files) {
                if(file.lastModified() > lastModifiedTime){
                    chosenFile = file.toPath();
                    lastModifiedTime = file.lastModified();
                }

            }
        }
        return chosenFile;
    }

}
