# HuskChat-TestEvents

This is a Velocity/Bungee plugin that demonstrates the HuskChat events API.

## Building

To build the plugin, you will need to create a directory called `lib`, and place the HuskChat jar files for Bungee and Velocity in there.

You will most likely also need to update the `pom.xml` files in the `bungee` and `velocity` modules to use the correct file name in the `systemPath` property.

Use the Maven `package` function from the `HuskChatTestEvents` module to build the plugin. You will find the resulting plugins in the `target` directory. 