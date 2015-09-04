package Tiles;
import Assets.Assets;

public class RockTile extends Tile{

	public RockTile(int id) {
		super(Assets.rock, id);
	}
	
	//override de isSolid dans Tile pour ne pas pouvoir marcher dessus
	
	
	@Override
	public boolean isSolid(){
		return true;
	}


}

