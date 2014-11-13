/*  1:   */ package com.calialec.radarbro;
/*  2:   */ 
/*  3:   */ import java.util.List;
/*  4:   */ import net.minecraft.client.Minecraft;
/*  5:   */ import net.minecraft.client.entity.EntityClientPlayerMP;
/*  6:   */ import net.minecraft.client.gui.GuiScreen;
/*  7:   */ import net.minecraft.client.gui.GuiSlot;
/*  8:   */ import net.minecraft.client.renderer.Tessellator;
/*  9:   */ import org.lwjgl.opengl.GL11;
/* 10:   */ 
/* 11:   */ public class GuiSlotWaypoint
/* 12:   */   extends GuiSlot
/* 13:   */ {
/* 14:   */   final GuiWaypointManager parentGui;
/* 15:   */   
/* 16:   */   public GuiSlotWaypoint(GuiWaypointManager par1GuiMultiplayer)
/* 17:   */   {
/* 18:15 */     super(par1GuiMultiplayer.mc, par1GuiMultiplayer.width, par1GuiMultiplayer.height, 32, par1GuiMultiplayer.height - 64, 36);
/* 19:16 */     this.parentGui = par1GuiMultiplayer;
/* 20:   */   }
/* 21:   */   
/* 22:   */   protected int getSize()
/* 23:   */   {
/* 24:21 */     return GuiWaypointManager.getWaypointList(this.parentGui).size();
/* 25:   */   }
/* 26:   */   
/* 27:   */   protected boolean isSelected(int par1)
/* 28:   */   {
/* 29:26 */     return par1 == GuiWaypointManager.getSelectedWaypoint(this.parentGui);
/* 30:   */   }
/* 31:   */   
/* 32:   */   protected int func_148138_e()
/* 33:   */   {
/* 34:31 */     return GuiWaypointManager.getWaypointList(this.parentGui).size() * 36;
/* 35:   */   }
/* 36:   */   
/* 37:   */   protected void drawBackground()
/* 38:   */   {
/* 39:36 */     this.parentGui.drawDefaultBackground();
/* 40:   */   }
/* 41:   */   
/* 42:   */   protected void drawSlot(int var1, int var2, int var3, int var4, Tessellator var5, int var6, int var7)
/* 43:   */   {
/* 44:42 */     WaypointNBTStorage waypointnbtstorage = (WaypointNBTStorage)GuiWaypointManager.getWaypointList(this.parentGui).get(var1);
/* 45:   */     String enabledState;
/* 47:46 */     if (waypointnbtstorage.enabled.equals("true")) {
/* 48:47 */       enabledState = "§2Enabled";
/* 49:   */     } else {
/* 50:49 */       enabledState = "§4Disabled";
/* 51:   */     }
/* 52:52 */     String[] coords = waypointnbtstorage.coordinates.split(",");
/* 53:   */     
/* 54:54 */     int distance = (int)this.parentGui.mc.thePlayer.getDistance(Double.parseDouble(coords[0]), Double.parseDouble(coords[1]), Double.parseDouble(coords[2]));
/* 55:   */     
/* 56:56 */     this.parentGui.drawString(this.parentGui.mc.fontRenderer, waypointnbtstorage.name, var2 + 2, var3 + 1, 16777215);
/* 57:57 */     this.parentGui.drawString(this.parentGui.mc.fontRenderer, enabledState, var2 + 2, var3 + 12, 8421504);
/* 58:58 */     this.parentGui.drawString(this.parentGui.mc.fontRenderer, distance + " blocks away", var2 + 100, var3 + 12, 8421504);
/* 59:59 */     this.parentGui.drawString(this.parentGui.mc.fontRenderer, "(" + waypointnbtstorage.coordinates + ")", var2 + 2, var3 + 12 + 11, 3158064);
/* 60:60 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 61:   */     
/* 62:62 */     int i = 0;
/* 63:63 */     int j = 0;
/* 64:64 */     String s = "";
/* 65:   */     
/* 66:66 */     byte byte0 = 4;
/* 67:68 */     if ((this.mouseX >= var2 + 100 - byte0) && (this.mouseY >= var3 + 8) && (this.mouseX <= var2 + 160 + 10 + byte0) && (this.mouseY <= var3 + 16 + byte0)) {
/* 68:70 */       GuiWaypointManager.setTooltipText(this.parentGui, "(~" + Math.round(distance / 4.3D) + " seconds of walking)");
/* 69:   */     }
/* 70:   */   }
/* 71:   */   
/* 72:   */   protected void elementClicked(int var1, boolean var2, int var3, int var4)
/* 73:   */   {
/* 74:76 */     GuiWaypointManager.setSelectedWaypoint(this.parentGui, var1);
/* 75:77 */     boolean flag = (GuiWaypointManager.getSelectedWaypoint(this.parentGui) >= 0) && (GuiWaypointManager.getSelectedWaypoint(this.parentGui) < getSize());
/* 76:78 */     GuiWaypointManager.getButtonEdit(this.parentGui).enabled = flag;
/* 77:79 */     GuiWaypointManager.getButtonToggle(this.parentGui).enabled = flag;
/* 78:80 */     GuiWaypointManager.getButtonDelete(this.parentGui).enabled = flag;
/* 79:82 */     if ((var2) && (flag)) {
/* 80:84 */       this.parentGui.updateToggledState(true);
/* 81:   */     } else {
/* 82:86 */       this.parentGui.updateToggledState(false);
/* 83:   */     }
/* 84:   */   }
/* 85:   */ }


/* Location:           C:\Users\Admin\Downloads\RadarBroDecompiled.jar
 * Qualified Name:     com.calialec.radarbro.GuiSlotWaypoint
 * JD-Core Version:    0.7.1
 */