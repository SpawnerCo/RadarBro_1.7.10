/*   1:    */ package com.calialec.radarbro;
/*   2:    */ 
/*   3:    */ import java.util.List;
/*   4:    */ import net.minecraft.client.Minecraft;
/*   5:    */ import net.minecraft.client.gui.GuiButton;
/*   6:    */ import net.minecraft.client.gui.GuiScreen;
/*   7:    */ import net.minecraft.client.renderer.texture.TextureManager;
/*   8:    */ import net.minecraft.util.ResourceLocation;
/*   9:    */ import net.minecraft.util.StringTranslate;
/*  10:    */ import org.lwjgl.input.Keyboard;
/*  11:    */ import org.lwjgl.opengl.GL11;
/*  12:    */ 
/*  13:    */ public class GuiRadarBroIconSettings
/*  14:    */   extends GuiScreen
/*  15:    */ {
/*  16:    */   private GuiScreen parentScreen;
/*  17: 17 */   public static final ResourceLocation radaricons = new ResourceLocation("mod_RadarBro/textures/radaricons.png");
/*  18:    */   private TextureManager textureManager;
/*  19:    */   
/*  20:    */   public GuiRadarBroIconSettings(GuiScreen guiscreen)
/*  21:    */   {
/*  22: 22 */     this.parentScreen = guiscreen;
/*  23: 23 */     this.textureManager = mod_RadarBro.mc.getTextureManager();
/*  24:    */   }
/*  25:    */   
/*  26:    */   public void updateScreen() {}
/*  27:    */   
/*  28:    */   public void initGui()
/*  29:    */   {
/*  30: 32 */     StringTranslate stringTranslate = new StringTranslate();
/*  31: 33 */     Keyboard.enableRepeatEvents(true);
/*  32: 34 */     this.buttonList.clear();
/*  33:    */     
/*  34:    */ 
/*  35:    */ 
/*  36: 38 */     this.buttonList.add(new GuiButton(0, this.width / 2 - 130, this.height / 2 - 65, 22, 14, mod_RadarBro.RadarBat ? "On" : "Off"));
/*  37: 39 */     this.buttonList.add(new GuiButton(1, this.width / 2 - 130, this.height / 2 - 50, 22, 14, mod_RadarBro.RadarChicken ? "On" : "Off"));
/*  38: 40 */     this.buttonList.add(new GuiButton(2, this.width / 2 - 130, this.height / 2 - 35, 22, 14, mod_RadarBro.RadarCow ? "On" : "Off"));
/*  39: 41 */     this.buttonList.add(new GuiButton(3, this.width / 2 - 130, this.height / 2 - 20, 22, 14, mod_RadarBro.RadarMooshroom ? "On" : "Off"));
/*  40: 42 */     this.buttonList.add(new GuiButton(4, this.width / 2 - 130, this.height / 2 - 5, 22, 14, mod_RadarBro.RadarOcelot ? "On" : "Off"));
/*  41: 43 */     this.buttonList.add(new GuiButton(5, this.width / 2 - 130, this.height / 2 + 10, 22, 14, mod_RadarBro.RadarPig ? "On" : "Off"));
/*  42: 44 */     this.buttonList.add(new GuiButton(6, this.width / 2 - 130, this.height / 2 + 25, 22, 14, mod_RadarBro.RadarSheep ? "On" : "Off"));
/*  43: 45 */     this.buttonList.add(new GuiButton(7, this.width / 2 - 130, this.height / 2 + 40, 22, 14, mod_RadarBro.RadarSnowGolem ? "On" : "Off"));
/*  44: 46 */     this.buttonList.add(new GuiButton(8, this.width / 2 - 130, this.height / 2 + 55, 22, 14, mod_RadarBro.RadarSquid ? "On" : "Off"));
/*  45: 47 */     this.buttonList.add(new GuiButton(9, this.width / 2 - 130, this.height / 2 + 70, 22, 14, mod_RadarBro.RadarVillager ? "On" : "Off"));
/*  46:    */     
/*  47:    */ 
/*  48:    */ 
/*  49: 51 */     this.buttonList.add(new GuiButton(10, this.width / 2 - 17, this.height / 2 - 80, 22, 14, mod_RadarBro.RadarBlaze ? "On" : "Off"));
/*  50: 52 */     this.buttonList.add(new GuiButton(11, this.width / 2 - 17, this.height / 2 - 65, 22, 14, mod_RadarBro.RadarCaveSpider ? "On" : "Off"));
/*  51: 53 */     this.buttonList.add(new GuiButton(12, this.width / 2 - 17, this.height / 2 - 50, 22, 14, mod_RadarBro.RadarCreeper ? "On" : "Off"));
/*  52: 54 */     this.buttonList.add(new GuiButton(13, this.width / 2 - 17, this.height / 2 - 35, 22, 14, mod_RadarBro.RadarEnderdragon ? "On" : "Off"));
/*  53: 55 */     this.buttonList.add(new GuiButton(14, this.width / 2 - 17, this.height / 2 - 20, 22, 14, mod_RadarBro.RadarGhast ? "On" : "Off"));
/*  54: 56 */     this.buttonList.add(new GuiButton(15, this.width / 2 - 17, this.height / 2 - 5, 22, 14, mod_RadarBro.RadarMagmaCube ? "On" : "Off"));
/*  55: 57 */     this.buttonList.add(new GuiButton(16, this.width / 2 - 17, this.height / 2 + 10, 22, 14, mod_RadarBro.RadarSilverfish ? "On" : "Off"));
/*  56: 58 */     this.buttonList.add(new GuiButton(17, this.width / 2 - 17, this.height / 2 + 25, 22, 14, mod_RadarBro.RadarSkeleton ? "On" : "Off"));
/*  57: 59 */     this.buttonList.add(new GuiButton(18, this.width / 2 - 17, this.height / 2 + 40, 22, 14, mod_RadarBro.RadarSlime ? "On" : "Off"));
/*  58: 60 */     this.buttonList.add(new GuiButton(19, this.width / 2 - 17, this.height / 2 + 55, 22, 14, mod_RadarBro.RadarSpider ? "On" : "Off"));
/*  59: 61 */     this.buttonList.add(new GuiButton(20, this.width / 2 - 17, this.height / 2 + 70, 22, 14, mod_RadarBro.RadarZombie ? "On" : "Off"));
/*  60:    */     
/*  61: 63 */     this.buttonList.add(new GuiButton(21, this.width / 2 - 17, this.height / 2 + 85, 22, 14, mod_RadarBro.RadarZombie ? "On" : "Off"));
/*  62: 64 */     this.buttonList.add(new GuiButton(22, this.width / 2 - 17, this.height / 2 + 100, 22, 14, mod_RadarBro.RadarZombie ? "On" : "Off"));
/*  63:    */     
/*  64:    */ 
/*  65:    */ 
/*  66: 68 */     this.buttonList.add(new GuiButton(23, this.width / 2 + 95, this.height / 2 - 50, 22, 14, mod_RadarBro.RadarEnderman ? "On" : "Off"));
/*  67: 69 */     this.buttonList.add(new GuiButton(24, this.width / 2 + 95, this.height / 2 - 35, 22, 14, mod_RadarBro.RadarIronGolem ? "On" : "Off"));
/*  68: 70 */     this.buttonList.add(new GuiButton(25, this.width / 2 + 95, this.height / 2 - 20, 22, 14, mod_RadarBro.RadarWolf ? "On" : "Off"));
/*  69: 71 */     this.buttonList.add(new GuiButton(26, this.width / 2 + 95, this.height / 2 - 5, 22, 14, mod_RadarBro.RadarZombiePigman ? "On" : "Off"));
/*  70:    */     
/*  71:    */ 
/*  72:    */ 
/*  73: 75 */     this.buttonList.add(new GuiButton(27, this.width / 2 + 185, this.height / 2 - 50, 22, 14, mod_RadarBro.RadarArrow ? "On" : "Off"));
/*  74: 76 */     this.buttonList.add(new GuiButton(28, this.width / 2 + 185, this.height / 2 - 35, 22, 14, mod_RadarBro.RadarBoat ? "On" : "Off"));
/*  75: 77 */     this.buttonList.add(new GuiButton(29, this.width / 2 + 185, this.height / 2 - 20, 22, 14, mod_RadarBro.RadarChest ? "On" : "Off"));
/*  76: 78 */     this.buttonList.add(new GuiButton(30, this.width / 2 + 185, this.height / 2 - 5, 22, 14, mod_RadarBro.RadarItem ? "On" : "Off"));
/*  77: 79 */     this.buttonList.add(new GuiButton(31, this.width / 2 + 185, this.height / 2 + 10, 22, 14, mod_RadarBro.RadarMinecart ? "On" : "Off"));
/*  78: 80 */     this.buttonList.add(new GuiButton(32, this.width / 2 + 185, this.height / 2 + 25, 22, 14, mod_RadarBro.RadarPainting ? "On" : "Off"));
/*  79: 81 */     this.buttonList.add(new GuiButton(33, this.width / 2 + 185, this.height / 2 + 40, 22, 14, mod_RadarBro.RadarMonsterSpawner ? "On" : "Off"));
/*  80: 82 */     this.buttonList.add(new GuiButton(34, this.width / 2 + 185, this.height / 2 + 55, 22, 14, mod_RadarBro.RadarWaypoint ? "On" : "Off"));
/*  81: 83 */     this.buttonList.add(new GuiButton(35, this.width / 2 + 185, this.height / 2 + 70, 22, 14, mod_RadarBro.RadarXPOrb ? "On" : "Off"));
/*  82:    */     
/*  83:    */ 
/*  84:    */ 
/*  85: 87 */     this.buttonList.add(new GuiButton(36, this.width / 2 + 95, this.height / 2 + 55, 22, 14, mod_RadarBro.RadarPlayer ? "On" : "Off"));
/*  86: 88 */     this.buttonList.add(new GuiButton(37, this.width / 2 + 95, this.height / 2 + 70, 22, 14, mod_RadarBro.RadarAlly ? "On" : "Off"));
/*  87: 89 */     this.buttonList.add(new GuiButton(38, this.width / 2 + 95, this.height / 2 + 85, 22, 14, mod_RadarBro.RadarEnemy ? "On" : "Off"));
/*  88:    */     
/*  89:    */ 
/*  90:    */ 
/*  91: 93 */     this.buttonList.add(new GuiButton(39, this.width / 2 + 135, this.height / 2 + 90, 60, 20, stringTranslate.translateKey("gui.done")));
/*  92:    */   }
/*  93:    */   
/*  94:    */   public void onGuiClosed()
/*  95:    */   {
/*  96: 99 */     Keyboard.enableRepeatEvents(false);
/*  97:    */   }
/*  98:    */   
/*  99:    */   protected void actionPerformed(GuiButton guibutton)
/* 100:    */   {
/* 101:104 */     if (!guibutton.enabled) {
/* 102:106 */       return;
/* 103:    */     }
/* 104:108 */     if (guibutton.id == 0)
/* 105:    */     {
/* 106:110 */       mod_RadarBro.RadarBat = !mod_RadarBro.RadarBat;
/* 107:111 */       ((GuiButton)this.buttonList.get(0)).displayString = (mod_RadarBro.RadarBat ? "On" : "Off");
/* 108:    */     }
/* 109:113 */     if (guibutton.id == 1)
/* 110:    */     {
/* 111:115 */       mod_RadarBro.RadarChicken = !mod_RadarBro.RadarChicken;
/* 112:116 */       ((GuiButton)this.buttonList.get(1)).displayString = (mod_RadarBro.RadarChicken ? "On" : "Off");
/* 113:    */     }
/* 114:118 */     if (guibutton.id == 2)
/* 115:    */     {
/* 116:119 */       mod_RadarBro.RadarCow = !mod_RadarBro.RadarCow;
/* 117:120 */       ((GuiButton)this.buttonList.get(2)).displayString = (mod_RadarBro.RadarCow ? "On" : "Off");
/* 118:    */     }
/* 119:123 */     if (guibutton.id == 3)
/* 120:    */     {
/* 121:125 */       mod_RadarBro.RadarMooshroom = !mod_RadarBro.RadarMooshroom;
/* 122:126 */       ((GuiButton)this.buttonList.get(3)).displayString = (mod_RadarBro.RadarMooshroom ? "On" : "Off");
/* 123:    */     }
/* 124:128 */     if (guibutton.id == 4)
/* 125:    */     {
/* 126:130 */       mod_RadarBro.RadarOcelot = !mod_RadarBro.RadarOcelot;
/* 127:131 */       ((GuiButton)this.buttonList.get(4)).displayString = (mod_RadarBro.RadarOcelot ? "On" : "Off");
/* 128:    */     }
/* 129:133 */     if (guibutton.id == 5)
/* 130:    */     {
/* 131:135 */       mod_RadarBro.RadarPig = !mod_RadarBro.RadarPig;
/* 132:136 */       ((GuiButton)this.buttonList.get(5)).displayString = (mod_RadarBro.RadarPig ? "On" : "Off");
/* 133:    */     }
/* 134:138 */     if (guibutton.id == 6)
/* 135:    */     {
/* 136:140 */       mod_RadarBro.RadarSheep = !mod_RadarBro.RadarSheep;
/* 137:141 */       ((GuiButton)this.buttonList.get(6)).displayString = (mod_RadarBro.RadarSheep ? "On" : "Off");
/* 138:    */     }
/* 139:143 */     if (guibutton.id == 7)
/* 140:    */     {
/* 141:145 */       mod_RadarBro.RadarSnowGolem = !mod_RadarBro.RadarSnowGolem;
/* 142:146 */       ((GuiButton)this.buttonList.get(7)).displayString = (mod_RadarBro.RadarSnowGolem ? "On" : "Off");
/* 143:    */     }
/* 144:148 */     if (guibutton.id == 8)
/* 145:    */     {
/* 146:150 */       mod_RadarBro.RadarSquid = !mod_RadarBro.RadarSquid;
/* 147:151 */       ((GuiButton)this.buttonList.get(8)).displayString = (mod_RadarBro.RadarSquid ? "On" : "Off");
/* 148:    */     }
/* 149:153 */     if (guibutton.id == 9)
/* 150:    */     {
/* 151:155 */       mod_RadarBro.RadarVillager = !mod_RadarBro.RadarVillager;
/* 152:156 */       ((GuiButton)this.buttonList.get(9)).displayString = (mod_RadarBro.RadarVillager ? "On" : "Off");
/* 153:    */     }
/* 154:159 */     if (guibutton.id == 10)
/* 155:    */     {
/* 156:161 */       mod_RadarBro.RadarBlaze = !mod_RadarBro.RadarBlaze;
/* 157:162 */       ((GuiButton)this.buttonList.get(10)).displayString = (mod_RadarBro.RadarBlaze ? "On" : "Off");
/* 158:    */     }
/* 159:164 */     if (guibutton.id == 11)
/* 160:    */     {
/* 161:166 */       mod_RadarBro.RadarCaveSpider = !mod_RadarBro.RadarCaveSpider;
/* 162:167 */       ((GuiButton)this.buttonList.get(11)).displayString = (mod_RadarBro.RadarCaveSpider ? "On" : "Off");
/* 163:    */     }
/* 164:169 */     if (guibutton.id == 12)
/* 165:    */     {
/* 166:171 */       mod_RadarBro.RadarCreeper = !mod_RadarBro.RadarCreeper;
/* 167:172 */       ((GuiButton)this.buttonList.get(12)).displayString = (mod_RadarBro.RadarCreeper ? "On" : "Off");
/* 168:    */     }
/* 169:174 */     if (guibutton.id == 13)
/* 170:    */     {
/* 171:176 */       mod_RadarBro.RadarEnderdragon = !mod_RadarBro.RadarEnderdragon;
/* 172:177 */       ((GuiButton)this.buttonList.get(13)).displayString = (mod_RadarBro.RadarEnderdragon ? "On" : "Off");
/* 173:    */     }
/* 174:179 */     if (guibutton.id == 14)
/* 175:    */     {
/* 176:181 */       mod_RadarBro.RadarGhast = !mod_RadarBro.RadarGhast;
/* 177:182 */       ((GuiButton)this.buttonList.get(14)).displayString = (mod_RadarBro.RadarGhast ? "On" : "Off");
/* 178:    */     }
/* 179:184 */     if (guibutton.id == 15)
/* 180:    */     {
/* 181:186 */       mod_RadarBro.RadarMagmaCube = !mod_RadarBro.RadarMagmaCube;
/* 182:187 */       ((GuiButton)this.buttonList.get(15)).displayString = (mod_RadarBro.RadarMagmaCube ? "On" : "Off");
/* 183:    */     }
/* 184:189 */     if (guibutton.id == 16)
/* 185:    */     {
/* 186:191 */       mod_RadarBro.RadarSilverfish = !mod_RadarBro.RadarSilverfish;
/* 187:192 */       ((GuiButton)this.buttonList.get(16)).displayString = (mod_RadarBro.RadarSilverfish ? "On" : "Off");
/* 188:    */     }
/* 189:194 */     if (guibutton.id == 17)
/* 190:    */     {
/* 191:196 */       mod_RadarBro.RadarSkeleton = !mod_RadarBro.RadarSkeleton;
/* 192:197 */       ((GuiButton)this.buttonList.get(17)).displayString = (mod_RadarBro.RadarSkeleton ? "On" : "Off");
/* 193:    */     }
/* 194:199 */     if (guibutton.id == 18)
/* 195:    */     {
/* 196:201 */       mod_RadarBro.RadarSlime = !mod_RadarBro.RadarSlime;
/* 197:202 */       ((GuiButton)this.buttonList.get(18)).displayString = (mod_RadarBro.RadarSlime ? "On" : "Off");
/* 198:    */     }
/* 199:204 */     if (guibutton.id == 19)
/* 200:    */     {
/* 201:206 */       mod_RadarBro.RadarSpider = !mod_RadarBro.RadarSpider;
/* 202:207 */       ((GuiButton)this.buttonList.get(19)).displayString = (mod_RadarBro.RadarSpider ? "On" : "Off");
/* 203:    */     }
/* 204:209 */     if (guibutton.id == 20)
/* 205:    */     {
/* 206:211 */       mod_RadarBro.RadarWitch = !mod_RadarBro.RadarWitch;
/* 207:212 */       ((GuiButton)this.buttonList.get(20)).displayString = (mod_RadarBro.RadarWitch ? "On" : "Off");
/* 208:    */     }
/* 209:214 */     if (guibutton.id == 21)
/* 210:    */     {
/* 211:216 */       mod_RadarBro.RadarWither = !mod_RadarBro.RadarWither;
/* 212:217 */       ((GuiButton)this.buttonList.get(21)).displayString = (mod_RadarBro.RadarWither ? "On" : "Off");
/* 213:    */     }
/* 214:219 */     if (guibutton.id == 22)
/* 215:    */     {
/* 216:221 */       mod_RadarBro.RadarZombie = !mod_RadarBro.RadarZombie;
/* 217:222 */       ((GuiButton)this.buttonList.get(22)).displayString = (mod_RadarBro.RadarZombie ? "On" : "Off");
/* 218:    */     }
/* 219:225 */     if (guibutton.id == 23)
/* 220:    */     {
/* 221:227 */       mod_RadarBro.RadarEnderman = !mod_RadarBro.RadarEnderman;
/* 222:228 */       ((GuiButton)this.buttonList.get(23)).displayString = (mod_RadarBro.RadarEnderman ? "On" : "Off");
/* 223:    */     }
/* 224:230 */     if (guibutton.id == 24)
/* 225:    */     {
/* 226:232 */       mod_RadarBro.RadarIronGolem = !mod_RadarBro.RadarIronGolem;
/* 227:233 */       ((GuiButton)this.buttonList.get(24)).displayString = (mod_RadarBro.RadarIronGolem ? "On" : "Off");
/* 228:    */     }
/* 229:235 */     if (guibutton.id == 25)
/* 230:    */     {
/* 231:237 */       mod_RadarBro.RadarWolf = !mod_RadarBro.RadarWolf;
/* 232:238 */       ((GuiButton)this.buttonList.get(25)).displayString = (mod_RadarBro.RadarWolf ? "On" : "Off");
/* 233:    */     }
/* 234:240 */     if (guibutton.id == 26)
/* 235:    */     {
/* 236:242 */       mod_RadarBro.RadarZombiePigman = !mod_RadarBro.RadarZombiePigman;
/* 237:243 */       ((GuiButton)this.buttonList.get(26)).displayString = (mod_RadarBro.RadarZombiePigman ? "On" : "Off");
/* 238:    */     }
/* 239:245 */     if (guibutton.id == 27)
/* 240:    */     {
/* 241:247 */       mod_RadarBro.RadarArrow = !mod_RadarBro.RadarArrow;
/* 242:248 */       ((GuiButton)this.buttonList.get(27)).displayString = (mod_RadarBro.RadarArrow ? "On" : "Off");
/* 243:    */     }
/* 244:250 */     if (guibutton.id == 28)
/* 245:    */     {
/* 246:252 */       mod_RadarBro.RadarBoat = !mod_RadarBro.RadarBoat;
/* 247:253 */       ((GuiButton)this.buttonList.get(28)).displayString = (mod_RadarBro.RadarBoat ? "On" : "Off");
/* 248:    */     }
/* 249:255 */     if (guibutton.id == 29)
/* 250:    */     {
/* 251:257 */       mod_RadarBro.RadarChest = !mod_RadarBro.RadarChest;
/* 252:258 */       ((GuiButton)this.buttonList.get(29)).displayString = (mod_RadarBro.RadarChest ? "On" : "Off");
/* 253:    */     }
/* 254:260 */     if (guibutton.id == 30)
/* 255:    */     {
/* 256:262 */       mod_RadarBro.RadarItem = !mod_RadarBro.RadarItem;
/* 257:263 */       ((GuiButton)this.buttonList.get(30)).displayString = (mod_RadarBro.RadarItem ? "On" : "Off");
/* 258:    */     }
/* 259:265 */     if (guibutton.id == 31)
/* 260:    */     {
/* 261:267 */       mod_RadarBro.RadarMinecart = !mod_RadarBro.RadarMinecart;
/* 262:268 */       ((GuiButton)this.buttonList.get(31)).displayString = (mod_RadarBro.RadarMinecart ? "On" : "Off");
/* 263:    */     }
/* 264:270 */     if (guibutton.id == 32)
/* 265:    */     {
/* 266:272 */       mod_RadarBro.RadarPainting = !mod_RadarBro.RadarPainting;
/* 267:273 */       ((GuiButton)this.buttonList.get(32)).displayString = (mod_RadarBro.RadarPainting ? "On" : "Off");
/* 268:    */     }
/* 269:275 */     if (guibutton.id == 33)
/* 270:    */     {
/* 271:277 */       mod_RadarBro.RadarMonsterSpawner = !mod_RadarBro.RadarMonsterSpawner;
/* 272:278 */       ((GuiButton)this.buttonList.get(33)).displayString = (mod_RadarBro.RadarMonsterSpawner ? "On" : "Off");
/* 273:    */     }
/* 274:280 */     if (guibutton.id == 34)
/* 275:    */     {
/* 276:282 */       mod_RadarBro.RadarWaypoint = !mod_RadarBro.RadarWaypoint;
/* 277:283 */       ((GuiButton)this.buttonList.get(34)).displayString = (mod_RadarBro.RadarWaypoint ? "On" : "Off");
/* 278:    */     }
/* 279:285 */     if (guibutton.id == 35)
/* 280:    */     {
/* 281:287 */       mod_RadarBro.RadarXPOrb = !mod_RadarBro.RadarXPOrb;
/* 282:288 */       ((GuiButton)this.buttonList.get(35)).displayString = (mod_RadarBro.RadarXPOrb ? "On" : "Off");
/* 283:    */     }
/* 284:291 */     if (guibutton.id == 36)
/* 285:    */     {
/* 286:293 */       mod_RadarBro.RadarPlayer = !mod_RadarBro.RadarPlayer;
/* 287:294 */       ((GuiButton)this.buttonList.get(36)).displayString = (mod_RadarBro.RadarPlayer ? "On" : "Off");
/* 288:    */     }
/* 289:296 */     if (guibutton.id == 37)
/* 290:    */     {
/* 291:298 */       mod_RadarBro.RadarAlly = !mod_RadarBro.RadarAlly;
/* 292:299 */       ((GuiButton)this.buttonList.get(37)).displayString = (mod_RadarBro.RadarAlly ? "On" : "Off");
/* 293:    */     }
/* 294:301 */     if (guibutton.id == 38)
/* 295:    */     {
/* 296:303 */       mod_RadarBro.RadarEnemy = !mod_RadarBro.RadarEnemy;
/* 297:304 */       ((GuiButton)this.buttonList.get(38)).displayString = (mod_RadarBro.RadarEnemy ? "On" : "Off");
/* 298:    */     }
/* 299:306 */     if (guibutton.id == 39) {
/* 300:308 */       this.mc.displayGuiScreen(this.parentScreen);
/* 301:    */     }
/* 302:311 */     mod_RadarBro.saveOptions();
/* 303:    */   }
/* 304:    */   
/* 305:    */   protected void mouseClicked(int i, int j, int k)
/* 306:    */   {
/* 307:316 */     super.mouseClicked(i, j, k);
/* 308:    */   }
/* 309:    */   
/* 310:    */   public void drawIcon(int x, int y, int x2, int y2)
/* 311:    */   {
/* 312:320 */     GL11.glPushMatrix();
/* 313:321 */     GL11.glScalef(0.5F, 0.5F, 0.5F);
/* 314:322 */     GL11.glTranslatef(x, y, 0.0F);
/* 315:323 */     drawTexturedModalRect(x, y, x2, y2, 16, 16);
/* 316:324 */     GL11.glScalef(2.0F, 2.0F, 2.0F);
/* 317:325 */     GL11.glPopMatrix();
/* 318:    */   }
/* 319:    */   
/* 320:    */   public void drawScreen(int i, int j, float f)
/* 321:    */   {
/* 322:330 */     GL11.glDisable(2929);
/* 323:331 */     drawDefaultBackground();
/* 324:    */     
/* 325:333 */     this.textureManager.bindTexture(radaricons);
/* 326:334 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 327:    */     
/* 328:    */ 
/* 329:    */ 
/* 330:    */ 
/* 331:339 */     drawIcon(this.width / 2 - 205, this.height / 2 - 62, 80, 32);
/* 332:    */     
/* 333:    */ 
/* 334:342 */     drawIcon(this.width / 2 - 205, this.height / 2 - 47, 32, 0);
/* 335:    */     
/* 336:    */ 
/* 337:345 */     drawIcon(this.width / 2 - 205, this.height / 2 - 32, 48, 0);
/* 338:    */     
/* 339:    */ 
/* 340:348 */     drawIcon(this.width / 2 - 205, this.height / 2 - 17, 144, 0);
/* 341:    */     
/* 342:    */ 
/* 343:351 */     drawIcon(this.width / 2 - 205, this.height / 2 - 2, 240, 16);
/* 344:    */     
/* 345:    */ 
/* 346:354 */     drawIcon(this.width / 2 - 205, this.height / 2 + 13, 160, 0);
/* 347:    */     
/* 348:    */ 
/* 349:357 */     drawIcon(this.width / 2 - 205, this.height / 2 + 28, 176, 0);
/* 350:    */     
/* 351:    */ 
/* 352:360 */     drawIcon(this.width / 2 - 205, this.height / 2 + 43, 240, 0);
/* 353:    */     
/* 354:    */ 
/* 355:363 */     drawIcon(this.width / 2 - 205, this.height / 2 + 58, 16, 16);
/* 356:    */     
/* 357:    */ 
/* 358:366 */     drawIcon(this.width / 2 - 205, this.height / 2 + 73, 80, 16);
/* 359:    */     
/* 360:    */ 
/* 361:    */ 
/* 362:    */ 
/* 363:    */ 
/* 364:372 */     drawIcon(this.width / 2 - 100, this.height / 2 - 77, 0, 0);
/* 365:    */     
/* 366:    */ 
/* 367:375 */     drawIcon(this.width / 2 - 100, this.height / 2 - 62, 16, 0);
/* 368:    */     
/* 369:    */ 
/* 370:378 */     drawIcon(this.width / 2 - 100, this.height / 2 - 47, 64, 0);
/* 371:    */     
/* 372:    */ 
/* 373:381 */     drawIcon(this.width / 2 - 100, this.height / 2 - 32, 80, 0);
/* 374:    */     
/* 375:    */ 
/* 376:384 */     drawIcon(this.width / 2 - 100, this.height / 2 - 17, 112, 0);
/* 377:    */     
/* 378:    */ 
/* 379:387 */     drawIcon(this.width / 2 - 100, this.height / 2 - 2, 128, 0);
/* 380:    */     
/* 381:    */ 
/* 382:390 */     drawIcon(this.width / 2 - 100, this.height / 2 + 13, 192, 0);
/* 383:    */     
/* 384:    */ 
/* 385:393 */     drawIcon(this.width / 2 - 100, this.height / 2 + 28, 208, 0);
/* 386:    */     
/* 387:    */ 
/* 388:396 */     drawIcon(this.width / 2 - 100, this.height / 2 + 43, 224, 0);
/* 389:    */     
/* 390:    */ 
/* 391:399 */     drawIcon(this.width / 2 - 100, this.height / 2 + 58, 0, 16);
/* 392:    */     
/* 393:    */ 
/* 394:402 */     drawIcon(this.width / 2 - 100, this.height / 2 + 73, 96, 32);
/* 395:    */     
/* 396:    */ 
/* 397:405 */     drawIcon(this.width / 2 - 100, this.height / 2 + 88, 112, 32);
/* 398:    */     
/* 399:    */ 
/* 400:408 */     drawIcon(this.width / 2 - 100, this.height / 2 + 103, 48, 16);
/* 401:    */     
/* 402:    */ 
/* 403:    */ 
/* 404:    */ 
/* 405:    */ 
/* 406:414 */     drawIcon(this.width / 2 + 10, this.height / 2 - 47, 96, 0);
/* 407:    */     
/* 408:    */ 
/* 409:417 */     drawIcon(this.width / 2 + 10, this.height / 2 - 32, 0, 32);
/* 410:    */     
/* 411:    */ 
/* 412:420 */     drawIcon(this.width / 2 + 10, this.height / 2 - 17, 32, 16);
/* 413:    */     
/* 414:    */ 
/* 415:423 */     drawIcon(this.width / 2 + 10, this.height / 2 - 2, 64, 16);
/* 416:    */     
/* 417:    */ 
/* 418:    */ 
/* 419:    */ 
/* 420:    */ 
/* 421:429 */     drawIcon(this.width / 2 + 125, this.height / 2 - 47, 112, 16);
/* 422:    */     
/* 423:    */ 
/* 424:432 */     drawIcon(this.width / 2 + 125, this.height / 2 - 32, 128, 16);
/* 425:    */     
/* 426:    */ 
/* 427:435 */     drawIcon(this.width / 2 + 125, this.height / 2 - 17, 16, 32);
/* 428:    */     
/* 429:    */ 
/* 430:438 */     drawIcon(this.width / 2 + 125, this.height / 2 - 2, 144, 16);
/* 431:    */     
/* 432:    */ 
/* 433:441 */     drawIcon(this.width / 2 + 125, this.height / 2 + 13, 160, 16);
/* 434:    */     
/* 435:    */ 
/* 436:444 */     drawIcon(this.width / 2 + 125, this.height / 2 + 28, 176, 16);
/* 437:    */     
/* 438:    */ 
/* 439:447 */     drawIcon(this.width / 2 + 125, this.height / 2 + 43, 128, 32);
/* 440:    */     
/* 441:    */ 
/* 442:450 */     drawIcon(this.width / 2 + 125, this.height / 2 + 58, 32, 32);
/* 443:    */     
/* 444:    */ 
/* 445:453 */     drawIcon(this.width / 2 + 125, this.height / 2 + 73, 192, 16);
/* 446:    */     
/* 447:    */ 
/* 448:    */ 
/* 449:    */ 
/* 450:    */ 
/* 451:459 */     drawIcon(this.width / 2 + 10, this.height / 2 + 58, 96, 16);
/* 452:    */     
/* 453:    */ 
/* 454:462 */     drawIcon(this.width / 2 + 10, this.height / 2 + 73, 208, 16);
/* 455:    */     
/* 456:    */ 
/* 457:465 */     drawIcon(this.width / 2 + 10, this.height / 2 + 88, 224, 16);
/* 458:    */     
/* 459:467 */     drawCenteredString(this.fontRendererObj, "RadarBro Icon Settings", this.width / 2, this.height / 4 - 72 + 20, 16777215);
/* 460:    */     
/* 461:469 */     drawString(this.fontRendererObj, "Passive", this.width / 2 - 180, this.height / 2 - 77, 16777215);
/* 462:470 */     drawString(this.fontRendererObj, "Hostile", this.width / 2 - 60, this.height / 2 - 95, 16777215);
/* 463:471 */     drawString(this.fontRendererObj, "Neutral", this.width / 2 + 40, this.height / 2 - 62, 16777215);
/* 464:472 */     drawString(this.fontRendererObj, "Other", this.width / 2 + 150, this.height / 2 - 62, 16777215);
/* 465:473 */     drawString(this.fontRendererObj, "Players", this.width / 2 + 40, this.height / 2 + 35, 16777215);
/* 466:    */     
/* 467:475 */     drawString(this.fontRendererObj, "Bat", this.width / 2 - 190, this.height / 2 - 62, 10526880);
/* 468:476 */     drawString(this.fontRendererObj, "Chicken", this.width / 2 - 190, this.height / 2 - 47, 10526880);
/* 469:477 */     drawString(this.fontRendererObj, "Cow", this.width / 2 - 190, this.height / 2 - 32, 10526880);
/* 470:478 */     drawString(this.fontRendererObj, "Mooshroom", this.width / 2 - 190, this.height / 2 - 17, 10526880);
/* 471:479 */     drawString(this.fontRendererObj, "Ocelot", this.width / 2 - 190, this.height / 2 - 2, 10526880);
/* 472:480 */     drawString(this.fontRendererObj, "Pig", this.width / 2 - 190, this.height / 2 + 13, 10526880);
/* 473:481 */     drawString(this.fontRendererObj, "Sheep", this.width / 2 - 190, this.height / 2 + 28, 10526880);
/* 474:482 */     drawString(this.fontRendererObj, "Snow Golem", this.width / 2 - 190, this.height / 2 + 43, 10526880);
/* 475:483 */     drawString(this.fontRendererObj, "Squid", this.width / 2 - 190, this.height / 2 + 58, 10526880);
/* 476:484 */     drawString(this.fontRendererObj, "Villager", this.width / 2 - 190, this.height / 2 + 73, 10526880);
/* 477:    */     
/* 478:486 */     drawString(this.fontRendererObj, "Blaze", this.width / 2 - 85, this.height / 2 - 77, 10526880);
/* 479:487 */     drawString(this.fontRendererObj, "Cave Spider", this.width / 2 - 85, this.height / 2 - 62, 10526880);
/* 480:488 */     drawString(this.fontRendererObj, "Creeper", this.width / 2 - 85, this.height / 2 - 47, 10526880);
/* 481:489 */     drawString(this.fontRendererObj, "Enderdragon", this.width / 2 - 85, this.height / 2 - 32, 10526880);
/* 482:490 */     drawString(this.fontRendererObj, "Ghast", this.width / 2 - 85, this.height / 2 - 17, 10526880);
/* 483:491 */     drawString(this.fontRendererObj, "Magma Cube", this.width / 2 - 85, this.height / 2 - 2, 10526880);
/* 484:492 */     drawString(this.fontRendererObj, "Silverfish", this.width / 2 - 85, this.height / 2 + 13, 10526880);
/* 485:493 */     drawString(this.fontRendererObj, "Skeleton", this.width / 2 - 85, this.height / 2 + 28, 10526880);
/* 486:494 */     drawString(this.fontRendererObj, "Slime", this.width / 2 - 85, this.height / 2 + 43, 10526880);
/* 487:495 */     drawString(this.fontRendererObj, "Spider", this.width / 2 - 85, this.height / 2 + 58, 10526880);
/* 488:496 */     drawString(this.fontRendererObj, "Witch", this.width / 2 - 85, this.height / 2 + 73, 10526880);
/* 489:497 */     drawString(this.fontRendererObj, "Wither", this.width / 2 - 85, this.height / 2 + 88, 10526880);
/* 490:498 */     drawString(this.fontRendererObj, "Zombie", this.width / 2 - 85, this.height / 2 + 103, 10526880);
/* 491:    */     
/* 492:500 */     drawString(this.fontRendererObj, "Enderman", this.width / 2 + 25, this.height / 2 - 47, 10526880);
/* 493:501 */     drawString(this.fontRendererObj, "Iron Golem", this.width / 2 + 25, this.height / 2 - 32, 10526880);
/* 494:502 */     drawString(this.fontRendererObj, "Wolf", this.width / 2 + 25, this.height / 2 - 17, 10526880);
/* 495:503 */     drawString(this.fontRendererObj, "Zombie Pigman", this.width / 2 + 25, this.height / 2 - 2, 10526880);
/* 496:    */     
/* 497:505 */     drawString(this.fontRendererObj, "Arrow", this.width / 2 + 140, this.height / 2 - 47, 10526880);
/* 498:506 */     drawString(this.fontRendererObj, "Boat", this.width / 2 + 140, this.height / 2 - 32, 10526880);
/* 499:507 */     drawString(this.fontRendererObj, "Chest", this.width / 2 + 140, this.height / 2 - 17, 10526880);
/* 500:508 */     drawString(this.fontRendererObj, "Item", this.width / 2 + 140, this.height / 2 - 2, 10526880);
/* 501:509 */     drawString(this.fontRendererObj, "Minecart", this.width / 2 + 140, this.height / 2 + 13, 10526880);
/* 502:510 */     drawString(this.fontRendererObj, "Painting", this.width / 2 + 140, this.height / 2 + 28, 10526880);
/* 503:511 */     drawString(this.fontRendererObj, "Spawner", this.width / 2 + 140, this.height / 2 + 43, 10526880);
/* 504:512 */     drawString(this.fontRendererObj, "Waypoint", this.width / 2 + 140, this.height / 2 + 58, 10526880);
/* 505:513 */     drawString(this.fontRendererObj, "XP Orb", this.width / 2 + 140, this.height / 2 + 73, 10526880);
/* 506:    */     
/* 507:515 */     drawString(this.fontRendererObj, "Player", this.width / 2 + 25, this.height / 2 + 58, 10526880);
/* 508:516 */     drawString(this.fontRendererObj, "Ally", this.width / 2 + 25, this.height / 2 + 73, 10526880);
/* 509:517 */     drawString(this.fontRendererObj, "Enemy", this.width / 2 + 25, this.height / 2 + 88, 10526880);
/* 510:    */     
/* 511:519 */     super.drawScreen(i, j, f);
/* 512:    */   }
/* 513:    */ }


/* Location:           C:\Users\Admin\Downloads\RadarBroDecompiled.jar
 * Qualified Name:     com.calialec.radarbro.GuiRadarBroIconSettings
 * JD-Core Version:    0.7.1
 */