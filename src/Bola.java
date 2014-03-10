import java.awt.Rectangle;

public class Bola {
	private Rectangle area;
	private int impulsox=0,impulsoy=0;
	private int movex=0, movey=0;
	private boolean rolando=true;
	
	Bola (Rectangle area, boolean branca){
		this.area=area;
		if (branca==true){
			this.impulsox=0;
			this.impulsoy=0;
			this.movex=1;
			this.movey=1;
		}
	}
	public boolean isRuning(){
		if (this.impulsox==0 && this.impulsoy==0){
			return false;
		} else{
			return true;
		}
	}
	public Rectangle getArea(){
		return area;
	}
	public boolean getRolando(){
		return rolando;
	}
	public void invertX(){
		this.movex=this.movex*(-1);
	}

	public void invertY(){
		this.movey=this.movey*(-1);
	}
	public void nullX(){
		this.area.x=0;
	}
	public void nullY(){
		this.area.y=0;
	}
	
	public void blastOFF(int miranguloX, int miranguloY, int blastoff){
		this.movex=miranguloX;
		this.movey=miranguloY;
		this.impulsox=Math.abs(blastoff*10);
		this.impulsoy=Math.abs(blastoff*10);
	}
	public void encacapar(Cacapa cacapa){
		if (cacapa.area.x+cacapa.area.width>this.getArea().x && cacapa.area.x<this.getArea().x+this.getArea().width && cacapa.area.y+cacapa.area.height>this.getArea().y && cacapa.area.y<this.getArea().y+this.getArea().width){
		//if (cacapa.area.x+(int)((cacapa.area.width*3)/4)>this.getArea().x && cacapa.area.x+(int)(cacapa.area.width/4)<this.getArea().x+this.getArea().width && cacapa.area.y+(int)((cacapa.area.height*3)/4)>this.getArea().y && cacapa.area.y+(int)(cacapa.area.height/4)<this.getArea().y+this.getArea().width){
			this.impulsox=0;
			this.impulsoy=0;
			this.area.x=(-1);
			this.area.y=(-1);
			this.area.height=1;
			this.area.width=1;
			this.rolando=false;
		}
	}
	public void moveBall(){
		if (rolando==true){
			if (this.impulsox>0 && Math.abs(this.movex)>0){
				this.area.x+=this.movex+(int)((this.impulsox/this.movex));
				this.impulsox-=1;
			} else{
				if (this.impulsox>0){
					this.impulsox-=1;
				}
			}
			if (this.impulsoy>0 && Math.abs(this.movey)>0){
				this.area.y+=this.movey+(int)((this.impulsoy/this.movey));
				this.impulsoy-=1;
			} else{
				if (this.impulsoy>0){
					this.impulsoy-=1;
				}
			}
			
		}
	}
	public void colisao(Bola bola){
		if (rolando){
			if (this.area.y+this.area.height>=bola.area.y && this.area.y<=bola.area.y+bola.area.height){
				if (this.area.x+this.area.width>bola.area.x && this.area.x<bola.area.x+bola.area.width){
					/*
					bola.movex=this.movex+(int)(0.1*this.movex*Math.abs(bola.movex));
					bola.movey=this.movey+(int)(0.1*this.movey*Math.abs(bola.movey));
					*/
					bola.movex=this.movex;
					bola.movey=this.movey;
					this.impulsox=(int)(this.impulsox/2);
					this.impulsoy=(int)(this.impulsoy/2);
					this.movex=-(this.movex);
					this.movey=-(this.movey);
					bola.impulsox+=this.impulsox;
					bola.impulsoy+=this.impulsoy;//-(int)(bola.impulsoy/2);
					this.moveBall();
				}
			}
			//if (this.area.x+this.area.width>=bola.getArea().x && this.area.x<=bola.getArea().x+bola.area.width){
				//if (this.area.y+this.area.height>bola.getArea().y && this.area.y<bola.getArea().y+bola.area.height){
					//bola.impulsoy+=(int)(this.impulsoy/2);//-(int)(bola.impulsoy/2);
					//this.impulsoy-=(int)(2.5*this.impulsoy/2);
				//}
			//}
		}
	}

}
