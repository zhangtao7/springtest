package com.springtest.chapter7.exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

	private static void showAvailableBytes(InputStream in) {
		  try {
		   System.out.println("当前字节输入流中的字节数为:" + in.available());
		  } catch (IOException e) {
		   e.printStackTrace();
		  }
		 }
	public static void readFileByBytes() {
		String fileName="C:/project/SimpleTracking.vci";
		  File file = new File(fileName);
		  InputStream in = null;
//		  try {
//		   System.out.println("以字节为单位读取文件内容，一次读一个字节：");
//		   // 一次读一个字节
//		   in = new FileInputStream(file);
//		   int tempbyte;
//		   while ((tempbyte = in.read()) != -1) {
//		    System.out.write(tempbyte);
//		   }
//		   in.close();
//		  } catch (IOException e) {
//		   e.printStackTrace();
//		   return;
//		  }
		  try {
		   //System.out.println("以字节为单位读取文件内容，一次读多个字节：");
		   // 一次读多个字节
		   byte[] tempbytes = new byte[100];
		   int byteread = 0;
		   in = new FileInputStream(fileName);
		   showAvailableBytes(in);
		   // 读入多个字节到字节数组中，byteread为一次读入的字节数
		   while ((byteread = in.read(tempbytes)) != -1) {
		    System.out.write(tempbytes, 0, byteread);
		   }
		  } catch (Exception e1) {
		   e1.printStackTrace();
		  } finally {
		   if (in != null) {
		    try {
		     in.close();
		    } catch (IOException e1) {
		    }
		   }
		  }
		 }
	
	
	public static void read() {
		Path path = Paths.get("C:/project/SimpleTracking.vci"); 
		try {
			
			byte [] by=Files.readAllBytes(path);
			ByteBuffer bu=ByteBuffer.allocate(by.length);
			System.out.println(by);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	public static void main(String[] args) {
		Main.read();
		//Main.readFileByBytes();
	}

}
