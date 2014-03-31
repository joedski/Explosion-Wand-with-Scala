package com.atalhlla.util.minecraft;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;

public class EntityHelpers {
	// Multiply by DEG_TO_RAD to convert from degrees to radians.
	public static final double DEG_TO_RAD_D = Math.PI / 180.0D;
	public static final float DEG_TO_RAD_F = (float) Math.PI / 180.0F;

	/**
	 * This sets the entity to a position just in front of the thrower with
	 * velocity based on the thrower's rotation and the specified speed.
	 * (velocity is speed + direction; speed is the magnitude of the velocity
	 * vector.)
	 * 
	 * @param entity
	 *            The entity that is being thrown.
	 * @param throwSpeed
	 *            The speed the entity will have in the throwing direction.
	 * @param thrower
	 *            The living entity throwing the throwee entity.
	 * @return The entity being thrown.
	 */
	public static Entity throwEntity( Entity entity, float throwSpeed, EntityLivingBase thrower ) {
		// Note: does not actually set thrower on the entity because that's a
		// property of Throwables which don't need use of this helper.
		// Also doesn't set the heading because it's assumed that this is
		// throwing entities that may not have a heading.

		entity.setLocationAndAngles( thrower.posX, thrower.posY + (double) thrower.getEyeHeight(), thrower.posZ, thrower.rotationYaw, thrower.rotationPitch );

		entity.posX -= (double) (MathHelper.cos( entity.rotationYaw * DEG_TO_RAD_F ) * 0.16F);
		entity.posY -= 0.1D;
		entity.posZ -= (double) (MathHelper.sin( entity.rotationYaw * DEG_TO_RAD_F ) * 0.16F);

		entity.setPosition( entity.posX, entity.posY, entity.posZ );
		entity.yOffset = 0.0F;

		entity.motionX = (double) (-MathHelper.sin( entity.rotationYaw * DEG_TO_RAD_F ) * MathHelper.cos( entity.rotationPitch * DEG_TO_RAD_F ) * throwSpeed);
		entity.motionZ = (double) (MathHelper.cos( entity.rotationYaw * DEG_TO_RAD_F ) * MathHelper.cos( entity.rotationPitch * DEG_TO_RAD_F ) * throwSpeed);
		entity.motionY = (double) (-MathHelper.sin( entity.rotationPitch * DEG_TO_RAD_F ) * throwSpeed);

		return entity;
	}

	public static Entity throwEntity( Entity entity, EntityLivingBase thrower ) {
		return throwEntity( entity, 0.4F, thrower );
	}
}
