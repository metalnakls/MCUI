package mcui.mixin;
import mcui.MenuConfig;
import java.util.ArrayList;
import net.minecraft.client.gui.screens.*;
import net.minecraft.client.gui.components.*;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import com.terraformersmc.modmenu.gui.ModsScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
@Mixin(TitleScreen.class)
public abstract class ScreenMixin extends Screen {
 protected ScreenMixin(){super(Component.empty());}
 @Inject(method="init()V",at=@At("TAIL"))
 private void mcui$layout(CallbackInfo ci){
  if(!((Object)this instanceof TitleScreen)||minecraft.isDemo())return;
  AbstractWidget single=null,multi=null,options=null,quit=null;
  for(var child:new ArrayList<>(children()))if(child instanceof AbstractWidget a && a.getMessage().getContents() instanceof TranslatableContents t){
   switch(t.getKey()){
    case "menu.singleplayer" -> single=a;
    case "menu.multiplayer" -> multi=a;
    case "menu.options" -> options=a;
    case "menu.quit" -> quit=a;
   }
  }
  if(single==null||multi==null||options==null||quit==null)return;
  clearWidgets();
  int width=Math.min(200,this.width-24),half=(width-4)/2,x=(this.width-width)/2,y=(this.height-92)/2;
  place(single,x,y,half);place(multi,x+half+4,y,half);
  Button mods=Button.builder(Component.translatable("modmenu.title"),b->minecraft.gui.setScreen(new ModsScreen(this))).build();
  place(mods,x,y+24,width);place(options,x,y+48,width);place(quit,x,y+72,width);
  clearFocus();setInitialFocus(single);
 }
 private void place(AbstractWidget b,int x,int y,int w){b.setPosition(x,y);b.setWidth(w);b.setHeight(20);addRenderableWidget(b);}
}
