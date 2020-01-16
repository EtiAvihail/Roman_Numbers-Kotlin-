val legalChars: HashMap<Char, Int> = createMap()

fun isRomanNumber(str: String): Boolean {

    for (i in 0 until (str.length - 1)) {

        if (!legalChars.contains(str[i])) return false
        if (!legalRepeats(str, i)) return false
        if (!singleLesser(str, i)) return false
    }

    return true
}

fun createMap(): HashMap<Char, Int> {

    val map: HashMap<Char, Int> = HashMap<Char, Int>()
    map['I'] = 1;
    map['X'] = 10;
    map['C'] = 100;
    map['V'] = 5;
    map['L'] = 50;

    return map
}

fun legalRepeats(str: String, index: Int): Boolean {

    when (str[index]) {

        'I' -> if (charRepeats(str, 'I', index)) return false
        'X' -> if (charRepeats(str, 'X', index)) return false
        'C' -> if (charRepeats(str, 'C', index)) return false
        'V' -> if (index < str.length - 1 && str[index] == 'V') return false
        'L' -> if (index < str.length - 1 && str[index] == 'L') return false
    }

    return true

}

fun charRepeats(str: String, c: Char, startIndex: Int): Boolean {

    return (startIndex < str.length - 3 && str[startIndex + 1] == c && str[startIndex + 2] == c)
}

fun singleLesser(str: String, index: Int): Boolean {

    if (index == 0 || index == str.length) return true
    else {

        if ((legalChars[str[index - 1]]!! <= legalChars[str[index]]!!) && (legalChars[str[index]]!! <= legalChars[str[index + 1]]!!)) {
            return false
        }
    }

    return true
}

