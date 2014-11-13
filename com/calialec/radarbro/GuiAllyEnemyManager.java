/*   1:    */ package com.calialec.radarbro;
/*   2:    */ 
/*   3:    */ import java.util.ArrayList;
/*   4:    */ import java.util.List;
/*   5:    */ import net.minecraft.client.Minecraft;
/*   6:    */ import net.minecraft.client.gui.GuiButton;
/*   7:    */ import net.minecraft.client.gui.GuiScreen;
/*   8:    */ import net.minecraft.util.StringTranslate;
/*   9:    */ 
/*  10:    */ public class GuiAllyEnemyManager
/*  11:    */   extends GuiScreen
/*  12:    */ {
/*  13:    */   protected GuiScreen parentGui;
/*  14:    */   private int selectedUsernameIndex;
/*  15:    */   public static List currentList;
/*  16:    */   public static int currentListType;
/*  17:    */   private GuiButton buttonAdd;
/*  18:    */   private GuiButton buttonDelete;
/*  19:    */   private GuiButton buttonAllyList;
/*  20:    */   private GuiButton buttonEnemyList;
/*  21:    */   private GuiSlotAllyEnemy allyEnemyList;
/*  22:    */   
/*  23:    */   public GuiAllyEnemyManager(GuiScreen par1GuiScreen)
/*  24:    */   {
/*  25: 24 */     this.parentGui = par1GuiScreen;
/*  26: 25 */     currentList = new ArrayList();
/*  27: 26 */     this.selectedUsernameIndex = -1;
/*  28: 27 */     currentListType = 0;
/*  29:    */   }
/*  30:    */   
/*  31:    */   public void initGui()
/*  32:    */   {
/*  33: 32 */     StringTranslate stringTranslate = new StringTranslate();
/*  34: 33 */     this.buttonList.add(this.buttonAdd = new GuiButton(0, this.width / 2 - 154, this.height - 28, 100, 20, "Add Ally"));
/*  35: 34 */     this.buttonList.add(this.buttonDelete = new GuiButton(1, this.width / 2 - 50, this.height - 28, 100, 20, "Delete Ally"));
/*  36: 35 */     this.buttonList.add(this.buttonAllyList = new GuiButton(2, this.width / 2 - 154, this.height - 52, 155, 20, "Ally List"));
/*  37: 36 */     this.buttonList.add(this.buttonEnemyList = new GuiButton(3, this.width / 2 + 4, this.height - 52, 150, 20, "Enemy List"));
/*  38: 37 */     this.buttonList.add(new GuiButton(4, this.width / 2 + 4 + 50, this.height - 28, 100, 20, stringTranslate.translateKey("Done")));
/*  39: 38 */     boolean flag = (this.selectedUsernameIndex >= 0) && (this.selectedUsernameIndex < this.allyEnemyList.getSize());
/*  40: 39 */     this.buttonDelete.enabled = flag;
/*  41: 40 */     this.buttonAllyList.enabled = false;
/*  42: 41 */     this.allyEnemyList = new GuiSlotAllyEnemy(this);
/*  43: 42 */     //this.allyEnemyList.func_148134_d(7, 8);
/*  44: 43 */     currentList.clear();
/*  45: 44 */     currentListType = 0;
/*  46: 45 */     mod_RadarBro.AllyList.clear();
/*  47: 46 */     mod_RadarBro.EnemyList.clear();
/*  48: 47 */     mod_RadarBro.loadAllyList();
/*  49:    */   }
/*  50:    */   
/*  51:    */   protected void actionPerformed(GuiButton par1GuiButton)
/*  52:    */   {
/*  53: 52 */     if (par1GuiButton.enabled) {
/*  54: 54 */       switch (par1GuiButton.id)
/*  55:    */       {
/*  56:    */       case 0: 
/*  57: 57 */         this.mc.displayGuiScreen(new GuiScreenAddAllyEnemy(this, currentListType == 0 ? 0 : 1));
/*  58: 58 */         break;
/*  59:    */       case 1: 
/*  60: 61 */         String playerUsername = (String)currentList.get(getSelectedUsername(this));
/*  61: 62 */         if (currentListType == 0)
/*  62:    */         {
/*  63: 63 */           if (mod_RadarBro.AllyList.contains(playerUsername))
/*  64:    */           {
/*  65: 65 */             mod_RadarBro.AllyList.remove(playerUsername);
/*  66: 66 */             mod_RadarBro.saveAllyList();
/*  67: 67 */             currentList.remove(playerUsername);
/*  68:    */           }
/*  69:    */         }
/*  70: 70 */         else if (mod_RadarBro.EnemyList.contains(playerUsername))
/*  71:    */         {
/*  72: 72 */           mod_RadarBro.EnemyList.remove(playerUsername);
/*  73: 73 */           mod_RadarBro.saveEnemyList();
/*  74: 74 */           currentList.remove(playerUsername);
/*  75:    */         }
/*  76: 77 */         this.buttonDelete.enabled = ((this.selectedUsernameIndex >= 0) && (this.selectedUsernameIndex < this.allyEnemyList.getSize()));
/*  77: 78 */         break;
/*  78:    */       case 2: 
/*  79: 81 */         currentListType = 0;
/*  80: 82 */         this.buttonAllyList.enabled = false;
/*  81: 83 */         this.buttonEnemyList.enabled = true;
/*  82: 84 */         this.buttonAdd.displayString = "Add Ally";
/*  83: 85 */         this.buttonDelete.displayString = "Delete Ally";
/*  84: 86 */         currentList.clear();
/*  85: 87 */         this.buttonDelete.enabled = ((this.selectedUsernameIndex >= 0) && (this.selectedUsernameIndex < this.allyEnemyList.getSize()));
/*  86: 88 */         mod_RadarBro.loadAllyList();
/*  87: 89 */         break;
/*  88:    */       case 3: 
/*  89: 92 */         currentListType = 1;
/*  90: 93 */         this.buttonEnemyList.enabled = false;
/*  91: 94 */         this.buttonAllyList.enabled = true;
/*  92: 95 */         this.buttonAdd.displayString = "Add Enemy";
/*  93: 96 */         this.buttonDelete.displayString = "Delete Enemy";
/*  94: 97 */         currentList.clear();
/*  95: 98 */         this.buttonDelete.enabled = ((this.selectedUsernameIndex >= 0) && (this.selectedUsernameIndex < this.allyEnemyList.getSize()));
/*  96: 99 */         mod_RadarBro.loadEnemyList();
/*  97:100 */         break;
/*  98:    */       case 4: 
/*  99:103 */         this.mc.displayGuiScreen(this.parentGui);
/* 100:104 */         mod_RadarBro.loadAllyList();
/* 101:105 */         mod_RadarBro.loadEnemyList();
/* 102:106 */         break;
/* 103:    */       default: 
/* 104:109 */         this.allyEnemyList.actionPerformed(par1GuiButton);
/* 105:    */       }
/* 106:    */     }
/* 107:    */   }
/* 108:    */   
/* 109:    */   public void drawScreen(int par1, int par2, float par3)
/* 110:    */   {
/* 111:116 */     this.allyEnemyList.drawScreen(par1, par2, par3);
/* 112:117 */     drawCenteredString(this.fontRendererObj, currentListType == 0 ? "Ally Manager" : "Enemy Manager", this.width / 2, 16, 16777215);
/* 113:118 */     super.drawScreen(par1, par2, par3);
/* 114:    */   }
/* 115:    */   
/* 116:    */   public void updateScreen()
/* 117:    */   {
/* 118:123 */     super.updateScreen();
/* 119:    */   }
/* 120:    */   
/* 121:    */   static int setSelectedUsername(GuiAllyEnemyManager par0GuiAllyEnemyManager, int par1)
/* 122:    */   {
/* 123:128 */     return par0GuiAllyEnemyManager.selectedUsernameIndex = par1;
/* 124:    */   }
/* 125:    */   
/* 126:    */   static int getSelectedUsername(GuiAllyEnemyManager par0GuiAllyEnemyManager)
/* 127:    */   {
/* 128:133 */     return par0GuiAllyEnemyManager.selectedUsernameIndex;
/* 129:    */   }
/* 130:    */   
/* 131:    */   static List getAllyList(GuiAllyEnemyManager par0GuiAllyEnemyManager)
/* 132:    */   {
/* 133:138 */     return currentList;
/* 134:    */   }
/* 135:    */   
/* 136:    */   static GuiButton getButtonDelete(GuiAllyEnemyManager par0GuiAllyEnemyManager)
/* 137:    */   {
/* 138:143 */     return par0GuiAllyEnemyManager.buttonDelete;
/* 139:    */   }
/* 140:    */ }


/* Location:           C:\Users\Admin\Downloads\RadarBroDecompiled.jar
 * Qualified Name:     com.calialec.radarbro.GuiAllyEnemyManager
 * JD-Core Version:    0.7.1
 */