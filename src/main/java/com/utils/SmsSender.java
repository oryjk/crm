package com.utils;

/**
 * Created by 朋肖 on 2016-05-11.
 */
public class SmsSender {

        public static void main(String[] args)throws Exception
        {
            /*HttpClient client = new HttpClient();
            PostMethod post = new PostMethod("http://gbk.sms.webchinese.cn");
            post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=gbk");//在头文件中设置转码
            NameValuePair[] data ={ new NameValuePair("Uid", "本站用户名"),new NameValuePair("Key", "接口安全秘钥"),new NameValuePair("smsMob","手机号码"),new NameValuePair("smsText","验证码：8888")};
            post.setRequestBody(data);

            client.executeMethod(post);
            Header[] headers = post.getResponseHeaders();
            int statusCode = post.getStatusCode();
            System.out.println("statusCode:"+statusCode);
            for(Header h : headers)
            {
                System.out.println(h.toString());
            }
            String result = new String(post.getResponseBodyAsString().getBytes("gbk"));
            System.out.println(result); //打印返回消息状态


            post.releaseConnection();*/

        }


}
