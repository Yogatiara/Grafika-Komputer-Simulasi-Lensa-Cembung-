import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.border.Border;

public class lensaCembung extends JComponent {
    
    private  class Line {
        final int x1; 
        final int y1;
        final int x2;
        final int y2;   
        final Color color;

        public Line(int x1, int y1, int x2, int y2, Color color) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.color = color;
        }               
    }

    private final List<Line> lines = new ArrayList<Line>();

    public void addLine(int x1, int x2, int x3, int x4, Color color) {
        lines.add(new Line(x1, x2, x3, x4, color));
       
    }

    public JFrame JFrame() {
       
        JFrame frame = new JFrame();

        frame.add( new lensaCembung());
        frame.setSize( 1070, 1000);

        frame.setVisible( true );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        return frame;
    }

    public JPanel Jpanel() {
        JPanel greenPanel = new JPanel();
        JPanel totalGUI = new JPanel();
        Border blackline = BorderFactory.createLineBorder(Color.green);
  
        totalGUI.setLayout(null);

        greenPanel.setBackground(new Color(204,255,204));
        greenPanel.setLocation(30, 120);
        greenPanel.setSize(1000,700);
        greenPanel.setBorder(blackline);

        totalGUI.add(greenPanel);
        totalGUI.add(Slider());
     
        JFrame().getContentPane().add(totalGUI);
        
        return totalGUI;
    }
    
    public void paint(Graphics g) {
        g.drawLine(30, 465, 1028, 465);  // Garis horizontal
        g.drawLine(525, 120, 525, 820);  // Garis vertikal
        
        for (Line line : lines) {
            g.setColor(line.color);
            g.drawLine(line.x1, line.y1, line.x2, line.y2);  
        }
    }

    public Component Slider() {  
        JSlider slider = new JSlider(JSlider.VERTICAL, 0, 500, 250);  
        slider.setPreferredSize(new Dimension(16,700));
        Dimension size = slider.getPreferredSize();
        slider.setBounds(10, 120, size.width, size.height);
  
        return slider;
    } 


    public static void main( String[] args ) {
        lensaCembung grafik = new lensaCembung();

        grafik.Jpanel();
      
   
        grafik.addLine(1000, 250, 216, 154, Color.BLACK);

    }

}