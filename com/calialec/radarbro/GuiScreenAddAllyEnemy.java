/*   1:    */ package com.calialec.radarbro;
/*   2:    */ 
/*   3:    */ import java.util.ArrayList;
/*   4:    */ import java.util.List;
/*   5:    */ import net.minecraft.client.Minecraft;
/*   6:    */ import net.minecraft.client.gui.GuiButton;
/*   7:    */ import net.minecraft.client.gui.GuiScreen;
/*   8:    */ import net.minecraft.client.gui.GuiTextField;
/*   9:    */ import net.minecraft.util.StringTranslate;
/*  10:    */ import org.lwjgl.input.Keyboard;
/*  11:    */ 
/*  12:    */ public class GuiScreenAddAllyEnemy
/*  13:    */   extends GuiScreen
/*  14:    */ {
/*  15:    */   private GuiScreen parentGui;
/*  16:    */   private GuiTextField playerUsername;
/*  17:    */   private int mode;
/*  18:    */   
/*  19:    */   public GuiScreenAddAllyEnemy(GuiScreen par1GuiScreen, int mode)
/*  20:    */   {
/*  21: 18 */     this.parentGui = par1GuiScreen;
/*  22: 19 */     this.mode = mode;
/*  23:    */   }
/*  24:    */   
/*  25:    */   public void updateScreen()
/*  26:    */   {
/*  27: 23 */     this.playerUsername.updateCursorCounter();
/*  28:    */   }
/*  29:    */   
/*  30:    */   public void initGui()
/*  31:    */   {
/*  32: 28 */     StringTranslate stringTranslate = new StringTranslate();
/*  33: 29 */     Keyboard.enableRepeatEvents(true);
/*  34: 30 */     this.buttonList.clear();
/*  35: 31 */     this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 96 + 12, stringTranslate.translateKey("addServer.add")));
/*  36: 32 */     this.buttonList.add(new GuiButton(1, this.width / 2 - 100, this.height / 4 + 120 + 12, stringTranslate.translateKey("gui.cancel")));
/*  37: 33 */     this.playerUsername = new GuiTextField(this.fontRendererObj, this.width / 2 - 100, 76, 200, 20);
/*  38: 34 */     this.playerUsername.setFocused(true);
/*  39: 35 */     this.playerUsername.setText("");
/*  40: 36 */     this.playerUsername.setMaxStringLength(16);
/*  41: 37 */     ((GuiButton)this.buttonList.get(0)).enabled = (this.playerUsername.getText().length() > 0);
/*  42:    */   }
/*  43:    */   
/*  44:    */   public void onGuiClosed()
/*  45:    */   {
/*  46: 42 */     Keyboard.enableRepeatEvents(false);
/*  47:    */   }
/*  48:    */   
/*  49:    */   protected void actionPerformed(GuiButton par1GuiButton)
/*  50:    */   {
/*  51: 47 */     if (!par1GuiButton.enabled) {
/*  52: 49 */       return;
/*  53:    */     }
/*  54: 52 */     if (par1GuiButton.id == 1)
/*  55:    */     {
/*  56: 54 */       this.mc.displayGuiScreen(this.parentGui);
/*  57:    */     }
/*  58: 56 */     else if (par1GuiButton.id == 0)
/*  59:    */     {
/*  60: 58 */       String playerUsername = this.playerUsername.getText();
/*  61: 59 */       if (this.mode == 0)
/*  62:    */       {
/*  63: 60 */         if (!mod_RadarBro.AllyList.contains(playerUsername))
/*  64:    */         {
/*  65: 62 */           mod_RadarBro.AllyList.add(playerUsername);
/*  66: 63 */           mod_RadarBro.saveAllyList();
/*  67: 64 */           this.mc.displayGuiScreen(this.parentGui);
/*  68:    */         }
/*  69:    */       }
/*  70: 67 */       else if (!mod_RadarBro.EnemyList.contains(playerUsername))
/*  71:    */       {
/*  72: 69 */         mod_RadarBro.EnemyList.add(playerUsername);
/*  73: 70 */         mod_RadarBro.saveEnemyList();
/*  74: 71 */         this.mc.displayGuiScreen(this.parentGui);
/*  75:    */       }
/*  76:    */     }
/*  77:    */   }
/*  78:    */   
/*  79:    */   protected void keyTyped(char par1, int par2)
/*  80:    */   {
/*  81: 79 */     this.playerUsername.textboxKeyTyped(par1, par2);
/*  82: 81 */     if (par1 == '\t') {
/*  83: 83 */       if (this.playerUsername.isFocused()) {
/*  84: 85 */         this.playerUsername.setFocused(false);
/*  85:    */       } else {
/*  86: 89 */         this.playerUsername.setFocused(true);
/*  87:    */       }
/*  88:    */     }
/*  89: 93 */     if (par1 == '\r') {
/*  90: 95 */       actionPerformed((GuiButton)this.buttonList.get(0));
/*  91:    */     }
/*  92: 98 */     ((GuiButton)this.buttonList.get(0)).enabled = (this.playerUsername.getText().length() > 0);
/*  93:    */   }
/*  94:    */   
/*  95:    */   protected void mouseClicked(int par1, int par2, int par3)
/*  96:    */   {
/*  97:104 */     super.mouseClicked(par1, par2, par3);
/*  98:105 */     this.playerUsername.mouseClicked(par1, par2, par3);
/*  99:    */   }
/* 100:    */   
/* 101:    */   public void drawScreen(int par1, int par2, float par3)
/* 102:    */   {
/* 103:110 */     drawDefaultBackground();
/* 104:111 */     drawCenteredString(this.fontRendererObj, "Add RadarBro " + (this.mode == 0 ? "Ally" : "Enemy"), this.width / 2, this.height / 4 - 60 + 20, 16777215);
/* 105:112 */     drawString(this.fontRendererObj, "Player username", this.width / 2 - 100, 63, 10526880);
/* 106:113 */     this.playerUsername.drawTextBox();
/* 107:114 */     super.drawScreen(par1, par2, par3);
/* 108:    */   }
/* 109:    */ }


/* Location:           C:\Users\Admin\Downloads\RadarBroDecompiled.jar
 * Qualified Name:     com.calialec.radarbro.GuiScreenAddAllyEnemy
 * JD-Core Version:    0.7.1
 */