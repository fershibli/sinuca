import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.JFrame;
import java.awt.event.*;

//1)JFrame: Tela do JOGO
//  ____________________
// |__________________|X|
// |        O           |
// |       <|V          |
// |-------V \----------|
// |____________________|
//
//2)JPanel: Usado para controlar a parte gráfica (ideal para menu).
//   __x__________________
//  |O-->                 |-
// y||                    |:
//  |V                    |height
//  |                     |:
//  |_____________________|-
//   |.......width.......|
//
// 1 e 2 fazem parte do pacote Swing
//
//3)Graphics: Usado para controle "Geométrico" do JPanel.
//4)Retangle: Colisão de Objeto usado para guardar coordenadas na tela.
//
public class Teste extends JFrame implements KeyListener{
	static JFrame j;
	static BallGame panel;
	public static void main(String[] args){
		GameObject gob = new GameObject(new Rectangle(0,0,600,300),new Rectangle(0,0,600,300));
		panel = new BallGame(gob);
		j = new Teste();
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setSize(gob.getTela().width, gob.getTela().height);
		j.setContentPane(panel); //a linha mais importante do curso até agora
		j.setBackground(new Color(0, 155, 0));//isso dará cor à janela inicial, veja a classe BallGame...
		j.setVisible(true);
		while(true){
			gob.mover();
			j.repaint();
			try {
				Thread.sleep(60);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	Teste(){
		setTitle("Jogo da Bola");
		addKeyListener(this);
	}
	public void keyPressed(KeyEvent e){
		if(e.getSource()==j && panel.getRolando()){

			if(e.getKeyCode()==40){//DOWN
				if (panel.anguloY<=18 && panel.anguloY>-18){
					panel.anguloY-=1;
				}
			}
			if(e.getKeyCode()==39){//RIGHT
				if (panel.anguloX<=18 && panel.anguloX>-18){
					panel.anguloX-=1;
				}
			}
			if(e.getKeyCode()==38){//UP
				if (panel.anguloY<18 && panel.anguloY>=-18){
					panel.anguloY+=1;
				}
			}
			if(e.getKeyCode()==37){//LEFT
				if (panel.anguloX<18 && panel.anguloX>=-18){
					panel.anguloX+=1;
				}
			}
			if(e.getKeyCode()<=40 && e.getKeyCode()>=37){
				//System.out.println(panel.getBolas()[0].isRuning()+","+panel.anguloX+","+panel.anguloY);
			}
			if (panel.getBolas()[0].isRuning()==false){
				if(e.getKeyCode()==32){//space
					if (panel.chargeblast<50){
						panel.chargeblast+=2;
					}
				}
			}
		}
	}
	public void keyReleased(KeyEvent e){
		if(e.getSource()==j && panel.getRolando()){
			if (panel.getBolas()[0].isRuning()==false){
				if(e.getKeyCode()==32){//space
					panel.blastOFF(panel.anguloX, panel.anguloY, panel.chargeblast);
					panel.chargeblast=0;
				}
			}
		}
	}
	public void keyTyped(KeyEvent e){
		
	}
}
