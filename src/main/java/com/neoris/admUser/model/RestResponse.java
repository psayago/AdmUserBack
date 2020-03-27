package com.neoris.admUser.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class RestResponse {
	private Integer responseCode;
	private String responseMessage;
	private Map<String, ? extends Object> data;
	private List<StatusInfo> serviceStatus;

	public Integer getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(Integer responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public Map<String, ? extends Object> getData() {
		return data;
	}

	public void setData(Map<String, ? extends Object> data) {
		this.data = data;
	}

	public List<StatusInfo> getServiceStatus() {
		return serviceStatus;
	}

	public void setServiceStatus(List<StatusInfo> serviceStatus) {
		this.serviceStatus = serviceStatus;
	}

	public boolean isOk() {
		return responseCode == 200;
	}

	public boolean hasError() {
		return responseCode >= 400;
	}

	// Codigos: 206 warning sin data, 208 warning con data
	public boolean hasWarning() {
		return responseCode > 200 && responseCode < 300;
	}

	public boolean serviceStatusContains(String codigo) {
		Optional<StatusInfo> matchingObject = serviceStatus.stream().filter(ss -> ss.getCodigo().equalsIgnoreCase(codigo)).findFirst();
		StatusInfo person = matchingObject.orElse(null);

		return person != null;
	}

	public List<String> getErrorsDescriptions() {
		List<String> errores = new ArrayList<>();

		for (StatusInfo status : serviceStatus)
			errores.add(status.getDescripcion());

		return errores;
	}
}
