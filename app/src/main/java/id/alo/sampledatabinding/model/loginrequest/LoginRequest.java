package id.alo.sampledatabinding.model.loginrequest;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.google.gson.annotations.SerializedName;

import id.alo.sampledatabinding.BR;

public class LoginRequest extends BaseObservable {

	@SerializedName("password")
	public String password;

	@SerializedName("device_token")
	public String deviceToken;

	@SerializedName("version")
	public String version;

	@SerializedName("email")
	public String email;

	public void setPassword(String password){
		this.password = password;
		notifyPropertyChanged(BR.password);
	}

	@Bindable
	public String getPassword(){
		return password;
	}

	public void setDeviceToken(String deviceToken){
		this.deviceToken = deviceToken;
	}

	@Bindable
	public String getDeviceToken(){
		return deviceToken;
	}

	public void setVersion(String version){
		this.version = version;
	}

	@Bindable
	public String getVersion(){
		return version;
	}

	public void setEmail(String email){
		this.email = email;
        notifyPropertyChanged(BR.email);
	}

	@Bindable
	public String getEmail(){
		return email;
	}
}