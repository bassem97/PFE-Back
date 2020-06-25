package com.ats.remotetimemanager.Service.Database;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface RestoreDBService {
    ResponseEntity rollback() throws IOException;
    ResponseEntity restore(MultipartFile file) throws IOException;
}
