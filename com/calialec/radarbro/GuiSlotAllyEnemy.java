/*  1:   */ package com.calialec.radarbro;
/*  2:   */ 
/*  3:   */ import java.awt.image.BufferedImage;
/*  4:   */ import java.util.List;
/*  5:   */ import net.minecraft.client.Minecraft;
/*  6:   */ import net.minecraft.client.gui.GuiScreen;
/*  7:   */ import net.minecraft.client.gui.GuiSlot;
/*  8:   */ import net.minecraft.client.renderer.Tessellator;
/*  9:   */ import net.minecraft.client.renderer.texture.DynamicTexture;
/* 10:   */ import net.minecraft.client.renderer.texture.TextureManager;
/* 11:   */ import net.minecraft.util.ResourceLocation;
/* 12:   */ import org.lwjgl.opengl.GL11;
/* 13:   */ 
/* 14:   */ public class GuiSlotAllyEnemy
/* 15:   */   extends GuiSlot
/* 16:   */ {
/* 17:   */   final GuiAllyEnemyManager parentGui;
/* 18:   */   
/* 19:   */   public GuiSlotAllyEnemy(GuiAllyEnemyManager par1GuiAllyEnemyManager)
/* 20:   */   {
/* 21:19 */     super(par1GuiAllyEnemyManager.mc, par1GuiAllyEnemyManager.width, par1GuiAllyEnemyManager.height, 32, par1GuiAllyEnemyManager.height - 65 + 4, 18);
/* 22:20 */     this.parentGui = par1GuiAllyEnemyManager;
/* 23:   */   }
/* 24:   */   
/* 25:   */   protected int getSize()
/* 26:   */   {
/* 27:25 */     return GuiAllyEnemyManager.getAllyList(this.parentGui).size();
/* 28:   */   }
/* 29:   */   
/* 30:   */   protected boolean isSelected(int par1)
/* 31:   */   {
/* 32:30 */     return par1 == GuiAllyEnemyManager.getSelectedUsername(this.parentGui);
/* 33:   */   }
/* 34:   */   
/* 35:   */   protected int func_148138_e()
/* 36:   */   {
/* 37:35 */     return getSize() * 18;
/* 38:   */   }
/* 39:   */   
/* 40:   */   protected void drawBackground()
/* 41:   */   {
/* 42:40 */     this.parentGui.drawDefaultBackground();
/* 43:   */   }
/* 44:   */   
/* 45:   */   public void drawPlayerHeadImage(BufferedImage bi, int x, int y)
/* 46:   */   {
/* 47:44 */     DynamicTexture previewTexture = new DynamicTexture(bi);
/* 48:45 */     ResourceLocation resourceLocation = this.parentGui.mc.getTextureManager().getDynamicTextureLocation("preivew", previewTexture);
/* 49:46 */     this.parentGui.mc.getTextureManager().bindTexture(resourceLocation);
/* 50:47 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 51:48 */     GL11.glPushMatrix();
/* 52:49 */     this.parentGui.drawTexturedModalRect(x, y, 0, 0, 32, 32);
/* 53:50 */     GL11.glPopMatrix();
/* 54:   */   }
/* 55:   */   
/* 56:   */   protected void drawSlot(int var1, int var2, int var3, int var4, Tessellator var5, int var6, int var7)
/* 57:   */   {
/* 58:57 */     String playerUsername = (String)GuiAllyEnemyManager.getAllyList(this.parentGui).get(var1);
/* 59:58 */     this.parentGui.drawCenteredString(this.parentGui.mc.fontRenderer, "§c" + playerUsername, this.parentGui.width / 2, var3 + 1, 16777215);
/* 60:59 */     drawPlayerHeadImage(GuiRadarBro.generatePlayerHeadImage(playerUsername), this.parentGui.width / 2 - 60, var3 + 1);
/* 61:   */   }
/* 62:   */   
/* 63:   */   protected void elementClicked(int var1, boolean var2, int var3, int var4)
/* 64:   */   {
/* 65:64 */     GuiAllyEnemyManager.setSelectedUsername(this.parentGui, var1);
/* 66:65 */     boolean flag = (GuiAllyEnemyManager.getSelectedUsername(this.parentGui) >= 0) && (GuiAllyEnemyManager.getSelectedUsername(this.parentGui) < getSize());
/* 67:66 */     GuiAllyEnemyManager.getButtonDelete(this.parentGui).enabled = flag;
/* 68:   */   }
/* 69:   */ }


/* Location:           C:\Users\Admin\Downloads\RadarBroDecompiled.jar
 * Qualified Name:     com.calialec.radarbro.GuiSlotAllyEnemy
 * JD-Core Version:    0.7.1
 */