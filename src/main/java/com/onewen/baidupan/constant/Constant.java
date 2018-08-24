package com.onewen.baidupan.constant;

/**
 * 静态常量
 * 
 * @author 梁光运
 * @date 2018年8月20日
 */
public final class Constant {
	public final static String BAIDU_PAN_URL = "https://pan.baidu.com/";
	public final static String BAIDU_PASSPORT_URL = "https://passport.baidu.com/v2/api/";
	public final static String BAIDU_GETAPI_URL = "https://passport.baidu.com/v2/api/?getapi&tpl=netdisk&subpro=netdisk_web&apiver=v3&tt=%s&class=login&gid=%s&loginversion=v4&logintype=basicLogin&traceid=&callback=%s";
	public final static String BAIDU_PUBLIC_KEY_URL = "https://passport.baidu.com/v2/getpublickey?token=%s&tpl=netdisk&subpro=netdisk_web&apiver=v3&tt=%s&gid=%s&loginversion=v4&traceid=&callback=%s";
	public final static String BAIDU_PAN_HOME_URL = "https://pan.baidu.com/disk/home";
	public final static String BAIDU_PAN_LOGIN_URL = "https://passport.baidu.com/v2/api/?login";
	public final static String BAIDU_VERIFY_CODE_URL = "https://passport.baidu.com/v2/?checkvcode&token=%s&tpl=netdisk&subpro=netdisk_web&apiver=v3&tt=%s&verifycode=%s&loginversion=v4&codestring=%s&traceid=3FA03001&callback=%s";
	public final static String BAIDU_VERIFY_CODE_IMG_URL = "https://passport.baidu.com/cgi-bin/genimage?%s";
	public final static String BAIDU_PAN_PASS_V3 = "https://pan.baidu.com/res/static/thirdparty/pass_v3_jump.html";
	public final static String BAIDU_USER_INFO_URL = "http://tieba.baidu.com/f/user/json_userinfo";
	
	public final static String PAN_API_LIST_FILE = "https://pan.baidu.com/api/list?dir=%s";

	/**
	 * 获取GID
	 * 
	 * @return
	 */
	public static String getGid() {
		String str = "xxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx";
		while (str.indexOf("x") >= 0) {
			int r = (int) (Math.random() * 16);
			r = str.indexOf("x") < str.indexOf("y") ? r : 3 & r | 8;
			str = str.replaceFirst("[xy]", Integer.toHexString(r));
		}
		return str.toUpperCase();
	}

	/**
	 * 获取回调码
	 * 
	 * @return
	 */
	public static String getCallBackCode() {
		return "bd__cbs__" + Integer.toUnsignedString((int) Math.floor(2147483648L * Math.random()), 36);
	}

	/**
	 * 获取api地址
	 * 
	 * @return
	 */
	public static String getApiUrl(String gid) {
		return String.format(BAIDU_GETAPI_URL, System.currentTimeMillis(), gid, getCallBackCode());
	}

	/**
	 * 获取publicKey地址
	 * 
	 * @return
	 */
	public static String getPublicKeyUrl(String token, String gid) {
		return String.format(BAIDU_PUBLIC_KEY_URL, token, System.currentTimeMillis(), gid, getCallBackCode());
	}

	/**
	 * 获取验证码地址
	 * 
	 * @param token
	 * @param code
	 * @param codeString
	 * @return
	 */
	public static String getVerifyCodeUrl(String token, String code, String codeString) {
		return String.format(BAIDU_VERIFY_CODE_URL, token, System.currentTimeMillis(), code, codeString,
				getCallBackCode());
	}

	/**
	 * 获取验证码图片地址
	 * 
	 * @param codeString
	 * @return
	 */
	public static String getVerifyCodeImgUrl(String codeString) {
		return String.format(BAIDU_VERIFY_CODE_IMG_URL, codeString);
	}
	
	/**
	 * 获取文件列表地址
	 * @param dir 目录
	 * @return
	 */
	public static String getListFileUrl(String dir) {
		return String.format(PAN_API_LIST_FILE, dir);
	}

}
