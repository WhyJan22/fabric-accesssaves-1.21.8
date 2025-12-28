package net.whyjan.accesssaves.mixin;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.world.SelectWorldScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SelectWorldScreen.class)
public class SelectWorldScreenMixin extends Screen {
    protected SelectWorldScreenMixin(Text title) {
        super(title);
    }

    @Inject(at = @At("RETURN"), method = "init")
    private void addCustomButton(CallbackInfo ci) {
        this.addDrawableChild(
                ButtonWidget.builder(
                        Text.literal("o"),
                        button -> {
                            // TODO: your click logic here
                        }
                ).dimensions(
                        this.width / 2 + 4 + 154, // RIGHT of Create New World
                        this.height - 52,
                        20,
                        20
                ).build()
        );
    }
}
