/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.util.OSSConfigure
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

/**
 * @className:com.xed.financing.wxgzh.util.OSSConfigure
 * @description:
 * @version:v1.0.0 
 * @date:2017年12月4日 下午1:51:55
 * @author:QT
 */
public interface OSSConfigure
{
	 String endpoint="oss-cn-beijing.aliyuncs.com";
     
	 String accessKeyId= "LTAIrfLXdMl02zhk";
	 String accessKeySecret = "I4CZViwAhkFypw2XhNKp82L4VznjIh";
     String bucketName="xedjr";
     String accessUrl="http://"+bucketName+".oss-cn-beijing.aliyuncs.com";
      
   	 String remoteFilePath="mm_icon/";
   	 String subPath_null="img";
}
