package com.monitor.util;

import java.io.FileNotFoundException;

import org.junit.Test;
import org.springframework.util.ResourceUtils;

public class UtilTest {
	@Test
	public void parseStatus() {
		try {
			String json=FileHandler.file2Str(
					ResourceUtils.getFile("classpath:status.json"));
			CoreResponseParser.parseStatus(json);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
