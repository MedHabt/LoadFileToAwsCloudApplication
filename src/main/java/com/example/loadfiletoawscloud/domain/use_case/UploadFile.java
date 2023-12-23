package com.example.loadfiletoawscloud.domain.use_case;

import com.example.loadfiletoawscloud.aws.AmazonClient;
import com.example.loadfiletoawscloud.domain.model.File;
import com.example.loadfiletoawscloud.domain.port.PortFile;
import com.example.loadfiletoawscloud.util.FileUtils;
import org.springframework.stereotype.Component;

@Component
public class UploadFile {

    private final PortFile portFile;

    private final AmazonClient amazonClient;

    public UploadFile(PortFile portFile, AmazonClient amazonClient) {
        this.portFile = portFile;
        this.amazonClient = amazonClient;
    }

    public String excute(File file){
        //vérifier l'existance du fichier
        // vérifier la taille du fichier
        //autre traitement.
        amazonClient.uploadFileToBucket(file.name(), FileUtils.bytesToFile(file.data(), file.name()), String.valueOf(file.fileNature()));
        return portFile.uploadFile(file);
    }
}
