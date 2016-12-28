package com.spearbothy.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;

public class FileAction extends BaseAction {
	private File img;
	// 封装上传文件类型的属性
	private String imgContentType;
	// 封装上传文件名的属性
	private String imgFileName;

	@Action("uploadfile")
	public void uploadImg() {

		Map<String, Object> result = new HashMap<>();

		String rootPath = ServletActionContext.getServletContext().getRealPath("");

		String savePath = "";

		// 目录打散
		String childDirectory = makeChildDirectory( imgFileName);

		savePath = File.separator + "uploadImg" + File.separator + childDirectory + File.separator
				+ imgFileName;

		File saveFile = new File(rootPath,savePath);
		
		if(!saveFile.getParentFile().exists()){
			saveFile.getParentFile().mkdirs();
		}
		
		try {
			// 文件上传
			InputStream is = new FileInputStream(img);
			FileOutputStream fos = new FileOutputStream(saveFile);
			int len = -1;

			byte[] buffer = new byte[8192];

			while ((len = is.read(buffer)) != -1) {
				fos.write(buffer, 0, len);
			}

			is.close();
			fos.close();

			result.put("success", 1 );
			result.put("message", "上传成功");
			result.put("url", savePath);

		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", 0 );
			result.put("message", "上传失败");
		}

		writeJson(result);
	}

	// 目录打散
	private String makeChildDirectory(String filename) {

		int hashcode = filename.hashCode();// 返回字符转换的32位hashcode码
		String code = Integer.toHexString(hashcode); // 把hashcode转换为16进制的字符
		String childDirectory = UUID.randomUUID().toString().substring(0, 2) + File.separator + code.charAt(0)
				+ File.separator + code.charAt(1); // a/b
		return childDirectory;
	}

	public File getImg() {
		return img;
	}

	public void setImg(File img) {
		this.img = img;
	}

	public String getImgContentType() {
		return imgContentType;
	}

	public void setImgContentType(String imgContentType) {
		this.imgContentType = imgContentType;
	}

	public String getImgFileName() {
		return imgFileName;
	}

	public void setImgFileName(String imgFileName) {
		this.imgFileName = imgFileName;
	}

}
