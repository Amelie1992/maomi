package com.xed.financing.wxgzh.controller.wx;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
import com.xed.financing.wxgzh.model.subjectpic.SubjectPicBean;
import com.xed.financing.wxgzh.service.accountInfo.AccountInfoService;
import com.xed.financing.wxgzh.service.param.ParamService;
import com.xed.financing.wxgzh.service.subjectpic.SubjectPicService;
import com.xed.financing.wxgzh.util.AuthUtil;
import com.xed.financing.wxgzh.util.GetUUID;
import com.xed.financing.wxgzh.util.OOSManager;
import com.xed.financing.wxgzh.util.ViewJsonUtil;

/**
 * 微信分享接口
 * @className:com.xed.financing.wxgzh.controller.wx.WXshareController
 * @description:
 * @version:v1.0.0 
 * @date:2017年10月30日 下午3:59:22
 * @author:Peng Gang
 */
@Controller
@RequestMapping("/wxshareController")
public class WXshareController
{
	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(WXshareController.class);
	
	@Autowired
	private SubjectPicService subjectPicService;
	
	@Autowired
	private ParamService paramService;
	
	@Autowired
	private AccountInfoService accountInfoService;
	/**
	 * 方法名：getWxConfig</br> 详述：获取微信的配置信息
	 * 
	 * @param request
	 * @return 说明返回值含义
	 * @throws IOException
	 * @throws 说明发生此异常的条件
	 */
	@ResponseBody
	@RequestMapping("/s/getWxConfig")
	public Map<String,Object> getWxConfig(String url, HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		String jsapi_ticket = paramService.getParamVal("JSPAPI_TICKET");
		String timestamp = Long.toString(System.currentTimeMillis()/1000); // 必填，生成签名的时间戳
		
		String nonceStr = GetUUID.getNonceStr(16); // 必填，生成签名的随机串
		String signature = "";
		// 注意这里参数名必须全部小写，且必须有序
		String sign = "jsapi_ticket=" + jsapi_ticket + 
				"&noncestr=" + nonceStr + 
				"&timestamp=" + timestamp + 
				"&url=" + url;
		try
		{
			MessageDigest crypt = MessageDigest.getInstance("SHA-1");
			byte[] digest = crypt.digest(sign.toString().getBytes());
			signature = byteToHex(digest);
		}
		catch (NoSuchAlgorithmException e)
		{
			System.out.println("加密异常");
			e.printStackTrace();
		}
		
		resultMap.put("appId", AuthUtil.APPID);
		resultMap.put("timestamp", timestamp);
		resultMap.put("nonceStr", nonceStr);
		resultMap.put("signature", signature);
		return resultMap;
	}
	

	/**
	 * 方法名：byteToHex</br> 
	 * 详述：字符串加密辅助方法
	 * @param hash
	 * @return 说明返回值含义
	 * @throws 说明发生此异常的条件
	 */
	private String byteToHex(final byte[] hash)
	{
		Formatter formatter = new Formatter();
		for (byte b : hash)
		{
			formatter.format("%02x", b);
		}
		String result = formatter.toString();
		formatter.close();
		return result;
	}

	/**
	 * 获取媒体文件
	 * 
	 * @param accessToken
	 *            接口访问凭证
	 * @param mediaId
	 *            媒体文件id
	 * @param savePath
	 *            文件在本地服务器上的存储路径
	 * */
	@ResponseBody
	@RequestMapping("/wximg")
	public String[] downloadMedia(String[] mediaIds, HttpServletRequest request, HttpServletResponse response)
	{
		String[] path = new String[mediaIds.length];
		
		String accessToken = paramService.getParamVal("ACCESS_TOKEN");
		String savePath = request.getSession().getServletContext().getRealPath(File.separator + "upload/"); 	
		// 拼接请求地址
		
		for(int i = 0; i < mediaIds.length; i++){
			String filePath = "";
			String requestUrl = "http://file.api.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID";
			
			System.out.println("mediaIds :" + mediaIds[i]);
			requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken).replace("MEDIA_ID", mediaIds[i]);
			try
			{
				URL url = new URL(requestUrl);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setDoInput(true);
				conn.setRequestMethod("GET");

				if (!savePath.endsWith("/"))
				{
					savePath += "/";
				}
				// 根据内容类型获取扩展名
				String fileExt = getFileexpandedName(conn.getHeaderField("Content-Type"));
				// 将mediaId作为文件名
				filePath = savePath + mediaIds[i] + fileExt;

				BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
				FileOutputStream fos = new FileOutputStream(new File(filePath));
				
				byte[] buf = new byte[8096];
				int size = 0;
				while ((size = bis.read(buf)) != -1)
					fos.write(buf, 0, size);
				
				fos.close();
				bis.close();

				conn.disconnect();
				String info = String.format("下载媒体文件成功，filePath=" + filePath);
				System.out.println(info);
				//result = "{\"result\":\"success\"}";
				path[i] = filePath;
			}
			catch (Exception e)
			{
				filePath = null;
				String error = String.format("下载媒体文件失败：%s", e);
				System.out.println(error);
				//result = "{\"result\":\"error\"}";
				path[i] = filePath;
			}			
		}
		return path;
	}

	/**
	 * 匹配后缀
	 * @Description:
	 * @param contentType
	 * @return
	 * @version:v1.0
	 * @author:Peng Gang
	 * @date:2017年11月30日 上午9:27:46
	 */
	public String getFileexpandedName(String contentType)
	{
		String fileEndWitsh = "";
		if ("image/jpeg".equals(contentType))
			fileEndWitsh = ".jpg";
		else if("image/jpg".equals(contentType))
			fileEndWitsh = ".jpg";
		else if("image/png".equals(contentType))
			fileEndWitsh = ".png";
		else if("image/gif".equals(contentType))
			fileEndWitsh = ".gif";	
		else if ("audio/mpeg".equals(contentType))
			fileEndWitsh = ".mp3";
		else if ("audio/amr".equals(contentType))
			fileEndWitsh = ".amr";
		else if ("video/mp4".equals(contentType))
			fileEndWitsh = ".mp4";
		else if ("video/mpeg4".equals(contentType))
			fileEndWitsh = ".mp4";
		return fileEndWitsh;
	}
	
	/**
	 * 获取媒体文件
	 * 
	 * @param accessToken
	 *            接口访问凭证
	 * @param mediaId
	 *            媒体文件id
	 * @param savePath
	 *            文件在本地服务器上的存储路径
	 * */
	@ResponseBody
	@RequestMapping("/wxdownpic")
	public ModelAndView downloadPic(String[] mediaIds, HttpServletRequest request, HttpServletResponse response)
	{
		String accessToken = paramService.getParamVal("ACCESS_TOKEN");
			
		String remark = "保存失败";
		boolean flag = false;
		try
		{
			
			String[] uploadFile  = new String[mediaIds.length];
			for (int i = 0; i < mediaIds.length; i++)
			{				
				System.out.println("path :" + mediaIds[i] );
				//先删除服务器上的原图片，
				//上传
		        String upload = OOSManager.uploadWXImage(accessToken, mediaIds[i], "img");
		        upload = upload+ "?x-oss-process=style/add_watermark_maomi";//文件处理
		        //upload = upload+ "?x-oss-process=image/resize,w_100";//对图像的处理
		        
		        //http://xedjr.oss-cn-beijing.aliyuncs.com/mm_icon/img/img_xOPQsFpTRCRqovB_vXCOLG0dVsGcNhu7skcE2u9jW8H1cGQnxs_FIQhV2nv1rSVz.jpg?
		        //x-oss-process=style/add_watermark
		        
		        keepSubjectPic(upload, request);
		        
		        uploadFile[i]=upload;
			}
			remark = "保存成功";
			flag = true;
		}
		catch (Exception e)
		{
			flag = false;
			remark = "保存失败";
		}
		return ViewJsonUtil.promptMessage(flag, remark);	
	}
	
	/**
	 * 保存图片url到数据库
	 * @Description:
	 * @param upload
	 * @param request
	 * @version:v1.0
	 * @author:Peng Gang
	 * @date:2017年12月12日 下午3:13:55
	 */
	public void keepSubjectPic(String upload, HttpServletRequest request){
		try{
			AccountInfo accountInfo = (AccountInfo) request.getSession().getAttribute("account");
			
			/*限制只能上传一次头像
			if(accountInfoService.checkIcon(accountInfo)){
				accountInfo.setAccountIcon(upload);
				accountInfoService.updateAccountIcon(accountInfo);
				System.out.println("保存图片成功");
			}*/
			accountInfo.setAccountIcon(upload);
			accountInfoService.updateAccountIcon(accountInfo);
			System.out.println("保存图片成功");
			
		}catch (Exception e)
		{
			e.printStackTrace();
			System.out.println("保存标图片异常！");
		}
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
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	@ResponseBody
    public Map<String,Object> csvUpload(@RequestParam CommonsMultipartFile[] csvFile, HttpServletRequest request) throws Exception {
		Map<String,Object> resultMap=new HashMap<String,Object>();
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
			//只上传一张
			resultMap.put("result", "success");
			
			//保存到数据库
			keepSubjectPic(uploadFile[0], request);
		}
		catch (Exception e)
		{
			resultMap.put("result", "error");
			e.printStackTrace();
		}
		return resultMap;
	}	
}	
