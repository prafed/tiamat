package no.rutebanken.tiamat.ifopt.dto.assembler;


import no.rutebanken.tiamat.ifopt.dto.dto.SimpleQuayDTO;
import org.springframework.stereotype.Component;
import uk.org.netex.netex.Quay;

@Component
public class SimpleQuayAssembler {

    public SimpleQuayDTO assemble(Quay quay) {
        SimpleQuayDTO simpleQuayDTO = new SimpleQuayDTO();

        simpleQuayDTO.id = quay.getId();
        if(quay.getName() != null) simpleQuayDTO.name = quay.getName().getValue();
        return simpleQuayDTO;
    }

}