/*  1:   */ package com.calialec.radarbro;
/*  2:   */ 
/*  3:   */ import java.util.List;
/*  4:   */ import net.minecraft.client.Minecraft;
/*  5:   */ import net.minecraft.client.gui.GuiButton;
/*  6:   */ import net.minecraft.client.gui.GuiScreen;
/*  7:   */ import net.minecraft.util.StringTranslate;
/*  8:   */ import org.lwjgl.input.Keyboard;
/*  9:   */ 
/* 10:   */ public class GuiRadarBroGUISettings
/* 11:   */   extends GuiScreen
/* 12:   */ {
/* 13:   */   private GuiScreen parentScreen;
/* 14:   */   
/* 15:   */   public GuiRadarBroGUISettings(GuiScreen guiscreen)
/* 16:   */   {
/* 17:14 */     this.parentScreen = guiscreen;
/* 18:   */   }
/* 19:   */   
/* 20:   */   public void initGui()
/* 21:   */   {
/* 22:19 */     StringTranslate stringTranslate = new StringTranslate();
/* 23:20 */     Keyboard.enableRepeatEvents(true);
/* 24:21 */     this.buttonList.clear();
/* 25:22 */     this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 - 16, "Auto Rotate: " + (mod_RadarBro.RadarAutoRotate ? "ON" : "OFF")));
/* 26:23 */     this.buttonList.add(new GuiButton(1, this.width / 2 - 100, this.height / 4 + 8, "Coordinates: " + (mod_RadarBro.RadarCoordinates ? "ON" : "OFF")));
/* 27:24 */     this.buttonList.add(new GuiButton(2, this.width / 2 - 100, this.height / 4 + 32, "Terrain: " + (mod_RadarBro.RadarTerrain ? "ON" : "OFF")));
/* 28:25 */     this.buttonList.add(new GuiButton(3, this.width / 2 - 100, this.height / 4 + 56, "Reposition Radar..."));
/* 29:26 */     this.buttonList.add(new GuiButton(4, this.width / 2 - 100, this.height / 4 + 80, stringTranslate.translateKey("gui.done")));
/* 30:   */   }
/* 31:   */   
/* 32:   */   public void onGuiClosed()
/* 33:   */   {
/* 34:31 */     Keyboard.enableRepeatEvents(false);
/* 35:   */   }
/* 36:   */   
/* 37:   */   protected void actionPerformed(GuiButton guibutton)
/* 38:   */   {
/* 39:36 */     if (!guibutton.enabled) {
/* 40:38 */       return;
/* 41:   */     }
/* 42:40 */     if (guibutton.id == 0)
/* 43:   */     {
/* 44:41 */       mod_RadarBro.RadarAutoRotate = !mod_RadarBro.RadarAutoRotate;
/* 45:42 */       ((GuiButton)this.buttonList.get(0)).displayString = ("Auto Rotate: " + (mod_RadarBro.RadarAutoRotate ? "ON" : "OFF"));
/* 46:   */     }
/* 47:44 */     if (guibutton.id == 1)
/* 48:   */     {
/* 49:46 */       mod_RadarBro.RadarCoordinates = !mod_RadarBro.RadarCoordinates;
/* 50:47 */       ((GuiButton)this.buttonList.get(1)).displayString = ("Coordinates: " + (mod_RadarBro.RadarCoordinates ? "ON" : "OFF"));
/* 51:   */     }
/* 52:49 */     if (guibutton.id == 2)
/* 53:   */     {
/* 54:51 */       mod_RadarBro.RadarTerrain = !mod_RadarBro.RadarTerrain;
/* 55:52 */       ((GuiButton)this.buttonList.get(2)).displayString = ("Terrain: " + (mod_RadarBro.RadarTerrain ? "ON" : "OFF"));
/* 56:   */     }
/* 57:54 */     if (guibutton.id == 3) {
/* 58:56 */       this.mc.displayGuiScreen(new GuiRepositionRadarBro(this.mc));
/* 59:   */     }
/* 60:58 */     if (guibutton.id == 4) {
/* 61:60 */       this.mc.displayGuiScreen(this.parentScreen);
/* 62:   */     }
/* 63:   */   }
/* 64:   */   
/* 65:   */   protected void mouseClicked(int i, int j, int k)
/* 66:   */   {
/* 67:66 */     super.mouseClicked(i, j, k);
/* 68:   */   }
/* 69:   */   
/* 70:   */   public void drawScreen(int i, int j, float f)
/* 71:   */   {
/* 72:71 */     drawDefaultBackground();
/* 73:72 */     drawCenteredString(this.fontRendererObj, "RadarBro GUI Settings", this.width / 2, this.height / 4 - 60 + 20, 16777215);
/* 74:73 */     super.drawScreen(i, j, f);
/* 75:   */   }
/* 76:   */ }


/* Location:           C:\Users\Admin\Downloads\RadarBroDecompiled.jar
 * Qualified Name:     com.calialec.radarbro.GuiRadarBroGUISettings
 * JD-Core Version:    0.7.1
 */