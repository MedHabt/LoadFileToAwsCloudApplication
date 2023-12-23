package com.example.loadfiletoawscloud.infra.mapper;

import com.example.loadfiletoawscloud.domain.model.File;
import com.example.loadfiletoawscloud.infra.entity.FileEntity;

import java.util.Optional;

public class MapperFileEntity {

    private MapperFileEntity(){
        throw new IllegalStateException("MapperFileEntity class");
    }

    public static FileEntity mapFileToFileEntity(File file){
        if(file ==null){
            return null;
        }
        FileEntity fileEntity= new FileEntity();
        fileEntity.setName(file.name());
        fileEntity.setContentType(file.contentType());
        fileEntity.setSize(file.size());
        fileEntity.setFileNature(file.fileNature());
        fileEntity.setData(file.data());
        return fileEntity;
    }

    public static Optional<File> mapFileEntityToFile(FileEntity fileEntity) {
        Optional<File> file = Optional.of(new File(fileEntity.getName(),
                fileEntity.getContentType(),
                fileEntity.getSize(),
                fileEntity.getFileNature(),
                fileEntity.getData()));
        return Optional.of(file.orElse(null));
    }
}
