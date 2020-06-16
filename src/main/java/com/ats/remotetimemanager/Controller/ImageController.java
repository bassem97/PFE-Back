package com.ats.remotetimemanager.Controller;

import com.ats.remotetimemanager.Model.Image;
import com.ats.remotetimemanager.Repository.ImageRepository;
import com.ats.remotetimemanager.Service.Image.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@RestController
@CrossOrigin("*")
@RequestMapping("/image/")
public class ImageController {

        @Autowired
        ImageService imageService;

        @PostMapping("upload/{id}")
        public ResponseEntity uploadImage(@RequestParam("imageFile") MultipartFile file, @PathVariable("id") long id ) throws IOException {
                return this.imageService.uploadImage(file,id);
        }

        @GetMapping(path = {"load/{name}"})
        public Image load(@PathVariable("name") String name) throws IOException {
                return imageService.load(name);
        }

}
