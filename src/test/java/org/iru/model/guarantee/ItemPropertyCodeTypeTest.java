package org.iru.model.guarantee;

import javax.xml.namespace.QName;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;
import org.ow2.easywsdl.schema.api.Schema;
import org.ow2.easywsdl.schema.api.SchemaException;
import org.ow2.easywsdl.schema.api.SchemaReader;
import org.ow2.easywsdl.schema.api.SimpleType;
import org.ow2.easywsdl.schema.impl.SchemaReaderImpl;

public class ItemPropertyCodeTypeTest {
	@Test
	public void validateItemPropertyCodeTypeType() throws SchemaException, IOException, URISyntaxException {
		SchemaReader reader = new SchemaReaderImpl();
		Schema schema = reader.read(getClass().getClassLoader().getResource("iru-guarantee-1.xsd"));
		SimpleType type = (SimpleType) schema.getType(QName.valueOf("{http://www.iru.org/model/guarantee-1}ItemPropertyCodeTypeType"));
		type.getRestriction().getEnumerations().forEach(restriction -> ItemPropertyCodeType.fromValue(restriction.getValue()));

		Arrays.stream(ItemPropertyCodeType.values()).forEach(itemPropertyCodeType -> {
			Assert.assertTrue(type.getRestriction().getEnumerations().stream().anyMatch(restriction -> restriction.getValue().equals(itemPropertyCodeType.value())));
		});
	}
}