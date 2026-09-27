package moscow.rockstar.utility.rotations.modes;

import moscow.rockstar.Rockstar;
import moscow.rockstar.systems.modules.modules.combat.Aura;
import moscow.rockstar.systems.modules.modules.combat.ElytraTarget;
import moscow.rockstar.utility.game.prediction.ElytraPredictionSystem;
import moscow.rockstar.utility.interfaces.IMinecraft;
import moscow.rockstar.utility.math.MathUtility;
import moscow.rockstar.utility.rotations.Rotation;
import moscow.rockstar.utility.rotations.RotationMath;
import moscow.rockstar.utility.rotations.RotationPointUtil;
import net.minecraft.util.Hand;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.network.packet.c2s.play.PlayerInteractItemC2SPacket;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.RaycastContext;
import net.minecraft.util.hit.HitResult.Type;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket.Full;
import net.minecraft.world.RaycastContext.FluidHandling;
import net.minecraft.world.RaycastContext.ShapeType;

final class AuraRotationSupport implements IMinecraft {
   private AuraRotationSupport() {
   }

   static Rotation rotationToTarget(Aura aura, LivingEntity target) {
      return RotationMath.getRotationTo(aimPoint(aura, target));
   }

   static Vec3d aimPoint(Aura aura, LivingEntity target) {
      Vec3d predicted = target.getPos();
      if (Rockstar.getInstance().getModuleManager().getModule(ElytraTarget.class).isEnabled() && target instanceof PlayerEntity player) {
         predicted = ElytraPredictionSystem.predictPlayerPosition(player);
      }

      Box box = target.getBoundingBox();
      return aura != null && aura.isHitVectorModeEnabled()
         ? RotationPointUtil.nearestPoint(box, mc.player.getEyePos())
         : new Vec3d(
            predicted.x,
            MathHelper.clamp(MathUtility.interpolate(mc.player.getY(), target.getEyeY(), 0.5), box.minY, box.maxY),
            predicted.z
         );
   }

   static Vec3d targetDelta(LivingEntity target, double yScale) {
      Vec3d center = target.getBoundingBox().getCenter();
      Vec3d point = new Vec3d(center.x, target.getY() + target.getHeight() * yScale, center.z);
      return point.subtract(mc.player.getEyePos());
   }

   static Rotation rotationFromDelta(Vec3d delta) {
      return new Rotation(RotationPointUtil.yawTo(delta), RotationPointUtil.pitchTo(delta));
   }

   static Rotation rotationDelta(Rotation base, Vec3d delta) {
      Rotation target = rotationFromDelta(delta);
      return new Rotation(MathHelper.wrapDegrees(target.getYaw() - base.getYaw()), target.getPitch() - base.getPitch());
   }

   static boolean canSeePoint(Vec3d point) {
      return mc.player != null && mc.world != null
         ? mc.world
               .raycast(new RaycastContext(mc.player.getEyePos(), point, ShapeType.COLLIDER, FluidHandling.NONE, mc.player))
               .getType()
            == Type.MISS
         : false;
   }

   static boolean canTrace(Aura aura, LivingEntity target, Rotation rotation, boolean checkBlocks) {
      return MathUtility.canTraceWithBlock(aura.getAttackDistanceValue(), rotation.getYaw(), rotation.getPitch(), mc.player, target, checkBlocks);
   }

   static float random(float min, float max) {
      return MathUtility.random(min, max);
   }

   static float lerp(float delta, float start, float end) {
      return start + (end - start) * delta;
   }

   static void sendRotationPackets(Rotation rotation) {
      if (mc.player != null && mc.player.networkHandler != null) {
         mc.player
            .networkHandler
            .sendPacket(
               new Full(
                  mc.player.getX(),
                  mc.player.getY(),
                  mc.player.getZ(),
                  rotation.getYaw(),
                  rotation.getPitch(),
                  mc.player.isOnGround(),
                  mc.player.horizontalCollision
               )
            );
         mc.player.networkHandler.sendPacket(new PlayerInteractItemC2SPacket(Hand.MAIN_HAND, 0, rotation.getYaw(), rotation.getPitch()));
      }
   }
}
