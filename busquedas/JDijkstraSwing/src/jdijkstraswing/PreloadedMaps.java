package jdijkstraswing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class PreloadedMaps {
    public static Object[][] loadFromFile() {
        Object[][] data = null;
        
        JFileChooser jfc = new JFileChooser();
        jfc.setFileFilter(new FileNameExtensionFilter("Archivos de mapa", "map", "MAP"));
        int acepto = jfc.showOpenDialog(null);
        
        if(acepto == JFileChooser.CANCEL_OPTION)
            return null;
        
        File file = jfc.getSelectedFile();
        FileInputStream reader;
        
        try {
            char c, fin;
            reader = new FileInputStream(file);
            String num = "";
            int x = 0, y = 0;
            
            do {
                fin = (char) reader.read();
                num += Character.toString(fin);
            } while(fin != '\n');
            
            String[] sizestr = num.split("\\s");
            int w = Integer.parseInt(sizestr[0]);
            int h = Integer.parseInt(sizestr[1]);
            data = new Object[w][h];
            
            while(reader.available() > 0) {
                c = (char) reader.read();
                
                switch(c) {
                    case 'B':
                        data[x][y] = Const.BLOCK; y++; break;
                    case '.':
                        data[x][y] = Const.TILE; y++; break;
                    case '\n':
                        y = 0; x++; break;
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PreloadedMaps.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PreloadedMaps.class.getName()).log(Level.SEVERE, null, ex);
        } catch(NumberFormatException ex) {
            //
        }
        
        return data;
    }
    
    public static void saveFile(Object[][] data) {
        int N = data.length;
        FileOutputStream fo;
        JFileChooser jfc = new JFileChooser();
        jfc.setFileFilter(new FileNameExtensionFilter("Archivos de mapa", "map", "MAP"));
        int aceptar = jfc.showSaveDialog(null);
        File f = null;
        
        if(aceptar == JFileChooser.CANCEL_OPTION) {
            return;
        }
        
        f = jfc.getSelectedFile();
        try {
            fo = new FileOutputStream(f);
            String n = Integer.toString(N);
            String headerStr = n + " " + n + "\n";
            byte[] header = headerStr.getBytes();
            fo.write(header);
            
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    fo.write(((String) data[i][j]).getBytes());
                }
                
                fo.write("\n".getBytes());
            }
            
            fo.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PreloadedMaps.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PreloadedMaps.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
