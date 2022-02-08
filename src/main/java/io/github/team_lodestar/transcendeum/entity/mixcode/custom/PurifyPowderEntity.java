package io.github.team_lodestar.transcendeum.entity.mixcode.custom;

import io.github.team_lodestar.transcendeum.entity.mixcode.MixCodeEntityType;
import io.github.team_lodestar.transcendeum.item.mixcode.MixCodeItemRegister;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.IPacket;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class PurifyPowderEntity extends ProjectileItemEntity {

    public PurifyPowderEntity(EntityType<? extends PurifyPowderEntity> type, World world) {
        super(type, world);
    }

    public PurifyPowderEntity(World worldIn, LivingEntity entity) {
        super(MixCodeEntityType.PURIFY_POWDER_PROJECTILE.get(), entity, worldIn);
    }

    public PurifyPowderEntity(World worldIn, double x, double y, double z) {
        super(MixCodeEntityType.PURIFY_POWDER_PROJECTILE.get(), x, y, z, worldIn);
    }

    @Override
    protected Item getDefaultItem() {
        return MixCodeItemRegister.PURIFY_POWDER.get();
    }

    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    protected void onImpact(RayTraceResult result) {
        this.remove();
    }


}
