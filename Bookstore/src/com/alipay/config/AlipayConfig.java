package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016101000655794";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCl2KRHqS4vo2dSHt/ZR/zwWq/V92DFZvQXHJygRlxGMXaBRcGO/CWrpmIVQXM7mUvj1QYpK0UXF3nFYCG+hGutLOoee7ijPjP5PKlHLw34QkeaB3Lwdy1dFSbJFkPfePT1MU5nuTn4hOvW0atI5iGRzxjJh4Q24kOyK6GpfLC3CiIX36yoAmbYLTfxvPPXkh6McaRpkvVz6tyZTpCCVh8CMFIR3tRjme36F9Tq+sN6s4a+y/bdDPBDtHIQJvdDZviiUTePFZJoSC+COUeDkyq2nLpkm/BkKPDWikbM2hxM5uJkBpuk+NziugHFlS7U31/1j8MUwnCBJcELH2myf4EXAgMBAAECggEASgy3HUAO3TpqkaIzdMLNz0vOowy3aqyTZBZkYLPJ05WWQhYxXHR9JW0+8hqtJvlFh07AV3V4fdz/g/9uUbCymzootr+rK0hE0I4jTyNVa3m8mqukyHWODbe5/6MvXwKU7T28sldj6PEAlIQ9pGkMqBv+B0243QCeFVmh7xk7lh35bDw6WW8vub4SvrQ1pNxfdrdpm9RBpBpOzQpJi4Julyx5AG8wiVqeXPeXLjQ/Ig+mBIDQUhpqhb6aOMiZEM/8Ron/214UV9t0AH9kJNOX0XT3/OZKaAoQJ6bzd+I8DITg0ZGapmLDaUVukOWRqSlufdcJ89cQgrNVxWLzf3b1oQKBgQDhLvGS/336rXoIL/9FywAkdZ0HEVh1TMe6LXpG3VZ4Yw4vNwdTpYmWF4X+mS9LTeMxlc4vqDdLLyznFT34LCRveSTF9+f2/zEsgCFevlLMJovj/7/WFtH2mdHMOsfsEKCklXsOxAGaHAYaXo0STPPIwNte8IzW7y0r2NQRq1J6qQKBgQC8iuLhJUaPZdeGFKa89vqJZfrO1UORmCbEFSOdSEyaKskt7C4EfaWdDf90h7Dcte6Ds3k6/n/nUqJiPBjerIS3wEI05g48wHRlHWToioiTAoZezW/+iAVaEj7YwAncQqKdSNibCLT3VBJoOw9wFzZA+BTRyb2RFg7VwSJgG6k1vwKBgF0RF8qXSavnMr5bh/eCdOacrW+UXajtOMbbsOPE6s4KsnwVFDQgAINF6Z1WFlPbNwDxVywfK+so7jf7cYc2R0DDIs2nLfnJcrtfoWsU4gd6DusGcnS7Lb/rxufPi30nSh17okZx/+9/kY4occmUgFUCUCgm5y6V32d10AAVfJsxAoGBALRlKpkC4lU3uxP11Gc+5A3sfiHB2WmHq6e3FiFZ2Lk1MNH4hTsUwQ3ZI89qOOWkSPbIFLlGYjiBTw8wsxby9/UcRfx5Faw48+T/T9pTGkOWidxRMdPWb1Bz3p/idkzBkPduiJklpohybz49LBMykl1tP/ZN0UvtT/pjVTGhpa/fAoGBAOALrMUtYqDS8R6M0HC2tdjnBKn4G9CAzcgCZw8XTTusCIPQhR6KUmDK9r0DG6S44d/hYdqmt6y6PIaGJrv16f89PzVG8yqqGLbc8gBnVQsiznLt0+Jlhy7Pw5AjpbJnFaZ5UN1vRcQlKFm/S4FJuRYVs4rxRkg+sNjKwfVmYfYh";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAyv656+iy02qNo2CvNOU3+6lxXmrpBQgM5rX1u2e54EYmwYDyAqK1070S1DniPlGu89zi8L0dZSOj6i4Ygcck6r0QSw2qg7+q26QBgXZeo2iEcudt2TvLfd+e97jHSgZTY8YqP5ByWcdOvm64m7H3NyNXJFKyPsbpWnDjvlIY274ft7X9VZdWYaJcLc7zgiTIRsQyOhQ4hAgUyju4q2cEdtcxhx6y9n3iY/iYRGAK/xOq0P8bSPwp/ACQvggqQAVk8UtmUzUGbWW4D1c+wB2G3VRxSfArww3lbQkONurYvcUQ1dJOgaC9gkdoduDeNisRwfACkkBUwG6Iq3Q72E8omwIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://www.hongmaobook.com/Bookstore/pay/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

