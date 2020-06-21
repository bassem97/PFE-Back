package com.ats.remotetimemanager.Service.Image;
import com.ats.remotetimemanager.Model.Image;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

public interface ImageService {
    ResponseEntity uploadImage( MultipartFile file, long id) throws IOException;
    Image load(String filename) throws IOException;
    Boolean delete(String filename) throws IOException;
}
