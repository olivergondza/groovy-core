package groovy;

/** 
 * A test case for switch statement
 * 
 * @author <a href="mailto:james@coredevelopers.net">James Strachan</a>
 * @version $Revision$
 */
class SwitchTest {

    testSwitchWithIntValues() {
        assertSwitch(1, 2, 3, 4);
    }

    testSwitchWithDoubleValues() {
        assertSwitch(1.5, 2.4, 3.2, 4.1);
    }
    
    testSwitchWithStringValues() {
        assertSwitch("abc", "def", "xyz", "unknown");
    }

    testSwitchWithMixedTypeValues() {
        assertSwitch("abc", Date(), 5.32, 23);
    }


    assertSwitch(a, b, c, d) {
        assertSwitchMatch1(a, a, b, c);
        assertSwitchMatch2(b, a, b, c);
        assertSwitchMatch3(c, a, b, c);
        assertSwitchMatchDefault(d, a, b, c);
    }
    
    assertSwitchMatch1(value, case1Value, case2Value, case3Value) {
        switch (value) {
            case case1Value: 
                // worked
                break;
            case case2Value: 
                failNotEquals(value, case2Value);
                break;
            case case3Value: 
                failNotEquals(value, case3Value);
                break;
            default:
                failNotDefault(value);
                break;
        }
    }

    assertSwitchMatch2(value, case1Value, case2Value, case3Value) {
        switch (value) {
            case case1Value: 
                failNotEquals(value, case1Value);
                break;
            case case2Value: 
	            // worked
                break;
            case case3Value: 
                failNotEquals(value, case3Value);
                break;
            default:
                failNotDefault(value);
                break;
        }
    }
    
    assertSwitchMatch3(value, case1Value, case2Value, case3Value) {
        switch (value) {
            case case1Value: 
                failNotEquals(value, case1Value);
                break;
            case case2Value: 
                failNotEquals(value, case2Value);
                break;
            case case3Value: 
	            // worked
                break;
            default:
                failNotDefault(value);
                break;
        }
    }
    
    assertSwitchMatchDefault(value, case1Value, case2Value, case3Value) {
        switch (value) {
            case case1Value: 
                failNotEquals(value, case1Value);
                break;
            case case2Value: 
                failNotEquals(value, case2Value);
                break;
            case case3Value: 
                failNotEquals(value, case3Value);
                break;
            default:
	            // worked
                break;
        }
    }

	failNotEquals(value, expectedCaseValue) {
	    fail("value: " + value + " is not equal to case value: " + expectedCaseValue);
	}
	
	failNotDefault(value) {
	    fail("value: " + value + " should not match the default switch clause" );
	}
}