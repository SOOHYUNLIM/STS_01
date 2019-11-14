package org.zerock.util;

import java.io.File;
import java.nio.file.Files;

public final class CheckFileType {

	public static boolean checkImgeType(File file) {
		boolean result = false;
		try {
			String mimeType = Files.probeContentType(file.toPath());
			result = mimeType.startsWith("image");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
