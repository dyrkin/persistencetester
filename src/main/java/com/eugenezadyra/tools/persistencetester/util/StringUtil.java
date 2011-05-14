package com.eugenezadyra.tools.persistencetester.util;

import org.apache.commons.lang.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author eugene zadyra
 */
public class StringUtil {

	public static String substringBetween(String string, String open, String close) {
		return StringUtils.substringBetween(string, open, close);
	}

	public static String substringByRegexp(String string, String regexp) {
		Pattern p = Pattern.compile(regexp);
		Matcher m = p.matcher(string);
		if (m.find()) {
			return m.group(1);
		}
		return null;
	}

	public static String substringBefore(String string, String open) {
		return StringUtils.substringBefore(string, open);
	}

	public static String substringAfterLast(String string, String last) {
		return StringUtils.substringAfterLast(string, last);
	}
}
