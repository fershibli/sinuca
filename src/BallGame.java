import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JPanel;


public class BallGame extends JPanel {
	public int anguloX=18, anguloY=18, chargeblast=0;
	private GameObject b;
	public BallGame(GameObject b){
		this.b=b;
	}
	public void blastOFF(int miranguloX, int miranguloY, int blastoff){
		b.blastOFF(miranguloX, miranguloY, blastoff);
	}
	public Bola[] getBolas(){
		return b.getBolas();
	}

	public boolean getRolando(){
		return b.getRolando();
	}
	public void paintComponent(Graphics g){
		b.setMv(g.getClipBounds());
		Rectangle scr = b.getTela();
		g.setColor(new Color(0, 155, 0));//isso dará cor à janela quando ela for aumentada, experimente tirar esta linha e aumentar a janela.
		g.fillRect(scr.x, scr.y, scr.width, scr.height);//FILL RECT no lugar de CLEAN RECT para mantermos as cores dadas.
		for (int i=0;i<6;i+=1){
			Rectangle cacapa=b.getCacapas()[i].getArea();
			g.setColor(new Color(0, 0, 0));// cor da cacapa
			g.fillOval(cacapa.x, cacapa.y, cacapa.width, cacapa.height);
		}
		for (int i=0;i<6;i+=1){
			Rectangle bola=b.getBolas()[i].getArea();
			if (i==0){
				if (b.getBolas()[0].isRuning()==false && getRolando()){
					g.setColor(new Color(255,255, 255));
					g.fillOval(bola.x-(int)(this.anguloX*0.9)+(int)(bola.width/2)-4, bola.y-(int)(this.anguloY*0.9)+(int)(bola.height/2)-4, 4, 4);
					g.setColor(new Color(255,255, 255));
					g.fillOval(bola.x-(this.anguloX)+(int)(bola.width/2)-4, bola.y-(this.anguloY)+(int)(bola.height/2)-4, 4, 4);
					for(int c=1; c<5;c+=1){
						g.setColor(new Color(139,69,19));
						g.fillOval(bola.x-(int)(this.anguloX*(1+(c*0.1)))+(int)(bola.width/2)-4, bola.y-(int)(this.anguloY*(1+(c*0.1)))+(int)(bola.height/2)-4, 4, 4);
					}
				}
				g.setColor(new Color(255, 255-(this.chargeblast*5), 255-(this.chargeblast*5))); //bola branca
			} else{
				g.setColor(new Color(255, 0, 0));//isso dará cor à bola ;)
			}
			g.fillOval(bola.x, bola.y, bola.width, bola.height);
		}
	}

}
