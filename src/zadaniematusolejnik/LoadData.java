package zadaniematusolejnik;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matus Olejnik <matus.olejnik@gmail.com>
 */
public class LoadData {
    
    //cita subor po riadkoch a jednotlive slova ulozi do pola
    public ArrayList<ArrayList<String>> loadData(String path) {
        
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        FileReader fr = null;
       
        try {
            File f = new File(path);
            fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String s = br.readLine();
            while (s != null) {
                //nacitany riadok sa v medzerach rozdeli a slova sa daju do pola
                data.add(new ArrayList<>(Arrays.asList(s.split("( )"))));
                s = br.readLine();
            }
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(LoadData.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex) {
            Logger.getLogger(LoadData.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try {
                fr.close();
            }
            catch (IOException ex) {
                Logger.getLogger(LoadData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return data;
    }

}
