package util;

import java.util.UUID;

public class FileNameUtil {
	/**
	 * ����UUID�����ļ���
	 * @return
	 */
	public static String getUUIDFileName(){
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replace("-", "");
	}
	/**
	 * �����ϴ�ȡ���ļ���
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
	 * ��ȡ�ļ�����׺
	 * @param fileName
	 * @return
	 */
	public static String getFileType(String fileName){
		int index = fileName.lastIndexOf(".");
		return fileName.substring(index);
	}
}
