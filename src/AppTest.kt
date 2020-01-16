import App.isRomanNumber
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class AppTest{

    @Test
    fun testingIllegalCharsShouldBeFalse() {

        assertEquals(false, isRomanNumber("VLאזא"))
        assertEquals(false, isRomanNumber("XXAX"))

    }

    @Test
    fun testingFirstRoleShouldBeTrue() {

        assertEquals(true, isRomanNumber("XXII"))
    }

    @Test
    fun testingFirstRoleShouldBeFalse() {

        assertEquals(false, isRomanNumber("IIXX"))
    }

    @Test
    fun testingSecondRoleShouldBeTrue() {

        assertEquals(true, isRomanNumber("III"))
        //test when in the middle\end of the string
        assertEquals(true, isRomanNumber("XIII"))
        assertEquals(true, isRomanNumber("LXXXI"))

    }
    @Test
    fun testingSecondRoleShouldBeFalse() {

        assertEquals(false, isRomanNumber("IIII"))
        //test when in the middle\end of the string
        assertEquals(false, isRomanNumber("XIIII"))
        assertEquals(false, isRomanNumber("LXXXXI"))
    }

    @Test
    fun testingThirdRoleShouldBeTrue() {

        assertEquals(true, isRomanNumber("L"))
        //this also tests fourth role
        assertEquals(true, isRomanNumber("IV"))
        assertEquals(true, isRomanNumber("VI"))
    }
    @Test
    fun testingThirdRoleShouldBeFalse() {

        assertEquals(false, isRomanNumber("LL"))
        assertEquals(false, isRomanNumber("IVV"))
        assertEquals(false, isRomanNumber("IVVI"))
        assertEquals(false, isRomanNumber("LLI"))
    }

    @Test
    fun testingFourthRoleShouldBeTrue() {

        assertEquals(true, isRomanNumber("IV"))
        assertEquals(true, isRomanNumber("XIV"))
        assertEquals(true, isRomanNumber("XCIX"))
        assertEquals(true, isRomanNumber("VXL"))
    }
    @Test
    fun testingFourthRoleShouldBeFalse() {

        assertEquals(false, isRomanNumber("IIV"))
        assertEquals(false, isRomanNumber("XIIV"))
        assertEquals(false, isRomanNumber("XXC"))
        assertEquals(false, isRomanNumber("XIXXL"))
    }

}