/*package org.jeecgframework.web.utils;

import java.util.ArrayList;
import java.util.List;

import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.AppMessage;
import com.gexin.rp.sdk.base.impl.SingleMessage;
import com.gexin.rp.sdk.base.impl.Target;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.NotificationTemplate;

public class NotificationTemplateDemo {

	 private static String appId = "zYNQb17OgZ7r6lsFqMtR08";
	    private static String appKey = "79SF5fIamg9CUwwvFJRyb2";
	    private static String masterSecret = "eH4qCabSE08PaEAw2bMumA";   
	public static final String CID = "e605a0db5ce3cca9b76b012978064940";
	
	public static NotificationTemplate notificationTemplateDemo(String appId, String appkey) {
	    NotificationTemplate template = new NotificationTemplate();
	    // 设置APPID与APPKEY
	    template.setAppId(appId);
	    template.setAppkey(appkey);
	    // 设置通知栏标题与内容
	    template.setTitle("请输入通知栏标题");
	    template.setText("请输入通知栏内容");
	    // 配置通知栏图标
	    template.setLogo("icon.png");
	    // 配置通知栏网络图标
	    template.setLogoUrl("");
	    // 设置通知是否响铃，震动，或者可清除
	    template.setIsRing(true);
	    template.setIsVibrate(true);
	    template.setIsClearable(true);
	    // 透传消息设置，1为强制启动应用，客户端接收到消息后就会立即启动应用；2为等待应用启动
	    template.setTransmissionType(1);
	    template.setTransmissionContent("请输入您要透传的内容");
	    // 设置定时展示时间
	    // template.setDuration("2015-01-16 11:40:00", "2015-01-16 12:24:00");
	    return template;
	}
	
	public static void main(String[] args) {
		NotificationTemplate template = notificationTemplateDemo(appId, appKey);
		
		// 代表在个推注册的一个 app，调用该类实例的方法来执行对个推的请求
				IGtPush push = new IGtPush(appKey, masterSecret);
				// 创建信息模板
			
				List<String> appIds = new ArrayList<String>();
		        appIds.add(appId);

		        // 定义"AppMessage"类型消息对象，设置消息内容模板、发送的目标App列表、是否支持离线发送、以及离线消息有效期(单位毫秒)
		        AppMessage message = new AppMessage();
		        message.setData(template);
		        message.setAppIdList(appIds);
		        message.setOffline(true);
		        message.setOfflineExpireTime(1000 * 30);

		        IPushResult ret = push.pushMessageToApp(message);
		        System.out.println(ret.getResponse().toString());
	
	}
}
*/