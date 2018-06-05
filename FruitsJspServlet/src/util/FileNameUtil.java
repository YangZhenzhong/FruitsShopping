package util;

import java.util.UUID;

public class FileNameUtil {
	/**
	 * 根据UUID生成文件名
	 * @return
	 */
	public static String getUUIDFileName(){
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replace("-", "");
	}
	/**
	 * 根据上传取出文件名
	 * @param context
	 * @return
	 */
	public static String getRealFileName(String context){
		//form-data; name="upfile"; filename="bag.jpg"
		int index = context.lastIndexOf("=");
		String filename = context.substring(index+2,context.length()-1);
		return filename;
	}
	/**
	 * 获取文件名后缀
	 * @param fileName
	 * @return
	 */
	public static String getFileType(String fileName){
		int index = fileName.lastIndexOf(".");
		return fileName.substring(index);
	}
}
