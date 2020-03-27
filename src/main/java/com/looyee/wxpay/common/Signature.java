package com.looyee.wxpay.common;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

@Slf4j
public class Signature {

	/**
	 * 签名算法
	 *
	 * @param o 要参与签名的数据对象
	 * @return 签名
	 * @throws IllegalAccessException
	 */
	public static String getSign(Map<String, Object> map) {
		String signType = "sign_type";
		String signTypeStr = MapUtils.getString(map, signType);
		if (StringUtils.isBlank(signTypeStr)) {
			signTypeStr = "MD5";
		}

		String key = "key";
		String keyStr = MapUtils.getString(map, key);
		map.remove(key);
		ArrayList<String> list = new ArrayList<>();
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			if (!entry.getValue().equals("")) {
				list.add(entry.getKey() + "=" + entry.getValue() + "&");
			}
		}
		int size = list.size();
		String[] arrayToSort = list.toArray(new String[size]);
		Arrays.sort(arrayToSort, String.CASE_INSENSITIVE_ORDER);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size; i++) {
			sb.append(arrayToSort[i]);
		}
		String result = sb.toString();
		result += "key=" + keyStr;
		if ("MD5".equals(signTypeStr)) {
			log.info("Sign Before MD5:" + result);
			result = MD5.MD5Encode(result).toUpperCase();
		} else {
			log.info("Sign Before HMACSHA:" + result);
			result = HMACSHA256.createSign(result, keyStr).toUpperCase();
		}
		log.info("Sign Result:" + result);
		return result;
	}

	public static String getHMACSHASign(Map<String, Object> map) {
		String key = "key";
		String keyStr = MapUtils.getString(map, key);
		map.remove(key);
		ArrayList<String> list = new ArrayList<>();
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			if (!entry.getValue().equals("")) {
				list.add(entry.getKey() + "=" + entry.getValue() + "&");
			}
		}
		int size = list.size();
		String[] arrayToSort = list.toArray(new String[size]);
		Arrays.sort(arrayToSort, String.CASE_INSENSITIVE_ORDER);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size; i++) {
			sb.append(arrayToSort[i]);
		}
		String result = sb.toString();
		result += "key=" + keyStr;
		log.info("Sign Before HMACSHA:" + result);
		result = HMACSHA256.createSign(result, keyStr).toUpperCase();
		log.info("Sign Result:" + result);
		return result;
	}

	/**
	 * 检验API返回的数据里面的签名是否合法，避免数据在传输的过程中被第三方篡改
	 *
	 * @param responseString API返回的XML数据字符串
	 * @return API签名是否合法
	 * @throws ParserConfigurationException
	 * @throws IOException
	 * @throws SAXException
	 */
	public static boolean checkIsSignValidFromResponseString(String responseString, String key)
			throws ParserConfigurationException, IOException, SAXException {

		Map<String, Object> map = XMLParser.getMapFromXML(responseString);
		log.info(map.toString());

		String signFromAPIResponse = map.get("sign").toString();
		if (StringUtils.isBlank(signFromAPIResponse)) {
			log.info("API返回的数据签名数据不存在，有可能被第三方篡改!!!");
			return false;
		}
		log.info("服务器回包里面的签名是:" + signFromAPIResponse);
		// 清掉返回数据对象里面的Sign数据（不能把这个数据也加进去进行签名），然后用签名算法进行签名
		map.put("sign", "");
		map.put("key", key);

		// 将API返回的数据根据用签名算法进行计算新的签名，用来跟API返回的签名进行比较
		String signForAPIResponse = "";
		if (signFromAPIResponse.length() == 64) {
			signForAPIResponse = Signature.getHMACSHASign(map);
		} else if (signFromAPIResponse.length() == 32) {
			signForAPIResponse = Signature.getSign(map);
		}
		if (!signForAPIResponse.equals(signFromAPIResponse)) {
			// 签名验不过，表示这个API返回的数据有可能已经被篡改了
			log.info("API返回的数据签名验证不通过，有可能被第三方篡改!!!");
			return false;
		}
		log.info("恭喜，API返回的数据签名验证通过!!!");
		return true;
	}

	public static void main(String[] args) {
		String asda = "1AF996DFD5F30FBB032F5E317D08934DB1F373270FFC7A8747C366507BDC083A";
		System.out.println(asda.length());
	}
}
