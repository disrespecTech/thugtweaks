# ThugTweaks

A Paper plugin which aims to restore a few vanilla aspects, such as global mob cap (for mob-switches when `per-player-mob-spawns` is `true`) and time of day synchronization across all dimensions (or worlds) when a player sleeps.

Plugin is named after the Thugcraft SMP server. Server is open to applications from anyone 18 years and older.

[![ThugCraft](https://discordapp.com/api/guilds/276649353383510016/widget.png?style=banner2)](https://discord.gg/FEwCtMx)

---

## Configuration

Config is located in `plugins/thug-tweaks/config.yml`. Default values are as follows:

```yml
version: 1
version-readme: Please don't update the version
spawning:
  enforce-global-mobcap: false
world:
  synchronize-day-time: false
```
