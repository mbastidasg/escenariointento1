/*
 PLANTILLA BASE PARA CREACION DE ESCENARIOS.
 */
package Ejercicio0;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {

    private int xref;
    private int yref;
    private Timer timer;
    private int secuencia;
    private int secEscenario;

    public Board() {
        this.xref = 10;
        this.yref = 0;
        this.timer = new Timer(25, this);
        this.timer.start();
        this.secuencia = 0;
        this.secEscenario = 0;

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.red);

        Image fondo = loadImage("blue_background.png");
       for (int i = 0; i <80; i++) {
          g.drawImage(fondo, i*22, 0, this);  
        }
        Image piedras = loadImage ("stone.png");
        
        g.drawImage(fondo, xref, yref, this)

        Image gato = loadImage("cats.gif");

        g.drawImage(gato, xref, 100, (xref+132), 180,(132 * secuencia), 0, ((132 * secuencia) + 132), 80, this);

        g.drawRect(this.xref, 50, 20, 20);
        Rectangle carro = new Rectangle(this.xref, 50, 20, 20);

        g.fillOval(40, this.yref, 15, 15);
        Rectangle oval = new Rectangle(40, this.yref, 15, 15);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.xref++;
        this.yref++;
        this.secuencia++;
        if (this.secuencia >= 5) {
            this.secuencia = 0;
        }
        if (this.xref >= 660) {
            this.xref = 0;
        }
        repaint();
       
        
    }

    public Image loadImage(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }

}
