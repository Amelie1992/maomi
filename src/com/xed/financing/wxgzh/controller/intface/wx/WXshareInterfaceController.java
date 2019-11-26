package com.xed.financing.wxgzh.controller.intface.wx;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.xed.financing.wxgzh.mapper.param.ParamMapper;
import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
import com.xed.financing.wxgzh.service.accountInfo.AccountInfoService;
import com.xed.financing.wxgzh.util.OOSManager;
import com.xed.financing.wxgzh.util.UploadUtil;

/**
 * 微信分享接口
 * @className:com.xed.financing.wxgzh.controller.wx.WXshareController
 * @description:
 * @version:v1.0.0 
 * @date:2017年10月30日 下午3:59:22
 * @author:Peng Gang
 */
@Controller
@RequestMapping("/ios/wxshareController")
public class WXshareInterfaceController
{
	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(WXshareInterfaceController.class);
	
	@Autowired
	private AccountInfoService accountInfoService;
	
	@Autowired
	private ParamMapper paramMapper;
	/**
	 * 保存图片url到数据库
	 * @Description:
	 * @param upload
	 * @param request
	 * @version:v1.0
	 * @author:Peng Gang
	 * @date:2017年12月12日 下午3:13:55
	 */
	public String keepSubjectPic(String upload,String accountId){
		String code = "0";
		try{
			AccountInfo accountInfo = accountInfoService.iosGetLoginAccountInfo(accountId);
			
			/*限制只能上传一次头像
			if(accountInfoService.checkIcon(accountInfo)){
				accountInfo.setAccountIcon(upload);
				accountInfoService.updateAccountIcon(accountInfo);
				System.out.println("保存图片成功");
			}*/
			accountInfo.setAccountIcon(upload);
			accountInfoService.updateAccountIcon(accountInfo);
			System.out.println("保存图片成功");
			code = "1";
		}catch (Exception e)
		{
			e.printStackTrace();
			System.out.println("保存标图片异常！");
		}
		return code;
	}
	
	
	/**
	 * 
	 * @Description:
	 * @param csvFile
	 * @return
	 * @throws Exception
	 * @version:v1.0
	 * @author:penggang
	 * @date:2018年1月26日 上午11:00:38
	 */
	@RequestMapping("/upload")
	@ResponseBody
    public Map<String,Object> csvUpload(@RequestParam CommonsMultipartFile[] csvFile,String accountId) throws Exception {
		Map<String,Object> obj=new HashMap<String,Object>();
		// 设置标识
		String code = "上传失败";
		String msg = "500";
		try
		{
			String[] uploadFile  = new String[csvFile.length];
			for (int i = 0; i < csvFile.length; i++)
			{
				DiskFileItem fi = (DiskFileItem)csvFile[i].getFileItem(); 
		        File file = fi.getStoreLocation();
		        String upload = OOSManager.uploadFile(file , "mm_icon/img");//data  test
		        upload = upload+ "?x-oss-process=style/add_watermark_maomi";
		        uploadFile[i]=upload;
			}
			//保存到数据库
			keepSubjectPic(uploadFile[0], accountId);
			msg = "上传成功";
			code = "200";
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		obj.put("msg", msg);
		obj.put("code", code);
		return obj;
	}	
	
	/**
	 * ios报错txt上传
	 * @Description:
	 * @param filedatas
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 * @version:v1.0
	 * @author:QT
	 * @date:2018年6月8日 上午9:31:20
	 */
	@ResponseBody
	@RequestMapping(value = "/uploadToFtp")
	public Map<String,Object> uploadToFTP(@RequestParam MultipartFile[] Exception,String verCode) throws IllegalStateException, IOException
	{
		Map<String,Object> map = new HashMap<String,Object>();
		
		String code = "上传失败";
		String msg = "300";
		
		String fileName="";
		
		MultipartFile filedata = Exception[0];
		
		// 判断是否为空
		if (filedata == null || filedata.isEmpty())
		{
			msg = "文件为空";
			code = "301";
		}

		try
		{
			//String picDir = "E:/TOOLS/apache-tomcat-7.0.68/webapps/upload/image";
			String picDir = paramMapper.getParamVal("IOS_FILE_SAVE_URL");
			
			// 保存相对路径到数据库 图片写入服务器
			fileName = UploadUtil.uploadImgToFtp(filedata,picDir,verCode);
			msg = "上传成功";
			code = "200";
			
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		map.put("msg", msg);
		map.put("code", code);
		map.put("fileName", fileName);
		return map;
	}
}	
