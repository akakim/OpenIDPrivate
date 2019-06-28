package com.openid.kim.repository.impl;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kim.util.JpaUtil;
import com.openid.kim.jpa.Player;
import com.openid.kim.repository.PlayersRespository;

@Repository
@Transactional(value="defaultTransactionManager")
public class JpaPlayersRespository implements PlayersRespository {

	@PersistenceContext(unitName="defaultPersistenceDreamUnit")
	private EntityManager manager;
	
	public JpaPlayersRespository() {
		
	}
	
	public JpaPlayersRespository(EntityManager manager) {
		this.manager = manager;
		
	}
	
	@Override
	public Player getById(Long id) {
		return manager.find(Player.class, id);
	}

	@Override
	public List<Player> getAllClients() {
		
		TypedQuery<Player> q = manager.createNamedQuery(Player.QUERY_ALL,Player.class);
		return q.getResultList();
	}

	@Override
	public void deletePlayer(Player player) {
		// TODO Auto-generated method stub

	}

	@Override
	public Player updateClient(Long id, Player targetPlayer) {
		// TODO Auto-generated method stub
		return JpaUtil.saveOrUpdate(manager, targetPlayer);
	}

}
