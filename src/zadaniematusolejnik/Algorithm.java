package zadaniematusolejnik;

/**
 *
 * @author Matus Olejnik <matus.olejnik@gmail.com>
 */
public class Algorithm {

    private final String inputWord;
    private final int inputWordLength;

    public Algorithm(String inputWord) {
        this.inputWord = inputWord.toLowerCase();
        inputWordLength = inputWord.length();
    }

    //pomocou dynamickeho programovanie najde a vrati dlzku najdlhsieho substringu
    //slov "inputWord" a "s"
    public int findLongestSubstring(String s) {
        s = s.toLowerCase();
        //tabulka pre dynamicke programovanie
        int[][] array = new int[inputWordLength][s.length()];
        //dlzka doposial najdlhsieho substringu
        int tempLength = 0;

        for (int i = 0; i < inputWordLength; i++) {
            for (int j = 0; j < s.length(); j++) {
                //ak sa znaky rovnaju zacneme vyplnat tabulku
                if (inputWord.charAt(i) == s.charAt(j)) {
                    //ak porovnavame zaciatok slova zapiseme do tabulky
                    //zaciatocnu hodnotu 1
                    if (i == 0 || j == 0) {
                        array[i][j] = 1;
                    }
                    else {
                        //ak uz nie sme na zaciatku slova tak z diagonaly vlavo hore
                        //zistime aktualnu dlzku substringu a do aktualnej poziacie
                        //zapiseme inkrementovanu hodnotu o 1
                        array[i][j] = array[i - 1][j - 1] + 1;
                    }
                    //ak sme zsitili ze aktualna dlzka substringu je vacsia ako doposial 
                    //najdlhsia, ulozime si tuto novu najdlhsiu dlzku
                    if (array[i][j] > tempLength) {
                        tempLength = array[i][j];
                    }
                }
                //ak sa porovnavane pismena nerovaju zapiseme do tabulky 0
                else {
                    array[i][j] = 0;
                }
            }
        }

        return tempLength;
    }

}
