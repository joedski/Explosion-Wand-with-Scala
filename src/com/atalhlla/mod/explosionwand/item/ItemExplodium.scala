package com.atalhlla.mod.explosionwand.item

import net.minecraft.item.Item
import com.atalhlla.mod.explosionwand.ExplosionWandMod

object ItemExplodium {
	val NAME = "explodium_item"
}

class ItemExplodium extends Item {
	this.setCreativeTab( ExplosionWandMod.creativeTab )
	this.setTextureName( ExplosionWandMod.modId + ":" + ItemExplodium.NAME )
}