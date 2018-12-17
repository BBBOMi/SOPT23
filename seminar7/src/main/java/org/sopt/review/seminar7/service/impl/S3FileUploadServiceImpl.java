package org.sopt.review.seminar7.service.impl;

import com.amazonaws.AmazonClientException;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.Upload;
import lombok.extern.slf4j.Slf4j;
import org.sopt.review.seminar7.service.S3FileUploadService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by bomi on 2018-12-17.
 */

@Slf4j
@Service
public class S3FileUploadServiceImpl implements S3FileUploadService {

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    @Value("${cloud.aws.s3.bucket.url}")
    private String defaultUrl;

    private final AmazonS3Client amazonS3Client;

    public S3FileUploadServiceImpl(final AmazonS3Client amazonS3Client) {
        this.amazonS3Client = amazonS3Client;
    }

    @Override
    public String upload(MultipartFile uploadFIle) throws IOException {
        String origName = uploadFIle.getOriginalFilename();
        String url;

        try {
            // 확장자
            final String ext = origName.substring(origName.lastIndexOf('.'));
            final String saveFileName = getUuid() + ext;
            // 파일 객체 생성
            File file = new File(System.getProperty("user.dir") + saveFileName);

            uploadFIle.transferTo(file);
            uploadOnS3(saveFileName, file);

            url = defaultUrl + saveFileName;

            file.delete();
        } catch(StringIndexOutOfBoundsException e) {
            url = null;
        }
        return url;
    }

    private static String getUuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    @Override
    public void uploadOnS3(String fileName, File file) {
        final TransferManager transferManager = new TransferManager(this.amazonS3Client);
        final PutObjectRequest request = new PutObjectRequest(bucket, fileName, file);
        final Upload upload = transferManager.upload(request);

        try {
            upload.waitForCompletion();
        } catch(AmazonClientException ae) {
            log.error(ae.getMessage());
        } catch(InterruptedException ie) {
            log.error(ie.getMessage());
        }
    }
}
