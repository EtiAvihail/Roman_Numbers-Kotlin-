fun isRomanNumber(str: String): Boolean {

    val legalChars : HashMap<Char,Int>  = createMap()


    for (i in 0 until (str.length - 1)) {

        if (!legalChars.contains(str[i])) return false

        when (str[i]) {

            'I' -> if (charRepeats(str, 'I', i)) return false
            'X' -> if (charRepeats(str, 'X', i)) return false
            'C' -> if (charRepeats(str, 'C', i)) return false
            'V' -> if (i < str.length - 1 && str[i] == 'V') return false
            'L' -> if (i < str.length - 1 && str[i] == 'L') return false
        }
        //TODO handle condition 4

    }

    return true
}

fun createMap() : HashMap<Char, Int>{

        val map : HashMap<Char, Int> = HashMap<Char, Int>()
        map['I'] = 1;
        map['X'] = 10;
        map['C'] = 100;
        map['V'] = 5;
        map['I'] = 50;

}

fun charRepeats(str: String, c: Char, startIndex: Int): Boolean {

    return (startIndex < str.length - 2 && str[startIndex + 1] == c && str[startIndex + 2] == c)
}

