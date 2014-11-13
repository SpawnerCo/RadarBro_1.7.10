/*   1:    */ package com.calialec.radarbro;
/*   2:    */ 
/*   3:    */ import cpw.mods.fml.common.eventhandler.SubscribeEvent;
/*   4:    */ import java.awt.Graphics;
/*   5:    */ import java.awt.image.BufferedImage;
/*   6:    */ import java.io.IOException;
/*   7:    */ import java.net.MalformedURLException;
/*   8:    */ import java.net.URL;
/*   9:    */ import java.util.ArrayList;
/*  10:    */ import java.util.HashMap;
/*  11:    */ import java.util.List;
/*  12:    */ import javax.imageio.ImageIO;
/*  13:    */ import net.minecraft.client.Minecraft;
/*  14:    */ import net.minecraft.client.entity.AbstractClientPlayer;
/*  15:    */ import net.minecraft.client.entity.EntityOtherPlayerMP;
/*  16:    */ import net.minecraft.client.gui.FontRenderer;
/*  17:    */ import net.minecraft.client.gui.GuiScreen;
/*  18:    */ import net.minecraft.client.gui.ScaledResolution;
/*  19:    */ import net.minecraft.client.renderer.entity.RenderItem;
/*  20:    */ import net.minecraft.client.renderer.texture.DynamicTexture;
/*  21:    */ import net.minecraft.client.renderer.texture.TextureManager;
/*  22:    */ import net.minecraft.client.resources.IResource;
/*  23:    */ import net.minecraft.client.resources.IResourceManager;
/*  24:    */ import net.minecraft.entity.Entity;
/*  25:    */ import net.minecraft.entity.boss.EntityDragon;
/*  26:    */ import net.minecraft.entity.boss.EntityWither;
/*  27:    */ import net.minecraft.entity.item.EntityBoat;
/*  28:    */ import net.minecraft.entity.item.EntityItem;
/*  29:    */ import net.minecraft.entity.item.EntityMinecart;
/*  30:    */ import net.minecraft.entity.item.EntityPainting;
/*  31:    */ import net.minecraft.entity.item.EntityXPOrb;
/*  32:    */ import net.minecraft.entity.monster.EntityBlaze;
/*  33:    */ import net.minecraft.entity.monster.EntityCaveSpider;
/*  34:    */ import net.minecraft.entity.monster.EntityCreeper;
/*  35:    */ import net.minecraft.entity.monster.EntityEnderman;
/*  36:    */ import net.minecraft.entity.monster.EntityGhast;
/*  37:    */ import net.minecraft.entity.monster.EntityIronGolem;
/*  38:    */ import net.minecraft.entity.monster.EntityMagmaCube;
/*  39:    */ import net.minecraft.entity.monster.EntityPigZombie;
/*  40:    */ import net.minecraft.entity.monster.EntitySilverfish;
/*  41:    */ import net.minecraft.entity.monster.EntitySkeleton;
/*  42:    */ import net.minecraft.entity.monster.EntitySlime;
/*  43:    */ import net.minecraft.entity.monster.EntitySnowman;
/*  44:    */ import net.minecraft.entity.monster.EntitySpider;
/*  45:    */ import net.minecraft.entity.monster.EntityWitch;
/*  46:    */ import net.minecraft.entity.monster.EntityZombie;
/*  47:    */ import net.minecraft.entity.passive.EntityBat;
/*  48:    */ import net.minecraft.entity.passive.EntityChicken;
/*  49:    */ import net.minecraft.entity.passive.EntityCow;
/*  50:    */ import net.minecraft.entity.passive.EntityMooshroom;
/*  51:    */ import net.minecraft.entity.passive.EntityOcelot;
/*  52:    */ import net.minecraft.entity.passive.EntityPig;
/*  53:    */ import net.minecraft.entity.passive.EntitySheep;
/*  54:    */ import net.minecraft.entity.passive.EntitySquid;
/*  55:    */ import net.minecraft.entity.passive.EntityVillager;
/*  56:    */ import net.minecraft.entity.passive.EntityWolf;
/*  57:    */ import net.minecraft.entity.player.EntityPlayer;
/*  58:    */ import net.minecraft.entity.projectile.EntityArrow;
/*  59:    */ import net.minecraft.item.ItemStack;
/*  60:    */ import net.minecraft.tileentity.TileEntity;
/*  61:    */ import net.minecraft.tileentity.TileEntityChest;
/*  62:    */ import net.minecraft.tileentity.TileEntityDispenser;
/*  63:    */ import net.minecraft.tileentity.TileEntityDropper;
/*  64:    */ import net.minecraft.tileentity.TileEntityEnderChest;
/*  65:    */ import net.minecraft.tileentity.TileEntityMobSpawner;
/*  66:    */ import net.minecraft.util.ResourceLocation;
/*  67:    */ import net.minecraft.world.World;
/*  68:    */ import net.minecraftforge.client.event.RenderGameOverlayEvent;
/*  69:    */ import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
/*  70:    */ import org.lwjgl.opengl.GL11;
/*  71:    */ 
/*  72:    */ public class GuiRadarBro
/*  73:    */   extends GuiScreen
/*  74:    */ {
/*  75:    */   private static Minecraft mc;
/*  76: 74 */   public static final ResourceLocation radaricons = new ResourceLocation("mod_RadarBro/textures/radaricons.png");
/*  77:    */   private TextureManager textureManager;
/*  78:    */   
/*  79:    */   public GuiRadarBro(Minecraft minecraft)
/*  80:    */   {
/*  81: 77 */     mc = minecraft;
/*  82: 78 */     this.textureManager = mc.getTextureManager();
/*  83:    */   }
/*  84:    */   
/*  85:    */   @SubscribeEvent
/*  86:    */   public void onDrawRadarBro(RenderGameOverlayEvent event)
/*  87:    */   {
/*  88: 84 */     if ((event.isCancelable()) || (event.type != RenderGameOverlayEvent.ElementType.EXPERIENCE)) {
/*  89: 85 */       return;
/*  90:    */     }
/*  91: 87 */     if (mod_RadarBro.RadarEnabled)
/*  92:    */     {
/*  93: 88 */       ScaledResolution sr = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
/*  94: 89 */       int i = sr.getScaledWidth();
/*  95: 90 */       GL11.glPushMatrix();
/*  96: 91 */       GL11.glTranslatef(i - 65 + (GuiRepositionRadarBro.xDisplacement + GuiRepositionRadarBro.xEndDisplacement), 65 + (GuiRepositionRadarBro.yDisplacement + GuiRepositionRadarBro.yEndDisplacement), 0.0F);
/*  97: 92 */       if (mod_RadarBro.RadarCoordinates)
/*  98:    */       {
/*  99: 93 */         GL11.glScalef(0.5F, 0.5F, 0.5F);
/* 100: 94 */         mc.fontRenderer.drawString("(" + (int)mc.thePlayer.posX, -8 - mc.fontRenderer.getStringWidth("(" + (int)mc.thePlayer.posX), 134, 14737632);
/* 101: 95 */         mc.fontRenderer.drawString("," + (int)mc.thePlayer.posY + "," + (int)mc.thePlayer.posZ + ")", -8, 134, 14737632);
/* 102: 96 */         GL11.glScalef(2.0F, 2.0F, 2.0F);
/* 103:    */       }
/* 104: 98 */       if (mod_RadarBro.RadarAutoRotate) {
/* 105: 99 */         GL11.glRotatef(-mc.thePlayer.rotationYaw, 0.0F, 0.0F, 1.0F);
/* 106:    */       }
/* 107:    */       try
/* 108:    */       {
/* 109:103 */         if (mod_RadarBro.RadarTerrain) {
/* 110:104 */           renderTerrain();
/* 111:    */         }
/* 112:    */       }
/* 113:    */       catch (Exception e) {}
/* 114:109 */       drawCircle(0, 0, 63.0D, Integer.MIN_VALUE, true);
/* 115:110 */       drawCircle(0, 0, 63.0D, -2140904094, false);
/* 116:111 */       drawCircle(0, 0, 43.0D, -2140904094, false);
/* 117:112 */       drawCircle(0, 0, 22.0D, -2140904094, false);
/* 118:113 */       GL11.glLineWidth(2.0F);
/* 119:114 */       GL11.glDisable(3553);
/* 120:115 */       GL11.glDisable(2896);
/* 121:116 */       GL11.glBegin(1);
/* 122:117 */       GL11.glVertex2d(0.0D, -63.0D);
/* 123:118 */       GL11.glVertex2d(0.0D, 63.0D);
/* 124:119 */       GL11.glVertex2d(-63.0D, 0.0D);
/* 125:120 */       GL11.glVertex2d(63.0D, 0.0D);
/* 126:121 */       GL11.glVertex2d(-44.5D, -44.5D);
/* 127:122 */       GL11.glVertex2d(44.5D, 44.5D);
/* 128:123 */       GL11.glVertex2d(-44.5D, 44.5D);
/* 129:124 */       GL11.glVertex2d(44.5D, -44.5D);
/* 130:125 */       GL11.glEnd();
/* 131:126 */       GL11.glDisable(3042);
/* 132:127 */       GL11.glEnable(3553);
/* 133:128 */       drawIconRadar();
/* 134:129 */       if (mod_RadarBro.RadarAutoRotate) {
/* 135:130 */         GL11.glRotatef(mc.thePlayer.rotationYaw, 0.0F, 0.0F, 1.0F);
/* 136:    */       }
/* 137:132 */       drawTriangle(0, 0, -4144960);
/* 138:133 */       GL11.glPopMatrix();
/* 139:    */     }
/* 140:    */   }
/* 141:    */   
/* 142:    */   public void drawIconRadar()
/* 143:    */   {
/* 144:138 */     if (mod_RadarBro.RadarWaypoint) {
/* 145:139 */       for (int j41 = 0; j41 < mod_RadarBro.Waypoints.size(); j41++)
/* 146:    */       {
/* 147:141 */         String[] waypointInfo = mod_RadarBro.Waypoints.get(j41).toString().split(",");
/* 148:142 */         int waypointX = (int)Double.parseDouble(waypointInfo[0]);
/* 149:143 */         int waypointY = (int)Double.parseDouble(waypointInfo[1]);
/* 150:144 */         int waypointZ = (int)Double.parseDouble(waypointInfo[2]);
/* 151:145 */         int posX = (int)(mc.thePlayer.posX - waypointX);
/* 152:146 */         int posY = (int)(mc.thePlayer.posY - waypointY);
/* 153:147 */         int posZ = (int)(mc.thePlayer.posZ - waypointZ);
/* 154:148 */         String name = waypointInfo[3];
/* 155:149 */         String enabled = waypointInfo[4];
/* 156:150 */         if (enabled.equals("true")) {
/* 157:151 */           if (Math.hypot(posX, posZ) < 120.0D)
/* 158:    */           {
/* 159:152 */             drawIconRadarIcon(posX, posZ, 32, 32);
/* 160:153 */             drawRadarNames(posX, posZ, name);
/* 161:154 */             mod_RadarBro.WaypointLastInRangePosition.put(mod_RadarBro.Waypoints.get(j41).toString(), posX + "," + posZ);
/* 162:    */           }
/* 163:    */           else
/* 164:    */           {
/* 165:    */             try
/* 166:    */             {
/* 167:157 */               String[] lastposition = ((String)mod_RadarBro.WaypointLastInRangePosition.get(mod_RadarBro.Waypoints.get(j41).toString())).split(",");
/* 168:158 */               int lastposX = Integer.parseInt(lastposition[0]);
/* 169:159 */               int lastposZ = Integer.parseInt(lastposition[1]);
/* 170:160 */               drawIconRadarWaypointIcon(lastposX, lastposZ);
/* 171:161 */               drawRadarNames(lastposX, lastposZ, name);
/* 172:    */             }
/* 173:    */             catch (NullPointerException e) {}
/* 174:    */           }
/* 175:    */         }
/* 176:    */       }
/* 177:    */     }
/* 178:169 */     if ((mod_RadarBro.RadarChest) || (mod_RadarBro.RadarMonsterSpawner))
/* 179:    */     {
/* 180:170 */       List<TileEntity> tileEntities = mc.theWorld.loadedTileEntityList;
/* 181:171 */       for (int i = 0; i < tileEntities.size(); i++)
/* 182:    */       {
/* 183:172 */         TileEntity tileEntity = (TileEntity)tileEntities.get(i);
/* 184:173 */         int pPosX = (int)Math.round(mc.thePlayer.posX);
/* 185:174 */         int pPosY = (int)Math.round(mc.thePlayer.posY);
/* 186:175 */         int pPosZ = (int)Math.round(mc.thePlayer.posZ);
/* 187:176 */         int tileEntPosX = Math.round(tileEntity.xCoord);
/* 188:177 */         int tileEntPosY = Math.round(tileEntity.yCoord);
/* 189:178 */         int tileEntPosZ = Math.round(tileEntity.zCoord);
/* 190:179 */         int dPosX = pPosX - tileEntPosX;
/* 191:180 */         int dPosY = pPosY - tileEntPosY;
/* 192:181 */         int dPosZ = pPosZ - tileEntPosZ;
/* 193:182 */         if (Math.hypot(dPosX, dPosZ) < 130.0D)
/* 194:    */         {
/* 195:183 */           if (((tileEntity instanceof TileEntityChest)) && (mod_RadarBro.RadarChest)) {
/* 196:184 */             drawIconRadarIcon(dPosX, dPosZ, 16, 32);
/* 197:    */           }
/* 198:186 */           if (((tileEntity instanceof TileEntityEnderChest)) && (mod_RadarBro.RadarChest)) {
/* 199:187 */             drawIconRadarIcon(dPosX, dPosZ, 64, 32);
/* 200:    */           }
/* 201:189 */           if (((tileEntity instanceof TileEntityMobSpawner)) && (mod_RadarBro.RadarMonsterSpawner)) {
/* 202:190 */             drawIconRadarIcon(dPosX, dPosZ, 128, 32);
/* 203:    */           }
/* 204:192 */           if ((tileEntity instanceof TileEntityDispenser)) {
/* 205:193 */             drawIconRadarIcon(dPosX, dPosZ, 144, 32);
/* 206:    */           }
/* 207:195 */           if ((tileEntity instanceof TileEntityDropper)) {
/* 208:196 */             drawIconRadarIcon(dPosX, dPosZ, 160, 32);
/* 209:    */           }
/* 210:    */         }
/* 211:    */       }
/* 212:    */     }
/* 213:201 */     List<Entity> entities = mc.theWorld.loadedEntityList;
/* 214:202 */     for (int i = 0; i < entities.size(); i++)
/* 215:    */     {
/* 216:203 */       Entity entity = (Entity)entities.get(i);
/* 217:204 */       int pPosX = (int)Math.round(mc.thePlayer.posX);
/* 218:205 */       int pPosY = (int)Math.round(mc.thePlayer.posY);
/* 219:206 */       int pPosZ = (int)Math.round(mc.thePlayer.posZ);
/* 220:207 */       int entPosX = (int)Math.round(entity.posX);
/* 221:208 */       int entPosY = (int)Math.round(entity.posY);
/* 222:209 */       int entPosZ = (int)Math.round(entity.posZ);
/* 223:210 */       int dPosX = pPosX - entPosX;
/* 224:211 */       int dPosY = pPosY - entPosY;
/* 225:212 */       int dPosZ = pPosZ - entPosZ;
/* 226:213 */       if ((Math.hypot(dPosX, dPosZ) < 130.0D) && (entity != mc.thePlayer))
/* 227:    */       {
/* 228:214 */         if (((entity instanceof EntityBat)) && (mod_RadarBro.RadarBat)) {
/* 229:215 */           drawIconRadarIcon(dPosX, dPosZ, 80, 32);
/* 230:    */         }
/* 231:217 */         if (((entity instanceof EntityChicken)) && (mod_RadarBro.RadarChicken)) {
/* 232:218 */           drawIconRadarIcon(dPosX, dPosZ, 32, 0);
/* 233:    */         }
/* 234:220 */         if (((entity instanceof EntityCow)) && (mod_RadarBro.RadarCow) && (!(entity instanceof EntityMooshroom))) {
/* 235:221 */           drawIconRadarIcon(dPosX, dPosZ, 48, 0);
/* 236:    */         }
/* 237:223 */         if (((entity instanceof EntityMooshroom)) && (mod_RadarBro.RadarMooshroom)) {
/* 238:224 */           drawIconRadarIcon(dPosX, dPosZ, 144, 0);
/* 239:    */         }
/* 240:226 */         if (((entity instanceof EntityOcelot)) && (mod_RadarBro.RadarOcelot)) {
/* 241:227 */           drawIconRadarIcon(dPosX, dPosZ, 240, 16);
/* 242:    */         }
/* 243:229 */         if (((entity instanceof EntityPig)) && (mod_RadarBro.RadarPig)) {
/* 244:230 */           drawIconRadarIcon(dPosX, dPosZ, 160, 0);
/* 245:    */         }
/* 246:232 */         if (((entity instanceof EntitySheep)) && (mod_RadarBro.RadarSheep)) {
/* 247:233 */           drawIconRadarIcon(dPosX, dPosZ, 176, 0);
/* 248:    */         }
/* 249:235 */         if (((entity instanceof EntitySnowman)) && (mod_RadarBro.RadarSnowGolem)) {
/* 250:236 */           drawIconRadarIcon(dPosX, dPosZ, 240, 0);
/* 251:    */         }
/* 252:238 */         if (((entity instanceof EntitySquid)) && (mod_RadarBro.RadarSquid)) {
/* 253:239 */           drawIconRadarIcon(dPosX, dPosZ, 16, 16);
/* 254:    */         }
/* 255:241 */         if (((entity instanceof EntityVillager)) && (mod_RadarBro.RadarVillager)) {
/* 256:242 */           drawIconRadarIcon(dPosX, dPosZ, 80, 16);
/* 257:    */         }
/* 258:244 */         if (((entity instanceof EntityBlaze)) && (mod_RadarBro.RadarBlaze)) {
/* 259:245 */           drawIconRadarIcon(dPosX, dPosZ, 0, 0);
/* 260:    */         }
/* 261:247 */         if (((entity instanceof EntityCaveSpider)) && (mod_RadarBro.RadarCaveSpider)) {
/* 262:248 */           drawIconRadarIcon(dPosX, dPosZ, 16, 0);
/* 263:    */         }
/* 264:250 */         if (((entity instanceof EntityCreeper)) && (mod_RadarBro.RadarCreeper)) {
/* 265:251 */           drawIconRadarIcon(dPosX, dPosZ, 64, 0);
/* 266:    */         }
/* 267:253 */         if (((entity instanceof EntityDragon)) && (mod_RadarBro.RadarEnderdragon)) {
/* 268:254 */           drawIconRadarIcon(dPosX, dPosZ, 80, 0);
/* 269:    */         }
/* 270:256 */         if (((entity instanceof EntityGhast)) && (mod_RadarBro.RadarGhast)) {
/* 271:257 */           drawIconRadarIcon(dPosX, dPosZ, 112, 0);
/* 272:    */         }
/* 273:259 */         if (((entity instanceof EntityMagmaCube)) && (mod_RadarBro.RadarMagmaCube)) {
/* 274:260 */           drawIconRadarIcon(dPosX, dPosZ, 128, 0);
/* 275:    */         }
/* 276:262 */         if (((entity instanceof EntitySilverfish)) && (mod_RadarBro.RadarSilverfish)) {
/* 277:263 */           drawIconRadarIcon(dPosX, dPosZ, 192, 0);
/* 278:    */         }
/* 279:265 */         if (((entity instanceof EntitySkeleton)) && (mod_RadarBro.RadarSkeleton)) {
/* 280:266 */           drawIconRadarIcon(dPosX, dPosZ, 208, 0);
/* 281:    */         }
/* 282:268 */         if (((entity instanceof EntitySlime)) && (mod_RadarBro.RadarSlime) && (!(entity instanceof EntityMagmaCube))) {
/* 283:269 */           drawIconRadarIcon(dPosX, dPosZ, 224, 0);
/* 284:    */         }
/* 285:271 */         if (((entity instanceof EntitySpider)) && (mod_RadarBro.RadarSpider)) {
/* 286:272 */           drawIconRadarIcon(dPosX, dPosZ, 0, 16);
/* 287:    */         }
/* 288:274 */         if (((entity instanceof EntityWitch)) && (mod_RadarBro.RadarWitch)) {
/* 289:275 */           drawIconRadarIcon(dPosX, dPosZ, 96, 32);
/* 290:    */         }
/* 291:277 */         if (((entity instanceof EntityWither)) && (mod_RadarBro.RadarWither)) {
/* 292:278 */           drawIconRadarIcon(dPosX, dPosZ, 112, 32);
/* 293:    */         }
/* 294:280 */         if (((entity instanceof EntityZombie)) && (mod_RadarBro.RadarZombie)) {
/* 295:281 */           drawIconRadarIcon(dPosX, dPosZ, 48, 16);
/* 296:    */         }
/* 297:283 */         if (((entity instanceof EntityEnderman)) && (mod_RadarBro.RadarEnderman)) {
/* 298:284 */           drawIconRadarIcon(dPosX, dPosZ, 96, 0);
/* 299:    */         }
/* 300:286 */         if (((entity instanceof EntityIronGolem)) && (mod_RadarBro.RadarIronGolem)) {
/* 301:287 */           drawIconRadarIcon(dPosX, dPosZ, 0, 32);
/* 302:    */         }
/* 303:289 */         if (((entity instanceof EntityWolf)) && (mod_RadarBro.RadarWolf)) {
/* 304:290 */           drawIconRadarIcon(dPosX, dPosZ, 32, 16);
/* 305:    */         }
/* 306:292 */         if (((entity instanceof EntityPigZombie)) && (mod_RadarBro.RadarZombiePigman)) {
/* 307:293 */           drawIconRadarIcon(dPosX, dPosZ, 64, 16);
/* 308:    */         }
/* 309:295 */         if (((entity instanceof EntityArrow)) && (mod_RadarBro.RadarArrow)) {
/* 310:296 */           drawIconRadarIcon(dPosX, dPosZ, 112, 16);
/* 311:    */         }
/* 312:298 */         if (((entity instanceof EntityBoat)) && (mod_RadarBro.RadarBoat)) {
/* 313:299 */           drawIconRadarIcon(dPosX, dPosZ, 128, 16);
/* 314:    */         }
/* 315:301 */         if (((entity instanceof EntityItem)) && (mod_RadarBro.RadarItem))
/* 316:    */         {
/* 317:302 */           EntityItem entitem = (EntityItem)entities.get(i);
/* 318:303 */           drawIconRadarItemIcon(dPosX, dPosZ, entitem.getEntityItem());
/* 319:    */         }
/* 320:305 */         if (((entity instanceof EntityMinecart)) && (mod_RadarBro.RadarMinecart)) {
/* 321:306 */           drawIconRadarIcon(dPosX, dPosZ, 160, 16);
/* 322:    */         }
/* 323:308 */         if (((entity instanceof EntityPainting)) && (mod_RadarBro.RadarPainting)) {
/* 324:309 */           drawIconRadarIcon(dPosX, dPosZ, 176, 16);
/* 325:    */         }
/* 326:311 */         if (((entity instanceof EntityXPOrb)) && (mod_RadarBro.RadarXPOrb)) {
/* 327:312 */           drawIconRadarIcon(dPosX, dPosZ, 192, 16);
/* 328:    */         }
/* 329:314 */         if ((entity instanceof EntityPlayer)) {
/* 330:    */           try
/* 331:    */           {
/* 332:316 */             EntityOtherPlayerMP eop = (EntityOtherPlayerMP)entities.get(i);
/* 333:318 */             if (mod_RadarBro.AllyList.contains(eop.getDisplayName()))
/* 334:    */             {
/* 335:319 */               drawIconRadarIcon(dPosX, dPosZ, 208, 16);
/* 336:320 */               if (mod_RadarBro.RadarPlayerNames) {
/* 337:321 */                 drawRadarNames(dPosX, dPosZ, eop.getDisplayName());
/* 338:    */               }
/* 339:    */             }
/* 340:324 */             if ((mod_RadarBro.EnemyList.contains(eop.getDisplayName())) && (mod_RadarBro.RadarEnemy))
/* 341:    */             {
/* 342:325 */               drawIconRadarIcon(dPosX, dPosZ, 224, 16);
/* 343:326 */               if (mod_RadarBro.RadarPlayerNames) {
/* 344:327 */                 drawRadarNames(dPosX, dPosZ, eop.getDisplayName());
/* 345:    */               }
/* 346:    */             }
/* 347:331 */             if (mod_RadarBro.RadarPlayer)
/* 348:    */             {
/* 349:332 */               if (mod_RadarBro.RadarUsePlayerSkinTexture) {
/* 350:333 */                 drawPlayerHeadImage(generatePlayerHeadImage(eop.getDisplayName()), (dPosX + 5) / 2, (dPosZ + 5) / 2);
/* 351:    */               } else {
/* 352:335 */                 drawIconRadarIcon(dPosX, dPosZ, 96, 16);
/* 353:    */               }
/* 354:337 */               if (mod_RadarBro.RadarPlayerNames) {
/* 355:338 */                 drawRadarNames(dPosX, dPosZ, eop.getDisplayName());
/* 356:    */               }
/* 357:    */             }
/* 358:    */           }
/* 359:    */           catch (ClassCastException e) {}
/* 360:    */         }
/* 361:    */       }
/* 362:    */     }
/* 363:    */   }
/* 364:    */   
/* 365:    */   public static void drawCircle(int x, int y, double r, int c, boolean filled)
/* 366:    */   {
/* 367:349 */     float f = (c >> 16 & 0xFF) / 255.0F;
/* 368:350 */     float f1 = (c >> 8 & 0xFF) / 255.0F;
/* 369:351 */     float f2 = (c & 0xFF) / 255.0F;
/* 370:352 */     float f3 = (c >> 24 & 0xFF) / 255.0F;
/* 371:353 */     GL11.glEnable(3042);
/* 372:354 */     GL11.glDisable(3553);
/* 373:355 */     GL11.glEnable(2848);
/* 374:356 */     GL11.glBlendFunc(770, 771);
/* 375:357 */     GL11.glColor4f(f, f1, f2, f3);
/* 376:358 */     GL11.glBegin(filled ? 6 : 2);
/* 377:359 */     for (int i = 0; i <= 360; i++)
/* 378:    */     {
/* 379:361 */       double x2 = Math.sin(i * 3.141526D / 180.0D) * r;
/* 380:362 */       double y2 = Math.cos(i * 3.141526D / 180.0D) * r;
/* 381:363 */       GL11.glVertex2d(x + x2, y + y2);
/* 382:    */     }
/* 383:365 */     GL11.glEnd();
/* 384:366 */     GL11.glDisable(2848);
/* 385:367 */     GL11.glEnable(3553);
/* 386:368 */     GL11.glDisable(3042);
/* 387:    */   }
/* 388:    */   
/* 389:    */   public static void drawTriangle(int cx, int cy, int c)
/* 390:    */   {
/* 391:373 */     if (!mod_RadarBro.RadarAutoRotate)
/* 392:    */     {
/* 393:374 */       GL11.glPushMatrix();
/* 394:375 */       GL11.glTranslatef(0.0F, 0.0F, 0.0F);
/* 395:376 */       GL11.glRotatef(-mc.thePlayer.rotationYaw, 0.0F, 0.0F, 1.0F);
/* 396:    */     }
/* 397:378 */     GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
/* 398:379 */     float f = (c >> 24 & 0xFF) / 255.0F;
/* 399:380 */     float f1 = (c >> 16 & 0xFF) / 255.0F;
/* 400:381 */     float f2 = (c >> 8 & 0xFF) / 255.0F;
/* 401:382 */     float f3 = (c & 0xFF) / 255.0F;
/* 402:383 */     GL11.glColor4f(f1, f2, f3, f);
/* 403:384 */     GL11.glEnable(3042);
/* 404:385 */     GL11.glDisable(3553);
/* 405:386 */     GL11.glEnable(2848);
/* 406:387 */     GL11.glBlendFunc(770, 771);
/* 407:388 */     GL11.glBegin(4);
/* 408:389 */     GL11.glVertex2d(cx, cy + 3);
/* 409:390 */     GL11.glVertex2d(cx + 3, cy - 3);
/* 410:391 */     GL11.glVertex2d(cx - 3, cy - 3);
/* 411:392 */     GL11.glEnd();
/* 412:393 */     GL11.glDisable(2848);
/* 413:394 */     GL11.glEnable(3553);
/* 414:395 */     GL11.glDisable(3042);
/* 415:396 */     GL11.glRotatef(-180.0F, 0.0F, 0.0F, 1.0F);
/* 416:397 */     if (!mod_RadarBro.RadarAutoRotate) {
/* 417:398 */       GL11.glPopMatrix();
/* 418:    */     }
/* 419:    */   }
/* 420:    */   
/* 421:    */   private void setColorizedColor(int color)
/* 422:    */   {
/* 423:403 */     float alpha = (color >> 24 & 0xFF) / 255.0F;
/* 424:404 */     float red = (color >> 16 & 0xFF) / 255.0F;
/* 425:405 */     float green = (color >> 8 & 0xFF) / 255.0F;
/* 426:406 */     float blue = (color & 0xFF) / 255.0F;
/* 427:407 */     GL11.glColor4f(red, green, blue, alpha);
/* 428:    */   }
/* 429:    */   
/* 430:    */   public void renderTerrain() {}
/* 431:    */   
/* 432:    */   public void drawIconRadarIcon(int x, int y, int x2, int y2)
/* 433:    */   {
/* 434:416 */     this.textureManager.bindTexture(radaricons);
/* 435:417 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 436:418 */     GL11.glEnable(3042);
/* 437:419 */     GL11.glPushMatrix();
/* 438:420 */     GL11.glScalef(0.5F, 0.5F, 0.5F);
/* 439:421 */     GL11.glTranslatef(x + 1, y + 1, 0.0F);
/* 440:422 */     if (mod_RadarBro.RadarAutoRotate) {
/* 441:423 */       GL11.glRotatef(mc.thePlayer.rotationYaw, 0.0F, 0.0F, 1.0F);
/* 442:    */     }
/* 443:424 */     drawTexturedModalRect(-8, -8, x2, y2, 16, 16);
/* 444:425 */     GL11.glTranslatef(-x - 1, -y - 1, 0.0F);
/* 445:426 */     GL11.glScalef(2.0F, 2.0F, 2.0F);
/* 446:427 */     GL11.glDisable(2896);
/* 447:428 */     GL11.glDisable(3042);
/* 448:429 */     GL11.glPopMatrix();
/* 449:    */   }
/* 450:    */   
/* 451:    */   public void drawIconRadarItemIcon(int x, int y, ItemStack is)
/* 452:    */   {
/* 453:433 */     GL11.glPushMatrix();
/* 454:434 */     GL11.glScalef(0.5F, 0.5F, 0.5F);
/* 455:435 */     GL11.glTranslatef(x + 1, y + 1, 0.0F);
/* 456:436 */     if (mod_RadarBro.RadarAutoRotate) {
/* 457:437 */       GL11.glRotatef(mc.thePlayer.rotationYaw, 0.0F, 0.0F, 1.0F);
/* 458:    */     }
/* 459:438 */     mod_RadarBro.itemRenderer.renderItemIntoGUI(mc.fontRenderer, this.textureManager, is, -8, -8);
/* 460:439 */     GL11.glTranslatef(-x - 1, -y - 1, 0.0F);
/* 461:440 */     GL11.glScalef(2.0F, 2.0F, 2.0F);
/* 462:441 */     GL11.glDisable(2896);
/* 463:442 */     GL11.glPopMatrix();
/* 464:    */   }
/* 465:    */   
/* 466:    */   public void drawIconRadarWaypointIcon(int x, int y)
/* 467:    */   {
/* 468:446 */     this.textureManager.bindTexture(radaricons);
/* 469:447 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 470:448 */     GL11.glPushMatrix();
/* 471:449 */     GL11.glScalef(0.5F, 0.5F, 0.5F);
/* 472:450 */     GL11.glTranslatef(x + 1, y + 1, 0.0F);
/* 473:451 */     if (mod_RadarBro.RadarAutoRotate) {
/* 474:452 */       GL11.glRotatef(-mc.thePlayer.rotationYaw / 180.0F - 180.0F, 0.0F, 0.0F, 1.0F);
/* 475:    */     }
/* 476:453 */     drawTexturedModalRect(-8, 0, 48, 32, 16, 16);
/* 477:454 */     GL11.glTranslatef(-x - 1, -y - 1, 0.0F);
/* 478:455 */     GL11.glScalef(2.0F, 2.0F, 2.0F);
/* 479:456 */     GL11.glDisable(2896);
/* 480:457 */     GL11.glPopMatrix();
/* 481:    */   }
/* 482:    */   
/* 483:    */   public void drawRadarNames(int x, int y, String username)
/* 484:    */   {
/* 485:461 */     GL11.glPushMatrix();
/* 486:462 */     GL11.glScalef(0.5F, 0.5F, 0.5F);
/* 487:463 */     GL11.glTranslatef(x, y, 0.0F);
/* 488:464 */     if (mod_RadarBro.RadarAutoRotate) {
/* 489:465 */       GL11.glRotatef(mc.thePlayer.rotationYaw, 0.0F, 0.0F, 1.0F);
/* 490:    */     }
/* 491:467 */     GL11.glTranslatef(-x, -y, 0.0F);
/* 492:468 */     FontRenderer fontrenderer = mc.fontRenderer;
/* 493:469 */     if (mod_RadarBro.AllyList.contains(username))
/* 494:    */     {
/* 495:470 */       drawCenteredString(fontrenderer, username, x, y - 18, 3665978);
/* 496:    */     }
/* 497:472 */     else if (mod_RadarBro.EnemyList.contains(username))
/* 498:    */     {
/* 499:473 */       drawCenteredString(fontrenderer, username, x, y - 18, 15742782);
/* 500:    */     }
/* 501:475 */     else if (mod_RadarBro.RadarColorPlayerNames)
/* 502:    */     {
/* 503:476 */       drawCenteredString(fontrenderer, username, x, y - 18, 14737632);
/* 504:    */     }
/* 505:    */     else
/* 506:    */     {
/* 507:478 */       if (username.contains("??")) {
/* 508:479 */         username = username.substring(2);
/* 509:    */       }
/* 510:481 */       drawCenteredString(fontrenderer, username, x, y - 18, 14737632);
/* 511:    */     }
/* 512:484 */     GL11.glScalef(2.0F, 2.0F, 2.0F);
/* 513:485 */     GL11.glPopMatrix();
/* 514:    */   }
/* 515:    */   
/* 516:    */   public void drawPlayerHeadImage(BufferedImage bufferedimage, int x, int y)
/* 517:    */   {
/* 518:489 */     DynamicTexture previewTexture = new DynamicTexture(bufferedimage);
/* 519:490 */     ResourceLocation resourceLocation = mc.getTextureManager().getDynamicTextureLocation("preivew", previewTexture);
/* 520:491 */     mc.getTextureManager().bindTexture(resourceLocation);
/* 521:492 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 522:493 */     GL11.glPushMatrix();
/* 523:494 */     drawTexturedModalRect(x, y, 0, 0, 32, 32);
/* 524:495 */     GL11.glPopMatrix();
/* 525:    */   }
/* 526:    */   
/* 527:    */   public static BufferedImage generatePlayerHeadImage(String username)
/* 528:    */   {
/* 529:499 */     if (username.contains("§")) {
/* 530:500 */       username = username.substring(2);
/* 531:    */     }
/* 532:502 */     String skinURL = "http://s3.amazonaws.com/MinecraftSkins/" + username + ".png";
/* 533:503 */     if (!mod_RadarBro.HeadIconCache.containsKey(skinURL)) {
/* 534:504 */       mod_RadarBro.HeadIconCache.put(skinURL, null);
/* 535:    */     }
/* 536:506 */     URL url = null;
/* 537:    */     try
/* 538:    */     {
/* 539:508 */       url = new URL(skinURL);
/* 540:    */     }
/* 541:    */     catch (MalformedURLException e1)
/* 542:    */     {
/* 543:510 */       e1.printStackTrace();
/* 544:    */     }
/* 545:512 */     BufferedImage bufferedimage = mod_RadarBro.getIconFromCache(skinURL);
/* 546:513 */     if (bufferedimage == null)
/* 547:    */     {
/* 548:514 */       BufferedImage playerSkin = null;
/* 549:    */       try
/* 550:    */       {
/* 551:517 */         playerSkin = ImageIO.read(url);
/* 552:    */         
/* 553:519 */         BufferedImage playerHead = playerSkin.getSubimage(8, 8, 8, 8);
/* 554:520 */         BufferedImage playerBody = new BufferedImage(256, 256, 2);
/* 555:521 */         Graphics g = playerBody.getGraphics();
/* 556:522 */         g.drawImage(playerHead, 0, 0, null);
/* 557:523 */         mod_RadarBro.HeadIconCache.remove(skinURL);
/* 558:524 */         mod_RadarBro.HeadIconCache.put(skinURL, playerBody);
/* 559:525 */         return playerBody;
/* 560:    */       }
/* 561:    */       catch (IOException e)
/* 562:    */       {
/* 563:527 */         BufferedImage bi = null;
/* 564:    */         try
/* 565:    */         {
/* 566:529 */           bi = ImageIO.read(mc.getResourceManager().getResource(AbstractClientPlayer.locationStevePng).getInputStream());
/* 567:530 */           BufferedImage playerHead = bi.getSubimage(8, 8, 8, 8);
/* 568:531 */           BufferedImage playerBody = new BufferedImage(256, 256, 2);
/* 569:532 */           Graphics g = playerBody.getGraphics();
/* 570:533 */           g.drawImage(playerHead, 0, 0, null);
/* 571:534 */           mod_RadarBro.HeadIconCache.remove(skinURL);
/* 572:535 */           mod_RadarBro.HeadIconCache.put(skinURL, playerBody);
/* 573:536 */           return playerBody;
/* 574:    */         }
/* 575:    */         catch (Exception e1)
/* 576:    */         {
/* 577:538 */           e1.printStackTrace();
/* 578:    */         }
/* 579:    */       }
/* 580:    */     }
/* 581:    */     else
/* 582:    */     {
/* 583:542 */       return bufferedimage;
/* 584:    */     }
/* 585:544 */     return bufferedimage;
/* 586:    */   }
/* 587:    */ }


/* Location:           C:\Users\Admin\Downloads\RadarBroDecompiled.jar
 * Qualified Name:     com.calialec.radarbro.GuiRadarBro
 * JD-Core Version:    0.7.1
 */