
package com.Fatec.VirusBuster;

import java.io.IOException;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.game.GameCanvas;
import javax.microedition.lcdui.game.LayerManager;
import javax.microedition.lcdui.game.Sprite;
import javax.microedition.lcdui.game.TiledLayer;

/**
 *
 * @author kaue
 */
public class Jogo extends GameCanvas implements Runnable
{
    boolean rodando;
    LayerManager lm;
    Sprite virus;
    int velocidadeVirus;

    int linha;
    int velocidadeBala;
    Sprite antiVirus;
    Sprite bala;
    Sprite spriteIntro;
    Sprite spriteGameOver;
    int tela =1;
    int totalDeletados = 0;
    TiledLayer fundo;
    GameDesign gd;
    boolean balaAtirada;
    //inicializa as variaveis
    public void init() throws  IOException
    {
        gd = new GameDesign();
        this.rodando = true;
        balaAtirada = false;
        this.antiVirus = gd.getAntiVirus();
        this.fundo = gd.getFundo();
        this.velocidadeVirus = 10;
        this.velocidadeBala = 10;
        this.spriteIntro = gd.getSpriteIntro();
        this.spriteGameOver = gd.getSpriteGameOver();
        this.linha =0;
        this.bala = gd.getBala();
        this.virus = gd.getVirus();
        this.lm = new LayerManager();
        gd.updateLayerManagerForIntro(lm);
        this.antiVirus.setPosition(this.getHeight()/2 - 8, this.getHeight()-16);
        }
    public Jogo()
    {
        super(true);
        try
        {
            this.init();
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
    
    public void parar()
    {
        this.rodando = false;
    }
    
    public void run() {
        Graphics g = getGraphics();
        while (this.rodando) {
            //verifica se o jogador apertou alguma tecla
            int keyState = getKeyStates();
            //se estiver na tela principal tela -> 1
            if(tela == 1)
            {   
                try
                {
                gd.updateLayerManagerForIntro(lm);
                }
                catch(Exception ex)
                {
                    System.out.println(ex);
                }
                        
                spriteIntro.setVisible(true);
                if(keyState!=0)
                {
                    try
                    {
                        gd.updateLayerManagerForCena(lm);
                        this.antiVirus.setPosition(this.getHeight()/2 - 8, this.getHeight()-16);
                        antiVirus.setVisible(true);
                        fundo.setVisible(true);
                        virus.setVisible(true);
                        spriteIntro.setVisible(false);
                        spriteGameOver.setVisible(false);
                        tela = 2;
                    }catch(Exception ex)
                    {
                        System.out.print(ex);
                    }
                }
            }
            //lagica da tela de jogo
            else if(tela == 2){
            //se tecla esquerda
                
            if ((keyState & LEFT_PRESSED) != 0 && antiVirus.getX()> 0 )
            {
                antiVirus.move(-4,0);
            }
            //se tecla direita
            if ((keyState & RIGHT_PRESSED) != 0 && antiVirus.getX()< this.getWidth()-antiVirus.getWidth())
            {
                antiVirus.move(4,0);
            }
            //se tecla up e a bala ainda não foi atirada
            if ((keyState & UP_PRESSED) != 0 && !balaAtirada )
            {
                //re alinha a bala com o char controlado pelo jogador
                bala.setPosition(antiVirus.getX(), antiVirus.getY());
                //muda o estado dabala para atirada
                balaAtirada = true;
                //deicha a bala visivel
                bala.setVisible(true);
            }
            //se a bala foi atirada mova ela em y
            if(balaAtirada)
                bala.move(0,-velocidadeBala);
            
            //move o "Virus" na direção 
            virus.move(velocidadeVirus, 0);
            //se o "Virus" sair da tela ,deça uma linha ate chegar no jogador
            if(virus.getX() > this.getWidth() || virus.getX()< 0 )
            {
                virus.move(0, 16);
                velocidadeVirus = -velocidadeVirus;
            }
            //verifica se a bala colidio com o virus
            if(bala.collidesWith(virus, false))
            {
                virus.setPosition(0, 0);
                balaAtirada = false;
                bala.setVisible(false);
                bala.setPosition(0, 0);
                totalDeletados++;
                //a cada 3 virus 'deletados' o jogo fica mais dificil
                if(totalDeletados%3 == 0)
                    if(velocidadeVirus>0)
                    {
                        velocidadeVirus+=5;
                        System.out.println(velocidadeVirus);
                    }
                    else
                    {
                        velocidadeVirus-=5;
                        System.out.println(velocidadeVirus);
                    }
            }
            //permite que o jogador atire denovo
            if(bala.getY() < 0)
            {
                balaAtirada = false;
                bala.setVisible(false);
                bala.setPosition(0, 0);
            }
                if(virus.collidesWith(antiVirus, false))
                {
                    tela=3;
                }
           }
            //Game over...
            else if(tela==3)
            {
                
                try{
                    gd.updateLayerManagerForGame_Over(lm);
                    //alinhando o sprite de game over com o centro da tela
                    spriteGameOver.setPosition(this.getWidth()/2 - spriteGameOver.getWidth()/2,this.getHeight()/2 - spriteGameOver.getHeight()/2);
                    bala.setVisible(false);
                    antiVirus.setVisible(false);
                    fundo.setVisible(false);
                    virus.setVisible(false);
                    spriteIntro.setVisible(false);
                    spriteGameOver.setVisible(true);
                    velocidadeVirus = 10;
                    
                    
                    }catch(Exception ex)
                    {
                        System.out.println(ex);
                    }
                if(keyState!=0)
                {
                    try
                    {
                        gd.updateLayerManagerForIntro(lm);
                        tela=1;
                    }catch(Exception ex)
                    {
                        System.out.println(ex);
                    }
                    
                }
            }
            //desenha a tela
            
            this.lm.paint(g, 0, 0);
            flushGraphics(0, 0, this.getWidth(), this.getHeight());

            try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
    
}
