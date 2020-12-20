package pl.coderslab.upload;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileService {

//    @Value("${file.upload-dir}")
//    public String uploadDir;
    private final UploadRepository uploadRepository;

    public FileService(UploadRepository uploadRepository) {
        this.uploadRepository = uploadRepository;
    }

    public void uploadFile(MultipartFile file, String uploadDir) {

        try {
            Path copyLocation = Paths
                    .get(uploadDir + File.separator + StringUtils.cleanPath(file.getOriginalFilename()));
            Upload upload= new Upload(uploadDir,StringUtils.cleanPath(file.getOriginalFilename()));
            upload.setFullPath(copyLocation.toString());
            System.out.println(copyLocation.toString());
            Files.copy(file.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);
            uploadRepository.save(upload);
        } catch (Exception e) {
            e.printStackTrace();
            throw new FileStorageException("Could not store file " + file.getOriginalFilename()
                    + ". Please try again!");
        }
    }


}
