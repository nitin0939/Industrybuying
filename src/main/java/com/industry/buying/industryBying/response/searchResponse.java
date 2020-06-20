package com.industry.buying.industryBying.response;

public class searchResponse {
	long total_matches;
	truth truth;
	cube cube;
	google google;
	ibm ibm;
	
	public long getTotal_matches() {
		return total_matches;
	}
	public void setTotal_matches(long total_matches) {
		this.total_matches = total_matches;
	}
	public truth getTruth() {
		return truth;
	}
	public void setTruth(truth truth) {
		this.truth = truth;
	}
	public cube getCube() {
		return cube;
	}
	public void setCube(cube cube) {
		this.cube = cube;
	}
	public google getGoogle() {
		return google;
	}
	public void setGoogle(google google) {
		this.google = google;
	}
	public ibm getIbm() {
		return ibm;
	}
	public void setIbm(ibm ibm) {
		this.ibm = ibm;
	}
	
}
