package id.alo.sampledatabinding.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class SearchResponse{

	@SerializedName("data")
	private List<SearchItem> data;

	@SerializedName("status")
	private String status;

	public void setData(List<SearchItem> data){
		this.data = data;
	}

	public List<SearchItem> getData(){
		return data;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}
}