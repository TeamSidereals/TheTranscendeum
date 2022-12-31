package io.github.team_lodestar.transcendeum.entity.mixcode.custom;

import io.github.team_lodestar.transcendeum.entity.mixcode.MixCodeEntityType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.monster.ZombieVillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.network.IPacket;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import java.util.Random;

public class PurifyPowderEntity extends ProjectileItemEntity {

    public PurifyPowderEntity(EntityType<? extends PurifyPowderEntity> type, World world) {
        super(type,world);
    }

    public PurifyPowderEntity(World worldIn, LivingEntity entity) {
        super(MixCodeEntityType.PURIFY_POWDER_PROJECTILE.get(), entity, worldIn);
    }

    public PurifyPowderEntity(World worldIn, double x, double y, double z) {
        super(MixCodeEntityType.PURIFY_POWDER_PROJECTILE.get(), x, y, z, worldIn);
    }

    @Override
    protected Item getDefaultItem() {
        return Items.SUGAR.asItem();
    }

    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    protected void onImpact(RayTraceResult result) {
        if (!world.isRemote){
            if (result.getType() == RayTraceResult.Type.ENTITY){
                Entity entity = ((EntityRayTraceResult) result).getEntity();
                if (entity instanceof MobEntity){
                    CreatureAttribute attribute = ((MobEntity) entity).getCreatureAttribute();
                    if (attribute == CreatureAttribute.UNDEAD){
                        entity.attackEntityFrom(DamageSource.MAGIC, 2);
                        ((MobEntity) entity).addPotionEffect(new EffectInstance(Effects.WEAKNESS, 100, 0));
                        ((MobEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, 100, 0));
                    }
                    if (entity instanceof ZombieVillagerEntity){
                        Random roll = new Random();
                        if (roll.nextDouble() < 0.1D) {
                            PlayerEntity player = null;
                            if (this.func_234616_v_() instanceof PlayerEntity){
                                player = (PlayerEntity) this.func_234616_v_();
                            }
                            ((ZombieVillagerEntity) entity).startConverting(player.getUniqueID(), roll.nextInt(2401) + 3600);
                        }
                    }
                }
            }
            if (result.getType() == RayTraceResult.Type.BLOCK){
                BlockPos hitPos = ((BlockRayTraceResult) result).getPos();
                BlockState hitBlock = world.getBlockState(hitPos);
                if (hitBlock.getBlock() == Blocks.MYCELIUM){
                    world.setBlockState(hitPos, Blocks.GRASS_BLOCK.getDefaultState());
                }
            }
            this.remove();
        }
    }

    @Override
    public void tick() {
        world.addParticle(ParticleTypes.FIREWORK, this.getPosX(), this.getPosY() - 0.3D, this.getPosZ(),
                this.rand.nextGaussian() * 0.05D, -this.getMotion().y * 0.5D,
                this.rand.nextGaussian() * 0.05D);
        super.tick();
    }
}
