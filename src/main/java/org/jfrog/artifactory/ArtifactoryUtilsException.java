package org.jfrog.artifactory;

import org.jfrog.artifactory.api.ADTConfig;

import java.util.HashMap;
import java.util.Map;

public class ArtifactoryUtilsException extends RuntimeException {	
	
	private static final long serialVersionUID = 557686856339703121L;
	
	private Map<Integer, String> errorMessage = new HashMap<Integer, String>();
	private int status;
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	public ArtifactoryUtilsException() {
		status = 0;
		errorMessage.put(0, "An ArtifactoryResourceWeb object can't be null. Please create one to make it works.");
	}

	public ArtifactoryUtilsException(final int pStatus, final ADTConfig pResource) {

		status = pStatus;
		errorMessage.put(401, "You did not have the rights to use it with this login : "+pResource.getLogin()+" and password :"+pResource.getPassword());
		errorMessage.put(403, "The following repository does not exist : "+pResource.getRepository_name());
		errorMessage.put(405, "Wrong artifactory home url : "+pResource.getServer_ip());

	}
	
	public ArtifactoryUtilsException(final int pStatus, final String pMessage) {
		super(pMessage);
		status = pStatus;
		errorMessage.put(404, pMessage);
	}
	
	
	@Override
	public String getMessage() {
		
		return errorMessage.get(status);
	} 

}
