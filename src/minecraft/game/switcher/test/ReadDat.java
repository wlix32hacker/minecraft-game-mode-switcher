/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package minecraft.game.switcher.test;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jnbt.CompoundTag;
import org.jnbt.IntTag;
import org.jnbt.NBTConstants;
import org.jnbt.NBTInputStream;
import org.jnbt.NBTOutputStream;
import org.jnbt.NBTUtils;
import org.jnbt.Tag;

/**
 *
 * @author Elvis
 */
public class ReadDat {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        File theFile = new File("C:\\Users\\Elvis\\AppData\\Roaming\\.minecraft\\saves\\Demo_World\\teste.dat");
        NBTInputStream nbtStream = new NBTInputStream(new FileInputStream(theFile));
        
        final CompoundTag tree = (CompoundTag) nbtStream.readTag();
        final CompoundTag newTree;
        final Map<String, Object> treeItens = (Map<String, Object>) tree.getValue().get("Data").getValue();
//        treeItens.putAll((Map<String, Object>) tree.getValue().get("Data").getValue());
        
        
        
        treeItens.put("GameType", new IntTag("GameType", 1)); // creative mode
        Map<String, Tag> player = ((CompoundTag) treeItens.get("Player")).getValue();
        System.out.println(treeItens.get("GameType"));
        System.out.println(player.get("playerGameType"));
//        System.out.println(new Gson().toJson(treeItens.keySet()));
//        Tag value = (Tag) readTag.getValue();
//        NBTOutputStream nbtOutputStream = new NBTOutputStream(new FileOutputStream(theFile));
//        nbtOutputStream.writeTag(readTag);
        //        System.out.println(readTag.getValue());
        //        String toJson = new Gson().toJson(readTag);
        //        System.out.println(toJson);
        
        
        
    }
}
