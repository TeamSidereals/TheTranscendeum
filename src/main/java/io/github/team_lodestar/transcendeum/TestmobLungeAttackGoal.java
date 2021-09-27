package io.github.team_lodestar.transcendeum;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.CreatureEntity;

public class TestmobLungeAttackGoal extends Goal {
	protected final CreatureEntity attacker;
	private final float lungeSpeed;
	private final float lungePower;
	private int lungeCooldown;
	private double targetX, targetY, targetZ;
	private boolean explodesUponImpact;
	public TestmobLungeAttackGoal(CreatureEntity entity, float lungeSpeed, float lungePower, int lungeInterval, boolean willExplodeUponImpact) {
		this.attacker = entity;
		this.lungeSpeed = lungeSpeed;
		this.lungePower = lungePower;
		this.explodesUponImpact = willExplodeUponImpact;
	}

	public boolean shouldExecute() {
		LivingEntity target = this.attacker.getAttackTarget();
		if (target == null) {
			return false;
		} else if (!target.isAlive()) {
			return false;
		} else {
			if (--this.lungeCooldown <= 0) {
				return true;
			}
		}
		return false;
	}

	public boolean shouldContinueExecuting() {
		LivingEntity target = this.attacker.getAttackTarget();
		if (target == null) {
			return false;
		} else if (!target.isAlive()) {
			return false;
		} else {
			return !(target instanceof PlayerEntity) || !target.isSpectator() && !((PlayerEntity) target).isCreative();
		}
	}

	public void startExecuting() {
		this.lungeCooldown = 0;
	}

	public void resetTask() {
	}

	public void tick() {
		LivingEntity target = this.attacker.getAttackTarget();
		this.attacker.getLookController().setLookPositionWithEntity(target, 30.0F, 30.0F);
		double distance = this.attacker.getDistanceSq(target.getPosX(), target.getPosY(), target.getPosZ());
		this.targetX = target.getPosX();
		this.targetY = target.getPosY();
		this.targetZ = target.getPosZ();
	}
}
