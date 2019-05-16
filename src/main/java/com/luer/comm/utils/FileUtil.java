package com.luer.comm.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Configuration
@EnableCaching
@PropertySource(value = "classpath:/application.properties")
public class FileUtil {

    //将MultipartFile转为File
    public static File ChangeFile(MultipartFile file) {
        File f = null;
        if (file.equals("") || file.getSize() <= 0) {
            file = null;
        } else {
            InputStream ins = null;
            try {
                ins = file.getInputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
            f = new File(file.getOriginalFilename());
            inputStreamToFile(ins, f);
            return f;
        }
        return null;
    }

    //文件操作
    public static void inputStreamToFile(InputStream ins, File file) {
        try {
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 输出指定文件的byte数组
     *
     * @param filePath 文件路径
     * @param os       输出流
     * @return
     */
    public static void writeBytes(String filePath, OutputStream os) throws IOException {
        FileInputStream fis = null;
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                throw new FileNotFoundException(filePath);
            }
            fis = new FileInputStream(file);
            byte[] b = new byte[1024];
            int length;
            while ((length = fis.read(b)) > 0) {
                os.write(b, 0, length);
            }
        } catch (IOException e) {
            throw e;
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    /**
     * 删除文件
     *
     * @param filePath 文件
     * @return
     */
    public static boolean deleteFile(String filePath) {
        boolean flag = false;
        File file = new File(filePath);
        // 路径为文件且不为空则进行删除
        if (file.isFile() && file.exists()) {
            file.delete();
            flag = true;
        }
        return flag;
    }

    /**
     * 默认大小 50M
     */
    public static final long DEFAULT_MAX_SIZE = 52428800;

    /**
     * 默认上传的地址
     */
    @Value("${profile}")
    private String defaultBaseDir;

    public int getServerPort() {
        return serverPort;
    }

    public void setServerPort(int serverPort) {
        this.serverPort = serverPort;
    }

    @Value("${serverPort}")
    private int serverPort;

    /**
     * 默认的文件名最大长度
     */
    public static final int DEFAULT_FILE_NAME_LENGTH = 200;

    /**
     * 默认文件类型jpg
     */
    public static final String IMAGE_JPG_EXTENSION = ".jpg";

    private static int counter = 0;

   /* public static void setDefaultBaseDir(String defaultBaseDir)
    {
        FileUtil.defaultBaseDir = defaultBaseDir;
    }*/

    public String getDefaultBaseDir() {
        return defaultBaseDir;
    }

    /**
     * 以默认配置进行文件上传
     *
     * @param file 上传的文件
     * @return 文件名称
     * @throws Exception
     */
    public final String upload(MultipartFile file) throws IOException {
        try {
            return upload(getDefaultBaseDir(), file, FileUtil.IMAGE_JPG_EXTENSION);
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    /**
     * 根据文件路径上传
     *
     * @param baseDir 相对应用的基目录
     * @param file    上传的文件
     * @return 文件名称
     * @throws IOException
     */
    public static final String upload(String baseDir, MultipartFile file) throws IOException {
        try {
            return upload(baseDir, file, FileUtil.IMAGE_JPG_EXTENSION);
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    /**
     * 文件上传
     *
     * @param baseDir   相对应用的基目录
     * @param file      上传的文件
     * @param extension 上传文件类型
     * @return 返回上传成功的文件名
     * @throws IOException 比如读写文件出错时
     */
    public static final String upload(String baseDir, MultipartFile file, String extension)
            throws Exception {
        int fileNamelength = file.getOriginalFilename().length();
        if (fileNamelength > FileUtil.DEFAULT_FILE_NAME_LENGTH) {
            throw new Exception();
        }
        String fileName = encodingFilename(file.getOriginalFilename(), extension);
        File desc = getAbsoluteFile(baseDir, baseDir + fileName);
        file.transferTo(desc);
        return fileName;
    }

    private static final File getAbsoluteFile(String uploadDir, String filename) throws IOException {
        File desc = new File(File.separator + filename);

        if (!desc.getParentFile().exists()) {
            desc.getParentFile().mkdirs();
        }
        if (!desc.exists()) {
            desc.createNewFile();
        }
        return desc;
    }

    /**
     * 编码文件名
     */
    private static final String encodingFilename(String filename, String extension) {
        filename = filename.replace("_", " ");
        filename = MD5Utils.hash(filename + System.nanoTime() + counter++) + extension;
        return filename;
    }

    public String changeIpToUrl(String path) {
        String[] str = path.split("profile");
        if (str.length > 1) {
            String url = getDefaultBaseDir() + str[1];
            System.out.println("url===============" + url);
            return url;
        }
        return null;
    }

    public static File getFileByURL(String url) {
        File file = new File(url);
        return file;
    }

    public static void main(String[] args) {
        getFileByURL("D:\\profile\\04aade25979d4892801d866746fa5d5a\\cover\0ade2982c8c31a9e890f672af6d6af6f.jpg");
    }

}
