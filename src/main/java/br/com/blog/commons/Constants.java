package br.com.blog.commons;

public final class Constants {
	
	public static final String PACKAGE = "br.com.blog";
	public static final String V1 = "v1/";
	public static final String ROOT_URL = "/api/";
	
	public static final String USUARIOS = ROOT_URL + V1 + "usuarios";
	
	public static final String DATE_FORMAT_FULL = "dd/MM/yyyy HH:mm:ss";
	public static final String DATE_FORMAT_DATE = "dd/MM/yyyy";
	public static final String DATE_FORMAT_SHORT = "dd/MM/yy";
	public static final String DATE_FORMAT_HOUR = "hh:mm";
	public static final String DATE_FORMAT_SQL = "yyyy-MM-dd";
	public static final String DATE_FORMAT_SQL_TIMESTAMP = "yyyy-MM-dd HH:mm:ss";

	public static final String APPLICATION_JSON_UTF_8 = "application/json;charset=utf-8";
	public static final String APPLICATION_XML_UTF_8 = "application/xml;charset=utf-8";

	public static final String UTF_8 = "UTF-8";
	public static final String ISO_8859_1 = "ISO-8859-1";
	public static final String BLANK = "";
	public static final String SPACE = " ";
	public static final String SEMICOLON = ";";
	public static final String COLON = ":";
	public static final String DOT = ".";
	public static final String COMMA = ",";
	public static final String HIFEN = "-";
	public static final String SLASH = "/";
	public static final String BACKSLASH = "\\";
	
	public static final String DEFAULT_PAGE = "0";
	public static final String DEFAULT_SIZE = "5";

	private Constants() {
		// Construtor padrão.
	}
	
}

