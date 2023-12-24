package com.example.loadfiletoawscloud.domain.use_case;

import com.example.loadfiletoawscloud.aws.AmazonClient;
import com.example.loadfiletoawscloud.domain.model.File;
import com.example.loadfiletoawscloud.domain.port.PortFile;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.util.Optional;

@Component
public class ExistFile {

    private final PortFile portFile;

    private final AmazonClient amazonClient;

    public ExistFile(PortFile portFile, AmazonClient amazonClient) {
        this.portFile = portFile;
        this.amazonClient = amazonClient;
    }

    public boolean excute(String fileName){
       try {
           Optional<File> file = portFile.downloadFile(fileName);
            if(file.isPresent()){
                return file.get().name().equalsIgnoreCase(fileName) && amazonClient.fileExistInBucket(file.get().fileNature()+"/"+file.get().uuidAwsFile());
            }
            return true;
       } catch (FileNotFoundException e) {
            return true;
        }
    }
}
