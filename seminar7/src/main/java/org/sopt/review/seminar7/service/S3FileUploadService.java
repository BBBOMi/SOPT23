package org.sopt.review.seminar7.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by bomi on 2018-12-17.
 */

public interface S3FileUploadService {
    String upload(MultipartFile uploadFIle) throws IOException;
    void uploadOnS3(final String fileName, final File file);
}
