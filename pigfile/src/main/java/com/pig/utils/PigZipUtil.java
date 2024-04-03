package com.pig.utils;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class PigZipUtil {
    public static int buffSize = 4096;

    /**
     * create
     */
    public String createZip(String[] files) {
        String zipFileName = "zipName.zip";
        File zipFile = new File(zipFileName);
        if (!zipFile.getParentFile().exists()) {
            zipFile.getParentFile().mkdirs();
        }
        if (!zipFile.exists()) {
            try {
                zipFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return zipFileName;
    }

    /**
     * compress
     *
     * @param file
     * @param ifDel
     */
    public static void compressZip(File file, boolean ifDel) {
        String fName = file.getPath();
        String zipFileName = fName + ".zip";
        File zipFile = new File(zipFileName);
        if (!zipFile.exists()) {
            try {
                zipFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        ZipOutputStream zipOutputStream = null;
        BufferedInputStream bufferInputStream = null;
        try {
            // zipFileName为压缩文件的名称 xx.zip,
            fileOutputStream = new FileOutputStream(zipFile);
            zipOutputStream = new ZipOutputStream(new BufferedOutputStream(fileOutputStream));
            // 创建读写缓冲区
            byte[] bufs = new byte[buffSize];
            if (file.exists()) {
                ZipEntry zipEntry = new ZipEntry(file.getName());
                zipOutputStream.putNextEntry(zipEntry);
                fileInputStream = new FileInputStream(file);
                bufferInputStream = new BufferedInputStream(fileInputStream, buffSize);
                int read = 0;
                while ((read = bufferInputStream.read(bufs, 0, buffSize)) != -1) {
                    zipOutputStream.write(bufs, 0, read);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ifDel) {
                file.delete();
            }
            try {
                if (bufferInputStream != null) {
                    bufferInputStream.close();
                }
                if (zipOutputStream != null) {
                    zipOutputStream.close();
                }
                fileInputStream.close();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        compressZip(new File("/tmp/a.txt"), false);
    }

}
