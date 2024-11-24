package app.Services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;

@Service
public class UploadService {
    public  String upload(MultipartFile multipartFile){
        Date createdAt = new Date();
        String storageFileName = createdAt.getTime() + "_" + multipartFile.getOriginalFilename();
        try {
            String uploadDir = "public/images";
            Path path = Paths.get(uploadDir);
            if (!Files.exists(path)) {
                Files.createDirectories(path);
            }

            try (InputStream inputStream = multipartFile.getInputStream()) {
                Files.copy(inputStream, Paths.get(uploadDir, storageFileName), StandardCopyOption.REPLACE_EXISTING);

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return storageFileName;
    }

}
