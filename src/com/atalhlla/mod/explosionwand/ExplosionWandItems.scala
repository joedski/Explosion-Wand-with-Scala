package com.atalhlla.mod.explosionwand

import net.minecraft.item.Item
import com.atalhlla.mod.explosionwand.item.ItemExplodium
import com.atalhlla.mod.explosionwand.item.ItemExplosionWand
import cpw.mods.fml.common.registry.GameRegistry
import net.minecraft.item.ItemStack
import net.minecraft.init.Items
import net.minecraft.init.Blocks

object ExplosionWandItems {

	var explodium: Item = null
	var explosionWand: Item = null

	def registerItems() {
		//		And that's how birth works.
		//		I mean reflection.
		explodium = ExplosionWandMod.utils.registerItem( classOf[ ItemExplodium ], ItemExplodium.NAME )
		explosionWand = ExplosionWandMod.utils.registerItem( classOf[ ItemExplosionWand ], ItemExplosionWand.NAME )
	}

	def registerRecipes() {
		// Quick hack, but until I can figure out or find something better...
		def c( inC: Char ) = new Character( inC )

		GameRegistry.addShapedRecipe( new ItemStack( explodium ),
			"zrz",
			"rTr",
			"zrz",
			c( 'r' ), Items.redstone,
			c( 'z' ), Items.blaze_powder,
			c( 'T' ), Blocks.tnt )

		GameRegistry.addShapedRecipe( new ItemStack( explosionWand ),
			"X  ",
			" g ",
			"  Z",
			c( 'X' ), explodium,
			c( 'g' ), Items.gold_nugget,
			c( 'Z' ), Items.blaze_rod )
	}
}