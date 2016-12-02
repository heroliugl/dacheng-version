package com.dacheng.push.utils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

public class FileUtils {
	/**
	 * 上传文件
	 * @param request
	 * @param String tagPath
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	public static String upload(HttpServletRequest request, String tagPath) throws IllegalStateException, IOException{
		try {
			String path = "";
			CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());  
			if (multipartResolver.isMultipart(request)) {
				MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;  
				Iterator<String> iter = multiRequest.getFileNames();
				while (iter.hasNext()) {
					MultipartFile file = multiRequest.getFile(iter.next()); 
					if (file != null) {
						String fileName = file.getOriginalFilename(); 
						path = request.getSession().getServletContext().getRealPath(tagPath) + "\\" + fileName;
						
						InetAddress addr = InetAddress.getLocalHost();
						
						StringBuffer filePath = new StringBuffer("http://");
						//获得外网IP地址
						filePath.append(addr.getHostAddress());
						filePath.append(":");
						//获得端口号
						filePath.append(request.getServerPort());
						//获得项目名
						filePath.append(request.getContextPath());
						filePath.append("/");
						//获得目标文件夹
						filePath.append(tagPath);
						filePath.append("/");
						//获得文件名
						filePath.append(fileName);
						
						//创建文件夹
						buildFile(path, true);

						File localFile = new File(path);
						file.transferTo(localFile);
						
						return filePath.toString();
					}  
				}  
			}  
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * /读文件夹下所有内容
	 * @param filepath
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static boolean readfile(String filepath) throws FileNotFoundException, IOException {
		try {

			File file = new File(filepath);
			if (!file.isDirectory()) {
				System.out.println("文件");
				System.out.println("path=" + file.getPath());
				System.out.println("absolutepath=" + file.getAbsolutePath());
				System.out.println("name=" + file.getName());

			} else if (file.isDirectory()) {
				String[] filelist = file.list();
				for (int i = 0; i < filelist.length; i++) {
					File readfile = new File(filepath + "\\" + filelist[i]);
					if (!readfile.isDirectory()) {
						file = new File(readfile.getPath());
						System.out.println("fileName :---------- " + file.getName());
						InputStream in = new BufferedInputStream(new FileInputStream(file));  
						InputStreamReader isr = new InputStreamReader(in,"GBK");
	                    BufferedReader br = new BufferedReader(isr);  
	                    String line;  
	                    while ((line = br.readLine()) != null) {
	                        System.out.println(line);
	                    }  

					} else if (readfile.isDirectory()) {
						readfile(filepath + "\\" + filelist[i]);
					}
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("readfile()   Exception:" + e.getMessage());
		}
		return true;
	}

	/**
	 * 潘东是文件夹还是文件，创建文件夹方法
	 */
    public static File buildFile(String fileName, boolean isDirectory) {
		File target = new File(fileName);
		
		//查看文件绝对路径
//		Object s=  target.getAbsolutePath();
//		Object s2=  target.getAbsoluteFile();
				
		if (isDirectory) {
			target.mkdirs();
		} else {
			if (!target.getParentFile().exists()) {
				target.getParentFile().mkdirs();
				target = new File(target.getAbsolutePath());
			}
		}
		return target;
	}
    
    public static boolean fileDownload(String urlString, String localFile) {
		URL url;
		byte[] buffer = new byte[512];
		int size = 0;
		boolean success = false;
		try {
			url = new URL(urlString);
			BufferedInputStream stream = new BufferedInputStream(url.openStream());
			FileOutputStream fos = new FileOutputStream(localFile);
			while ((size = stream.read(buffer)) != -1) {
				fos.write(buffer, 0, size);
			}
			fos.close();
			stream.close();
			success = true;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return success;
	}
    
    /**
     * 读取文件内容
     * @param path 文件路径
     * @param encoding 编码格式
     * @return
     */
    public static String readFileContext(String path, String encoding){
		StringBuffer sb = new StringBuffer();
		try {
			File file = new File(path);
//			if (file.isFile() && file.exists()) {	// 判断文件是否存在
				InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);	// 考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					sb.append(lineTxt);
//					System.out.println(sb.toString());
				}
				read.close();
//				System.out.println(sb.toString());
//			} else {
//				System.out.println("找不到指定的文件");
//				return "找不到指定的文件";
//			}
		} catch (IOException e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		}
		return sb.toString();
	}
    
	/**
	 * 将字符串写入文件方法
	 * @param path
	 * @param fileContext
	 */
	public static int writerFileContext(String path, String fileContext){
		try {
	        FileWriter writer = new FileWriter(path);
            writer.write(fileContext);
            writer.flush();
            writer.close();
            return 1;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}
    
//	潘东写的
//	/**
//	 * 上传文件
//	 * @param request
//	 * @param String tagPath
//	 * @return
//	 * @throws IllegalStateException
//	 * @throws IOException
//	 */
//	public static String upload(HttpServletRequest request, String tagPath) throws IllegalStateException, IOException{
//		 String path = "";
//		 CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());  
//         if (multipartResolver.isMultipart(request)) {
//             MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;  
//             Iterator<String> iter = multiRequest.getFileNames();
//             while (iter.hasNext()) {  
//                 MultipartFile file = multiRequest.getFile(iter.next()); 
//                 if (file != null) {
//                     String fileName = UUID.randomUUID() + file.getOriginalFilename();  
//                     path = request.getRealPath(tagPath) +"\\"+fileName ;
//                     File localFile = new File(path);
//                     file.transferTo(localFile);
//                 }  
//             }  
//         }  
//        return path;
//	}
}
