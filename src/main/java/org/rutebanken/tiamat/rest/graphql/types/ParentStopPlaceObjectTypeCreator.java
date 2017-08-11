package org.rutebanken.tiamat.rest.graphql.types;

import graphql.schema.*;
import org.rutebanken.tiamat.model.SiteRefStructure;
import org.rutebanken.tiamat.model.StopPlace;
import org.rutebanken.tiamat.rest.graphql.scalars.TransportModeScalar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static graphql.Scalars.GraphQLString;
import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;
import static graphql.schema.GraphQLObjectType.newObject;
import static org.rutebanken.tiamat.rest.graphql.GraphQLNames.*;
import static org.rutebanken.tiamat.rest.graphql.types.CustomGraphQLTypes.interchangeWeightingEnum;
import static org.rutebanken.tiamat.rest.graphql.types.CustomGraphQLTypes.stopPlaceTypeEnum;

@Component
public class ParentStopPlaceObjectTypeCreator {

    @Autowired
    private DataFetcher stopPlaceFetcher;

    public GraphQLObjectType create(GraphQLInterfaceType stopPlaceInterface,
                                    List<GraphQLFieldDefinition> stopPlaceInterfaceFields,
                                    List<GraphQLFieldDefinition> commonFieldsList,
                                    GraphQLObjectType stopPlaceObjectType) {
        return newObject()
                .name("ParentStopPlace")
                .withInterface(stopPlaceInterface)
                .fields(stopPlaceInterfaceFields)
                .fields(commonFieldsList)
                .field(newFieldDefinition()
                        .name("children")
                        .type(stopPlaceObjectType)
                        .dataFetcher(stopPlaceFetcher))
                .build();
    }
}
