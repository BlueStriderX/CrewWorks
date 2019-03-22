package crewworks.thederpgamer.main;

import thederpgamer.main.main;
import thederpgamer.main.blocks;

public class event {

  @EventHandler //starmade api equivalent?
  public static void onBlockPlace(EventHandler event, Block block) {
    if (block == blocks.crewModule) {
      if (entity.type != "ship" || entity.type != "station") {
        MessageBox placeError = new MessageBox;
        placeError.setText("You can only put crew modules on ships or stations!", center)
        placeError.addbutton("Ok", center)
        player.sendMessage().placeError;
        event.cancel(); //cancel block place event
        return;
      }
    }
  }
}
