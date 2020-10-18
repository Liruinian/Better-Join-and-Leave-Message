package com.timlrn2016.broadcastonjoin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{
	/**
	 * ������������غ���ʾ��Ϣ
	 */
	@Override
	public void onEnable() {
		File file = new File(getDataFolder(), "config.yml");
		if (!getDataFolder().exists()) {
			getDataFolder().mkdir();
		}
		if (!file.exists()) {
			getServer().getConsoleSender().sendMessage("��6[����ȫ������]δ���������ļ�..�����½�һ�������ļ�");
			getServer().getConsoleSender().sendMessage("��6[Better Join and Leave Message]No config Found! We'll create a new one for you!");
			this.saveDefaultConfig();
		}
		this.reloadConfig();
		
		if(!(getConfig().getBoolean("Enable"))) {
			getServer().getConsoleSender().sendMessage("��4[����ȫ������] ��δ������������� �뽫�����ļ��е�Enable: false ��Ϊ true");
			getServer().getConsoleSender().sendMessage("��4[Better Join and Leave Message] You haven't turn this plugin on! Please edit the config, and change Enable: false to true");
			getServer().getPluginManager().disablePlugin(this);
		}else{
			getServer().getConsoleSender().sendMessage("��2[����ȫ������]�ɹ����ؽ���ȫ�������� Made By Tim_LRN2016");
			Bukkit.getPluginManager().registerEvents (new PlayerJoin_LeaveListener(), this);
		}
	}
	public void onDisable() {
		getServer().getConsoleSender().sendMessage("��4[����ȫ������]�ɹ�ж�ؽ���ȫ�������� Made By Tim_LRN2016");
	}
	public class PlayerJoin_LeaveListener implements Listener{
		@EventHandler
		public void onJoin(PlayerJoinEvent e) {
			//setJoinMessage to Null (or display two Messages)
			e.setJoinMessage(null);
			
			List <String> Opjoin = new ArrayList<String>();
			List <String> Playerjoin = new ArrayList<String>();
			
			Opjoin = getConfig().getStringList("Opjoin");
			Playerjoin = getConfig().getStringList("Playerjoin");
			
			if (e.getPlayer().isOp()) {
				for(int i = 0  ; i < Opjoin.size(); i++) {
					String Opjoinmessage = Opjoin.get(i).replace("&","��").replace("%player%", e.getPlayer().getDisplayName());
					Bukkit.broadcastMessage(Opjoinmessage);
				}
				return;
			}
			for(int i = 0  ; i < Playerjoin.size(); i++) {
				String Playerjoinmessage = Playerjoin.get(i).replace("&","��").replace("%player%", e.getPlayer().getDisplayName());
				Bukkit.broadcastMessage(Playerjoinmessage);
			}
			return;
		}
		@EventHandler
		public void onLeave(PlayerQuitEvent a) {
			//setQuitMessage to Null (or display two Messages)
			a.setQuitMessage(null);
			
			List <String> Opleave = new ArrayList<String>();
			List <String> Playerleave = new ArrayList<String>();
			
			Opleave = getConfig().getStringList("Opleave");
			Playerleave = getConfig().getStringList("Playerleave");
			
			if (a.getPlayer().isOp()) {
				for(int i = 0  ; i < Opleave.size(); i++) {
					String Opleavemessage = Opleave.get(i).replace("&","��").replace("%player%", a.getPlayer().getDisplayName());
					Bukkit.broadcastMessage(Opleavemessage);
				}
				return;
			}
			for(int i = 0  ; i < Playerleave.size(); i++) {
				String Playerleavemessage = Playerleave.get(i).replace("&","��").replace("%player%", a.getPlayer().getDisplayName());
				Bukkit.broadcastMessage(Playerleavemessage);
			}
				return;
		}
	}

}
