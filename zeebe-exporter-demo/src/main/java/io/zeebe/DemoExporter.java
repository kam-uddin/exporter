package io.zeebe;

import io.camunda.zeebe.exporter.api.Exporter;
import io.camunda.zeebe.exporter.api.context.Context;
import io.camunda.zeebe.exporter.api.context.Controller;
import io.camunda.zeebe.protocol.record.Record;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DemoExporter implements Exporter {
    private static final Logger log = LoggerFactory.getLogger(DemoExporter.class);
    private Controller controller;

    @Override
    public void configure(Context context) {
    }

    @Override
    public void open(Controller controller) {
        log.info("Exporter Open");
        this.controller = controller;
    }

    @Override
    public void close() {
    }

    @Override
    public void export(Record record) {
        log.info("Hello from exporter");
        log.info("--- Zeebe record : {} ---", record.toString());
        this.controller.updateLastExportedRecordPosition(record.getPosition());
    }
}