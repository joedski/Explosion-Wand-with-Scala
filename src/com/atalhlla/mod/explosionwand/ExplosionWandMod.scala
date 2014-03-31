package com.atalhlla.mod.explosionwand

import com.atalhlla.mod.explosionwand.proxy.CommonProxy
import com.atalhlla.util.minecraft.ModUtils

import cpw.mods.fml.common.Mod
import cpw.mods.fml.common.Mod.EventHandler
import cpw.mods.fml.common.SidedProxy
import cpw.mods.fml.common.event.FMLInitializationEvent
import cpw.mods.fml.common.event.FMLPreInitializationEvent

//@Mod( modid = "explosionwand", name = "Explosion Wand", version = "alpha0", modLanguage = "scala" )
@Mod( modid = "explosionwand", useMetadata = true, modLanguage = "scala" )
object ExplosionWandMod {
	val modId = "explosionwand"
	val modName = "Explosion Wand"
	val version = "a0"
		
	val utils = new ModUtils( this )
	
	val creativeTab = new CreativeTabsExplosionWand( modId )

	@SidedProxy(
		clientSide = "com.atalhlla.mod.explosionwand.proxy.ClientProxy",
		serverSide = "com.atalhlal.mod.explosionwand.proxy.CommonProxy" )
	var proxy: CommonProxy = _

	@EventHandler
	def preInit( event: FMLPreInitializationEvent ) {
		ExplosionWandItems.registerItems
	}

	@EventHandler
	def init( event: FMLInitializationEvent ) {
		ExplosionWandItems.registerRecipes
	}
}