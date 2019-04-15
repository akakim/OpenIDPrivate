package com.openid.kim.connect.service;

import com.dream.model.ClientDetailsEntity;
import com.openid.kim.connect.model.CachedImage;


public interface ClientLogoLoadingService {
	public CachedImage getLogo(ClientDetailsEntity client);
}
