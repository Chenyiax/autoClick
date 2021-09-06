package com.a.main;

import net.sf.json.JSONObject;

import javax.net.ssl.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class post {

    public static void postMessage(String id, String url) {
//        String id = "19407020611";
//        String url="https://ehallplatform.xust.edu.cn/default/jkdk/mobile/mobJkdkAdd_test.jsp?uid=QTJFQTRGOEZBNkIyRDNGQ0Y3MEQ1Q0YwQkVCODYyMjQ=";
        String cookie = getCookie(url);
        String message = getMessage(id, cookie);
        System.out.println(sendHtpps(changeMessage(message),cookie));
    }

    private final static HostnameVerifier DO_NOT_VERIFY = new HostnameVerifier() {
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    };

    private static void trustAllHosts() {
        // Create a trust manager that does not validate certificate chains
        TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return new java.security.cert.X509Certificate[]{};
            }

            public void checkClientTrusted(X509Certificate[] chain, String authType) {
            }

            public void checkServerTrusted(X509Certificate[] chain, String authType) {
            }
        }};
        // Install the all-trusting trust manager
        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String changeMessage(String message) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + 1);

        JSONObject jo = JSONObject.fromObject(message);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("procinstid", "");
        jsonObject.put("empid", jo.get("EMPID"));
        jsonObject.put("shzt", jo.get("SHZT"));
        jsonObject.put("id", "");
        jsonObject.put("jrrq1", new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));//
        jsonObject.put("sjh2", jo.get("SJH2"));
        jsonObject.put("jrsfzx3", jo.get("JRSFZX3"));
        jsonObject.put("szdd4", jo.get("SZDD4"));
        jsonObject.put("xxdz41", jo.get("XXDZ4_1"));
        jsonObject.put("jrtwfw5", jo.get("JRTWFW5"));
        jsonObject.put("jrsfjgwh6", jo.get("JRSFJGWH6"));
        jsonObject.put("jrsfjghb7", jo.get("JRSFJGHB7"));
        jsonObject.put("jrsfcxfrzz8", jo.get("JRSFCXFRZZ8"));
        jsonObject.put("jrsfywhrjc9", jo.get("JRSFYWHRJC9"));
        jsonObject.put("jrsfyhbrjc10", jo.get("JRSFYHBRJC10"));
        jsonObject.put("jrsfjcgrrq11", jo.get("JRSFJCGRRQ11"));
        jsonObject.put("jssfyqzysgl12", jo.get("JRSFJGHB7"));
        jsonObject.put("sfcyglq13", jo.get("SFCYGLQ13"));
        jsonObject.put("glkssj131", "");
        jsonObject.put("gljssj132", "");
        jsonObject.put("sfyyqxgzz14", jo.get("SFYYQXGZZ14"));
        jsonObject.put("qtxx15", null);
        jsonObject.put("gh", jo.get("GH"));
        jsonObject.put("xm", jo.get("XM"));
        jsonObject.put("xb", jo.get("XB"));
        jsonObject.put("sfzh", "");
        jsonObject.put("szyx", jo.get("SZYX"));
        jsonObject.put("xydm", jo.get("XYDM"));
        jsonObject.put("zy", "");
        jsonObject.put("zydm", "");
        jsonObject.put("bj", jo.get("BJ"));
        jsonObject.put("bjdm", jo.get("BJDM"));
        jsonObject.put("jg", "");
        jsonObject.put("yx", "");
        jsonObject.put("sfxs", jo.get("SFXS"));
        jsonObject.put("xslx", jo.get("XSLX"));
        jsonObject.put("jingdu", jo.get("JINGDU"));
        jsonObject.put("weidu", jo.get("WEIDU"));
        jsonObject.put("guo", "中国");
        jsonObject.put("sheng", jo.get("SHENG"));
        jsonObject.put("shi", jo.get("SHI"));
        jsonObject.put("xian", jo.get("XIAN"));
        jsonObject.put("sfncxaswfx16", jo.get("SFNCXASWFX16"));
        jsonObject.put("dm", "4006078");
        jsonObject.put("jdlx", jo.get("JDLX"));
        jsonObject.put("tbsj", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));//
        jsonObject.put("fcjtgj17Qt", "");
        jsonObject.put("fcjtgj17", "");
        jsonObject.put("hqddlx", jo.get("HQDDLX"));
        jsonObject.put("ymtys", "");
        jsonObject.put("time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));//new SimpleDateFormat("yyyy-MM-dd").format(new Date())
        JSONObject jb = new JSONObject();
        jb.put("xkdjkdk",jsonObject.toString());
        System.out.println(jb.toString());
        return jb.toString();
    }

    private static String getCookie(String url) {
        OutputStreamWriter out = null;
        BufferedReader in = null;
        HttpURLConnection conn;
        try {
            trustAllHosts();
            URL realUrl = new URL(url);
            HttpsURLConnection https = (HttpsURLConnection) realUrl.openConnection();
            https.setHostnameVerifier(DO_NOT_VERIFY);
            conn = https;

            // 设置通用的请求属性
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.138 Safari/537.36");
            conn.setRequestProperty("Host", "ehallplatform.xust.edu.cn");

            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 定义BufferedReader输入流来读取URL的响应
            out = new OutputStreamWriter(conn.getOutputStream(), "utf-8");
            //错误方式，这种方式容易出现乱码
            // PrintWriter out = new PrintWriter(connection.getOutputStream());
            /*out.print(a);*/
            // flush输出流的缓冲
            out.flush();
            Map<String, List<String>> map = conn.getHeaderFields();
            String s = map.get("Set-Cookie").get(0);
            return s.substring(0, s.indexOf(";"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String getMessage(String id, String cookie) {
        String url="http://ehallplatform.xust.edu.cn/default/jkdk/mobile/com.primeton.eos.jkdk.xkdjkdkbiz.getJkdkRownum.biz.ext?gh=";
        String result = "";
        OutputStreamWriter out = null;
        BufferedReader in = null;
        HttpURLConnection conn;
        try {
            trustAllHosts();
            URL realUrl= new URL(null, url+id, new sun.net.www.protocol.https.Handler());
            HttpsURLConnection https = (HttpsURLConnection) realUrl.openConnection();
            https.setHostnameVerifier(DO_NOT_VERIFY);
            conn = https;

            // 设置通用的请求属性
            conn.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.138 Safari/537.36");
            conn.setRequestProperty("Cookie", cookie);

            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 定义BufferedReader输入流来读取URL的响应
            out = new OutputStreamWriter(conn.getOutputStream(), "utf-8");
            //错误方式，这种方式容易出现乱码
            // PrintWriter out = new PrintWriter(connection.getOutputStream());
            /*out.print(a);*/
            // flush输出流的缓冲
            out.flush();

            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }

            JSONObject jsonobject = JSONObject.fromObject(result);
            String message = jsonobject.optString("list").substring(1,jsonobject.optString("list").length()-1);
            return message;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String sendHtpps(String a,String cookie) {
        String url="https://ehallplatform.xust.edu.cn/default/jkdk/mobile/com.primeton.eos.jkdk.xkdjkdkbiz.jt.biz.ext";
        String result = "";
        OutputStreamWriter out = null;
        BufferedReader in = null;
        HttpURLConnection conn;
        try {
            trustAllHosts();
            URL realUrl = new URL(url);
            HttpsURLConnection https = (HttpsURLConnection) realUrl.openConnection();
            https.setHostnameVerifier(DO_NOT_VERIFY);
            conn = https;

            // 设置通用的请求属性
            conn.setRequestProperty("Accept", "*/*");
            conn.setRequestProperty("Accept-Encoding", "gzip, deflate, br");
            conn.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.9");
            conn.setRequestProperty("Connection", "keep-alive");
            conn.setRequestProperty("Content-Length", "930");
            conn.setRequestProperty("Content-Type", "text/json");
            conn.setRequestProperty("Cookie", cookie);
            conn.setRequestProperty("Host", "ehallplatform.xust.edu.cn");
            conn.setRequestProperty("Origin", "https://ehallplatform.xust.edu.cn");
            conn.setRequestProperty("Referer", "https://ehallplatform.xust.edu.cn/default/jkdk/mobile/mobJkdkAdd_test.jsp?uid=QTJFQTRGOEZBNkIyRDNGQ0Y3MEQ1Q0YwQkVCODYyMjQ=");
            conn.setRequestProperty("Sec-Fetch-Dest", "empty");
            conn.setRequestProperty("Sec-Fetch-Mode", "cors");
            conn.setRequestProperty("Sec-Fetch-Site", "same-origin");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (iPhone; CPU iPhone OS 13_2_3 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/13.0.3 Mobile/15E148 Safari/604.1");
            conn.setRequestProperty("X-Requested-With", "XMLHttpRequest");


            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流

            out = new OutputStreamWriter(conn.getOutputStream(), "utf-8");
            out.write(a);
//            out.write("{\"xkdjkdk\":{\"procinstid\":\"\",\"empid\":\"165280\",\"shzt\":\"-2\",\"id\":\"\",\"jrrq1\":\"2021-09-04\",\"sjh2\":\"17768653059\",\"jrsfzx3\":\"是\",\"szdd4\":\"中国陕西省西安市临潼区\",\"xxdz41\":\"西安科技大学临潼校区15号宿舍楼233宿舍\",\"jrtwfw5\":\"正常体温:36～37.2℃\",\"jrsfjgwh6\":\"否\",\"jrsfjghb7\":\"否\",\"jrsfcxfrzz8\":\"否\",\"jrsfywhrjc9\":\"否\",\"jrsfyhbrjc10\":\"否\",\"jrsfjcgrrq11\":\"否\",\"jssfyqzysgl12\":\"否\",\"sfcyglq13\":\"否\",\"glkssj131\":\"\",\"gljssj132\":\"\",\"sfyyqxgzz14\":\"否\",\"qtxx15\":null,\"gh\":\"19407020611\",\"xm\":\"徐辰屹\",\"xb\":\"男\",\"sfzh\":\"\",\"szyx\":\"通信与信息工程学院\",\"xydm\":\"4006\",\"zy\":\"\",\"zydm\":\"\",\"bj\":\"通信工程1906班\",\"bjdm\":\"4006078\",\"jg\":\"\",\"yx\":\"\",\"sfxs\":\"是\",\"xslx\":\"1\",\"jingdu\":\"108.96047\",\"weidu\":\"34.23145\",\"guo\":\"中国\",\"sheng\":\"陕西省\",\"shi\":\"西安市\",\"xian\":\"雁塔区\",\"sfncxaswfx16\":\"否\",\"dm\":\"4006078\",\"jdlx\":\"0\",\"tbsj\":\"2021-09-04 18:00:26\",\"fcjtgj17Qt\":\"\",\"fcjtgj17\":\"\",\"hqddlx\":\"1\",\"ymtys\":\"\",\"time\":\"2021-09-04\"}}");
//            //错误方式，这种方式容易出现乱码
            // PrintWriter out = new PrintWriter(connection.getOutputStream());
            /*out.print(a);*/
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {// 使用finally块来关闭输出流、输入流
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }
}