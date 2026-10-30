package mcui.mixin;

import net.minecraft.client.gui.screens.worldselection.WorldOpenFlows;
import net.minecraft.world.level.storage.LevelStorageSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WorldOpenFlows.class)
public abstract class WorldWarningMixin {
 @Inject(method="askForBackup",at=@At("HEAD"),cancellable=true)
 private void mcui$experimental(LevelStorageSource.LevelStorageAccess world, boolean customized,
                                     Runnable proceed, Runnable cancel, CallbackInfo ci) {
  // Existing experimental worlds only. Keep customized-world, version and pack-error dialogs.
  if (!customized) { ci.cancel(); proceed.run(); }
 }
}
