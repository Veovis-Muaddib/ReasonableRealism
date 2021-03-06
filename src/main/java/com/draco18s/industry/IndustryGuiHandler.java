package com.draco18s.industry;

import com.draco18s.industry.client.gui.GuiContainerFoundry;
import com.draco18s.industry.client.gui.GuiContainerExtHopper;
import com.draco18s.industry.client.gui.GuiContainerFilter;
import com.draco18s.industry.entities.TileEntityFoundry;
import com.draco18s.industry.entities.TileEntityFilter;
import com.draco18s.industry.inventory.ContainerFoundry;
import com.draco18s.industry.inventory.ContainerExtHopper;
import com.draco18s.industry.inventory.ContainerFilter;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityHopper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class IndustryGuiHandler implements IGuiHandler {
	public static int EXT_HOPPER = 0;
	public static int FILTER = 1;
	public static final int FOUNDRY = 2;

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		BlockPos pos = new BlockPos(x, y, z);
		if(ID == EXT_HOPPER) {
			TileEntity tileEntity = world.getTileEntity(pos);
			if(tileEntity instanceof TileEntityHopper){
				return new ContainerExtHopper(player.inventory, (TileEntityHopper) tileEntity);
			}
		}
		if(ID == FILTER) {
			TileEntity tileEntity = world.getTileEntity(pos);
			if(tileEntity instanceof TileEntityFilter){
				return new ContainerFilter(player.inventory, (TileEntityFilter) tileEntity);
			}
		}
		if(ID == FOUNDRY) {
			TileEntity tileEntity = world.getTileEntity(pos);
			if(tileEntity instanceof TileEntityFoundry){
				return new ContainerFoundry(player.inventory, (TileEntityFoundry) tileEntity);
			}
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		BlockPos pos = new BlockPos(x, y, z);
		if(ID == EXT_HOPPER) {
			TileEntity tileEntity = world.getTileEntity(pos);
			if(tileEntity instanceof TileEntityHopper){
				return new GuiContainerExtHopper(new ContainerExtHopper(player.inventory, (TileEntityHopper) tileEntity), (TileEntityHopper)tileEntity);
			}
		}
		if(ID == FILTER) {
			TileEntity tileEntity = world.getTileEntity(pos);
			if(tileEntity instanceof TileEntityFilter){
				return new GuiContainerFilter(player.inventory, (TileEntityFilter) tileEntity);
			}
		}
		if(ID == FOUNDRY) {
			TileEntity tileEntity = world.getTileEntity(pos);
			if(tileEntity instanceof TileEntityFoundry){
				return new GuiContainerFoundry(new ContainerFoundry(player.inventory, (TileEntityFoundry) tileEntity), (TileEntityFoundry)tileEntity);
			}
		}
		return null;
	}
}
