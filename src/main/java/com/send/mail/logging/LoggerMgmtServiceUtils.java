package com.send.mail.logging;

import org.apache.commons.lang3.exception.ExceptionUtils;

public class LoggerMgmtServiceUtils {

	private LoggerMgmtServiceUtils() {
	}

	public static String getStackTraceException(Exception e) {
		return ExceptionUtils.getStackTrace(e);
	}

}
