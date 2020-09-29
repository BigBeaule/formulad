package com.bigb.vassal.formuled;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.FileUtils;

import com.bigb.vassal.formuled.configuration.Settings;
import com.bigb.vassal.formuled.element.ModuleBuild;
import com.bigb.vassal.formuled.element.ModuleData;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;

/**
 * 
 */
public class VassalBuilder {
	private static final boolean KEEP_XML = Boolean.getBoolean("bigb.formuled.keep.xml");

	public static void main(String[] args) throws Exception {
		XmlMapper xml = new XmlMapper();
		xml.enable(SerializationFeature.INDENT_OUTPUT);
		xml.enable(ToXmlGenerator.Feature.WRITE_XML_DECLARATION);

		JsonMapper json = new JsonMapper();
		Settings settings = json.readValue(new File("configuration.json"), Settings.class);

		File buildFile = new File("assets/buildFile");
		File moduleData = new File("assets/moduledata");

		try {
			try (FileWriter writer = new FileWriter(buildFile)) {
				xml.writeValue(writer, new ModuleBuild(settings));
			}

			try (FileWriter writer = new FileWriter(moduleData)) {
				xml.writeValue(writer, new ModuleData(settings));
			}

			if (KEEP_XML) {
				FileUtils.copyFile(buildFile, new File(buildFile.getName() + ".xml"));
				FileUtils.copyFile(moduleData, new File(moduleData.getName() + ".xml"));
			}

			try (FileOutputStream fos = new FileOutputStream("FormulaDe-" + settings.getModuleVersion() + ".vmod");
					ZipOutputStream zip = new ZipOutputStream(fos)) {

				File baseDir = new File("assets");
				URI baseUri = baseDir.toURI();
				for (File file : baseDir.listFiles()) {
					zipFile(zip, baseUri, file);
				}
			}
		} finally {
			FileUtils.deleteQuietly(buildFile);
			FileUtils.deleteQuietly(moduleData);
		}
	}

	private static void zipFile(ZipOutputStream zip, URI baseUri, File file) throws IOException {
		String entryName = baseUri.relativize(file.toURI()).getPath();

		if (file.isDirectory()) {
			for (File f : file.listFiles()) {
				zipFile(zip, baseUri, f);
			}

			return;
		}

		zip.putNextEntry(new ZipEntry(entryName));
		zip.write(FileUtils.readFileToByteArray(file));
		zip.closeEntry();
	}
}
