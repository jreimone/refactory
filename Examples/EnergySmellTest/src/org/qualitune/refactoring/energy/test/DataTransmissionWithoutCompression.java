package org.qualitune.refactoring.energy.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

/**
 * Example class for demonstrating a data transmission without compression,
 * taken from http://mirror.synyx.de/apache//httpcomponents/httpclient/binary/httpcomponents-client-4.2.2-bin.zip
 * the ClientMultipartFormPost.java and modified.
 */
public class DataTransmissionWithoutCompression {
	
	public static void main(String[] args) throws Exception {
		if (args.length != 1)  {
			System.out.println("File path not given");
			System.exit(1);
		}
		HttpClient httpclient = new DefaultHttpClient();
		try {
			HttpPost httppost = new HttpPost("http://some.url:8080/" +
					"servlets-examples/servlet/RequestInfoExample");
			FileBody bin = new FileBody(new File(args[0]));
			StringBody comment = new StringBody("A binary file of some kind");

			MultipartEntity  reqEntity = new MultipartEntity();
			reqEntity.addPart("bin", bin);
			reqEntity.addPart("comment", comment);

			httppost.setEntity(reqEntity);

			System.out.println("executing request " + httppost.getRequestLine());
			HttpResponse response = httpclient.execute(httppost);
			HttpEntity resEntity = response.getEntity();

			System.out.println("----------------------------------------");
			System.out.println(response.getStatusLine());
			if (resEntity != null) {
				System.out.println("Response content length: " + resEntity.getContentLength());
			}
			EntityUtils.consume(resEntity);
		} finally {
			try { httpclient.getConnectionManager().shutdown(); } catch (Exception ignore) {}
		}

	}
	
	public static void transmitData(String[] args) throws Exception {
		if (args.length != 1)  {
			System.out.println("File path not given");
			System.exit(1);
		}
		HttpClient httpclient = new DefaultHttpClient();
		try {

			HttpPost httppost = new HttpPost("http://some.url:8080/servlets-examples/servlet/RequestInfoExample");
			File file = new File(args[0]);
//			FileBody fileBody = new FileBody(gzipFile(file));
			FileBody fileBody = new FileBody(gzipFile(file)) ;
			StringBody comment = new StringBody("A binary file of some kind");

			MultipartEntity reqEntity = new MultipartEntity();
			reqEntity.addPart("bin", fileBody);
			reqEntity.addPart("comment", comment);

			httppost.setEntity(reqEntity);

			System.out.println("executing request " + httppost.getRequestLine());
			HttpResponse response = httpclient.execute(httppost);
			HttpEntity resEntity = response.getEntity();

			System.out.println("----------------------------------------");
			System.out.println(response.getStatusLine());
			if (resEntity != null) {
				System.out.println("Response content length: " + resEntity.getContentLength());
			}
			EntityUtils.consume(resEntity);
		} finally {
			try { httpclient.getConnectionManager().shutdown(); } catch (Exception ignore) {}
		}

	}

	private static File gzipFile(File uncompressedFile){
		try {
			assert uncompressedFile != null && uncompressedFile.exists();
			File gzippedFile = File.createTempFile(uncompressedFile.getName(), "gz");
			FileInputStream fis = new FileInputStream(uncompressedFile);
			GZIPOutputStream out = new GZIPOutputStream(new FileOutputStream(gzippedFile));
			byte[] buffer = new byte[4096];
			int bytesRead;
			while ((bytesRead = fis.read(buffer)) != -1){
				out.write(buffer,0, bytesRead);
			}
			fis.close();
			out.close();
			return gzippedFile;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
