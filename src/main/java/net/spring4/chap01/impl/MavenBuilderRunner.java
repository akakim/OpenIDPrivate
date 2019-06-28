package net.spring4.chap01.impl;

import java.util.List;

import org.apache.log4j.Logger;



import net.spring4.chap01.BuildRunner;

public class MavenBuilderRunner implements BuildRunner{

	
	private static final Logger logger = Logger.getLogger(MavenBuilderRunner.class);
	
	
	private String mavenPath;
	
	@Override
	public void build(List<String> srcDirs, String binDir) {
		
		String info = "메이븐 경로 : " + mavenPath +" \n";
		
		
		final StringBuilder builder = new StringBuilder();
		srcDirs.forEach( item -> 		
		builder.append("소스 경로 : " + item + "\n"));

		info.concat( builder.toString());
		info += "클래스 파일 경로 : " + binDir + "\n";
		
		logger.info( info );
	}
	
	public void setMavenPath(String mavenPath) {
		this.mavenPath = mavenPath;
	}

}
