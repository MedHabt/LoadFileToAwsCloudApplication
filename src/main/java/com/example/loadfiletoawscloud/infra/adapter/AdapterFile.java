package com.example.loadfiletoawscloud.infra.adapter;

import com.example.loadfiletoawscloud.domain.model.File;
import com.example.loadfiletoawscloud.domain.port.PortFile;
import com.example.loadfiletoawscloud.infra.mapper.MapperFileEntity;
import com.example.loadfiletoawscloud.infra.repository.RepositoryDatabase;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.util.Optional;


@Component
public class AdapterFile implements PortFile {

    private final RepositoryDatabase repositoryDatabase;

    public AdapterFile(RepositoryDatabase repositoryDatabase) {
        this.repositoryDatabase = repositoryDatabase;
    }

    @Override
    public String uploadFile(File file) {
        //stocker le fichier
        repositoryDatabase.saveFile(MapperFileEntity.mapFileToFileEntity(file));
        return "fichier enregistrer avec seccés";
    }

    @Override
    public Optional<File> downloadFile(String fileName) throws FileNotFoundException {
        return MapperFileEntity.mapFileEntityToFile(repositoryDatabase.get(fileName));
    }

    /*@Override
    public boolean fileExiste(String fileName) {
        return repositoryDatabase.fileExiste(fileName);
    }*/
}
