package templateMethod.oo;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


public class GeradorXMLCompactado extends GeradorArquivo {
	
	protected byte[] processar(byte[] bytes) throws IOException {
		ByteArrayOutputStream byteout = new ByteArrayOutputStream();
		ZipOutputStream out = new ZipOutputStream(byteout);
		out.putNextEntry(new ZipEntry("internal"));
		out.write(bytes);
		out.closeEntry();
		out.close();
		return byteout.toByteArray();
	}

	@Override
	protected String gerarConteudo(Map<String, Object> propriedades) {
		StringBuilder propFileBuilder = new StringBuilder();
		propFileBuilder.append("<properties>");
		for (String prop: propriedades.keySet()) {
			propFileBuilder.append("<"+prop+">"+propriedades.get(prop)+"</"+prop+">");
		}
		propFileBuilder.append("</propriedades>");
		return propFileBuilder.toString();
	}

}
