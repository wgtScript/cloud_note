package note.test;

import org.junit.Test;

import note.util.CodeMd5;

public class TestDigest {

	@Test
	public void testDigest() {
		String pwd = "111111";
		String pw=CodeMd5.crypt(pwd);
		System.out.println(pw);
	}
}
