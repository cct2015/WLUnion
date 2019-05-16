package com.luer.comm.utils;

import com.luer.comm.bean.NameValue;
import com.luer.config.MyX509TrustManager;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.activation.MimetypesFileTypeMap;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.ConnectException;
import java.net.URL;
import java.net.HttpURLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HttpUtil {
    private static Logger log = LoggerFactory.getLogger(HttpUtil.class);

    public static String httpGet(String url, String method, Map<String, String> params) {

        URL u = null;
        HttpURLConnection con = null;
        String json = com.alibaba.fastjson.JSONObject.toJSONString(params);
        StringBuffer sb = new StringBuffer();
        sb.append("------footfoodapplicationrequestnetwork\r\n");
        sb.append("Content-Disposition:form-data;name=\"");
        sb.append("str");
        sb.append("\"\r\n\r\n");
        sb.append(json);
        sb.append("\r\n");
        sb.append("------footfoodapplicationrequestnetwork--\r\n");

        try {
            u = new URL(url);
            con = (HttpURLConnection) u.openConnection();
            con.setRequestMethod(method);
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setUseCaches(false);
            con.setRequestProperty("Content-Type", "multipart/form-data;boundary=----footfoodapplicationrequestnetwork");
            con.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8");
            con.setRequestProperty("Accept", "*/*");
            con.setRequestProperty("Range", "bytes=" + "");

            OutputStreamWriter osw = new OutputStreamWriter(con.getOutputStream(), "utf-8");
            osw.write(sb.toString());
            osw.flush();
            osw.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                con.disconnect();
            }
        }
        // read return content
        StringBuffer buffer = new StringBuffer();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
            String temp;
            while ((temp = br.readLine()) != null) {
                buffer.append(temp);
                buffer.append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }

    public static String post(String strURL, String params) {
        String result = "error";
        try {
            URL url = new URL(strURL);// 创建连接
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);

            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestMethod("POST"); // 设置请求方式
            connection.setRequestProperty("Accept", "application/json"); // 设置接收数据的格式
            connection.setRequestProperty("Content-Type", "application/json"); // 设置发送数据的格式
            connection.setRequestProperty("Charset", "UTF-8");
            connection.connect();

            OutputStreamWriter out = new OutputStreamWriter(
                    connection.getOutputStream(), "UTF-8"); // utf-8编码
            out.append(params);
            out.flush();
            out.close();

            //获得响应状态
            StringBuffer sb = new StringBuffer();
            int resultCode = connection.getResponseCode();
            if (HttpURLConnection.HTTP_OK == resultCode) {
                String readLine = new String();
                BufferedReader responseReader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
                while ((readLine = responseReader.readLine()) != null) {
                    sb.append(readLine);
                }
                responseReader.close();
            }
            result = sb.toString();

        } catch (IOException e) {
            StringWriter sw = null;
            PrintWriter pw = null;
            try {
                sw = new StringWriter();
                pw = new PrintWriter(sw);
                //将出错的栈信息输出到printWriter中
                e.printStackTrace(pw);
                pw.flush();
                sw.flush();
            } finally {
                if (sw != null) {
                    try {
                        sw.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
                if (pw != null) {
                    pw.close();
                }
            }
            result = sw.toString();
        }
        return result;
    }

    public static String post(String strURL, String params, List<NameValue> headerList) {
        String result = "error";
        try {
            URL url = new URL(strURL);// 创建连接
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);

            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestMethod("POST"); // 设置请求方式
            connection.setRequestProperty("Accept", "application/json"); // 设置接收数据的格式
            connection.setRequestProperty("Content-Type", "application/json"); // 设置发送数据的格式
            connection.setRequestProperty("Charset", "UTF-8");
            if (headerList != null) {
                for (NameValue item : headerList) {
                    connection.addRequestProperty(item.getName(), item.getValue().toString());
                }
            }
            connection.connect();

            OutputStreamWriter out = new OutputStreamWriter(
                    connection.getOutputStream(), "UTF-8"); // utf-8编码
            out.append(params);
            out.flush();
            out.close();

            //获得响应状态
            StringBuffer sb = new StringBuffer();
            int resultCode = connection.getResponseCode();
            if (HttpURLConnection.HTTP_OK == resultCode) {
                String readLine = new String();
                BufferedReader responseReader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
                while ((readLine = responseReader.readLine()) != null) {
                    sb.append(readLine);
                }
                responseReader.close();
            }
            result = sb.toString();

        } catch (IOException e) {
            StringWriter sw = null;
            PrintWriter pw = null;
            try {
                sw = new StringWriter();
                pw = new PrintWriter(sw);
                //将出错的栈信息输出到printWriter中
                e.printStackTrace(pw);
                pw.flush();
                sw.flush();
            } finally {
                if (sw != null) {
                    try {
                        sw.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
                if (pw != null) {
                    pw.close();
                }
            }
            result = sw.toString();
        }
        return result;
    }

    public static String get(String requestUrl, String paraStr) {
        String result ="get_error";
        try {
            URL url = new URL(requestUrl);// 创建连接
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestMethod("GET"); // 设置请求方式
            connection.setRequestProperty("Accept", "application/json"); // 设置接收数据的格式
            connection.setRequestProperty("Content-Type", "application/json"); // 设置发送数据的格式
            connection.connect();
            OutputStreamWriter out = new OutputStreamWriter(
                    connection.getOutputStream(), "UTF-8"); // utf-8编码
            out.append(paraStr);
            out.flush();
            out.close();

            // 当有数据需要提交时
            if (null != paraStr) {
                OutputStream outputStream = connection.getOutputStream();
                // 注意编码格式，防止中文乱码
                outputStream.write(paraStr.getBytes("UTF-8"));
                outputStream.close();
            }

            // 将返回的输入流转换成字符串
            int length = (int) connection.getContentLength();// 获取长度
            InputStream is = connection.getInputStream();
            if (length != -1) {
                byte[] data = new byte[length];
                byte[] temp = new byte[512];
                int readLen = 0;
                int destPos = 0;
                while ((readLen = is.read(temp)) > 0) {
                    System.arraycopy(temp, 0, data, destPos, readLen);
                    destPos += readLen;
                }
                 result = new String(data, "UTF-8"); // utf-8编码
            }
        }
        catch (Exception e) {
            StringWriter sw = null;
            PrintWriter pw = null;
            try {
                sw = new StringWriter();
                pw =  new PrintWriter(sw);
                //将出错的栈信息输出到printWriter中
                e.printStackTrace(pw);
                pw.flush();
                sw.flush();
            } finally {
                if (sw != null) {
                    try {
                        sw.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
                if (pw != null) {
                    pw.close();
                }
            }
            result=sw.toString();
         }
        return result;
    }

    public static String formUpload(String urlStr, File file) {
        String res = "";
        HttpURLConnection conn = null;
        String BOUNDARY = "---------------------------123821742118716"; // boundary就是request头和上传文件内容的分隔符
        try {
            URL url = new URL(urlStr);
            conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(30000);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.1; zh-CN; rv:1.9.2.6)");
            conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);
            OutputStream out = new DataOutputStream(conn.getOutputStream());

            // file
            String inputName = "";
            String filename = file.getName();
            String contentType = new MimetypesFileTypeMap().getContentType(file);
            if (filename.endsWith(".png")) {
                contentType = "image/png";
            }
            if (contentType == null || contentType.equals("")) {
                contentType = "application/octet-stream";
            }

            StringBuffer strBuf = new StringBuffer();
            strBuf.append("\r\n").append("--").append(BOUNDARY).append("\r\n");
            strBuf.append("Content-Disposition: form-data; name=\"" + inputName + "\"; filename=\"" + filename + "\"\r\n");
            strBuf.append("Content-Type:" + contentType + "\r\n\r\n");
            out.write(strBuf.toString().getBytes());
            DataInputStream in = new DataInputStream(new FileInputStream(file));
            int bytes = 0;
            byte[] bufferOut = new byte[1024];
            while ((bytes = in.read(bufferOut)) != -1) {
                out.write(bufferOut, 0, bytes);
            }
            in.close();
            byte[] endData = ("\r\n--" + BOUNDARY + "--\r\n").getBytes();
            out.write(endData);
            out.flush();
            out.close();

            // 读取返回数据
            StringBuffer strBuf2 = new StringBuffer();
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = null;
            while ((line = reader.readLine()) != null) {
                strBuf2.append(line).append("\n");
            }
            res = strBuf2.toString();
            reader.close();
            reader = null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.disconnect();
                conn = null;
            }
        }
        return res;
    }

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

    public static String uploadFile(String urlStr, File file, String params, List<NameValue> headerList) {

        String res = "";
        HttpURLConnection conn = null;
        String BOUNDARY = "---------------------------123821742118716"; // boundary就是request头和上传文件内容的分隔符
        try {
            URL url = new URL(urlStr);
            conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(30000);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0(Windows;U;Windows NT 6.1;zh-CN;rv:1.9.2.6)");
            conn.setRequestProperty("Content-Type","multipart/form-data;boundary=" + BOUNDARY);
            conn.setRequestProperty("Charset", "UTF-8");
            /*添加请求头*/
            if (headerList != null) {
                for (NameValue item : headerList) {
                    conn.addRequestProperty(item.getName(), item.getValue().toString());
                }
            }
            OutputStream out = new DataOutputStream(conn.getOutputStream());

            out.write(params.getBytes());

            // file
            String inputName = "file";
            String filename = file.getName();
            String contentType = new MimetypesFileTypeMap().getContentType(file);
            if(!"".equals(contentType)){
                if (filename.endsWith(".png")) {
                    contentType = "image/png";
                }else if (filename.endsWith(".jpg") || filename.endsWith(".jpeg") || filename.endsWith(".jpe")) {
                    contentType = "image/jpeg";
                }else if (filename.endsWith(".gif")) {
                    contentType = "image/gif";
                }else if (filename.endsWith(".ico")) {
                    contentType = "image/image/x-icon";
                }
            }
            if (contentType == null || contentType.equals("")) {
                contentType = "application/octet-stream";
            }
            StringBuffer strBuf = new StringBuffer();
            strBuf.append("\r\n").append("--").append(BOUNDARY).append("\r\n");
            strBuf.append("Content-Disposition: form-data; name=\"" + inputName + "\"; filename=\"" + filename + "\"\r\n");
            strBuf.append("Content-Type:" + contentType + "\r\n\r\n");
            out.write(strBuf.toString().getBytes());
            DataInputStream in = new DataInputStream(new FileInputStream(file));
            int bytes = 0;
            byte[] bufferOut = new byte[1024];
            while ((bytes = in.read(bufferOut)) != -1) {
                out.write(bufferOut, 0, bytes);
            }
            in.close();
            byte[] endData = ("\r\n--" + BOUNDARY + "--\r\n").getBytes();
            out.write(endData);
            out.flush();
            out.close();

            // 读取返回数据
            StringBuffer strBuf2 = new StringBuffer();
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = null;
            while ((line = reader.readLine()) != null) {
                strBuf2.append(line).append("\n");
            }
            res = strBuf2.toString();
            reader.close();
            reader = null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.disconnect();
                conn = null;
            }
        }
        return res;
    }



}


