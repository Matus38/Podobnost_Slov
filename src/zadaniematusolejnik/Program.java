package zadaniematusolejnik;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matus Olejnik <matus.olejnik@gmail.com>
 */
public class Program {

    static final int WORDS_SIZE = 10;
    //pole s 10 najviac vyhovujucimi slovami
    Word words[] = new Word[WORDS_SIZE];

    //pomocne slovo pre hladanie lepsich
    Word worstWord = new Word("", Integer.MAX_VALUE, Integer.MAX_VALUE);
    int worstIndex = 0;

    //pocet slov v poli
    int count = 0;

    String inputWord;

    public Program() {

    }

    public void calculateCoeff() {

        ArrayList<ArrayList<String>> data = new ArrayList<>();

        //oznacenie toho ze do pola bolo pridane lepsie slovo a teda sa musi najst nove najhorsie
        boolean newWord = true;

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            LoadData ld = new LoadData();

            //System.out.println("Zadajte cestu k vstupnemu suboru");
            data = ld.loadData(br.readLine());
            //System.out.println("Zadajte vstupne slovo");
            inputWord = br.readLine();
            if (inputWord.length() < 3) {
                System.out.println("Vstupne slovo musi mat minimalnu dlzku 3");
                return;
            }
            else {
                Algorithm a = new Algorithm(inputWord);
                int aaa = 0;

                //prejde vsetky nacitane slova
                for (int i = 0; i < data.size(); i++) {
                    for (int j = 0; j < data.get(i).size(); j++) {
                        if (data.get(i).get(j).length() < 1) {
                            continue;
                        }

                        Word tmpW = new Word(data.get(i).get(j), a.findLongestSubstring(data.get(i).get(j)));
                                

                        //ak v poli este nie je 10 slov tak ich len pridame
                        if (count < WORDS_SIZE) {
                            words[count] = tmpW;
                            count++;
                        }
                        if (count >= WORDS_SIZE) {
                            //ak je slov viac ako 10 najprv sa najde najhorsie slovo
                            if (newWord) {
                                findWorst();
                                newWord = false;
                            }
                            //dalej sa hlada najhorsie slovo len ak pripudne nejake s lepsim koeficientom
                            //na zaklade podmienky
                            //ak je VS kratsie alebo rovnako dlhe ako nacitane slovo v pripade podobnosti
                            //je lepsie to kratsie
                            if ((tmpW.getCoeff() > worstWord.getCoeff())
                                    || ((tmpW.getCoeff() == worstWord.getCoeff()) && (tmpW.getWordLength() < worstWord.getWordLength()))) {
                                //vlozim do pola nove lepsie slovo
                                words[worstIndex] = tmpW;
                                worstWord = tmpW;
                                newWord = true;
                            }
                        }

                    }
                }
            }
        }

        catch (IOException ex) {
            Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (count > 0) {
            printWords();
        }
        else {
            System.out.println("Ziadne najdene slovo");
        }

    }

    //usporiada slova podla koeficientov
    public void sortWords() {
        Word tmp;

        for (int i = 0; i < count; i++) {
            for (int j = i + 1; j < count; j++) {
                //ak je koeficient jedneho vacsi ako aktiualne maximum vymenia sa prvku
                //alebo ak sa koeficienty rovnaju tak sa porovnaju dlzky slov, ak je jedno vacsie ma mensiu
                //prioritu a preto sa vymenia
                if ((words[i].getCoeff() < words[j].getCoeff())
                        || ((words[i].getCoeff() == words[j].getCoeff()) && (words[i].getWordLength() > words[j].getWordLength()))) {
                    tmp = words[i];
                    words[i] = words[j];
                    words[j] = tmp;
                }
               
            }
        }
    }

    public void printWords() {
        sortWords();
        for (int i = 0; i < count; i++) {
            System.out.println(words[i].getWord() + " - koeficient podobnosti " + words[i].getCoeff());
        }
    }

    //porovna koeficienty, pripade dlzky slov a na zaklade toho urci najhorsie slovo
    public void findWorst() {
        for (int k = 0; k < WORDS_SIZE; k++) {
            if (words[k].getCoeff() < worstWord.getCoeff()) {
                worstWord = words[k];
                worstIndex = k;
            }
            else if (words[k].getCoeff() == worstWord.getCoeff()) {
                if (words[k].getWordLength() > worstWord.getWordLength()) {
                    worstWord = words[k];
                    worstIndex = k;
                }
            }
        }
    }
}
