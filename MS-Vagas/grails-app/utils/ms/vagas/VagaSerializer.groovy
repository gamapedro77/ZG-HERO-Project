package ms.vagas

import com.fasterxml.jackson.databind.ObjectMapper
import ms.vagas.Vaga
import org.apache.kafka.common.serialization.Serializer

class VagaSerializer implements Serializer<Vaga>{

    @Override
    byte[] serialize(String topic, Vaga vaga) {
        return new ObjectMapper().writeValueAsBytes(vaga)

    }
}
