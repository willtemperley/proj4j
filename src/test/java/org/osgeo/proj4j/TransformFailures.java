package org.osgeo.proj4j;

import org.junit.Test;

/**
 * A class to run tests which are known to be failures.
 * This prevents Maven from running them automatically and reporting failures.
 *
 * @author mdavis
 */
public class TransformFailures extends BaseCoordinateTransformTest {

    @Test
    public void testEPSG_27700() {
        checkTransform("EPSG:4326", -2.89, 55.4, "EPSG:27700", 343733.1404, 612144.530677, 0.1);
        checkTransformAndInverse(
                "EPSG:4326", -2.0301713578021983, 53.35168607080468,
                "EPSG:27700", 398089, 383867,
                0.001, 0.2 * APPROX_METRE_IN_DEGREES);
    }

}
