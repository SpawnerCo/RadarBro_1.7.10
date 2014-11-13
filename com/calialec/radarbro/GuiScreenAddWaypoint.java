/*   1:    */ package com.calialec.radarbro;
/*   2:    */ 
/*   3:    */ import java.util.List;
/*   4:    */ import net.minecraft.client.Minecraft;
/*   5:    */ import net.minecraft.client.gui.GuiButton;
/*   6:    */ import net.minecraft.client.gui.GuiScreen;
/*   7:    */ import net.minecraft.client.gui.GuiTextField;
/*   8:    */ import net.minecraft.entity.Entity;
/*   9:    */ import net.minecraft.util.StringTranslate;
/*  10:    */ import org.lwjgl.input.Keyboard;
/*  11:    */ 
/*  12:    */ public class GuiScreenAddWaypoint
/*  13:    */   extends GuiScreen
/*  14:    */ {
/*  15:    */   private GuiScreen parentGui;
/*  16:    */   private GuiTextField waypointX;
/*  17:    */   private GuiTextField waypointY;
/*  18:    */   private GuiTextField waypointZ;
/*  19:    */   private GuiTextField waypointName;
/*  20:    */   private WaypointNBTStorage waypointNBTStorage;
/*  21:    */   
/*  22:    */   public GuiScreenAddWaypoint(GuiScreen par1GuiScreen, WaypointNBTStorage par2ServerNBTStorage)
/*  23:    */   {
/*  24: 21 */     this.parentGui = par1GuiScreen;
/*  25: 22 */     this.waypointNBTStorage = par2ServerNBTStorage;
/*  26:    */   }
/*  27:    */   
/*  28:    */   public void updateScreen()
/*  29:    */   {
/*  30: 27 */     this.waypointName.updateCursorCounter();
/*  31: 28 */     this.waypointX.updateCursorCounter();
/*  32: 29 */     this.waypointY.updateCursorCounter();
/*  33: 30 */     this.waypointZ.updateCursorCounter();
/*  34:    */   }
/*  35:    */   
/*  36:    */   public void initGui()
/*  37:    */   {
/*  38: 35 */     StringTranslate stringTranslate = new StringTranslate();
/*  39: 36 */     Keyboard.enableRepeatEvents(true);
/*  40: 37 */     this.buttonList.clear();
/*  41: 38 */     this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 96 + 12, stringTranslate.translateKey("addServer.add")));
/*  42: 39 */     this.buttonList.add(new GuiButton(1, this.width / 2 - 100, this.height / 4 + 120 + 12, stringTranslate.translateKey("gui.cancel")));
/*  43: 40 */     this.waypointName = new GuiTextField(this.fontRendererObj, this.width / 2 - 100, 76, 200, 20);
/*  44: 41 */     this.waypointName.setFocused(true);
/*  45: 42 */     this.waypointName.setText(this.waypointNBTStorage.name);
/*  46: 43 */     this.waypointX = new GuiTextField(this.fontRendererObj, this.width / 2 - 100, 116, 60, 20);
/*  47: 44 */     this.waypointY = new GuiTextField(this.fontRendererObj, this.width / 2 - 30, 116, 60, 20);
/*  48: 45 */     this.waypointZ = new GuiTextField(this.fontRendererObj, this.width / 2 + 40, 116, 60, 20);
/*  49: 46 */     this.waypointX.setMaxStringLength(128);
/*  50: 47 */     this.waypointY.setMaxStringLength(128);
/*  51: 48 */     this.waypointZ.setMaxStringLength(128);
/*  52:    */     try
/*  53:    */     {
/*  54: 51 */       String[] coordinates = this.waypointNBTStorage.coordinates.split(",");
/*  55: 52 */       String xCoordinate = coordinates[0];
/*  56: 53 */       String yCoordinate = coordinates[1];
/*  57: 54 */       String zCoordinate = coordinates[2];
/*  58:    */       
/*  59: 56 */       this.waypointX.setText(xCoordinate);
/*  60: 57 */       this.waypointY.setText(yCoordinate);
/*  61: 58 */       this.waypointZ.setText(zCoordinate);
/*  62:    */     }
/*  63:    */     catch (ArrayIndexOutOfBoundsException e)
/*  64:    */     {
/*  65: 61 */       this.waypointX.setText(Double.toString((int)this.mc.thePlayer.posX));
/*  66: 62 */       this.waypointY.setText(Double.toString((int)this.mc.thePlayer.posY));
/*  67: 63 */       this.waypointZ.setText(Double.toString((int)this.mc.thePlayer.posZ));
/*  68:    */     }
/*  69: 66 */     ((GuiButton)this.buttonList.get(0)).enabled = ((this.waypointX.getText().length() > 0) && (this.waypointY.getText().length() > 0) && (this.waypointZ.getText().length() > 0) && (this.waypointName.getText().length() > 0));
/*  70:    */   }
/*  71:    */   
/*  72:    */   public void onGuiClosed()
/*  73:    */   {
/*  74: 71 */     Keyboard.enableRepeatEvents(false);
/*  75:    */   }
/*  76:    */   
/*  77:    */   protected void actionPerformed(GuiButton par1GuiButton)
/*  78:    */   {
/*  79: 76 */     if (!par1GuiButton.enabled) {
/*  80: 78 */       return;
/*  81:    */     }
/*  82: 81 */     if (par1GuiButton.id == 1)
/*  83:    */     {
/*  84: 83 */       this.parentGui.confirmClicked(false, 0);
/*  85:    */     }
/*  86: 85 */     else if (par1GuiButton.id == 0)
/*  87:    */     {
/*  88: 87 */       this.waypointNBTStorage.name = this.waypointName.getText();
/*  89: 88 */       this.waypointNBTStorage.coordinates = (this.waypointX.getText() + "," + this.waypointY.getText() + "," + this.waypointZ.getText());
/*  90: 89 */       this.parentGui.confirmClicked(true, 0);
/*  91:    */     }
/*  92:    */   }
/*  93:    */   
/*  94:    */   protected void keyTyped(char par1, int par2)
/*  95:    */   {
/*  96: 95 */     this.waypointName.textboxKeyTyped(par1, par2);
/*  97: 96 */     this.waypointX.textboxKeyTyped(par1, par2);
/*  98: 97 */     this.waypointY.textboxKeyTyped(par1, par2);
/*  99: 98 */     this.waypointZ.textboxKeyTyped(par1, par2);
/* 100:100 */     if (par1 == '\t') {
/* 101:102 */       if (this.waypointName.isFocused())
/* 102:    */       {
/* 103:104 */         this.waypointName.setFocused(false);
/* 104:105 */         this.waypointX.setFocused(true);
/* 105:106 */         this.waypointY.setFocused(true);
/* 106:107 */         this.waypointZ.setFocused(true);
/* 107:    */       }
/* 108:    */       else
/* 109:    */       {
/* 110:111 */         this.waypointName.setFocused(true);
/* 111:112 */         this.waypointX.setFocused(false);
/* 112:113 */         this.waypointY.setFocused(false);
/* 113:114 */         this.waypointZ.setFocused(false);
/* 114:    */       }
/* 115:    */     }
/* 116:118 */     if (par1 == '\r') {
/* 117:120 */       actionPerformed((GuiButton)this.buttonList.get(0));
/* 118:    */     }
/* 119:123 */     ((GuiButton)this.buttonList.get(0)).enabled = ((this.waypointX.getText().length() > 0) && (this.waypointY.getText().length() > 0) && (this.waypointZ.getText().length() > 0) && (this.waypointName.getText().length() > 0));
/* 120:125 */     if (((GuiButton)this.buttonList.get(0)).enabled)
/* 121:    */     {
/* 122:127 */       String s = this.waypointX.getText().trim();
/* 123:128 */       String[] as = s.split(":");
/* 124:130 */       if (as.length > 2) {
/* 125:132 */         ((GuiButton)this.buttonList.get(0)).enabled = false;
/* 126:    */       }
/* 127:    */     }
/* 128:    */   }
/* 129:    */   
/* 130:    */   protected void mouseClicked(int par1, int par2, int par3)
/* 131:    */   {
/* 132:139 */     super.mouseClicked(par1, par2, par3);
/* 133:140 */     this.waypointX.mouseClicked(par1, par2, par3);
/* 134:141 */     this.waypointY.mouseClicked(par1, par2, par3);
/* 135:142 */     this.waypointZ.mouseClicked(par1, par2, par3);
/* 136:143 */     this.waypointName.mouseClicked(par1, par2, par3);
/* 137:    */   }
/* 138:    */   
/* 139:    */   public void drawScreen(int par1, int par2, float par3)
/* 140:    */   {
/* 141:148 */     drawDefaultBackground();
/* 142:149 */     drawCenteredString(this.fontRendererObj, "Edit Waypoint Info", this.width / 2, this.height / 4 - 60 + 20, 16777215);
/* 143:150 */     drawString(this.fontRendererObj, "Waypoint Name", this.width / 2 - 100, 63, 10526880);
/* 144:151 */     drawString(this.fontRendererObj, "Waypoint Coordinates", this.width / 2 - 100, 104, 10526880);
/* 145:152 */     this.waypointName.drawTextBox();
/* 146:153 */     this.waypointX.drawTextBox();
/* 147:154 */     this.waypointY.drawTextBox();
/* 148:155 */     this.waypointZ.drawTextBox();
/* 149:156 */     super.drawScreen(par1, par2, par3);
/* 150:    */   }
/* 151:    */ }


/* Location:           C:\Users\Admin\Downloads\RadarBroDecompiled.jar
 * Qualified Name:     com.calialec.radarbro.GuiScreenAddWaypoint
 * JD-Core Version:    0.7.1
 */