#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/*
 * Copyright 2017 xtecuan.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ${package}.jaxrs.api;

import ${package}.config.facade.utils.ConfigurationFacade;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 *
 * @author xtecuan
 */
@Stateless
@Path("/framework")
public class XApplicationRestService {
    @EJB
    private ConfigurationFacade configFacade;
    
    private boolean validateToken(String currentToken) {
        return configFacade.getApiToken().equals(currentToken);
    }

    private Response forbiddenResponseForPassCode(String passCode) {
        String message = "";
        if (passCode == null || passCode.equals("")) {
            message = "Forbidden 403: You need to provide a valid passCode";
        } else {
            message = "Forbidden 403: The passCode provided is invalid : " + passCode;
        }
        return Response.status(Response.Status.FORBIDDEN).entity(message).type("text/plain").build();
    }
    
    @GET
    @Path("/")
    @Produces({"application/json"})
    public Response root(){
        return Response.ok(configFacade.getApiMetadata()).build();
    }
}
