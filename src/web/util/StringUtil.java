package web.util;

import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class StringUtil {

	/**
	 * trim
	 * 
	 * @param string
	 * @return
	 */
	public static String trim(String string) {
		if (string == null)
			return "";
		else
			return string.trim();
	}

	/**
	 * isEmpty
	 * 
	 * @param string
	 * @return boolean
	 */
	public static boolean isEmpty(String string) {
		if (string == null)
			return true;
		if ("".equals(string.trim()) || "null".equals(string.trim()))
			return true;
		else
			return false;
	}

	/**
	 * string2Integer
	 * 
	 * @param string
	 * @return Integer
	 */
	public static Integer string2Integer(String string) {
		String str = trim(string);
		if ("".equals(str))
			str = "0";
		if (str == null)
			str = "0";
		return new Integer(str);
	}

	/**
	 * integer2String
	 * 
	 * @param Integer
	 * @return String
	 */
	public static String integer2String(Integer value) {
		String result = "";
		if (value != null)
			result = String.valueOf(value.intValue());
		return result;
	}

	/**
	 * string2Double
	 * 
	 * @param string
	 * @return double
	 */
	public static double string2Double(String string) {
		String str = trim(string);
		if ("".equals(str))
			str = "0.0";
		return Double.parseDouble(str);
	}

	/**
	 * Encode a string using Base64 encoding. Used when storing passwords as
	 * cookies.
	 * 
	 * This is weak encoding in that anyone can use the decodeString routine to
	 * reverse the encoding.
	 * 
	 * @param str
	 * @return String
	 */
	public static String encodeString(String str) {
		sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();
		return new String(encoder.encodeBuffer(str.getBytes())).trim();
	}

	/**
	 * 设置默认值（为NULL时用空值代替）
	 * 
	 * @param value
	 * @return
	 */
	public static String defaultString(String value) {
		return value == null || value.trim().equals("null") ? "" : value.trim();
	}

	/**
	 * 删除字符串中的子字符串
	 * 
	 * @param str
	 * @param substr
	 * @return
	 */
	public static String delete(String str, String substr) {
		return str.replaceAll(substr, "");
	}

	/**
	 * 删除字符串中的子字符串，并且原来的分隔符不变
	 * 
	 * @param str
	 * @param substr
	 * @param separator
	 * @return
	 */
	public static String delete(String str, String substr, String separator) {
		String[] sList = str.trim().split(separator);
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < sList.length; i++) {
			if (sList[i] != null && sList[i].length() > 0 && !substr.equals(sList[i]))
				sb.append(sList[i].trim()).append(separator);
		}
		if (sb.length() > 0)
			sb.delete(sb.length() - separator.length(), sb.length());
		return sb.toString();
	}

	/*
	 * 从jsp传过来的中文参数需要在servlet中调用此方法将其转换为中文。
	 */
	public static String isoToGB2312(String param) {
		String result = "";
		try {
			if (param != null && !param.equals(""))
				result = new String(param.getBytes("ISO-8859-1"), "GB2312");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 取得字符串靠左的部分
	 * 
	 * @param str
	 * @param size
	 * @return
	 */
	public static String left(String str, int size) {
		if (str == null)
			return null;
		if (str.length() < size)
			size = str.length();
		return str.substring(0, size);
	}

	/**
	 * 取得字符串靠右的部分
	 * 
	 * @param str
	 * @param size
	 * @return
	 */
	public static String right(String str, int size) {
		if (str == null)
			return null;
		if (str.length() < size)
			size = str.length();
		return str.substring(str.length() - size, str.length());
	}

	/**
	 * 将一个string转化为int型，如value为空或者，转换异常，返回指定的默认值
	 * 
	 * <pre>
	 * StringUtils.toInteger(&quot;&quot;, 3);// return 3 value is empty;
	 * StringUtils.toInteger(&quot;aa&quot;, 3);// return 3 value is exception;
	 * </pre>
	 * 
	 * @param value
	 *            要转换的string value
	 * @param defaultValue
	 *            当string为空，或者转换失败时，传回的默认值
	 * @return
	 */
	public static int toInt(String value, int defaultValue) {
		try {
			if (isEmpty(value)) {
				return defaultValue;
			}
			return Integer.parseInt(value);
		} catch (Exception e) {
			return defaultValue;
		}
	}

	public static Integer toInteger(String value, Integer defaultValue) {
		try {
			if (isEmpty(value)) {
				return defaultValue;
			}
			return Integer.valueOf(value);
		} catch (Exception e) {
			return defaultValue;
		}
	}

	public static Long toLong(String value) {
		try {
			if (isEmpty(value)) {
				return new Long(0);
			}
			return Long.valueOf(value);
		} catch (Exception e) {
			return new Long(0);
		}
	}

	public static Double toDouble(String value) {
		try {
			if (isEmpty(value)) {
				return new Double(0);
			}
			return Double.valueOf(value);
		} catch (Exception e) {
			return new Double(0);
		}
	}

	public static String convertString(String param, String from, String to) {
		String result = "";
		try {
			if (param != null && !param.equals(""))
				result = new String(param.getBytes(from), to);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 获取客户端类型
	 * 
	 * @param userAgent
	 * @return
	 */
	public static String getClientExplorerType(HttpServletRequest request) {
		String userAgent = request.getHeader("USER-AGENT").toLowerCase();
		String explorer = "非主流浏览器";
		if (isIE(request)) {
			int index = userAgent.indexOf("msie");
			explorer = userAgent.substring(index, index + 8);
		} else if (isChrome(request)) {
			int index = userAgent.indexOf("chrome");
			explorer = userAgent.substring(index, index + 12);
		} else if (isFirefox(request)) {
			int index = userAgent.indexOf("firefox");
			explorer = userAgent.substring(index, index + 11);
		}
		return explorer.toUpperCase();
	}

	/**
	 * 判断是否是IE浏览器
	 * 
	 * @param userAgent
	 * @return
	 */
	public static boolean isIE(HttpServletRequest request) {
		String userAgent = request.getHeader("USER-AGENT").toLowerCase();
		boolean isIe = true;
		int index = userAgent.indexOf("msie");
		if (index == -1) {
			isIe = false;
		}
		return isIe;
	}

	/**
	 * 判断是否是Chrome浏览器
	 * 
	 * @param userAgent
	 * @return
	 */
	public static boolean isChrome(HttpServletRequest request) {
		String userAgent = request.getHeader("USER-AGENT").toLowerCase();
		boolean isChrome = true;
		int index = userAgent.indexOf("chrome");
		if (index == -1) {
			isChrome = false;
		}
		return isChrome;
	}

	/**
	 * 判断是否是Firefox浏览器
	 * 
	 * @param userAgent
	 * @return
	 */
	public static boolean isFirefox(HttpServletRequest request) {
		String userAgent = request.getHeader("USER-AGENT").toLowerCase();
		boolean isFirefox = true;
		int index = userAgent.indexOf("firefox");
		if (index == -1) {
			isFirefox = false;
		}
		return isFirefox;
	}

	/***
	 * 截字
	 * 
	 * @author Wangxiao
	 * @param content
	 *            需要截取的内容
	 * @param length
	 *            截字数 长度
	 * @param isEllipsis
	 *            是否添加省略号
	 * @return
	 */
	public static String leftString(String content, double length, boolean isEllipsis) {
		content = removeHTML(content, false);
		content = content.replaceAll("&nbsp;", " ");
		content = content.replaceAll("&amp;", "&");
		content = content.replaceAll("&lt;", "<");
		content = content.replaceAll("&gt;", ">");
		content = content.replaceAll("&#146;", "'");
		content = content.replaceAll("&quot;", "\"");
		content = content.replaceAll("&hellip;", "…");
		content = content.replaceAll("&mdash;", "—");
		content = content.replaceAll("&ldquo;", "“").replaceAll("&rdquo;", "”");
		if (content != null && content.length() > length) {
			double len = 0;// 记录中英文一共需要截取的长度
			int unStrSize = 0;// 记录下非中文个数
			int strSize = 0;// 记录下中文个数
			for (int i = 0; i < content.length(); i++) {

				char ch = content.charAt(i);
				short chint = (short) ch;

				if (len < length) {// 小于需要截取长度时才继续
					if (((chint & 0XFF00) >> 8) > 0) {// 中文字符
						len += 1;
						if (len > length) {// 当超出需要截取的长度时 则跳出
							break;
						}
						strSize += 1;
					} else {// 非中文字符
						len += 0.5;
						unStrSize += 1;
					}
				}

				if (len == length) {
					break;
				}
			}
			String result = "";
			result = content.substring(0, unStrSize + strSize);
			if (isEllipsis) {// 添加省略号
				if (result.length() < content.length()) {
					result = addPoint(result);
				}
			}
			result = result.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;");
			return result;
		}
		content = content.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;");
		return content;
	}

	/**
	 * Remove occurences of html, defined as any text between the characters
	 * "&lt;" and "&gt;". Optionally replace HTML tags with a space.
	 * 
	 * @param str
	 * @param addSpace
	 * @return
	 */
	public static String removeHTML(String str, boolean addSpace) {
		if (str == null)
			return "";
		StringBuffer ret = new StringBuffer(str.length());
		int start = 0;
		int beginTag = str.indexOf("<");
		int endTag = 0;
		if (beginTag == -1)
			return str;

		while (beginTag >= start) {
			if (beginTag > 0) {
				ret.append(str.substring(start, beginTag));

				// replace each tag with a space (looks better)
				if (addSpace)
					ret.append(" ");
			}
			endTag = str.indexOf(">", beginTag);

			// if endTag found move "cursor" forward
			if (endTag > -1) {
				start = endTag + 1;
				beginTag = str.indexOf("<", start);
			}
			// if no endTag found, get rest of str and break
			else {
				ret.append(str.substring(beginTag));
				break;
			}
		}
		// append everything after the last endTag
		if (endTag > -1 && endTag + 1 < str.length()) {
			ret.append(str.substring(endTag + 1));
		}

		// edit by lsg
		String result = ret.toString();
		result = result.replaceAll("&nbsp;", " ");
		result = result.replaceAll("\r\n", "");
		// return ret.toString().trim();
		return result.trim();
	}

	private static String addPoint(String content) {
		String endStr = content.substring(content.length() - 2, content.length());
		boolean isAdd = false;
		for (int i = 0; i < endStr.length(); i++) {
			char ch = endStr.charAt(i);
			short chint = (short) ch;
			if (((chint & 0XFF00) >> 8) > 0) {// 中文字符
				isAdd = true;
			}
		}
		if (isAdd) {
			// 最后两个字符中只要出现中文字符 则去掉最后两个字符
			content = content.substring(0, content.length() - 2);
		} else {
			// 最后两个字符中全是英文 则去掉最后三个字符
			content = content.substring(0, content.length() - 3);
		}
		content += "...";
		return content;
	}

	/**
	 * 
	 * @param str1
	 *            x-forwarded-for
	 * @param str2
	 *            Proxy-Client-IP
	 * @param str3
	 *            WL-Proxy-Client-IP
	 * @param str4
	 *            RemoteAddr
	 * @return
	 */
	public static String getIpAddr(String str1, String str2, String str3, String str4) {
		String ip = str1;
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = str2;
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = str3;
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = str4;
		}
		return ip;
	}

	public static String replaceCharacter(String originstr) {
		Pattern p = Pattern.compile("[a-zA-Z]");
		String result = p.matcher(originstr).replaceAll("");
		return result;
	}

	/**
	 * 获取汉字串拼音首字母,英文字母不处理
	 * 
	 * @param chinese
	 * @return
	 */
	public static String cn2FirstSpell(String chinese) {
		if (StringUtil.isEmpty(chinese))
			return "";

		try {
			StringBuffer pybf = new StringBuffer();
			char[] arr = chinese.toCharArray();
			HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
			defaultFormat.setCaseType(HanyuPinyinCaseType.UPPERCASE);
			defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] > 128) {
					try {
						String[] _t = PinyinHelper.toHanyuPinyinStringArray(arr[i], defaultFormat);
						if (_t != null) {
							pybf.append(_t[0].charAt(0));
						}
					} catch (BadHanyuPinyinOutputFormatCombination e) {
						e.printStackTrace();
					}
				} else {
					pybf.append(arr[i]);
				}
			}
			return pybf.toString().replaceAll("\\W", "").trim();
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	/**
	 * 获取汉字串拼音，英文字符不变
	 * 
	 * @param chinese
	 *            汉字串
	 * @return 汉语拼音
	 */
	public static String cn2Spell(String chinese) {
		try {
			StringBuffer pybf = new StringBuffer();
			char[] arr = chinese.toCharArray();
			HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
			defaultFormat.setCaseType(HanyuPinyinCaseType.UPPERCASE);
			defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] > 128) {
					try {
						pybf.append(PinyinHelper.toHanyuPinyinStringArray(arr[i], defaultFormat)[0]);
					} catch (BadHanyuPinyinOutputFormatCombination e) {
						e.printStackTrace();
					}
				} else {
					pybf.append(arr[i]);
				}
			}
			return pybf.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	/*
	 * 手机号验证
	 * 
	 * @param str
	 * 
	 * @return 验证通过返回true
	 */
	public static boolean isMobile(String str) {
		// "^(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$"
		// Pattern p = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$"); // 验证手机号
		// Matcher m = p.matcher(str);
		if (isEmpty(str)) {
			return false;
		}
		return str.matches("^[1][3,4,5,7,8][0-9]{9}$");
	}

	/**
	 * 取出一个指定长度大小的随机正整数.
	 * 
	 * @param length
	 *            int 设定所取出随机数的长度。length小于11
	 * @return int 返回生成的随机数。
	 */
	public static int buildRandom(int length) {
		int num = 1;
		double random = Math.random();
		if (random < 0.1) {
			random = random + 0.1;
		}
		for (int i = 0; i < length; i++) {
			num = num * 10;
		}
		return (int) ((random * num));
	}
	
	/**
	 * 格式化金额
	 * */
	public static String formatAmount(Double amount){
		StringBuffer buff = new StringBuffer();
	    buff.append("###,###.##");
	    NumberFormat formater = new DecimalFormat(buff.toString());
	    return formater.format(amount);
	}
	
	
	public static void main(String[] args) {
		String logoSize = "340*120";
		Integer logoLong = null;
		Integer logoWidth = null;
		if(!StringUtil.isEmpty(logoSize)){
			logoLong = Integer.valueOf(logoSize.split("\\*")[0]);
			logoWidth = Integer.valueOf(logoSize.split("\\*")[1]);
		}
		System.out.println(logoLong);
		System.out.println(logoWidth);
	}
}
