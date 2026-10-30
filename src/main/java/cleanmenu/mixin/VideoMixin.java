package cleanmenu.mixin;
import cleanmenu.MenuConfig;
import net.minecraft.client.Options;
import net.minecraft.client.OptionInstance;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.options.*;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
@Mixin(VideoSettingsScreen.class)
public abstract class VideoMixin extends OptionsSubScreen {
 protected VideoMixin(Screen s,Options o,Component c){super(s,o,c);}
 @Inject(method="addOptions",at=@At("TAIL"))
 private void cleanmenu$options(CallbackInfo ci){list.addSmall(OptionInstance.createBoolean("cleanmenu.panorama",MenuConfig.panorama,MenuConfig::panorama),options.panoramaSpeed());}
}
