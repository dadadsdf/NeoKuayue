package willow.train.kuayue.systems.device.track.entry.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.simibubi.create.foundation.blockEntity.renderer.SmartBlockEntityRenderer;
import kasuga.lib.core.client.model.BedrockModelLoader;
import kasuga.lib.core.client.model.anim_model.AnimModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import willow.train.kuayue.initial.AllElements;
import willow.train.kuayue.systems.device.track.entry.StationEntryBlockEntity;

public class StationEntryEntityRenderer extends SmartBlockEntityRenderer<StationEntryBlockEntity> {
    protected static AnimModel bedrockModel = BedrockModelLoader.getModel(
            AllElements.testRegistry.asResource("block/signal/track/entry/entry"),
            RenderType.cutoutMipped()
    );

    public StationEntryEntityRenderer(BlockEntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    protected void renderSafe(StationEntryBlockEntity blockEntity, float partialTicks, PoseStack ms, MultiBufferSource buffer, int light, int overlay) {
        bedrockModel.render(ms, buffer, light, overlay);
    }
}
