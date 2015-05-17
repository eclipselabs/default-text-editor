package org.eclipselabs.dte.tests;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.createNiceMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.assertEquals;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.ui.IURIEditorInput;
import org.eclipselabs.dte.TextFileDetector;
import org.junit.Test;

public class TextFileDetectorTest {

	@Test
	public void testNullSafety() throws IOException {
		System.out.println(IURIEditorInput.class);
		assertEquals(false, TextFileDetector.isTextFile((IURIEditorInput) null));
		assertEquals(false, TextFileDetector.isTextFile((String) null));
		assertEquals(false, TextFileDetector.isTextFile((InputStream) null));
	}

	@Test
	public void testEditorInputNullName() {
		IURIEditorInput mockedInput = createMock(IURIEditorInput.class);
		expect(mockedInput.getName()).andReturn(null);
		replay(mockedInput);
	
		assertEquals(false, TextFileDetector.isTextFile(mockedInput));
	}

	@Test
	public void testEditorInputNullURI() {
		IURIEditorInput mockedInput = createMock(IURIEditorInput.class);
		expect(mockedInput.getName()).andReturn("");
		expect(mockedInput.getURI()).andReturn(null);
		replay(mockedInput);
	
		assertEquals(false, TextFileDetector.isTextFile(mockedInput));
	}

	@Test
	public void testNonExistingFile() throws IOException {
		assertEquals(false, TextFileDetector.isTextFile("nonexisting"));
	}

	@Test
	public void testDetectTextFileByEditorInput() {
		_testDetectTextFileByEditorInput("resources/empty", true);
		_testDetectTextFileByEditorInput("resources/sample.7z", false);
		_testDetectTextFileByEditorInput("resources/sample.csv", true);
		_testDetectTextFileByEditorInput("resources/sample.png", false);
		_testDetectTextFileByEditorInput("resources/sample.xls", false);
		_testDetectTextFileByEditorInput("resources/sample.xml", true);
	}

	private void _testDetectTextFileByEditorInput(String fileName,
			boolean expected) {
		IURIEditorInput mockedInput = createNiceMock(IURIEditorInput.class);
		expect(mockedInput.getName()).andReturn(fileName);
		expect(mockedInput.getURI()).andReturn(new File(fileName).toURI());
		replay(mockedInput);

		assertEquals(expected, TextFileDetector.isTextFile(mockedInput));
	}

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

}
