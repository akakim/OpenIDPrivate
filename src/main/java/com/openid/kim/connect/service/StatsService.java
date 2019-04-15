package com.openid.kim.connect.service;

import java.util.Map;

import com.openid.kim.connect.model.ClientStat;



public interface StatsService {

	/**
	 * 평균 통계를 계산한다. 
	 *     	approvalCount: total approved sites
	 *      userCount: unique users
	 *      clientCount: unique clients
	 *
	 * @return
	 */
	public Map<String, Integer> getSummaryStats();

	/**
	 * Calculate the usage count for a single client
	 *
	 * @param clientId the id of the client to search on
	 * @return
	 */
	public ClientStat getCountForClientId(String clientId);

	/**
	 *  Trigger the stats to be recalculated upon next update.
	 */
	public void resetCache();
}
