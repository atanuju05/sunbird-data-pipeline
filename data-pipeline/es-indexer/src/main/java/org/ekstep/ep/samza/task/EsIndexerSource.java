package org.ekstep.ep.samza.task;

import org.apache.samza.system.IncomingMessageEnvelope;
import org.ekstep.ep.samza.domain.Event;

import java.util.Map;

public class EsIndexerSource {

    private IncomingMessageEnvelope envelope;

    public EsIndexerSource(IncomingMessageEnvelope envelope) {
        this.envelope = envelope;
    }

    public Event getEvent() {
        return new Event((Map<String, Object>) envelope.getMessage());
    }
    
    public String getStreamName() {
    	return envelope.getSystemStreamPartition().getStream();
    }
}
