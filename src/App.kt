object App {

    private val legalChars: HashMap<Char, Int> = createMap()

    fun isRomanNumber(str: String): Boolean {

        for (i in 0 until str.length) {

            if (!legalChars.contains(str[i])) return false

            when(str[i]){

                'I', 'X', 'C' -> if(!checkIXC(str, i)) return false
                'V', 'L' ->  if (i > 0 && str[i] == str[i - 1]) return false

            }
        }

        return true
    }

    private fun createMap(): HashMap<Char, Int> {

        val map: HashMap<Char, Int> = HashMap<Char, Int>()
        map['I'] = 1;
        map['X'] = 10;
        map['C'] = 100;
        map['V'] = 5;
        map['L'] = 50;

        return map
    }

    private fun checkIXC(str : String, index : Int) : Boolean{

        if(index == 0) return true
        if(charRepeats(str, index)) return false
        if(index < str.length - 1 && legalChars[str[index]]!! < legalChars[str[index + 1]]!!){
            when(str[index]){
                'I' -> if(str[index - 1] == 'I') return false
                'X' -> if(str[index - 1] == 'I' || str[index - 1] == 'X') return false
            }
        }

        return true
    }

    private fun charRepeats(str: String, index: Int): Boolean {

        var c : Char = str[index]

        return (index > 2  && str[index - 1] == c && str[index - 2] == c && str[index - 3] == c)

    }

}