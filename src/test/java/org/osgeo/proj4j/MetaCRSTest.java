package org.osgeo.proj4j;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.junit.Test;
import org.osgeo.proj4j.io.MetaCRSTestCase;
import org.osgeo.proj4j.io.MetaCRSTestFileReader;

/**
 * Runs MetaCRS test files.
 * 
 * @author mbdavis
 * 
 */
public class MetaCRSTest {

	private static CRSFactory csFactory = new CRSFactory();

	@Test
	public void xtestMetaCRSExample() throws IOException {
        //todo: tidy rel paths
		File file = getFile("../../../TestData.csv");
		MetaCRSTestFileReader reader = new MetaCRSTestFileReader(file);
		List<MetaCRSTestCase> tests = reader.readTests();
		for (MetaCRSTestCase test : tests) {
			runTest(test);
		}
	}

	@Test
	public void testPROJ4_SPCS() throws IOException {
		File file = getFile("../../../PROJ4_SPCS_EPSG_nad83.csv");
		MetaCRSTestFileReader reader = new MetaCRSTestFileReader(file);
		List<MetaCRSTestCase> tests = reader.readTests();
		for (MetaCRSTestCase test : tests) {
			runTest(test);
		}
	}

	File getFile(String name) {
		try {
			return new File(this.getClass().getResource(name).toURI());
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	void runTest(MetaCRSTestCase crsTest) {
		try {
			crsTest.execute(csFactory);
			crsTest.print(System.out);
		} catch (Proj4jException ex) {
			System.out.println(ex);
		}
	}

}
