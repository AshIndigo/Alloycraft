package com.ashindigo.utils;

/**
 * Used for adding Block and Item Loader methods easily
 * @author Ash Indigo
 */
@Deprecated // Don't use for now
public interface UtilsItemBlockInterface {
	
	/**
	 * For Blocks
	 * @author Ash Indigo
	 *
	 */
	public interface IBlock {
		
		public void preInitBlocks();
		
		public void initBlocks();
		
		public void postInitBlocks();
	}
	
	/**
	 * For Items
	 * @author Ash Indigo
	 *
	 */
	public interface IItem {
		
		public void preInitItems();
		
		public void initItems();
		
		public void postInitItems();
	}
	
}
