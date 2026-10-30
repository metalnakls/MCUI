package cleanmenu.mixin;
import cleanmenu.MenuConfig;
import net.minecraft.client.gui.components.LogoRenderer;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.resources.Identifier;
import com.mojang.renderpearl.api.pipeline.RenderPipeline;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
@Mixin(LogoRenderer.class)
public abstract class LogoMixin {
 @Redirect(method="extractRenderState(Lnet/minecraft/client/gui/GuiGraphicsExtractor;IFI)V",at=@At(value="INVOKE",target="Lnet/minecraft/client/gui/GuiGraphicsExtractor;blit(Lcom/mojang/renderpearl/api/pipeline/RenderPipeline;Lnet/minecraft/resources/Identifier;IIFFIIIII)V",ordinal=1))
 private void cleanmenu$edition(GuiGraphicsExtractor g,RenderPipeline p,Identifier texture,int x,int y,float u,float v,int w,int h,int tw,int th,int color){
  if(!(Minecraft.getInstance().gui.screen() instanceof TitleScreen))g.blit(p,texture,x,y,u,v,w,h,tw,th,color);
 }
}
