package com.ats.remotetimemanager.Service.Image;

import com.ats.remotetimemanager.Model.Image;
import com.ats.remotetimemanager.Model.User;
import com.ats.remotetimemanager.Repository.ImageRepository;
import com.ats.remotetimemanager.Repository.UserRepository;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service("imageService")
public class ImageServiceImpl implements ImageService {

    @Autowired
    ImageRepository imageRepository;
    @Autowired
    UserRepository userRepository;
    private final Path root = Paths.get("Images");



    @Override
    public ResponseEntity uploadImage(MultipartFile file, long id) {
        String name = file.getContentType().replaceAll("image/", id+".");
        try {
            Files.copy(file.getInputStream(), this.root.resolve(name));
        } catch (IOException e) {
            try {
                if(delete(name)){
                    Files.copy(file.getInputStream(), this.root.resolve(name));
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("_________________________________________________________________");
        User  user = userRepository.findByUserId(id);
        user.setImage(name);
        userRepository.save(user);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Override
    public Image load(String filename) throws IOException {
        FileInputStream input;
            Path file = root.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                    input = new FileInputStream(resource.getFile());
                String type = filename.substring(filename.lastIndexOf(".")+1);
                MultipartFile filee = new MockMultipartFile("file", filename,type, IOUtils.toByteArray(input));
                input.close();
                return new Image (filename,filee.getContentType(),filee.getBytes());

            }
        return null;
    }

    @Override
    public Boolean delete(String imageName) throws IOException {
        File dir = new File(root.toUri());
        File[] list = dir.listFiles();
        for(File file: list){
            if(file.getName().equals(imageName)){
                System.out.println("________________DELETING__________________ :"+ file.getName());
                return file.delete();
            }
        }
        return false;
    }

}
