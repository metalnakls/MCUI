package mcui.mixin;
import mcui.MenuConfig;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
@Mixin(Screen.class)
public abstract class BackgroundMixin {
 @Shadow public int width;
 @Shadow public int height;
 @Inject(method="extractPanorama",at=@At("HEAD"),cancellable=true)
 private void mcui$background(GuiGraphicsExtractor g,float delta,CallbackInfo ci){
  if(!MenuConfig.panorama){g.fill(0,0,width,height,0xff171a20);ci.cancel();}
 }
}
