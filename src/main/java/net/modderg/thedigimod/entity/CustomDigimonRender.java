package net.modderg.thedigimod.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Matrix4f;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public abstract class CustomDigimonRender<D extends CustomDigimon> extends GeoEntityRenderer<CustomDigimon> {
    protected Style XpStyle = Style.EMPTY;

    public CustomDigimonRender(EntityRendererProvider.Context renderManager, AnimatedGeoModel<CustomDigimon> modelProvider) {
        super(renderManager, modelProvider);

    }

    @Override
    public void render(CustomDigimon entity, float entityYaw, float partialTicks, PoseStack stack, MultiBufferSource bufferIn, int packedLightIn) {
        if(entity.isEvolving()){
            packedLightIn = 0;
        }
        var renderNameTagEvent = new net.minecraftforge.client.event.RenderNameTagEvent(entity, entity.getDisplayName(), this, stack, bufferIn, packedLightIn, partialTicks);
        net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(renderNameTagEvent);
        MutableComponent mp = MutableComponent.create(Component.literal(xpBarMath( entity.getNeededXp(), entity.getLevelXp(), 30)).getContents());
        mp.setStyle(XpStyle.withColor(TextColor.fromRgb(11534335)));
        MutableComponent mp2 = MutableComponent.create(Component.literal(entity.getMood()).getContents());
        mp2.setStyle(XpStyle.withColor(TextColor.fromRgb(entity.getMoodColor())));
        MutableComponent mp3 = MutableComponent.create(Component.literal(Integer.toString(Math.round(entity.getHealth())) + " Hp").getContents());
        mp3.setStyle(XpStyle.withColor(TextColor.fromRgb(8704641)));
        if (entity.isTame() && renderNameTagEvent.getResult() != net.minecraftforge.eventbus.api.Event.Result.DENY && (renderNameTagEvent.getResult() == net.minecraftforge.eventbus.api.Event.Result.ALLOW || this.shouldShowName(entity))) {
            this.renderXp(entity, mp, stack, bufferIn, packedLightIn);
            this.renderMood(entity, mp2, stack, bufferIn, packedLightIn);
            this.renderHp(entity, mp3, stack, bufferIn, packedLightIn);
        }
        super.render(entity, entityYaw, partialTicks, stack, bufferIn, packedLightIn);
    }

    protected String xpBarMath(int max, int current, int size){
        StringBuilder sb = new StringBuilder();
        int percentage = (size*(100*current/max))/100;
        int i = 0;
        while(i < percentage){
            sb.append("|");
            i++;
        }
        while(i < size){
            sb.append("·");
            i++;
        }
        return sb.toString();
    }

    protected void renderXp(Entity p_114498_, Component p_114499_, PoseStack stack, MultiBufferSource p_114501_, int p_114502_) {
        double d0 = this.entityRenderDispatcher.distanceToSqr(p_114498_);
        if (net.minecraftforge.client.ForgeHooksClient.isNameplateInRenderDistance(p_114498_, d0)) {
            boolean flag = !p_114498_.isDiscrete();
            float f = p_114498_.getBbHeight() + 0.2F;
            int i = "deadmau5".equals(p_114499_.getString()) ? -10 : 0;
            stack.pushPose();
            stack.translate(0.0D, (double)f, 0.0D);
            stack.mulPose(this.entityRenderDispatcher.cameraOrientation());
            stack.scale(-0.025F, -0.025F, 0.025F);
            Matrix4f matrix4f = stack.last().pose();
            float f1 = Minecraft.getInstance().options.getBackgroundOpacity(0.25F);
            int j = (int)(f1 * 255.0F) << 24;
            Font font = this.getFont();
            float f2 = (float)(-font.width(p_114499_) / 2);
            font.drawInBatch(p_114499_, f2, (float)i, 553648127, false, matrix4f, p_114501_, flag, j, p_114502_);
            if (flag) {
                font.drawInBatch(p_114499_, f2, (float)i, -1, false, matrix4f, p_114501_, false, 0, p_114502_);
            }

            stack.popPose();
        }
    }

    protected void renderMood(CustomDigimon p_114498_, Component p_114499_, PoseStack stack, MultiBufferSource p_114501_, int p_114502_) {
        double d0 = this.entityRenderDispatcher.distanceToSqr(p_114498_);
        if (net.minecraftforge.client.ForgeHooksClient.isNameplateInRenderDistance(p_114498_, d0)) {
            boolean flag = !p_114498_.isDiscrete();
            float f = p_114498_.getBbHeight() + 0.8F;
            int i = "deadmau5".equals(p_114499_.getString()) ? -10 : 0;
            stack.pushPose();
            stack.translate(0.0D, (double)f, 0.0D);
            stack.mulPose(this.entityRenderDispatcher.cameraOrientation());
            stack.scale(-0.025F, -0.025F, 0.025F);
            Matrix4f matrix4f = stack.last().pose();
            float f1 = Minecraft.getInstance().options.getBackgroundOpacity(0.25F);
            int j = (int)(f1 * 255.0F) << 24;
            Font font = this.getFont();
            float f2 = (float)(-font.width(p_114499_) / 2);
            font.drawInBatch(p_114499_, f2, (float)i, p_114498_.getMoodColor(), false, matrix4f, p_114501_, flag, j, p_114502_);
            if (flag) {
                font.drawInBatch(p_114499_, f2, (float)i, -1, false, matrix4f, p_114501_, false, 0, p_114502_);
            }

            stack.popPose();
        }
    }

    protected void renderHp(CustomDigimon p_114498_, Component p_114499_, PoseStack stack, MultiBufferSource p_114501_, int p_114502_) {
        double d0 = this.entityRenderDispatcher.distanceToSqr(p_114498_);
        if (net.minecraftforge.client.ForgeHooksClient.isNameplateInRenderDistance(p_114498_, d0)) {
            boolean flag = !p_114498_.isDiscrete();
            float f = p_114498_.getBbHeight() + 1.07F;
            int i = "deadmau5".equals(p_114499_.getString()) ? -10 : 0;
            stack.pushPose();
            stack.translate(0.0D, (double)f, 0.0D);
            stack.mulPose(this.entityRenderDispatcher.cameraOrientation());
            stack.scale(-0.025F, -0.025F, 0.025F);
            Matrix4f matrix4f = stack.last().pose();
            float f1 = Minecraft.getInstance().options.getBackgroundOpacity(0.25F);
            int j = (int)(f1 * 255.0F) << 24;
            Font font = this.getFont();
            float f2 = (float)(-font.width(p_114499_) / 2);
            font.drawInBatch(p_114499_, f2, (float)i, 8704641, false, matrix4f, p_114501_, flag, j, p_114502_);
            if (flag) {
                font.drawInBatch(p_114499_, f2, (float)i, -1, false, matrix4f, p_114501_, false, 0, p_114502_);
            }

            stack.popPose();
        }
    }
}
