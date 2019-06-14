package com.dream.jpa;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import javax.persistence.Table;

@Entity
@Table( name = "atp_players")
@NamedQueries({
	
	@NamedQuery(
			name = Player.QUERY_ALL,
				query = "SELECT p FROM Player p"
			),
	@NamedQuery(
			name = Player.QUERY_ALL,
			query = "SELECT p FROM Player p"
		)
	
})


public class Player implements Serializable{

	public static final String QUERY_ALL = "Player.findAllUnordered";
	public static final String QEURY_ORERED_NAME="Player.findAllOrderedByName";
	
	@Column(name="idatp_player")
	private Integer id;
	
	@Column(name="player_name")
	private String playerName;

	@Column(name="player_score")
	private String playerScore;
	
	@Column(name="player_reg")
	private Date playerRegistration;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public String getPlayerScore() {
		return playerScore;
	}
	public void setPlayerScore(String playerScore) {
		this.playerScore = playerScore;
	}
	public Date getPlayerRegistration() {
		return playerRegistration;
	}
	public void setPlayerRegistration(Date playerRegistration) {
		this.playerRegistration = playerRegistration;
	}
	
	
	
}
