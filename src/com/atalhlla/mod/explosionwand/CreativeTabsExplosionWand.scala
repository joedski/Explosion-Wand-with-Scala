package com.atalhlla.mod.explosionwand

import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.Item
import net.minecraft.init.Blocks

class CreativeTabsExplosionWand( tabLabel: String )
		extends CreativeTabs( tabLabel ) {
	
	def getTabIconItem = Item.getItemFromBlock( Blocks.tnt )
}