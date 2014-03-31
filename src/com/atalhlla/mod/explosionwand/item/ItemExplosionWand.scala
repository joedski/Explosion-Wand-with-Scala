package com.atalhlla.mod.explosionwand.item

import net.minecraft.item.Item
import com.atalhlla.mod.explosionwand.ExplosionWandMod
import net.minecraft.item.ItemStack
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.world.World
import net.minecraft.entity.item.EntityTNTPrimed
import com.atalhlla.util.minecraft.EntityHelpers

object ItemExplosionWand extends Item {
	val NAME = "explosion_wand"
}

class ItemExplosionWand extends Item {
	this.setCreativeTab( ExplosionWandMod.creativeTab )
	this.setTextureName( ExplosionWandMod.modId + ":" + ItemExplosionWand.NAME )

	this.maxStackSize = 1
	this.setMaxDamage( 16 )

	override def onItemRightClick( itemStack: ItemStack, world: World, player: EntityPlayer ) :ItemStack = {
		if ( !player.capabilities.isCreativeMode ) {
			itemStack.damageItem( 1, player )
		}
				
		if( ! world.isRemote ) {
			world.playSoundEffect( player.posX, player.posY, player.posZ, ExplosionWandMod.modId + ":explosionwand.throw", 2.0F, 1F );
			
			val tnt = new EntityTNTPrimed( world, player.posX, player.posY, player.posZ, player )
			tnt.fuse /= 2
			EntityHelpers.throwEntity( tnt, 2F, player )
			world.spawnEntityInWorld( tnt )
		}
		
		return itemStack
	}
}