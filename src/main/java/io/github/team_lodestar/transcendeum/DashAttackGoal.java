package io.github.team_lodestar.transcendeum;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.CreatureEntity;

import io.github.team_lodestar.transcendeum.particle.TwilighterisParticle;

public class DashAttackGoal extends Goal {
	protected final CreatureEntity attacker;
	private boolean hasDashed;
	private final float dashSpeed;
	private final float dashDamage;
	private final int detectDistance;
	private int cooldown;
	private double targetX, targetY, targetZ;
	private double attackerX, attackerY, attackerZ;
	private final boolean explodesUponImpact;
	public DashAttackGoal(CreatureEntity entity, float dashSpeed, float dashDamage, int detectDistance, boolean willExplodeUponImpact) {
		this.attacker = entity;
		this.dashSpeed = dashSpeed;
		this.dashDamage = dashDamage;
		this.detectDistance = detectDistance;
		this.explodesUponImpact = willExplodeUponImpact;
	}

	public boolean shouldExecute() {
		CreatureEntity attacker = (CreatureEntity) this.attacker;
		this.attackerY = attacker.getPosY();
		LivingEntity target = this.attacker.getAttackTarget();
		if (target == null) {
			return false;
		} else if (!target.isAlive()) {
			return false;
		} else {
			this.targetY = target.getPosY();
			if (this.attackerY >= this.targetY) {
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
			return (this.attackerY >= this.targetY)
					&& (!(target instanceof PlayerEntity) || !target.isSpectator() && !((PlayerEntity) target).isCreative());
		}
	}

	public void startExecuting() {
		this.cooldown = 0;
		this.hasDashed = false;
		this.attacker.setAggroed(true);
	}

	public void resetTask() {
		this.attacker.setAggroed(false);
		this.cooldown = 0;
	}

	public void tick() {
		CreatureEntity attacker = (CreatureEntity) this.attacker;
		LivingEntity target = this.attacker.getAttackTarget();
		this.attackerX = attacker.getPosX();
		this.attackerY = attacker.getPosY();
		this.attackerZ = attacker.getPosZ();
		this.targetX = target.getPosX();
		this.targetY = target.getPosY();
		this.targetZ = target.getPosZ();
		this.attacker.getLookController().setLookPositionWithEntity(target, 30.0F, 30.0F);
		double distance = this.attacker.getDistanceSq(target.getPosX(), target.getPosY(), target.getPosZ());
		if (this.cooldown <= 0) {
			if ((int) distance <= this.detectDistance) {
				double vx = this.targetX - this.attackerX;
				double vy = this.targetY - this.attackerY;
				double vz = this.targetZ - this.attackerZ;
				float speed = this.dashSpeed;
				double vm = (double) Math.sqrt((Math.pow(vx, 2) + (Math.pow(vy, 2) + Math.pow(vz, 2))));
				vx = (double) ((vx / vm) * speed);
				vy = (double) ((vy / vm) * speed);
				vz = (double) ((vz / vm) * speed);
				this.attacker.setMotion(vx, vy, vz);
				this.hasDashed = true;
				if (this.hasDashed) {
					IWorld world = attacker.world;
					if (world instanceof ServerWorld) {
						((ServerWorld) world).spawnParticle(TwilighterisParticle.particle, (attacker.getPosX()), (attacker.getPosY()),
								(attacker.getPosZ()), (int) 10, 0.2, 0.2, 0.2, 0.1);
					}
					this.executeDamage(target, distance);
				}
			}
		}
		if (this.cooldown > 0) {
			--this.cooldown;
		}
	}

	protected void executeDamage(LivingEntity target, double distToTarget) {
		double distance = this.getAttackReachSqr(target);
		if (distToTarget <= distance) {
			target.attackEntityFrom(DamageSource.causeMobDamage(attacker), (float) this.dashDamage);
			target.setGlowing(true);
			this.hasDashed = false;
			this.cooldown = 40;
		}
	}

	protected double getAttackReachSqr(LivingEntity target) {
		return (double) (this.attacker.getWidth() * 2.0F * this.attacker.getWidth() * 2.0F + target.getWidth());
	}
}
