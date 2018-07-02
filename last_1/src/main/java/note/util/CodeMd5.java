package note.util;

import org.apache.commons.codec.digest.DigestUtils;

public class CodeMd5 {

private final static String salt="加盐了哈";

public static String crypt(String pwd){
	return DigestUtils.md5Hex(pwd+salt);
}
}
