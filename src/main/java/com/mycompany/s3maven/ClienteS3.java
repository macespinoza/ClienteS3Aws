/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.s3maven;

import java.io.File;
import java.nio.file.Paths;
        

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.AmazonServiceException;

/**
 *
 * @author mcotrina
 */
public class ClienteS3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // Se carga el fichero al Bucket S3 elegido
        AWSService awsServicio = new AWSService("AccesKey","SecretKey","Bucket");
        awsServicio.uploadFile("D:/37775-309023300-7.pdf", "206420", "37775-309023300-7.pdf", "37775-309023300-1.pdf");
        awsServicio.uploadFile("D:/37775-309023300-7.pdf", "206420", "37775-309023300-7.pdf", "37775-309023300-2.pdf");
        awsServicio.uploadFile("D:/37775-309023300-7.pdf", "206420", "37775-309023300-7.pdf", "37775-309023300-3.pdf");
        awsServicio.uploadFile("D:/37775-309023300-7.pdf", "206420", "37775-309023300-7.pdf", "37775-309023300-4.pdf");
        awsServicio.uploadFile("D:/37775-309023300-7.pdf", "206420", "37775-309023300-7.pdf", "37775-309023300-5.pdf");
        awsServicio.uploadFile("D:/37775-309023300-7.pdf", "206420", "37775-309023300-7.pdf", "37775-309023300-6.pdf");

    }
    
    
    
}
