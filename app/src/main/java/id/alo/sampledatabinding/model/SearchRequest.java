package id.alo.sampledatabinding.model;

import com.google.gson.annotations.SerializedName;

public class SearchRequest{

	@SerializedName("keyword")
	private String keyword;

	@SerializedName("token")
	private String token;

	public void setKeyword(String keyword){
		this.keyword = keyword;
	}

	public String getKeyword(){
		return keyword;
	}

	public void setToken(String token){
		this.token = token;
	}

	public String getToken(){
		return token;
	}
}