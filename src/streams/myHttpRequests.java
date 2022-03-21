package streams;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Base64;

import javafx.scene.image.Image;


/**
 * This class encapsulate 
 * @author BONGINKOSI
 *
 */
public class myHttpRequests {
	private BufferedReader  br = null;
	private DataOutputStream dos = null;
	private FileInputStream fis = null;


	public myHttpRequests(Socket s) {
		try {
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));	
			dos = new DataOutputStream(new BufferedOutputStream(s.getOutputStream()));
			System.out.println("Streams were successfully established");
		} catch (IOException e) {
			System.err.println("There was an error, streams were not established");
		}	
	}
	
	
	public Image getCannyEdges(File img)
	{
		Image resultImg = null;
		
		try {
			fis = new FileInputStream(img);
			byte[] bytes = new byte[(int)img.length()];
			fis.read(bytes);
			
			//encoding file 
			var  encodedFile = new String(Base64.getEncoder().encodeToString(bytes));
			var bytesToSend = encodedFile.getBytes();
			
			
			dos.write(("POST /api/Canny HTTP/1.1\r\n").getBytes());
			dos.write(("Content-Type: Application/text\r\n").getBytes());
			dos.write(("Content-Length: "+encodedFile.length()+"\r\n").getBytes());
			dos.write("\r\n".getBytes());
			dos.write(bytesToSend);
			dos.flush();
			dos.write("\r\n".getBytes());
			
			String reader = "";
			String response = "";
			
			while(!(reader = br.readLine()).equals(""))
			{
				response += reader +"\n";
			}
			
			System.out.println(response);
			
			String imageData = "";
			
			while((reader = br.readLine())!=null)
			{
				imageData += reader;
			}
			//System.out.println(imageData + "Wow");
			
			String base64Sreing = imageData.substring(imageData.indexOf('\'')+1,imageData.lastIndexOf('}')-1);
			System.out.println(base64Sreing);
			
			byte[] decoder = Base64.getDecoder().decode(base64Sreing);
			resultImg = new Image(new ByteArrayInputStream(decoder));
			
		} catch (FileNotFoundException e) {
			System.err.println("Http request class cannot find file input stream an image");
			
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("The system was unable to send the CannyEdges request");
		
		}finally
		{
			try {
				
				fis.close();
			
			} catch (IOException e) {
				
				System.err.println("System failed to close file input stream");
			
			}
		}
				
		return resultImg;
	}
	
	
	public Image getGrayScale(File img)
	{
		Image resultImg = null;
		
		try {
			fis = new FileInputStream(img);
			byte[] bytes = new byte[(int)img.length()];
			fis.read(bytes);
			
			//encoding file 
			var  encodedFile = new String(Base64.getEncoder().encodeToString(bytes));
			var bytesToSend = encodedFile.getBytes();
			
			
			dos.write(("POST /api/GrayScale HTTP/1.1\r\n").getBytes());
			dos.write(("Content-Type: Application/text\r\n").getBytes());
			dos.write(("Content-Length: "+encodedFile.length()+"\r\n").getBytes());
			dos.write("\r\n".getBytes());
			dos.write(bytesToSend);
			dos.flush();
			dos.write("\r\n".getBytes());
			
			String reader = "";
			String response = "";
			
			while(!(reader = br.readLine()).equals(""))
			{
				response += reader +"\n";
			}
			
			System.out.println(response);
			
			String imageData = "";
			
			while((reader = br.readLine())!=null)
			{
				imageData += reader;
			}
			//System.out.println(imageData + "Wow");
			
			String base64Sreing = imageData.substring(imageData.indexOf('\'')+1,imageData.lastIndexOf('}')-1);
			System.out.println(base64Sreing);
			
			byte[] decoder = Base64.getDecoder().decode(base64Sreing);
			resultImg = new Image(new ByteArrayInputStream(decoder));
			
		} catch (FileNotFoundException e) {
			System.err.println("Http request class cannot find file input stream an image");
			
		} catch (IOException e) {
			e.printStackTrace();
			//System.err.println("The system was unable to send the GrayScale request");
		
		}finally
		{
			try {
				
				fis.close();
			
			} catch (IOException e) {
				
				System.err.println("System failed to close file input stream");
			
			}
		}
				
		return resultImg;
	}
	
	
	public Image getErosion(File img)
	{
		Image resultImg = null;
		
		try {
			fis = new FileInputStream(img);
			byte[] bytes = new byte[(int)img.length()];
			fis.read(bytes);
			
			//encoding file 
			var  encodedFile = new String(Base64.getEncoder().encodeToString(bytes));
			var bytesToSend = encodedFile.getBytes();
			
			
			dos.write(("POST /api/GrayScale HTTP/1.1\r\n").getBytes());
			dos.write(("Content-Type: Application/text\r\n").getBytes());
			dos.write(("Content-Length: "+encodedFile.length()+"\r\n").getBytes());
			dos.write("\r\n".getBytes());
			dos.write(bytesToSend);
			dos.flush();
			dos.write("\r\n".getBytes());
			
			String reader = "";
			String response = "";
			
			while(!(reader = br.readLine()).equals(""))
			{
				response += reader +"\n";
			}
			
			System.out.println(response);
			
			String imageData = "";
			
			while((reader = br.readLine())!=null)
			{
				imageData += reader;
			}
			//System.out.println(imageData + "Wow");
			
			String base64Sreing = imageData.substring(imageData.indexOf('\'')+1,imageData.lastIndexOf('}')-1);
			System.out.println(base64Sreing);
			
			byte[] decoder = Base64.getDecoder().decode(base64Sreing);
			resultImg = new Image(new ByteArrayInputStream(decoder));
			
			try 
			{
				
				fis.close();
			
			} catch (IOException e) {
				
				System.err.println("System failed to close file input stream");
			
			}
			
		} catch (FileNotFoundException e) {
			System.err.println("Http request class cannot file input stream an image");
			
		} catch (IOException e) {
			System.err.println("The system was unable to send the  request");
		}finally
		{
			try {
				
				fis.close();
			
			} catch (IOException e) {
				
				System.err.println("System failed to close file input stream");
			
			}
		}
				
		return resultImg;
	}
	
	public Image getDilation(File img)
	{
		Image resultImg = null;
		
		try {
			fis = new FileInputStream(img);
			byte[] bytes = new byte[(int)img.length()];
			fis.read(bytes);
			
			//encoding file 
			var  encodedFile = new String(Base64.getEncoder().encodeToString(bytes));
			var bytesToSend = encodedFile.getBytes();
			
			
			dos.write(("POST /api/Dilation HTTP/1.1\r\n").getBytes());
			dos.write(("Content-Type: Application/text\r\n").getBytes());
			dos.write(("Content-Length: "+encodedFile.length()+"\r\n").getBytes());
			dos.write("\r\n".getBytes());
			dos.write(bytesToSend);
			dos.flush();
			dos.write("\r\n".getBytes());
			
			String reader = "";
			String response = "";
			
			while(!(reader = br.readLine()).equals(""))
			{
				response += reader +"\n";
			}
			
			System.out.println(response);
			
			String imageData = "";
			
			while((reader = br.readLine())!=null)
			{
				imageData += reader;
			}
			//System.out.println(imageData + "Wow");
			
			String base64Sreing = imageData.substring(imageData.indexOf('\'')+1,imageData.lastIndexOf('}')-1);
			System.out.println(base64Sreing);
			
			byte[] decoder = Base64.getDecoder().decode(base64Sreing);
			resultImg = new Image(new ByteArrayInputStream(decoder));
			
		} catch (FileNotFoundException e) {
			System.err.println("Http request class cannot file input stream an image");
			
		} catch (IOException e) {
			System.err.println("The system was unable to send the Dilation request");
			e.printStackTrace();
		}finally
		{
			try {			
				fis.close();		
			} catch (IOException e) {
				
				System.err.println("System failed to close file input stream");
			
			}
		}
				
		return resultImg;
	}
	
}
