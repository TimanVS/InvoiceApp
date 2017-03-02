package ua.timan.invoice.utils;

import static lombok.AccessLevel.PRIVATE;

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

}
