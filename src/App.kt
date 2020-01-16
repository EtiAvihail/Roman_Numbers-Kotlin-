object App{

    private val legalChars = mapOf('I' to 1, 'V' to 5, 'X' to 10, 'L' to 50, 'C' to 100)

    fun isRomanNumber(str: String): Boolean {

        for (i in 1 until str.length) {

            if (!legalChars.contains(str[i])) return false

            when (str[i]) {

                'I' -> if (charRepeats(str, i)) return false
                'X' -> if (!checkX(str, i)) return false
                'C' -> if (!checkC(str, i)) return false
                'V' -> if (!checkV(str,i)) return false
                'L' -> if (!checkL(str,i)) return false

            }
        }

        return true
    }

    private fun checkX(str: String, index: Int): Boolean {

        if(charRepeats(str, index)) return false
        if(str[index - 1] == 'V') return false
        if((index > 1 && str[index - 1] == 'I' && str[index - 2] == 'I')) return false

        return true
    }

    private fun checkL(str: String, index: Int): Boolean {

        if(str[index - 1] == 'L') return false
        return checkDescending(str,index)

    }

    private fun checkC(str: String, index: Int): Boolean {

        if(charRepeats(str, index)) return false
        return checkDescending(str, index)
    }

    private fun checkV(str: String, index: Int) : Boolean {

        if(str[index - 1] == 'V') return false;
        if(str[index - 1] == 'I' && index > 1 && str[index - 2] == 'I') return false

        return true
    }


    private fun checkDescending(str: String, index: Int): Boolean {

        if (str[index - 1] != 'I' && str[index - 1] != 'X') return false
        else if (str[index - 1] ==  'I') {
            if (index > 1 && str[index - 2] == 'I') return false
        }else { //str[index] == 'X'
            if (index > 1 && (str[index - 2] == 'I' || str[index - 2] == 'X')) return false
        }

        return true
    }

    private fun charRepeats(str: String, index: Int): Boolean {

        var c: Char = str[index]

        return (index > 2 && str[index - 1] == c && str[index - 2] == c && str[index - 3] == c)

    }
}