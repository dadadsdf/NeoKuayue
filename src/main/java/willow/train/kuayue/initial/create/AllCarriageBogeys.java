package willow.train.kuayue.initial.create;

import com.simibubi.create.content.trains.bogey.BogeyBlockEntityRenderer;
import kasuga.lib.registrations.BundledReg;
import kasuga.lib.registrations.common.BlockEntityReg;
import kasuga.lib.registrations.create.BogeyBlockReg;
import kasuga.lib.registrations.create.BogeyGroupReg;
import kasuga.lib.registrations.create.BogeySizeReg;
import kasuga.lib.registrations.registry.CreateRegistry;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import willow.train.kuayue.block.bogey.carriage.CarriageBogeyBlock;
import willow.train.kuayue.block.bogey.carriage.CarriageBogeyEntity;
import willow.train.kuayue.block.bogey.carriage.MeterCarriageBogeyBlock;
import willow.train.kuayue.block.bogey.carriage.MeterCarriageBogeyEntity;
import willow.train.kuayue.block.bogey.carriage.renderer.*;
import willow.train.kuayue.initial.AllElements;

public class AllCarriageBogeys {
    public static final CreateRegistry testRegistry = AllElements.testRegistry;

    public static final BogeySizeReg pk209p = new BogeySizeReg("pk209p")
            .size(0.915F / 2F)
            .submit(testRegistry);

    public static final BogeySizeReg pk209pNoMotor = new BogeySizeReg("pk209p_no_motor")
            .size(0.915F / 2F)
            .submit(testRegistry);

    public static final BogeySizeReg pk209pBackward = new BogeySizeReg("pk209p_backward")
            .size(0.915F / 2F)
            .submit(testRegistry);

    public static final BogeySizeReg cw2 = new BogeySizeReg("cw2")
            .size(0.915F / 2F)
            .submit(testRegistry);

    public static final BogeySizeReg sw220k = new BogeySizeReg("sw220k")
            .size(0.915F / 2F)
            .submit(testRegistry);

    public static final BogeySizeReg sw220kBackward = new BogeySizeReg("sw220k_backward")
            .size(0.915F / 2F)
            .submit(testRegistry);

    public static final BogeySizeReg sw160 = new BogeySizeReg("sw160")
            .size(0.915F / 2F)
            .submit(testRegistry);

    public static final BogeySizeReg mkz = new BogeySizeReg("mkz")
            .size(0.915F/2F)
            .submit(testRegistry);

    public static final BogeySizeReg tkz2 = new BogeySizeReg("tkz2")
            .size(0.915F/2F)
            .submit(testRegistry);

    public static final BogeySizeReg tkz2Motor = new BogeySizeReg("tkz2_motor")
            .size(0.915F/2F)
            .submit(testRegistry);

    public static final BogeySizeReg tkz2MotorBackward = new BogeySizeReg("tkz2_motor_backward")
            .size(0.915F/2F)
            .submit(testRegistry);

    public static final BogeySizeReg tkz1 = new BogeySizeReg("tkz1")
            .size(0.915F/2F)
            .submit(testRegistry);

    public static final BogeySizeReg zk6 = new BogeySizeReg("zk6")
            .size(0.915F/2F)
            .submit(testRegistry);

    public static final BogeyGroupReg carriageBogeyGroup = new BogeyGroupReg("carriage", "kuayue_bogey")
            .bogey(pk209p.getSize(), PK209PRenderer::new, testRegistry.asResource("pk209p_bogey"))
            .bogey(pk209pNoMotor.getSize(), PK209PRenderer.NoMotor::new, testRegistry.asResource("pk209p_no_motor_bogey"))
            .bogey(pk209pBackward.getSize(), PK209PRenderer.Backward::new, testRegistry.asResource("pk209p_backward_bogey"))
            .bogey(cw2.getSize(), CW2BogeyRenderer::new, testRegistry.asResource("cw2_bogey"))
            .bogey(sw220k.getSize(), SW220KRenderer::new, testRegistry.asResource("sw220k_bogey"))
            .bogey(sw220kBackward.getSize(), SW220KRenderer.Backward::new, testRegistry.asResource("sw220k_backward_bogey"))
            .bogey(sw160.getSize(), SW160Renderer::new, testRegistry.asResource("sw160_bogey"))
            .translationKey("carriage_group")
            .submit(testRegistry);

    public static final BogeyGroupReg freightCarriageBogeyGroup = new BogeyGroupReg("freight_carriage", "kuayue_bogey")
            .bogey(zk6.getSize(), ZK6Renderer::new, testRegistry.asResource("zk6_bogey"))
            .translationKey("freight_carriage_group")
            .submit(testRegistry);

    public static final BogeyGroupReg meterCarriageBogeyGroup = new BogeyGroupReg("meter_carriage", "kuayue_bogey_2")
            .bogey(mkz.getSize(), MKZRenderer::new, testRegistry.asResource("mkz_bogey"))
            .bogey(tkz2.getSize(), TKZ2Renderer::new, testRegistry.asResource("tkz2_bogey"))
            .bogey(tkz1.getSize(), TKZ1Renderer::new, testRegistry.asResource("tkz1_bogey"))
            .bogey(tkz2Motor.getSize(), TKZ2Renderer.Motor::new, testRegistry.asResource("tkz2_motor_bogey"))
            .bogey(tkz2MotorBackward.getSize(), TKZ2Renderer.MotorBackward::new, testRegistry.asResource("tkz2_motor_backward_bogey"))
            .translationKey("meter_carriage_group")
            .submit(testRegistry);

    public static final BundledReg<BogeyBlockReg<CarriageBogeyBlock>> carriageBlockBundle =
            new BundledReg<BogeyBlockReg<CarriageBogeyBlock>>("carriage_bundle")
            .factory(BogeyBlockReg::new)
            .action(reg -> reg.block(CarriageBogeyBlock::new))
            .action(reg -> reg.material(Material.METAL))
            .action(reg -> reg.materialColor(MaterialColor.PODZOL))
            .action(reg -> reg.property(BlockBehaviour.Properties::requiresCorrectToolForDrops))
            .action(reg -> reg.property(properties -> properties.strength(1.5f, 3.0f)))
            .action(BogeyBlockReg::noOcclusion)
            .drive((key, reg) -> switch (key) {
                case "sw220k_bogey" -> reg.size(sw220k).translationKey("sw220k_bogey");
                case "sw220k_backward_bogey" -> reg.size(sw220kBackward).translationKey("sw220k_bogey");
                case "cw2_bogey" -> reg.size(cw2).translationKey("cw2_bogey");
                case "pk209p_bogey" -> reg.size(pk209p).translationKey("pk209p_bogey");
                case "pk209p_no_motor_bogey" -> reg.size(pk209pNoMotor).translationKey("pk209p_no_motor_bogey");
                case "pk209p_backward_bogey" -> reg.size(pk209pBackward).translationKey("pk209p_bogey");
                case "sw160_bogey" -> reg.size(sw160).translationKey("sw160_bogey");
                case "zk6_bogey" -> reg.size(zk6).translationKey("zk6_bogey");
                default -> reg.size(cw2).translationKey("cw2_bogey");
            })
            .element("sw220k_bogey").element("sw220k_backward_bogey").element("cw2_bogey")
            .element("pk209p_bogey").element("pk209p_no_motor_bogey").element("pk209p_backward_bogey")
            .element("sw160_bogey").element("zk6_bogey")
            .submit(testRegistry);

    public static final BundledReg<BogeyBlockReg<MeterCarriageBogeyBlock>> meterCarriageBlockBundle =
            new BundledReg<BogeyBlockReg<MeterCarriageBogeyBlock>>("meter_carriage_bundle")
            .factory(BogeyBlockReg::new)
            .action(reg -> reg.block(MeterCarriageBogeyBlock::new))
            .action(reg -> reg.material(Material.METAL))
            .action(reg -> reg.materialColor(MaterialColor.PODZOL))
            .action(reg -> reg.property(BlockBehaviour.Properties::requiresCorrectToolForDrops))
            .action(reg -> reg.property(properties -> properties.strength(1.5f, 3.0f)))
            .action(BogeyBlockReg::noOcclusion)
            .drive((key, reg) -> switch (key) {
                case "mkz_bogey" -> reg.size(mkz).translationKey("mkz_bogey");
                default -> reg.size(mkz).translationKey("mkz_bogey");
            })
            .element("mkz_bogey")
            .submit(testRegistry);

    public static final BundledReg<BogeyBlockReg<MeterCarriageBogeyBlock>> meterCarriageHalfHeightTopBlockBundle =
            new BundledReg<BogeyBlockReg<MeterCarriageBogeyBlock>>("meter_carriage_half_height_top_bundle")
            .factory(BogeyBlockReg::new)
            .action(reg -> reg.block((properties, bogeySize) -> new MeterCarriageBogeyBlock(properties, bogeySize, true)))
            .action(reg -> reg.material(Material.METAL))
            .action(reg -> reg.materialColor(MaterialColor.PODZOL))
            .action(reg -> reg.property(BlockBehaviour.Properties::requiresCorrectToolForDrops))
            .action(reg -> reg.property(properties -> properties.strength(1.5f, 3.0f)))
            .action(BogeyBlockReg::noOcclusion)
            .drive((key, reg) -> switch (key) {
                case "tkz2_bogey" -> reg.size(tkz2).translationKey("tkz2_bogey");
                case "tkz1_bogey" -> reg.size(tkz1).translationKey("tkz1_bogey");
                case "tkz2_motor_bogey" -> reg.size(tkz2Motor).translationKey("tkz2_motor_bogey");
                case "tkz2_motor_backward_bogey" -> reg.size(tkz2MotorBackward).translationKey("tkz2_motor_backward_bogey");
                default -> reg.size(tkz2).translationKey("tkz2_bogey");
            })
            .element("tkz2_bogey").element("tkz1_bogey").element("tkz2_motor_bogey")
            .element("tkz2_motor_backward_bogey")
            .submit(testRegistry);

    public static final BlockEntityReg<CarriageBogeyEntity> carriageBogeyEntity =
            new BlockEntityReg<CarriageBogeyEntity>("carriage_bogey_entity")
                    .blockEntityType(CarriageBogeyEntity::new)
                    .addBlock(() -> carriageBlockBundle.getElement("pk209p_bogey").getEntry().get())
                    .addBlock(() -> carriageBlockBundle.getElement("pk209p_no_motor_bogey").getEntry().get())
                    .addBlock(() -> carriageBlockBundle.getElement("pk209p_backward_bogey").getEntry().get())
                    .addBlock(() -> carriageBlockBundle.getElement("cw2_bogey").getEntry().get())
                    .addBlock(() -> carriageBlockBundle.getElement("sw220k_bogey").getEntry().get())
                    .addBlock(() -> carriageBlockBundle.getElement("sw220k_backward_bogey").getEntry().get())
                    .addBlock(() -> carriageBlockBundle.getElement("sw160_bogey").getEntry().get())
                    .addBlock(() -> carriageBlockBundle.getElement("zk6_bogey").getEntry().get())
                    .withRenderer(() -> BogeyBlockEntityRenderer::new)
                    .submit(testRegistry);

    public static final BlockEntityReg<MeterCarriageBogeyEntity> meterCarriageBogeyEntity =
            new BlockEntityReg<MeterCarriageBogeyEntity>("meter_carriage_bogey_entity")
                    .blockEntityType(MeterCarriageBogeyEntity::new)
                    .addBlock(() -> meterCarriageBlockBundle.getElement("mkz_bogey").getEntry().get())
                    .addBlock(() -> meterCarriageHalfHeightTopBlockBundle.getElement("tkz2_bogey").getEntry().get())
                    .addBlock(() -> meterCarriageHalfHeightTopBlockBundle.getElement("tkz1_bogey").getEntry().get())
                    .addBlock(() -> meterCarriageHalfHeightTopBlockBundle.getElement("tkz2_motor_bogey").getEntry().get())
                    .addBlock(() -> meterCarriageHalfHeightTopBlockBundle.getElement("tkz2_motor_backward_bogey").getEntry().get())
                    .withRenderer(() -> BogeyBlockEntityRenderer::new)
                    .submit(testRegistry);

    public static void invoke() {}
}
