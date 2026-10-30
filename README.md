# Clean Menu

Standalone Fabric 26.3 client mod, requiring Mod Menu. It does not depend on Metal Shaders.

The centered title menu uses vanilla’s 200-pixel width. Singleplayer and multiplayer split the first row; mods, options, and quit each have their own full-width row. Original world and multiplayer callbacks, including multiplayer restrictions, are retained. Title-screen Realms, friends, language/accessibility shortcuts, copyright/footer text, and the Java Edition subtitle are hidden. Options still contains language, accessibility, and credits.

Video Settings includes **Menu panorama** and vanilla **Panorama Speed**. Disabling the panorama uses a plain dark background; speed zero keeps the panorama still. The panorama switch is saved to `config/clean-menu.properties`; speed uses Minecraft's own settings. Minecraft supplies one panorama scene; resource packs can replace it.

From the repository root, with JDK 25:

```
./gradlew -p ui/clean-menu build
```

The local build uses the installed Mod Menu 21.0.0-beta.1 JAR as a compile-only dependency. Install `ui/clean-menu/build/libs/clean-menu-0.1.0.jar` alongside Mod Menu and restart Minecraft.

Manual check: title layout at different GUI scales, keyboard tab/enter navigation, all five actions, return from child screens, and panorama toggle/speed persistence after restarting. Live UI verification has not been performed by the agent.
