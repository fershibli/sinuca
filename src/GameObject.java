import java.awt.*;
import java.util.Random;

public class GameObject{
	private Rectangle tela;
	private Bola[] bolas = new Bola[6]; //era uma boa montar uma classe bola
	private Cacapa[] cacapas = new Cacapa[6];
	private Rectangle mv;
	Random aleatorio= new Random();
	public GameObject(Rectangle tela, Rectangle mv){
		this.mv=mv;
		this.cacapas[0]=new Cacapa(new Rectangle(0,0,20, 20));
		this.cacapas[1]=new Cacapa(new Rectangle(0,mv.height-60,20, 20));
		this.cacapas[2]=new Cacapa(new Rectangle(mv.width-36,mv.height-60,20, 20));
		this.cacapas[3]=new Cacapa(new Rectangle(mv.width-36,0,20, 20));
		this.cacapas[4]=new Cacapa(new Rectangle((int)(mv.width/2)-16,mv.height-60,20, 20));
		this.cacapas[5]=new Cacapa(new Rectangle((int)(mv.width/2)-16,0,20, 20));
		this.bolas[0]=new Bola(new Rectangle((int)(mv.width/2)-16,(int)(mv.height/2)-40,20, 20), true);
		this.bolas[1]=new Bola(new Rectangle(100,20,20, 20), false);
		for (int ball=2; ball<6; ball+=1){
			this.bolas[ball]=new Bola(new Rectangle(20+aleatorio.nextInt(mv.width-56),20+aleatorio.nextInt(mv.height-80),20, 20), false);
		}
		
		this.tela=tela;
	}
	public void setMv(Rectangle mv){
		this.mv=mv;
	}
	public Bola[] getBolas(){
		return bolas;
	}
	public void blastOFF(int miranguloX, int miranguloY, int blastoff){
		bolas[0].blastOFF(miranguloX, miranguloY, blastoff);
	}

	public boolean getRolando(){
		return bolas[0].getRolando();
	}

	public Cacapa[] getCacapas(){
		return cacapas;
	}
	public Rectangle getTela(){
		return tela;
	}

	public void mover(){//condições de movimento e colisão
		for (int i=0; i<6; i+=1){
			bolas[i].moveBall();
			for (int e=0; e<6; e+=1){
				if (e!=i){
					bolas[i].colisao(bolas[e]);
				}
			}
			if (bolas[i].getArea().x>(mv.width-bolas[i].getArea().width)){
				bolas[i].invertX();
				bolas[i].getArea().x=mv.width-bolas[i].getArea().width;
			}
			if (bolas[i].getArea().y>(mv.height-bolas[i].getArea().height)){
				bolas[i].invertY();
				bolas[i].getArea().y=mv.height-bolas[i].getArea().height;
			}
			if (bolas[i].getArea().x<=0){
				bolas[i].invertX();
				bolas[i].nullX();
			}
			if (bolas[i].getArea().y<=0){
				bolas[i].invertY();
				bolas[i].nullY();
			}
			for (int a=0; a<6;a+=1){
				bolas[i].encacapar(cacapas[a]);
			}
		}
	}


}
