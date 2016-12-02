package com.dacheng.utils.mail;

public class TestMailSender {
	public static void main(String[] args) {
		// 这个类主要是设置邮件
		MailSenderInfo mailInfo = new MailSenderInfo();
		mailInfo.setMailServerHost("smtp.qq.com");
		mailInfo.setMailServerPort("25");
		mailInfo.setValidate(true);
		mailInfo.setUserName("lijunlin@dachengsoftware.com");
		mailInfo.setPassword("huangdan.2597");// 您的邮箱密码
		mailInfo.setFromAddress("lijunlin@dachengsoftware.com");
		mailInfo.setToAddress("lijunlin9520@163.com");
		mailInfo.setSubject("OBD汽车设备APP");
		mailInfo.setContent("你的验证码为：123456");
		// 这个类主要来发送邮件
		SimpleMailSender sms = new SimpleMailSender();
		sms.sendTextMail(mailInfo);// 发送文体格式
		sms.sendHtmlMail(mailInfo);// 发送html格式
	}
}