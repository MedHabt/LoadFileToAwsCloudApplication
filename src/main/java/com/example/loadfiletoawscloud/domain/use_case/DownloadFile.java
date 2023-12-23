package com.example.loadfiletoawscloud.domain.use_case;

import com.example.loadfiletoawscloud.domain.model.File;
import com.example.loadfiletoawscloud.domain.port.PortFile;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;

@Component
public class DownloadFile {

    private final PortFile portFile;

    public DownloadFile(PortFile portFile) {
        this.portFile = portFile;
    }

    public File excute(String fileName) throws FileNotFoundException {
        return portFile.downloadFile(fileName).get();
    }
}
