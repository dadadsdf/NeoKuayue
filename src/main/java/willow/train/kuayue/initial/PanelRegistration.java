package willow.train.kuayue.initial;

import kasuga.lib.registrations.common.BlockEntityReg;
import kasuga.lib.registrations.common.BlockReg;
import kasuga.lib.registrations.common.CreativeTabReg;
import kasuga.lib.registrations.common.ItemReg;
import kasuga.lib.registrations.registry.SimpleRegistry;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import willow.train.kuayue.block.panels.TrainPanelBlock;
import willow.train.kuayue.item.PanelBlockItem;

public class PanelRegistration<T extends TrainPanelBlock> {

    public final BlockReg<T> block;

    public final ItemReg<PanelBlockItem> item;

    public PanelRegistration(String registrationKey) {
        block = new BlockReg<T>(registrationKey);
        item = new ItemReg<PanelBlockItem>(registrationKey);
        item.itemType(properties -> new PanelBlockItem(block.getBlock(), properties));
    }

    public PanelRegistration<T> materialAndColor(Material material, MaterialColor materialColor) {
        block.material(material).materialColor(materialColor);
        return this;
    }

    public PanelRegistration<T> noOcclusion() {
        block.addProperty(BlockBehaviour.Properties::noOcclusion);
        return this;
    }

    public PanelRegistration<T> block(BlockReg.BlockBuilder<T> builder) {
        this.block.blockType(builder);
        return this;
    }

    public PanelRegistration<T> blockEntity(BlockEntityType.BlockEntitySupplier<?> provider) {
        block.withBlockEntity(block.registrationKey, provider);
        return this;
    }

    public PanelRegistration<T> blockEntityRenderer(BlockEntityReg.BlockEntityRendererBuilder<?> renderer) {
        block.withBlockEntityRenderer(renderer);
        return this;
    }

    public PanelRegistration<T> tab(CreativeTabReg reg) {
        this.item.tab(reg);
        return this;
    }

    public PanelRegistration<T> stackSize(int size) {
        this.item.stackTo(size);
        return this;
    }

    public PanelRegistration<T> submit(SimpleRegistry registry) {
        this.block.submit(registry);
        this.item.submit(registry);
        return this;
    }
}
