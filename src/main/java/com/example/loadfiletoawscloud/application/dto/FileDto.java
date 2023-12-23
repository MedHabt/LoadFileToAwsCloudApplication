package com.example.loadfiletoawscloud.application.dto;

import com.example.loadfiletoawscloud.util.FileNature;

import java.util.Arrays;

public record FileDto(String name, String contentType, Long size, String fileNature, byte[] data) {
    public FileDto {
        fileNature = switch (fileNature){
            case "I" -> String.valueOf(FileNature.IDENTITY);
            case "P" -> String.valueOf(FileNature.PASSPORT);
            default -> String.valueOf(FileNature.MULTIPLEFILES);
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FileDto fileDto = (FileDto) o;

        if (!name.equals(fileDto.name)) return false;
        if (!contentType.equals(fileDto.contentType)) return false;
        if (!size.equals(fileDto.size)) return false;
        if (!fileNature.equals(fileDto.fileNature)) return false;
        return Arrays.equals(data, fileDto.data);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + contentType.hashCode();
        result = 31 * result + size.hashCode();
        result = 31 * result + fileNature.hashCode();
        result = 31 * result + Arrays.hashCode(data);
        return result;
    }

    @Override
    public String toString() {
        return "FileDto{" +
                "name='" + name + '\'' +
                ", contentType='" + contentType + '\'' +
                ", size=" + size +
                ", fileNature='" + fileNature + '\'' +
                ", data=" + Arrays.toString(data) +
                '}';
    }
}
