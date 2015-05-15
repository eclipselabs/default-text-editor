package org.eclipselabs.dte.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.eclipselabs.dte.KnownBinaryFileExtensions;
import org.eclipselabs.dte.KnownTextBasedFileExtensions;
import org.junit.Test;

public class KnownFileTypesExtensionsTest {

	@Test
	public void testNoDuplications() {
		Set<String> intersection = new HashSet<String>(
				KnownTextBasedFileExtensions.set());
		intersection.retainAll(KnownBinaryFileExtensions.set());

		String message = "Duplicated file extensions: "
				+ Arrays.toString(intersection.toArray());

		assertTrue(message, intersection.isEmpty());
	}

	@Test
	public void testRemoveLeadingUnderscoreFromName() {
		assertEquals("7Z", KnownBinaryFileExtensions._7Z.toString());
	}

}
