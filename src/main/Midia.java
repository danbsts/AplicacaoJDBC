package main;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Blob;

public class Midia {
	private Blob blob;
	private String nome;
	public Midia(Blob blob, String nome) {
		this.blob = blob;
		this.nome = nome;
	}
	public void Create() {
		File file = new File("/../../"+nome);
		FileOutputStream fo = null;
		try {
			fo = new FileOutputStream(file);
			if (!file.exists()) {
				file.createNewFile();
			}
			
			byte[] content = blob.getBytes(1, 0);
			fo.write(content);
			fo.flush();
			fo.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (fo != null) {
					fo.close();
				}
			}catch(Exception e) {e.printStackTrace();}
		}
		
	}
}
