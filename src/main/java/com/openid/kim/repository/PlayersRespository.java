package com.openid.kim.repository;

import java.util.Collection;
import java.util.List;

import com.openid.kim.jpa.Player;

public interface PlayersRespository {

	public Player getById(Long id);
	
	public List<Player> getAllClients();
	
	public void deletePlayer(Player player);
	
	public Player updateClient(Long id,Player targetPlayer);
}
