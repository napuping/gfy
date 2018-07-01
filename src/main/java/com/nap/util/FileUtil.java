
package com.nap.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;

public class FileUtil {
    
    public static boolean deleteFile(String path){
        File file = new File(path);
        if(file.exists()){
            return file.delete();
        }
        return true;
    }
    
    //上传
    public static String upload(String rootDir,
            String filepath,String filename,InputStream inputStream){
        if(StringUtils.isEmpty(rootDir) || StringUtils.isEmpty(inputStream))
            return null;
        File file = new File(rootDir + filepath);
        if(!file.exists())
            file.mkdirs();
        BufferedInputStream bin = null;
        BufferedOutputStream bout  = null;
        try {
            bin = new BufferedInputStream(inputStream);
            bout = new BufferedOutputStream(new FileOutputStream(new File(file, filename)));
            byte[] b = new byte[1024];
            int len = -1;
            while((len = bin.read(b)) != -1)
                bout.write(b, 0, len);
            return filepath + filename;
        } catch(Exception e) {
          e.printStackTrace();
        }finally {
            try {
                if(bout != null)
                    bout.close();
            } catch(Exception e2) {
            }
            try {
                if(bin != null)
                    bin.close();
            } catch(Exception e2) {
            }
        }
        return null;
    }
    
    //下载
    public static void download(String path,String filename,HttpServletResponse response){
        try {
            response.setHeader("Content-Disposition",
                    "attachment;filename=" + new String(filename.getBytes("utf-8"),"iso-8859-1"));
        } catch(UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        BufferedInputStream bin = null;
        BufferedOutputStream bout  = null;
        try {
            bin = new BufferedInputStream(new FileInputStream(path));
            bout = new BufferedOutputStream(response.getOutputStream());
            byte[] b = new byte[2048];
            int len = -1;
            while((len = bin.read(b)) != -1)
                bout.write(b, 0, len);
        } catch(Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(bout != null)
                    bout.close();
            } catch(Exception e2) {
            }
            try {
                if(bin != null)
                    bin.close();
            } catch(Exception e2) {
            }
        }
    }
}
