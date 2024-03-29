package com.xed.financing.wxgzh.util;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import sun.misc.BASE64Decoder;

public class UploadTool
{
    /**
     * 上传图片
     * @param base64 图片编码后的字符串
     * @return 上传成功后的文件名
     */
    public static File upload(String base64) {
        //upload是图片上传路径
        String dir ="/upload";
        File fileLocation = new File(dir);
        //判断上传路径是否存在，如果不存在就创建
        if(!fileLocation.exists()) {
            boolean isCreated  = fileLocation.mkdir();
            if(!isCreated) {
                //目标上传目录创建失败,可做其他处理,例如抛出自定义异常等,一般应该不会出现这种情况。
                return null;
            }
        }
        if(base64.indexOf("jpeg") != -1) {
            //base64字串中有jpeg字串，这是一个4个字的，而我这里是把base64字串的指定位置的字串来作为上传
            //文件类型的判断依据，所以在大部分都是三个字的文件类型下就得把jpeg改成jpg了
            base64 = base64.replaceFirst("jpeg", "jpg");
        }
        //生成一个唯一的文件名
        String upName = UUID.randomUUID().toString()+System.currentTimeMillis()+"."+base64.substring(11, 14);
        FileOutputStream out;
        String iconBase64 = base64.substring(22);
        try {
            byte[] buffer = new BASE64Decoder().decodeBuffer(iconBase64);
            out = new FileOutputStream(dir+"/"+upName);
            out.write(buffer);
            out.close();
            String  filePath = dir+"/"+upName;
            File file = new File(filePath);
            return file;

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 上传图片
     * @param base64 图片编码后的字符串
     * @return 上传成功后的文件名
     */
    public static File uploadExcel(HttpServletRequest request,String base64,String fileName) {
        //upload是图片上传路径
        String dir ="/upload";
        File fileLocation = new File(dir);
        //判断上传路径是否存在，如果不存在就创建
        if(!fileLocation.exists()) {
            boolean isCreated  = fileLocation.mkdir();
            if(!isCreated) {
                //目标上传目录创建失败,可做其他处理,例如抛出自定义异常等,一般应该不会出现这种情况。
                return null;
            }
        }
        //生成一个唯一的文件名
        String upName = UUID.randomUUID().toString()+System.currentTimeMillis();
        FileOutputStream out;


        //判断浏览器类型
//        String agent=request.getHeader("User-Agent").toLowerCase();

	    String iconBase64Array[]=base64.split(",");
	
	    String iconBase64 = iconBase64Array[1];
//        
//        if(agent.matches(".*chrome.*")){
//            iconBase64 = iconBase64Array[1];
//        }else if(agent.matches(".*firefox.*")) {
//            iconBase64 = iconBase64Array[1];
//        }
	    
	    String fileflag = "";
	    if (fileName.endsWith(".xls"))
		{
	    	fileflag = ".xls";
		}
		else if (fileName.endsWith(".xlsx"))
		{
			fileflag = ".xlsx";
		}

        try {
        	 String  filePath = dir+"/"+upName+fileflag;
             File file = new File(filePath);
        	
            byte[] buffer = new BASE64Decoder().decodeBuffer(iconBase64);
            out = new FileOutputStream(file);
            out.write(buffer);
            out.close();
           
            return file;

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }
}
