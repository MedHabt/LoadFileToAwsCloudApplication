package com.example.loadfiletoawscloud.domain.model;

import com.example.loadfiletoawscloud.util.FileNature;

import java.util.Arrays;

public record File(String name, String contentType, Long size, FileNature fileNature, byte[] data) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        File file = (File) o;

        if (!name.equals(file.name)) return false;
        if (!contentType.equals(file.contentType)) return false;
        if (!size.equals(file.size)) return false;
        if (fileNature != file.fileNature) return false;
        return Arrays.equals(data, file.data);
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
        return "File{" +
                "name='" + name + '\'' +
                ", contentType='" + contentType + '\'' +
                ", size=" + size +
                ", fileNature=" + fileNature +
                ", data=" + Arrays.toString(data) +
                '}';
    }
}
