package com.atalhlla.util.minecraft;

/*
 * This code is licensed under the WTFPL.
 * 
 * You can copy it if you want.
 * You can rename it if you want.
 * You copy it and claim you wrote it, though that'd be disingenuous.  (But not if you actually did write it before finding this version.  Also, no one cares.)
 * You can print it out, shred it, glue the confetti together, and grate it over your macaroni and cheese if you want, but that sounds unhealthy.
 */

import java.util.Iterator;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAITasks;

/**
 * A set of AI task utils that are bound to a living entity to make working with
 * tasks easier in cases where you do not have direct access to them because
 * they are stored in private fields.
 * 
 * @author Joe
 * 
 */

public class AITaskUtils {

	public EntityLiving entity;

	public AITaskUtils( EntityLiving entity ) {
		this.entity = entity;
	}

	/**
	 * Finds the first AI Task in entity.tasks that is an instance of the
	 * specified AI class, or null if the entity's AI tasks do not contain such
	 * a task.
	 * 
	 * @param aiClass
	 *            The class-object of the specified AI task.
	 * @return the actual AI task which is an instance of the AI task class.
	 */
	public EntityAIBase getFirstTaskOfType( Class<? extends EntityAIBase> aiClass ) {
		@SuppressWarnings( "rawtypes" )
		Iterator iterator = entity.tasks.taskEntries.iterator();
		EntityAIBase quarryTaskAction = null;

		while( iterator.hasNext() ) {
			EntityAITasks.EntityAITaskEntry taskEntry = (EntityAITasks.EntityAITaskEntry) iterator.next();
			EntityAIBase taskAction = taskEntry.action;

			if( aiClass.isInstance( taskAction ) ) {
				quarryTaskAction = taskAction;
				break;
			}
		}

		return quarryTaskAction;
	}

	/**
	 * Removes the first AI task from entity.tasks which is an instance of the
	 * specified AI class. Uses an iterator by calling getFirstTaskOfType()
	 * before calling entity.tasks.removeTask().
	 * 
	 * @param aiClass
	 *            The class-object of the specified AI task to remove.
	 */
	public void removeFirstTaskOfType( Class<EntityAIBase> aiClass ) {
		entity.tasks.removeTask( getFirstTaskOfType( aiClass ) );
	}
}
