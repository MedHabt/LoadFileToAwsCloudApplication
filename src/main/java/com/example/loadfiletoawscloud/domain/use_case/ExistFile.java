package com.example.loadfiletoawscloud.domain.use_case;

import com.example.loadfiletoawscloud.domain.port.PortFile;
import org.springframework.stereotype.Component;

@Component
public class ExistFile {

    private final PortFile portFile;

    public ExistFile(PortFile portFile) {
        this.portFile = portFile;
    }

    public boolean excute(String fileName){
        return portFile.fileExiste(fileName);
    }
}
