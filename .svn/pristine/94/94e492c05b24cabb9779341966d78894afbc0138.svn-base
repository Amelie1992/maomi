/**
 * Copyright (C) 2018 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.controller.timingProcessing.MySQLDatabaseBackup
 * @description:
 * 
 * @version:v1.0.0 
 * @author:QT
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2018年12月20日    	QT  		v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.controller.timingProcessing;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ResourceBundle;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.xed.financing.wxgzh.util.GetUUID;

/**
 * 自动备份数据库
 * @className:com.xed.financing.wxgzh.controller.timingProcessing.MySQLDatabaseBackup
 * @description:
 * @version:v1.0.0 
 * @date:2018年12月20日 上午10:26:35
 * @author:QT
 */
@Component
public class MySQLDatabaseBackup
{
	//读取配置文件
	//private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("mysqlbackup");
	/** 
     * Java代码实现MySQL数据库导出 
     *  
     * @param hostIP 
     * @param userName 
     * @param password 
     * @param savePath 
     * @param fileName 
     * @param databaseName 
     * @author QT 
     */  
	//@Scheduled(cron = "0 0/2 * * * ? ")
   /* public void  exportDatabaseTool() throws InterruptedException {  
		ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("mysqlbackup");
    	//MySQL数据库所在服务器地址IP 
    	String hostIP=RESOURCE_BUNDLE.getString("hostIP");
    	//进入数据库所需要的用户名 
    	String userName=RESOURCE_BUNDLE.getString("userName");
    	//进入数据库所需要的密码 
    	String password=RESOURCE_BUNDLE.getString("password");
    	//数据库导出文件保存路径 
    	String savePath=RESOURCE_BUNDLE.getString("savePath")+GetUUID.getUsefulID("SQL")+".sql"; ;
    	String packPath=RESOURCE_BUNDLE.getString("packPath");
    	//要导出的数据库名 
    	String databaseName=RESOURCE_BUNDLE.getString("databaseName");
    	
        String exportCMD = packPath+"mysqldump " + "-u" + userName + " -p" + password + " -h" + hostIP + " " + databaseName + " > " + savePath;
        System.out.println(exportCMD);
        Runtime runtime = Runtime.getRuntime();
        PrintWriter printWriter = null;  
        BufferedReader bufferedReader = null;  
        try {            
        	
        	printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream(savePath), "utf8"));  
	        //-c告诉它读取随后的字符串，exportCMD是要运行的命令。 
	    	Process p=runtime.exec(new String[] {"/bin/sh","-c",exportCMD});
	    	System.out.println("p:"+p);
	    	InputStreamReader inputStreamReader = new InputStreamReader(p.getInputStream(), "utf8");  
            bufferedReader = new BufferedReader(inputStreamReader);  
            String line;  
            while((line = bufferedReader.readLine())!= null){  
                printWriter.println(line);  
            }  
            printWriter.flush();  
            if(p.waitFor() == 0){//0 表示线程正常终止。  
            	System.out.println("备份成功"); 
            }  
            
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }finally {  
            try {  
                if (bufferedReader != null) {  
                    bufferedReader.close();  
                }  
                if (printWriter != null) {  
                    printWriter.close();  
                }  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }        
    }  */
    
}
