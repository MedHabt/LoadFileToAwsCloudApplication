package com.example.loadfiletoawscloud.infra.entity;

import com.example.loadfiletoawscloud.util.FileNature;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
@Table(name="file")
public class FileEntity {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid")
    private Integer id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="contenttype", nullable = false)
    private String contentType;

    @Column(name="size", nullable = false)
    private Long size;

    @Column(name = "filenature", nullable = false)
    private FileNature fileNature;

    @Lob
    @Column(name="data", nullable = false)
    private byte[] data;

    @Column(name="uuid_aws", nullable = false)
    private String uuidAwsFile;
}
