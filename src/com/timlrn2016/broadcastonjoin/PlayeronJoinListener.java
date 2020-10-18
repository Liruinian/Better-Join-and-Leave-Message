package com.timlrn2016.broadcastonjoin;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayeronJoinListener implements Listener{
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		if (e.getPlayer().isOp()) {
			e.setJoinMessage(null);
			Bukkit.broadcastMessage("§6§l§m §f§l§m                          §6§l§m ");
			Bukkit.broadcastMessage("  §7[§4管理员§7] §4" + e.getPlayer().getName()+" §e加入了游戏！");
			Bukkit.broadcastMessage("§6§l§m §f§l§m                          §6§l§m ");
			return;
		}
			e.setJoinMessage(null);
			Bukkit.broadcastMessage("§6§l§m §f§l§m                          §6§l§m ");
			Bukkit.broadcastMessage("  §7[§2玩家§7] §a" + e.getPlayer().getName()+" §e加入了游戏！");
			Bukkit.broadcastMessage("§6§l§m §f§l§m                          §6§l§m ");
			return;
	}
	@EventHandler
	public void onLeave(PlayerQuitEvent a) {
		if (a.getPlayer().isOp()) {
			a.setQuitMessage(null);
			Bukkit.broadcastMessage("§6§l§m §f§l§m                          §6§l§m ");
			Bukkit.broadcastMessage("  §7[§4管理员§7] §4" + a.getPlayer().getName()+" §e退出了游戏！");
			Bukkit.broadcastMessage("§6§l§m §f§l§m                          §6§l§m ");
			return;
		}
			a.setQuitMessage(null);
			Bukkit.broadcastMessage("§6§l§m §f§l§m                          §6§l§m ");
			Bukkit.broadcastMessage("  §7[§2玩家§7] §a" + a.getPlayer().getName()+" §e退出了游戏！");
			Bukkit.broadcastMessage("§6§l§m §f§l§m                          §6§l§m ");
			return;
	}
}
