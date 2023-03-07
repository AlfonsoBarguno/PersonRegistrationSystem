package com.Bargunyo.PersonDB.Data;

import com.Bargunyo.PersonDB.Exceptions.StorageException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;

//It's not an interface because we are not using JpaRepository
@Repository
public class FileStorageRepository {


    //We define a path in our computer environment
    //(a environment variable) where the files will be stored
    //This path should be changed in another computer or in a db
    //if the system is going to be deployed
    @Value("${STORAGE_FOLDER}")//the value (path) in this case is: C:\Users\Alfonso\Desktop\UploadsPersonDb
    private String storageFolder;

    public void save(String originalFilename, InputStream inputStream) throws IOException {

        try {

            Path filePath = Path.of(storageFolder).resolve(originalFilename).normalize();
            Files.copy(inputStream, filePath);
        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    public Resource findByName(String filename) throws MalformedURLException {

        try {
            Path filePath = Path.of(storageFolder).resolve(filename).normalize();
            return new UrlResource(filePath.toUri());


        } catch (MalformedURLException e) {

            e.printStackTrace();
        }
        return null;


    }

    public void deleteAllByName(Iterable<String> fileNames) {

        //With this try/catch, the deleting method wont be finished if there any error
        //in some of the files. But the files alredeady deleted will be gone.
        //Options: 1) try/catch just in Files.deleteIfExists
        //         2) add @Transactional in the service method
        try {
            for (String filename: fileNames) {
                Path filePath = Path.of(storageFolder).resolve(filename).normalize();
                Files.deleteIfExists(filePath);
            }
        } catch (IOException e) {

            throw new RuntimeException(e);
        }

    }
}

