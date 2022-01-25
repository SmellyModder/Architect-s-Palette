package architectspalette.common.blocks.flint;

import architectspalette.common.blocks.SixWayPillarBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class FlintPillarBlock extends SixWayPillarBlock {
    public FlintPillarBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void fallOn(Level worldIn, BlockState stateIn, BlockPos pos, Entity entityIn, float fallDistance) {
        entityIn.causeFallDamage(fallDistance, 1.25f, DamageSource.FALL);
    }
}