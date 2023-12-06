# Hi there! Thank you for checking out Simple Hollow Logs!
<img align="right" width="120" src="src/main/resources/assets/axialeaa/simple-hollow-logs.png">

[![GitHub downloads](https://img.shields.io/github/downloads/axialeaa/SimpleHollowLogs/total?label=Github%20downloads&logo=github&style=for-the-badge)](https://github.com/axialeaa/SimpleHollowLogs/releases)
[![Modrinth downloads](https://img.shields.io/modrinth/dt/simple-hollow-logs?label=Modrinth%20downloads&logo=modrinth&style=for-the-badge)](https://modrinth.com/mod/simple-hollow-logs)

Simple Hollow Logs is a client and server-side [Fabric](https://fabricmc.net) mod which attempts to add the hollow logs from the Minecraft Live 2021 Birch Forest concept art! They generate naturally in some forest-like biomes across the overworld, and they can be crafted using 8 of their regular log counterparts. They also have a unique collision box, allowing you to crawl inside!

![](https://github.com/axialeaa/SimpleHollowLogs/assets/116074698/e9385a02-b429-45d7-88e7-7c9d2ead2bc0)
> A player crawling inside a hollow log.

Unlike normal logs, they can be filled with water. When this happens, they will hold it in on their 4 solid faces, but will let it spill out the holes.

Hollow logs may also be stripped using an axe.
***

### Getting Started
Due to the use of `FlammableBlockRegistry`, `FabricItemSettings`, `ItemGroupEvents`, `BiomeModifications` and `BiomeSelectors`, you will need to download [Fabric API](https://modrinth.com/mod/fabric-api) in order to use this mod. Once you have, simply drag both Fabric API and Simple Hollow Logs in your mods folder. If you're playing on a multiplayer server, you'll need to have these mods installed on both the server and client sides.
***

### Mod Compatibility
Currently, this mod features hollow log variants of every vanilla log type, some of which may generate naturally in overworld biomes. Logs and biome types from other mods may be supported in the future, but it's not on the roadmap.
