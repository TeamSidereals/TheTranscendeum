/**
 * The code of this mod element is always locked.
 *
 * You can register new events in this class too.
 *
 * If you want to make a plain independent class, create it using
 * Project Browser -> New... and make sure to make the class
 * outside io.github.team_lodestar.transcendeum as this package is managed by MCreator.
 *
 * If you change workspace package, modid or prefix, you will need
 * to manually adapt this file to these changes or remake it.
 *
 * This class will be added in the mod root package.
*/
package io.github.team_lodestar.transcendeum;

import io.github.team_lodestar.transcendeum.entity.KefgaellEntity;
import io.github.team_lodestar.transcendeum.item.EnigmaGlovePoweredItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.common.Mod;

public class KefgaellShootGoal extends Goal {
	private final KefgaellEntity.CustomEntity mob;
	public int shootTime;

	public KefgaellShootGoal(KefgaellEntity.CustomEntity mobEntity) {
		this.mob = mobEntity;
	}

	public boolean shouldExecute() {
		return this.mob.getAttackTarget() != null;
	}

	public void startExecuting() {
		this.shootTime = 0;
	}

	public void resetTask() {
		this.mob.setShooting(false);
	}

	public boolean shouldContinueExecuting() {
		return this.mob.getAttackTarget() != null;
	}

	public void tick() {
		LivingEntity target = this.mob.getAttackTarget();

		if (target != null && target.getDistanceSq(this.mob) < 4096.0D && this.mob.canEntityBeSeen(target)) {
			this.mob.getLookController().setLookPositionWithEntity(target, 10.0F, 10.0F);
			++this.shootTime;

			World world = this.mob.world;

			if (this.shootTime >= 30) {

				this.mob.playSound(SoundEvents.ENTITY_WITHER_BREAK_BLOCK, 1.0F, 1.0F);
				EnigmaGlovePoweredItem.shoot(mob, target);
				if (world instanceof ServerWorld) {
					((ServerWorld) world).spawnParticle(ParticleTypes.FLAME, this.mob.getPosX(), this.mob.getPosY(), this.mob.getPosZ(), 75, 5, 2, 5, 0.01);
				}

				this.shootTime = 0;
			}
		}

		this.mob.setShooting(this.shootTime >= 20);
	}
}
