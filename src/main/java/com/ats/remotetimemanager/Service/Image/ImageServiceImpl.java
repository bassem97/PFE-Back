package com.ats.remotetimemanager.Service.Image;

import com.ats.remotetimemanager.Model.Image;
import com.ats.remotetimemanager.Model.User;
import com.ats.remotetimemanager.Repository.ImageRepository;
import com.ats.remotetimemanager.Repository.UserRepository;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@Service("imageService")
public class ImageServiceImpl implements ImageService {

    @Autowired
    ImageRepository imageRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public ResponseEntity uploadImage(MultipartFile file, long id) throws IOException {
        System.out.println("Original Image Byte Size - " + file.getBytes().length);
        String name = file.getContentType().replaceAll("image/", id+".");
        String path = "C:\\Users\\Bassem's PC\\Desktop\\PFE\\PFE-back\\src\\main\\resources\\Images\\"+ name;
        File filePath = new File(path);
        file.transferTo(filePath);
        User  user = userRepository.findByUserId(id);
        String[] str = new String[] {path,name};
        user.setImage(str);
        userRepository.save(user);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Override
    public Image getImage(long id) throws IOException {
        User user = userRepository.findByUserId(id);
        File filePath = new  File(user.getImage()[0]+user.getImage()[1]);
        FileInputStream input = new FileInputStream(filePath);
        String type = filePath.getName().substring(filePath.getName().lastIndexOf(".")+1);
        MultipartFile file = new MockMultipartFile("file", filePath.getName(),type, IOUtils.toByteArray(input));
        return new Image (user.getImage()[1],file.getContentType(),file.getBytes());
//        return compressBytes(file.getBytes());

    }

    @Override
    public Image findImageById(long imageId) throws IOException {
        final Image retrievedImage = imageRepository.findById(imageId);
        return new Image(retrievedImage.getName(),
                retrievedImage.getType(),
                decompressBytes(retrievedImage.getPicByte()));
    }

    // compress the image bytes before storing it in the database
    @Override
    public byte[] compressBytes(byte[] data) {
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        try {
            outputStream.close();
        } catch (IOException ignored) {
        }
        System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
        return outputStream.toByteArray();
    }

    // uncompress the image bytes before returning it to the angular application
    @Override
    public byte[] decompressBytes(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);
                outputStream.write(buffer, 0, count);
            }
            outputStream.close();
        } catch (IOException | DataFormatException ignored) {
        }
        return outputStream.toByteArray();
    }
}
