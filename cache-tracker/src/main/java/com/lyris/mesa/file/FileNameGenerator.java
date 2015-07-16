package com.lyris.mesa.file;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Generate a unique file name, including the full path, for Unix read/write operations.
 * Subclasses in other layers dictate naming conventions for paths and files. This class appends
 * a UUID to the file name to ensure uniqueness. It also will create the directory specified in 
 * the path at file name generation time, if it does not exist.
 * 
 * @author rthummeti
 *
 */
public class FileNameGenerator {

	private String name;
	private String extension;
	private String path;
	private String uniqueName;

	public FileNameGenerator(String path) {
		super();
		this.path = path;
	}

	public FileNameGenerator(String path, String name, String extension) {
		super();
		this.path = path;
		this.name = name;
		setExtension(extension);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setExtension(String extension) {
		this.extension = (extension.startsWith(".")) ? extension : "." + extension;
	}

	public String getUniqueName() {
		return uniqueName;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String generate() throws IOException{

		//Check if there is directory, if not create it
		File dir = new File(this.path);
		if (!dir.exists())
			dir.mkdirs();

		String uuid = UUID.randomUUID().toString();
		//Add the last section of uuid
		uniqueName = getName() + uuid.substring(uuid.lastIndexOf("-")) + extension;

		return (path.endsWith("/")) ? path + uniqueName : path + "/" + uniqueName;
	}
}
