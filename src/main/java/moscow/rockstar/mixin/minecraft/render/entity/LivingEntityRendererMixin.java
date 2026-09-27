package moscow.rockstar.mixin.minecraft.render.entity;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import moscow.rockstar.Rockstar;
import moscow.rockstar.utility.rotations.RotationHandler;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(LivingEntityRenderer.class)
public abstract class LivingEntityRendererMixin {
   @ModifyExpressionValue(
      method = "updateRenderState(Lnet/minecraft/entity/LivingEntity;Lnet/minecraft/client/render/entity/state/LivingEntityRenderState;F)V",
      at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/entity/LivingEntityRenderer;clampBodyYaw(Lnet/minecraft/entity/LivingEntity;FF)F")
   )
   public float rockstar$changeYaw(float oldValue, LivingEntity entity, LivingEntityRenderState state, float tickDelta) {
      if (entity instanceof ClientPlayerEntity) {
         RotationHandler rotationHandler = Rockstar.getInstance().getRotationHandler();
         float yaw = rotationHandler.isIdling() ? oldValue : rotationHandler.getRenderRotation().getYaw();
         rotationHandler.getServerRotation().setYaw(yaw);
         return yaw;
      } else {
         return oldValue;
      }
   }

   @ModifyExpressionValue(
      method = "updateRenderState(Lnet/minecraft/entity/LivingEntity;Lnet/minecraft/client/render/entity/state/LivingEntityRenderState;F)V",
      at = @At(value = "INVOKE", target = "Lnet/minecraft/util/math/MathHelper;lerpAngleDegrees(FFF)F")
   )
   public float rockstar$changeHeadYaw(float oldValue, LivingEntity entity, LivingEntityRenderState state, float tickDelta) {
      if (entity instanceof ClientPlayerEntity) {
         RotationHandler rotationHandler = Rockstar.getInstance().getRotationHandler();
         float yaw = rotationHandler.isIdling() ? oldValue : rotationHandler.getRenderRotation().getYaw();
         rotationHandler.getServerRotation().setYaw(yaw);
         return yaw;
      } else {
         return oldValue;
      }
   }

   @ModifyExpressionValue(
      method = "updateRenderState(Lnet/minecraft/entity/LivingEntity;Lnet/minecraft/client/render/entity/state/LivingEntityRenderState;F)V",
      at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;getLerpedPitch(F)F")
   )
   public float rockstar$changePitch(float oldValue, LivingEntity entity, LivingEntityRenderState state, float tickDelta) {
      if (entity instanceof ClientPlayerEntity) {
         RotationHandler rotationHandler = Rockstar.getInstance().getRotationHandler();
         float pitch = rotationHandler.isIdling() ? oldValue : rotationHandler.getRenderRotation().getPitch();
         rotationHandler.getServerRotation().setPitch(pitch);
         return pitch;
      } else {
         return oldValue;
      }
   }
}
