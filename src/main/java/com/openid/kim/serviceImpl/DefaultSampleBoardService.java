package com.openid.kim.serviceImpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.openid.kim.dao.SampleDAO;
import com.openid.kim.service.SampleBoardService;

@Service("defaultSampleBoardService")
public class DefaultSampleBoardService implements SampleBoardService {

	Logger log = Logger.getLogger(this.getClass());

	@Resource(name="sampleDAO")
	private SampleDAO sampleDAO;
	
	@Override
	public List<Map<String, Object>> selectBoardList(Map<String,Object> coomandMap) {
		return sampleDAO.selectBoardList(coomandMap);
	
	}

}
