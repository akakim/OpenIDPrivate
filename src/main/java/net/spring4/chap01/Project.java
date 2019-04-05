package net.spring4.chap01;

import java.util.List;

public class Project {
	
	
	private BuildRunner buildRunner;
	private List<String> srcDirs;
	private String binDir;
	

	public List<String> getSrcDirs() {
		return srcDirs;
	}

	public void setSrcDirs(List<String> srcDirs) {
		this.srcDirs = srcDirs;
	}

	public String getBinDir() {
		return binDir;
	}

	public void setBinDir(String binDir) {
		this.binDir = binDir;
	}

	public BuildRunner getBuildRunner() {
		return buildRunner;
	}

	public void setBuildRunner(BuildRunner buildRunner) {
		this.buildRunner = buildRunner;
	}
	
	public void build() {
		buildRunner.build(srcDirs, binDir);
	}
}
