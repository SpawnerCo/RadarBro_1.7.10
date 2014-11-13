/*   1:    */ package com.calialec.radarbro;
/*   2:    */ 
/*   3:    */ import cpw.mods.fml.client.registry.ClientRegistry;
/*   4:    */ import cpw.mods.fml.common.FMLCommonHandler;
/*   5:    */ import cpw.mods.fml.common.Mod;
/*   6:    */ import cpw.mods.fml.common.Mod.EventHandler;
/*   7:    */ import cpw.mods.fml.common.Mod.Instance;
/*   8:    */ import cpw.mods.fml.common.event.FMLInitializationEvent;
/*   9:    */ import cpw.mods.fml.common.event.FMLPostInitializationEvent;
/*  10:    */ import cpw.mods.fml.common.eventhandler.EventBus;
/*  11:    */ import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
/*  12:    */ import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent;

/*  13:    */ import java.awt.image.BufferedImage;
/*  14:    */ import java.io.BufferedReader;
/*  15:    */ import java.io.BufferedWriter;
/*  16:    */ import java.io.File;
/*  17:    */ import java.io.FileReader;
/*  18:    */ import java.io.FileWriter;
/*  19:    */ import java.io.PrintStream;
/*  20:    */ import java.io.PrintWriter;
/*  21:    */ import java.util.ArrayList;
/*  22:    */ import java.util.HashMap;
/*  23:    */ import java.util.List;

/*  24:    */ import net.minecraft.client.Minecraft;
/*  25:    */ import net.minecraft.client.renderer.entity.RenderItem;
/*  26:    */ import net.minecraft.client.settings.KeyBinding;
/*  27:    */ import net.minecraft.nbt.CompressedStreamTools;
/*  28:    */ import net.minecraft.nbt.NBTTagCompound;
/*  29:    */ import net.minecraft.nbt.NBTTagList;
/*  30:    */ import net.minecraftforge.common.MinecraftForge;
/*  31:    */ 
/*  32:    */ @Mod(modid="mod_RadarBro", name="RadarBro", version="v1337.69")
/*  33:    */ public class mod_RadarBro
/*  34:    */ {
/*  35:    */   public static final String ID = "mod_RadarBro";
/*  36:    */   public static final String NAME = "RadarBro";
/*  37:    */   public static final String VERSION = "v1337.69";
/*  38:    */   public static Minecraft mc;
/*  39: 45 */   public KeyBinding GUIkey = new KeyBinding("RadarBro Settings", 19, "RadarBro Settings");
/*  40: 46 */   protected static RenderItem itemRenderer = new RenderItem();
/*  41: 48 */   public static ArrayList AllyList = new ArrayList();
/*  42: 49 */   public static ArrayList EnemyList = new ArrayList();
/*  43: 50 */   public static ArrayList Waypoints = new ArrayList();
/*  44: 51 */   public static HashMap<String, BufferedImage> HeadIconCache = new HashMap();
/*  45: 52 */   public static HashMap<String, String> WaypointLastInRangePosition = new HashMap();
/*  46:    */   private static File settingsFile;
/*  47: 55 */   public static boolean RadarEnabled = true;
/*  48: 56 */   public static boolean RadarPlayerNames = true;
/*  49: 57 */   public static boolean RadarColorPlayerNames = true;
/*  50: 58 */   public static boolean RadarUsePlayerSkinTexture = false;
/*  51: 59 */   public static boolean RadarAutoRotate = true;
/*  52: 60 */   public static boolean RadarTerrain = false;
/*  53: 61 */   public static boolean RadarCoordinates = true;
/*  54: 63 */   public static boolean RadarBat = true;
/*  55: 64 */   public static boolean RadarChicken = true;
/*  56: 65 */   public static boolean RadarCow = true;
/*  57: 66 */   public static boolean RadarMooshroom = true;
/*  58: 67 */   public static boolean RadarOcelot = true;
/*  59: 68 */   public static boolean RadarPig = true;
/*  60: 69 */   public static boolean RadarSheep = true;
/*  61: 70 */   public static boolean RadarSnowGolem = true;
/*  62: 71 */   public static boolean RadarSquid = true;
/*  63: 72 */   public static boolean RadarVillager = true;
/*  64: 74 */   public static boolean RadarBlaze = true;
/*  65: 75 */   public static boolean RadarCaveSpider = true;
/*  66: 76 */   public static boolean RadarCreeper = true;
/*  67: 77 */   public static boolean RadarEnderdragon = true;
/*  68: 78 */   public static boolean RadarGhast = true;
/*  69: 79 */   public static boolean RadarMagmaCube = true;
/*  70: 80 */   public static boolean RadarSilverfish = true;
/*  71: 81 */   public static boolean RadarSkeleton = true;
/*  72: 82 */   public static boolean RadarSlime = true;
/*  73: 83 */   public static boolean RadarSpider = true;
/*  74: 84 */   public static boolean RadarWitch = true;
/*  75: 85 */   public static boolean RadarWither = true;
/*  76: 86 */   public static boolean RadarZombie = true;
/*  77: 88 */   public static boolean RadarEnderman = true;
/*  78: 89 */   public static boolean RadarIronGolem = true;
/*  79: 90 */   public static boolean RadarWolf = true;
/*  80: 91 */   public static boolean RadarZombiePigman = true;
/*  81: 93 */   public static boolean RadarArrow = true;
/*  82: 94 */   public static boolean RadarBoat = true;
/*  83: 95 */   public static boolean RadarChest = true;
/*  84: 96 */   public static boolean RadarItem = true;
/*  85: 97 */   public static boolean RadarMinecart = true;
/*  86: 98 */   public static boolean RadarMonsterSpawner = true;
/*  87: 99 */   public static boolean RadarPainting = true;
/*  88:100 */   public static boolean RadarWaypoint = true;
/*  89:101 */   public static boolean RadarXPOrb = true;
/*  90:103 */   public static boolean RadarPlayer = true;
/*  91:104 */   public static boolean RadarAlly = true;
/*  92:105 */   public static boolean RadarEnemy = true;
/*  93:    */   public static String radarBroDir;
/*  94:    */   @Mod.Instance("mod_RadarBro")
/*  95:    */   public static mod_RadarBro instance;
/*  96:    */   
/*  97:    */   @Mod.EventHandler
/*  98:    */   public void postInit(FMLPostInitializationEvent event)
/*  99:    */   {
/* 100:114 */     MinecraftForge.EVENT_BUS.register(new GuiRadarBro(Minecraft.getMinecraft()));
/* 101:115 */     FMLCommonHandler.instance().bus().register(this);
/* 102:    */   }
/* 103:    */   
/* 104:    */   @Mod.EventHandler
/* 105:    */   public void load(FMLInitializationEvent event)
/* 106:    */   {
/* 107:120 */     mc = Minecraft.getMinecraft();
/* 108:121 */     ClientRegistry.registerKeyBinding(this.GUIkey);
/* 109:122 */     radarBroDir = Minecraft.getMinecraft().mcDataDir + File.separator + "mods" + File.separator + "RadarBro";
/* 110:123 */     settingsFile = new File(radarBroDir + File.separator + "settings.txt");
/* 111:124 */     loadOptions();
/* 112:125 */     loadAllyList();
/* 113:126 */     loadEnemyList();
/* 114:127 */     loadWaypointList();
/* 115:    */   }
/* 116:    */   
/* 117:    */   @SubscribeEvent
/* 118:    */   public void onKeyInput(InputEvent.KeyInputEvent event)
/* 119:    */   {
/* 120:132 */     if (this.GUIkey.isPressed()) {
/* 121:133 */       Minecraft.getMinecraft().displayGuiScreen(new GuiRadarBroSettings(null));
/* 122:    */     }
/* 123:    */   }
/* 124:    */   
/* 125:    */   public static BufferedImage getIconFromCache(String url)
/* 126:    */   {
/* 127:138 */     BufferedImage bufferedimage = (BufferedImage)HeadIconCache.get(url);
/* 128:139 */     if (bufferedimage != null) {
/* 129:140 */       return bufferedimage;
/* 130:    */     }
/* 131:142 */     return null;
/* 132:    */   }
/* 133:    */   
/* 134:    */   public void loadWaypointList()
/* 135:    */   {
/* 136:    */     try
/* 137:    */     {
/* 138:148 */       NBTTagCompound nbttagcompound = CompressedStreamTools.read(new File(radarBroDir, "waypoints.dat"));
/* 139:149 */       NBTTagList nbttaglist = nbttagcompound.getTagList("waypoints", 0);
/* 140:151 */       for (int i = 0; i < nbttaglist.tagCount(); i++) {
/* 141:153 */         WaypointNBTStorage.createWaypointNBTStorage(nbttaglist.getCompoundTagAt(i));
/* 142:    */       }
/* 143:    */     }
/* 144:    */     catch (Exception exception) {}
/* 145:    */   }
/* 146:    */   
/* 147:    */   public static void loadAllyList()
/* 148:    */   {
/* 149:    */     try
/* 150:    */     {
/* 151:164 */       int[] ai = new int[512];
/* 152:165 */       File file = new File(radarBroDir, "AllyList.txt");
/* 153:166 */       if (file.exists())
/* 154:    */       {
/* 155:168 */         BufferedReader bufferedreader = new BufferedReader(new FileReader(file));
/* 156:    */         String s;
/* 157:170 */         for (int i = 0; (s = bufferedreader.readLine()) != null; i++)
/* 158:    */         {
/* 159:172 */           AllyList.add(s);
/* 160:173 */           GuiAllyEnemyManager.currentList.add(s);
/* 161:    */         }
/* 162:175 */         bufferedreader.close();
/* 163:    */       }
/* 164:    */     }
/* 165:    */     catch (Exception exception)
/* 166:    */     {
/* 167:180 */       System.err.print(exception.toString());
/* 168:    */     }
/* 169:    */   }
/* 170:    */   
/* 171:    */   public static void loadEnemyList()
/* 172:    */   {
/* 173:    */     try
/* 174:    */     {
/* 175:187 */       int[] ai = new int[512];
/* 176:188 */       File file = new File(radarBroDir, "EnemyList.txt");
/* 177:189 */       if (file.exists())
/* 178:    */       {
/* 179:191 */         BufferedReader bufferedreader = new BufferedReader(new FileReader(file));
/* 180:    */         String s;
/* 181:193 */         for (int i = 0; (s = bufferedreader.readLine()) != null; i++)
/* 182:    */         {
/* 183:195 */           EnemyList.add(s);
/* 184:196 */           GuiAllyEnemyManager.currentList.add(s);
/* 185:    */         }
/* 186:198 */         bufferedreader.close();
/* 187:    */       }
/* 188:    */     }
/* 189:    */     catch (Exception exception)
/* 190:    */     {
/* 191:203 */       System.err.print(exception.toString());
/* 192:    */     }
/* 193:    */   }
/* 194:    */   
/* 195:    */   public static void saveAllyList()
/* 196:    */   {
/* 197:    */     try
/* 198:    */     {
/* 199:210 */       new File(radarBroDir).mkdirs();
/* 200:211 */       File file = new File(radarBroDir, "AllyList.txt");
/* 201:212 */       BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(file));
/* 202:213 */       for (int i = 0; i < AllyList.size(); i++) {
/* 203:215 */         bufferedwriter.write((String)AllyList.get(i) + "\r\n");
/* 204:    */       }
/* 205:217 */       bufferedwriter.close();
/* 206:    */     }
/* 207:    */     catch (Exception exception)
/* 208:    */     {
/* 209:221 */       System.err.print(exception.toString());
/* 210:    */     }
/* 211:    */   }
/* 212:    */   
/* 213:    */   public static void saveEnemyList()
/* 214:    */   {
/* 215:    */     try
/* 216:    */     {
/* 217:228 */       new File(radarBroDir).mkdirs();
/* 218:229 */       File file = new File(radarBroDir, "EnemyList.txt");
/* 219:230 */       BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(file));
/* 220:231 */       for (int i = 0; i < EnemyList.size(); i++) {
/* 221:233 */         bufferedwriter.write((String)EnemyList.get(i) + "\r\n");
/* 222:    */       }
/* 223:235 */       bufferedwriter.close();
/* 224:    */     }
/* 225:    */     catch (Exception exception)
/* 226:    */     {
/* 227:239 */       System.err.print(exception.toString());
/* 228:    */     }
/* 229:    */   }
/* 230:    */   
/* 231:    */   public static void loadOptions()
/* 232:    */   {
/* 233:    */     try
/* 234:    */     {
/* 235:246 */       new File(radarBroDir).mkdirs();
/* 236:247 */       if (!settingsFile.exists()) {
/* 237:249 */         return;
/* 238:    */       }
/* 239:251 */       BufferedReader bufferedreader = new BufferedReader(new FileReader(settingsFile));
/* 240:252 */       for (String s = ""; (s = bufferedreader.readLine()) != null;) {
/* 241:    */         try
/* 242:    */         {
/* 243:256 */           String[] as = s.split(":");
/* 244:258 */           if (as[0].equals("radar_Bat")) {
/* 245:260 */             RadarBat = as[1].equals("true");
/* 246:    */           }
/* 247:262 */           if (as[0].equals("radar_Chicken")) {
/* 248:264 */             RadarChicken = as[1].equals("true");
/* 249:    */           }
/* 250:266 */           if (as[0].equals("radar_Cow")) {
/* 251:268 */             RadarCow = as[1].equals("true");
/* 252:    */           }
/* 253:270 */           if (as[0].equals("radar_Mooshroom")) {
/* 254:272 */             RadarMooshroom = as[1].equals("true");
/* 255:    */           }
/* 256:274 */           if (as[0].equals("radar_Ocelot")) {
/* 257:276 */             RadarOcelot = as[1].equals("true");
/* 258:    */           }
/* 259:278 */           if (as[0].equals("radar_Pig")) {
/* 260:280 */             RadarPig = as[1].equals("true");
/* 261:    */           }
/* 262:282 */           if (as[0].equals("radar_Sheep")) {
/* 263:284 */             RadarSheep = as[1].equals("true");
/* 264:    */           }
/* 265:286 */           if (as[0].equals("radar_SnowGolem")) {
/* 266:288 */             RadarSnowGolem = as[1].equals("true");
/* 267:    */           }
/* 268:290 */           if (as[0].equals("radar_Squid")) {
/* 269:292 */             RadarSquid = as[1].equals("true");
/* 270:    */           }
/* 271:294 */           if (as[0].equals("radar_Villager")) {
/* 272:296 */             RadarVillager = as[1].equals("true");
/* 273:    */           }
/* 274:298 */           if (as[0].equals("radar_Blaze")) {
/* 275:300 */             RadarBlaze = as[1].equals("true");
/* 276:    */           }
/* 277:302 */           if (as[0].equals("radar_CaveSpider")) {
/* 278:304 */             RadarCaveSpider = as[1].equals("true");
/* 279:    */           }
/* 280:306 */           if (as[0].equals("radar_Creeper")) {
/* 281:308 */             RadarCreeper = as[1].equals("true");
/* 282:    */           }
/* 283:310 */           if (as[0].equals("radar_Enderdragon")) {
/* 284:312 */             RadarEnderdragon = as[1].equals("true");
/* 285:    */           }
/* 286:314 */           if (as[0].equals("radar_Ghast")) {
/* 287:316 */             RadarGhast = as[1].equals("true");
/* 288:    */           }
/* 289:318 */           if (as[0].equals("radar_MagmaCube")) {
/* 290:320 */             RadarMagmaCube = as[1].equals("true");
/* 291:    */           }
/* 292:322 */           if (as[0].equals("radar_Silverfish")) {
/* 293:324 */             RadarSilverfish = as[1].equals("true");
/* 294:    */           }
/* 295:326 */           if (as[0].equals("radar_Skeleton")) {
/* 296:328 */             RadarSkeleton = as[1].equals("true");
/* 297:    */           }
/* 298:330 */           if (as[0].equals("radar_Slime")) {
/* 299:332 */             RadarSlime = as[1].equals("true");
/* 300:    */           }
/* 301:334 */           if (as[0].equals("radar_Spider")) {
/* 302:336 */             RadarSpider = as[1].equals("true");
/* 303:    */           }
/* 304:338 */           if (as[0].equals("radar_Witch")) {
/* 305:340 */             RadarWitch = as[1].equals("true");
/* 306:    */           }
/* 307:342 */           if (as[0].equals("radar_Wither")) {
/* 308:344 */             RadarWither = as[1].equals("true");
/* 309:    */           }
/* 310:346 */           if (as[0].equals("radar_Zombie")) {
/* 311:348 */             RadarZombie = as[1].equals("true");
/* 312:    */           }
/* 313:350 */           if (as[0].equals("radar_Enderman")) {
/* 314:352 */             RadarEnderman = as[1].equals("true");
/* 315:    */           }
/* 316:354 */           if (as[0].equals("radar_IronGolem")) {
/* 317:356 */             RadarIronGolem = as[1].equals("true");
/* 318:    */           }
/* 319:358 */           if (as[0].equals("radar_Wolf")) {
/* 320:360 */             RadarWolf = as[1].equals("true");
/* 321:    */           }
/* 322:362 */           if (as[0].equals("radar_ZombiePigman")) {
/* 323:364 */             RadarZombiePigman = as[1].equals("true");
/* 324:    */           }
/* 325:366 */           if (as[0].equals("radar_Arrow")) {
/* 326:368 */             RadarArrow = as[1].equals("true");
/* 327:    */           }
/* 328:370 */           if (as[0].equals("radar_Boat")) {
/* 329:372 */             RadarBoat = as[1].equals("true");
/* 330:    */           }
/* 331:374 */           if (as[0].equals("radar_Chest")) {
/* 332:376 */             RadarChest = as[1].equals("true");
/* 333:    */           }
/* 334:378 */           if (as[0].equals("radar_Item")) {
/* 335:380 */             RadarItem = as[1].equals("true");
/* 336:    */           }
/* 337:382 */           if (as[0].equals("radar_Minecart")) {
/* 338:384 */             RadarMinecart = as[1].equals("true");
/* 339:    */           }
/* 340:386 */           if (as[0].equals("radar_Painting")) {
/* 341:388 */             RadarPainting = as[1].equals("true");
/* 342:    */           }
/* 343:390 */           if (as[0].equals("radar_MonsterSpawner")) {
/* 344:392 */             RadarMonsterSpawner = as[1].equals("true");
/* 345:    */           }
/* 346:394 */           if (as[0].equals("radar_Waypoint")) {
/* 347:396 */             RadarWaypoint = as[1].equals("true");
/* 348:    */           }
/* 349:398 */           if (as[0].equals("radar_XPOrb")) {
/* 350:400 */             RadarXPOrb = as[1].equals("true");
/* 351:    */           }
/* 352:402 */           if (as[0].equals("radar_Player")) {
/* 353:404 */             RadarPlayer = as[1].equals("true");
/* 354:    */           }
/* 355:406 */           if (as[0].equals("radar_Ally")) {
/* 356:408 */             RadarAlly = as[1].equals("true");
/* 357:    */           }
/* 358:410 */           if (as[0].equals("radar_Enemy")) {
/* 359:412 */             RadarEnemy = as[1].equals("true");
/* 360:    */           }
/* 361:414 */           if (as[0].equals("radar_Terrain")) {
/* 362:416 */             RadarTerrain = as[1].equals("true");
/* 363:    */           }
/* 364:418 */           if (as[0].equals("radar_Coordinates")) {
/* 365:420 */             RadarCoordinates = as[1].equals("true");
/* 366:    */           }
/* 367:422 */           if (as[0].equals("radar_xOffset")) {
/* 368:424 */             GuiRepositionRadarBro.xEndDisplacement = Integer.parseInt(as[1]);
/* 369:    */           }
/* 370:426 */           if (as[0].equals("radar_yOffset")) {
/* 371:428 */             GuiRepositionRadarBro.yEndDisplacement = Integer.parseInt(as[1]);
/* 372:    */           }
/* 373:    */         }
/* 374:    */         catch (Exception exception1)
/* 375:    */         {
/* 376:434 */           System.out.println("Skipping bad setting: " + s);
/* 377:    */         }
/* 378:    */       }
/* 379:438 */       bufferedreader.close();
/* 380:    */     }
/* 381:    */     catch (Exception exception)
/* 382:    */     {
/* 383:442 */       System.out.println("Failed to load settings");
/* 384:443 */       exception.printStackTrace();
/* 385:    */     }
/* 386:    */   }
/* 387:    */   
/* 388:    */   public static void saveOptions()
/* 389:    */   {
/* 390:    */     try
/* 391:    */     {
/* 392:450 */       PrintWriter printwriter = new PrintWriter(new FileWriter(settingsFile));
/* 393:451 */       printwriter.println("radar_Bat:" + RadarBat);
/* 394:452 */       printwriter.println("radar_Chicken:" + RadarChicken);
/* 395:453 */       printwriter.println("radar_Cow:" + RadarCow);
/* 396:454 */       printwriter.println("radar_Mooshroom:" + RadarMooshroom);
/* 397:455 */       printwriter.println("radar_Ocelot:" + RadarOcelot);
/* 398:456 */       printwriter.println("radar_Pig:" + RadarPig);
/* 399:457 */       printwriter.println("radar_Sheep:" + RadarSheep);
/* 400:458 */       printwriter.println("radar_SnowGolem:" + RadarSnowGolem);
/* 401:459 */       printwriter.println("radar_Squid:" + RadarSquid);
/* 402:460 */       printwriter.println("radar_Villager:" + RadarVillager);
/* 403:461 */       printwriter.println("radar_Blaze:" + RadarBlaze);
/* 404:462 */       printwriter.println("radar_CaveSpider:" + RadarCaveSpider);
/* 405:463 */       printwriter.println("radar_Creeper:" + RadarCreeper);
/* 406:464 */       printwriter.println("radar_Enderdragon:" + RadarEnderdragon);
/* 407:465 */       printwriter.println("radar_Ghast:" + RadarGhast);
/* 408:466 */       printwriter.println("radar_MagmaCube:" + RadarMagmaCube);
/* 409:467 */       printwriter.println("radar_Silverfish:" + RadarSilverfish);
/* 410:468 */       printwriter.println("radar_Skeleton:" + RadarSkeleton);
/* 411:469 */       printwriter.println("radar_Slime:" + RadarSlime);
/* 412:470 */       printwriter.println("radar_Spider:" + RadarSpider);
/* 413:471 */       printwriter.println("radar_Witch:" + RadarWitch);
/* 414:472 */       printwriter.println("radar_Wither:" + RadarWither);
/* 415:473 */       printwriter.println("radar_Zombie:" + RadarZombie);
/* 416:474 */       printwriter.println("radar_Enderman:" + RadarEnderman);
/* 417:475 */       printwriter.println("radar_IronGolem:" + RadarIronGolem);
/* 418:476 */       printwriter.println("radar_Wolf:" + RadarWolf);
/* 419:477 */       printwriter.println("radar_ZombiePigman:" + RadarZombiePigman);
/* 420:478 */       printwriter.println("radar_Arrow:" + RadarArrow);
/* 421:479 */       printwriter.println("radar_Boat:" + RadarBoat);
/* 422:480 */       printwriter.println("radar_Chest:" + RadarChest);
/* 423:481 */       printwriter.println("radar_Item:" + RadarItem);
/* 424:482 */       printwriter.println("radar_Minecart:" + RadarMinecart);
/* 425:483 */       printwriter.println("radar_Painting:" + RadarPainting);
/* 426:484 */       printwriter.println("radar_MonsterSpawner:" + RadarMonsterSpawner);
/* 427:485 */       printwriter.println("radar_Waypoint:" + RadarWaypoint);
/* 428:486 */       printwriter.println("radar_XPOrb:" + RadarXPOrb);
/* 429:487 */       printwriter.println("radar_Player:" + RadarPlayer);
/* 430:488 */       printwriter.println("radar_Ally:" + RadarAlly);
/* 431:489 */       printwriter.println("radar_Enemy:" + RadarEnemy);
/* 432:490 */       printwriter.println("radar_Terrain:" + RadarTerrain);
/* 433:491 */       printwriter.println("radar_Coordinates:" + RadarCoordinates);
/* 434:492 */       printwriter.println("radar_xOffset:" + GuiRepositionRadarBro.xEndDisplacement);
/* 435:493 */       printwriter.println("radar_yOffset:" + GuiRepositionRadarBro.yEndDisplacement);
/* 436:494 */       printwriter.close();
/* 437:    */     }
/* 438:    */     catch (Exception exception)
/* 439:    */     {
/* 440:498 */       System.out.println("Failed to save settings");
/* 441:499 */       exception.printStackTrace();
/* 442:    */     }
/* 443:    */   }
/* 444:    */ }


/* Location:           C:\Users\Admin\Downloads\RadarBroDecompiled.jar
 * Qualified Name:     com.calialec.radarbro.mod_RadarBro
 * JD-Core Version:    0.7.1
 */