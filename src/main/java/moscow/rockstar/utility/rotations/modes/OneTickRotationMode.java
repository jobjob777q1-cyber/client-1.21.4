package moscow.rockstar.utility.rotations.modes;

import moscow.rockstar.systems.modules.modules.combat.Aura;
import moscow.rockstar.utility.rotations.MoveCorrection;
import moscow.rockstar.utility.rotations.Rotation;
import moscow.rockstar.utility.rotations.RotationHandler;
import moscow.rockstar.utility.rotations.RotationPriority;
import net.minecraft.entity.LivingEntity;

public final class OneTickRotationMode implements AuraRotationMode {
   private Rotation rotation = Rotation.ZERO;
   private int targetId = -1;
   private boolean ready;
   private boolean yawNudge;

   @Override
   public void rotate(Aura aura, RotationHandler handler, LivingEntity target, MoveCorrection moveCorrection) {
      if (target != null && !target.isDead()) {
         if (this.ready && this.targetId == target.getId() && this.canUsePreparedRotation(aura, target)) {
            AuraRotationSupport.sendRotationPackets(this.rotation);
         } else {
            this.prepare(aura, target);
         }

         this.nudgeClientYaw();
         handler.rotate(this.rotation, moveCorrection, 180.0F, 180.0F, 180.0F, RotationPriority.TO_TARGET);
      } else {
         this.reset();
      }
   }

   private void prepare(Aura aura, LivingEntity target) {
      this.rotation = AuraRotationSupport.rotationToTarget(aura, target);
      this.targetId = target.getId();
      this.ready = true;
      AuraRotationSupport.sendRotationPackets(this.rotation);
   }

   private boolean canUsePreparedRotation(Aura aura, LivingEntity target) {
      return !this.ready ? false : AuraRotationSupport.canTrace(aura, target, this.rotation, !aura.isNoHitInvEnabled()) || !aura.isWallsEnabled();
   }

   private void nudgeClientYaw() {
      if (mc.player != null) {
         this.yawNudge = !this.yawNudge;
         mc.player.setYaw(mc.player.getYaw() + (this.yawNudge ? 0.1F : -0.1F));
      }
   }

   @Override
   public void reset() {
      this.ready = false;
      this.targetId = -1;
      this.rotation = Rotation.ZERO;
   }
}
