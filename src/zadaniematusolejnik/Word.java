package zadaniematusolejnik;

/**
 *
 * @author Matus Olejnik <matus.olejnik@gmail.com>
 */

//trieda ktora bude obsahovat samotne slovo, koeficient daneho slova,
//offset dlzky a pomocny koeficient
public class Word {
    private int coeff;
    private String word;
    private int offset;
    private int wordLength;
    
    //nepouzite
    public Word(String word, int coeff, int offset){
        this.word = word;
        this.coeff = coeff;
        this.offset = offset;
        
        wordLength = word.length();
    }
    
    public Word(String word, int coeff){
        this.word = word;
        this.coeff = coeff;
        //this.offset = offset;
        
        wordLength = word.length();
       // wordLength = coeff - offset;
    }
    
    public int getCoeff(){
        return coeff;
    }
    
    public int getOffset(){
        return offset;
    }
    
    //dlzka slova
    public int getWordLength(){
        return wordLength;
    }
    
    public String getWord(){
        return word;
    }

}
