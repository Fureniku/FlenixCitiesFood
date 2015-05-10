package co.uk.silvania.cities.food.blocks.crops;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import co.uk.silvania.cities.food.FCF_Blocks;
import co.uk.silvania.cities.food.FCF_Items;
import co.uk.silvania.cities.food.FlenixCities_Food;

public class BlockCornCrop3 extends BlockFCFCrop {

	public BlockCornCrop3() {
		super();
		this.setTickRandomly(true);
	}
	
	@Override
	protected Item getSeedItem() {
		return FCF_Items.cornSeed;
	}
	
	@Override
	protected Item getCropItem() {
		return FCF_Items.cornItem;
	}
	
	@Override
	protected boolean canPlaceBlockOn(Block block) {
        return block == FCF_Blocks.cornCrop2;
    }
	
	@Override
	public void registerBlockIcons(IIconRegister icon) {
		this.icons = new IIcon[13];
		
		for (int i = 0; i < this.icons.length; ++i) {
			this.icons[i] = icon.registerIcon(FlenixCities_Food.modid + ":cornCrop1_stage_" + i);
		}
	}
	
	@Override 
	public IIcon getIcon(IBlockAccess block, int x, int y, int z, int side) {
		int meta = block.getBlockMetadata(x, y, z);
		if (meta == 7) {
			return this.icons[13];
		}
		if (meta < 0 || meta > 7) {
			meta = 7;
		}
		return this.icons[meta];
	}
}