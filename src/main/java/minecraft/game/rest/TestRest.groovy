package minecraft.game.rest;

import static minecraft.game.Main.getServer;

/**
 * @author elvis
 * @version $Revision: $<br/>
 *          $Id: $
 * @since 5/2/16 5:13 PM
 */
public class TestRest {

	public TestRest() {

		println "setuping api"

		// setup a GET route
		getServer().get("/weather/[location]", { req ->
			req.write([
					message: "Hi! there from ${req.param('location')}"
			]);
		});

	}
}
