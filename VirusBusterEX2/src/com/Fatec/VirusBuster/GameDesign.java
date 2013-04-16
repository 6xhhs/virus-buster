/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Fatec.VirusBuster;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import javax.microedition.lcdui.game.*;
import java.io.IOException;

/**
 * @author kaue
 */
public class GameDesign {
    
//<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private Sprite bala;
    public int balaseq001Delay = 200;
    public int[] balaseq001 = {8};
    private Image tile_virus_buster;
    private Sprite Virus;
    public int Virusseq001Delay = 200;
    public int[] Virusseq001 = {4};
    private TiledLayer Fundo;
    private Sprite AntiVirus;
    public int AntiVirusseq004Delay = 200;
    public int[] AntiVirusseq004 = {12};
    private Image VB;
    private Sprite spriteIntro;
    public int spriteIntroseq001Delay = 200;
    public int[] spriteIntroseq001 = {0};
    private Image game_over;
    private Sprite spriteGameOver;
    public int spriteGameOverseq001Delay = 200;
    public int[] spriteGameOverseq001 = {0};
//</editor-fold>//GEN-END:|fields|0|
    
//<editor-fold defaultstate="collapsed" desc=" Generated Methods ">//GEN-BEGIN:|methods|0|
//</editor-fold>//GEN-END:|methods|0|



    public Image getTile_virus_buster() throws java.io.IOException {//GEN-BEGIN:|2-getter|0|2-preInit
        if (tile_virus_buster == null) {//GEN-END:|2-getter|0|2-preInit
            // write pre-init user code here
            tile_virus_buster = Image.createImage("/tile_virus_buster.png");//GEN-BEGIN:|2-getter|1|2-postInit
        }//GEN-END:|2-getter|1|2-postInit
        // write post-init user code here
        return this.tile_virus_buster;//GEN-BEGIN:|2-getter|2|
    }//GEN-END:|2-getter|2|

    public Sprite getAntiVirus() throws java.io.IOException {//GEN-BEGIN:|57-getter|0|57-preInit
        if (AntiVirus == null) {//GEN-END:|57-getter|0|57-preInit
            // write pre-init user code here
            AntiVirus = new Sprite(getTile_virus_buster(), 16, 16);//GEN-BEGIN:|57-getter|1|57-postInit
            AntiVirus.setFrameSequence(AntiVirusseq004);//GEN-END:|57-getter|1|57-postInit
            // write post-init user code here
        }//GEN-BEGIN:|57-getter|2|
        return AntiVirus;
    }//GEN-END:|57-getter|2|



    public Sprite getBala() throws java.io.IOException {//GEN-BEGIN:|70-getter|0|70-preInit
        if (bala == null) {//GEN-END:|70-getter|0|70-preInit
            // write pre-init user code here
            bala = new Sprite(getTile_virus_buster(), 16, 16);//GEN-BEGIN:|70-getter|1|70-postInit
            bala.setFrameSequence(balaseq001);//GEN-END:|70-getter|1|70-postInit
            // write post-init user code here
        }//GEN-BEGIN:|70-getter|2|
        return bala;
    }//GEN-END:|70-getter|2|

    public void updateLayerManagerForCena(LayerManager lm) throws java.io.IOException {//GEN-LINE:|101-updateLayerManager|0|101-preUpdate
        // write pre-update user code here
        getVirus().setPosition(6, 4);//GEN-BEGIN:|101-updateLayerManager|1|101-postUpdate
        getVirus().setVisible(true);
        lm.append(getVirus());
        getBala().setPosition(37, 75);
        getBala().setVisible(false);
        lm.append(getBala());
        getAntiVirus().setPosition(2, 186);
        getAntiVirus().setVisible(true);
        lm.append(getAntiVirus());
        getFundo().setPosition(1, 1);
        getFundo().setVisible(true);
        lm.append(getFundo());//GEN-END:|101-updateLayerManager|1|101-postUpdate
        // write post-update user code here
    }//GEN-LINE:|101-updateLayerManager|2|

    public TiledLayer getFundo() throws java.io.IOException {//GEN-BEGIN:|113-getter|0|113-preInit
        if (Fundo == null) {//GEN-END:|113-getter|0|113-preInit
            // write pre-init user code here
            Fundo = new TiledLayer(20, 20, getTile_virus_buster(), 16, 16);//GEN-BEGIN:|113-getter|1|113-midInit
            int[][] tiles = {
                {16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16},
                {16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16},
                {16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16},
                {16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16},
                {16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16},
                {16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16},
                {16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16},
                {16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16},
                {16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16},
                {16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16},
                {16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16},
                {16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16},
                {16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16},
                {16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16},
                {16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16},
                {16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16},
                {16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16},
                {16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16},
                {16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16},
                {16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16}
            };//GEN-END:|113-getter|1|113-midInit
            // write mid-init user code here
            for (int row = 0; row < 20; row++) {//GEN-BEGIN:|113-getter|2|113-postInit
                for (int col = 0; col < 20; col++) {
                    Fundo.setCell(col, row, tiles[row][col]);
                }
            }
        }//GEN-END:|113-getter|2|113-postInit
        // write post-init user code here
        return Fundo;//GEN-BEGIN:|113-getter|3|
    }//GEN-END:|113-getter|3|

    public Sprite getVirus() throws java.io.IOException {//GEN-BEGIN:|132-getter|0|132-preInit
        if (Virus == null) {//GEN-END:|132-getter|0|132-preInit
            // write pre-init user code here
            Virus = new Sprite(getTile_virus_buster(), 16, 16);//GEN-BEGIN:|132-getter|1|132-postInit
            Virus.setFrameSequence(Virusseq001);//GEN-END:|132-getter|1|132-postInit
            // write post-init user code here
        }//GEN-BEGIN:|132-getter|2|
        return Virus;
    }//GEN-END:|132-getter|2|

    public void updateLayerManagerForIntro(LayerManager lm) throws java.io.IOException {//GEN-LINE:|217-updateLayerManager|0|217-preUpdate
        // write pre-update user code here
        getSpriteIntro().setPosition(6, 6);//GEN-BEGIN:|217-updateLayerManager|1|217-postUpdate
        getSpriteIntro().setVisible(true);
        lm.append(getSpriteIntro());//GEN-END:|217-updateLayerManager|1|217-postUpdate
        // write post-update user code here
    }//GEN-LINE:|217-updateLayerManager|2|

    public void updateLayerManagerForGame_Over(LayerManager lm) throws java.io.IOException {//GEN-LINE:|218-updateLayerManager|0|218-preUpdate
        // write pre-update user code here
        getSpriteGameOver().setPosition(7, 6);//GEN-BEGIN:|218-updateLayerManager|1|218-postUpdate
        getSpriteGameOver().setVisible(true);
        lm.append(getSpriteGameOver());//GEN-END:|218-updateLayerManager|1|218-postUpdate
        // write post-update user code here
    }//GEN-LINE:|218-updateLayerManager|2|

    public Image getVB() throws java.io.IOException {//GEN-BEGIN:|219-getter|0|219-preInit
        if (VB == null) {//GEN-END:|219-getter|0|219-preInit
            // write pre-init user code here
            VB = Image.createImage("/VB.png");//GEN-BEGIN:|219-getter|1|219-postInit
        }//GEN-END:|219-getter|1|219-postInit
        // write post-init user code here
        return this.VB;//GEN-BEGIN:|219-getter|2|
    }//GEN-END:|219-getter|2|

    public Sprite getSpriteIntro() throws java.io.IOException {//GEN-BEGIN:|220-getter|0|220-preInit
        if (spriteIntro == null) {//GEN-END:|220-getter|0|220-preInit
            // write pre-init user code here
            spriteIntro = new Sprite(getVB(), 200, 200);//GEN-BEGIN:|220-getter|1|220-postInit
            spriteIntro.setFrameSequence(spriteIntroseq001);//GEN-END:|220-getter|1|220-postInit
            // write post-init user code here
        }//GEN-BEGIN:|220-getter|2|
        return spriteIntro;
    }//GEN-END:|220-getter|2|

    public Image getGame_over() throws java.io.IOException {//GEN-BEGIN:|225-getter|0|225-preInit
        if (game_over == null) {//GEN-END:|225-getter|0|225-preInit
            // write pre-init user code here
            game_over = Image.createImage("/game_over.png");//GEN-BEGIN:|225-getter|1|225-postInit
        }//GEN-END:|225-getter|1|225-postInit
        // write post-init user code here
        return this.game_over;//GEN-BEGIN:|225-getter|2|
    }//GEN-END:|225-getter|2|

    public Sprite getSpriteGameOver() throws java.io.IOException {//GEN-BEGIN:|226-getter|0|226-preInit
        if (spriteGameOver == null) {//GEN-END:|226-getter|0|226-preInit
            // write pre-init user code here
            spriteGameOver = new Sprite(getGame_over(), 200, 200);//GEN-BEGIN:|226-getter|1|226-postInit
            spriteGameOver.setFrameSequence(spriteGameOverseq001);//GEN-END:|226-getter|1|226-postInit
            // write post-init user code here
        }//GEN-BEGIN:|226-getter|2|
        return spriteGameOver;
    }//GEN-END:|226-getter|2|












    
}
