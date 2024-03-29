package com.pig.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class UnzipFileUtil {

    private UnzipFileUtil(){}

    /**
     * 解压到指定目录
     */
    public static File unZipFiles(String zipPath) {
        return unZipFiles(new File(zipPath), new File("").getAbsolutePath());
    }

    /**
     * 解压文件到指定目录
     */
    public static File unZipFiles(File zipFile, String descDir) {
        File pathFile = new File(descDir);
        if (!pathFile.exists()) {
            boolean ifSuccess = pathFile.mkdirs();
            System.out.println("pathFile.mkdirs()= " + ifSuccess);
        }
        List<File> fileLilst = new ArrayList<>();
        // 解决zip文件中有中文目录或者中文文件
        try(ZipFile zip = new ZipFile(zipFile, Charset.forName("GBK"))) {
            for (Enumeration entries = zip.entries(); entries.hasMoreElements();) {
                ZipEntry entry = (ZipEntry) entries.nextElement();
                String zipEntryName = entry.getName();
                InputStream in = zip.getInputStream(entry);
                String outPath = (descDir +File.separator+ zipEntryName);
                // 判断路径是否存在,不存在则创建文件路径
                // 判断文件全路径是否为文件夹,如果是上面已经上传,不需要解压
                if (new File(outPath).isDirectory()) {
                    continue;
                }
                // 路径信息
                System.out.println(outPath);
                try(OutputStream out = new FileOutputStream(outPath)) {
                    byte[] buf1 = new byte[1024];
                    int len;
                    while ((len = in.read(buf1)) > 0) {
                        out.write(buf1, 0, len);
                    }
                    in.close();
                    out.close();
                    fileLilst.add(new File(outPath));
                }catch (Exception ex){ ex.printStackTrace(); }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (fileLilst.isEmpty())
            return null;
        return fileLilst.get(0);
    }
}
