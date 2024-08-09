package com.natamus.cryingghasts.events;

import com.natamus.cryingghasts.config.ConfigHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Ghast;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class GhastEvent {
	public static void onPlayerTick(ServerLevel world, ServerPlayer player) {
		if (player.tickCount % ConfigHandler.ghastTearDelayTicks != 0) {
			return;
		}
		
		BlockPos ppos = player.blockPosition();
		ItemStack tear = new ItemStack(Items.GHAST_TEAR, 1);
		
		int r = ConfigHandler.maxDistanceToGhastBlocks;
		for (Entity entity : world.getEntities(player, new AABB(ppos.getX()-r, ppos.getY()-r, ppos.getZ()-r, ppos.getX()+r, ppos.getY()+r, ppos.getZ()+r))) {
			if (entity instanceof Ghast) {
				Vec3 gpos = entity.position();
				world.addFreshEntity(new ItemEntity(world, gpos.x, gpos.y+2, gpos.z, tear));
			}
		}
	}
}
