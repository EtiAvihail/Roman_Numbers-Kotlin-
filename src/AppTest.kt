import App.isRomanNumber
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class AppTest{

    @Test
    fun testing1to100() {


        var numbers = listOf("I","XXVI","LI","LXXVI","II","XXVII","LII","LXXVII","III","XXVIII","LIII","LXXVIII","IV","XXIX","LIV", "LXXIX",
            "V","XXX","LV","LXXX","VI","XXXI","LVI","LXXXI","VII","XXXII","LVII","LXXXII","VIII","XXXIII","LVIII","LXXXIII",
            "IX","XXXIV","LIX","LXXXIV","X","XXXV","LX","LXXXV","XI","XXXVI", "LXI", "LXXXVI", "XII", "XXXVII", "LXII", "LXXXVII",
            "XIII","XXXVIII","LXIII","LXXXVIII","XIV","XXXIX",	"LXIV",	"LXXXIX","XV","XL","LXV","XC", "XVI","XLI","LXVI","XCI","XVII","XLII","LXVII","XCII",
            "XVIII","XLIII","LXVIII","XCIII",	"XIX","XLIV","LXIX","XCIV","XX","XLV", "LXX","XCV","XXI","XLVI","LXXI","XCVI", "XXII","XLVII","LXXII","XCVII",
            "XXIII","XLVIII","LXXIII","XCVIII","XXIV","XLIX","LXXIV","XCIX","XXV","L", "LXXV", "C")

        for(i in 0 until numbers.size){
            assertEquals(true, isRomanNumber(numbers[i]))
        }
    }

    @Test
    fun testingIllegalCharsShouldBeFalse() {

        assertEquals(false, isRomanNumber("VLaX"))
        assertEquals(false, isRomanNumber("XXAX"))

    }

    @Test
    fun testingFirstRoleShouldBeFalse() {

        assertEquals(false, isRomanNumber("IIXX"))
    }
    @Test
    fun testingSecondRoleShouldBeFalse() {

        assertEquals(false, isRomanNumber("IIII"))
        //test when in the middle\end of the string
        assertEquals(false, isRomanNumber("XIIII"))
        assertEquals(false, isRomanNumber("LXXXXI"))
    }

    @Test
    fun testingThirdRoleShouldBeFalse() {

        assertEquals(false, isRomanNumber("LL"))
        assertEquals(false, isRomanNumber("IVV"))
        assertEquals(false, isRomanNumber("IVVI"))
        assertEquals(false, isRomanNumber("LLI"))
    }

    @Test
    fun testingFourthRoleShouldBeFalse() {

        assertEquals(false, isRomanNumber("IIV"))
        assertEquals(false, isRomanNumber("XIIV"))
        assertEquals(false, isRomanNumber("XXC"))
        assertEquals(false, isRomanNumber("XIXXL"))
        assertEquals(false, isRomanNumber("VXL"))

    }

}