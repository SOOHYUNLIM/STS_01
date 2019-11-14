package org.zerock.dto;

public class AttachDTO {

	private String fileName, uuid;
	private boolean image;

	public AttachDTO(String fileName, String uuid) {
		this(fileName, uuid, false);
	}

	public AttachDTO(String fileName, String uuid, boolean image) {
		super();
		this.fileName = fileName;
		this.uuid = uuid;
		this.image = image;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	public String getUuid() {
		return uuid;
	}

	public boolean isImage() {
		return image;
	}

	@Override
	public String toString() {
		return "AttachDTO [fileName=" + fileName + ", uuid=" + uuid + ", image=" + image + "]";
	}
	
}
