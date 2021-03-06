package com.minalien.mffs.items.upgrades

import com.minalien.mffs.core.MFFSCreativeTab
import com.minalien.mffs.machines.TileEntityProjector
import net.minecraft.tileentity.TileEntity

/**
 * Provides Projectors the ability to break only fluid blocks when generating a forcefield.
 */
object ItemSpongeUpgrade extends ItemUpgrade with MachineUpgrade {
	setCreativeTab(MFFSCreativeTab)
	setUnlocalizedName("upgradeSponge")
	setTextureName("mffs:upgrades/sponge")
	setMaxStackSize(this.stackSize)
	/**
	 * @return A list of valid TileEntity classes the Upgrade can apply to.
	 */
	override def getValidMachines: Array[Class[_ <: TileEntity]] = Array(classOf[TileEntityProjector])

	/**
	 * Applies the effects to the tile entity.
	 *
	 * @param tileEntity Tile entity being upgraded.
	 */
	def applyUpgrade(tileEntity: TileEntity) {
		tileEntity match {
			case projector: TileEntityProjector =>
				projector.isInSpongeMode = true
		}
	}

	/**
	 * Removes the effects from the tile entity.
	 *
	 * @param tileEntity Tile entity being downgraded.
	 */
	def removeUpgrade(tileEntity: TileEntity) {
		tileEntity match {
			case projector: TileEntityProjector =>
				projector.isInSpongeMode = false
		}
	}

	override def canStack: Boolean = false

	override def stackSize: Int = 1
}
