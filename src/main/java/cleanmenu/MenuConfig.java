package cleanmenu;
import java.nio.file.*;
import java.io.*;
import java.util.Properties;
import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.LoggerFactory;
public final class MenuConfig {
 private static final Path FILE=FabricLoader.getInstance().getConfigDir().resolve("clean-menu.properties");
 public static boolean panorama=load();
 private static boolean load(){
  if(!Files.exists(FILE))return true;
  try(var in=Files.newInputStream(FILE)){var p=new Properties();p.load(in);return Boolean.parseBoolean(p.getProperty("panorama","true"));}
  catch(IOException e){LoggerFactory.getLogger("cleanmenu").warn("Could not read menu settings",e);return true;}
 }
 public static void panorama(boolean value){
  panorama=value;var p=new Properties();p.setProperty("panorama",Boolean.toString(value));
  try {Files.createDirectories(FILE.getParent());try(var out=Files.newOutputStream(FILE)){p.store(out,"Clean Menu");}}
  catch(IOException e){LoggerFactory.getLogger("cleanmenu").warn("Could not save menu settings",e);}
 }
}
