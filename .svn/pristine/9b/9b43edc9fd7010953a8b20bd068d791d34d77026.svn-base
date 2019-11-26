/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.util.OOSManager
 * @description:
 * 
 * @version:v1.0.0 
 * @author:QT
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年12月4日       QT          v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;

/**
 * @className:com.xed.financing.wxgzh.util.OOSManager
 * @description:
 * @version:v1.0.0 
 * @date:2017年12月4日 下午1:50:47
 * @author:QT
 */
public class OOSManager
{
	/***下载媒体文件*/
	public static String DOWNLOAD_MEDIA_URL = "https://api.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID";
	
	/**
	 * @date 2016年12月29日下午3:12:33
	 * @param accessToken
	 * @param mediaId 
	 * @param subPath askid提问id
	 * @throws Exception String
	 * @Des:上传微信图片至阿里OOS
	 */
	 public static String uploadWXImage(String accessToken,String mediaId,String subPath) throws Exception{  
		    
		    String key = OSSConfigure.remoteFilePath+subPath+"/"+subPath+"_"+mediaId;
			if (subPath==null) {
				key = OSSConfigure.remoteFilePath+OSSConfigure.subPath_null+"/"+"_"+mediaId;
			}
		    String requestUrl = DOWNLOAD_MEDIA_URL;
			requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken).replace("MEDIA_ID", mediaId);
			System.out.println(requestUrl);
			try {
				URL url = new URL(requestUrl);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setDoInput(true);
				conn.setRequestMethod("GET");
				String contentType = conn.getHeaderField("Content-Type");
				// 根据内容类型获取扩展名
				String fileExt = MediaUtil.getFileEndWitsh(contentType);
				// 将mediaId作为文件名
				 InputStream fileContent=conn.getInputStream();  
				 //创建OSSClient实例  
				 OSSClient ossClient=new OSSClient(OSSConfigure.endpoint, OSSConfigure.accessKeyId, OSSConfigure.accessKeySecret);  
				 key=key+fileExt;
				 PutObjectResult putObject = ossClient.putObject(OSSConfigure.bucketName, key, fileContent);
				 System.err.println("putObjectgetETag:"+putObject.getETag());  
				 System.err.println("putObjectgetRequestId:"+putObject.getRequestId());  
				 System.err.println("putObjectgetClientCRC:"+putObject.getClientCRC());  
				 System.err.println("putObjectgetServerCRC:"+putObject.getServerCRC());  
				 return OSSConfigure.accessUrl+"/" +key; 
		 
			} catch (Exception e) {
				String error = String.format("下载媒体文件失败：%s", e);
				System.out.println(error);
				return null;
			}
	 } 
	
	/**
	 * @date 2016年12月29日上午11:17:37
	 * @param ossConfigure
	 * @param file
	 * @param remotePath
	 * @throws Exception String
	 * @Des:上传OSS服务器文件
	 */
	 public static String uploadFile(File file,String remotePath) throws Exception{  
	        InputStream fileContent=null;  
	        fileContent=new FileInputStream(file);  
	          
	        OSSClient ossClient=new OSSClient(OSSConfigure.endpoint, OSSConfigure.accessKeyId, OSSConfigure.accessKeySecret);  
	         String remoteFilePath = remotePath.substring(0, remotePath.length()).replaceAll("\\\\","/")+"/";  
	        System.err.println("remoteFilePath:"+remoteFilePath);
	         //创建上传Object的Metadata  
	        ObjectMetadata objectMetadata=new ObjectMetadata();  
	        objectMetadata.setContentLength(fileContent.available());  
	        objectMetadata.setCacheControl("no-cache");  
	        objectMetadata.setHeader("Pragma", "no-cache");  
	        objectMetadata.setContentEncoding("utf-8");
	        objectMetadata.setContentType(contentType(file.getName().substring(file.getName().lastIndexOf("."))));  
	        objectMetadata.setContentDisposition("inline;filename=" + file.getName());  
	        //上传文件  
	        PutObjectResult putObject = ossClient.putObject(OSSConfigure.bucketName, remoteFilePath + file.getName(), fileContent, objectMetadata);  
	        
	        System.err.println("putObjectgetETag:"+putObject.getETag());  
	        System.err.println("putObjectgetRequestId:"+putObject.getRequestId());  
	        System.err.println("putObjectgetClientCRC:"+putObject.getClientCRC());  
	        System.err.println("putObjectgetServerCRC:"+putObject.getServerCRC());  
	        ossClient.shutdown();
	        return OSSConfigure.accessUrl+"/" +remoteFilePath + file.getName();  
	    }  
	 
	 
	 
	 /**
	  * @date 2016年12月29日上午11:17:22
	  * @param ossConfigure
	  * @param filePath void
	  * @Des:根据key删除OSS服务器上的文件 
	  */
	 public static void deleteFile(OSSConfigure ossConfigure,String filePath){  
		 OSSClient ossClient=new OSSClient(OSSConfigure.endpoint, OSSConfigure.accessKeyId, OSSConfigure.accessKeySecret);  
	         ossClient.deleteObject(OSSConfigure.bucketName, filePath);  
	          
	    }  
	
	 
	 /**
	  * @date 2016年12月29日上午11:17:11
	  * @param FilenameExtension
	  * @return String
	  * @Des:判断OSS服务文件上传时文件的contentType 
	  */
	 public static String contentType(String FilenameExtension){  
	        if(FilenameExtension.equals("BMP")||FilenameExtension.equals("bmp")){return "image/bmp";}  
	        if(FilenameExtension.equals("GIF")||FilenameExtension.equals("gif")){return "image/gif";}  
	        if(FilenameExtension.equals("JPEG")||FilenameExtension.equals("jpeg")||  
	           FilenameExtension.equals("JPG")||FilenameExtension.equals("jpg")||     
	           FilenameExtension.equals("PNG")||FilenameExtension.equals("png")){return "image/jpeg";}  
	        if(FilenameExtension.equals("HTML")||FilenameExtension.equals("html")){return "text/html";}  
	        if(FilenameExtension.equals("TXT")||FilenameExtension.equals("txt")){return "text/plain";}  
	        if(FilenameExtension.equals("VSD")||FilenameExtension.equals("vsd")){return "application/vnd.visio";}  
	        if(FilenameExtension.equals("PPTX")||FilenameExtension.equals("pptx")||  
	            FilenameExtension.equals("PPT")||FilenameExtension.equals("ppt")){return "application/vnd.ms-powerpoint";}  
	        if(FilenameExtension.equals("DOCX")||FilenameExtension.equals("docx")||  
	            FilenameExtension.equals("DOC")||FilenameExtension.equals("doc")){return "application/msword";}  
	        if(FilenameExtension.equals("XML")||FilenameExtension.equals("xml")){return "text/xml";}  
	        return "text/html";  
	     }  
}
