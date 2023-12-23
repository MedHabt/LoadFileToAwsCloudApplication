package com.example.loadfiletoawscloud.domain.port;

import com.example.loadfiletoawscloud.domain.model.File;

import java.io.FileNotFoundException;
import java.util.Optional;

public interface PortFile {
    String uploadFile(File file);

    Optional<File> downloadFile(String fileName) throws FileNotFoundException;

    boolean fileExiste(String fileName);
}
