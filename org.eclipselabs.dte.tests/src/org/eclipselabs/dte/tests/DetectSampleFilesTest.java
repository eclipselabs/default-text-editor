package org.eclipselabs.dte.tests;

import static org.junit.Assert.assertEquals;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.ui.IURIEditorInput;
import org.eclipselabs.dte.TextFileDetector;
import org.junit.Test;

public class DetectSampleFilesTest {

	@Test
	public void testDetectTextFileByFileName() {
		_testDetectTextFileByFileName("resources/empty", true);
		_testDetectTextFileByFileName("resources/sample.7z", false);
		_testDetectTextFileByFileName("resources/sample.csv", true);
		_testDetectTextFileByFileName("resources/sample.png", false);
		_testDetectTextFileByFileName("resources/sample.xls", false);
		_testDetectTextFileByFileName("resources/sample.xml", true);
	}

	private void _testDetectTextFileByFileName(String fileName, boolean expected) {
		boolean result = TextFileDetector.isTextFile(fileName);
		assertEquals(fileName, expected, result);
	}

	@Test
	public void testDetectTextFileByInputStream() throws IOException {
		_testDetectTextFileByInputStream("resources/empty", true);
		_testDetectTextFileByInputStream("resources/sample.7z", false);
		_testDetectTextFileByInputStream("resources/sample.csv", true);
		_testDetectTextFileByInputStream("resources/sample.png", false);
		_testDetectTextFileByInputStream("resources/sample.xls", false);
		_testDetectTextFileByInputStream("resources/sample.xml", true);
	}

	private void _testDetectTextFileByInputStream(String fileName,
			boolean expected) throws IOException {
		boolean result = false;
		BufferedInputStream is = null;
		try {
			is = new BufferedInputStream(new FileInputStream(fileName));
			result = TextFileDetector.isTextFile(fileName);
		} finally {
			// Make sure the input streams are closed
			is.close();
		}

		assertEquals(fileName, expected, result);
	}

	@Test
	public void testNullSafety() throws IOException {
		assertEquals(false, TextFileDetector.isTextFile((IURIEditorInput) null));
		assertEquals(false, TextFileDetector.isTextFile((String) null));
		assertEquals(false, TextFileDetector.isTextFile((InputStream) null));
	}

	@Test
	public void testNonExistingFiles() throws IOException {
		assertEquals(false, TextFileDetector.isTextFile("nonexisting"));
	}

}
