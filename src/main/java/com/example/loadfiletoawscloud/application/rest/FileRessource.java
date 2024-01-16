package com.example.loadfiletoawscloud.application.rest;

import com.example.loadfiletoawscloud.application.dto.FileDto;
import com.example.loadfiletoawscloud.domain.mapper.FileMapper;
import com.example.loadfiletoawscloud.domain.use_case.DownloadFile;
import com.example.loadfiletoawscloud.domain.use_case.ExistFile;
import com.example.loadfiletoawscloud.domain.use_case.UploadFile;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@RestController()
public class FileRessource {
    private final UploadFile uploadFile;

    private final DownloadFile downloadFile;

    private final ExistFile existFile;

    public FileRessource(UploadFile uploadFile, DownloadFile downloadFile, ExistFile existFile){
        this.uploadFile = uploadFile;
        this.downloadFile = downloadFile;
        this.existFile = existFile;
    }

    @PostMapping("/uploadFile")
    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file, @RequestParam("type") String typeDocument) throws IOException {
        if(file.isEmpty()){
            return new ResponseEntity<>("File cannot be empty", HttpStatus.NOT_FOUND);
        }
        if(file.getSize()>800000){
            return new ResponseEntity<>("file must have more than 8MB",HttpStatus.NOT_ACCEPTABLE);
        }

        if(existFile.excute(file.getOriginalFilename())){
            return new ResponseEntity<>("file already exist please choose another file",HttpStatus.NOT_ACCEPTABLE);
        }

        return new ResponseEntity<>(uploadFile.excute(FileMapper.mapFileDtoToFile(new FileDto(file.getOriginalFilename(),file.getContentType(),file.getSize(), typeDocument, file.getBytes()))
        ), HttpStatus.CREATED);
    }

    @PostMapping("/uploadMultipleFiles")
    public List<ResponseEntity<String>> uploadMutipleFile(@RequestParam("file") MultipartFile[] files, @RequestParam("type") String type){
        return Collections.emptyList();
//        return  Arrays.stream(files)
//                .map(file -> upload(file, type))
//                .toList();
    }

    @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable String fileName) throws IOException {
        FileDto fileDto = FileMapper.mapFileToFileDto(downloadFile.excute(fileName));
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(fileDto.contentType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "file = "+fileDto.name())
                .body(new ByteArrayResource(fileDto.data()));

    }
}
