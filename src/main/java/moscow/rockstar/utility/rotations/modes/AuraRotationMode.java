package moscow.rockstar.utility.rotations.modes;

import moscow.rockstar.systems.modules.modules.combat.Aura;
import moscow.rockstar.utility.interfaces.IMinecraft;
import moscow.rockstar.utility.rotations.MoveCorrection;
import moscow.rockstar.utility.rotations.RotationHandler;
import net.minecraft.entity.LivingEntity;

public interface AuraRotationMode extends IMinecraft {
   void rotate(Aura var1, RotationHandler var2, LivingEntity var3, MoveCorrection var4);

   default void reset() {
   }
}
