package com.example.loadfiletoawscloud.domain.use_case;

import com.example.loadfiletoawscloud.aws.AmazonClient;
import com.example.loadfiletoawscloud.domain.model.File;
import com.example.loadfiletoawscloud.domain.port.PortFile;
import com.example.loadfiletoawscloud.util.FileUtils;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

@Component
public class DownloadFile {

    private final PortFile portFile;
    private final AmazonClient amazonClient;

    public DownloadFile(PortFile portFile, AmazonClient amazonClient) {
        this.portFile = portFile;
        this.amazonClient = amazonClient;
    }

    public File excute(String fileName) throws IOException {
        File file = portFile.downloadFile(fileName).get();
        if(file == null) {
            throw new FileNotFoundException();
        }else {
            InputStream inputStream = amazonClient.getFileInputStream(file.uuidAwsFile(),String.valueOf(file.fileNature()));
            return new File(file.name(),
                    file.contentType(),
                    file.size(),
                    file.fileNature(),
                    FileUtils.convertInputStreamToByte(inputStream),
                    file.uuidAwsFile());
        }
    }
}
