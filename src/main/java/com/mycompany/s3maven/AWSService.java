/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.s3maven;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;

/**
 *
 * @author mcotrina
 */
public class AWSService  {
    
    String AWS_CREDENTIAL_ACCESS_KEY;
    String AWS_CREDENTIAL_SECRET_KEY;
    String AWS_BUCKET_NAME;
    String SUFFIX = "/";
    AWSCredentials credentials;
    ObjectMetadata metadata;

    public AWSService(String AccesKey, String SecretKey, String Bucket) {
        this.AWS_CREDENTIAL_ACCESS_KEY = AccesKey;
        this.AWS_CREDENTIAL_SECRET_KEY = SecretKey;
        this.AWS_BUCKET_NAME = Bucket;
        
        credentials = new BasicAWSCredentials(AWS_CREDENTIAL_ACCESS_KEY,AWS_CREDENTIAL_SECRET_KEY);
        metadata = new ObjectMetadata();
    }

    

    public String uploadFile(String srcFullPath, String destFolder, String srcFilename, String destFilename)
        throws Exception {

            if(credentials==null)
                credentials = new BasicAWSCredentials(AWS_CREDENTIAL_ACCESS_KEY,AWS_CREDENTIAL_SECRET_KEY);
                          
                    // create a client connection based on credentials
            AmazonS3 s3client = new AmazonS3Client(credentials);

                    // create folder into bucket
            createFolder(AWS_BUCKET_NAME, destFolder, s3client);

                    // upload file to folder
            String fileName = destFolder + SUFFIX + destFilename;
            s3client.putObject(new PutObjectRequest(AWS_BUCKET_NAME, fileName, new File(srcFullPath)).withCannedAcl(CannedAccessControlList.PublicRead));
                    
             return fileName;
        }
    private void createFolder(String bucketName, String folderName, AmazonS3 client) {
        // create meta-data for your folder and set content-length to 0
        metadata.setContentLength(0);
        // create empty content
        InputStream emptyContent = new ByteArrayInputStream(new byte[0]);
        // create a PutObjectRequest passing the folder name suffixed by /
        PutObjectRequest  putObjectRequest = new PutObjectRequest(bucketName, folderName + SUFFIX, emptyContent,metadata);
                    // send request to S3 to create folder
        client.putObject(putObjectRequest);
    }
}
