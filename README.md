# Practical

Practical is a simple Minecraft plugin that blocks attack particle packets.

In vanilla Minecraft, when a player gets hit, particles can appear on their screen. Practical blocks those packets to give players a cleaner PvP experience.

This works similarly to how **Esta land** does it.

## Features

- Blocks attack-related particles
- Blocks hit particles from showing on the player’s screen
- Lightweight and simple
- Works automatically after installation
- Good for PvP servers
- Maven-based project

## Installation

1. Build the plugin with Maven:

```bash
mvn clean package
````

2. Open the `target/` folder.
3. Put the generated `.jar` file into your server’s `plugins` folder.
4. Restart your server.

## Usage

Practical works automatically after being installed.

There are currently:

* No commands
* No config
* No permissions
* No API

## Note

This plugin is still in development, so expect issues and bugs.

If you find any, please report them on the GitHub repository.

## Todo

* Add commands
* Add `/practical reload`
* Add `/practical toggle`
* Add config support
* Add permissions
* Add more blocking options
* Add option to block exact particle types
* Add option to block critical particles
* Add option to block enchanted critical particles
* Add option to block sweep particles
* Add optional API if needed
* Add support for more Minecraft versions
* Improve packet filtering
* Add customizable messages

## Requirements

* Java 17+
* Maven
* Spigot, Paper, or another plugin-supported server software

## License

All rights reserved.

```
