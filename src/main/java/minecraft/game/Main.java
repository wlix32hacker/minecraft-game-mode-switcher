package minecraft.game;

import minecraft.game.rest.TestRest;
import net.metzweb.tinyserver.TinyServer;
import net.metzweb.tinyserver.response.JsonResponse;

/**
 * @author elvis
 * @version $Revision: $<br/>
 *          $Id: $
 * @since 5/2/16 4:44 PM
 */
public class Main {
    private static TinyServer SERVER;

    public static void main(String[] args) {
        SERVER = new TinyServer(8200);

        // calling controllers
        new TestRest();

        // set JSON response class
        SERVER.setResponseFormat(new JsonResponse());

        // start server
        SERVER.start();

    }

    public static TinyServer getServer() {
        return SERVER;
    }
}
