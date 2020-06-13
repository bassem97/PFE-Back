package com.ats.remotetimemanager.Service.Image;

import com.ats.remotetimemanager.Model.Image;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {
    ResponseEntity uploadImage( MultipartFile file) throws IOException;
    Image getImage(String imageName) throws IOException;
    byte[] compressBytes(byte[] data);
    byte[] decompressBytes(byte[] data);
}
