/*
 * Licensed under the EUPL, Version 1.2 or – as soon they will be approved by
 * the European Commission - subsequent versions of the EUPL (the "Licence");
 * You may not use this work except in compliance with the Licence.
 * You may obtain a copy of the Licence at:
 *
 *   https://joinup.ec.europa.eu/software/page/eupl
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the Licence is distributed on an "AS IS" basis,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Licence for the specific language governing permissions and
 * limitations under the Licence.
 */

/*
 * Licensed under the EUPL, Version 1.2 or – as soon they will be approved by
 * the European Commission - subsequent versions of the EUPL (the "Licence");
 * You may not use this work except in compliance with the Licence.
 * You may obtain a copy of the Licence at:
 *
 *   https://joinup.ec.europa.eu/software/page/eupl
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the Licence is distributed on an "AS IS" basis,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Licence for the specific language governing permissions and
 * limitations under the Licence.
 */

/*
 * Licensed under the EUPL, Version 1.2 or – as soon they will be approved by
 * the European Commission - subsequent versions of the EUPL (the "Licence");
 * You may not use this work except in compliance with the Licence.
 * You may obtain a copy of the Licence at:
 *
 *   https://joinup.ec.europa.eu/software/page/eupl
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the Licence is distributed on an "AS IS" basis,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Licence for the specific language governing permissions and
 * limitations under the Licence.
 */

package org.rutebanken.tiamat.rest.graphql.fetchers;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.rutebanken.tiamat.exporter.params.FareZoneSearch;
import org.rutebanken.tiamat.model.FareZone;
import org.rutebanken.tiamat.repository.FareZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.rutebanken.tiamat.rest.graphql.GraphQLNames.PAGE;
import static org.rutebanken.tiamat.rest.graphql.GraphQLNames.QUERY;
import static org.rutebanken.tiamat.rest.graphql.GraphQLNames.SIZE;

@Service("fareZonesFetcher")
@Transactional
public class FareZonesFetcher implements DataFetcher<Page<FareZone>> {

    @Autowired
    private FareZoneRepository fareZoneRepository;

    @Override
    @Transactional
    public Page<FareZone> get(DataFetchingEnvironment environment) {

        FareZoneSearch fareZoneSearch = FareZoneSearch.newFareZoneSearchBuilder()
                .query(environment.getArgument(QUERY))
                .build();

        List<FareZone> fareZones = fareZoneRepository.findFareZones(fareZoneSearch);
        return new PageImpl<>(fareZones, PageRequest.of(environment.getArgument(PAGE), environment.getArgument(SIZE)), fareZones.size());
    }
}
