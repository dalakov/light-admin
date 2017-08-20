package org.lightadmin.config;

import org.lightadmin.api.config.annotation.Administration;
import org.lightadmin.api.config.builder.EntityMetadataConfigurationUnitBuilder;
import org.lightadmin.api.config.builder.FieldSetConfigurationUnitBuilder;
import org.lightadmin.api.config.builder.ScreenContextConfigurationUnitBuilder;
import org.lightadmin.api.config.unit.EntityMetadataConfigurationUnit;
import org.lightadmin.api.config.unit.FieldSetConfigurationUnit;
import org.lightadmin.api.config.unit.ScreenContextConfigurationUnit;
import org.lightadmin.test.model.TestOrder;
import org.lightadmin.test.renderer.LineItemRenderer;

@SuppressWarnings("unused")
@Administration(TestOrder.class)
public class OrderTestEntityConfiguration {

    public static EntityMetadataConfigurationUnit configuration(EntityMetadataConfigurationUnitBuilder configurationBuilder) {
        return configurationBuilder.pluralName("Test Order Domain").build();
    }

    public static ScreenContextConfigurationUnit screenContext(ScreenContextConfigurationUnitBuilder screenContextBuilder) {
        return screenContextBuilder.screenName("Administration of Test Order Domain").build();
    }

    public static FieldSetConfigurationUnit listView(FieldSetConfigurationUnitBuilder listViewBuilder) {
        return listViewBuilder.field("id").caption("ID").field("name").caption("Name").field("customer").caption("Customer").field("shippingAddresses").caption("Shipping Addresses").renderable(new LineItemRenderer()).caption("Line Items").build();
    }
}