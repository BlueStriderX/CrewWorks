package crewworks.thederpgamer.main;

import java.util.ArrayList;
import thederpgamer.libraries.tools;
//import block api

public class crewHandler {
  public static void npcMove(Entity npc) {
    /** makes an npc move along a path */
    ArrayList<Location> pathBlock = new ArrayList<Location>();
    for(x = 0, x == pathBlock.size(), x++) {
      Location currentBlock = pathBlock.get(x);
      npc.moveTo(currentBlock);
    }
  }

  public static void npcActivate(Entity npc, Block target) {
    /** makes an npc activate a logic block */
    Location npcLocation = npc.getLocation();
    Block block1 = getBlockAt(npcLocation);
    Block block2 = target;
    float distance = tools.getDistance(block1, block2);
    Entity entity = target.getEntity();
    if(distance > 3) {
      npc.sendControllerMessage("I can't reach the target!");
      return;
    }
    if(entity.getBlockAt(target) == Block.ACTIVATION_MODULE || entity.getBlockAt(target) == Block.BUTTON || entity.getBlockAt(target) == Block.SMALL_ACTIVATION_MODULE || entity.getBlockAt(target) == Block.SMALL_BUTTON) {
      target.setActivated(true);
    }
  }

  public static void npcAction(Entity npc, String action, Block target, float percent, String buff) {
    /** makes an npc perform a specified action */
    if(action == "ACTIVATE_LOGIC") {
      npcMove(npc);
      npcActivate(npc, target);
    } else if(action == "BUFF_SYSTEM")  {
      npcMove(npc);
      npcBuffSystem(npc, target, percent);
    } else if(action == "BUFF_WEAPON") {
      npcMove(npc);
      npcBuffWeapon(npc, target, percent, buff);
    } else if(action == "BUFF_TURRET") {
      npcMove(npc);
      npcBuffTurret(npc, target, percent, buff);
    }
  }

  public static void npcBuffSystem(Entity npc, Block target, float percent) {
    /** makes an npc buff a specified system */
    Entity entity = target.getEntity();
    Block block = entity.getBlockAt(target);
    if(target == Block.POWER_REACTOR) {
      entity.effect.system.addPowerRegen(percent);
      entity.effect.system.addPowerCapacity(percent * -0.25);
    } else if(target == Block.POWER_STABILIZER) {
      entity.effect.system.addPowerCapacity(percent);
      entity.effect.system.addPowerRegen(percent * -0.25);
    } else if(target == Block.SHIELD_REGENERATOR) {
      entity.effect.system.addShieldRegen(percent);
      entity.effect.system.addShieldCapacity(percent * -0.25);
    } else if(target == Block.SHIELD_CAPACITOR) {
      entity.effect.system.addShieldCapacity(percent);
      entity.effect.system.addShieldRegen(percent * -0.25);
    } else {
      npc.sendControllerMessage("There's nothing I can do with this system!");
    }
  }
  public static void npcBuffWeapon(Entity npc, Block target, float percent, String buff) {
    /** makes an npc buff a specified weapon */
    Entity entity = target.getEntity();
    Block block = entity.getBlockAt(target);
    if(target == Block.CANNON_COMPUTER) {
      if(buff == "BUFF_RELOAD") { //buff cannon reload speed
        entity.effect.weapon.addReloadSpeed(percent);
        entity.effect.weapon.addDamage(percent * -0.25);
      } else if(buff == "BUFF_DAMAGE") { //buff cannon damage
        entity.effect.weapon.addDamage(percent);
        entity.effect.weapon.addProjectileSpeed(percent * -0.25);
      } else if(buff == "BUFF_SPEED") {
        entity.effect.weapon.addProjectileSpeed(percent); // buff cannon projectile speed
        entity.effect.weapon.addDamage(percent * -0.25)
      }
    } else if(target == Block.BEAM_COMPUTER) {
      if(buff == "BUFF_RELOAD") {
        entity.effect.weapon.addReloadSpeed(percent); //buff beam reload speed
        entity.effect.weapon.addDamage(percent * -0.25);
      } else if(buff == "BUFF_DAMAGE") { //buff beam damage
        entity.effect.weapon.addDamage(percent);
        entity.effect.weapon.addRange(percent * -0.25);
      } else if(buff == "BUFF_RANGE") { //buff beam range
        entity.effect.weapon.addRange(percent);
        entity.effect.weapon.addDamage(percent * -0.25)
      }
    } else if(target == Block.MISSILE_COMPUTER) {
      if(buff == "BUFF_RELOAD") { //buff missile reload speed
        entity.effect.weapon.addReloadSpeed(percent);
        entity.effect.weapon.addDamage(percent * -0.25);
      } else if(buff == "BUFF_DAMAGE") { //buff missile damage
        entity.effect.weapon.addDamage(percent);
        entity.effect.weapon.addProjectileSpeed(percent * -0.25);
      } else if(buff == "BUFF_SPEED") { //buff missile projectile speed
        entity.effect.weapon.addProjectileSpeed(percent);
        entity.effect.weapon.addDamage(percent * -0.25)
      }
    } else {
      npc.sendControllerMessage("There's nothing I can do with this system!");
    }
  }

  public static void npcBuffTurret(Entity npc, Block target, float percent, String buff) {
    /** makes an npc buff a specified turret */
    Entity entity = target.getEntity();
    Block block = entity.getBlockAt(target);
    if(target == Block.TURRET_DOCK) {
      Entity turretBase = block.rail.getDockedEntity();
      Entity turretGun = turretBase.getDocked();
      ArrayList<System> weapons = new ArrayList<System>();
      weapons.add(turretGun.getWeapons);
      if(buff == "BUFF_TURRET_RELOAD") {
        for(x = 0, x == weapons.size(), x++) {
          turretGun.effect.weapon.addReloadSpeed(percent);
          turretGun.effect.weapon.addDamage(percent * -0.25)
        }
      } else if(buff == "BUFF_TURRET_DAMAGE") {
        if(weapons.contains(Block.BEAM_COMPUTER)) {
          for(x = 0, x == weapons.size(), x++) {
            Block currentWeapon = weapons[x];
            turretGun.effect.weapon.addDamage(percent);
            if(currentWeapon.getMaster != Block.BEAM_COMPUTER) {
              turretGun.effect.weapon.addProjectileSpeed(percent * -0.25);
            }
          }
        }
      } else if(buff == "BUFF_TURRET_PROJECTILE_SPEED") {
        if(weapons.contains(Block.BEAM_COMPUTER)) {
          for(x = 0, x == weapons.size(), x++) {
            Block currentWeapon = weapons[x];
            if(currentWeapon.getMaster != Block.BEAM_COMPUTER) {
              turretGun.effect.weapon.addProjectileSpeed(percent);
              turretGun.effect.weapon.addReloadSpeed(percent * -0.25);
            }
          }
        }
      } else if(buff == "BUFF_TURRET_TURNRATE") {
        turretBase.effect.addTurnRate(percent);
        if(weapons.contains(Block.BEAM_COMPUTER)) {
          for(x = 0, x == weapons.size(), x++) {
            Block currentWeapon = weapons[x];
            if(currentWeapon.getMaster != Block.BEAM_COMPUTER) {
              turretGun.effect.weapon.addProjectileSpeed(percent * -0.07);
            }
            turretBase.effect.addTurnRate(percent);
          }
        }
      }
    } else {
      npc.sendControllerMessage("That's not a Rail Turret!");
    }
  }
}
