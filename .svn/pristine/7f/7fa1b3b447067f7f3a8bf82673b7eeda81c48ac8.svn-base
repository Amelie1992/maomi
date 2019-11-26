/**
 * Copyright (C) 2018 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.util.UploadUtil
 * @description:
 * 
 * @version:v1.0.0 
 * @author:QT
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2018年6月8日    	QT  		v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * @className:com.xed.financing.wxgzh.util.UploadUtil
 * @description:
 * @version:v1.0.0 
 * @date:2018年6月8日 上午9:32:12
 * @author:QT
 */
public class UploadUtil
{
	public static String uploadImgToFtp(@RequestParam MultipartFile filedata,String picDir,String verCode) throws SQLException, IOException
	{
		  // 获取图片的文件名
        String fileName = filedata.getOriginalFilename();
        // 获取图片的扩展名
        String extensionName = fileName
                .substring(fileName.lastIndexOf(".") + 1);
        // 新的图片文件名 = 获取时间戳+"."图片扩展名
        String newFileName = verCode+"版本"+GetUUID.getUsefulID("")
                + "." + extensionName;

        // 根据配置文件获取服务器图片存放路径
       
        String saveFilePath = picDir;

        /* 构建文件目录 */
        File fileDir = new File(saveFilePath);
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }

        try {
            FileOutputStream out = new FileOutputStream(saveFilePath + "\\"
                    + newFileName);
            // 写入文件
            out.write(filedata.getBytes());
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newFileName;
	}
}
