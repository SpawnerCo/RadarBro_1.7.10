/*   1:    */ package com.calialec.radarbro;
/*   2:    */ 
/*   3:    */ import java.io.File;
/*   4:    */ import java.util.ArrayList;
/*   5:    */ import java.util.List;

/*   6:    */ import net.minecraft.client.Minecraft;
/*   7:    */ import net.minecraft.client.gui.FontRenderer;
/*   8:    */ import net.minecraft.client.gui.GuiButton;
/*   9:    */ import net.minecraft.client.gui.GuiScreen;
/*  10:    */ import net.minecraft.client.gui.GuiYesNo;
import net.minecraft.client.gui.GuiYesNoCallback;
/*  11:    */ import net.minecraft.nbt.CompressedStreamTools;
/*  12:    */ import net.minecraft.nbt.NBTTagCompound;
/*  13:    */ import net.minecraft.nbt.NBTTagList;
/*  14:    */ import net.minecraft.util.StatCollector;
/*  15:    */ import net.minecraft.util.StringTranslate;

/*  16:    */ import org.lwjgl.input.Keyboard;
/*  17:    */ 
/*  18:    */ public class GuiWaypointManager
/*  19:    */   extends GuiScreen implements GuiYesNoCallback
/*  20:    */ {
/*  21:    */   private GuiScreen parentScreen;
/*  22:    */   private GuiSlotWaypoint waypointSlotContainer;
/*  23:    */   private List waypointList;
/*  24:    */   private int selectedWaypoint;
/*  25:    */   private GuiButton buttonEdit;
/*  26:    */   private GuiButton buttonDelete;
/*  27:    */   private GuiButton buttonToggle;
/*  28:    */   private boolean deleteClicked;
/*  29:    */   private boolean addClicked;
/*  30:    */   private boolean editClicked;
/*  31:    */   private String timeTooltip;
/*  32:    */   private WaypointNBTStorage tempWaypoint;
/*  33:    */   
/*  34:    */   public GuiWaypointManager(GuiScreen par1GuiScreen)
/*  35:    */   {
/*  36: 37 */     this.waypointList = new ArrayList();
/*  37: 38 */     this.selectedWaypoint = -1;
/*  38: 39 */     this.deleteClicked = false;
/*  39: 40 */     this.addClicked = false;
/*  40: 41 */     this.editClicked = false;
/*  41: 42 */     this.timeTooltip = null;
/*  42: 43 */     this.tempWaypoint = null;
/*  43: 44 */     this.parentScreen = par1GuiScreen;
/*  44:    */   }
/*  45:    */   
/*  46:    */   public void initGui()
/*  47:    */   {
/*  48: 49 */     loadWaypointList();
/*  49: 50 */     Keyboard.enableRepeatEvents(true);
/*  50: 51 */     this.buttonList.clear();
/*  51: 52 */     this.waypointSlotContainer = new GuiSlotWaypoint(this);
/*  52: 53 */     initGuiControls();
/*  53:    */   }
/*  54:    */   
/*  55:    */   public void loadWaypointList()
/*  56:    */   {
/*  57:    */     try
/*  58:    */     {
/*  59: 60 */       NBTTagCompound nbttagcompound = CompressedStreamTools.read(new File(mod_RadarBro.radarBroDir, "waypoints.dat"));
/*  60: 61 */       NBTTagList nbttaglist = nbttagcompound.getTagList("waypoints", 10);
/*  61: 62 */       this.waypointList.clear();
/*  62: 64 */       for (int i = 0; i < nbttaglist.tagCount(); i++) {
/*  63: 66 */         this.waypointList.add(WaypointNBTStorage.createWaypointNBTStorage(nbttaglist.getCompoundTagAt(i)));
/*  64:    */       }
/*  65:    */     }
/*  66:    */     catch (Exception exception)
/*  67:    */     {
/*  68: 71 */       exception.printStackTrace();
/*  69:    */     }
/*  70:    */   }
/*  71:    */   
/*  72:    */   private void saveWaypointList()
/*  73:    */   {
/*  74:    */     try
/*  75:    */     {
/*  76: 79 */       NBTTagList nbttaglist = new NBTTagList();
/*  77: 81 */       for (int i = 0; i < this.waypointList.size(); i++) {
/*  78: 83 */         nbttaglist.appendTag(((WaypointNBTStorage)this.waypointList.get(i)).getCompoundTag());
/*  79:    */       }
/*  80: 86 */       NBTTagCompound nbttagcompound = new NBTTagCompound();
/*  81: 87 */       nbttagcompound.setTag("waypoints", nbttaglist);
/*  82: 88 */       CompressedStreamTools.safeWrite(nbttagcompound, new File(mod_RadarBro.radarBroDir, "waypoints.dat"));
/*  83:    */     }
/*  84:    */     catch (Exception exception)
/*  85:    */     {
/*  86: 92 */       exception.printStackTrace();
/*  87:    */     }
/*  88:    */   }
/*  89:    */   
/*  90:    */   public void initGuiControls()
/*  91:    */   {
/*  92: 98 */     StringTranslate stringTranslate = new StringTranslate();
/*  93: 99 */     this.buttonList.add(this.buttonEdit = new GuiButton(7, this.width / 2 - 154, this.height - 28, 100, 20, stringTranslate.translateKey("selectServer.edit")));
/*  94:100 */     this.buttonList.add(this.buttonDelete = new GuiButton(2, this.width / 2 - 50, this.height - 28, 100, 20, stringTranslate.translateKey("selectServer.delete")));
/*  95:101 */     this.buttonList.add(this.buttonToggle = new GuiButton(4, this.width / 2 - 154, this.height - 52, 155, 20, "Toggle Waypoint"));
/*  96:102 */     this.buttonList.add(new GuiButton(3, this.width / 2 + 4, this.height - 52, 150, 20, "Add Waypoint"));
/*  97:103 */     this.buttonList.add(new GuiButton(0, this.width / 2 + 4 + 50, this.height - 28, 100, 20, stringTranslate.translateKey("gui.done")));
/*  98:104 */     boolean flag = (this.selectedWaypoint >= 0) && (this.selectedWaypoint < this.waypointSlotContainer.getSize());
/*  99:105 */     this.buttonToggle.enabled = flag;
/* 100:106 */     this.buttonEdit.enabled = flag;
/* 101:107 */     this.buttonDelete.enabled = flag;
/* 102:    */   }
/* 103:    */   
/* 104:    */   public void onGuiClosed()
/* 105:    */   {
/* 106:112 */     Keyboard.enableRepeatEvents(false);
/* 107:    */   }
/* 108:    */   
/* 109:    */   public void updateToggledState(boolean doubleClicked)
/* 110:    */   {
/* 111:117 */     if (doubleClicked)
/* 112:    */     {
/* 113:118 */       WaypointNBTStorage waypointnbtstorage = (WaypointNBTStorage)this.waypointList.get(this.selectedWaypoint);
/* 114:119 */       if (waypointnbtstorage.enabled.equals("true")) {
/* 115:120 */         waypointnbtstorage.enabled = "false";
/* 116:    */       } else {
/* 117:122 */         waypointnbtstorage.enabled = "true";
/* 118:    */       }
/* 119:124 */       ((GuiButton)this.buttonList.get(2)).displayString = (waypointnbtstorage.enabled.equals("true") ? "Disable Waypoint" : "Enable Waypoint");
/* 120:    */       
/* 121:126 */       saveWaypointList();
/* 122:127 */       mod_RadarBro.Waypoints.clear();
/* 123:128 */       loadWaypointList();
/* 124:    */     }
/* 125:    */     else
/* 126:    */     {
/* 127:131 */       WaypointNBTStorage waypointnbtstorage = (WaypointNBTStorage)this.waypointList.get(this.selectedWaypoint);
/* 128:132 */       ((GuiButton)this.buttonList.get(2)).displayString = (waypointnbtstorage.enabled.equals("true") ? "Disable Waypoint" : "Enable Waypoint");
/* 129:    */     }
/* 130:    */   }
/* 131:    */   
/* 132:    */   protected void actionPerformed(GuiButton par1GuiButton)
/* 133:    */   {
/* 134:138 */     if (!par1GuiButton.enabled) {
/* 135:140 */       return;
/* 136:    */     }
/* 137:143 */     if (par1GuiButton.id == 2)
/* 138:    */     {
/* 139:145 */       String s = ((WaypointNBTStorage)this.waypointList.get(this.selectedWaypoint)).name;
/* 140:147 */       if (s != null)
/* 141:    */       {
/* 142:149 */         StringTranslate stringTranslate = new StringTranslate();
/* 143:150 */         this.deleteClicked = true;
/* 144:151 */         String s1 = "Are you sure you want to remove this waypoint?";
/* 145:152 */         String s2 = "'" + s + "' " + stringTranslate.translateKey("selectServer.deleteWarning");
/* 146:153 */         String s3 = stringTranslate.translateKey("selectServer.deleteButton");
/* 147:154 */         String s4 = stringTranslate.translateKey("gui.cancel");
/* 148:155 */         GuiYesNo guiyesno = new GuiYesNo(this, s1, s2, s3, s4, this.selectedWaypoint);
/* 149:156 */         this.mc.displayGuiScreen(guiyesno);
/* 150:    */       }
/* 151:    */     }
/* 152:159 */     else if (par1GuiButton.id == 4)
/* 153:    */     {
/* 154:161 */       updateToggledState(true);
/* 155:162 */       saveWaypointList();
/* 156:163 */       mod_RadarBro.Waypoints.clear();
/* 157:164 */       loadWaypointList();
/* 158:    */     }
/* 159:166 */     else if (par1GuiButton.id == 3)
/* 160:    */     {
/* 161:168 */       this.addClicked = true;
/* 162:169 */       this.mc.displayGuiScreen(new GuiScreenAddWaypoint(this, this.tempWaypoint = new WaypointNBTStorage(StatCollector.translateToLocal("Waypoint"), "", "true")));
/* 163:    */     }
/* 164:171 */     else if (par1GuiButton.id == 7)
/* 165:    */     {
/* 166:173 */       this.editClicked = true;
/* 167:174 */       WaypointNBTStorage waypointnbtstorage = (WaypointNBTStorage)this.waypointList.get(this.selectedWaypoint);
/* 168:175 */       this.mc.displayGuiScreen(new GuiScreenAddWaypoint(this, this.tempWaypoint = new WaypointNBTStorage(waypointnbtstorage.name, waypointnbtstorage.coordinates, waypointnbtstorage.enabled)));
/* 169:    */     }
/* 170:177 */     else if (par1GuiButton.id == 0)
/* 171:    */     {
/* 172:179 */       this.mc.displayGuiScreen(this.parentScreen);
/* 173:    */     }
/* 174:    */     else
/* 175:    */     {
/* 176:183 */       this.waypointSlotContainer.actionPerformed(par1GuiButton);
/* 177:    */     }
/* 178:    */   }
/* 179:    */   
/* 180:    */   public void confirmClicked(boolean par1, int par2)
/* 181:    */   {
/* 182:189 */     if (this.deleteClicked)
/* 183:    */     {
/* 184:191 */       this.deleteClicked = false;
/* 185:193 */       if (par1)
/* 186:    */       {
/* 187:195 */         this.waypointList.remove(par2);
/* 188:196 */         saveWaypointList();
/* 189:197 */         mod_RadarBro.Waypoints.clear();
/* 190:198 */         loadWaypointList();
/* 191:    */       }
/* 192:201 */       this.mc.displayGuiScreen(this);
/* 193:    */     }
/* 194:203 */     else if (this.addClicked)
/* 195:    */     {
/* 196:205 */       this.addClicked = false;
/* 197:207 */       if (par1)
/* 198:    */       {
/* 199:209 */         this.waypointList.add(this.tempWaypoint);
/* 200:210 */         saveWaypointList();
/* 201:    */       }
/* 202:213 */       this.mc.displayGuiScreen(this);
/* 203:    */     }
/* 204:215 */     else if (this.editClicked)
/* 205:    */     {
/* 206:217 */       this.editClicked = false;
/* 207:219 */       if (par1)
/* 208:    */       {
/* 209:221 */         WaypointNBTStorage waypointnbtstorage = (WaypointNBTStorage)this.waypointList.get(this.selectedWaypoint);
/* 210:222 */         waypointnbtstorage.name = this.tempWaypoint.name;
/* 211:223 */         waypointnbtstorage.coordinates = this.tempWaypoint.coordinates;
/* 212:224 */         saveWaypointList();
/* 213:225 */         mod_RadarBro.Waypoints.clear();
/* 214:226 */         loadWaypointList();
/* 215:    */       }
/* 216:229 */       this.mc.displayGuiScreen(this);
/* 217:    */     }
/* 218:    */   }
/* 219:    */   
/* 220:    */   protected void keyTyped(char par1, int par2)
/* 221:    */   {
/* 222:235 */     if (par1 == '\r') {
/* 223:237 */       actionPerformed((GuiButton)this.buttonList.get(2));
/* 224:    */     }
/* 225:    */   }
/* 226:    */   
/* 227:    */   protected void mouseClicked(int par1, int par2, int par3)
/* 228:    */   {
/* 229:243 */     super.mouseClicked(par1, par2, par3);
/* 230:    */   }
/* 231:    */   
/* 232:    */   public void drawScreen(int par1, int par2, float par3)
/* 233:    */   {
/* 234:248 */     this.timeTooltip = null;
/* 235:249 */     drawDefaultBackground();
/* 236:250 */     this.waypointSlotContainer.drawScreen(par1, par2, par3);
/* 237:251 */     drawCenteredString(this.fontRendererObj, "Waypoint Manager", this.width / 2, 20, 16777215);
/* 238:252 */     super.drawScreen(par1, par2, par3);
/* 239:254 */     if (this.timeTooltip != null) {
/* 240:256 */       func_35325_a(this.timeTooltip, par1, par2);
/* 241:    */     }
/* 242:    */   }
/* 243:    */   
/* 244:    */   protected void func_35325_a(String par1Str, int par2, int par3)
/* 245:    */   {
/* 246:262 */     if (par1Str == null) {
/* 247:264 */       return;
/* 248:    */     }
/* 249:268 */     int i = par2 + 12;
/* 250:269 */     int j = par3 - 12;
/* 251:270 */     int k = this.fontRendererObj.getStringWidth(par1Str);
/* 252:271 */     drawGradientRect(i - 3, j - 3, i + k + 3, j + 8 + 3, -1073741824, -1073741824);
/* 253:272 */     this.fontRendererObj.drawStringWithShadow(par1Str, i, j, -1);
/* 254:    */   }
/* 255:    */   
/* 256:    */   static List getWaypointList(GuiWaypointManager par0GuiMultiplayer)
/* 257:    */   {
/* 258:279 */     return par0GuiMultiplayer.waypointList;
/* 259:    */   }
/* 260:    */   
/* 261:    */   static int setSelectedWaypoint(GuiWaypointManager par0GuiMultiplayer, int par1)
/* 262:    */   {
/* 263:284 */     return par0GuiMultiplayer.selectedWaypoint = par1;
/* 264:    */   }
/* 265:    */   
/* 266:    */   static int getSelectedWaypoint(GuiWaypointManager par0GuiMultiplayer)
/* 267:    */   {
/* 268:289 */     return par0GuiMultiplayer.selectedWaypoint;
/* 269:    */   }
/* 270:    */   
/* 271:    */   static GuiButton getButtonEdit(GuiWaypointManager par0GuiMultiplayer)
/* 272:    */   {
/* 273:294 */     return par0GuiMultiplayer.buttonEdit;
/* 274:    */   }
/* 275:    */   
/* 276:    */   static GuiButton getButtonToggle(GuiWaypointManager par0GuiMultiplayer)
/* 277:    */   {
/* 278:299 */     return par0GuiMultiplayer.buttonToggle;
/* 279:    */   }
/* 280:    */   
/* 281:    */   static GuiButton getButtonDelete(GuiWaypointManager par0GuiMultiplayer)
/* 282:    */   {
/* 283:304 */     return par0GuiMultiplayer.buttonDelete;
/* 284:    */   }
/* 285:    */   
/* 286:    */   static String setTooltipText(GuiWaypointManager par0GuiMultiplayer, String par1Str)
/* 287:    */   {
/* 288:309 */     return par0GuiMultiplayer.timeTooltip = par1Str;
/* 289:    */   }
/* 290:    */ }


/* Location:           C:\Users\Admin\Downloads\RadarBroDecompiled.jar
 * Qualified Name:     com.calialec.radarbro.GuiWaypointManager
 * JD-Core Version:    0.7.1
 */