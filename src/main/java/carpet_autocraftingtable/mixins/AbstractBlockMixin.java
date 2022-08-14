package carpet_autocraftingtable.mixins;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractBlock.AbstractBlockState.class)
public class AbstractBlockMixin {
	@Inject(method = "hasBlockEntity", at = @At(value = "HEAD"), cancellable = true)
	private void onHasBlockEntity(CallbackInfoReturnable<Boolean> cir){
		AbstractBlock.AbstractBlockState abstractBlockState = ((AbstractBlock.AbstractBlockState)(Object)this);
		if (abstractBlockState.isOf(Blocks.CRAFTING_TABLE) || abstractBlockState.isOf(Blocks.SMITHING_TABLE)){
			cir.setReturnValue(false);
		}
	}
}
