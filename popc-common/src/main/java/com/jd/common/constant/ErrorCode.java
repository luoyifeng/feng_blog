package com.jd.common.constant;

public class ErrorCode {

	/**
	 * 业务常规错误
	 */
	public static final int ERROR_OLD = 1;
	/**
	 * 处理成功
	 */
	public static final int SUCCESS = 200;
	/**
	 * 业务常规错误
	 */
	public static final int ERROR = 500;

	/**
	 * 系统异常
	 */
	public static final int SYS_UNKNOWN = 9999;
	public static final int SYS_RUNTIME = -9000;
	public static final int SYS_NULL_POINT = -9001;
	public static final int SYS_CLASS_CAST = -9002;
	public static final int SYS_IO = -9003;
	public static final int SYS_NO_METHOD = -9004;
	public static final int SYS_INDEX_OUT_BOUNDS = -9005;

	/**
	 * 第三方组件异常，如数据库、缓存等
	 */
	public static final int SYS_DB_ERR = 9996;
	public static final int THR_JIMDB_ERR = -8000;
	public static final int THR_ES_ERR = -8001;
	public static final int THR_DB_ERR = -8002;

	/**
	 * 请求异常，请求参数为空等
	 */
	public static final int INVALID_PARAM = 9989;
	public static final int REQ_INVALID_PARAM = -7000;
	public static final int REQ_PARAM_TYPE_NOT_MATCH = -7001;

	/**
	 * 用户异常，用户未登陆等
	 */
	public static final int USER_NOT_LOGIN = -6000;
	public static final int USER_MENU_AUTH_FAIL = -6001;
	public static final int USER_DATA_AUTH_FAIL = -6002;
}
