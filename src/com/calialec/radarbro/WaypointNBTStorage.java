/*  1:   */ package com.calialec.radarbro;
/*  2:   */ 
/*  3:   */ import java.util.ArrayList;
/*  4:   */ import net.minecraft.nbt.NBTTagCompound;
/*  5:   */ 
/*  6:   */ public class WaypointNBTStorage
/*  7:   */ {
/*  8:   */   public String name;
/*  9:   */   public String coordinates;
/* 10:   */   public String enabled;
/* 11:   */   
/* 12:   */   public WaypointNBTStorage(String par1Str, String par2Str, String par3Str)
/* 13:   */   {
/* 14:13 */     this.name = par1Str;
/* 15:14 */     this.coordinates = par2Str;
/* 16:15 */     this.enabled = par3Str;
/* 17:   */   }
/* 18:   */   
/* 19:   */   public NBTTagCompound getCompoundTag()
/* 20:   */   {
/* 21:20 */     NBTTagCompound nbttagcompound = new NBTTagCompound();
/* 22:21 */     nbttagcompound.setString("name", this.name);
/* 23:22 */     nbttagcompound.setString("coordinates", this.coordinates);
/* 24:23 */     nbttagcompound.setString("enabled", this.enabled);
/* 25:24 */     return nbttagcompound;
/* 26:   */   }
/* 27:   */   
/* 28:   */   public static WaypointNBTStorage createWaypointNBTStorage(NBTTagCompound par0NBTTagCompound)
/* 29:   */   {
/* 30:29 */     if (!mod_RadarBro.Waypoints.contains(par0NBTTagCompound.getString("coordinates") + "," + par0NBTTagCompound.getString("name") + "," + par0NBTTagCompound.getString("enabled"))) {
/* 31:30 */       mod_RadarBro.Waypoints.add(par0NBTTagCompound.getString("coordinates") + "," + par0NBTTagCompound.getString("name") + "," + par0NBTTagCompound.getString("enabled"));
/* 32:   */     }
/* 33:32 */     return new WaypointNBTStorage(par0NBTTagCompound.getString("name"), par0NBTTagCompound.getString("coordinates"), par0NBTTagCompound.getString("enabled"));
/* 34:   */   }
/* 35:   */ }


/* Location:           C:\Users\Admin\Downloads\RadarBroDecompiled.jar
 * Qualified Name:     com.calialec.radarbro.WaypointNBTStorage
 * JD-Core Version:    0.7.1
 */