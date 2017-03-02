package ua.timan.invoice.utils;

import static lombok.AccessLevel.PRIVATE;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import lombok.NoArgsConstructor;

@NoArgsConstructor(access = PRIVATE)
public final class InvoiceUtils {

	public static <T> List<T> toList(Iterable<T> iterable) {
		if (iterable == null) {
			return null;
		} else if (iterable instanceof List) {
			return (List<T>) iterable;
		} else {
			return toArrayList(iterable);
		}
	}

	private static <T> List<T> toArrayList(Iterable<T> iterable) {
		List<T> list = new ArrayList<>();
		for (T item : iterable) {
			list.add(item);
		}
		return list;
	}

	public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

	public static InputStream getResourceAsStream(String fileName) throws IOException {
		return InvoiceUtils.class.getClassLoader().getResourceAsStream(fileName);
	}

	public static byte[] getResourceAsBytes(String fileName) throws IOException {
		try (InputStream in = getResourceAsStream(fileName); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
			byte[] buffer = new byte[1024];
			int length;
			while ((length = in.read(buffer)) != -1) {
				out.write(buffer, 0, length);
			}
			return out.toByteArray();
		}
	}

	public static String getResourceAsString(String fileName, Charset charset) throws IOException {
		return new String(getResourceAsBytes(fileName), charset);
	}

	public static String getResourceAsString(String fileName) throws IOException {
		return getResourceAsString(fileName, DEFAULT_CHARSET);
	}

}
