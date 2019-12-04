package com.clm.Service;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

public class UploadImageService {
	public static String uploadImage(String filePath)
	{
		String accessKey = "YVXU5teck1KGqFKvXee9su34fNbrH0jSVSm_IfPo";
		String secretKey = "nSne1yeq5GAfJgThaNKCEzpu-Bi672hBmO5cmNS3";
		String bucket = "superslc";

		Configuration configuration = new Configuration(Zone.zone2());
		UploadManager manager = new UploadManager(configuration);
		String key =null;

		Auth auth = Auth.create(accessKey, secretKey);
		String upToken = auth.uploadToken(bucket);
		String localFilePath = filePath;
		DefaultPutRet set=null;
		try {
			Response response = manager.put(localFilePath, key, upToken);
			set = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
			//System.out.println(set.key);
			//System.out.println(set.hash);

		} catch (QiniuException e) {
			e.printStackTrace();
		}
		return "http://sss.superslc.com/"+set.hash;
	}
	public static void main(String[] args)
	{
		System.out.println(uploadImage("/Users/wanghanyi/Desktop/1.png"));
	}
}
