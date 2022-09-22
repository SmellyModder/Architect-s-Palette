package architectspalette.core.model.util;


import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.BakedModelWrapper;
import net.minecraftforge.client.model.data.IModelData;
import net.minecraftforge.client.model.data.ModelDataMap;

//Copyright (c) simibubi
//Sourced from Create once again.
//I understand how this works, but there's no point in reinventing the wheel.
//On the note of understanding it, I'm not sure if I actually need this. It seems to enable layers of data, but I don't need that.
//But I may as well do it, since I'm referencing their implementation anyway, and they definitely use this.
public abstract class BakedModelWrapperWithData extends BakedModelWrapper<BakedModel> {
    public BakedModelWrapperWithData(BakedModel originalModel) {
        super(originalModel);
    }

    @Override
    public IModelData getModelData(BlockAndTintGetter level, BlockPos pos, BlockState state, IModelData modelData) {
        ModelDataMap.Builder builder = new ModelDataMap.Builder();
        if (originalModel instanceof BakedModelWrapperWithData wrappedModel) {
            wrappedModel.gatherModelData(builder, level, pos, state);
        }
        return gatherModelData(builder, level, pos, state).build();
    }

    protected abstract ModelDataMap.Builder gatherModelData(ModelDataMap.Builder builder, BlockAndTintGetter world, BlockPos pos, BlockState state);

}
