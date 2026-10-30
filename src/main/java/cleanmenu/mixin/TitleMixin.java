package cleanmenu.mixin;
import cleanmenu.MenuConfig;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.Font;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
@Mixin(TitleScreen.class)
public abstract class TitleMixin {
 @Inject(method="realmsNotificationsEnabled",at=@At("HEAD"),cancellable=true)
 private void cleanmenu$realms(CallbackInfoReturnable<Boolean> ci){ci.setReturnValue(false);}
 @Redirect(method="extractRenderState",at=@At(value="INVOKE",target="Lnet/minecraft/client/gui/GuiGraphicsExtractor;text(Lnet/minecraft/client/gui/Font;Ljava/lang/String;III)V"))
 private void cleanmenu$footer(GuiGraphicsExtractor g,Font font,String text,int x,int y,int color){}
}
