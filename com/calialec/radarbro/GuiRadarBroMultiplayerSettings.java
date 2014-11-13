/*  1:   */ package com.calialec.radarbro;
/*  2:   */ 
/*  3:   */ import java.util.List;
/*  4:   */ import net.minecraft.client.Minecraft;
/*  5:   */ import net.minecraft.client.gui.GuiButton;
/*  6:   */ import net.minecraft.client.gui.GuiScreen;
/*  7:   */ import net.minecraft.util.StringTranslate;
/*  8:   */ import org.lwjgl.input.Keyboard;
/*  9:   */ 
/* 10:   */ public class GuiRadarBroMultiplayerSettings
/* 11:   */   extends GuiScreen
/* 12:   */ {
/* 13:   */   private GuiScreen parentScreen;
/* 14:   */   
/* 15:   */   public GuiRadarBroMultiplayerSettings(GuiScreen guiscreen)
/* 16:   */   {
/* 17:14 */     this.parentScreen = guiscreen;
/* 18:   */   }
/* 19:   */   
/* 20:   */   public void initGui()
/* 21:   */   {
/* 22:19 */     StringTranslate stringTranslate = new StringTranslate();
/* 23:20 */     Keyboard.enableRepeatEvents(true);
/* 24:21 */     this.buttonList.clear();
/* 25:22 */     this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 - 16, "Player Names: " + (mod_RadarBro.RadarPlayerNames ? "ON" : "OFF")));
/* 26:23 */     this.buttonList.add(new GuiButton(1, this.width / 2 - 100, this.height / 4 + 8, "Color Player Names: " + (mod_RadarBro.RadarColorPlayerNames ? "ON" : "OFF")));
/* 27:24 */     this.buttonList.add(new GuiButton(2, this.width / 2 - 100, this.height / 4 + 32, "Player Skin Texture: " + (mod_RadarBro.RadarUsePlayerSkinTexture ? "ON" : "OFF")));
/* 28:25 */     this.buttonList.add(new GuiButton(3, this.width / 2 - 100, this.height / 4 + 56, stringTranslate.translateKey("gui.done")));
/* 29:   */   }
/* 30:   */   
/* 31:   */   public void onGuiClosed()
/* 32:   */   {
/* 33:30 */     Keyboard.enableRepeatEvents(false);
/* 34:   */   }
/* 35:   */   
/* 36:   */   protected void actionPerformed(GuiButton guibutton)
/* 37:   */   {
/* 38:35 */     if (!guibutton.enabled) {
/* 39:37 */       return;
/* 40:   */     }
/* 41:39 */     if (guibutton.id == 0)
/* 42:   */     {
/* 43:40 */       mod_RadarBro.RadarPlayerNames = !mod_RadarBro.RadarPlayerNames;
/* 44:41 */       ((GuiButton)this.buttonList.get(0)).displayString = ("Player Names: " + (mod_RadarBro.RadarPlayerNames ? "ON" : "OFF"));
/* 45:   */     }
/* 46:43 */     if (guibutton.id == 1)
/* 47:   */     {
/* 48:45 */       mod_RadarBro.RadarColorPlayerNames = !mod_RadarBro.RadarColorPlayerNames;
/* 49:46 */       ((GuiButton)this.buttonList.get(1)).displayString = ("Color Player Names: " + (mod_RadarBro.RadarColorPlayerNames ? "ON" : "OFF"));
/* 50:   */     }
/* 51:48 */     if (guibutton.id == 2)
/* 52:   */     {
/* 53:50 */       mod_RadarBro.RadarUsePlayerSkinTexture = !mod_RadarBro.RadarUsePlayerSkinTexture;
/* 54:51 */       ((GuiButton)this.buttonList.get(2)).displayString = ("Player Skin Texture: " + (mod_RadarBro.RadarUsePlayerSkinTexture ? "ON" : "OFF"));
/* 55:   */     }
/* 56:53 */     if (guibutton.id == 3) {
/* 57:55 */       this.mc.displayGuiScreen(this.parentScreen);
/* 58:   */     }
/* 59:   */   }
/* 60:   */   
/* 61:   */   protected void mouseClicked(int i, int j, int k)
/* 62:   */   {
/* 63:61 */     super.mouseClicked(i, j, k);
/* 64:   */   }
/* 65:   */   
/* 66:   */   public void drawScreen(int i, int j, float f)
/* 67:   */   {
/* 68:66 */     drawDefaultBackground();
/* 69:67 */     drawCenteredString(this.fontRendererObj, "RadarBro Multiplayer Settings", this.width / 2, this.height / 4 - 60 + 20, 16777215);
/* 70:68 */     super.drawScreen(i, j, f);
/* 71:   */   }
/* 72:   */ }


/* Location:           C:\Users\Admin\Downloads\RadarBroDecompiled.jar
 * Qualified Name:     com.calialec.radarbro.GuiRadarBroMultiplayerSettings
 * JD-Core Version:    0.7.1
 */