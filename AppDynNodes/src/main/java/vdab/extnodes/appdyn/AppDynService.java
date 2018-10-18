/*LICENSE*
 * Copyright (C) 2013 - 2018 MJA Technology LLC 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/
package vdab.extnodes.appdyn;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import vdab.api.node.HTTPService_A;

import com.lcrc.af.AnalysisData;
import com.lcrc.af.AnalysisEvent;
import com.lcrc.af.constants.IconCategory;


public class AppDynService extends  HTTPService_A  {

	private String c_Host = "localhost";
	private Integer c_Port =  Integer.valueOf(8293);
	private String c_MetricGroup = "default";

	public AppDynService (){
		super();
	}
	// ATTRIBUTE Methods
	public String get_Host(){
		return c_Host;
	}
	public void set_Host(String host){
		c_Host = host;
	}
	public String get_MetricGroup(){
		return c_MetricGroup;
	}
	public void set_MetricGroup(String group){
		c_MetricGroup = group;
	}
	public Integer get_Port(){
		return c_Port;
	}
	public void set_Port( Integer port){
		c_Port = port;
	}
	public Integer get_IconCode(){
		return IconCategory.NODE_APPDYN;
	}
	public synchronized void processEvent(AnalysisEvent ev){
			super.processEvent(ev);
	}
	// SUPPORTING Methods --------------------------------------
	public String buildCompleteURL(AnalysisEvent ev){
		StringBuilder sb = new StringBuilder("http://");
		sb.append(get_Host()).append(":").append(get_Port());
		
		sb.append("/machineagent/metrics");
		AnalysisData ad = ev.getAnalysisData();
		AnalysisData ads[] = ad.getAllSimpleNumerics();
		if (ads.length > 0){
			
			sb.append("?name=");
			String encodedName = null;
			try {
		
				encodedName = "Custom Metrics|"+c_MetricGroup+"|"+ads[0].getLabel();
				encodedName = URLEncoder.encode(encodedName,"UTF-8");
			} catch (UnsupportedEncodingException e) {
					setError("Unable to encode Dynatrace name data e>"+e);
					return null;
			}
			sb.append(encodedName);
			sb.append("&value=");
			Integer val = ads[0].getDataAsInteger();
			sb.append(val);	
			sb.append("&type=average");
			return sb.toString();
		}
		return null;
	}

}
