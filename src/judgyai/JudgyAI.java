/*
* Auteur : Lycia Mameri
*/
package judgyai;


import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class JudgyAI {

    public static void main(String[] args) throws Exception {
        
        
        //DEBUT CODE GRAPHIC
        SwingUtilities.invokeLater(new Runnable(){
        @Override
        public void run(){
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.getContentPane().add(new Graphic());
            frame.pack();
            frame.setVisible(true);
        }
    });//FIN CODE GRAPHIC
        
        
    }

}
