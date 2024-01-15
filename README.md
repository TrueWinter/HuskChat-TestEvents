# HuskChat-TestEvents

This is a Velocity/Bungee plugin that demonstrates the [HuskChat](https://github.com/WiIIiam278/HuskChat) events API.

## Building

To build the plugin, you will need to clone HuskChat in the parent directory and build it.

You will most likely also need to update the `pom.xml` files in the `common` module to use the correct file name in the `systemPath` property.

Use the Maven `package` function from the `HuskChatTestEvents` module to build the plugin. You will find the resulting plugins in the `target` directory. 