package com.example.loadfiletoawscloud.domain.mapper;

import com.example.loadfiletoawscloud.application.dto.FileDto;
import com.example.loadfiletoawscloud.domain.model.File;
import com.example.loadfiletoawscloud.util.FileNature;
import com.example.loadfiletoawscloud.util.FileUtils;

public class FileMapper {

    private FileMapper(){
        throw new IllegalStateException("FileMapper class");
    }

    public static File mapFileDtoToFile(FileDto fileDto){
        if(fileDto == null){
            return null;
        }
        return new File(fileDto.name(), fileDto.contentType(), fileDto.size(), FileNature.valueOf(fileDto.fileNature()), fileDto.data(), FileUtils.generateFileName(fileDto.name()));
    }

    public static FileDto mapFileToFileDto(File file) {
        if(file == null){
            return null;
        }
        return new FileDto(file.name(),
                file.contentType(),
                file.size(),
                String.valueOf(file.fileNature()),
                file.data());
    }
}
